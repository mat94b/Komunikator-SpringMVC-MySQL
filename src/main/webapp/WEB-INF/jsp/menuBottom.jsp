<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="controlers.IndexControllers"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/theme/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/theme/css/styles.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-bottom">
	<div class="container">
		<ul class="nav nav-pills" role="tablist">
			<li role="presentation" class="active"><a href="c">Kontakty<span
					class="badge">${contactAmound}</span></a></li>
			<li role="presentation"><a href="profile">Profil</a></li>
			<li role="presentation"><a href="message">Wiadomosci</a></li>
			<li role="presentation"><a href="s">Wyslij</a></li>
			<li role="presentation"><a href="sett">Ustawienia profilu</a></li>
			<div class="row">
				<form role="form" method="post" action="find">
					<div class="col-lg-6">
						<div class="input-group">

							<input type="text" class="form-control" name="findThisPerson"
								placeholder="Wyszukaj uzytkownika, wpisujac jego nazwe...">
							<span class="input-group-btn"> <input
								class="btn btn-default" type="submit" value="Szukaj!">
							</span> </input>

						</div>
						<!-- /input-group -->
					</div>
				</form>
				<!-- /.col-lg-6 -->
				<p class="navbar-text navbar-right"><li role="presentation"><a href="lo">Wyloguj</a></li>
					Zarejestrowano jako: <a href="profile" class="navbar-link">${nameAndSurname}</a>
				</p>
		</ul>
	</div>
	</nav>
</body>
</html>