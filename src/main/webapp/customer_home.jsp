<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.entity.Customer" %>
<%
	Customer c=(Customer) session.getAttribute("cHome");
%>
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
		margin-top:5px;
		margin-right:3px;
		text-align:right;
	}
	form.logout{
		display:inline-block;
	}
	button.logout{
		height:30px;
	}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/customer_home.css?v=3" type="text/css">
<title>Home Page</title>
</head>
<body>
	<div class="logout">
		<form class="logout" action="customer_login.jsp"><button class="logout">log out</button></form>
	</div>
	<div>
	<center>
		<h1><strong>C</strong>ustomer <strong>H</strong>ome</h1>
		<div id="image"><img src='user.png'/></div>
			<table>
				<tr>
					<td>Name :</td>
					<td class="recieve"><%= c.getFullName() %></td>
				</tr>
				<tr>
					<td>DOB:</td>
					<td class="recieve"><%= c.getDob() %></td>
				</tr>
				
				<tr>
					<td>Account Number :</td>
					<td class="recieve"><%= c.getAccNumber() %></td>
				</tr>
				<tr>
					<td>Balance :</td>
					<td class="recieve"><%= c.getBalance() %></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td class="recieve"><%= c.getEmail() %></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><form action="withdrawl_page.jsp?acc_no=<%= c.getAccNumber() %>"><button>Withdraw</button></form></td>
					<td><form action="deposit_page.jsp"><button>Deposit</button></form></td>
				</tr>
				<tr>
					<td><form action="changeDetailsByCustomer.jsp"><button>Change Details</button></form></td>
					<td><form action="change_password.jsp"><button>Change Password</button></form></td>
				</tr>
				<tr>
					<td><form action="view_transactions.jsp"><button>show transactions</button></form></td>
					<td></td>
				</tr>
			</table>
	</center>
	</div>
</body>
</html>