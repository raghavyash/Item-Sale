app.config([ '$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {
			$stateProvider.state('login', {
				url : '/login',
				templateUrl : 'views/login.html'
			}).state('signup', {
				url : '/signup',
				templateUrl : 'views/signup.html'
			}).state('forgotpassword', {
				url : '/forgotpassword',
				templateUrl : 'views/forgot_password.html'
			}).state('home', {
				url : '/home',
				templateUrl : 'views/home.html',
				controller : 'HomePageCtrl'
			}).state('userDetail', {
				url : '/user',
				templateUrl : 'views/user_detail.html'
			}).state('userDashBoard', {
				url : '/userDashBoard',
				templateUrl : 'views/user_dashboard.html'
			}).state('feedbcak_form', {
				url : '/feedbcak_form',
				templateUrl : 'views/feedbcak_form.html'
			})
			.state('query', {
				url : '/query',
				templateUrl : 'views/query/query.html',
				controller : 'QueryCtrl',

			}).state('query.query_add', {
				url : '/query_add',
				templateUrl : 'views/query/query_add.html',
				controller : 'QueryAddCtrl',
			}).state('query.query_list', {
				url : '/query_list',
				templateUrl : 'views/query/query_list.html',
				controller : 'QueryListCtrl',
			}).state('query.query_type_list', {
				url : '/query_type_list',
				templateUrl : 'views/query/query_type_list.html',
				controller : 'QuerySearchCtrl',
				params: { queryList: null},
			
			}).state('query.search_query', {
				url : '/search_query',
				templateUrl : 'views/query/query_search_list.html',
				controller : 'QuerySearchCtrl',
				params: { queryList: null},
			
			}).state('query.showQueryDetail', {
				url : '/showQueryDetail/:queryId',
				templateUrl : 'views/query/query_show_detail.html',
				controller : 'QueryShowDetailCtrl',	
			})
			
			.state('sale_post', {
				url : '/sale_post',
				templateUrl : 'views/sale/sale_post.html'
			
			}).state('saleItemDetail', {
				url : '/sale_detail/:saleId',
				templateUrl : 'views/sale/sale_item_detail.html',
				controller : 'SaleDetailCtrl',
			
			}).state('sale_list', {
				url : '/sale_list/',
				templateUrl : 'views/sale/sale_list.html',
				controller : 'SaleModelSearchCtrl',
				params: { saleList: null,searchData: null},
			})
			.state('blog', {
				url : '/blog',
				controller : 'BlogCtrl',
				templateUrl : 'views/blog/blog.html'
			}).state('blog.blog_add', {
				url : '/blog_add',
				controller : 'BlogAddCtrl',
				templateUrl : 'views/blog/blog_add.html',

			}).state('blog.blog_list', {
				url : '/blog_list',
				controller : 'BlogListCtrl',
				templateUrl : 'views/blog/blog_list.html',

			}).state('blog.blog_type_detail', {
				url : '/blog_type_detail',
				templateUrl : 'views/blog/blog_type_detail.html',
				controller : 'BlogSearchCtrl',
				params: { blogList: null},
			
			}).state('blog.search_blog', {
				url : '/search_blog',
				templateUrl : 'views/blog/blog_search_list.html',
				controller : 'BlogSearchCtrl',
				params: { blogList: null},
			
			}).state('blog.showBlogDetail', {
				url : '/showBlogDetail/:blogId',
				templateUrl : 'views/blog/blog_show_detail.html',
				controller : 'BlogShowDetailCtrl',	
				
			})
			$urlRouterProvider.otherwise('/home');
		} ]);