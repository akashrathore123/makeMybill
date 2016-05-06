var app = angular.module('home',[]);
app.controller('login',function($scope,$http,$window)
		{
  $scope.logIn = function(){
	
	var pass = document.getElementById("password").value;
	var userId = document.getElementById("userId").value;
	
	if(userId=="" || userId==undefined){
		$scope.logInError = "* Enter Password";
	    return;
	}
	if(pass==""||pass==undefined){
		$scope.logInError = "* Enter Password";
		return;
	}
	var user1 = $scope.user;
	 $http({
		 

         method : 'POST',
         url : 'logInCheck',
         headers: {'Content-Type': 'application/json'},
         data : user1
     }).
     success(function(data,status,headers,config){

//      	spinner.stop();
     	$window.location="user.jsp";
     })
	 .error(function(data,status,headers,config){
		 if(status==500){
			 $window.location="error500.jsp";
		 }else
			
		 $scope.logInError=data;
		 
	 });

}
  });