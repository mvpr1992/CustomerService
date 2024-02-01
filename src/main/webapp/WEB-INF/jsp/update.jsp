<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Update</title>
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
		</table><br><br>
		<h2 style="color: #FFFFFF;">Personal Information</h2>
		<br><br>
			<form action="/updateuserinfo" method="post">
			<table style="width:60%" align = "center">
				<tr>	
  	  				<td><input type="hidden" id="customerId" name="customerId" value = <%=session.getAttribute("customerId")%>></td>
  	  				<td><input type="hidden" id="firstName" name="firstName" value = <%=session.getAttribute("firstName")%>></td>
  	  				<td><input type="hidden" id="lastName" name="lastName" value = <%=session.getAttribute("lastName")%>></td>
  	  				<td><input type="hidden" id="userId" name="userId" value = <%=session.getAttribute("userId")%>></td>
  	  				<td><input type="hidden" id="password" name="password" value = <%=session.getAttribute("password")%>></td>
  	  				<td><input type="hidden" id="managerId" name="managerId" value = <%=session.getAttribute("managerId")%>></td>
  	  			</tr>
				<tr>
  	  				<td><label for="mobile" style="color: #FFFFFF;">Mobile Number:</label></td>
  	  				<td><input type="text" id="mobile" name="mobile" value = <%=session.getAttribute("mobile")%>></td>
  	  			</tr>
  	  			<tr>
  	  				<td><label for="email" style="color: #FFFFFF;">eMail Id:</label></td>
  	  				<td><input type="email" id="email" name="email" value = <%=session.getAttribute("email")%>></td>
  	  			</tr>
  	  			<tr>
  	  				<td><label for="mailingAddress" style="color: #FFFFFF;">Mailing Address:</label></td>
  	  				<td><input type="text" id="mailingAddress" name="mailingAddress" value = <%=session.getAttribute("mailingAddress")%>></td>
  	  			</tr>
  	  			<tr>
  	  				<td><label for="zipCode" style="color: #FFFFFF;">Zip Code:</label></td>
  	  				<td><input type="text" id="zipCode" name="zipCode" value = <%=session.getAttribute("zipCode")%>></td>
  	  			</tr>
  	  			<tr>
  	  				<td><label for="city" style="color: #FFFFFF;">City:</label></td>
  	  				<td><input type="text" id="city" name="city" value = <%=session.getAttribute("city")%>></td>
  	  			</tr>
  	  			<tr>
  	  				<td><label for="country" style="color: #FFFFFF;">Country:</label></td>
  	  				<td><input type="text" id="country" name="country" value = <%=session.getAttribute("country")%>></td>
  	  			<tr>
  	  			</table>
  	  			<br>
  	  			<div class="text-center">
  					<input type="submit" value="Update"/> 
  				</div>    
    		</form>
    	</section>
	</main>
	</body>
</html>