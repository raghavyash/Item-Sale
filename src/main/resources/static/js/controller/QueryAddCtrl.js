myController.controller('QueryAddCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		'MasterFactory',
		'QueryFactory','$log',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location, MasterFactory, QueryFactory,$log) {
			
			
			QueryFactory.getQueryListByUserId({
				id : $rootScope.userId
			},function(result) {
				$scope.queryList = result.response_data;
			});
			
			$scope.saveQuery = function() {
				$http({
					method : 'POST',
					url : 'query/save-query',
					data : {
						query : $scope.query,
						queryTypeId : $scope.queryTypeId,
						userId : $rootScope.userId,
						description : $scope.description,
						userName:$rootScope.user.firstName
					},
					headers: {
						'Content-Type': 'application/json' 
						 },
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
						
						var queryId=response.data.response_data.id;
					 $state.go('query.showQueryDetail',{queryId});
					}else{
						alert("Not Save Successfully  Query Detail ");
					}
					 
				}, function error(response) {
					alert("Exception Occur !!!  Not Save Successfully  Query Detail ");
					 
				});
			};
			

		} ]);