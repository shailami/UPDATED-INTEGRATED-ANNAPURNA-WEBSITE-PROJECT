<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp" />
<form action="/cart/passMoneyForm" method="get">
	<!-- Enter profileId: --> <input type="hidden" value="1" name="profileId"/><br/>
	Enter Amount : <input value="${totalAmount}" name="amount" readonly="readonly"/><br/><!-- ${Order.totalAmount} -->
	<input type="submit"/>
</form>
</body>
</html>