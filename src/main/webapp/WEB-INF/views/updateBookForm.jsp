<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title><spring:message code="book.updateBookForm.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>
					<spring:message code="book.updateBookForm.title" />
				</h2>
			</div>
		</div>
	</section>
	<section>

		<!-- beginning adding book panel -->
		<div class="col-lg-6 col-lg-offset-3">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<spring:message code="book.updateBookForm.addBookLegend" />
					</h3>
				</div>
				<form:form modelAttribute="book" class="form-horizontal"
					enctype="multipart/form-data" accept-charset="UTF-8">
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
					<div class="panel-body">
						<fieldset>
							<div class="form-group">
								<form:hidden path="bookId" />
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4" for="title"><spring:message
											code="book.updateBookForm.form.title" /></label>
									<div class="col-lg-7">
										<form:input id="title" path="title" type="text"
											class="form-control" />
										<form:errors path="title" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4" for="author"><spring:message
											code="book.updateBookForm.form.author" /></label>
									<div class="col-lg-7">
										<form:select path="author" name="author" class="form-control">
											<form:option value="${author.authorId}">${author.authorName} ${author.authorSurname}</form:option>
											<c:forEach items="${authors}" var="author">
												<form:option value="${author.authorId}">${author.authorName} ${author.authorSurname} </form:option>
											</c:forEach>
										</form:select>
										<form:errors path="author" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4"
										for="releaseDate"><spring:message
											code="book.updateBookForm.form.releaseDate" /></label>
									<div class="col-lg-7">
										<form:input id="releaseDate" path="releaseDate" type="text"
											placeHolder="dd.mm.rrrr" class="form-control" />
										<form:errors path="releaseDate" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4" for="numOfPages"><spring:message
											code="book.updateBookForm.form.numPages" /></label>
									<div class="col-lg-7">
										<form:input id="numOfPages" path="numOfPages" type="number"
											class="form-control" />
										<form:errors path="numOfPages" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4" for="category"><spring:message
											code="book.updateBookForm.form.genre" /></label>
									<div class="col-lg-7">
										<form:select path="category" name="category"
											class="form-control">
											<form:option value="${category.categoryId}">${category.categoryName}</form:option>
											<c:forEach items="${categories}" var="category">
												<form:option value="${category.categoryId}">${category.categoryName} </form:option>
											</c:forEach>
										</form:select>
										<form:errors path="category" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4"
										for="description"><spring:message
											code="book.updateBookForm.form.description" /></label>
									<div class="col-lg-7">
										<form:textarea id="description" path="description" rows="5"
											cols="40" class="form-control" />
										<form:errors path="description" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4" for="bookImage"><spring:message
											code="book.updateBookForm.form.coverImage" /></label>
									<div class="col-lg-7">
										<form:input id="bookImage" path="bookImage" type="file"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-4">
									<input type="submit" id="btnAdd" class="btn btn-primary btn-md"
										style="width: 160px;"
										value="<spring:message code="book.updateBookForm.form.addBookBtn"/>" />
								</div>
							</div>
						</fieldset>
					</div>
				</form:form>
			</div>
		</div>
		<!-- end of adding book form -->
	</section>
</body>
<br>
</html>