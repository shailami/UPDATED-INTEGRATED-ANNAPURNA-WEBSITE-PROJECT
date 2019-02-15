
<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<style type="text/css">
table, th, td {
	padding: 5px;
	height: 80px;
	width: 1100px;
	font-size: 20px;
	text-align: center;
	font-family: inherit;
}

th, td {
	padding: 1px;
	background-color: lightgray;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp" />

	<table>
		<tr>
			<th>ORDER ID</th>
			<th>DATE</th>
			<th>MODE OF PAYMENT</th>
			<th>STATUS</th>
			<th>PRODUCTS</th>
			<th>TOTAL AMOUNT</th>
			<th>USER ID</th>
		</tr>
		
			<jstl:forEach var="order" items="${list}">
			<tr>
				<td>${order.orderId}</td>
				<td>${order.date}</td>
				<td>${order.modeOfPayment}</td>
				<td>${order.status}</td>
				<td>${order.products}</td>
				<td>${order.totalAmount}</td>
				<td>${order.cartId}</td>
			</tr>
		</jstl:forEach>
		</table>
</body>
</html>