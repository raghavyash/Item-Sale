myController.controller('QuerySearchCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams','QueryFactory',
		function($scope, $http, $rootScope, $state, $stateParams,QueryFactory) {
			
			
			$scope.IsVisibleForComment = false;
            $scope.ShowComment = function (index) {
            	
            	$scope.queryList[index].isVisibleForComment = true;
               
            }
            $scope.hideComment = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.queryList[index].isVisibleForComment = false;
            }
            $scope.IsVisibleForAnswer = false;
            $scope.ShowAnswer = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.queryList[index].isVisibleForAnswer = true;
            }
            $scope.hideAnswer = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.queryList[index].isVisibleForAnswer = false;
            }
			
			$scope.queryList=$stateParams.queryList;
			if($scope.queryList!= null){
			$scope.pageSize = 10,
			  $scope.currentPage = 1;
			  $scope.totalItems = $scope.queryList.length;
			}
			
			$scope.saveQueryComments = function(index) {
				var query = $scope.queryList[index];
				 
				$http({
					method : 'POST',
					url : 'query-comment/save-query-comment',
					 data: {queryId : query.id,
						 comment:query.comment,
						 userId:$rootScope.userId,
						 userName:$rootScope.user.email},
					
					headers: {
						'Content-Type': 'application/json' 
						 },
				}).then(function success(response) {
					alert("Successfully Post Your Comment");
					
					$state.go('query.showQueryDetail',{queryId:query.id});
					
				}, function error(response) {
					alert("Exception Occur !!! ");
					 
				});
				 
			};
			
			$scope.saveQueryAnswer = function(index) {
				var query = $scope.queryList[index];
				
				
				$http({
					method : 'POST',
					url : 'query-answer/save-query-answer',
					 data: {queryId : query.id,
						 queryAnswer:query.queryAnswer,
						 userId:$rootScope.userId,
						 userName:$rootScope.user.email
					 },
					headers: {
						'Content-Type': 'application/json' 
						 },
				}).then(function success(response) {
					alert("Successfully Post Your Answer");
					
					$state.go('query.showQueryDetail',{queryId:query.id});
				}, function error(response) {
					alert("Exception Occur !!! ");
					 
				});
				 
			};
			
		} ]);