myController.controller('QueryCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		'MasterFactory',
		'QueryFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location, MasterFactory, QueryFactory) {

			MasterFactory.getQueryTypeList(function(result) {
				$scope.queryTypeList = result.response_data;
			});
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
            QueryFactory.getQueryCountTotalDetailList(function(result) {
				$scope.queryCountDetailList = result.response_data;
			});
			QueryFactory.getQueryTypeCountList(function(result) {
				$scope.queryTypeCountList = result.response_data;
			});
			  
			  QueryFactory.getQueryListWithoutUserId(function(result) {
				  $scope.pageSize = 10,
				  $scope.currentPage = 1;
				 $scope.queryList = result.response_data;
				$scope.totalItems =  $scope.queryList.length;
			
				});
			
			$scope.searchQuery = function() {
				$http({
					method : 'POST',
					url : 'query/searchQueryList',
					 data: {queryTypeId : $scope.queryTypeId ,query:(isEmpty($scope.query) ? null
								: $scope.query)},
					headers: {
						'Content-Type': 'application/json' 
						 },
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
					    $state.go('query.search_query',{queryList:response.data.response_data});
					}
					 
				}, function error(response) {
					alert("Exception Occur !!! ");
					 
				});
			};
          
			$scope.getQueryDetail = function(queryId) {
				if(queryId != null){
				 $state.go('query.showQueryDetail',{queryId});
				}
			};
			
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
			$scope.getQueryDetailByQueryTypeId = function(QueryTypeId) {
				if (QueryTypeId != null) {
					QueryFactory.getQueryDetailListByQueryTypeId({
						id : QueryTypeId
					}, function(result) {
						$scope.queryList = result.response_data;
						$state.go('query.query_type_list', {
							queryList : $scope.queryList
						}, {
							reload : true,
							inherit : false,
							notify : true
						});
					});
				}
			};
			
			
		} ]);