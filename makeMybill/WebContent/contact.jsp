<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
			<meta name="description" content="A Bootstrap based app landing page template">
			<meta name="author" content="">
			<link rel="shortcut icon" href="assets/ico/favicon.png">

			<title>makeMybill || Features</title>

			<!-- Bootstrap core CSS -->
			<link href="css/bootstrap.min.css" rel="stylesheet">

			<!-- Custom styles for this template -->
			<link href="css/custom.css" rel="stylesheet">
			<link href="css/flexslider.css" rel="stylesheet">
			
			<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
			<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,700' rel='stylesheet' type='text/css'>
			<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'>

			<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
			<!--[if lt IE 9]-->
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
			<!-- [endif]-->
					<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
			<script src="js/logIn.js"></script>
		</head>

		<body ng-app="home">
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
							
											 <li><a href="home.jsp">Home</a></li>						
							<li><a href="features.jsp">Features</a></li>
							<li><a href="complain.jsp">Complain</a></li>
							<li><a href="contact.jsp">Contact Us</a></li>
							<%if(null==session || null==session.getAttribute("bill")) {%>
							<li><a href="" data-toggle="modal" data-target="#login-modal">Log In</a></li><%}else{ %>
								<li><a href="user.jsp">Bill</a></li>
								 <li><a href="signOut">Log Out</a></li>
								<%} %>
						</ul>
					</div><!--/.nav-collapse -->
				</div>
			</div>
	
		
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog" >
				<div class="loginmodal-container" ng-controller="login">
					<h1>Login to Your Account</h1><br>
				  
					<input type="text" name="userId" id="userId" ng-model="user.id" placeholder="Username or email">
					<input type="password" name="password" id="password" ng-model="user.password" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit" ng-click="logIn()" style="width: 100%;" value="Login">
				  <span id="logInError" style="color: red">{{logInError}}</span>
					
				  <div class="login-help">
					
				  </div>
				</div>
			</div>
		  </div>
		  
<br>
<br>
<br>
<br>
		<div id="contactWrap">
		<div class="overlay">
			<div class="container">
				<div class="row">
						<div class="col-xs-12">
						<h2 class="sectionTitle">Contact us</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 text-center">
						<div class="blurb">
						 Send us a message. We'd love to hear from you!
						</div>
					</div>
				</div>
					<div class="row" ng-controller="contactUs">
						<div class="col-sm-4 col-sm-offset-2">
							<div class="inputContainer">
							<label>Name</label>
								<input type="text" name="contactName" id="contactName" value="" ng-model="user3.name" class="form-control" autocomplete="off" />
							</div>
						</div>
						<div class="col-sm-4">
							<div class="inputContainer">
							<label class="screen-reader-text">Email</label>
								<input type="text" name="email" id="email" value="" ng-model="user3.email" class="form-control" autocomplete="off"  />
							</div>
						</div>
						<div class="col-sm-8 col-sm-offset-2">
							<div class="inputContainer">
							<label class="screen-reader-text">Message</label>
								<textarea name="comments" id="commentsText" class="form-control" ng-model="user3.message" autocomplete="off"></textarea>
							</div>
						</div>
						<div class="col-sm-8 col-sm-offset-2">
							<button name="submit" type="button" class="btn btn-primary btn-lg" ng-click="contact()">Send</button>
							<br>
							<span id="contactError" style="color: red" >{{contactError}}</span>
       <span id="contactStatus" >{{contactStatus}}</span>
						</div>
						
					</div>
			</div>
		</div>
	</div> <!-- /contactWrap -->
	
	
	
	
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 text-center">
					<p>Copyright &copy; 2016 makeMybill - Electricity Billing Automation and Complain Registration. All Rights Reserved</p>
					<p class="social">
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