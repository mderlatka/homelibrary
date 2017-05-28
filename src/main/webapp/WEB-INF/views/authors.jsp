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
<title><spring:message code="author.authors.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="author.authors.title" />
				</h1>
				<p>
					<spring:message code="author.authors.title2" />
				</p>
			</div>
		</div>
	</section>
	<section>
		<c:if test="${insertSuccess eq true}">
			<div class="alert alert-success">
				<spring:message code="author.authors.insertAuthorSuccess" />
			</div>
		</c:if>
		<c:if test="${deleteSuccess eq true}">
			<div class="alert alert-danger">
				<spring:message code="author.authors.deleteAuthorSuccess" />
			</div>
		</c:if>
		<br>
		<div class="col-lg-8">
			<table class="table">
				<c:forEach items="${authors}" var="author">
					<tbody>
						<tr>
							<th>${author.authorName}${author.authorSurname}</th>
							<td><a
								href="<spring:url value="/books/author?id=${author.authorId}" />"
								class="btn btn-primary"> <span
									class="glyphicon-book glyphicon" /></span> <spring:message
										code="author.authors.authorBooks" />
							</a></td>
							<td><sec:authorize access="hasRole('ROLE_ADMIN')">
									<c:url var="deleteAuthor"
										value="/authors/delete/author?id=${author.authorId}" />
									<form action="${deleteAuthor}" method="POST">
										<input type="submit" class="btn btn-danger"
											value="<spring:message code="author.authors.removeAuthorBtn"/>"
											onClick="return confirm('Do you want to remove author?\nEnter OK or Cancel')" />
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
								</sec:authorize></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>