<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String s=(String) session.getAttribute("delCust"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<link rel="stylesheet" href="css/withdrawl_page.css?v=2" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<center>
	<% if(s==null){ %>
	<h1><strong>D</strong>elete <strong>C</strong>ustomer</h1>
	<% }else{ %>
	<h1><%= s %></h1>
	<%} %>
		<form action="delete_customer" method="post"> 
			<table>
				<tr>
					<td>Enter account number :</td>
					<td><input type="text" placeholder="enter here.." name="acc_no"/></td>
				</tr>
				<tr>
					<td>Enter customer name :</td>
					<td><input type="text" placeholder="enter here.." name="full_name"/></td>
				</tr>
				<tr>
					<td><button>Delete</button></form></td>
					<td><form action="javascript:history.back()"><button>Go Back</button></form></td>
				</tr>
				
			</table>
	</center>
</body>
</html>