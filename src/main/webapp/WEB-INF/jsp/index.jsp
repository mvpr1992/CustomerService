<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>My Homepage</title>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/home.css">
<style type="text/css">
body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
      }
      form {
      	style="color: #FFFFFF";
        max-width: 400px;
        margin: 0 auto;
        padding: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 5px #ccc;
      }
      label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
      }
      input[type="text"],
      input[type="email"],
      input[type="password"] {
        display: block;
        width: 95%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }
      input[type="submit"] {
      	background-color: #4CAF50;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      input[type="submit"]:hover {
        background-color: #0062cc;
      }
    </style>
</head>
<body>
	<header>
		<div class="navbar">
			<a href="/">Home</a>
			<a href="/managerlogin">Manager Login</a>
			<a href="/adminlogin">Admin Login</a>
			<a href="/signup">SignUp</a>
			<a href="/about">About</a>
		</div>
	</header>
	<main>
		<section class="hero">
			<h1 style="color: #FFFFFF;">Welcome to the Bank of USA!!</h1>
			<div class="text-center">
			<form action="/loginuser" method="post">
    			<H1 ALIGN="CENTER" style="color: #FFFFFF;">Personal Login</H1>
    			<h4 style="color: #FFFFFF;"><b>Username</b></h3>
      			<input type="text" id="userId" name="userId" required>
      			<h4 style="color: #FFFFFF;"><b>Password</b></h3>
      			<input type="password" id="password" name="password" required>
  				<div class="text-center">
  					<input type="submit" name="submit" value="Login"> <br><br>
  					<a href="/signup" style="color: #FFFFFF;">New Customer</a> <br><br>
				</div>
    		</form>
    		</div>
		</section>
	</main>
</body>
</html>
