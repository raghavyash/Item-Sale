myController.controller('BlogCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location','MasterFactory','BlogFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location,MasterFactory,BlogFactory) {
			
			MasterFactory.getBlogTypeList(function(result) {
				$scope.blogTypeList = result.response_data;
			});
			
			
			BlogFactory.getBlogTypeCountList(function(result) {
				$scope.blogTypeCountList = result.response_data;
			});
			BlogFactory.getBlogCountTotalDetailList(function(result) {
				$scope.blogCountDetailList = result.response_data;
			});
			
			$scope.IsVisibleForComment = false;
            $scope.ShowComment = function (index) {
            	$scope.blogList[index].isVisibleForComment = true;
            }
            $scope.hideComment = function (index) {
                // If DIV is visible it will be hidden and vice versa.
            	$scope.blogList[index].isVisibleForComment = false;
            	
            }
            // blog List for Without user Login
			BlogFactory.getBlogListWithoutUserId(function(result) {
					  $scope.pageSize = 10,
					  $scope.currentPage = 1;
					$scope.blogList = result.response_data;
					$scope.totalItems = $scope.blogList.length;
				});
			
			
			$scope.searchBlog = function() {
				debugger;
				$http({
					method : 'POST',
					url : 'blog/searchBlogList',
					data: {blogTypeId : $scope.blogTypeId ,title:(isEmpty($scope.title) ? null
								: $scope.title)},
					headers: {
						'Content-Type': 'application/json' 
						 },
				}).then(function success(response) {
					$scope.blogList = response.data.response_data;
					$state.go('blog.search_blog', {
						blogList : $scope.blogList});
					 
				}, function error(response) {
					alert("Exception Occur !!! ");
					 
				});
			};
			$scope.getBlogDetail = function(blogId) {
				if(blogId!= null){
				 $state.go('blog.showBlogDetail',{blogId});
			}
			};
			
			
			$scope.getBlogDetailByBlogTypeId = function(blogTypeId) {

				if (blogTypeId != null) {
					BlogFactory.getBlogDetailListByBlogTypeId({
						id : blogTypeId
					}, function(result) {
						debugger;
						$scope.blogList = result.response_data;
						$state.go('blog.blog_type_detail', {
							blogList : $scope.blogList
						}, {
							reload : true,
							inherit : false,
							notify : true
						});
					});
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