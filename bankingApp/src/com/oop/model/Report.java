package com.oop.model;

public class Report {
	
	private int reportId;
	private String month;
	private String totalAmount;
	private int transactionCount;
	private int userCount;
	
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getTransactionCount() {
		return transactionCount;
	}
	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", month=" + month + ", totalAmount=" + totalAmount
				+ ", transactionCount=" + transactionCount + ", userCount=" + userCount + "]";
	}
	
	
	
}
