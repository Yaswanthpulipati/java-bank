<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css?v=2" type="text/css">
<title>Bank App</title>
</head>
<body>
	
	<center>
	<h1><strong>W</strong>elcome to our <strong>B</strong>ank !!!</h1>
	<div>
		<table>
			<tr>
				<td>
					<form action="admin_login" method="get">
						<button type="submit" >Admin</button>
					</form>
				</td>
			
				<td>
					<form action="customer_login" method="get">
        				<button type="submit" >Customer</button>
        			</form>
				</td>
			</tr>
		</table>
	</div>
	</center>        
    
</body>
</html>