myController
		.controller(
				'SalePostCtrl',
				[
						'$scope',
						'$http',
						'$rootScope',
						'$state',
						'$stateParams',
						'$window',
						'$location',
						'MasterFactory',
						'BlogFactory',
						function($scope, $http, $rootScope, $state,
								$stateParams, $window, $location,
								MasterFactory, BlogFactory) {

							// working with ng-options with Json data
							
							$scope.fuelTypeList = [ {
								"key" : "Petrol",
								"value" : "Petrol"
							}, {
								"key" : "Diesel",
								"value" : "Diesel"
							} ];
							$scope.fuelType = $scope.fuelTypeList[0].key;

							$scope.colorList = [ {
								"key" : "Green",
								"value" : "Green"
							}, {
								"key" : "Black",
								"value" : "Black"
							}, {
								"key" : "White",
								"value" : "White"
							}, {
								"key" : "Red",
								"value" : "Red"
							} ];
							$scope.color = $scope.colorList[0].key;

							$scope.ownerList = [ {
								"key" : "FirstOwner",
								"value" : "FirstOwner"
							}, {
								"key" : "SecondOwner",
								"value" : "SecondOwner"
							}, {
								"key" : "ThirdOwner",
								"value" : "ThirdOwner"
							}, {
								"key" : "FourthOwner",
								"value" : "FourthOwner"
							} ];
							$scope.noOfOwner = $scope.ownerList[0].key;

							$scope.conditionList = [ {
								"key" : "Good",
								"value" : "Good"
							}, {
								"key" : "Execielent",
								"value" : "Execielent"
							}, {
								"key" : "Very Good",
								"value" : "Very Good"
							}, {
								"key" : "Poor",
								"value" : "Poor"
							}, {
								"key" : "Fair",
								"value" : "Fair"
							} ];
							$scope.conditionGrade = $scope.conditionList[0].key;

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

							$scope.saveSalePost = function() {
									debugger;
								var imageName1 = (isEmpty($scope.myForm.files[0]) ? null
										: $scope.myForm.files[0].name) ;
								var imageName2 = (isEmpty($scope.myForm.files[1]) ? null
										: $scope.myForm.files[1].name) ;
								var imageName3 = (isEmpty($scope.myForm.files[2]) ? null
										: $scope.myForm.files[2].name) ;
								var imageName4 = (isEmpty($scope.myForm.files[3]) ? null
										: $scope.myForm.files[3].name) ;
								var imageName5 = (isEmpty($scope.myForm.files[4]) ? null
										: $scope.myForm.files[4].name) ;
								
								debugger;
									$http(
										{
											method : 'POST',
											url : 'sale/save-sale',
											data : {
												title : $scope.title,
												description : $scope.description,
												categoryId : $scope.categoryId,
												subCategoryId : $scope.subCategoryId,
												fuelType : $scope.fuelType,
												kmDriven : $scope.kmDriven,
												model : $scope.model,
												price : $scope.price,
												year : $scope.year,
												other : $scope.other,
												itemId : $scope.itemId,
												cityName : $scope.cityName,
												locationName : $scope.locationName,
												userName : $scope.userName,
												mobile : $scope.mobile,
												userId : $scope.userId,
												color : $scope.color,
												registrationNumber : $scope.registrationNumber,
												noOfOwner : $scope.noOfOwner,
												conditionGrade : $scope.conditionGrade,
												image1:imageName1,
												image2:imageName2,
												image3:imageName3,
												image4:imageName4,
												image5:imageName5,
												
												
											},
										})
										.then(
												function success(response) {

													alert("Successfully Save POst Sale Data ");

												},
												function error(response) {
													alert("Invalid Data Please Check Data!!!! ");
												});
							};
							$scope.myForm = {
								files : []
							}
							$scope.doUploadFile = function() {
								var url = "sale/uploadMultiFiles";
								var data = new FormData();
								for (i = 0; i < $scope.myForm.files.length; i++) {
									data.append("files",$scope.myForm.files[i]);
								}

								var config = {
									transformRequest : angular.identity,
									transformResponse : angular.identity,
									headers : {
										'Content-Type' : undefined
									}
								}
								$http.post(url, data, config)
										.then(
												function(response) {
													alert("Successfully Upload Images");

												},
												function(response) {
													alert("Not Upload Images Successfully");

												});
							};

						} ]);