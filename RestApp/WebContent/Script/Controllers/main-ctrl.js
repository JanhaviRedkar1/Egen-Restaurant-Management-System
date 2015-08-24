(function(){
	'use Strict';
	angular.module("restApp").controller('MainCtrl', MainController);
	function MainController($http){
		var mctrl = this;
		mctrl.getallCustomers =function(){
			$http({
				method:'GET',
				url:"api/customers/all"
			}).success(function(data){
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
		};

mctrl.getCustomers =function(){
			
			if(mctrl.custID){
			$http({
				method:'GET',
				url:"api/customers/get/" + mctrl.custID
			}).success(function(data){
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
			}
		};
mctrl.addReservations =function(){
			
			
			$http({
				method:'POST',
				url:"api/reservations/add" ,
				data:mctrl.newcust
			}).success(function(data){
				console.log(data);
				mctrl.newcust = null;
			}).error(function(error){
				console.log(error);
			});
			
		};
		
		mctrl.tryLogin= function(){
			
			$http({
				method:'POST',
				url:"api/reservations/login" ,
				data:mctrl.au
			}).success(function(data){
				console.log(data);
				
				if(data.status = "success")
					{
					mctrl.loogedIn =true;
					}
				else
					{
					mctrl.loggedIn =false;
					}
			}).error(function(error){
				console.log(error);
			});
			
		};
mctrl.addReservations =function(){
			
			
			$http({
				method:'POST',
				url:"api/reservations/add" ,
				data:mctrl.newcust
			}).success(function(data){
				console.log(data);
				mctrl.newcust = null;
			}).error(function(error){
				console.log(error);
			});
			
		};
	}
	
})();