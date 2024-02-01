<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>creditcard</title>
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
		<table style="width:50%" align = "center">
  			<tr>
    			<td style="color: #FFFFFF;">Your Last Application Status:    <%=session.getAttribute("creditcardstatus")%></td>
  			</tr>
  			<tr>
  				 <td style="color: #FFFFFF;"><strong>Your Available Limit:    ${cctran.availablelimit}</strong></td>
			<tr>
		</table>
		<form action="/applyforcreditcard" method="post">
  			<input type="hidden" id="customerId" name="customerId" value="<%=session.getAttribute("customerId")%>">
  			<input type="hidden" id="managerId" name="managerId" value="<%=session.getAttribute("managerId")%>">
        	<h3 style="color: #FFFFFF;">Apply for Credit Card</h2> 
        	<br>
        	<input type="submit" value="Apply" />
    	</form>
    	<br>
    	<h3 style="color: #FFFFFF;">Credit Card Purchase</h2>
    	<form action="/creditcardtransaction" method="post">
  			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
  			<br/><br/>
  			<table style="width:40%" align = "center">
  				<tr>
  					<td><label for="description" style="color: #FFFFFF;">Description:</label></td>
  					<td style="color: #000000;"><input type="text" id="description" name="description"></td>
  				</tr>
  				<tr>
  					<td><label for="amount" style="color: #FFFFFF;">Amount:</label></td>
  					<td style="color: #000000;"><input type="text" id="amount" name="amount"></td>
  				</tr>
  				<tr>
  				 	<td style="color: #FF0000;" align = "center"><strong> ${cctran.message}</strong></td>
				<tr>
  			</table>
  			<br/>
  			<input type="submit"/>
  		</form>
    	</section>
	</main>
  </body>
</html>