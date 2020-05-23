app.factory('QueryFactory', function($resource,$rootScope) {
	var baseUrl = $rootScope.server_host+'query';
	return $resource(baseUrl, {}, {
		'getQueryListByUserId' : {
			method : 'GET',
			url : baseUrl + '/getQueryListByUserId'
		},
		'getQueryListWithoutUserId' : {
			method : 'GET',
			url : baseUrl + '/getQueryListWithoutUserId'
		},
		'getQueryDetailById' : {
			method : 'GET',
			url : baseUrl + '/getQueryDetail'
		},
		'getQueryDetailListByQueryTypeId' : {
			method : 'GET',
			url : baseUrl + '/getQueryDetailListByQueryTypeId'
		},
		'getQueryCountTotalDetailList' : {
			method : 'GET',
			url : baseUrl + '/getQueryCountTotalDetailList'
		},
		'getQueryTypeCountList' : {
			method : 'GET',
			url : baseUrl + '/getQueryTypeCountList'
		},
	});
});
