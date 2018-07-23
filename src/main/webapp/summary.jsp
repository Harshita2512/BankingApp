<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Summary</title>
<link href="<c:url value="/resources/project.css" />" rel="stylesheet"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<style>

.info {
	height: 40px;
	margin-top:60px;
	margin-bottom:0px;
	margin-left: 100px;
	margin-right: 100px;

}

#error {
	color:red;
}
#msg {
	color:green;
}
.main {
	margin-bottom: 150px;
	margin-left: 100px;
	margin-right: 100px;
	border: 1px solid black;
	background-color: #e6ccb3;
	color: black;
}


input {
	width: 360px;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background-color: white;
}

button {
	background-color: #734d26;
	color: black;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 194px;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

#summarytab {
background-color: #734d26;
}

#activities {
width: 600px;
}

#activities tr th{
    
    text-align: center;
    color: white;
    width:150px;
    border: 1px solid black;
    background-color: #734d26;
    height:30px;
}

#activities tr td{
    
    text-align: center;
    color: white;
    width:150px;
    border: 1px solid black;
    background-color: #e6ccb3;
    height:50px;
}

</style>
<script type="text/javascript">



</script>
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
	    <a id="summarytab">Summary</a>
	    <a href = "activities">Activities</a>
	    <a href="transfer.jsp">Transfer</a>
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
		<table id="activities">
		<tr>
		<th> Account Number</th>
		<th> Type</th>
		<th> Total Balance</th>
		</tr>
		
		<c:if test="${accountInfo != null}">
		<tr>
		<td>${accountInfo.accountNumber}</td>
		<td> ${accountInfo.type}</td>
		<td> ${accountInfo.balance}</td>
		</tr>
		</c:if>
		
		
		</table>
		
		</div>
		<div class="footer"></div>
		</div>
</body>
</html>