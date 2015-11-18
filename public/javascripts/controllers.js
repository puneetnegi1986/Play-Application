/*
 * Author: Puneet Negi
 */

angular.module('PlayApp.controllers', []).controller(
		'addController',
		function($scope, $routeParams, calulatorApiService) {

			var finalResult = calulatorApiService.sum($routeParams.test1,
					$routeParams.test2).success(function(data) {
				$scope.result = data;
			});

		}).

controller(
		'calculatorController',
		function($scope, $routeParams, calulatorApiService) {
			var finalResult = calulatorApiService.loadData().success(
					function(dataset) {
						$('#example').DataTable({
							data : dataset,
							columns : [ {
								title : "Part Numer"
							}, {
								title : "Site Code"
							}, {
								title : "Unit Of Measure Code"
							}, {
								title : "partLength"
							}, {
								title : "Nomenclature"
							}, {
								title : "Procurement Family"
							}, {
								title : "Shop Cost"
							}

							]
						});

					});
		}).

controller(
		'subController',
		function($scope, $routeParams, calulatorApiService) {
			var finalResult = calulatorApiService.subtract($routeParams.test1,
					$routeParams.test2).success(function(data) {
				$scope.result = data;
			});
		}).

controller(
		'addPartDetailController',
		function($scope, $routeParams, calulatorApiService) {
			
			$scope.addRecord = function() {
				var partDetail=$scope.data;
				var finalResult = calulatorApiService.saveRecord(partDetail)
						.success(function(data) {
							$scope.result = data;
						});
			};

		});
