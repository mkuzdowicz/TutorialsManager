<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/Header.jsp"></jsp:include>


<div class="text-center">
	<p>Tutorials planned todo at this week:</p>
</div>

<hr>

<table class="table table-bordered">
	<thead>
		<tr>
			<td>tutorial</td>
			<td>author</td>
			<td>days left</td>
			<td>rating</td>
			<td>reworkedInPercents</td>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${tutorialsToDo}" var="tutorial">
			<tr>
				<td><a target="_blank" href="${tutorial.url}">${tutorial.title}</a></td>
				<td>${tutorial.author}</td>
				<td>${tutorial.daysLeft}</td>
				<td>${tutorial.rating}</td>
				<td>${tutorial.reworkedInPercents}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/Footer.jsp"></jsp:include>