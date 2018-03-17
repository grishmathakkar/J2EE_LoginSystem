<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="css/style.css">
  
  <style type="text/css">
<!--
.style2 {font-size: 250%}
-->
  </style>
</head>
<body>
<H1 class="login style2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Secure Login System</H1>

  <form method="post" action="<%=request.getContextPath() %>/Controller" method="post" class="login">
    <p class="forgot-password"><%=request.getAttribute("message") %></p>
    <input type="hidden" name="action" value="dologin" />
    <p>
      <label for="login">Email:</label>
      <input type="text" name="email" id="login" value="<%=request.getAttribute("email") %>">
    </p>

    <p>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" >
    </p>

    
	<br /><br />
	<p>
      <label for="password"></label>
     <img src="<%=request.getContextPath() %>/stickyImg" />
    </p>
	<br />
	<p>
      <label for="password">Enter Text:</label>
      <input type="text" name="answer" id="password" >
    </p>
    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>
    <p class="forgot-password"><a href="<%=request.getContextPath() %>/Controller?action=fpassword">Forgot your password?</a></p>
	 <p class="forgot-password">Don't have a Login? <a href="<%=request.getContextPath() %>/Controller?action=signup">SIGN-UP</a></p>
  </form>

</body>
</html>