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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title><spring:message code="author.addAuthor.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>
					<spring:message code="author.addAuthor.title" />
				</h2>
			</div>
		</div>
	</section>
	<section>
		<!-- beginning adding author panel -->
		<div class="col-lg-5 col-lg-offset-3">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<spring:message code="author.addAuthor.addNewAuthorForm" />
					</h3>
				</div>
				<form:form modelAttribute="authorDto" class="form-horizontal">
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
					<div class="panel-body">
						<fieldset>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4" for="authorName"><spring:message
											code="author.addAuthor.form.firstname" /></label>
									<div class="col-lg-7">
										<form:input id="authorName" path="authorName" type="text"
											class="form-control" />
										<form:errors path="authorName" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-lg-4 col-lg-4"
										for="authorSurname"><spring:message
											code="author.addAuthor.form.surname" /></label>
									<div class="col-lg-7">
										<form:input id="authorSurname" path="authorSurname"
											type="text" class="form-control" />
										<form:errors path="authorSurname" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-5 col-lg-1">
									<input type="submit" id="btnAdd" class="btn btn-primary"
										value="<spring:message code="author.addAuthor.form.addAuthorBtn"/>" />
								</div>
							</div>
						</fieldset>
					</div>
				</form:form>
			</div>
		</div>
		<!-- end of adding author form -->
	</section>
</body>
</html>