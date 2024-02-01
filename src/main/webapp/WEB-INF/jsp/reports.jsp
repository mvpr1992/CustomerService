<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>reports</title>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/home.css">
<style type="text/css">
form:label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

table td{
  color:#FFFFFF;
}

input {
	width: 200px;
}

input[type="submit"] {
      	background-color: #4CAF50;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }

section {
	padding: 15px;
} 

.hero-table {
	border-collapse: collapse;
	width: 40%;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<div class="navbar">
			<a href="/welcomehome">Home</a>
			<a href="/updatepersonalinfo">Update Personal Info</a>
			<a href="/managepayees/<%=session.getAttribute("customerId")%>">Manage Payees & Transactions</a>
			<a href="/utilitypayments/<%=session.getAttribute("customerId")%>">Utility Payments</a>
			<a href="/reports">Reports</a>
			<a href="/creditcard/<%=session.getAttribute("customerId")%>">Credit Card</a>
		</div>
	</header>
	<br>
	<main>
		<section class="hero">
		<table style="width:30%" align = "right">
  			<tr>
    			<td><h4 align = "right" style="color: #FFFFFF;">Welcome <%=session.getAttribute("firstName")%>!</h4></td>
    			<td>
    				<form action="/logout" method="get">
   						<input type="submit" value="Logout" >
					</form>
				</td>
  			</tr>
		</table>
		<br><br><br><br>
		<form action="/userdatareport" method="get">
  			<input type="hidden" id="userId" name="userId" value="<%=session.getAttribute("userId")%>">
        	<h2 style="color: #FFFFFF;">Download Your Personal Information</h2> 
        	<br>
        	<input type="submit" value="Download Report" />
    	</form>
    	<br><br>
    	<form action="/transactionstatementreport" method="get">
  			<input type="hidden" id="customerId" name="customerId" value="<%=session.getAttribute("customerId")%>">
        	<h2 style="color: #FFFFFF;">Download Your Transaction Statement</h2>
        	<label for="fromdate" style="color: #FFFFFF;">From Date:</label>
  			<input type="date" id="fromdate" name="fromdate" required>
  			<label for="todate" style="color: #FFFFFF;">To Date:</label>
  			<input type="date" id="todate" name="todate" required>
        	<br><br>
        	<input type="submit" value="Download Report"/>
    	</form>
    	<br><br>
    	<form action="/creditcardstatementreport" method="get">
  			<input type="hidden" id="customerId" name="customerId" value="<%=session.getAttribute("customerId")%>">
        	<h2 style="color: #FFFFFF;">Download Your Credit Card Statement</h2>
        	<label for="fromdate" style="color: #FFFFFF;">From Date:</label>
  			<input type="date" id="fromdate" name="fromdate" required>
  			<label for="todate" style="color: #FFFFFF;">To Date:</label>
  			<input type="date" id="todate" name="todate" required>
        	<br><br>
        	<input type="submit" value="Download Report"/>
    	</form>
    	</section>
	</main>
  </body>
</html>