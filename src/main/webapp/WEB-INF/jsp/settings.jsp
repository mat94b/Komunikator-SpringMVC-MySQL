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
<title>Ustawienia</title>
</head>
<body>


	<div class="registration_data_box">
		<div class="container">
			<form method="post" commandName="register" action="newset.html"
				class="form-signin">

				<h2 class="form-signin-heading">Ustawienia twojego konta:</h2>

				<div class="form-group">
					<input path="language" name="language" class="form-control"
						placeholder="Języki które znasz" />
				</div>
				<div class="alert alert-success" role="alert">
					<strong>Znasz Język/i: </strong> ${lang}
				</div>

				<div class="form-group">
					<input path="religion" name="religion" class="form-control"
						placeholder="Twoja religia" />
				</div>
				<div class="alert alert-warning" role="alert">
					<strong>Religia: </strong> ${rel}
				</div>
				<div class="form-group">
					<input path="livingCity" name="livingCity" class="form-control"
						placeholder="Miasto z którego jesteś" />
				</div>
				<div class="alert alert-info" role="alert">
					<strong>Aktualnie mieszkasz w: </strong> ${cit}
				</div>

				<div class="form-group">
					<input path="phone" name="telephone" class="form-control"
						placeholder="Twój telefon" />
				</div>
				<div class="alert alert-danger" role="alert">
					<strong>Aktualny telefon: </strong> ${pho}
				</div>
				<div class="form-group">
					<input path="des" name="desc" class="form-control"
						placeholder="Kilka slow o tobie" />
				</div>

				<div class="alert alert-success" role="alert">
					<strong>Aktualny opis: </strong> ${des}
				</div>
				<div class="form-group">
					<input type="submit" value="Zapisz"
						class="btn btn-lg btn-primary btn-block" />
				</div>

			</form>

				<form method="post" action="del">
					<input type="submit" value="Usun konto" />

				</form>
				<br> <br> <br>
				<br> <br> <br>
				<br> <br> <br>
				<br> <br> <br>
				<br> <br> <br>


			<jsp:include page="menuBottom.jsp" />
		</div>
</body>
</html>