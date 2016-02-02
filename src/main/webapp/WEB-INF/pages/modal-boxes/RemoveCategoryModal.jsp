<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="removeCategoryModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content text-center" id="removeCategoryModalContent">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Are You Sure To Remove</h4>
				<h4 id="categoryNameToRemove"></h4>
				<h4>Category</h4>
				<h4>?</h4>
				<br>
				<p>All tutorials under this category will bee lost</p>
			</div>
			<div class="modal-body row">
				<div class="col-md-8 col-md-offset-2">
					<form action="/PersonalTutorialsRepo/remove-category" method="POST">
						<input type="hidden" name="categoryPK" id="categoryPKHidden" /> <input
							type="submit" class="btn btn-danger removeCategoryModlaYesBtn"
							value="Yes" />
						<button type="button"
							class="btn btn-success removeCategoryModlaNoBtn"
							data-dismiss="modal">No</button>
					</form>

				</div>

			</div>
			<div class="modal-footer"></div>
		</div>

	</div>
</div>