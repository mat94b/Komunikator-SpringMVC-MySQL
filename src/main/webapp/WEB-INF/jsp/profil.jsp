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
<title>Profil - ${tit}</title>
</head>
<body>
	<div class="container">
		<div class="col-sm-8 blog-main">

			<div class="blog-post">

				<blockquote>
					<p>M. S. B. &copy; 2015</p>
				</blockquote>

				<h2 class="blog-post-title">
					<span class="label label-primary">${tit}</span>
				</h2>
				<p class="blog-post-meta">
					<span class="label label-danger">${un}</span> | <span
						class="label label-success">${email}</span>
				</p>

				<div class="alert alert-success" role="alert">
					<strong>Język/i: </strong> ${lang}
				</div>
				<div class="alert alert-warning" role="alert">
					<strong>Religia: </strong> ${religion}
				</div>
				<div class="alert alert-info" role="alert">
					<strong>Miasto: </strong> ${city}
				</div>
				<div class="alert alert-danger" role="alert">
					<strong>Telefon: </strong> ${phone}
				</div>

				<div class="alert alert-success" role="alert">
					<strong>O mnie: </strong> ${des}
				</div>

			</div>
			<!-- /.blog-post -->


		</div>
		<!-- /.blog-main -->
		<div class="col-sm-3 col-sm-offset-1 blog-sidebar">

			<div class="sidebar-module sidebar-module-inset">

				<h4>Statystyki:</h4>
				<p>
					<strong>Wyslane wiadomosci: </strong><em>${sendM}</em><br>
					<strong>Odebrane wiadomosci: </strong><em>${recievedM}</em><br>
					<strong>Rejestracia: </strong><em>${registraionDate}</em><br>
					<strong>Ostatnio online: </strong><em>${lastOnline}</em><br>
					<strong>Ilość kontaktów: </strong><em>${contactAmound}</em><br><br>
					<strong>Uzytkownikow: </strong><em>${registeredPeople}</em><br>
					<strong>Osob z twoim imieniem: </strong><em>${sameName}</em><br>
					<strong>Roznych emaili oraz imion: </strong><em>${creative}</em><br>
					<strong>ID: </strong><em>${id}</em><br>
					
				</p>
			</div>
		</div>


		<jsp:include page="menuBottom.jsp" />
	</div>


</body>
</html>