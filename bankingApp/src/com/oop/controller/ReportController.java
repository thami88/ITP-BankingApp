package com.oop.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.dao.ReportDAO;
import com.oop.dao.ReportDAOImplementation;
import com.oop.model.Report;


public class ReportController extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
     private ReportDAO dao;     
     public static final String list_REPORT = "/listReport.jsp";
     public static final String INSERT_OR_EDIT = "/report.jsp";

     
    public ReportController() {
       
        dao = new ReportDAOImplementation(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = list_REPORT;
			int reportId = Integer.parseInt( request.getParameter("reportId") );
			dao.deleteReport(reportId);
			request.setAttribute("reports", dao.getAllReports() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int reportId = Integer.parseInt( request.getParameter("reportId") );
			Report report = dao.getReportById(reportId);
			request.setAttribute("report", report);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = list_REPORT;
			request.setAttribute("report", dao.getAllReports() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Report report = new Report();
		report.setMonth(request.getParameter("month"));
		report.setTotalAmount(request.getParameter("totalAmount"));
		report.setTransactionCount(Integer.parseInt(request.getParameter("transactionCount")));
		report.setUserCount(Integer.parseInt(request.getParameter("userCount")));
		String reportId = request.getParameter("reportId");
		
		if (reportId == null || reportId.isEmpty())
			dao.addReport(report);
		else {
			report.setReportId(Integer.parseInt(reportId));
			dao.updateReport(report);
		 }
		RequestDispatcher view = request.getRequestDispatcher(list_REPORT);
		request.setAttribute("reports", dao.getAllReports());
		view.forward(request, response);
	}

}
