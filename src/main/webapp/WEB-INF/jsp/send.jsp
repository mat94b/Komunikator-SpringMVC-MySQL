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
	<br>
	<div class="container">
		<form class="form-horizontal" role="form" method="post"
			action="sent.php">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Nazwa</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name"
						name="adressContact" placeholder="Nazwa" value="">
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Tytul</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name"
						name="titleOfTheMessage" placeholder="Nazwa" value="">
				</div>
			</div>


			<div class="form-group">
				<label for="message" class="col-sm-2 control-label">Text</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="4" name="messageText"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10 col-sm-offset-2">
					<input id="submit" name="submit" type="submit" value="Send"
						class="btn btn-primary">
				</div>
			</div>
		</form>


		<jsp:include page="menuBottom.jsp" />
	</div>


</body>
</html>