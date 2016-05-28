<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal Video Tutorials Repository & Learning time
	management</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker.min.css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/main.css" />">
</head>
<body>
	<div class="container-fluid">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div id="navHeader" class="navbar-header">
					<a class="navbar-brand" href="/TutorialsManager/">home</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="/TutorialsManager/user/all-categories">tutorials</a></li>
					<li><a href="/TutorialsManager/user/add-tutorial">add new</a></li>
					<li><a href="/TutorialsManager/user/tutorials-to-do">your
							plan for this week</a></li>
					<li><a href="/TutorialsManager/create-account">create-account</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="pull-right">
						<form action="/TutorialsManager/logout" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input class="btn" type="submit"
								value="logout" />
						</form>
					</li>
					<li class="pull-right"><a class="btn"
						href="/TutorialsManager/login">login</a></li>
					<li><a href="${pageContext.request.contextPath}/auth/facebook"><button
								class="btn btn-primary">sign in with facebook</button></a></li>

					<li><a href="${pageContext.request.contextPath}/auth/twitter"><button
								class="btn btn-info">sign in with twitter</button></a></li>
				</ul>

			</div>
		</nav>
		<header class="text-center">
			<sec:authorize access="isAuthenticated()">
				<h3 class="pull-right">
					welcome
					<sec:authentication property="principal.username" />
				</h3>
			</sec:authorize>
			<h1>Personal Tutorials Repository & Learning time management</h1>
		</header>
		<hr>

		<!-- CONTENT BEGIN -->

		<sitemesh:write property='body' />

		<!-- CONTENT END -->

		<script src="<c:url value="/resources/js/main.js" />"></script>
		<footer>
			<hr>
			<div class="text-center">
				author:&nbsp;
				<spring:message code="author" />
				&nbsp;&nbsp;&nbsp;&nbsp; version:&nbsp;
				<spring:message code="version" />

			</div>
		</footer>

	</div>
</body>
</html>