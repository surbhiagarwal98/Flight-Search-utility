<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.nagarro.model.Flight"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #b3ecff;
	text-align: center;
}

table {
	background-color: white;
}

table, td, th {
	border-collapse: collapse;
	border: 1px solid black;
}

#logout {
	width: 50px;
	border: 1px solid black;
	padding: 5px;
	background-color: #178888;
	margin: 10px;
}

a {
	color: white;
}

h3 {
	text-align: right;
}

#btn {
	background-color: gray;
	color: white;
	padding: 7px;
}

h2 {
	text-align: left;
	color: #ff0080;
}
</style>
<meta charset="ISO-8859-1">
<title>Search result</title>
</head>

<body>
	<form action="logout">
		<h1>Available flights</h1>
		<h3 style="text-align: right">
			<input type="submit" value="Logout" id="btn">
		</h3>
		<br> <br>
		<table>
			<tr>
				<th>FLIGHT NO</th>
				
				<th>DEPARTURE LOCATION</th>
		
				<th>ARRIVAL LOCATION</th>
		
				<th>VALID TILL</th>

				<th>FLIGHT TIME</th>
	
				<th>FLIGHT DURATION</th>
		
				<th>FARE</th>
				
				<th>SEAT AVAILABILITY</th>
			
				<th>FLIGHT CLASS</th>
			
			</tr>
			<c:forEach items="${availableFlights}" var="flight">
				<tr>
					<td>${flight.getFlightNo()}</td>
					<td>${flight.getDepartureLoc()}</td>
					<td>${flight.getArrivalLoc()}</td>
					<td>${flight.getDate()}</td>
					<td>${flight.getTime()}</td>
					<td>${flight.getDuration()}</td>
					<td>${flight.getFare()}</td>
					<td>${flight.getSeatAvailability()}</td>
					<td>${flight.getFlightClass()}</td>
				</tr>
			</c:forEach>
		</table>


		<c:if test="${availableFlights.size() == 0}">
			<h2>No flights available!</h2>
		</c:if>

	</form>
</body>
</html>