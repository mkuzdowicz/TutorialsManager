<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="text-center">
	<p class="text-primary">Application users</p>
</div>

<input id="csrfTokenInput" type="hidden" name="${_csrf.parameterName}"
	value="${_csrf.token}" />

<hr>

<table class="table table-bordered">
	<thead>
		<tr>
			<td>userId</td>
			<td>login</td>
			<td>email</td>
			<td>type</td>
			<td>actions</td>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userid}</td>
				<td>${u.username}</td>
				<td>${u.email}</td>
				<td>${u.type}</td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

