<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#order {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#order td, #order th {
	border: 1px solid #ddd;
	padding: 8px;
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

#order tr:nth-child(even) {
	background-color: #f2f2f2;
}

#order tr:hover {
	background-color: #ddd;
}

#order th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body >
<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<jsp:include page="menu.jsp" />
<%-- ${list} --%>
<div>
	<div>
		<form action="search" id="order">
		Search :<input name="search" > 
			<input type="submit" value="Search"class="button" style="height: 40px"><br><br><br>
		</form>	
	</div>
	<table id="order">
		<tr>
			<th>Restaurant Name</th>
			<th>Address</th>
		</tr>
		
		<core:forEach var="restaurant" items="${list}">
			<tr>
				<td><a href="/foodItems?restaurantId=${restaurant.restaurantId}">${restaurant.name}</a></td>
				<td>${restaurant.address}</td>
			</tr>
		</core:forEach>
	</table>
</div>

</body>
</html>