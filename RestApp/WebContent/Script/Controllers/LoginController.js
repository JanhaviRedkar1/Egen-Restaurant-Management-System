
(function(){
	'use Strict';
	angular.module("restApp").controller('LoginCtrl', LoginController);
	function LoginController($http){
		var lctrl = this;
		

		
		lctrl.tryLogin= function(){
			
			$http({
				method:'POST',
				url:"api/reservations/login" ,
				data:mctrl.au
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
}
	
})();