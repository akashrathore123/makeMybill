package com.makeMybill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.makeMybill.dto.BillDTO;
import com.makeMybill.jdbc.DAO;
import com.makeMybill.jdbc.DBConstants;
import com.makeMybill.jdbc.Factory;
import com.makeMybill.jdbc.PreparedStatementDTO;
import com.makeMybill.jdbc.SQLConstants;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * Servlet implementation class DataFetch
 */
@WebServlet("/dataFetch")
public class DataFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 SerialPort serialPort = new SerialPort("COM4");
	        try{
	            //Open port
	            serialPort.openPort();
	            //We expose the settings. You can also use this line - serialPort.setParams(9600, 8, 1, 0);
	            serialPort.setParams(SerialPort.BAUDRATE_9600, 
	                                 SerialPort.DATABITS_8,
	                                 SerialPort.STOPBITS_1,
	                                 SerialPort.PARITY_NONE);
	            //Writes data to port

              Thread.sleep(1600);
	           
              byte x ='x';
	            serialPort.writeByte(x);
	             Thread.sleep(50);
	            
	             String unit = serialPort.readString();
	        	double unit1 = Double.parseDouble(unit);
	      
	           float unit2 = (float)unit1;
	       
	           HttpSession session = request.getSession(false);
	           BillDTO bill = new BillDTO();
	           bill = (BillDTO) session.getAttribute("bill");
	         
	           bill.setTotalUnit(unit1);
	         
	           String billTill = String.valueOf(unit1*7);
	          bill.setBillTill(billTill);
	          bill.setUnbilledAmount(String.valueOf((unit1*7)-Double.parseDouble(bill.getTotalPaid())));
             
	          DAO dao = Factory.getDAOObject();
              
	          List<PreparedStatementDTO> psList = new ArrayList<PreparedStatementDTO>();
              PreparedStatementDTO ps = new PreparedStatementDTO();
              ps.setPosition(1);
              ps.setDatatype(DBConstants.FLOAT);
              ps.setValue(unit2);
              psList.add(ps);
              
               ps = new PreparedStatementDTO();
              ps.setDatatype(DBConstants.STRING);
              ps.setPosition(2);
              ps.setValue(billTill);
              psList.add(ps);
              
               ps = new PreparedStatementDTO();
              ps.setDatatype(DBConstants.INTEGER);
              ps.setPosition(3);
              ps.setValue(bill.getMeterId());
              psList.add(ps);
              
             
              
              dao.cud(SQLConstants.ADD_DATA,psList);
              
              String unbilled = bill.getUnbilledAmount().substring(0, 5);
              bill.setUnbilledAmount(unbilled);
              Gson gson = new Gson();
              out.println(gson.toJson(bill));
	        } 
	       catch (SerialPortException e) {
				// TODO Auto-generated catch block
	    	   
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally{
	        	try {
					serialPort.closePort();
				} catch (SerialPortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	       
	}

}