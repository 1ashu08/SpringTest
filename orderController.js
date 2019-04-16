var app=angular.module('angularApp',[])
                .controller('orderController',function($scope,$http){
                    $scope.Data=[];
                    $scope.dataFilter="";
                    $scope.newData={serialNo:'0',name:'',quantity:'0',category:'',price:'0',size:'0',subTotal:'0',grandTotal:'0'};
                    var url="https://edmsmartpay.com/"+"insertOrder.php";
		    $scope.addOrder=function()
                    {
			//window.alert("Company Data Added");
			$scope.newData.serialNo=$scope.Data.length+1;
                        $scope.Data.push($scope.newData);
                        $scope.newData={serialNo:'0',name:'',quantity:'0',category:'',price:'0',size:'0',subTotal:'0',grandTotal:'0'};
                        //window.alert("Company Data Added");
                        
                    }
                    
                    $scope.deleteOrder=function(index)
                    {
			
			//console.log($scope.Data[index]);
                        $scope.Data.splice(index, 1);
                        //this.data.remove=true;
                        //window.alert("order From List");
                    }
		    $scope.reduceQuantity=function(index)
                    {
			try
			{
				if(parseInt($scope.Data[index].quantity)>0)
					$scope.Data[index].quantity=parseInt($scope.Data[index].quantity)-1;
				else
					$scope.Data[index].quantity='0';
			}catch(e)
			{
				console.log(e);
			}
	
			
                    }	
		    function reorder()
		    {
			for(var i=0;i<$scope.Data.length;i++)
			{
				$scope.Data[i].serialNo=i+1;
			}	
                    }			
		    $scope.placeOrder=function()
     		     {
			var request = $http({
                        method: "post",
                        url: url,
                        data:$scope.Data,
		    	headers: { 'Content-Type': 'x-www-form-urlencoded' }
			});

			/* Check whether the HTTP Request is successful or not. */
			request.then(function (data) {
				console.log(data);
				alert("Data inserted successfull");
			});	
		     }
                    
                });
