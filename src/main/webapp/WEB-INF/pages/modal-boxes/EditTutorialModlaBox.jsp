<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						action="/PersonalTutorialsRepo/edit-tutorial" method="POST">

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
							<label>url</label><input id="editFormTutorialUrl" type="text"
								name="url" class="form-control" />
						</div>
						<div class="form-group">
							<label>serviceDomain</label> <input
								id="editFormTutorialServiceDomain" type="text"
								name="serviceDomain" class="form-control" />
						</div>
						<div class="form-group">
							<label>rating</label> <input id="editFormTutorialRating"
								type="number" name="rating" class="form-control" />
						</div>
						<div class="form-group">
							reworkedInPercents<input id="editFormTutorialReworkedInPercents"
								type="number" name="reworkedInPercents" class="form-control" />
						</div>
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