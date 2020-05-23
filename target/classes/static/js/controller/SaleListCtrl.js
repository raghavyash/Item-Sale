myController.controller('SaleListCtrl', [
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

			SaleFactory.getSaleListByUserId({
				id : $rootScope.userId
			}, function(result) {
				$scope.itemList = result.response_data;
			});
			
			$scope.getItemDetail = function(saleId) {
			  if(saleId!= null){
				$state.go('saleItemDetail',{saleId});
			  }
			}
			
			$scope.serchSaleItem = function() {
				$http({
					method : 'POST',
					url : 'sale/searchItemDetail',
					data : {
						email : $scope.email,
						password : $scope.password
					},
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
						$state.go('userDashBoard',{},{reload:true});
					
					}else{
						alert(" Not Correect");
					}
					
				}, function error(response) {
					alert("Not Correct !!!! ");
				});
				}
			
		} ]);