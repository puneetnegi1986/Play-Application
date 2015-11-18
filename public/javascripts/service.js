/*
 * Author: Puneet Negi
 */

angular.module('PlayApp.services', []).factory('calulatorApiService',
		function($http) {

			var apiData = {};

			apiData.sum = function(value1, value2) {
				var param = {
					"data1" : value1,
					"data2" : value2
				};
				return $http.post("/add", param);
			}

			apiData.subtract = function(value1, value2) {
				var param = {
					"data1" : value1,
					"data2" : value2
				};
				return $http.post("/sub", param);

			}
			
			apiData.loadData = function() {
				var param = {};
				return $http.get("/loadPart", param);

			}
			
			apiData.saveRecord = function(data) {
				var param = {"data1":data};
				return $http.post("/savePart", param);

			}
			
			
			
			return apiData;
		});
