package com.makeMybill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.makeMybill.dto.BillDTO;
import com.makeMybill.email.SendMail;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/sendMail")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
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
		HttpSession session = request.getSession(false);
		BillDTO bill = new BillDTO();
		bill = (BillDTO) session.getAttribute("bill");
		SendMail mail = new SendMail();
		try {
			mail.sendEmail(bill);
			out.print("* Bill has been sent to your email account.");
			return;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("* Mail can not be sent now.");
			return;
		}
	}

}
