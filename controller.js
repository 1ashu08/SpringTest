
var myApp=angular.module('myModule',[])
                .controller('myController',function($scope,$http){
                    $scope.message='hello world';
                    $scope.obj={
                       'name':'ashutosh',
                       'age':'256',
                       'hobby':'playing klsdjaldk',
                       'image':'script/flag.png'
                    };
                    $scope.student=[
                        {'name':'ashutosh1','class':12,'age':30},
                        {'name':'ashutosh2','class':12,'age':30},
                        {'name':'ashutosh3','class':12,'age':30},
                        {'name':'ashutosh4','class':12,'age':30},
                        {'name':'ashutosh5','class':12,'age':30},
                        {'name':'ashutosh6','class':12,'age':30},
                        {'name':'ashutosh7','class':12,'age':30}
                    ];
                    $scope.technologies=[
                        {'name':'AI','like':0,'dislike':0},
                        {'name':'DBMS','like':0,'dislike':0},
                        {'name':'CODING','like':0,'dislike':0},
                        {'name':'ABC','like':0,'dislike':0},
                        {'name':'DEF','like':0,'dislike':0}
                    ];
                    
                    $scope.incrementLike=function(tech)
                    {
                        tech.like++;
                    };
                    $scope.incrementDisLike=function(tech)
                    {
                        tech.dislike++;
                    };

                    $scope.employee=[
                        {'name':'ashutosh','age':30,'salary':5035.3654,'dob':new Date("November 23,1998")},
                        {'name':'ashutosh1','age':35,'salary':5035.3654,'dob':new Date("November 23,1998")},
                        {'name':'ashutosh2','age':36,'salary':5035.3654,'dob':new Date("November 23,1998")},
                        {'name':'ashutosh3','age':30,'salary':5035.3654,'dob':new Date("November 23,1998")},
                        {'name':'ashutosh4','age':38,'salary':5035.3654,'dob':new Date("November 23,1998")},
                        {'name':'ashutosh5','age':30,'salary':5035.3654,'dob':new Date("April 23,1998")},
                        {'name':'ashutosh6','age':32,'salary':5035.3654,'dob':new Date("January 23,1998")},
                        {'name':'ashutosh7','age':30,'salary':5035.3654,'dob':new Date("March 23,1998")}

                    ];
                    $scope.rowLimit=5;
                    $scope.sortColumn='name';

                    $scope.onSubmit=function(){
                       
                        console.log('in form submission');

                        $http({
                            method:'POST', //'GET',
                            url: 'http://192.168.0.103:3000/home',
                            //id:$scope.employee,
                            params:{id:$scope.employee},
                            crossDomain:true,
                            
                         }).then(function (success){
                            console.log(":) form submitted");
                            console.log(success.data);
                         },function (error){
                            console.log("error in submittion :(");
                            console.log(error);
                         });

                        /*$http.post('192.168.0.103:3000',$scope.employee).
                        success(function(){
                            
                        }).
                        error(function(){
                            
                        });*/
                    };

                    
                    

                });


/*var myController=function($scope){
    $scope.message='hello world';

};

app.controller('myController',myController);
*/