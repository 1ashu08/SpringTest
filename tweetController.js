var app=angular.module('tweetModule',[])
.controller('tweetController',function($scope,$http){
    $scope.posts=[];
    $scope.newPosts={created_by:'',text:'',created_at:''};

    $scope.postComment=function()
    {
        $scope.newPosts.created_at=Date.now();
        $scope.posts.push($scope.newPosts);
        $scope.newPosts={created_by:'',text:'',created_at:''};
    } 
})
.controller('authController',function($scope,$http){
    $scope.error_message='';
    $scope.user={user_name:'',password:''};

    $scope.login=function()
    {
        $scope.error_message='login_requested for '+$scope.user.user_name;
    }
    $scope.register=function()
    {
        $scope.error_message='registration_requested for '+$scope.user.user_name;
    } 
});