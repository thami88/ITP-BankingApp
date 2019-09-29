<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Page</title>
<style>
body {
  background-color: lightblue;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}

a:link, a:visited {
  background-color: green;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: black;
  color: white;
}

</style>
</head>
<body>
<h1 align="center">Manage Reports</h1><hr/>

<h3>All Reports</h3>
	<table>
		<thead>
			<tr>
				<th>Report ID</th>
				<th>Month</th>
				<th>Total Amount</th>
				<th>Transaction Count</th>
				<th>User Count</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reports}" var="report">
				<tr>
					<td><c:out value="${report.reportId}" /></td>
					<td><c:out value="${report.month}" /></td>
					<td><c:out value="${report.totalAmount}" /></td>
					<td><c:out value="${report.transactionCount}" /></td>
					<td><c:out value="${report.userCount}" /></td>
					<td><a
						href="ReportController?action=edit&reportId=<c:out value="${report.reportId }"/>">Update</a></td>
					<td><a
						href="ReportController?action=delete&reportId=<c:out value="${report.reportId }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
	   <!-- ReportController.do -->
		<a href="ReportController?action=insert">Add Report</a>
	</p>

</body>
</html>