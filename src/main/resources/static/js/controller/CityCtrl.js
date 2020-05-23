app.controller('CityCtrl', ['$http', '$scope',
		function($http ,$scope,$location) {
			$scope.checkLogin = function() {
				$http({
					method : 'POST',
					url : 'user/checkLogin',
					data : {
						email : $scope.email,
						password : $scope.password
					},
				}).then(function success(response) {
					
					$location.path('/');
					alert("Successfully ");
					$scope.user = response.data;
				}, function error(response) {
					alert("Login Fail ");
				});
			};
		} ]);