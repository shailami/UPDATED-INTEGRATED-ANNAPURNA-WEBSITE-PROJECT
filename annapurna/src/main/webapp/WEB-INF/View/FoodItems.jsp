<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
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
<body>
<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<jsp:include page="menu.jsp" />	
		<table id="order">
		<tr>
			<th>Food Name</th>
			<th>Price</th>
			<th>Description</th>
			<th></th>
		</tr>
		<core:forEach var="foodItems" items="${restaurant.foodItems}">
			<tr>
				<td>${foodItems.foodName}</td>
				<td>${foodItems.price}</td>
				<td>${foodItems.description}</td>
				<td><a href="/cart/addCart?restaurantName=${restaurant.name}&foodName=${foodItems.foodName}
				&price=${foodItems.price}&quantity=1<%-- &address=${restaurant.address} --%>">Add </a></td>
			</tr>
		</core:forEach>
	</table>
	
</body>
</html>