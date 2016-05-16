package com.makeMybill.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.makeMybill.dto.BillDTO;
import com.makeMybill.jdbc.DAO;
import com.makeMybill.jdbc.DBConstants;
import com.makeMybill.jdbc.Factory;
import com.makeMybill.jdbc.PreparedStatementDTO;
import com.makeMybill.jdbc.SQLConstants;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		try{
			BufferedReader reader = request.getReader();
			String line = null;
			while((line=reader.readLine())!= null){
				
				sb.append(line);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			response.setStatus(404);
			return;
		}
		System.out.println(sb.toString());
		
		 Gson gson = new Gson();
         Map<String,String> user1 = gson.fromJson(sb.toString(),Map.class);
         if(user1 == null){
        	 
        	 out.println("* All Fields are required.");
        	 return;
         }

	System.out.println(user1);
         BillDTO user = new BillDTO();
         user.setUserId(user1.get("username"));
         user.setPassword(user1.get("password"));
         user.setMeterId(Integer.parseInt(user1.get("meterId")));
         user.setBillTill(user1.get("billTill"));
         user.setLastMonthPaid(user1.get("lastMonthPaid"));
         user.setLastPaidAmount(user1.get("lastPaidAmount"));
         user.setTotalPaid(user1.get("totalPaid"));
         user.setTotalUnit(Double.parseDouble(user1.get("currReading")));
         List<PreparedStatementDTO> psList = new ArrayList<PreparedStatementDTO>();
         PreparedStatementDTO ps = new PreparedStatementDTO();
         
         ps.setDatatype(DBConstants.STRING);
         ps.setPosition(1);
         ps.setValue(user.getUserId());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(2);
         ps.setDatatype(DBConstants.STRING);
         ps.setValue(user.getPassword());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(3);
         ps.setDatatype(DBConstants.INTEGER);
         ps.setValue(user.getMeterId());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(4);
         ps.setDatatype(DBConstants.STRING);
         ps.setValue(user.getLastMonthPaid());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(5);
         ps.setDatatype(DBConstants.STRING);
         ps.setValue(user.getBillTill());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(6);
         ps.setDatatype(DBConstants.STRING);
         ps.setValue(user.getLastPaidAmount());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(7);
         ps.setDatatype(DBConstants.STRING);
         ps.setValue(user.getTotalPaid());
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setPosition(8);
         ps.setDatatype(DBConstants.FLOAT);
         ps.setValue(Float.parseFloat(user1.get("currReading")));
         psList.add(ps);
         DAO dao = Factory.getDAOObject();
         try {
			dao.insertUser(SQLConstants.ADD_USER,psList);
			out.println("* User Added Successfully.");
					return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("* Internal Server Error.");
			response.setStatus(404);
			return;
		}
	    
	  
	  
	    
	}

}
