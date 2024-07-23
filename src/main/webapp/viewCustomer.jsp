<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Customer" %>
<% 
    Customer c = (Customer) session.getAttribute("viewOne");
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
input{
	border-radius: 5px;
    color: black;
    width: 150px;
    height: 30px;
    background-color: rgb(255, 255, 255, 0.3);
    border: none;
    font-weight: bold;
    font-family: monospace;
    outline: none;
}
input:focus{
	
	outline: none;
	border: none;
}
::placeholder{
	color:white;
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
<style>
    table {
        border-spacing: 20px;
    }
    td {
        text-align: right;
    }
</style>
<title>Customer Details</title>
</head>
<body>
    <center>
        <h1><strong>C</strong>ustomer <strong>D</strong>etails</h1>
        <form action="admin_to_customer" method="post">
            <table>
                <tr>
                    <td>Enter Account Number :</td>
                    <td><input type="text" placeholder="enter here..." name="acc_no" /></td>
                </tr>
                <tr>
                    <td><button type="submit">Submit</button></td>
                    <td><button type="button" onclick="history.back()">Go Back</button></td>
                </tr>
            </table>
        </form>
        <br>
        <table>
            <% 
                if (c != null && c.getFullName()!=null) { 
            %>
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
                    <td>Id Proof :</td>
                    <td class="recieve"><%= c.getIdProof() %></td>
                </tr>
            <% 
                } else{
            %>
            <tr>
            	<td>No Account Found...</td>
            </tr>
            <% } %>
        </table>
    </center>
</body>
</html>
