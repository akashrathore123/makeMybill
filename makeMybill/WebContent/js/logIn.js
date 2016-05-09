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



app.controller('addComplain',function($scope,$http,$window)
		{
  $scope.registerComplain = function(){
	$scope.complainError="";
	$scope.complainStatus="";
	
	
	var user2 = $scope.user1;
	 $http({
		 

         method : 'POST',
         url : 'addComplain',
         headers: {'Content-Type': 'application/json'},
         data : user2
     }).
     success(function(data,status,headers,config){

         	$scope.complainStatus=data;
         	})
	 .error(function(data,status,headers,config){
		 if(status==500){
			 $window.location="error500.jsp";
		 }else
			
		 $scope.complainError=data;
		 
	 });

}
  });

app.controller('contactUs',function($scope,$http,$window)
		{
  $scope.contact = function(){
	$scope.contactError="";
	$scope.contactStatus="";

	var user = $scope.user3;
	 $http({
		 

         method : 'POST',
         url : 'addContact',
         headers: {'Content-Type': 'application/json'},
         data : user
     }).
     success(function(data,status,headers,config){
    	
         	$scope.contactStatus=data;
         	})
	 .error(function(data,status,headers,config){
		 if(status==500){
			 $window.location="error500.jsp";
		 }else
			
			
		 $scope.contactError=data;
		 
	 });

}
  });

