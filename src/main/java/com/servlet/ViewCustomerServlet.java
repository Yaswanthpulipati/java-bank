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
 * Servlet implementation class ViewCustomerServlet
 */
public class ViewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao a=new AdminDao();
		HttpSession s=request.getSession();
		
		s.setAttribute("viewOne",a.getCustomer(request.getParameter("acc_no")));
		System.out.println("name="+a.getCustomer(request.getParameter("acc_no")).getFullName());
		response.sendRedirect("viewCustomer.jsp");
	}

}
