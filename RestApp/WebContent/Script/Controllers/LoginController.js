
RestAppModule.controller('LoginController', function($http ,$location){
		var lctrl = this;
			$http ({
				method: 'GET',
				url: 'api/authentications/isLogin'
			}).success(function(data){
				if(data.status=='success')
				lctrl.isLoggedIn = true;
				else
				lctrl.isLoggedIn = false;
					
			}).error(function(data){
				console.log(data);		
			});
		
		lctrl.login = function() {
			
			$http ({
				method: 'POST',
				url: 'api/authentications/login',
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
