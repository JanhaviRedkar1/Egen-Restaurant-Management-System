var RestAppModule = angular.module('restApp', ['ngRoute','ui.bootstrap']);

	// configure our routes
RestAppModule.config(function($routeProvider) {
		$routeProvider
		
		// Default Route
		.when('/', {
			templateUrl : 'Views/FrontPage.html',
			controller  : 'CarouselController'
		})
			// route for the home page
			.when('/Home', {
				templateUrl : 'Views/FrontPage.html',
				controller  : 'CarouselController'
		})

			// route for the login page
			.when('/login', {
				templateUrl : 'Views/Admin.html',
				controller  : 'AdminController'
			})
			// route for the Editing Reservation page
			.when('/editReserve', {
				templateUrl : 'Views/EditReservation.html',
				controller  : 'ReservationController'
			})
			
			// route for the Deleting reservation
			.when('/cancelReserve', {
				templateUrl : 'Views/CancelReservation.html',
				controller  : 'ReservationController'
			})
			// route for adding Reservation
			.when('/addReserve', {
				templateUrl : 'Views/AddReservation.html',
				controller  : 'ReservationController'
			});
	});

	