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
<title><spring:message code="user.registerForm.pageTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="user.registerForm.title" />
				</h1>
			</div>
		</div>
	</section>
	<!-- beginning registration panel -->
	<div class="col-lg-5 col-lg-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<spring:message code="user.registerForm.registrationForm" />
				</h3>
			</div>
			<form:form modelAttribute="userDto" class="form-horizontal">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="panel-body">
					<fieldset>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-lg-4 col-lg-4" for="userName"><spring:message
										code="user.registerForm.username" /></label>
								<div class="col-lg-7">
									<form:input id="userName" path="userName" type="text"
										class="form-control" />
									<form:errors path="userName" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-lg-4 col-lg-4" for="password"><spring:message
										code="user.registerForm.password" /></label>
								<div class="col-lg-7">
									<form:input id="password" path="password" type="password"
										class="form-control" />
									<form:errors path="password" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-lg-4 col-lg-4" for="email"><spring:message
										code="user.registerForm.email" /></label>
								<div class="col-lg-7">
									<form:input id="email" path="email" type="text"
										class="form-control" />
									<form:errors path="email" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-5 col-lg-1">
								<input type="submit" id="btnAdd" class="btn btn-lg btn-primary"
									value="<spring:message code="user.registerForm.addNewUserBtn"/>" />
							</div>
						</div>
					</fieldset>
				</div>
			</form:form>
		</div>
	</div>
	<!-- end of registration form -->

</body>
</html>