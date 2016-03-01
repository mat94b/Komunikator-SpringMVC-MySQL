<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="controlers.IndexControllers"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>NIEPOWODZENIE W WYSZUKIWANIU</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/theme/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/theme/css/styles.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>

	<meta HTTP-EQUIV="Refresh" CONTENT="4; URL=profile">
	<div class="container">

		<div class="jumbotron">
			<h1>BLAD!</h1>
			<p>Nie odnaleziono uzytkownika! Mozliwe ze wpisales bledny nick.</p>
		</div>

		<jsp:include page="menuBottom.jsp" />
	</div>







</body>
</html>