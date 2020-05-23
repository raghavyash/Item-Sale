myController.controller('BlogSearchCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		function($scope, $http, $rootScope, $state, $stateParams) {
			
			$scope.IsVisibleForComment = false;
            $scope.ShowComment = function (index) {
            	$scope.blogList[index].isVisibleForComment = true;
            }
            $scope.hideComment = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.blogList[index].isVisibleForComment = false;
            	
            }
			
			$scope.blogList=$stateParams.blogList;
			if($scope.blogList!= null){ 
			$scope.pageSize = 10,
			  $scope.currentPage = 1;
			  $scope.totalItems = $scope.blogList.length;
			}
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