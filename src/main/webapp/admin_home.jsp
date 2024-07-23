<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.Admin" %>
<%
	Admin a=(Admin) session.getAttribute("aHome");
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
<link rel="stylesheet" href="css/customer_home.css?v=1" type="text/css">
<style type="text/css">
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
<title>Home Page</title>
</head>
<body>
	<div class="logout">
		<form class="logout" action="admin_login.jsp"><button class="logout">log out</button></form>
	</div>
	<div>
		<center>
		<h1><strong>A</strong>dmin <strong>H</strong>ome</h1>
		<div id="image"><img src='user.png'/></div>
		<table>
			<tr>
				<td>Name:</td>
				<td class="recieve"><%= a.getName() %></td>
			</tr>
			<tr>
				<td>email:</td>
				<td class="recieve"><%= a.getEmail() %></td>
			</tr>
			<tr>
				<td>DoB:</td>
				<td class="recieve"><%= a.getDob() %></td>
			</tr>
			<tr>
				<td>Experience level:</td>
				<td class="recieve"><%= a.getExpLevel() %></td>
			</tr>
		</table>
		<br>
			<table>
				<tr>
					<td> <form action="registerCustomer.jsp"><button>Add Customer</button> </form></td>
					<td> <form action="deleteCustomer.jsp"><button>Delete Customer</button></form> </td>
				</tr>
				<tr>
					<td><form action="viewCustomer.jsp"><button>view customer</button></form></td>
					<td><form action="all_customers" method="post"><button>view all customers</button></form></td>
				</tr>
			</table>
		</center>
	</div>
</body>
</html>