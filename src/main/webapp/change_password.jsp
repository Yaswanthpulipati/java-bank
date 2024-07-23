<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String s=(String) session.getAttribute("change_password"); %>
<!DOCTYPE html>
<html>
<head>
<style>
	body {
    margin: auto;
    font-family: -apple-system, BlinkMacSystemFont, sans-serif;
    overflow: auto;
    background: linear-gradient(315deg, rgba(101,0,94,1) 3%, rgba(60,132,206,1) 38%, rgba(48,238,226,1) 68%, rgba(255,25,25,1) 98%);
    animation: gradient 15s ease infinite;
    background-size: 400% 400%;
    background-attachment: fixed;
}

@keyframes gradient {
    0% {
        background-position: 0% 0%;
    }
    50% {
        background-position: 100% 100%;
    }
    100% {
        background-position: 0% 0%;
    }
}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/customer_login.css?v=2" type="text/css">

<title>Change password..</title>
</head>
<body>
	<center>
		<% if(s==null){ %>
		<h1><strong>C</strong>hange <strong>Y</strong>our <strong>P</strong>assword</h1>
		<%}else{ %>
		<h1><%= s %></h1>
		<%} %>
		<form action="change_password" method="post">
			<table>
				<tr>
					<td>Enter Account Number :</td>
					<td><input type="text" placeholder="enter here..." name="acc_no" /></td>
				</tr>
				<tr>
					<td>Enter your current password :</td>
					<td><input type="password" placeholder="old password" name="old" /></td>
				</tr>
				<tr>
					<td>Enter your new password :</td>
					<td><input type="password" placeholder="new password" name="new" /></td>
				</tr>
			
				<tr>
					<td><button>Change</button></td>
					</form>
					<td><form action="javascript:history.back()"><button >Go Back</button></form></td>
				</tr>
			</table>
		
	</center>
</body>
</html>