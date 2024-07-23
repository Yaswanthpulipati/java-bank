<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<% double[] d=  (double[] )session.getAttribute("transactions");
	
	String s="<tr><td class=\"head\">S.no</td><td class=\"head\">Transaction type</td><td class=\"head\">amount</td></tr>";
	if(d!=null){
	for(int i=0;i<10;i++){
		if(d[i]>0){
			s=s+"<tr><td class=\"recieve\">"+(i+1)+"</td><td class=\"recieve\">Deposit</td><td class=\"recieve\">"+d[i]+"</td></tr>";
		}else if(d[i]<0){
			s=s+"<tr><td class=\"recieve\">"+(i+1)+"</td><td class=\"recieve\">Withdraw</td><td class=\"recieve\">"+(d[i]*-1)+"</td></tr>";
		}else{
			
		}
	}
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
input{
	border-style: none;
    border-radius: 8px;
    width: 100px;
    height: 30px;
    background-color: rgb(255, 255, 255, 0.3);
    font-weight: bold;
    font-family: monospace;
    outline: none;
}
input:focus{
	
	outline: none;
	border: none;
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
	<h1><strong>A</strong>ll <strong>T</strong>ransactions</h1>
		<table><form action="view_transactions" method="post">
			<tr><td>Enter your account number:</td><td><input placeholder="enter here.." type="text" name="acc_no"></td></tr>
			<tr><td><button type="submit">submit</button></form></td>
				<td><form action="javascript:history.back()"><button>Go Back</button></form></td>
			</tr>
		</table>
		<table>
				<%= s%>
				<tr>
					<td></td>
					<td><center><% if(d!=null && d.length!=0){ %><form action="download_pdf" method="get" ><button type="submit">Print</button></form><% } %></center></td>
					<td></td>
				</tr>
			
		</table>
	</center>
</body>
</html>