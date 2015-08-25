var RestAppModule = angular.module('restApp', ['ngRoute','ui.bootstrap']);

	// configure our routes
RestAppModule.config(function($routeProvider) {
		$routeProvider
		
		// Default Route
		.when('/', {
			templateUrl : 'Views/FrontPage.html',
			
		})
			// route for the home page
			.when('/Home', {
				templateUrl : 'Views/FrontPage.html',
				
		})

			// route for the login page
			.when('/login', {
				templateUrl : 'Views/Login.html',
				controller  : 'LoginController'
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
			})
			.when('/admin/:reservation_id/:no_of_people', {
				templateUrl : 'Views/ReservView.html',
				controller  : 'AdminController'
			})
		.when('/admin', {
			templateUrl : 'Views/Admin.html',
			controller  : 'AdminController'
		});
	});

	