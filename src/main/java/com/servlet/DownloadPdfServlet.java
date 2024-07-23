package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Servlet implementation class DownloadPdfServlet
 */
public class DownloadPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadPdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
        String filePath = "C:\\Users\\Yashwanth\\OneDrive\\Desktop\\transactions.pdf";
        File file = new File(filePath);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.setContentLength((int) file.length());

        
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream responseOutputStream = response.getOutputStream();

        // Write file to response
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            responseOutputStream.write(buffer, 0, bytesRead);
        }

        fileInputStream.close();
        responseOutputStream.close();
    }


	

}
