<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="controlers.IndexControllers"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${titleM}</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/theme/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/theme/css/styles.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>


	<div class="container">

		<form class="navbar-form navbar-left" role="search" method="post"  action="contactExact.html">
			<div class="form-group">
				<input type="text" name="key"class="form-control" placeholder="Uzytkownik">
			</div>
			<button type="submit" class="btn btn-default">Wyszukaj</button>
		</form>
<br><br>
<br><br>
		<c:forEach items="${contactArray}" var="contact">
			<div class="panel panel-default">
				<div class="panel-heading">${contact.name}
					${contact.surname}
					<c:if test="${contact.isFavorite == 1}">

						<span class="label label-primary">Favorite!</span>
					</c:if>
				</div>
				<div class="panel-body">
					<div class="bolded_text">Pseudonim:</div>
					${contact.nickname}
				</div>
				<div class="panel-body">
					<div class="bolded_text">E-mail:</div>
					${contact.em}
				</div>
				<div class="panel-body">
					<div class="bolded_text">Znajomi od:</div>
					${contact.addDay}
				</div>
				<div class="panel-body">
					<div class="bolded_text">Telefon:</div>
					${contact.tel}
				</div>

				<c:if test="${contact.isFavorite == 1}">
					<div class="panel-body">

						<input type="button" value="Zwykly znajomy">
					</div>
				</c:if>

				<c:if test="${contact.isFavorite == 0}">
					<div class="panel-body">
						<input type="button" onclick="location.href='accoundfav.html'"
							value="Dodaj do ulubionych">
					</div>
				</c:if>

			</div>
		</c:forEach>

		<jsp:include page="menuBottom.jsp" />

	</div>







</body>
</html>