//javascript code for take a tour
var tour = new Tour(
		{
			name : "tour",
			steps : [
					{
						element : "#currentSection",
						title : "User Input Section",
						content : "This part is used to take input numbers from the user and to display those numbers in sorted way along with processing time and number of places swaped.",
						placement : "right",

					},
					{
						element : "#historicSection",
						title : "Previous Results Section",
						content : "This part displays all previous inputs and the processed results. Please refresh the page for updating the result in this section",
						placement : "left",
						onShow : function(tour) {
							$("#starttour").prop("disabled", true);
						},
						onHide : function(tour) {
							$("#starttour").prop("disabled", false);
						},
					} ],
			container : "body",
			keyboard : true,
			storage : window.localStorage,
			debug : true,
			backdrop : true,
			backdropContainer : 'body',
			redirect : true,
			orphan : false,

			basePath : "",
			template : "<div class='popover tour'>"
					+ "<div class='arrow'></div>"
					+ "<h3 class='popover-title' style='font-weight:bold;'></h3>"
					+ "<div class='popover-content'></div>"
					+ "<div class='popover-navigation'>"
					+ "<button class='btn btn-primary btn-xs' data-role='prev'>&#8810 Prev</button>"
					+ "&nbsp;&nbsp&nbsp;"
					+ "<button class='btn btn-primary btn-xs' data-role='next'>Next &#8811</button>"
					+ "<button class='btn btn-danger btn-xs' data-role='end'>End tour</button>"
					+ "</div>" + "</div>",
		});

$("#starttour").click(function() {
	if (tour.ended()) {
		tour.restart();
	} else {
		tour.init();
		tour.start();
	}
});
// javascript code for take a tour ends here
