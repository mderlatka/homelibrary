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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title><spring:message code="user.userAccount.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>
					<spring:message code="user.userAccount.pageHeader" />
					${user.userName}
				</h2>
			</div>
		</div>
	</section>
	<section>
		<br />
		<div class="row">
			<c:if test="${usrHaveBookInFav eq true}">
				<div class="alert alert-warning">
					<spring:message code="user.userAccount.usrHaveBookInFav" />
				</div>
			</c:if>
			<c:if test="${addedFavUsrBookSuccessed eq true}">
				<div class="alert alert-success">
					<spring:message code="user.userAccount.addedFavUsrBookSuccessed" />
				</div>
			</c:if>
			<c:if test="${deleteFavUsrBookSuccessed eq true}">
				<div class="alert alert-danger">
					<spring:message code="user.userAccount.deleteFavUsrBookSuccessed" />
				</div>
			</c:if>
		</div>
		<br />
		<div class="row">
			<div class="col-lg-5 col-lg-3">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th><spring:message code="user.userAccount.login" /></th>
							<td>${user.userName}</td>
						</tr>
						<tr>
							<th><spring:message code="user.userAccount.email" /></th>
							<td>${user.email}</td>
						</tr>
						<tr>
							<th><spring:message code="user.userAccount.roles" /></th>
							<td><c:forEach items="${userRoles}" var="usrRoles"> ${usrRoles.rolename}<br />
								</c:forEach></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<section>
		<div class="row">
			<h2>
				<spring:message code="user.userAccount.userBooksTable" />
			</h2>
			<!-- beginning users books table -->
			<div class="col-lg-8">
				<table class="table">
					<thead>
						<tr>
							<th><spring:message code="user.userAccount.userFavBookTitle" /></th>
							<th><spring:message
									code="user.userAccount.userFavBookAuthor" /></th>
						</tr>
					</thead>
					<c:forEach items="${userBooks}" var="userBooks">
						<tbody>
							<tr>
								<td><a
									href="<spring:url value="/books/book?id=${userBooks.bookId}" />">
									<c:out value="${userBooks.title}" />
								</a></td>
								<td><a
									href="<spring:url value="/books/author?id=${userBooks.author.authorId}" />">
									<c:out value="${userBooks.author.authorName} ${userBooks.author.authorSurname}" />
								</a></td>
								<td>
									<button type="button" class="btn btn-danger"
										data-toggle="modal"
										data-target="#deleteUserBookModal_${userBooks.bookId}">
										<spring:message
											code="user.userAccount.deleteFavoriteUserBookBtn" />
									</button>
								</td>
							</tr>
						</tbody>
						<!-- Modal delete user book-->
						<div class="modal fade"
							id="deleteUserBookModal_${userBooks.bookId}" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">
											<spring:message
												code="user.userAccount.modalTitle.deleteFavoriteUserBookBtn" />
										</h4>
									</div>
									<div class="modal-body">
										<p>
											<spring:message
												code="user.userAccount.modalBody.deleteFavoriteUserBookBtn" />
										</p>
									</div>
									<div class="modal-footer">
										<c:url var="deleteFavoriteUserBook"
											value="/delete/favorite/book?id=${userBooks.bookId}" />
										<form action="${deleteFavoriteUserBook}" method="POST">
											<input type="submit" class="btn btn-danger"
												value="<spring:message code="user.userAccount.modalFooter.deleteFavoriteUserBookBtn"/>" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">
											<spring:message
												code="user.userAccount.modalFooter.cancelDeleteFavoriteUserBookBtn" />
										</button>
									</div>
								</div>

							</div>
						</div>
						<!-- end of modal delete user book -->
					</c:forEach>
				</table>
			</div>
			<!-- end of users books table -->
		</div>
	</section>
</body>
</html>
