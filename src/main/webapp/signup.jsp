<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup Page</title>
</head>
<style>
.container {
	width: 800px;
	border:10px solid #734d26;
	margin-right: auto;
	margin-left: auto;
}

.header {
	height: 80px;
	background-color: #734d26;
}

.header h1 {
	margin-top: 0em;
	margin-bottom: 0em;
	text-align: center;
	color: white;
	font-size: 3em;
}

.header p {
	text-align: center;
	color: white;
	margin-top: 0em;
	margin-bottom: 0em;
}

.info {
	height: 40px;
	margin-top:60px;
	margin-bottom:0px;
	margin-left: 200px;
	margin-right: 200px;

}

#error {
	color:red;
}

#msg {
	color:green;
}
.main {

	margin-bottom: 100px;
	margin-left: 200px;
	margin-right: 200px;
	border: 1px solid black;
	background-color:  #e6ccb3;
	margin-left: 200px;
	color: black;
}
input {
    width: 360px;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background-color : white;
}
button {
    background-color:  #734d26;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 390px;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

.footer {
	height: 20px;
	background-color: #734d26;
	
}

</style>
<body>

	<div class="container">
		<div class="header">
			<h1>HN Bank</h1>
			<p>Welcome to HN Bank Login Page</p>
		</div>
		<div class="info">
			<div id="error">
				<c:if test="${error != null}">
				${error}
				</c:if>
			</div>
			<div id="msg">
				<c:if test="${message != null}">
				${message}
				</c:if>
			</div>
		</div>
		
		<div class="main">
			<h1 style = "margin-bottom: 0.25em; margin-top: 0.25em">Sign Up</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<form action="registration" method="post">
			<label for="firstName"><b>First Name</b></label> 
			<input type="text" placeholder="Enter First Name" name="firstName" required> 
			<label for="lastName"><b>Last Name</b></label> 
			<input type="text" placeholder="Enter last Name" name="lastName"> 
			<label for="email"><b>Email</b></label> 
			<input type="text" placeholder="Enter Email" name="email" required> 
			<label for="password"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="password" required>
			<label for="phoneNumber"><b>Phone Number</b></label> 
			<input type="text" placeholder="Enter Contact Number" name="phoneNumber" required> 

			<button type="submit">Sign Up</button>
</form>
		</div>
		<div class="footer"></div>
		</div>
		
</body>
</html>