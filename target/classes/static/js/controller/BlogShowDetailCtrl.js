myController.controller('BlogShowDetailCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		'MasterFactory',
		'BlogFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location, MasterFactory, BlogFactory) {
			
			$scope.isVisibleForCommentReply = false;
            $scope.ShowCommentReply = function (index) {
            	
            	$scope.blogDetail.blogCommentModels[index].isVisibleForCommentReply =true;
               
            }
            $scope.hideCommentReply = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.blogDetail.blogCommentModels[index].isVisibleForCommentReply =false;
            }
			
			BlogFactory.getBlogDetailById({
				id : $stateParams.blogId
			}, function(result) {
				$scope.blogDetail = result.response_data;
			});
			
			 $scope.saveBlogComment = function(id) {
					 $http({
							method : 'POST',
							url : 'blog-comment/save-blog-comment',
							 data: {blogId : id,
								 comment:$scope.blogComment,
								 userId:$rootScope.userId,
								 userName:$rootScope.user.firstName},
							
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
					
					 $scope.saveBlogCommentReply = function(index) {
							debugger;
							 var blog = $scope.blogDetail.blogCommentModels[index];
							 $http({
									method : 'POST',
									url : 'blog-comment/save-blog-comment-reply',
									 data: {blogCommentId : blog.id,
										 reply:blog.reply,
										 userId:$rootScope.userId,
										 userName:$rootScope.user.firstName},
									
									headers: {
										'Content-Type': 'application/json' 
										 },
								}).then(function success(response) {
									
									alert("Successfully Post Your Reply Comment");
									$state.reload();
								}, function error(response) {
									alert("Exception Occur !!! ");
									 
								});
								 
							};
			
		} ]);