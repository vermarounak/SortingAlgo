'use strict';

define([ 'routeResolver' ], function() {

	var app = angular.module('myApp', [ 'ngResource', 'ui.bootstrap',
			'ngRoute', 'routeResolverServices' ]);

	app
			.config([
					'$routeProvider',
					'routeResolverProvider',
					'$controllerProvider',
					function($routeProvider, routeResolverProvider,
							$controllerProvider) {

						app.register = {
							controller : $controllerProvider.register
						};

						// Define routes - controllers will be loaded
						// dynamically
						var route = routeResolverProvider.route;

						$routeProvider.when(
								'/home',
								{
									templateUrl : 'pages/homePage.html?cd='
											+ (new Date()).getTime()
								}).otherwise({
							redirectTo : '/home'
						});
					} ]);

	return app;

});
