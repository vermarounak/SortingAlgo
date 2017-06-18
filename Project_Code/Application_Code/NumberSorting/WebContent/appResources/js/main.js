/**
 * 
 */

require.config({
	baseUrl : "appResources/js",
	urlArgs : "v=1.0"
});

require([

"routeResolver", "app", "Controllers/IndexController"

], function() {
	angular.bootstrap(document, [ 'myApp' ]);
}

);
