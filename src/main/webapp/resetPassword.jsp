<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #b3ecff;
	text-align: center;
}

.field {
	background-color: #f2f2f2;
	border-radius: 10%;
}

table {
	border: 2px solid #f2f2f2;
	margin: auto;
	padding: 20px;
	
}

#btn {
	background-color: gray;
	color: white;
}


</style>

<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<h2>Reset your password</h2>
	<form action="reset" method="post">
		<table style = "text-align:center">
			<tr>
				<td>Confirm Username</td>
				<td><input type="text" name="username" class="field"><td>
			</tr>
			<tr>
				<td>Enter new password</td>
				<td><input type="text" name="newPassword" class="field"></td>
			</tr>
			<tr>
			<td>Confirm Password</td>
			<td><input type="text" name="confirmPassword" class="field"></td>
			</tr>
		</table>
		<input type="submit" value="Submit" id="btn">
	</form>
</body>
</html>