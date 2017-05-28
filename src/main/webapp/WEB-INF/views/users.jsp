<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title><spring:message code="admin.users.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<h1>
				<spring:message code="admin.users.title" />
			</h1>
		</div>
	</section>
	<section>
		<div class="row">
			<div class="col-lg-offset-1 col-lg-10 col-lg-offset-1">
				<c:if test="${deleteUsrSuccess eq true}">
					<div class="alert alert-danger">
						<spring:message code="admin.users.deleteUsrSuccessAlert" />
					</div>
				</c:if>
			</div>
		</div>
		<div class="col-lg-4">
			<table class="table">
				<c:forEach items="${users}" var="user">
					<tbody>
						<tr>
							<th>${user.userName}</th>
							<td><a
								href=" <spring:url value="/users/user?id=${user.userId}"/>"
								class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon"></span> <spring:message
										code="admin.users.userDetails" />
							</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>