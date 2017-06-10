<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
</head>
<div class="jumbotron">
	<h1>
		<spring:message code="home.welcome.greeting" />
	</h1>
	<p>
		<spring:message code="home.welcome.greeting2" />
	</p>
</div>
<div class="row">
	<c:if test="${addUserSuccess eq true}">
		<div class="alert alert-success">
			<spring:message code="home.welcome.newUserRegisteredAlert" />
		</div>
	</c:if>
</div>
</html>