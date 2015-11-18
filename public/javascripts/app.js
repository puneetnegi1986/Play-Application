* Author: Puneet Negi
 */

angular.module('PlayApp',
		[ 'PlayApp.services', 'PlayApp.controllers', 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when("/calculator", {
				templateUrl : "assets/result.html",
				controller : "calculatorController"
			}).when("/add/:test1/:test2", {
				templateUrl : "assets/result.html",
				controller : "addController"
			}).when("/substract/:test1/:test2", {
				templateUrl : "assets/result.html",
				controller : "subController"
			}).when("/addRecord", {
				templateUrl : "assets/addPartDetails.html",
				controller : "addPartDetailController"
			}).otherwise({
				redirectTo : '/calculator'
			});
		} ]);
