$(document).ready(function() {

	var incrementRatingBtn = $('.incrementRatingBtn');

	var decrementRatingBtn = $('.decrementRatingBtn');

	var incrementTutorialProgressBtn = $('.incrementTutorialProgressBtn');

	var decrementTutorialProgressBtn = $('.decrementTutorialProgressBtn');

	incrementRatingBtn.click(function() {

		var clickedItemPk = $(this).data('item-pk');
		$('#ratingOfTutorial' + clickedItemPk).text('sdfsdfs');
	})

	decrementRatingBtn.click(function() {
		var clickedItemPk = $(this).data('item-pk');
		$('#ratingOfTutorial' + clickedItemPk).text('sdfsdfs');
	})

	incrementTutorialProgressBtn.click(function() {
		var clickedItemPk = $(this).data('item-pk');
		$('#progressOfTutorial' + clickedItemPk).text('sdfsdfs');
	})

	decrementTutorialProgressBtn.click(function() {
		var clickedItemPk = $(this).data('item-pk');
		$('#progressOfTutorial' + clickedItemPk).text('sdfsdfs');
	})

});