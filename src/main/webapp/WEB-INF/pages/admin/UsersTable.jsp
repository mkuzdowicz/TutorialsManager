<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="text-center">
	<p class="text-primary">Application users</p>
</div>

<input id="csrfTokenInput" type="hidden" name="${_csrf.parameterName}"
	value="${_csrf.token}" />

<hr>

<table class="table table-bordered table-condensed">
	<thead>
		<tr>
			<td>userId</td>
			<td>login</td>
			<td>email</td>
			<td>type</td>
			<td>social sign in provider</td>
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
				<td>${u.signInProvider}</td>
				<td><form
						action="${pageContext.request.contextPath}/admin/users/remove"
						method="POST">
						<input type="hidden" name="userId" value="${u.userid}" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button class="btn btn-danger" type="submit">remove</button>
					</form></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

