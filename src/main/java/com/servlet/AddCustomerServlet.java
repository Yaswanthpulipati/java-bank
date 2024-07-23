package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.AdminDao;
import com.entity.Customer;

/**
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("acc_no");
		String s2=request.getParameter("password");
		String s3=request.getParameter("full_name");
		String s4=request.getParameter("address");
		String s5=request.getParameter("mobile");
		String s6=request.getParameter("email");
		String s7=request.getParameter("acc_type");
		double s8=Double.parseDouble(request.getParameter("balance"));
		String s9=request.getParameter("dob");
		String s10=request.getParameter("idProof");
		
		Customer c=new Customer(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
		AdminDao a=new AdminDao();
		
		if(a.registerCustomer(c)) {
			HttpSession ss=request.getSession();
			ss.setAttribute("regCust", "Registered Successfully ");
			response.sendRedirect("registerCustomer.jsp");
		}
		else {
			HttpSession ss=request.getSession();
			ss.setAttribute("regCust", "Registeration Failed ");
			response.sendRedirect("registerCustomer.jsp");
		}
		
	}

}
