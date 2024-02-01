<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
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
        max-width: 700px;
        margin: 0 auto;
        padding: 20px;
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
	<br><br> <br><br>
    <form action="/usersignup" method="post">
      <h2 ALIGN="CENTER">Sign Up</h2>
      <label for="firstName" >First Name:</label>
  	  <input type="text" id="firstName" name="firstName" required>
  	  <label for="lastName">Last Name:</label>
  	  <input type="text" id="lastName" name="lastName" required>
      <label for="username">Username</label>
      <input type="text" id="username" name="userId" required>
      <label for="password">Password</label>
      <input type="password" id="password" name="password" required>
  	  <label for="mobile">Mobile Number:</label>
  	  <input type="text" id="mobile" name="mobile" required>
  	  <label for="email">eMail Id:</label>
  	  <input type="email" id="email" name="email" required>
  	  <label for="mailingAddress">Mailing Address:</label>
  	  <input type="text" id="mailingAddress" name="mailingAddress" required>
  	  <label for="zipCode">Zip Code:</label>
  	  <input type="text" id="zipCode" name="zipCode" required>
  	  <label for="city">City:</label>
  	  <input type="text" id="city" name="city" required>
  	  <label for="country">Country:</label>
  	  <input type="text" id="country" name="country" required>  
  	  <div class="text-center">
  			<input type="submit" value="Register"/>
	  </div>
    </form>
  </body>
</html>