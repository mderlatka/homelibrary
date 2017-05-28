<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style>
body {
	margin: 0 auto;
	padding: 0;
}
</style>
</head>
<body>

	<div class="container">
		<tiles:insertAttribute name="header" />
		<br>
		<div class="row">
			<div class="col-lg-2">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-lg-10">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<br> <br>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>