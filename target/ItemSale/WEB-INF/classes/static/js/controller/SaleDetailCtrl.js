myController.controller('SaleDetailCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		'QueryFactory',
		'SaleFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location, QueryFactory, SaleFactory) {
			
				SaleFactory.getSaleDetailById({
					id : $stateParams.saleId
				}, function(result) {
					$scope.saleDetailItem = result.response_data;
					$scope.userSaleList=result.response_data1;
				});
				SaleFactory.getTotalCountItemDetailList(function(result){
					$scope.itemCountDetailList = result.response_data;
				});
				QueryFactory.getQueryCountTotalDetailList(function(result){
					$scope.queryCountDetailList = result.response_data;
				});
			
		} ]);