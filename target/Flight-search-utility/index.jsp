<html>

<head>
<style>
body {
	background-color: #b3ecff;
	text-align: center;
}

.textfield {
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

h3 {
	color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>


<body>
	<h1>Flight Search Utility</h1>
	<h3>Login to search your flight.</h3>
	<form action="login" method="post">
		<table>
			<tr>
				<td style="align: left"><b>Login</b></td>
			</tr>
			<tr>
				<td>Username</td>
				<td>* <input type="text" name="username" class="textfield"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>* <input type="password" class="textfield" name="password"></td>
			</tr>
			<tr>
				<td><a href="resetPassword.jsp">Forgotten your password?</a></td>
			</tr>

		</table>
		<input type="submit" value="Login >>" id="btn">
	</form>
</body>

</html>
