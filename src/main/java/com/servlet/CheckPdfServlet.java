package com.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
//import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class CheckPdfServlet
 */
public class CheckPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckPdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Document d=new Document();
			PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\gumpa\\Desktop\\try.pdf"));
			d.open();
//			d.add(new Paragraph(request.getParameter("para")));
			PdfPTable t=new PdfPTable(3);
			PdfPCell c1=new PdfPCell(new Phrase("S.no"));
			c1.setBorderWidth(1.2f);
			c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			c1.setBorderColor(BaseColor.WHITE);
			t.addCell(c1);

			c1=new PdfPCell(new Phrase("Transaction type"));
			c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			c1.setBorderColor(BaseColor.WHITE);
			c1.setBorderWidth(1.2f);
			t.addCell(c1);
			
			c1=new PdfPCell(new Phrase("Amount"));
			c1.setBorderWidth(1.2f);
			c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			c1.setBorderColor(BaseColor.WHITE);
			t.addCell(c1);
			
			t.addCell("1");
			t.addCell("deposit");
			t.addCell("2348");
			d.add(t);
			d.close();
			System.out.print("file created");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
