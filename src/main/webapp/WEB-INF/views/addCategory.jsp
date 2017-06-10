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
<title><spring:message code="category.addCategory.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>
					<spring:message code="category.addCategory.title" />
				</h2>
			</div>
		</div>
	</section>
	<section>
		<!--  adding genre panel -->
		<div class="col-lg-5 col-lg-offset-3">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<spring:message code="category.addCategory.addingNewGenreForm" />
					</h3>
				</div>
				<form:form modelAttribute="categoryDto" class="form-horizontal">
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
					<div class="panel-body">
						<fieldset>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4"
										for="categoryName"><spring:message
											code="category.addCategory.form.genreName" /></label>
									<div class="col-lg-7">
										<form:input id="categoryName" path="categoryName" type="text"
											class="form-control" style="height: 45px;" />
										<form:errors path="categoryName" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-5 col-lg-1">
									<input type="submit" id="btnAdd" class="btn btn-primary"
										value="<spring:message code="category.addCategory.form.addGenreBtn"/>" />
								</div>
							</div>
						</fieldset>
					</div>
				</form:form>
			</div>
		</div>
		<!-- end of adding genre form -->

	</section>
</body>
</html>