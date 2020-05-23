app.factory('BlogFactory', function($resource,$rootScope) {
	var baseUrl = $rootScope.server_host+'blog';
	return $resource(baseUrl, {}, {
		'getBlogListByUserId' : {
			method : 'GET',
			url : baseUrl + '/getBlogListByUserId'
		},
		'getBlogListWithoutUserId' : {
			method : 'GET',
			url : baseUrl + '/getBlogListWithoutUserId'
		},
		'getBlogDetailById' : {
			method : 'GET',
			url : baseUrl + '/getBlogDetail'
		},
		'getBlogDetailListByBlogTypeId' : {
			method : 'GET',
			url : baseUrl + '/getBlogDetailListByBlogTypeId'
		},
		'getBlogCountTotalDetailList' : {
			method : 'GET',
			url : baseUrl + '/getBlogCountTotalDetailList'
		},
		'getBlogTypeCountList' : {
			method : 'GET',
			url : baseUrl + '/getBlogTypeCountList'
		},
		
	});
});
