<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<% List<Customer> l= (List<Customer>) session.getAttribute("viewAll");
	Iterator itr=l.iterator();
	String s="<tr><td class=\"head\">Account_number</td><td class=\"head\">Full Name</td><td class=\"head\">Balance</td></tr>";
	while(itr.hasNext()){
		Customer c= (Customer) itr.next();
		String st1=c.getFullName();
		String st2=c.getAccNumber();
		double bal=c.getBalance();
		s=s+"<tr><td class=\"recieve\">"+st2+"</td><td class=\"recieve\">"+st1+"</td><td class=\"recieve\">"+bal+"</td></tr>";
	} 
%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/customer_home.css?v=2" type="text/css">
<style>
	.head{
		color: #e1bba0;
    	background-color: transparent;
    	text-align: center;
	    border: none;
	    font-size: 30px;
	    font-family: emoji;
    	font-style: unset;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1><strong>A</strong>ll <strong>C</strong>ustomers</h1>
		<table>
				<%= s%>
				<tr>
					<td></td>
					<td><form action="javascript:history.back()"><button>Go Back</button></form></td>
				</tr>
			
		</table>
	</center>
</body>
</html>