<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/Header.jsp"></jsp:include>

<br>
<br>
<ul class="list-group">
	<c:forEach items="${catList}" var="cat">
		<li class="list-group-item"><a
			href="/PersonalTutorialsRepo/category?name=${cat}">${cat}</a>&nbsp;</li>
	</c:forEach>
</ul>

<hr>

<c:set value="${selectedCategory.tutorials}"
	var="selectedCategoryTutorials" />

<c:set value="${selectedCategory.tutorials.size()}"
	var="selectedCategoryTutorialsCount" />

<p>
	selected category: <strong>${selectedCategory.categoryName}</strong>
</p>
<p>
	tutorials count in category: <strong>${selectedCategoryTutorialsCount}</strong>
</p>

<table class="table table-bordered">
	<thead>
		<tr>
			<td>title</td>
			<td>author</td>
			<td>serviceDomain</td>
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
				<td>${tutorial.rating}</td>
				<td>${tutorial.reworkedInPercents}</td>
				<td><button class="btn btn-warning editBtn"
						id="edit${tutorial.id}" data-item-id="${tutorial.id}">edit</button>
					<button class="btn btn-danger removeBtn" id="remove${tutorial.id}"
						data-item-id="${tutorial.id}">remove</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div id="result"></div>
<script>
	var editBtns = $('.editBtn');

	var removeBtns = $('.removeBtn');

	editBtns.click(function() {

		var clickedItemId = $(this).data('item-id');

		$.ajax({
			url : '/PersonalTutorialsRepo/edit-tutorial',
			type : 'POST',
			data : {
				id : clickedItemId
			},
			success : function(result) {

				console.log(result);

				$("#result").html(result);
			}
		});

	});

	removeBtns.click(function() {

		var clickedItemId = $(this).data('item-id');

		$.ajax({
			url : '/PersonalTutorialsRepo/remove-tutorial',
			type : 'POST',
			data : {
				id : clickedItemId
			},
			success : function(result) {

				console.log(result);

				$("#result").html(result);
			}
		});

	});
</script>

<jsp:include page="layout/Footer.jsp"></jsp:include>