myController.controller('LoginCtrl', ['$scope','$http','$rootScope','$state','$stateParams','$window','$location',
		function($scope, $http,$rootScope,$state,$stateParams,$window,$location,$localStorage) {
	$scope.forshowmessage=false;		
	$scope.checkLogin = function() {
				$http({
					method : 'POST',
					url : 'user/checkLogin',
					data : {
						email : $scope.email,
						password : $scope.password
					},
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
					$rootScope.islogin = false;
					$rootScope.isLoggedinUser = true;
					//$rootScope.GuestUserSearchDiv=true;
					$rootScope.userData = response.data.response_data;
					localStorage.setItem('user', JSON.stringify(response.data.response_data));
					localStorage.setItem('token', response.data.token);
					localStorage.setItem('userId', response.data.userId);
					$http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
					$window.location.reload();
					$state.go('home');
					alert("Successfully Login ");
					}else{
						$scope.forshowmessage=true;
						$scope.messageShow= response.data.response_message;
					}
				}, function error(response) {
					$scope.messageShow= response.data.response_message;
				});
			};
			$scope.signup = function() {
				$http({
					method : 'POST',
					url : 'user/signup',
					data : {
						firstName : $scope.firstName,
						lastName : $scope.lastName,
						email : $scope.email,
						password : $scope.password,
						mobile : $scope.mobile,
						
					},
				}).then(function success(response) {
					
					if(response.data.response_status == true)
					{
					$rootScope.islogin = false;
					$rootScope.isLoggedinUser = true;
					//$rootScope.GuestUserSearchDiv=true;
					$rootScope.userData = response.data.response_data;
					localStorage.setItem('user', JSON.stringify(response.data.response_data));
					localStorage.setItem('token', response.data.token);
					localStorage.setItem('userId', response.data.userId);
					$http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
					$state.go('home',{},{reload:true});
					alert("Successfully Sign Up!!! ");
					
					}else{
						$scope.forshowmessage=true;
						$scope.messageShow = response.data.response_message;
						$scope.email="";
						$scope.password="";
					}
					
				}, function error(response) {
					alert("Error "+response.data.response_message);
				});
			};
			$scope.sendEmailforgotPassword = function() {
				$http({
					method : 'POST',
					url : 'user/forgotpassword',
					data : {
						email : $scope.email
						},
				}).then(function success(response) {
					if(response.data.response_status == true)
					{
					$state.go('login',{},{reload:true});
					alert("Successfully Send Email !!! Please Login  ");
					
					}else{
						$scope.forshowmessage=true;
						$scope.messageShow = response.data.response_message;
						$scope.email="";
						$scope.password="";
					}
					
				}, function error(response) {
					alert("Error "+response.data.response_message);
				});
			};
			$scope.logoutUser = function() {
				if ($window.confirm("Do you want to Log Out : ")) {
				$rootScope.showLogin = true;
				$rootScope.isLoggedinUser = false;
				localStorage.setItem('user', '');
				localStorage.setItem('userId', '');
				localStorage.setItem('token', '');
				$http.defaults.headers.common.Authorization = '';
				$window.location.reload();
				$state.go('home');
				
			}
			}

		} ]);