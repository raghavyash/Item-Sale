var app = angular.module('myApp', ['ui.router','ngStorage','ngResource','ui.bootstrap','myController','myServices','ngTable']);

var myController = angular.module('myController', []);

/* Services */
var myServices = angular.module('myServices', []);
var isEmpty = function(inputStr) {
	if (null == inputStr || "" == inputStr || undefined == inputStr
			|| "NaN" == inputStr) {
		return true;
	}
	return false;
};

app.run([ '$rootScope','$http','$location','$state','$timeout',function($rootScope, $http, $location,$state,$window,$localStorage,$timeout) {
	
	$rootScope.server_host = window.location.pathname;
	// keep user logged in after page refresh
	if (localStorage.getItem('token')!= null  && localStorage.getItem('token')!= '' && localStorage.getItem('userId') != null && localStorage.getItem('userId') !='') {
    	$rootScope.islogin = false;
		$rootScope.isLoggedinUser = true;
		$rootScope.userId= localStorage.getItem('userId');
		$rootScope.user= JSON.parse(localStorage.getItem('user'));
		$http.defaults.headers.common.Authorization = 'Bearer ' + localStorage.getItem('token');
		
	}else{
    	$rootScope.isLoggedinUser = false;
    	$rootScope.islogin = true;
    	$state.go('home');
    }
	

}]);



