<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<style>
</style>
<body>

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
	<tilesx:useAttribute name="current" id="current"
		classname="java.lang.String" ignore="true" scope="request" />

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="#"><strong><spring:message
								code="home.welcome.mainMenu" /></strong></a></li>
				<li class="${current == 'latestBooks' ? 'active' : '' }"><a
					href="<spring:url value="/books/latest" />"><spring:message
							code="layout.menu.latestBooks" /></a></li>
				<li class="${current == 'books' ? 'active' : '' }"><a
					href="<spring:url value="/books" />"><spring:message
							code="layout.menu.allBooks" /></a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="${current == 'addBook' ? 'active' : '' }"><a
						href="<spring:url value="/books/add" />"><spring:message
								code="layout.menu.addBook" /></a></li>
				</sec:authorize>
				<li class="${current == 'authors' ? 'active' : '' }"><a
					href="<spring:url value="/authors" />"><spring:message
							code="layout.menu.authors" /></a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="${current == 'addAuthor' ? 'active' : '' }"><a
						href="<spring:url value="/authors/addAuthor" />"><spring:message
								code="layout.menu.addAuthor" /></a></li>
				</sec:authorize>
				<li class="${current == 'categories' ? 'active' : '' }"><a
					href="<spring:url value="/categories" />"><spring:message
							code="layout.menu.categories" /></a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="${current == 'addCategory' ? 'active' : '' }"><a
						href="<spring:url value="/categories/addCategory" />"><spring:message
								code="layout.menu.addCategory" /></a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
</body>
</html>