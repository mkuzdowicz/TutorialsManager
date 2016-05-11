<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/Header.jsp"></jsp:include>

<input id="csrfTokenInput" type="hidden" name="${_csrf.parameterName}"
	value="${_csrf.token}" />


<p>Select a category</p>
<ul class="list-group">
	<c:forEach items="${catList}" var="cat">
		<li class="list-group-item text-center">
			<h4>
				<a
					href="/TutorialsManager/user/all-categories?categoryId=${cat.categoryId}">
					${cat.categoryName}</a> <span data-category-pk="${cat.categoryId}"
					data-category-name="${cat.categoryName}"
					class="btn btn-danger pull-right removeCategoryBtn">&times;</span>
			</h4>
		</li>
	</c:forEach>
</ul>

<hr>

<c:set value="${selectedCategory.tutorials}"
	var="selectedCategoryTutorials" />
<c:set value="${selectedCategory.categoryId}" var="selectedCategoryId" />
<c:set value="${selectedCategory.tutorials.size()}"
	var="selectedCategoryTutorialsCount" />

<div class="text-center">
	<p>
		selected category: <strong>${selectedCategory.categoryName}</strong>
	</p>
	<p>
		tutorials count in category: <strong>${selectedCategoryTutorialsCount}</strong>
	</p>
</div>

<table class="table table-bordered">
	<thead>
		<tr>
			<td>tutorial</td>
			<td>author</td>
			<td>serviceDomain</td>
			<td>period to work on</td>
			<td>rating</td>
			<td>progress</td>
			<td>actions</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${selectedCategoryTutorials}" var="tutorial">
			<tr>
				<td><a target="_blank" href="${tutorial.url}">${tutorial.title}</a></td>
				<td>${tutorial.author}</td>
				<td>${tutorial.serviceDomain}</td>
				<td class="text-center"><table>
						<tr>
							<td>from:&nbsp;</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${tutorial.startDateToDo}" /></td>
						</tr>
						<tr>
							<td>to:&nbsp;</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${tutorial.endDateToDo}" /></td>
						</tr>
					</table></td>
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
				<td><button class="btn btn-warning editBtn"
						id="edit${tutorial.id}" data-item-id="${tutorial.id}">edit</button>

					<button class="btn btn-danger removeBtn" id="edit${tutorial.id}"
						data-item-id="${tutorial.id}" data-item-title="${tutorial.title}">remove</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="modal-boxes/EditTutorialModlaBox.jsp" />
<jsp:include page="modal-boxes/RemoveTutorialModal.jsp" />
<jsp:include page="modal-boxes/RemoveCategoryModal.jsp" />

<script src="<c:url value="/resources/js/CategoriesPage.js" />"></script>
<script
	src="<c:url value="/resources/js/IncremetnDecremetRatingAndProgressOfTutorial.js" />"></script>
<jsp:include page="layout/Footer.jsp"></jsp:include>