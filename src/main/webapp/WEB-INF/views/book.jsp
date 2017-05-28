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
			<div class="col-lg-5">
				<img
					src="<c:url value="/resources/images/${book.title}.png"></c:url>"
					alt="image" style="width: 300px" />
			</div>
			<div class="col-lg-6">
				<h3>${book.author.authorName}${book.author.authorSurname}</h3>
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
					<fmt:formatDate pattern="dd.MM.yyyy" value="${book.releaseDate}" />
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
							<c:url var="deleteBook" value="/books/book?id=${book.bookId}" />
							<form action="${deleteBook}" method="POST">
								<input type="submit" class="btn btn-danger"
									value="<spring:message code="book.book.deleteBook"/>"
									onClick="return confirm('Are you sure you want to delete ${book.title}?\nEnter OK or Cancel')" />
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</div>
					</sec:authorize>
				</div>
			</div>
		</div>
	</section>
</body>
<br>
<br>
</html>