<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Modal -->
<div class="modal fade" id="editTutorialModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">edit tutorial</h4>
			</div>
			<div class="modal-body row">
				<div class="col-md-8 col-md-offset-2">
					<form class="form form-horizontal"
						action="/TutorialsManager/user/edit-tutorial" method="POST">

						<input id="editFormTutorialId" type="hidden" name="id"
							class="form-control" />

						<div class="form-group">
							<label>category</label> <input id="editFormCategoryName"
								type="text" name="category" class="form-control" />
						</div>
						<div class="form-group">
							<label>title</label> <input id="editFormTutorialTitle"
								type="text" name="title" class="form-control" />
						</div>
						<div class="form-group">
							<label>author</label> <input id="editFormTutorialAuthor"
								type="text" name="author" class="form-control" />
						</div>
						<div class="form-group">
							<label>url</label><input id="editFormTutorialUrl" type="url"
								name="url" class="form-control" />
						</div>
						<div class="form-group">
							<label>start date todo</label> <input
								class="datepicker form-control" id="startDateToDo"
								name="startDateToDo" />
						</div>
						<div class="form-group">
							<label>end date todo</label><input id="endDateToDo"
								name="endDateToDo" class="datepicker form-control" />
						</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div class="form-group">
							<input type="submit" class="btn btn-success"
								value="accept changes" />
						</div>


					</form>

				</div>

			</div>
			<div class="modal-footer"></div>
		</div>

	</div>
</div>
<script src="<c:url value="/resources/js/DatePickerInitAndConfig.js" />"></script>