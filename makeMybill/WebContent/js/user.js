var app = angular.module('user',[]);
app.controller('data',function($scope,$http,$window)
		{
 
	
	
	 $http({
		 

         method : 'POST',
         url : 'dataFetch',
         headers: {'Content-Type': 'application/json'},
         data : ''
     }).
     success(function(data,status,headers,config){

//      	spinner.stop();
     	$scope.bill = data;
     	console.log(data);
     })
	 .error(function(data,status,headers,config){
		 if(status==500){
			 $window.location="error500.jsp";
		 }else
			
			 $window.location="error404.jsp";
		 
	 });
	 
	 $scope.sendMail= function(){
		 $http({
			 

	        method : 'POST',
	        url : 'sendMail',
	        headers: {'Content-Type': 'application/json'},
	        data : ''
	    }).
	    success(function(data,status,headers,config){

//	     	spinner.stop();
	    	$scope.mailStatus = data;
	    	console.log(data);
	    })
		 .error(function(data,status,headers,config){
			 if(status==500){
				 $window.location="error500.jsp";
			 }else
				
				 $window.location="error404.jsp";
			 
		 });
	}

	

  });