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

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/addContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
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
		System.out.println("here");
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
		System.out.println(sb.toString());
		if(sb.toString().isEmpty()){
			response.setStatus(404);
			out.println("* Please fill the fields.");
			return;
		}
		 Gson gson = new Gson();
         Map<String,String> user1 = gson.fromJson(sb.toString(),Map.class);

	
         if(user1.size() < 3){
 	    	
 	    	response.setStatus(404);
 	    	out.println("* All fields are required.");
 	    	return;
 	    }
         DAO dao =Factory.getDAOObject();
         List<PreparedStatementDTO> psList = new ArrayList<PreparedStatementDTO>();
         PreparedStatementDTO ps = new PreparedStatementDTO();
         ps.setDatatype(DBConstants.STRING);
         ps.setPosition(1);
         ps.setValue(user1.get("name"));
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setDatatype(DBConstants.STRING);
         ps.setPosition(2);
         ps.setValue(user1.get("email"));
         psList.add(ps);
         
         ps = new PreparedStatementDTO();
         ps.setDatatype(DBConstants.STRING);
         ps.setPosition(3);
         ps.setValue(user1.get("message"));
         psList.add(ps);
         try {
			dao.cud(SQLConstants.ADD_CONTACT,psList);
			out.println("Your record is added.We will contact you soon.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}

}
