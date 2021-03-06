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
		<div class="col-lg-2">
			<table class="table">
				<thead>
				<tr>
				<th><strong>#ID</strong></th>
				<th><strong>Login</strong></th>
				<th><strong>Email</strong></th>
				<th><strong>Roles</strong></th>
				</tr>
				</thead>
				<c:forEach items="${users}" var="user">
					<tbody>
						<tr>
						<td>${user.userId}</td>
							<td><a
								href=" <spring:url value="/users/user?id=${user.userId}"/>">
									<c:out value="${user.userName}" />
							</a></td>
							<td>${user.email}</td>
							<td><c:forEach items="${user.userRoles}" var="roles">${roles.rolename}<br/></c:forEach></td>
							<td><a href="<spring:url value="/users/user?id=${user.userId}"/>" class="btn btn-primary"><spring:message code="admin.users.movetoUserDetailsBtn"/></a></div></td>
							<td><sec:authorize access="hasRole('ROLE_ADMIN')">
									<div class="col-lg-2 ">
										<button type="button" class="btn btn-danger"
											data-toggle="modal"
											data-target="#deleteUserModal_${user.userId}">
											<spring:message code="user.userDetails.deleteUserBtn" />
										</button>
									</div>
								</sec:authorize></td>
						</tr>
					</tbody>
<!-- Modal delete user -->
		<div class="modal fade" id="deleteUserModal_${user.userId}"
			role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">
							<spring:message
								code="user.userDetails.modalTitle.deleteUserBtn" />
						</h4>
					</div>
					<div class="modal-body">
						<p>
							<spring:message
								code="user.userDetails.modalBody.deleteUser" />
						</p>
					</div>
					<div class="modal-footer">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
								<form action="<c:url value="/users/delete/user?id=${user.userId}" />" method="POST">
									<input type="submit" class="col-lg-2 btn btn-danger"
										value="<spring:message code="user.userDetails.modalFooter.deleteUserBtn"/>" />
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
						</sec:authorize>
						<button type="button" class="col lg-2 btn btn-default" data-dismiss="modal">
							<spring:message
								code="user.userDetails.modalFooter.cancelDeleteUserBtn" />
						</button>
					</div>
				</div>

			</div>
		</div>
		<!-- end of modal delete user -->

				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>