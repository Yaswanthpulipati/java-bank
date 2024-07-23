<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String s=(String) session.getAttribute("changeDetails"); %>
    
<!DOCTYPE html>
<html>
<style>
	table{
		margin-bottom:50px;
	}
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
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/withdrawl_page.css?v=2" type="text/css">
<title>Update Details</title>
</head>
<body>
	<center>
	<% if(s==null){ %>
	<h1><strong>U</strong>pdate <strong>Y</strong>our <strong>D</strong>etails</h1>
	<%}else{ %>
	<h1><%= s %></h1>
	<%} %>
		<form action="change_customer_details" method="post">
			<table style="border=solid;">
				<tr>
					<td>Enter your Account number: </td>
					<td><input type="text" placeholder="enter here..." name="acc_no"/></td>
				</tr>
				<tr>
					<td>Enter your password: </td>
					<td><input type="password" placeholder="enter here..." name="password"/></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>Full Name :</td>
					<td> <input placeholder="enter here..." type="text" name="full_name"/> </td>
				</tr>
				<tr>
					<td>Address :</td>
					<td> <input placeholder="enter here..." type="text" name="address"/> </td>
				</tr>
				<tr>
					<td>Mobile Number :</td>
					<td> <input placeholder="enter here..." type="text" name="mobile"/> </td>
				</tr>
				<tr>
					<td>Email :</td>
					<td> <input placeholder="enter here..." type="text" name="email"/> </td>
				</tr>
				<tr>
					<td>Date of birth :</td>
					<td> <input placeholder="enter here..." type="text" name="dob"/> </td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></form></td>
					<td><form action="javascript:history.back()"><button >Go Back</button></form></td>
				</tr>
			</table>
		
	</center>
</body>
</html>