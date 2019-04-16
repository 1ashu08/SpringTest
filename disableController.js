var app=angular.module('angularApp',[])
                .controller('disableController',function($scope,$http){
                    
		var url="https://edmsmartpay.com/"+"date.php";
		console.log(url);	
		     $scope.allowedDate=["1","2","3","4","5","6","7"];
		     $scope.disableFlag=true;
				
		     $scope.getDateTime=function()
     		     {
			var request = $http({
                        method: "post",
                        url: url,
                        headers: { 'Content-Type': 'x-www-form-urlencoded' }
			});

			request.then(function (data) {
				console.log(data);
				for(var i=0;i<$scope.allowedDate.length;i++)
				{
					if(data==$scope.allowedDate[i])
					{
						$scope.disableFlag=true;
					}
				}
				alert("Time fecthed");
			});
			/*var data = new Date();
			console.log(data.getDate());
			for(var i=0;i<$scope.allowedDate.length;i++)
			{
				if(data.getDate()==$scope.allowedDate[i])
				{
					console.log("in if");
					$scope.disableFlag=false;
					break;
				}
			}*/	
		     }	
                   	$scope.getDateTime();             
                });
