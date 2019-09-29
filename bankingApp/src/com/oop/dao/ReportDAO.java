package com.oop.dao;

import java.util.List;

import com.oop.model.Report;

public interface ReportDAO {
	
	public void addReport(Report report);
	public void deleteReport(int reportId);
	public void updateReport(Report report);
	public List<Report> getAllReports();
	public Report getReportById(int reportId);

}
