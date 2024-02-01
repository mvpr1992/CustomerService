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
			<a href="/welcomeadmin">Home</a>
			<a href="/updatemanager">Update Manager</a>
			<a href="/adminreports">Reports</a>
		</div>
	</header>
	<br>
	<main>
		<section class="hero">
		<table style="width:30%" align = "right">
  			<tr>		
    			<td>
    				<form action="/logout" method="get">
   						<input type="submit" value="Logout" >
					</form>
				</td>
  			</tr>
		</table>
		<br><br><br><br>
		<h2 style="color: #FFFFFF;">Customers Pending with Approval</h2>
		<br><br>
		<table style="width:80%" align = "center">
  				<tr><td>FirstName</td>
  					<td>Last Name</td>
  				    <td>User Name</td>
  					<td>Mobile</td>
  					<td>eMail</td>
  					<td>Zip Code</td>
  					<td>City</td>
  					<td>Manager</td></tr>
  				<c:forEach items="${pendingusersignups}" var="user">
  					<tr><td><c:out value="${user.firstName}"/></td>
        				<td><c:out value="${user.lastName}"/></td>
        				<td><c:out value="${user.userId}"/></td>
        				<td><c:out value="${user.mobile}"/></td>
        				<td><c:out value="${user.email}"/></td>
        				<td><c:out value="${user.zipCode}"/></td>
        				<td><c:out value="${user.city}"/></td>
  						<form action="/approveuser" method="post">
  						<td>
  							<input type="hidden" id=customerId name="customerId" value="${user.customerId}">
  							<input type="hidden" id="firstName" name="firstName" value="${user.firstName}">
  							<input type="hidden" id="lastName" name="lastName" value="${user.lastName}">
  							<input type="hidden" id="userId" name="userId" value="${user.userId}">
  							<input type="hidden" id="password" name="password" value="${user.password}">
  							<input type="hidden" id="mobile" name="mobile" value="${user.mobile}">
  							<input type="hidden" id="email" name="email" value="${user.email}">
  							<input type="hidden" id="mailingAddress" name="mailingAddress" value="${user.mailingAddress}">
  							<input type="hidden" id="zipCode" name="zipCode" value="${user.zipCode}">
  							<input type="hidden" id="city" name="city" value="${user.city}">
  							<input type="hidden" id="country" name="country" value="${user.country}">
  							<select name="managerId" id="managerId" style="color: #000000;">
  								<c:forEach items="${managerlist}" var="manager">
  									<option value="${manager.managerId}"><c:out value="${manager.name}"/></option>	
    							</c:forEach>
							</select></td>
  							<td><input type="submit" value="Approve"/></td>
  						</form>
  					</tr>
    			</c:forEach>
  			</table>
		</section>
	</main>
	</body>
</html>