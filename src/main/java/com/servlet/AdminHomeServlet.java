package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.AdminDao;

/**
 * Servlet implementation class AdminHomeServlet
 */
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao c=new AdminDao();
		if(c.login(request.getParameter("admin_id"), request.getParameter("password"))) {
			
			System.out.println("Admin login success");
			HttpSession s=request.getSession();
			s.setAttribute("aHome", c.getAdmin(request.getParameter("admin_id")));
			response.sendRedirect("admin_home.jsp");
			
//			request.getRequestDispatcher("/admin_home.jsp").include(request, response);
		}else {
			response.setContentType("text/html");
			PrintWriter p=response.getWriter();
			p.print("<h1>failed - <a href=\"javascript:history.back()\">back</a></h1> ");
			System.out.println("Customer login failed");
		}
	}

}
