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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.makeMybill.dto.BillDTO;
import com.makeMybill.jdbc.DAO;
import com.makeMybill.jdbc.DBConstants;
import com.makeMybill.jdbc.Factory;
import com.makeMybill.jdbc.PreparedStatementDTO;
import com.makeMybill.jdbc.SQLConstants;

/**
 * Servlet implementation class LogInCheck
 */
@WebServlet("/logInCheck")
public class LogInCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInCheck() {
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
			response.setStatus(404);
			return;
		}
		System.out.println(sb.toString());
		
		 Gson gson = new Gson();
         Map<String,String> user1 = gson.fromJson(sb.toString(),Map.class);

	
	    
	    String email = (String) user1.get("id");
	    String password = (String) user1.get("password");
	    
	    if(email.isEmpty()||email==null){
	    	
	    	response.setStatus(404);
	    	out.print("* Enter user id");
	    	return;
	    }
       if(password.isEmpty()||password==null){
	    	
	    	response.setStatus(404);
	    	out.print("* Enter password");
	    	return;
	    }
	    BillDTO billDto = new BillDTO();
	    List<PreparedStatementDTO> pslist = new ArrayList<PreparedStatementDTO>();
	    DAO dao = Factory.getDAOObject();
	    PreparedStatementDTO ps = new PreparedStatementDTO();
	    try {
	    	ps.setDatatype(DBConstants.STRING);
	    	ps.setPosition(1);
	    	ps.setValue(email);
	    	pslist.add(ps);
	    	
	    	ps = new PreparedStatementDTO();
	    	ps.setDatatype(DBConstants.STRING);
	    	ps.setPosition(2);
	    	ps.setValue(password);
	    	pslist.add(ps);
	    	
			billDto = dao.checkLogin(SQLConstants.CHECK_LOGIN,pslist);
			
			if(billDto==null){
				
				out.println("* invalid user id or password.");
				response.setStatus(404);
				return;
			}else{
				HttpSession session = request.getSession(true);
				session.setAttribute("bill", billDto);
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}