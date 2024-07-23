package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.CustomerDao;

/**
 * Servlet implementation class CustomerHomeServelet
 */
public class CustomerHomeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerHomeServelet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao c=new CustomerDao();
		if(c.login(request.getParameter("acc_no"), request.getParameter("password"))) {
			
			System.out.println("Customer login success");
			
			HttpSession ss=request.getSession();
			ss.setAttribute("cHome", c.getCustomer(request.getParameter("acc_no")));
			System.out.println(c.getCustomer(request.getParameter("acc_no")).getFullName());
			response.sendRedirect("customer_home.jsp");
			
		}else {
			response.setContentType("text/html");
			PrintWriter p=response.getWriter();
			p.print("<h1>failed - <a href=\"javascript:history.back()\">back</a></h1> ");
			System.out.println("Customer login failed");
		}
	}

}
