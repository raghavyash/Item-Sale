myController.controller('HomePageCtrl', [
		'$scope',
		'MasterFactory',
		'$location',
		'$rootScope',
		'$http',
		'$state',
		'$stateParams',
		'MasterFactory',
		'SaleFactory',
		'QueryFactory',
		'BlogFactory',
		function($scope, MasterFactory, $location, $rootScope, $http, $state,
				$stateParams, MasterFactory, SaleFactory, QueryFactory,
				BlogFactory) {

			
              // Single Item Blog , Query Comment And Answer Count Detail List
			
			SaleFactory.getTotalCountItemDetailList(function(result) {
				$scope.itemCountDetailList = result.response_data;
			});
			QueryFactory.getQueryCountTotalDetailList(function(result) {
				$scope.queryCountDetailList = result.response_data;
			});
			BlogFactory.getBlogCountTotalDetailList(function(result) {
				$scope.blogCountDetailList = result.response_data;
			});
			
			// -- for Blog and Query Type Count Detail List
			
		   BlogFactory.getBlogTypeCountList(function(result) {
				$scope.blogTypeCountList = result.response_data;
			});
			QueryFactory.getQueryTypeCountList(function(result) {
				$scope.queryTypeCountList = result.response_data;
			});
			
			
			
			$scope.getQueryDetail = function(queryId) {
				if(queryId != null){
				 $state.go('query.showQueryDetail',{queryId});
			}
			};
			$scope.getBlogDetail = function(blogId) {
				if(blogId!= null){
				 $state.go('blog.showBlogDetail',{blogId});
				}
			};
			$scope.getSaleDetialList = function(itemId) {
				if (itemId != null) {
					SaleFactory.getSaleDetailListByItemId({
						id : itemId
					}, function(result) {
						$scope.searchsaleList = result.response_data;
						$state.go('sale_list', {
							saleList : $scope.searchsaleList
						}, {
							reload : true,
							inherit : false,
							notify : true
						});
					});
				}
			};

			
			
			//======Query Type with BlogType Detail List========
			$scope.getQueryDetailByQueryTypeId = function(QueryTypeId) {
				debugger;
				if (QueryTypeId != null) {
					QueryFactory.getQueryDetailListByQueryTypeId({
						id : QueryTypeId
					}, function(result) {
						debugger;
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
			
			$scope.getBlogDetailByBlogTypeId = function(blogTypeId) {
				debugger;
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

		} ]);
