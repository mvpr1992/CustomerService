<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>managercreditcard</title>
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
			<a href="/welcomemanagerhome">Home</a>
			<a href="/managerreports">Reports</a>
			<a href="/managercreditcard/<%=session.getAttribute("managerId")%>">Credit Cards</a>
			<a href="/managerscheduledpayments">Scheduled Payments</a>
		</div>
	</header>
	<br>
	<main>
		<section class="hero">
		<table style="width:30%" align = "right">
  			<tr>
    			<td><h4 align = "right" style="color: #FFFFFF;">Welcome <%=session.getAttribute("managerName")%>!</h4></td>		
    			<td>
    				<form action="/logout" method="get">
   						<input type="submit" value="Logout">
					</form>
				</td>
  			</tr>
		</table>
		<br><br><br><br>
		<h2 style="color: #FFFFFF;">Credit Card Applications</h2>
		<table style="width:80%" align = "center">
  				<tr><td>Application Id</td>
  					<td>Customer Id</td>
  				    <td>Max Limit</td></tr>
  				<c:forEach items="${creditapplications}" var="app">
  					<tr><td><c:out value="${app.applicationId}"/></td>
        				<td><c:out value="${app.customerId}"/></td>
  						<form action="/approvecreditcard" method="post">
  						<td>
  							<input type="hidden" id="applicationId" name="applicationId" value="${app.applicationId}">
  							<input type="hidden" id="customerId" name="customerId" value="${app.customerId}">
  							<input type="hidden" id="managerId" name="managerId" value="${app.managerId}">
  							<input type="text" id="max_limit" name="max_limit">
  						</td>
  						<td><input type="submit" value="Approve"/></td>
  						</form>
  					</tr>
    			</c:forEach>
  			</table>
    	</section>
	</main>
	</body>
</html>