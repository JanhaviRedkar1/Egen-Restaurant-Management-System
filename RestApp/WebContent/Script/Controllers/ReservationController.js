
RestAppModule.controller('ReservationController', function($http){
		var rctrl = this;
		rctrl.getallReservations =function(){
			$http({
				method:'GET',
				url:"api/reservations/all"
			}).success(function(data){
				
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
		};


		rctrl.getReservation =function(){
			
			if(rctrl.reservation_id){
			$http({
				method:'GET',
				url:"api/reservations/get/" + rctrl.reservation_id
			}).success(function(data){
				rctrl.reserve= data.payload;
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
			}
		};

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
		
	
	
	rctrl.updateReservations =function(){
		
		console.log(rctrl.newres);
		$http({
			method:'PUT',
			url:"api/reservations/update" ,
			data:rctrl.newres
		}).success(function(data){
			console.log(data);
			rctrl.reserve= data.payload;
			rctrl.newres = null;
		}).error(function(error){
			console.log(error);
		});
	};
	


rctrl.deleteReservations =function(){
	
	if(rctrl.reservation_id){
		$http ({
			method:'DELETE',
			url: 'api/reservations/cancel/' + rctrl.reservation_id 
			
			//headers: {"Content-Type": "application/json;charset=utf-8"}
		}).success(function(data){
			rctrl.reserve = data.payload;	
			//location.reload();
		}).error(function(data){
			console.log(data);		
		});
	}
	

};


	
	

		
	
	
});
