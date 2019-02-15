
<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
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

	<jsp:include page="menu.jsp" />

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<h1>**********ORDER*********</h1>
	<form action="http://localhost:8686/PassMoneyLink">
		<table id="order">
			<tr>
				<th>ORDER ID</th>
				<th>DATE</th>
				<th>MODE OF PAYMENT</th>
				<th>STATUS</th>
				<th>RESTAURANT NAME</th>
				<th>PRODUCTS</th>
				<th>TOTAL AMOUNT</th>
				<th>USER ID</th>
			</tr>


			<jstl:forEach var="Order" items="${list}">
				<tr>
					<td>${Order.orderId}</td>
					<td>${Order.date}</td>
					<td>${Order.modeOfPayment}</td>
					<td>${Order.status}</td>
					<td>${Order.restaurantName}</td>
					<td>
						<table>
							<tr>
								<th>FOOD NAME</th>
								<th>PRICE</th>
								<th>QUANTITY</th>
							</tr>
							<jstl:forEach var="foodItems" items="${Order.products}">
								<tr>


									<td>${foodItems.foodName}</td>
									<td>${foodItems.price}</td>
									<td>${foodItems.quantity}</td>
								</tr>


							</jstl:forEach>

						</table>
					</td>
					<td>${Order.totalAmount}</td>
					<td>${Order.cartId}</td>
				</tr>

				<tr>
					<td colspan="8"><a href="/cancelOrder?orderId=${Order.orderId}"
						class="button">Cancel Order</a></td>
				</tr>
			</jstl:forEach>
		</table>
		<br>
		<br>

		<!-- <input type="submit" value="Make Payment"> -->
	</form>
</body>
</html>