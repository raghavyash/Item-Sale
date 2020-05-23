myController.controller('QueryShowDetailCtrl', [
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
			debugger;
			$scope.isVisibleForCommentReply = false;
            $scope.ShowCommentReply = function (index) {
            	
            	$scope.queryDetail.queryCommentModels[index].isVisibleForCommentReply =true;
               
            }
            $scope.hideCommentReply = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.queryDetail.queryCommentModels[index].isVisibleForCommentReply =false;
            }
            $scope.isVisibleForAnswerReply = false;
            $scope.ShowAnswerReply = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.queryDetail.queryAnswerModels[index].isVisibleForAnswerReply = true;
            }
            $scope.hideAnswerReply = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.queryDetail.queryAnswerModels[index].isVisibleForAnswerReply = false;
            }
			QueryFactory.getQueryDetailById({
				id : $stateParams.queryId
			}, function(result) {
				$scope.queryDetail = result.response_data;
			});
			
            $scope.saveQueryAnswer = function(id) {
					$http({
					method : 'POST',
					url : 'query-answer/save-query-answer',
					 data: {queryId : id,
						 queryAnswer:$scope.queryAnswer,
						 userId:$rootScope.userId,
						 userName:$rootScope.user.email},
					
					headers: {
						'Content-Type': 'application/json' 
						 },
				}).then(function success(response) {
					
					alert("Successfully Post Your Comment");
					$state.reload();
				}, function error(response) {
					alert("Exception Occur !!! ");
					 
				});
				 
			};
			$scope.saveQueryAnswersReply = function(index) {
				debugger;
				var query = $scope.queryDetail.queryAnswerModels[index];
				$http({
				method : 'POST',
				url : 'query-answer/save-query-answer-reply',
				 data: {queryAnswerId : query.id,
					 reply:query.reply,
					 userId:$rootScope.userId,
					 userName:$rootScope.user.email},
				
				headers: {
					'Content-Type': 'application/json' 
					 },
			}).then(function success(response) {
				alert("Successfully Post Your Comment");
				$state.reload();
			}, function error(response) {
				alert("Exception Occur !!! ");
				 
			});
			 
		};
			
			 $scope.saveQueryComment = function(id) {
					$http({
						method : 'POST',
						url : 'query-comment/save-query-comment',
						 data: {queryId : id,
							 comment:$scope.comment,
							 userId:$rootScope.userId,
							 userName:$rootScope.user.email},
						
						headers: {
							'Content-Type': 'application/json' 
							 },
					}).then(function success(response) {
						
						alert("Successfully Post Your Comment");
						$state.reload();
					}, function error(response) {
						alert("Exception Occur !!! ");
						 
					});
					 
				};
				$scope.saveQueryCommentsReply = function(index) {
					debugger;
					var query = $scope.queryDetail.queryCommentModels[index];
					$http({
						method : 'POST',
						url : 'query-comment/save-query-comment-reply',
						 data: {queryCommentId : query.id,
							 reply:query.reply,
							 userId:$rootScope.userId,
							 userName:$rootScope.user.email},
						
						headers: {
							'Content-Type': 'application/json' 
							 },
					}).then(function success(response) {
						
						alert("Successfully Post Your Comment");
						$state.reload();
					}, function error(response) {
						alert("Exception Occur !!! ");
						 
					});
					 
				};
			
		} ]);