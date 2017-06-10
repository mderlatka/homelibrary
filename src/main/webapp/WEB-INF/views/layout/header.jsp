<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="navbar.css" rel="stylesheet">
</head>
<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
	<tilesx:useAttribute name="current" id="current"
		classname="java.lang.String" ignore="true" />

	<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<spring:url value="/" />">Homelibrary</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="${current == 'welcome' ? 'active' : '' }"><a
						href="<spring:url value="/" />"><spring:message
								code="home.welcome.mainPage" /></a></li>
					<sec:authorize access="! isAuthenticated()">
						<li class="${current == 'login' ? 'active' : '' }"><a
							href="<spring:url value="/login" />"><spring:message
									code="home.welcome.Login" /></a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="<spring:url value="/logout" />"><spring:message
									code="home.welcome.Logout" /></a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li class="${current == 'userAccount' ? 'active' : '' }"><a
							href="<spring:url value="/account" />"><spring:message
									code="home.welcome.account" /></a></li>
					</sec:authorize>
					<sec:authorize access="! isAuthenticated()">
						<li class="${current == 'registerForm' ? 'active' : '' }"><a
							href="<spring:url value="/registration" />"><spring:message
									code="home.welcome.register" /></a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current == 'users' ? 'active' : '' }"><a
							href="<spring:url value="/users" />"><spring:message
									code="home.welcome.users" /></a></li>
					</sec:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="?language=pl"><spring:message
								code="home.welcome.polish" /></a></li>
					<li><a href="?language=en"><spring:message
								code="home.welcome.english" /></a></li>
				</ul>
			</div>
			<!--/.container-fluid -->
		</nav>
	</div>
	<!-- /container -->
</body>
</html>