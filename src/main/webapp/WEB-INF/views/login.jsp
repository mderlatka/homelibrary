<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title><spring:message code="login.login.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="login.login.title" />
				</h1>
			</div>
		</div>
	</section>
	<div class="col-lg-4 col-lg-offset-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<spring:message code="login.login.LoginPanel" />
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${error eq true}">
					<div class="alert alert-danger">
						<spring:message code="login.login.badCredentials" />
						<br />
					</div>
				</c:if>
				<c:if test="${successedLogout eq true}">
					<div class="alert alert-danger">
						<spring:message code="login.login.successedLogout" />
					</div>
				</c:if>
				<form action="<c:url value='/login'></c:url>" method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input class="form-control"
							placeholder="<spring:message code="login.login.usernamePlaceholder"/>"
							name='username' type="text">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input class="form-control"
							placeholder="<spring:message code="login.login.passwordPlaceholder"/>"
							name='password' type="password" value="">
					</div>
					<br> <input class="btn btn-lg btn-success btn-block"
						type="submit"
						value="<spring:message code="login.login.loginbtn"/>"> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
