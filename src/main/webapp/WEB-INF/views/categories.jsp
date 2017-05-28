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
<title><spring:message code="category.categories.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">

			<div class="container">
				<h2>
					<spring:message code="category.categories.title" />
				</h2>
			</div>
		</div>
	</section>
	<section>
		<c:if test="${addCatSuccess eq true}">
			<div class="alert alert-success">
				<spring:message code="category.categories.addCatSuccessAlert" />
			</div>
		</c:if>
		<c:if test="${deleteCatSuccess eq true}">
			<div class="alert alert-danger">
				<spring:message code="category.categories.deleteCatSuccessAlert" />
			</div>
		</c:if>
		<br>
		<div class="col-lg-6">
			<table class="table">
				<c:forEach items="${categories}" var="category">
					<tbody>
						<tr>
							<th>${category.categoryName}</th>
							<td><a
								href=" <spring:url value="/books/categories/${category.categoryId}" />"
								class="btn btn-primary"> <span
									class="glyphicon-book glyphicon" /></span> <spring:message
										code="category.categories.booksOfGenre" />
							</a></td>
							<td><sec:authorize access="hasRole('ROLE_ADMIN')">
									<c:url var="deleteCategory"
										value="/categories/delete/category?id=${category.categoryId}" />
									<form action="${deleteCategory}" method="POST">
										<input type="submit" class="btn btn-danger"
											value="<spring:message code="category.categories.deleteGenreBtn"/>"
											onClick="return confirm('Do you want to remove genre?\nEnter OK or Cancel')" />
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