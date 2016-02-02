$(document).ready(
		function() {

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

						console.log(tutorialEditDto);

						$('#editFormCategoryName').val(
								tutorialEditDto.categryName);
						$('#editFormTutorialTitle').val(tutorialEditDto.title);
						$('#editFormTutorialAuthor')
								.val(tutorialEditDto.author);

						$('#editFormTutorialUrl').val(tutorialEditDto.url);
						$('#editFormTutorialRating')
								.val(tutorialEditDto.rating);
						$('#editFormTutorialReworkedInPercents').val(
								tutorialEditDto.reworkedInPercents);
						$('#editFormTutorialId').val(tutorialEditDto.id);
						$('#startDateToDo').val(tutorialEditDto.startDateToDo);
						$('#endDateToDo').val(tutorialEditDto.endDateToDo);

					},
					error : function(request, status, error) {
						alert(request.responseText);
					}
				});

				$('#editTutorialModal').modal('show');

			});

		});
