<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String s= (String) session.getAttribute("regCust"); %>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
color:white;
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

	div.logout{
		text-align:right;
	}
	form.logout{
		display:inline-block;
	}
	button.logout{
		height:30px;
	}
	input[type="date"]::-webkit-datetime-edit-text,
	input[type="date"]::-webkit-datetime-edit-month-field,
	input[type="date"]::-webkit-datetime-edit-day-field,
	input[type="date"]::-webkit-datetime-edit-year-field {
	  color: white;
	}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/withdrawl_page.css" type="text/css">
<title>Add Customer</title>
</head>
<body>
	<center>
	<% if(s==null){ %>
	<h1><strong>U</strong>pdate <strong>C</strong>ustomer <strong>D</strong>etails</h1>
	<%}else{ %>
	<h1><%= s %></h1>
	<% } %>
		<form action="add_customer" method="post">
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
					<td>Account Number :</td>
					<td> <input placeholder="enter here..." type="text" name="acc_no"/> </td>
				</tr>
				<tr>
					<td>Account Type :</td>
					<td> <input placeholder="saving/current" type="text" name="acc_type"/> </td>
				</tr>
				<tr>
					<td>Date of birth :</td>
					<td> <input placeholder="dd-mm-yyy" type="date" name="dob"/> </td>
				</tr>
				<tr>
					<td>ID proof number :</td>
					<td> <input placeholder="enter here..." type="text" name="idProof"/> </td>
				</tr>
				<tr>
					<td>Password :</td>
					<td> <input placeholder="enter here..." type="password" name="password"/> </td>
				</tr>
				<tr>
					<td>Balance :</td>
					<td> <input placeholder="text" type="text" name="balance"/> </td>
				</tr>
				<tr>
					<td><button type="submit">Add</button></form></td>
					<td><form action="javascript:history.back()"><button >Go Back</button></form></td>
				</tr>
			</table>
		
	</center>
</body>
</html>