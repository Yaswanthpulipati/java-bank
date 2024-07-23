package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.AdminDao;

/**
 * Servlet implementation class DeletCustomerServlet
 */
public class DeletCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acc= request.getParameter("acc_no");
		String name=request.getParameter("full_name");
		
		AdminDao a=new AdminDao();
		if(a.deleteCustomer(acc, name)) {
			HttpSession ss=request.getSession();
			ss.setAttribute("delCust", "Deleted Successfully");
			response.sendRedirect("deleteCustomer.jsp");
		}
		else {
			HttpSession ss=request.getSession();
			ss.setAttribute("delCust", "Deletion Failed");
			response.sendRedirect("deleteCustomer.jsp");
		}
	}

}
