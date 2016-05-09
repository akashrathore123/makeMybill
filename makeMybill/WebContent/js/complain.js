console.log("hey");
var app = angular.module('complain',[]);
app.controller('addComplain',function($scope,$http,$window)
		{
  $scope.registerComplain = function(){
	
	
	
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

