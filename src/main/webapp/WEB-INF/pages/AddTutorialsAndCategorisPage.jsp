<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
	<div id="addTutorialForm" class="col-md-4 col-md-offset-1">
		<h3>Add new tutorial</h3>
		<br>
		<form class="form form-horizontal"
			action="/TutorialsManager/user/add-tutorial" method="POST">

			<div class="form-group">
				<label>category</label> <select name="categoryId"
					class="form-control">
					<c:forEach items="${categories}" var="cat">
						<option value="${cat.categoryId}">${cat.categoryName}</option>
					</c:forEach>
				</select>

			</div>


			<div class="form-group">
				<label>url</label><input type="url" name="url" class="form-control"
					required="required" />
			</div>

			<div class="form-group">
				<label>start date todo</label> <input
					class="datepicker form-control" id="startDateToDo"
					name="startDateToDo" />
			</div>
			<div class="form-group">
				<label>end date todo</label><input id="startDateToDo"
					name="startDateToDo" class="datepicker form-control" />
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<div class="form-group text-center">
				<input type="submit" class="btn btn-success" value="add tutorial" />
			</div>

		</form>

	</div>


	<div id="addTutorialForm" class="col-md-4 col-md-offset-1">
		<h3>Add new category</h3>
		<br>
		<form class="form form-horizontal"
			action="/TutorialsManager/user/add-category" method="POST">

			<div class="form-group">
				<label>category</label> <input type="text" name="categoryName"
					class="form-control" required="required" />
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<div class="form-group text-center">
				<input type="submit" class="btn btn-success" value="add category" />
			</div>

		</form>

	</div>
</div>

<script src="<c:url value="/resources/js/DatePickerInitAndConfig.js" />"></script>
