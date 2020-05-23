app.factory('MasterFactory', function($resource,$rootScope) {
	var baseUrl = $rootScope.server_host+'master_list';
	return $resource(baseUrl, {}, {
		'getCityList' : {
			method : 'GET',
			url : baseUrl + '/getcity_list'
		},
		'getLocationList' : {
			method : 'GET',
			url : baseUrl + '/getlocation_list'
		},
		'getLocationListByCityName' : {
			method : 'GET',
			url : baseUrl + '/getlocation_listBy_cityName'
		},
		'getCategoryList' : {
			method : 'GET',
			url : baseUrl + '/getcategory_list'
		},
		'getSubCategoryList' : {
			method : 'GET',
			url : baseUrl + '/getsub_category_list'
		},
		'getItemList' : {
			method : 'GET',
			url : baseUrl + '/getitem_list'
		},
		'getBlogTypeList' : {
			method : 'GET',
			url : baseUrl + '/getblog_type_list'
		},
		'getQueryTypeList' : {
			method : 'GET',
			url : baseUrl + '/getquery_type_list'
		},
	});
});
