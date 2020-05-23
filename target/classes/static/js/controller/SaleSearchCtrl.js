myController
		.controller(
				'SaleSearchCtrl',
				[
						'$scope',
						'MasterFactory',
						'$location',
						'$rootScope',
						'$http',
						'$state',
						'$stateParams',
						'MasterFactory',
						'SaleFactory',
						function($scope, MasterFactory, $location, $rootScope,
								$http, $state, $stateParams, MasterFactory,
								SaleFactory) {

							MasterFactory.getCityList(function(result) {
								$scope.cityList = result.response_data;
							});
							$scope.getCityWiseLocation = function() {
								MasterFactory.getLocationListByCityName({
									name : $scope.cityName
								}, function(result) {
									$scope.locationList = result.response_data;
								});
							}

							MasterFactory.getCategoryList(function(result) {
								$scope.categoryList = result.response_data;
							});

							$scope.getSubCategoryList = function() {
								MasterFactory
										.getSubCategoryList(
												{
													id : $scope.categoryId
												},
												function(result) {
													$scope.subCategoryList = result.response_data;
												});
							}
							$scope.getItemList = function() {
								MasterFactory.getItemList({
									catId : $scope.categoryId,
									subCatId : $scope.subCategoryId
								}, function(result) {
									$scope.itemList = result.response_data;
								});
							}
							$scope.searchSaleItem = function() {

								$http(
										{
											method : 'POST',
											url : 'sale/searchItemDetailList',
											data : {
												cityName : (isEmpty($scope.cityName) ? null
														: $scope.cityName),
												locationName : (isEmpty($scope.locationName) ? null
														: $scope.locationName),
												categoryId : (isEmpty($scope.categoryId) ? null
														: $scope.categoryId),
												subCategoryId : (isEmpty($scope.subCategoryId) ? null
														: $scope.subCategoryId),
												itemId : (isEmpty($scope.itemId) ? null
														: $scope.itemId)
											},
										})
										.then(
												function success(response) {
													debugger;
													$scope.searchsaleList = response.data.response_data;
													var searchObject = {
														'cityName' : (isEmpty($scope.cityName) ? null
																: $scope.cityName),
														'locationName' : (isEmpty($scope.locationName) ? null
																: $scope.locationName),
														'categoryId' : (isEmpty($scope.categoryId) ? null
																: $scope.categoryId),
														'subCategoryId' : (isEmpty($scope.subCategoryId) ? null
																: $scope.subCategoryId),
														'itemId' : (isEmpty($scope.itemId) ? null
																: $scope.itemId)
													};
													$state
															.go(
																	'sale_list',
																	{
																		saleList : $scope.searchsaleList,
																		searchData : searchObject
																	},
																	{
																		reload : true,
																		inherit : false,
																		notify : true
																	});
												}, function error(response) {

												});

							}
						} ]);
