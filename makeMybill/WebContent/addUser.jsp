<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
			<meta name="description" content="A Bootstrap based app landing page template">
			<meta name="author" content="">
			<link rel="shortcut icon" href="assets/ico/favicon.png">

			<title>makeMybill || Home</title>

			<!-- Bootstrap core CSS -->
			<link href="css/bootstrap.min.css" rel="stylesheet">

			<!-- Custom styles for this template -->

        <link rel="stylesheet" href="css/style.css">
			<link href="css/custom.css" rel="stylesheet">
			<link href="css/flexslider.css" rel="stylesheet">
			
			<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
			<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,700' rel='stylesheet' type='text/css'>
			<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'>

			<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
			<!--[if lt IE 9]-->
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
			<![endif]-->
				<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
			<script src="js/admin.js"></script>
		</head>

		<body ng-app="admin">
			<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#topWrap">
							<span class="fa-stack fa-lg">
								<img src="assets/img/mybill.png" width="60" height="65"></img>
							</span>
							makeMy<span class="title">bill</span>
						</a>
					</div>
					<div class="collapse navbar-collapse appiNav">
						<ul class="nav navbar-nav">
							
							 <li><a href="adminHome.jsp">Home</a></li>
							<li><a href="addUser.jsp">Add User</a></li>
							<li><a href="updateBill.jsp">Update Bill </a></li>
							<li><a href="complainList.jsp">Complains </a></li>
							<li><a href="contactList.jsp">Contacts </a></li>
								<li><a href="signOut">Log Out </a></li>
							
						    
						</ul>
					</div><!--/.nav-collapse -->
				</div>
			</div>


	
			
<br><br><br><br><br><br>
	<div ng-controller="addUser">
<div id="addUserForm" style="margin-left: 35%;">
 <form class="form-group">
 <label for="usr" style="font-size: 20px">User ID:</label>
 <input class="form-control" ng-model="user.username" id="username" style="max-width:400px;" required="required">
 <label for="usr" style="font-size: 20px">Password:</label>
 <input class="form-control" ng-model="user.password" id="password" style="max-width:400px;"  required="required">
  <label for="usr" style="font-size: 20px">Meter ID:</label>
 <input class="form-control" ng-model="user.meterId" id="meterId" style="max-width:400px;"  required="required">
  <label for="usr" style="font-size: 20px">Last Paid Month:</label>
 <input class="form-control" ng-model="user.lastMonthPaid" id="lastMonthPaid" style="max-width:400px;"  required="required">
  <label for="usr" style="font-size: 20px">Bill Till:</label>
 <input class="form-control" ng-model="user.billTill" id="billTill" style="max-width:400px;"  required="required">
  <label for="usr" style="font-size: 20px">Last Paid Amount:</label>
 <input class="form-control" ng-model="user.lastPaidAmount" id="lastPaidAmount" style="max-width:400px;"  required="required">
 <label for="usr" style="font-size: 20px">Total Paid:</label>
 <input class="form-control" ng-model="user.totalPaid" id="totalPaid" style="max-width:400px;"  required="required">
 <label for="usr" style="font-size: 20px">Current Reading:</label>
 <input class="form-control" ng-model="user.currReading" id="currReading" style="max-width:400px;"  required="required">
 <input type="button" ng-click="addUser()" class="btn btn-default navbar-btn" style="width:100px;font-size: 15px" value="Add"/><br>
 <span id=addError">{{addError}}</span>
<span id="addStatus">{{addStatus}}</span>
 </form>
</div>
	</div>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 text-center">
<p>Copyright &copy; 2016 makeMybill - Electricity Billing Automation and Complain Registration. All Rights Reserved</p>					<p class="social">
						<a href="https://www.facebook.com/bootstrapbay">
							<span class="fa-stack fa-lg">
								<i class="fa fa-circle fa-stack-2x"></i>
								<i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
							</span>
						</a>
						<a href="https://twitter.com/bootstrapbay">
							<span class="fa-stack fa-lg">
								<i class="fa fa-circle fa-stack-2x"></i>
								<i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a>
						<a href="https://plus.google.com/+BootstrapbayThemes">
							<span class="fa-stack fa-lg">
								<i class="fa fa-circle fa-stack-2x"></i>
								<i class="fa fa-google-plus fa-stack-1x fa-inverse"></i>
							</span>
						</a>
						<a href="http://www.youtube.com/user/bootstrapbayofficial">
							<span class="fa-stack fa-lg">
								<i class="fa fa-circle fa-stack-2x"></i>
								<i class="fa fa-youtube fa-stack-1x fa-inverse"></i>
							</span>
						</a>
					</p>
				</div>
			</div>
		</div>
	</footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/flexslider.js"></script>
	
<script type="text/javascript">
$(document).ready(function() {
	$('.mobileSlider').flexslider({
		animation: "slide",
		slideshowSpeed: 3000,
		controlNav: false,
		directionNav: true,
		prevText: "&#171;",
		nextText: "&#187;"
	});
	$('.flexslider').flexslider({
		animation: "slide",
		directionNav: false
	});
		
	$('a[href*=#]:not([href=#])').click(function() {
		if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') || location.hostname == this.hostname) {
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			if ($(window).width() < 768) {
				if (target.length) {
					$('html,body').animate({
						scrollTop: target.offset().top - $('.navbar-header').outerHeight(true) + 1
					}, 1000);
					return false;
				}
			}
			else {
				if (target.length) {
					$('html,body').animate({
						scrollTop: target.offset().top - $('.navbar').outerHeight(true) + 1
					}, 1000);
					return false;
				}
			}
		}
	});
	
	$('#toTop').click(function() {
		$('html,body').animate({
			scrollTop: 0
		}, 1000);
	});
	
	var timer;
    $(window).bind('scroll',function () {
        clearTimeout(timer);
        timer = setTimeout( refresh , 50 );
    });
    var refresh = function () {
		if ($(window).scrollTop()>100) {
			$(".tagline").fadeTo( "slow", 0 );
		}
		else {
			$(".tagline").fadeTo( "slow", 1 );
		}
    };
		
});
</script>
  </body>
</html>