(function(){
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
	

			
			actrl.updateReservations =function(){
				
				console.log(actrl.newres);
				$http({
					method:'PUT',
					url:"api/reservations/update" ,
					data:actrl.newres
				}).success(function(data){
					console.log(data);
					actrl.reserve= data.payload;
					actrl.newres = null;
				}).error(function(error){
					console.log(error);
				});
			};
			

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
		actrl.getTables =function(){
			
			if(actrl.reservation_id){
			$http({
				method:'GET',
				url:"api/tables/get/" + actrl.capacity
			}).success(function(data){
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
			}
		};
		
	
	
});
})();