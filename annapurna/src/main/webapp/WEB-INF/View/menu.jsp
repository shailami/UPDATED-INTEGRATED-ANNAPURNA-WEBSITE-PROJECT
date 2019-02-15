<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

	<!-- <h2></h2> -->
	<h3 style="color: red;" align="center">
		<a href="${pageContext.request.contextPath}/">Home</a> | &nbsp;
		<a onclick="document.forms['logoutForm'].submit()">Logout</a>
	</h3>

	<form id="logoutForm" method="POST" action="${contextPath}/logout">
	</form>

</div>