<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row text-center">
	<div class="col-xs-8 col-xs-offset-2">
		<div class="text-center">
			<form name="loginForm" action="/TutorialsManager/login" method="POST">

				<div class="form-group">
					<label>User</label> <input class="form-control" type="text"
						name="username" />
				</div>

				<div class="form-group">
					<label>Password</label> <input class="form-control" type="password"
						name="password" />
				</div>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="form-group">
					<input class="btn btn-success" name="submit" type="submit"
						value="Login" />
				</div>

			</form>
		</div>

		<br /> <a href="/TutorialsManager/create-account"><button
				class="btn">create-account</button></a> <a
			href="${pageContext.request.contextPath}/auth/facebook"><button
				class="btn btn-primary">sign in with facebook</button></a> <a
			href="${pageContext.request.contextPath}/auth/twitter"><button
				class="btn btn-info">sign in with twitter</button></a>

	</div>
</div>