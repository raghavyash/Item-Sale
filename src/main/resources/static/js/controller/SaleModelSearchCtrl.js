myController.controller('SaleModelSearchCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		'MasterFactory',
		'SaleFactory',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location, MasterFactory, SaleFactory) {

			if($stateParams.searchData!= null){
			if($stateParams.searchData.cityName!= null){
			$scope.cityName =  $stateParams.searchData.cityName;
		   }if($stateParams.searchData.locationName!= null){
			$scope.locationName =  $stateParams.searchData.locationName;
		  }   if($stateParams.searchData.categoryId!= null){
			$scope.categoryId = $stateParams.searchData.categoryId;
			}
			if($stateParams.searchData.subCategoryId!= null){
			$scope.subCategoryId=  $stateParams.searchData.subCategoryId;
			}
			if($stateParams.searchData.itemId!= null){
			$scope.searchData =  $stateParams.searchData.itemId;
			}
			}
			$scope.itemList = $stateParams.saleList;
			
			  $scope.pageSize = 5,
			  $scope.currentPage = 1;
			  $scope.totalItems = $scope.itemList.length;
					
					$scope.getItemDetail = function(saleId) {
						if(saleId!= null){
						$state.go('saleItemDetail',{saleId});
					}
				}
			
		} ]);