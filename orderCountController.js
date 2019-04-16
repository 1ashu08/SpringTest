var app=angular.module('angularApp',[])
                .controller('orderCountController',function($scope,$http){
                    $scope.orderCount=0;
                    $scope.oldOrderCount=0;
		    var url="https://edmsmartpay.com/"+"customFetchOrder.php";
		    $scope.getOrderCount=function()
     		    {
			var request = $http({
                        method: "post",
                        url: url,
		    	headers: { 'Content-Type': 'x-www-form-urlencoded' }
			});

			/* Check whether the HTTP Request is successful or not. */
			request.then(function (data) {
				console.log(data.data);
				$scope.orderCount=data.data;				
				//console.log("new line");
				try
				{
					
				}catch(e)
				{
					console.log("error "+e);
				}
			});	
		     }
		     
		     updateData();
		     function updateData()
		     {
			$scope.getOrderCount();
			setTimeout(updateData, 5000);
		     }	
                    
                });
