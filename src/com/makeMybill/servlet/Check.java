package com.makeMybill.servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.makeMybill.dto.BillDTO;
import com.makeMybill.email.SendMail;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 * Servlet implementation class Check
 */
@WebServlet("/check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String[] portNames = SerialPortList.getPortNames();
	        for(int i = 0; i < portNames.length; i++){
	            System.out.println(portNames[i]);
	        }
	        
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
	        	

	        } 
	       catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
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
	       
		BillDTO billdata = new BillDTO();
		billdata.setBillTill('1300');
		billdata.setLastMonthPaid("March");
		billdata.setLastPaidAmount(400);
		billdata.setMeterId(144469);
		billdata.setTotalPaid(800);
		billdata.setTotalUnit(185.89);
		billdata.setUserId("akash.rathore1924@gmail.com");
		
		
		try {
			SendMail.sendEmail(billdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
