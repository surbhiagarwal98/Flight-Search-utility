<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #b3ecff;
	text-align:center;
}
table {
	border: 2px solid #f2f2f2;
	margin: auto;
	padding: 20px;
	text-align:left;
	cell-spacing:10px;
}
h1{
color:red;
}
.field{
width:100%;
background-color: #f2f2f2;
}
#btn{
background-color : gray;
color:white;
padding:7px;
}
</style>
<meta charset="ISO-8859-1">
<title>Search your Flight</title>
</head>
<body>
	
	<h1>Welcome, <%=request.getAttribute("username")%>!</h1>
	<h3>Please enter Flight details</h3>
	<form action="search" action="post">
		<table>
			<tr>
				<td>From</td>
				<td><select name="from" class="field">
						<c:forEach items="${depLocations}" var="depLocation">
							<option value="${depLocation}">${depLocation}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>To</td>
				<td><select name="to" class="field">
						<c:forEach items="${arrLocations}" var="arrLocation">
							<option value="${arrLocation}">${arrLocation}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Flight Class</td>
				<td><select name="flightclass" class="field">
						<option>E</option>
						<option>B</option>

				</select></td>
			</tr>
			<tr>
				<td>Flight Date(dd-MM-yyyy)</td>
				<td><input type="text" id="flightdate" name="date" class="field"></td>
			</tr>
			<tr>
				<td>Sort by</td>
				<td><select name="sortBy" class="field">
						<option>Fare</option>
						<option>Duration</option>
						<option>Both</option>
				</select></td>
			</tr>
			
		</table>
		<input type="submit" value="Search" id="btn">
	</form>
</body>
</html>