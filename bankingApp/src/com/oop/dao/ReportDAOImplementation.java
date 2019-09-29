package com.oop.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Report;
import com.oop.util.DBUtil;

public class ReportDAOImplementation implements ReportDAO {
	
	private Connection conn;
	
	public ReportDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addReport(Report report) {
	    
		try {
			String query = "insert into report(month,totalAmount,transactionCount,userCount) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, report.getMonth() );
			preparedStatement.setString( 2, report.getTotalAmount() );
			preparedStatement.setInt( 3, report.getTransactionCount() );
			preparedStatement.setInt( 4, report.getUserCount() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReport(int reportId) {
		try {
			String query = "delete from report where reportId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, reportId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateReport(Report report) {
		try {
			String query = "update report set month=?, totalAmount=?, transactionCount=?, userCount=? where reportId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, report.getMonth() );
			preparedStatement.setString( 2, report.getTotalAmount() );
			preparedStatement.setInt( 3, report.getTransactionCount() );
			preparedStatement.setInt( 4, report.getUserCount() );
			preparedStatement.setInt(5, report.getReportId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Report> getAllReports() {
		List<Report> reports = new ArrayList<Report>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from report" );
			while(resultSet.next()) {
				Report report = new Report();
				report.setReportId(resultSet.getInt("reportId"));
				report.setMonth(resultSet.getString("month"));
				report.setTotalAmount(resultSet.getString("totalAmount"));
				report.setTransactionCount(resultSet.getInt("transactionCount"));
				report.setUserCount(resultSet.getInt("userCount"));
				reports.add(report);
			}
			resultSet.close();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return reports;
}

	@Override
	public Report getReportById(int reportId) {
		Report report = new Report();
		try {
			
			String query = "select * from report where reportId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, reportId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				report.setReportId(resultSet.getInt("reportId"));
				report.setMonth(resultSet.getString("month"));
				report.setTotalAmount(resultSet.getString("totalAmount"));
				report.setTransactionCount(resultSet.getInt("transactionCount"));
				report.setUserCount(resultSet.getInt("userCount"));
			}
			resultSet.close();
			preparedStatement.close();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return report;
	}

}
