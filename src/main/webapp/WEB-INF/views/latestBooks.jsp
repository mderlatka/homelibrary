<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title><spring:message code="book.latestBooks.titlePage" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>
					<spring:message code="book.books.title" />
				</h2>
				<p>
					<spring:message code="book.books.titleIntroduce" />
				</p>
			</div>
		</div>
	</section>
	<section>
		<div class="row">
			<h3>
				<strong><spring:message code="book.books.latestBooksHeader" /></strong>
			</h3>
			<c:if test="${emptyLatestBooksList eq true}">
				<div class="alert alert-info">
					<spring:message code="book.LatestBooks.emptyLatestBooksList" />
				</div>
			</c:if>
		</div>
		<br>
		<c:forEach items="${latestBooks}" var="book">
			<div class="col-lg-4" style="padding-bottom: 15px">
				<div class="thumbnail" style="height: 525px;">
					<img
						src="<c:url value="/resources/images/${book.title}.png"></c:url>"
						alt="200x300" style="width: 200px; height: 300px;" />
					<div class="caption">
						<h3>${book.title}</h3>
						<h4>${book.author.authorName}${book.author.authorSurname}</h4>
						<p>
							<spring:message code="book.books.genre" />
							${book.category.categoryName}
						</p>
						<p>
							<spring:message code="book.books.numPages" />
							${book.numOfPages}
						</p>
						<p>
							<a href=" <spring:url value="/books/book?id=${book.bookId}" />"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> <spring:message
									code="book.books.details" />
							</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</section>
</body>
</html>