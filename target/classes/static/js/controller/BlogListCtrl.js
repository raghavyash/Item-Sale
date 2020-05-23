myController.controller('BlogListCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location','MasterFactory','BlogFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location,MasterFactory,BlogFactory) {
			
			
			
			$scope.IsVisibleForComment = false;
            $scope.ShowComment = function (index) {
            	
                // If DIV is visible it will be hidden and vice versa.
            	$scope.blogList[index].isVisibleForComment = true;
            }
            $scope.hideComment = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.blogList[index].isVisibleForComment = false;
            }
			
				BlogFactory.getBlogListWithoutUserId(function(result) {
					  $scope.pageSize = 10,
					  $scope.currentPage = 1;
					$scope.blogList = result.response_data;
					$scope.totalItems = $scope.blogList.length;
				});
			
			
			
			$scope.getBlogDetail = function(blogId) {
				if(blogId!= null){
				 $state.go('blog.showBlogDetail',{blogId});
			}
			};
			 $scope.saveBlogComments = function(index) {
					debugger;
					 var blog = $scope.blogList[index];
					 $http({
							method : 'POST',
							url : 'blog-comment/save-blog-comment',
							 data: {blogId : blog.id,
								 comment:blog.comment,
								 userId:$rootScope.userId,
								 userName:$rootScope.user.firstName},
							
							headers: {
								'Content-Type': 'application/json' 
								 },
						}).then(function success(response) {
							
							alert("Successfully Post Your Comment");
							 $state.go('blog.showBlogDetail',{blogId:blog.id});
						}, function error(response) {
							alert("Exception Occur !!! ");
							 
						});
						 
					};
		} ]);