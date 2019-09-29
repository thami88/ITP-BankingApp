<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Report</title>
<style>
body {
  background-color: lightblue;
}
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 10px;
  width:auto;

}


</style>
</head>
<body>
  
   <h1 align="center">Add New Report</h1><hr/>

    <!-- ReportController.do -->
	<form action="ReportController" method="post">
		<fieldset>
			<div>
				<label for="reportId">Report ID</label> <input type="text"
					name="reportId" value="<c:out value="${report.reportId}" />"
					readonly="readonly" placeholder="Report ID" />
			</div>
			<div>
				<label for="month">Month</label> <input type="text"
					name="month" value="<c:out value="${report.month}" />"
					placeholder="Month" />
			</div>
			<div>
				<label for="totalAmount">Total Amount</label> <input type="text"
					name="totalAmount" value="<c:out value="${report.totalAmount}" />"
					placeholder="Total Amount" />
			</div>
			<div>
				<label for="transactionCount">Transaction Count</label> <input type="text" name="course"
					value="<c:out value="${report.transactionCount}" />" placeholder="transaction Count" />
			</div>
			<div>
				<label for="userCount">User Count</label> <input type="text" name="year"
					value="<c:out value="${report.userCount}" />" placeholder="User Count" />
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>

</body>
</html>