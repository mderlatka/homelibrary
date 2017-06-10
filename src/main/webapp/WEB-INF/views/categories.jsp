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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<div class="row">
			<c:if test="${categoryExistAlert eq true}">
				<div class="alert alert-warning">
					<spring:message code="category.addCategory.categoryExistAlert" />
				</div>
			</c:if>
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
		</div>
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
									<button type="button" class="btn btn-danger"
										data-toggle="modal"
										data-target="#myModal_${category.categoryId}">
										<spring:message code="category.categories.deleteGenreBtn" />
									</button>
								</sec:authorize></td>
						</tr>
					</tbody>
					<!-- Modal -->
					<div class="modal fade" id="myModal_${category.categoryId}"
						role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">
										<spring:message
											code="category.categories.deleteGenre.modalTitle" />
									</h4>
								</div>
								<div class="modal-body">
									<p>
										<spring:message
											code="category.categories.deleteGenre.modalBody" />
									</p>
								</div>
								<div class="modal-footer">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<c:url var="deleteCategory"
											value="/categories/delete/category?id=${category.categoryId}" />
										<form action="${deleteCategory}" method="POST">
											<input type="submit" class="btn btn-danger"
												value="<spring:message code="category.categories.modalFooter.deleteGenre"/>" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</sec:authorize>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">
										<spring:message
											code="category.categories.modalFooter.cancelDeleteGenre" />
									</button>
								</div>
							</div>

						</div>
					</div>
					<!-- end of Modal-->
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>