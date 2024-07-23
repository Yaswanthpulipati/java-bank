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
<link rel="stylesheet" href="css/withdrawl_page.css?v=3" type="text/css">
<title>Money Deposit</title>
</head>
<body>
<center>
	<div>
		<form action="deposit_" method="post">
			<h1><strong>M</strong>oney <strong>D</strong>eposit Page</h1>
			<table>
				<td>Enter Account Number :</td>
				<td><input placeholder="enter here..."type="text" name="acc_no"/><b>/-<b></td>
				</tr>
				<tr>
				<tr>
				<td>Enter Amount to deposit (in Rs.) :</td>
				<td><input placeholder="e.g. 500.00"type="text" name="amount"/><b>/-<b></td>
				</tr>
				<tr>
					<td id="right"><button  type="submit" >Deposit</button></td>
					</form>
					<td>
						<form action="javascript:history.back()">
							<button type="submit">Go Back</button>
						</form>
					</td>
					
				</tr>
			</table>
	</div>
</center>
</body>
</html>