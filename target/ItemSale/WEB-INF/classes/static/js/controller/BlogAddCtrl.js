myController.controller('BlogAddCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location','MasterFactory','BlogFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location,MasterFactory,BlogFactory) {
			
			if($rootScope.userId!= null)
			 {
				  $scope.pageSize = 10,
				  $scope.currentPage = 1;
			   BlogFactory.getBlogListByUserId({
					id : $rootScope.userId
				},function(result) {
					$scope.blogList = result.response_data;
					$scope.totalItems = $scope.blogList.length;
				});
		      }
			$scope.saveBlog = function() {
				$http({
					method : 'POST',
					url : 'blog/save-blog',
					data : {
						title : $scope.title,
						description : $scope.description,
						blogTypeId : $scope.blogTypeId,
						userId : $rootScope.userId
					},
					headers: {'Content-Type': 'application/json'},
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
						 alert("Successfully Save Blog Data ");
						 var blogId=response.data.response_data.id;
						 $state.go('blog.showBlogDetail',{blogId});
						
					}else{
						alert("Not Save Successfully  Blob Detail ");
					}
						
				}, function error(response) {
					alert("Invalid Data Please Check Data!!!! ");
				});
			};
			$scope.getBlogDetail = function(blogId) {
				if(blogId!= null){
				 $state.go('blog.showBlogDetail',{blogId});
			}
			};
		
		} ]);