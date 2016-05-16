var app = angular.module('admin',[]);
app.controller('adminLogin',function($scope,$window,$http){
	
	$scope.login = function(){
	console.log("hey");
				
				var pass = document.getElementById("password").value;
				var userId = document.getElementById("username").value;
				
				if(userId=="" || userId==undefined){
					$scope.logInError = "* Enter username";
				    return;
				}
				if(pass==""||pass==undefined){
					$scope.logInError = "* Enter Password";
					return;
				}
				var user1 = $scope.user;
				 $http({
					 

			         method : 'POST',
			         url : 'adminLogIn',
			         headers: {'Content-Type': 'application/json'},
			         data : user1
			     }).
			     success(function(data,status,headers,config){

			     	$window.location="adminHome.jsp";
			     	console.log("done");
			     })
				 .error(function(data,status,headers,config){
					 if(status==500){
						 $window.location="error500.jsp";
					 }else
						
					 $scope.logInError=data;
					 
				 });

			}
});
app.controller('addUser',function($scope,$window,$http){
	
	$scope.addUser = function(){
		
		var userId = $scope.user.username;
		console.log(userId);
		addError = "";
		addStatus = "";
		
		
		
		 $http({
			 

	         method : 'POST',
	         url : 'addUser',
	         headers: {'Content-Type': 'application/json'},
	         data : $scope.user
	     }).
	     success(function(data,status,headers,config){

	     	$scope.addStatus = data;
	     	console.log("done");
	     })
		 .error(function(data,status,headers,config){
			 if(status==500){
				 $window.location="error500.jsp";
			 }else
				
			 $scope.addError=data;
			 
		 });
	}
	
});