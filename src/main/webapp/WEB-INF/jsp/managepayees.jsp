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
		</table><br><br><br>
		<h3 style="color: #FFFFFF;" align = "center">Your Account Balance: ${transaction.accountBalance}</h3>
		<form action="/transactuser" method="post">
  			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
  			<input type="hidden" id="email" name="email" value=<%=session.getAttribute("email")%>>
  			<table style="width:40%" align = "center"> 				
  				<tr>
  					<td><label for="transactiontype" style="color: #FFFFFF;">Transaction Type:</label></td>
  					<td><select name="transactiontype" id="transactiontype">
  						<option value="DR" style="color: #000000;">ATM Withdrawl</option>
  						<option value="CR" style="color: #000000;">Cheque Deposit</option>
						</select>
  					</td>
  				</tr>
  				<tr>
  					<td><label for="amount" style="color: #FFFFFF;">Amount:</label></td>
  					<td><input type="text" id="amount" name="amount"></td>
  				</tr>
  			</table>
  			<br>
  			<input type="submit"/>
  		</form>
    	<br/>
		<h2 style="color: #FFFFFF;" align = "center">Add Payee</h2>
		<form action="/addpayee" method="post">
  			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
   			<table style="width:40%" align = "center">
  				<tr>
  					<td><label for="payeeId" style="color: #FFFFFF;">Add Payee:</label></td>
  					<td><select name="payeeId" id="payeeId" style="color: #000000;">
  						<c:forEach items="${addpayeelist}" var="app">
  							<option value="${app.customerId}"><c:out value="${app.firstName}"/></option>	
    					</c:forEach>
					</select></td>
  				</tr>
  			</table>
  			<input type="submit"/>
  		</form>
  		<br/><br/>
  		<h2 style="color: #FFFFFF;" align = "center">Transfer to Payee</h2>
  		<form action="/transfertopayee" method="post">
  			<input type="hidden" id="customerId" name="customerId" value=<%=session.getAttribute("customerId")%>>
  			<table style="width:40%" align = "center">
  				<tr>
  					<td><label for="payeeId" style="color: #FFFFFF;">Payee:</label></td>
  					<td><select name="payeeId" id="payeeId" style="color: #000000;">
  						<c:forEach items="${managedpayeelist}" var="app">
  							<option value="${app.customerId}"><c:out value="${app.firstName}"/></option>	
    					</c:forEach>
					</select></td>
  				</tr>
  				<tr>
  					<td><label for="amount" style="color: #FFFFFF;">Amount:</label></td>
  					<td><input type="text" id="amount" name="amount"></td>
  				</tr>
  			</table>
  			<br/><br/>
  			<input type="submit"/>
  		</form>
    	</section>
	</main>
	</body>
</html>