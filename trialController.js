
var myApp=angular.module('myModule',[])
.controller('myController',function($scope,$http){
    $scope.message='hello world';
    
    $scope.postData=[
        {message:"post1"},
        {message:"post2"}
    ];

    $scope.postComment=function()
    {
        console.log($scope.chatBox);
        var data=$scope.chatBox;
        $scope.postData.push({message:data});
        console.log($scope.postData);
    }    
    
    $scope.incrementLike=function(tech)
    {
        tech.like++;
    };
    $scope.incrementDisLike=function(tech)
    {
        tech.dislike++;
    };

    
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

    };

    
    

});
