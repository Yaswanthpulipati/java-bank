package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dao.CustomerDao;

/**
 * Servlet implementation class WithDrawServlet
 */
public class WithDrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithDrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao c=new CustomerDao();
		String acc_no=request.getParameter("acc_no");
		double amount=Double.parseDouble(request.getParameter("amount"));
		if(c.withDrawl(amount, acc_no)) {
			c.AddTransaction(acc_no, -1*amount);
			response.sendRedirect("withdrawl_success.jsp");
		}else {
			response.setContentType("text/html");
			PrintWriter p=response.getWriter();
			p.print("<h1> failed </h1>");
		}
	}

}
