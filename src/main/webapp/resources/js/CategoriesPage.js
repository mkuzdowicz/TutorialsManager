var CSRF_TOKEN_VAL;

$(document).ready(
		function() {

			var editBtns = $('.editBtn');
			var removeBtns = $('.removeBtn');
			CSRF_TOKEN_VAL = $('#csrfTokenInput').val();

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
					url : '/TutorialsManager/user/edit-tutorial-show-form',
					type : 'POST',
					data : {
						id : clickedItemId,
						_csrf : CSRF_TOKEN_VAL
					},
					success : function(tutorialEditDto) {

						console.log(tutorialEditDto);
						$('#categorySelectBox').val(
								tutorialEditDto.category.categoryId);
						$('#editFormTutorialTitle').val(tutorialEditDto.title);
						$('#editFormTutorialAuthor')
								.val(tutorialEditDto.author);

						$('#editFormTutorialUrl').val(tutorialEditDto.url);
						$('#editFormTutorialRating')
								.val(tutorialEditDto.rating);
						$('#editFormTutorialReworkedInPercents').val(
								tutorialEditDto.progress);
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

			var removeCategoryBtn = $('.removeCategoryBtn');

			removeCategoryBtn.click(function() {

				var categoryPk = $(this).data('category-pk');
				var categoryName = $(this).data('category-name');
				$('#categoryPKHidden').val(categoryPk);
				$('#categoryNameToRemove').text(categoryName);
				$('#removeCategoryModal').modal('show');

			})

		});
