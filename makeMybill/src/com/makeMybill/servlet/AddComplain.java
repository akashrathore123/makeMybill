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
import com.makeMybill.jdbc.DAO;
import com.makeMybill.jdbc.DBConstants;
import com.makeMybill.jdbc.Factory;
import com.makeMybill.jdbc.PreparedStatementDTO;
import com.makeMybill.jdbc.SQLConstants;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class AddComplain
 */
@WebServlet("/addComplain")
public class AddComplain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplain() {
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

		StringBuffer sb = new StringBuffer();
		try{
			BufferedReader reader = request.getReader();
			String line = null;
			while((line=reader.readLine())!= null){
				
				sb.append(line);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			response.setStatus(500);
			return;
		}
		
		if(sb.toString().isEmpty()){
			
			out.println("* Please fill the fields.");
			return;
		}
		 Gson gson = new Gson();
         Map<String,String> user1 = gson.fromJson(sb.toString(),Map.class);

	
         if(user1.size() < 4){
 	    	
 	    	response.setStatus(404);
 	    	out.println("* All fields are required.");
 	    	return;
 	    }
	    int meterID =  Integer.parseInt(user1.get("meterID").trim());
	    String problem = (String) user1.get("problem").trim();
	    String address = (String) user1.get("address").trim();
	    String contact = (String) user1.get("contact").trim();
	    if(contact.length()<10 ||contact.length()>10 || !contact.matches("[0-9]+")){
	    	response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	    	out.println("* Incorrect mobile number.");
	    	return;
	    	
	    }
	   
	   DAO dao = Factory.getDAOObject();
	   List<PreparedStatementDTO> psList = new ArrayList<PreparedStatementDTO>();
	   PreparedStatementDTO ps = new PreparedStatementDTO();
	   ps.setPosition(1);
	   ps.setDatatype(DBConstants.INTEGER);
	   ps.setValue(meterID);
	   psList.add(ps);
	   int exist = 0;
	   try {
		exist =  dao.checkUser(SQLConstants.CHECK_USER,psList);
       
		if(exist==0){
			response.setStatus(404);
			out.println("* Meter ID not Found.");
			return;
		}
		
		ps = new PreparedStatementDTO();
		ps.setDatatype(DBConstants.STRING);
		ps.setPosition(2);
		ps.setValue(problem);
		psList.add(ps);
		
		ps = new PreparedStatementDTO();
		ps.setDatatype(DBConstants.STRING);
		ps.setPosition(3);
		ps.setValue(contact);
		psList.add(ps);
		
		ps = new PreparedStatementDTO();
		ps.setDatatype(DBConstants.STRING);
		ps.setPosition(4);
		ps.setValue(address);
		psList.add(ps);
		
		dao.cud(SQLConstants.ADD_COMPLAIN, psList);
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		out.println("Complain registered successfully,complain is in flow.");
		return;
	   } catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
