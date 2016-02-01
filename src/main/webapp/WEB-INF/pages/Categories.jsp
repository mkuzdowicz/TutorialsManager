<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/Header.jsp"></jsp:include>

<p>Select a category</p>
<ul class="list-group">
	<c:forEach items="${catList}" var="cat">
		<li class="list-group-item text-center"><a
			href="/PersonalTutorialsRepo/category?name=${cat}">${cat}</a>&nbsp;</li>
	</c:forEach>
</ul>

<hr>

<c:set value="${selectedCategory.tutorials}"
	var="selectedCategoryTutorials" />

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
			<td>title</td>
			<td>author</td>
			<td>serviceDomain</td>
			<td>url</td>
			<td>period to work on</td>
			<td>rating</td>
			<td>reworkedInPercents</td>
			<td>actions</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${selectedCategoryTutorials}" var="tutorial">
			<tr>
				<td>${tutorial.title}</td>
				<td>${tutorial.author}</td>
				<td>${tutorial.serviceDomain}</td>
				<td>${tutorial.url}</td>
				<td>from: <fmt:formatDate pattern="dd-MM-yyyy"
						value="${tutorial.startDateToDo}" /> <br>
				to: <fmt:formatDate pattern="dd-MM-yyyy" value="${tutorial.endDateToDo}" /></td>
				<td>${tutorial.rating}</td>
				<td>${tutorial.reworkedInPercents}</td>
				<td><button class="btn btn-warning editBtn"
						id="edit${tutorial.id}" data-item-id="${tutorial.id}">edit</button>

					<button class="btn btn-danger removeBtn" id="edit${tutorial.id}"
						data-item-id="${tutorial.id}" data-item-title="${tutorial.title}">remove</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="modal-boxes/EditTutorialModlaBox.jsp" />
<jsp:include page="modal-boxes/RemoveTutorialModal.jsp" />

<script>
	var editBtns = $('.editBtn');
	var removeBtns = $('.removeBtn');

	removeBtns.click(function() {

		var clickedItemId = $(this).data('item-id');

		var clickedItemTitle = $(this).data('item-title');

		$('#tutorialIdHidden').val(clickedItemId);

		$('#tutorialTitle').text(clickedItemTitle);

		$('#removeTutorialModal').modal('show');

	});

	editBtns.click(function() {

		var clickedItemId = $(this).data('item-id');

		$.ajax({
			url : '/PersonalTutorialsRepo/edit-tutorial-show-form',
			type : 'POST',
			data : {
				id : clickedItemId
			},
			success : function(tutorialEditDto) {

				$('#editFormCategoryName').val(tutorialEditDto.categryName);
				$('#editFormTutorialTitle').val(tutorialEditDto.title);
				$('#editFormTutorialAuthor').val(tutorialEditDto.author);

				$('#editFormTutorialUrl').val(tutorialEditDto.url);
				$('#editFormTutorialServiceDomain').val(
						tutorialEditDto.serviceDomain);
				$('#editFormTutorialRating').val(tutorialEditDto.rating);
				$('#editFormTutorialReworkedInPercents').val(
						tutorialEditDto.reworkedInPercents);
			},
			error : function(request, status, error) {
				alert(request.responseText);
			}
		});

		$('#editTutorialModal').modal('show');

	});

	// ---------------------------------------
</script>

<jsp:include page="layout/Footer.jsp"></jsp:include>