app.factory('SaleFactory', function($resource,$rootScope) {
	var baseUrl = $rootScope.server_host+'sale';
	return $resource(baseUrl, {}, {
		'getSaleListByUserId' : {
			method : 'GET',
			url : baseUrl + '/getSaleListByUserId'
		},
		'getSaleDetailById' : {
			method : 'GET',
			url : baseUrl + '/getSaleDetail'
		},
		'getSaleDetailListByItemId' : {
			method : 'GET',
			url : baseUrl + '/getSaleDetailListByItemId'
		},
		'searchModelItemDetailList' : {
			method : 'GET',
			url : baseUrl + '/searchModelItemDetailList'
		},
		'getTotalCountItemDetailList' : {
			method : 'GET',
			url : baseUrl + '/getTotalCountItemDetailList'
		},
		
	});
});