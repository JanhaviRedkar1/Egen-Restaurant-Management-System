
RestAppModule.controller('LoginController', function($http){
		var lctrl = this;
			$http ({
				method: 'GET',
				url: 'api/authenticate/isLogin'
			}).success(function(data){
				if(data.status=='success')
				loginCtrl.isLoggedIn = true;
				else
				loginCtrl.isLoggedIn = false;
					
			}).error(function(data){
				console.log(data);		
			});
		
		lctrl.login = function() {
			
			$http ({
				method: 'POST',
				url: 'api/authenticate/login',
				data: lctrl.auth
				
			}).success(function(data){
				if(data.status=='success')
					{
					lctrl.isLoggedIn = true;
					$location.path('/admin');
					}
				else
					{
					lctrl.isLoggedIn = false;
					}
				
			}).error(function(data){
				console.log(data);		
			});
	};
		
		




	
	

		
	
	
});
