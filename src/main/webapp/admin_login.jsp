<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
<link rel="stylesheet" type="text/css" href="css/customer_login.css?v=2">
<title>Admin Login Page</title>
</head>
<body>

	<div>
		<form action="admin_home" method="post">
			<center>
				<h1><strong>A</strong>dmin <strong>L</strong>ogin window</h1>
			<table>
				<tr>
					<td>Enter your ID:</td>
					<td><input type="text" placeholder="Enter here..." name="admin_id" required/></td>
				</tr>
				<tr>
					<td>Enter your password:</td>
					<td><input type="password" placeholder="Enter here..." name="password" required/></td>
				</tr>
				<tr>
					<td style="align-items:center">
						<button type="submit" >Login</button>
						</form>
					</td>
					<td><form action="index.jsp"><button type="submit">Go Back</button></form></td>
				</tr>
			</table>
			</center>
		
	</div>
	
</body>
</html>