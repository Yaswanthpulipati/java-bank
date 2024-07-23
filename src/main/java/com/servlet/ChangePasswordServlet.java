package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//import java.io.PrintWriter;

import com.dao.CustomerDao;

/**
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao c=new CustomerDao();
		String no=request.getParameter("acc_no");
		String o=request.getParameter("old");
		String n=request.getParameter("new");
		
		if(c.changePassword(no,o, n)) {
			HttpSession ss=request.getSession();
			ss.setAttribute("change_password", "Changed Successfully");
			response.sendRedirect("change_password.jsp");
		}else {
			HttpSession ss=request.getSession();
			ss.setAttribute("change_password", "Failed to change");
			response.sendRedirect("change_password.jsp");
		}
	}

}
