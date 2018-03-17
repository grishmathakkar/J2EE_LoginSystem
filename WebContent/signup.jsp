<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Sign-Up</title>
<link rel="stylesheet" href="css/style.css">
  
  <style type="text/css">
<!--
.style2 {font-size: 250%}
-->
  </style>
</head>
<body>
<h1 class="login style2">New user Registration</h1>

  <form method="post" action="<%=request.getContextPath() %>/Controller" method="post" class="login">
    <p class="forgot-password"><%=request.getAttribute("message") %></p>
    <input type="hidden" name="action" value="doregister" />
    <p>
      <label for="login">Name:</label>
      <input type="text" name="name" id="login" value="<%=request.getAttribute("name") %>">
    </p>
    <p>
      <label for="login">Email:</label>
      <input type="text" name="email" id="login" value="<%=request.getAttribute("email") %>">
    </p>

    <p>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" >
    </p>
	<br />
    <p>
      <label for="login">Re-Password:</label>
      <input type="password" name="repassword" id="repassword" >
    </p>
	<br /><br />
	<p>
      
     <img src="<%=request.getContextPath() %>/stickyImg" />
    </p>
	<br />
	<p>
      <label for="password">Enter Text:</label>
      <input type="text" name="answer" id="repassword" >
    </p>
    <p class="login-submit">
      <button type="submit" class="login-button">Register</button>
    </p>
    </form>
</body>
</html>