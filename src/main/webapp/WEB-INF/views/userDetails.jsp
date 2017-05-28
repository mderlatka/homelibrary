<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title><spring:message code="admin.user-details.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>
					<spring:message code="admin.user-details.pageTitle" />
					${user.userName}
				</h2>
			</div>
		</div>
	</section>
	<section>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="row">
				<a href="<spring:url value="/users" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> <spring:message
						code="admin.user-details.returnToUsersPageBtn" />
				</a>
			</div>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')&&!hasRole('ROLE_ADMIN')">
			<div class="row">
				<a href="<spring:url value="/" />" class="btn btn-default"> <span
					class="glyphicon-hand-left glyphicon"></span> <spring:message
						code="admin.user-details.returnToMainPageBtn" />
				</a>
			</div>
		</sec:authorize>
		<br />
		<div class="row">
			<div class="col-lg-5 col-lg-3">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th><spring:message code="admin.user-details.login" /></th>
							<td>${user.userName}</td>
						</tr>
						<tr>
							<th><spring:message code="admin.user-details.email" /></th>
							<td>${user.email}</td>
						</tr>
						<tr>
							<th><spring:message code="admin.user-details.roles" /></th>
							<td><c:forEach items="${userRoles}" var="usrRoles"> ${usrRoles.rolename}<br />
								</c:forEach></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="col-lg-2 col-lg-offset-1">
				<c:url var="deleteBook" value="/users/user?id=${user.userId}" />
				<form action="${deleteUser}" method="POST">
					<input type="submit" class="btn btn-danger"
						value="<spring:message code="admin.user-details.deleteUserBtn"/>"
						onClick="return confirm('Do you want to remove user?\nEnter OK or Cancel')" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
		</sec:authorize>
	</section>
</body>
</html>
