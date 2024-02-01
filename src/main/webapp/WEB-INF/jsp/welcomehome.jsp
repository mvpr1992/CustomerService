<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
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
		</table><br><br>
		<h2 style="color: #FFFFFF;">Personal Information</h2>
		<br><br>
		<table style="width:40%" align = "center">	
			<tr>
				<td><strong>First Name :</strong></td>
				<td><%=session.getAttribute("firstName")%></td>
			</tr>
			<tr>
				<td><strong>Last Name  :</strong></td>
				<td><%=session.getAttribute("lastName")%></td>
			</tr>
			<tr>
				<td><strong>Customer Id :</strong></td>
				<td><%=session.getAttribute("customerId")%></td>
			</tr>
			<tr>
				<td><strong>User ID :</strong></td>
				<td><%=session.getAttribute("userId")%></td>
			</tr>
			<tr>
				<td><strong>Mobile :</strong></td>
				<td><%=session.getAttribute("mobile")%></td>
			</tr>
			<tr>
				<td><strong>eMail ID :</strong></td>
				<td><%=session.getAttribute("email")%></td>
			</tr>
			<tr>
				<td><strong>Mailing Address :</strong></td>
				<td><%=session.getAttribute("mailingAddress")%></td>
			</tr>
			<tr>
				<td><strong>Zip Code :</strong></td>
				<td><%=session.getAttribute("zipCode")%></td>
			</tr>
			<tr>
				<td><strong>City :</strong></td>
				<td><%=session.getAttribute("city")%></td>
			</tr>
			<tr>
				<td><strong>Country</strong></td>
				<td><%=session.getAttribute("country")%></td>
			</tr>
			</table>
    	</section>
	</main>
	</body>
</html>