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
<title>${book.title}</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>${book.title}</h2>
			</div>
		</div>
	</section>
	<section>
		<div class="row">
			<c:if test="${addSuccess eq true}">
				<div class="alert alert-success">
					<spring:message code="book.books.updateSucces" />
				</div>
			</c:if>
		</div>
		<div class="row">
			<div class="col-lg-5">
				<a href="<c:url value="/image/book?id=${book.bookId}"/>"> <img
					src="/homelibrary/image/book?id=${book.bookId}" alt="image"
					style="width: 300px" />
				</a>
			</div>
			<div class="col-lg-6">
				<h3>${book.author.authorName}&nbsp;${book.author.authorSurname}</h3>
				<p>
					<spring:message code="book.book.bookId" />
					${book.bookId}
				</p>
				<p>
					<spring:message code="book.book.numPages" />
					${book.numOfPages}
				</p>
				<p>
					<spring:message code="book.book.releaseDate" />
					<fmt:formatDate pattern="dd.MM.yyyy" value="${book.releaseDate}"></fmt:formatDate>
				</p>
				<p>
					<spring:message code="book.book.genre" />
					${book.category.categoryName}
				</p>
				<p>
					<spring:message code="book.book.description" />
					<br></br> ${book.description}
				</p>
				<div class="row">
					<div class="col-lg-2">
						<a href="<c:url value="/books" />" class="btn btn-primary"> <span
							class="glyphicon-hand-left glyphicon"></span> <spring:message
								code="book.book.return" />
						</a>
					</div>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div class="col-lg-2 col-lg-offset-1">
							<a
								href="<spring:url value="/books/update/book?id=${book.bookId}" />"
								class="btn btn-primary"> Edytuj </a>
						</div>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div class="col-lg-2 col-lg-offset-1">
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#deleteModal_${book.bookId}">
								<spring:message code="book.book.deleteBook" />
							</button>
						</div>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<div class="col-lg-2 col-lg-offset-1">
							<c:url var="doAddFavoriteUserBook"
								value="/favorite/book?id=${book.bookId}" />
							<form action="${doAddFavoriteUserBook}" method="POST">
								<input type="submit" class="btn btn-primary"
									value="<spring:message code="book.book.addToFavorite"/>" /> <input
									type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</div>
					</sec:authorize>
				</div>
			</div>
		</div>
		<br /> <br />
	</section>
</body>
<!-- Modal -->
<div class="modal fade" id="deleteModal_${book.bookId}" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<spring:message code="book.book.deleteBook.modalTitle" />
				</h4>
			</div>
			<div class="modal-body">
				<p>
					<spring:message code="book.book.deleteBook.modalBody" />
				</p>
			</div>
			<div class="modal-footer">
				<div class="col-lg-1 col-lg-offset-8">
					<c:url var="deleteBook" value="/books/book?id=${book.bookId}" />
					<form action="${deleteBook}" method="POST">
						<input type="submit" class="btn btn-danger"
							value="<spring:message code="book.book.modalFooter.DeleteBookBtn"/>" />
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<spring:message code="book.book.modalFooter.cancelDeleteBookBtn" />
				</button>
			</div>
		</div>

	</div>
</div>
<!-- end of Modal-->
</html>