<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="removeTutorialModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content text-center" id="removeTutorialModalContent">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Are You Sure To Remove</h4>
				<h4 id="tutorialTitle"></h4>
			</div>
			<div class="modal-body row">
				<div class="col-md-8 col-md-offset-2">
					<form action="/PersonalTutorialsRepo/remove-tutorial" method="POST">
						<input type="hidden" name="tutorialId" id="tutorialIdHidden" /> <input
							type="submit" class="btn btn-danger removeModlaYesBtn"
							value="Yes" />
						<button type="button" class="btn btn-success removeModlaNoBtn"
							data-dismiss="modal">No</button>
					</form>

				</div>

			</div>
			<div class="modal-footer"></div>
		</div>

	</div>
</div>