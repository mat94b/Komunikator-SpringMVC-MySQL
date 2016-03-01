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
<title>${indexTitleMessage}</title>


<body>
<!-- HEADER START HERE -->
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<a class="navbar-brand" href="index.html">M. S. B. Komunikator
				&copy; 2015</a>
			<form method="post" commandName="acc" action="login.html"
				class="navbar-form navbar-right">
				<div class="form-group">
					<input path="username" name="username"
						placeholder="Nickname lub e-mail" class="form-control" />
				</div>
				<div class="form-group">
					<input type="password" path="password" name="password"
						placeholder="Haslo" class="form-control" />
				</div>
				<input type="submit" value="Zaloguj" class="btn btn-success" />
			</form>
		</div>
	</div>
<!-- HEADER ENDS HERE -->

<c:if test="${doneRegistration}">
<div class="alert alert-success" role="alert"><center><b>Dobra robota!</b> Nowe konto zostało pomyślnie utworzone, możesz się zalogować.</center></div>
</c:if>

<!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Witaj,</h1>
        <p>Ta strona to świetne miejsce abyś poznał nowych znajomych. Wymieniaj wiadomości z kim chcesz i kiedy chcesz bez żadnych ograniczeń ani kontroli!</p>
        <p><a class="btn btn-primary btn-lg" href="register.html" role="button">Zarejestruj się już teraz! &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Bezpieczeństwo</h2>
          <p>Korzystając z tego komunikatora możesz być pewny/a, że wiadomości które w tajemnicy chcesz przesłac swoim znajomym będą przeczytane tylko przez nich.</p>
        </div>
        <div class="col-md-4">
          <h2>Prywatność</h2>
          <p>M. S. B. gwarantuje 100% prywatności. Twoje wiadomości nie są archiwizowane przez nasze serwery. Twoje zaufanie to priorytet dla M. S. B.</p>
       </div>
        <div class="col-md-4">
          <h2>Darmowy</h2>
          <p>M. S. B. jest w pełni darmowy. Korzystaj ile chcesz i kiedy chcesz całkowicie za darmo!</p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; 2015 Bazy Danych - Projekt Zaliczeniowy, M. S. B.</p>
      </footer>
    </div> <!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>


</body>
</html>