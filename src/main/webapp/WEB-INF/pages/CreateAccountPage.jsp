<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form class="form-horizontal" method="post"
	commandName="createAccountForm"
	action="/TutorialsManager/create-account" name="createAccountForm">

	<div class="form-group">
		<label class="col-sm-2 control-label">login</label>
		<div class="col-sm-10">
			<form:input path="login" class="form-control" placeholder="login" />
			<form:errors path="login" class="control-label" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">password</label>
		<div class="col-sm-10">
			<form:input path="password" class="form-control"
				placeholder="password" type="password" />
			<form:errors path="password" class="control-label" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">confirm password</label>
		<div class="col-sm-10">
			<form:input path="confirmPassword" class="form-control"
				placeholder="confirm Password" type="password" />
			<form:errors path="confirmPassword" class="control-label" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input class="btn btn-success btn-block" type="submit"
				value="create account" />
		</div>
	</div>

	<c:if test="${errorMsg ne null}">
		<h2 class="alert alert-danger text-center">${errorMsg}</h2>
	</c:if>

	<c:if test="${successMsg ne null}">
		<h2 class="alert alert-success text-center">${successMsg}</h2>
	</c:if>

</form:form>