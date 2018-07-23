<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Transfer</title>
<link href="<c:url value="/resources/project.css" />" rel="stylesheet"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>

.info {
	height: 40px;
	margin-top:100px;
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

#transfertab {
background-color: #734d26;
}



</style>
<body>

	<div class="container">
		<div class="header">
			<div id="leftHeader"><div><label> Name: ${name} </label></div>
				<div><label> Email Id: ${email} </label></div>
				<div><label> Phone Number:${phoneNumber} </label></div>
			</div>
			<div id="centerHeader">HN Bank</div>
			<div id="rightHeader"><a data-method="delete" href ="logout">Logout</a></div>
		</div>
		<div class ="homeBar">
	    <a href = "summary">Summary</a>
	    <a href = "activities">Activities</a>
	    <a id="transfertab" href ="transfer.jsp">Transfer</a>
	    <a href ="updateInfo.jsp">Update Information</a>
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
			<h1 style = "margin-bottom: 0.25em; margin-top: 0.25em">Transfer Amount</h1>
			<p>Please fill in the details to transfer money.</p>
			<hr>
		<form action="transaction" method ="post">
			
			<label for="accountNumber "><b>Account Number</b></label> 
			<input type="text" placeholder="Enter sender Account Number" name="accountNumber" required> 
			<label for="amount"><b>Amount</b></label> 
			<input type="text" placeholder="Enter Amount" name="amount"> 
			

			<button type="submit">Submit</button>
			</form>

		</div>
		<div class="footer"></div>
		</div>
		
</body>
</html>