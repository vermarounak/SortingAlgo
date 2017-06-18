'use strict';

define(
		[],
		function() {

			var routeResolver = function() {

				this.$get = function() {
					return this;
				};

				this.routeConfig = function() {
					var viewsDirectory = '/NumberSorting/pages/', controllersDirectory = '/NumberSorting/appResources/js/Controllers/', directivesDirectory = '/NumberSorting/appResources/js/Directives/',

					setBaseDirectories = function(viewsDir, controllersDir,
							directivesDir) {
						viewsDirectory = viewsDir;
						controllersDirectory = controllersDir;
						directivesDirectory = directivesDir;
					},

					getViewsDirectory = function() {
						return viewsDirectory;
					},

					getControllersDirectory = function() {
						return controllersDirectory;
					},

					getDirectivesDirectory = function() {
						return directivesDirectory;
					};

					return {
						setBaseDirectories : setBaseDirectories,
						getControllersDirectory : getControllersDirectory,
						getViewsDirectory : getViewsDirectory,
						getDirectivesDirectory : getDirectivesDirectory
					};
				}();

				this.route = function(routeConfig) {

					var resolve = function(baseName, dirName, path, secure) {
						if (!path)
							path = '';

						var routeDef = {};
						routeDef.templateUrl = routeConfig.getViewsDirectory()
								+ path + baseName + '.html';
						routeDef.controller = baseName + 'Controller';
						routeDef.directive = dirName + 'Directive',
								routeDef.secure = (secure) ? secure : false;
						routeDef.resolve = {
							load : [
									'$q',
									'$rootScope',
									function($q, $rootScope) {
										var dependencies;
										if (!dirName) {
											dependencies = [ routeConfig
													.getControllersDirectory()
													+ path
													+ baseName
													+ 'Controller.js' ];
										} else {
											dependencies = [
													routeConfig
															.getControllersDirectory()
															+ path
															+ baseName
															+ 'Controller.js',
													routeConfig
															.getDirectivesDirectory()
															+ path
															+ dirName
															+ 'Directive.js' ];
										}
										return resolveDependencies($q,
												$rootScope, dependencies);
									} ]
						};

						return routeDef;
					},

					resolveDependencies = function($q, $rootScope, dependencies) {
						var defer = $q.defer();
						require(dependencies, function() {
							defer.resolve();
							$rootScope.$apply();
						});

						return defer.promise;
					};

					return {
						resolve : resolve
					};
				}(this.routeConfig);

			};

			var servicesApp = angular.module('routeResolverServices', []);

			//Must be a provider since it will be injected into module.config()    
			servicesApp.provider('routeResolver', routeResolver);
		});