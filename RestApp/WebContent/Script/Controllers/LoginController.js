
RestAppModule.controller('LoginController', function($http){
		var lctrl = this;
		

		
		lctrl.tryLogin= function(){
			console.log(lctrl.auth);
			
			
			
			$http({
				method:'POST',
				url:"api/authentications/login" ,
				data:lctrl.auth
			}).success(function(data){
				console.log(data);
				
				if(data.status = "success")
					{
					lctrl.loogedIn =true;
					}
				else
					{
					lctrl.loggedIn =false;
					}
			}).error(function(error){
				console.log(error);
			});
			
		};

});
	

RestAppModule.controller('LoginController', function($http){
		var lctrl = this;
		
		rctrl.addReservations =function(){
	
			console.log(rctrl.newres);
			$http({
				method:'POST',
				url:"api/reservations/add" ,
				data:rctrl.newres
			}).success(function(data){
				console.log(data);
				rctrl.reserve= data.payload;
				rctrl.newres = null;
			}).error(function(error){
				console.log(error);
			});
			
		};
		
	
	
		




	
	

		
	
	
});
