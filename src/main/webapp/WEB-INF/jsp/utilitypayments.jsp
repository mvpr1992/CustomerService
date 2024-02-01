<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Routing Numbers</title>
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
		</table><br><br><br>
    	<h2 style="color: #FFFFFF;">Bill Payment</h2>
  		<form action="/billpayment" method="post">
  			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
  			<table style="width:40%" align = "center">
  				<tr>
  					<td style="color: #FFFFFF;"><strong>Your Account Balance:</strong></td>
					<td style="color: #FFFFFF;">${transaction.accountBalance}</td>
				<tr>
  				<tr>
  					<td><label for="routingnumber" style="color: #FFFFFF;">Utility Name:</label></td>
  					<td><select name="routingnumber" id="routingnumber" style="color: #000000;">
  						<c:forEach items="${utilitylist}" var="app">
  							<option value="${app.routingnumber}"><c:out value="${app.utilityname}"/></option>	
    					</c:forEach>
					</select></td>
  				</tr>
  				<tr>
  					<td><label for="amount" style="color: #FFFFFF;">Amount:</label></td>
  					<td><input type="text" id="amount" name="amount"></td>
  				</tr>
  				<tr>
  					<td><label for="scheduledate" style="color: #FFFFFF;">Schedule Date:</label></td>
  					<td><input type="date" id="scheduledate" name="scheduledate" required></td>
  				</tr>
  			</table>
  			<br/><br/>
  			<input type="submit"/>
  		</form>
  		<br><br>
  		<h2 style="color: #FFFFFF;">Pay Credit Card Bill</h2>
  		<form action="/creditcardbillpayment" method="post">
  			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
  			<input type="hidden" id="email" name="email" value=<%=session.getAttribute("email")%>>
  			<table style="width:40%" align = "center">
  				<tr>
  					<td><label for="amount" style="color: #FFFFFF;">Amount:</label></td>
  					<td><input type="text" id="amount" name="amount"></td>
  				</tr>
  			</table>
  			<br/><br/>
  			<input type="submit"/>
  		</form>
    	<br><br>
		<h2 style="color: #FFFFFF;">Add Routing Numbers</h2>
			<form action="/addroutingnumbers" method="post">
			<table style="width:60%" align = "center">
			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
				<tr>
  	  				<td><label for="utilityname" style="color: #FFFFFF;">Utility Name:</label></td>
  	  				<td><input type="text" id="utilityname" name="utilityname"></td>
  	  			</tr>
				<tr>
  	  				<td><label for="routingnumber" style="color: #FFFFFF;">Routing Number:</label></td>
  	  				<td><input type="text" id="routingnumber" name="routingnumber"></td>
  	  			</tr>
  	  			</table>
  	  			<br>
  	  			<div class="text-center">
  					<input type="submit" value="Submit"/> 
  				</div>    
    		</form>
    	</section>
	</main>
	</body>
</html>