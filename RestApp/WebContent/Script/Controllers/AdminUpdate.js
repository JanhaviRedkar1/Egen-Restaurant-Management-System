(function(){
RestAppModule.controller('AdminUpdateController', function($http , $routeParams){
		var auctrl = this;
		var reserve = null;
		var table=null;
		
		$http({
			method:'GET',
			url:"api/tables/get/" + $routeParams.no_of_people
		}).success(function(data){
			auctrl.tables=data.payload;
			auctrl.table=data.payload[0].table_no;
			console.log(data);
		}).error(function(error){
			console.log(error);
		});

			
			auctrl.updateReservations =function(){
				
				console.log(auctrl.newres);
				$http({
					method:'PUT',
					url:"api/tables/updateTableinfo/" +$routeParams.reservation_id+"/"+ auctrl.table
					//data:auctrl.newres
				}).success(function(data){
					console.log(data);
					auctrl.reserve= data.payload;
					
					auctrl.newres = null;
				}).error(function(error){
					console.log(error);
				});
			};
			

		auctrl.getReservation =function(){
			
			if(auctrl.reservation_id){
			$http({
				method:'GET',
				url:"api/customers/get/" + auctrl.reservation_id
			}).success(function(data){
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
			}
		};
		
		
	
	
});
})();