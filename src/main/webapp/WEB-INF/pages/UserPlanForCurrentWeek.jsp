<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/Header.jsp"></jsp:include>


<div class="text-center">
	<p>Tutorials planned todo at this week:</p>
</div>

<input id="csrfTokenInput" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<hr>

<table class="table table-bordered">
	<thead>
		<tr>
			<td>tutorial</td>
			<td>author</td>
			<td>days left</td>
			<td>rating</td>
			<td>progress</td>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${tutorialsToDo}" var="tutorial">
			<tr>
				<td><a target="_blank" href="${tutorial.url}">${tutorial.title}</a></td>
				<td>${tutorial.author}</td>
				<td>${tutorial.daysLeft}</td>
				<td><span id="ratingOfTutorial${tutorial.id}">${tutorial.rating}</span>&nbsp;
					<button data-item-pk="${tutorial.id}"
						class="btn btn-primary incrementRatingBtn">+</button>&nbsp;
					<button data-item-pk="${tutorial.id}"
						class="btn btn-warning decrementRatingBtn">-</button></td>
				<td><span id="progressOfTutorial${tutorial.id}">${tutorial.progress}</span>&nbsp;%&nbsp;
					<button data-item-pk="${tutorial.id}"
						class="btn btn-primary incrementTutorialProgressBtn">+</button>&nbsp;
					<button data-item-pk="${tutorial.id}"
						class="btn btn-warning decrementTutorialProgressBtn">-</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script
	src="<c:url value="/resources/js/IncremetnDecremetRatingAndProgressOfTutorial.js" />"></script>
<jsp:include page="layout/Footer.jsp"></jsp:include>