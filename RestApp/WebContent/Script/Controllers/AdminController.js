
RestAppModule.controller('AdminController', function($http){
		var actrl = this;
		var reserve = null;
		
			$http({
				method:'GET',
				url:"api/reservations/all"
			}).success(function(data){
				actrl.reserve = data.payload;
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
	


		actrl.getReservation =function(){
			
			if(actrl.reservation_id){
			$http({
				method:'GET',
				url:"api/customers/get/" + actrl.reservation_id
			}).success(function(data){
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
			}
		};

		
	
	
});