<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wyszukano - ${tit}</title>
</head>
<body>

	<div class="container">
	
	
		<form class="navbar-form navbar-left" role="search" method="post"  action="key.html">
			<div class="form-group">
				<input type="text" name="key"class="form-control" placeholder="Slowo kluczowe">
			</div>
			<button type="submit" class="btn btn-default">Wyszukaj</button>
		</form>
<br><br>

		<c:forEach items="${messageHolder}" var="message">
			<br>
			<div class="list-group">
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading active">
						@<em>${message.sendingUser}</em> - <strong>${message.messageTitle}</strong>
						<h4 class="list-group-item-heading pull-right">
							<span class="label label-primary"> <em>Wyslano: </em><strong>${message.messageDate}</strong></span>

						</h4>

					</h4>
					<p class="list-group-item-text">
					<div class="panel-body">
						<p>${message.messageText}</p>
					</div>



				</a>
			</div>
		</c:forEach>


	</div>
	<jsp:include page="menuBottom.jsp" />
	</div>
</body>
</html>