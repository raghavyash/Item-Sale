myController.controller('FeedBackCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location) {
			
			$scope.saveFeedback = function() {
				$http({
					method : 'POST',
					url : 'feedback/save-feedback',
					data : {
						firstName : $scope.firstName,
						lastname : $scope.lastname,
						email : $scope.email,
						phone : $scope.phone,
						message : $scope.message,
					},
					headers: {'Content-Type': 'application/json'},
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
						alert("Successfully Submit FeedBack Data ");
						$state.go('home',{},{reload:true});
					}else{
						alert("Not Save FeedBack Data ");
					}
						
				}, function error(response) {
					alert("Invalid Data Please Check Data!!!! ");
				});
			};

		} ]);