<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${registerTitleMessage}</title>
</head>
<body>
	<div class="registration_data_box">
		<div class="container">
			<form method="post" commandName="register" action="registration.html"
				class="form-signin">

				<h2 class="form-signin-heading">Tworzenie nowego konta:</h2>

				<div class="form-group">
					<input path="fname" name="name" class="form-control"
						placeholder="Imię" />
				</div>
				<div class="form-group">
					<input path="lname" name="lastname" class="form-control"
						placeholder="Nazwisko" />
				</div>

				<div class="form-group">
					${nicknameExist} <input path="uname" name="nickname"
						class="form-control" placeholder="Nickname" />
				</div>

				<div class="form-group">
					${emailExist} <input path="uname" name="emailadress"
						class="form-control" placeholder="E-mail" />
				</div>

				<div class="form-group">
					<input type="password" path="password" name="password"
						class="form-control" placeholder="Hasło" />
				</div>

				<div class="form-group">
					<input path="password" name="cellphone" class="form-control"
						placeholder="Telefon" />
				</div>

				<div class="form-group">
					<input path="password" name="city" class="form-control"
						placeholder="Miasto" />
				</div>

				<div class="form-group">
					<input type="submit" value="Zarejestruj"
						class="btn btn-lg btn-primary btn-block" />
				</div>
			</form>
		</div>

	</div>












	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</body>
</html>