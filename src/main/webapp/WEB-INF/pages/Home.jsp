<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal Tutorials Repository</title>
</head>
<body>

	<p>Hello to PersonalToutorialsRepo</p>
	<hr>
	<ul>
		<c:forEach items="${tutorialList}" var="tutorial">

			<li>${tutorial}</li>

		</c:forEach>

	</ul>

</body>
</html>