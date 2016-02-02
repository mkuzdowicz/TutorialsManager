$(document).ready(function() {

	setNavigation();

});

function setNavigation() {
	var path = window.location.pathname;
	path = path.replace(/\/$/, "");
	path = decodeURIComponent(path);

	$(".nav a").each(function() {
		var href = $(this).attr('href');
		if (path.match(href)) {
			$(this).closest('li').addClass('active');
		}
	});
}