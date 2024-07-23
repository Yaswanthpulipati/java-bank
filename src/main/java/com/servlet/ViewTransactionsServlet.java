package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileOutputStream;
import java.io.IOException;

import com.dao.CustomerDao;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ViewTransactionsServlet
 */
public class ViewTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTransactionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao c=new CustomerDao();
		double[] d=c.getTransactions(request.getParameter("acc_no"));
		try {
		Document doc=new Document();
		PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Yashwanth\\OneDrive\\Desktop\\transactions.pdf"));
		PdfPTable t=new PdfPTable(3);
		
		doc.open();
		PdfPCell ce=new PdfPCell(new Phrase("S.no"));
		ce.setBackgroundColor(BaseColor.LIGHT_GRAY);
		ce.setBorderWidth(1.2f);
		ce.setBorderColor(BaseColor.DARK_GRAY);
		t.addCell(ce);
		
		ce=new PdfPCell(new Phrase("Transaction type"));
		ce.setBackgroundColor(BaseColor.LIGHT_GRAY);
		ce.setBorderWidth(1.2f);
		ce.setBorderColor(BaseColor.DARK_GRAY);
		t.addCell(ce);
		
		ce=new PdfPCell(new Phrase("amount (in rs.)"));
		ce.setBackgroundColor(BaseColor.LIGHT_GRAY);
		ce.setBorderWidth(1.2f);
		ce.setBorderColor(BaseColor.DARK_GRAY);
		t.addCell(ce);
		int s_no=1;
		
		for(int i=0;i<10;i++) {
			if(d[i]!=0) {
				t.addCell(""+(s_no++));
				if(d[i]>0) {
					t.addCell("Deposit");
					t.addCell(""+d[i]);
				}else {
					t.addCell("Withdraw");
					t.addCell(""+(d[i]*-1));
				}
			}
		}
		doc.add(t);
		doc.close();
		
		if(d!=null) {
			HttpSession ss=request.getSession();
			ss.setAttribute("transactions", d);
			response.sendRedirect("view_transactions.jsp");
		}
		}catch(Exception e) {
			System.out.println("d is null");
			e.printStackTrace();
		}
	}

}
