package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.CustomerDao;
import com.entity.Customer;

/**
 * Servlet implementation class ChangeCustomerDetails
 */
public class ChangeCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCustomerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao cd=new CustomerDao();
		Customer c=new Customer();
		
		c.setAccNumber((String) request.getParameter("acc_no"));
		c.setFullName((String) request.getParameter("full_name"));
		c.setAddress((String) request.getParameter("address"));
		c.setEmail((String) request.getParameter("email"));
		c.setMobileNumber((String) request.getParameter("mobile"));
		c.setDob((String) request.getParameter("dob"));
		c.setPassword((String) request.getParameter("password"));
		
		
		if(cd.updateCustomer(c,c.getAccNumber())) {
			HttpSession ss=request.getSession();
			ss.setAttribute("changeDetails", "Updated Successfully");
			response.sendRedirect("changeDetailsByCustomer.jsp");
		}else {
			HttpSession ss=request.getSession();
			ss.setAttribute("changeDetails", "Failed to update");
			response.sendRedirect("changeDetailsByCustomer.jsp");
		}
		
	}

}
