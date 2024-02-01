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
	<c:set var="firstName" value="${user.firstName}" scope="session" />
	<c:set var="lastName" value="${user.lastName}" scope="session" />
	<c:set var="customerId" value="${user.customerId}" scope="session" />
	<c:set var="userId" value="${user.userId}" scope="session" />
	<c:set var="password" value="${user.password}" scope="session" />
	<c:set var="mobile" value="${user.mobile}" scope="session" />
	<c:set var="email" value="${user.email}" scope="session" />
	<c:set var="mailingAddress" value="${user.mailingAddress}" scope="session" />
	<c:set var="zipCode" value="${user.zipCode}" scope="session" />
	<c:set var="city" value="${user.city}" scope="session" />
	<c:set var="country" value="${user.country}" scope="session" />
	<c:set var="managerId" value="${user.managerId}" scope="session" />
	<c:set var="creditcardstatus" value="${creditcard.status}" scope="session" />
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
				<td>${user.firstName}</td>
			</tr>
			<tr>
				<td><strong>Last Name  :</strong></td>
				<td>${user.lastName}</td>
			</tr>
			<tr>
				<td><strong>Customer Id :</strong></td>
				<td>${user.customerId}</td>
			</tr>
			<tr>
				<td><strong>User ID :</strong></td>
				<td>${user.userId}</td>
			</tr>
			<tr>
				<td><strong>Mobile :</strong></td>
				<td>${user.mobile}</td>
			</tr>
			<tr>
				<td><strong>eMail ID :</strong></td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td><strong>Mailing Address :</strong></td>
				<td>${user.mailingAddress}</td>
			</tr>
			<tr>
				<td><strong>Zip Code :</strong></td>
				<td>${user.zipCode}</td>
			</tr>
			<tr>
				<td><strong>City :</strong></td>
				<td>${user.city}</td>
			</tr>
			<tr>
				<td><strong>Country</strong></td>
				<td>${user.country}</td>
			</tr>
			</table>
    	</section>
	</main>
	</body>
</html>