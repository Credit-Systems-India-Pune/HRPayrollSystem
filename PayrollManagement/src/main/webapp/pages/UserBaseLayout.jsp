<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<html>
<head>

<!-- <base href="/ORSProject0/"> -->


<script 
type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js">
</script>


<script language="javascript">
$(function(){
	$("#selectall").click(function () {
		  $('.case').attr('checked', this.checked);
	});
	$(".case").click(function(){

		if($(".case").length == $(".case:checked").length) {
			$("#selectall").attr("checked", "checked");
		} else {
			$("#selectall").removeAttr("checked");
		}

	});
});

</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="/PayrollManagement/resources/js/jquery.min.js"></script>

<script src="/PayrollManagement/resources/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="/PayrollManagement/resources/css/font-awesome.min.css">


	
	
	
<link rel="stylesheet" type="text/css" href="/PayrollManagement/resources/css/angular-datepicker.css">

<script type="text/javascript" src="/PayrollManagement/resources/js/angular.min.js"></script>

<script type="text/javascript" src="/PayrollManagement/resources/js/angular-locale_en.js"></script>
<script type="text/javascript" src="/PayrollManagement/resources/js/angular-datepicker.js"></script>
<script type="text/javascript" src="PayrollManagement/resources/js/index.js"></script>
	

<style type="text/css">

.panel-heading {
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px
	text-align: center;
    text-decoration-color: black;
}




html {
	height: 100%
}

body {
	height: 100%
}

#page {
	height: 100%;
	padding-top: 80px;
}

#body {
	min-height: calc(100% - 40px);
	background-color: #f0f0f0;
	margin-left: 150px;
	padding-top: 20px;
}

.body {
	min-height: calc(100%);
	padding-top: 70px;
	position: relative;
	top: 0;
	margin-top: 0;
}

.footer {
	background-color:  white;
	color: black;
	bottom: 0;
	width: 100%;
	text-align: right;
	
	padding: 10px 0px;
	box-shadow: 0 3px 1px -2px rgba(2, 2, 2, .14), 0 2px 2px 0 rgba(0, 0, 0, .098), -1px 2px 8px 5px rgba(1, 1, 6, 0.98);
	
}

#page {
	height: calc(100%);
	padding-top: 80px;
}

/* ////////Left//////// */
@media ( max-width : 768px) {
	.nav-side-collapse-menu {
		display: none;
	}
}

.nav-side-collapse-menu {
	position: fixed;
	top: 80px;
	left: 0;
	bottom: 0;
	z-index: 1000;
}

.nav-side-collapse-menu .nav-side-lg {
	width: 150px;
}

.nav-side-menu {
	overflow-y: scroll;
	overflow-x: scroll;
	height: 100%;
	background-color:  white;
	padding-top: 15px;
	box-shadow: 0 3px 1px -2px rgba(2, 2, 2, .14), 0 2px 2px 0 rgba(0, 0, 0, .098), -1px 2px 8px 5px rgba(1, 1, 6, 0.98);
}

.nav-side-menu .nav-menu {
	list-style: none;
	padding: 0;
	text-align: center;
	margin-bottom: 0;
}

.nav-side-menu .user-profile .user-profile-img {
	width: 50px;
	height: 50px;
}

.nav-side-menu .user-profile .user {
	display: block;
}

.nav-side-menu .user-profile .role {
	display: block;
	font-size: 12px;
}

.nav-side-menu .nav-menu>li>a {
	color: grey;
	font-size: 16px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.nav-side-menu .nav-menu>li a {
	display: block;
	color: rgb(119, 119, 120);
}

.nav-side-menu .nav-menu>li>a:hover {
	color: rgb(195, 195, 195);
	background-color: rgba(78, 80, 96, 0.35);
	text-decoration: none;
}

.nav-side-menu .nav-menu>li a:hover {
	text-decoration: none;
	color: rgb(195, 195, 195);
	border-left: 4px solid black;
	padding-right: 4px;
}

.nav-side-menu .nav-menu>li.open>a {
	background-color: red;
	color: rgb(195, 195, 195);
	border-left: 4px solid black;
	padding-right: 4px;
}

.nav-side-menu .nav-menu>li>ul {
	list-style: none;
	padding: 0;
	margin: 0px 10px;
	background-color: rgba(78, 80, 96, 0.35);
	display: none;
	border-bottom: 1px solid white;
}

.nav-side-menu .nav-menu>li>ul>li>a {
	display: block;
	padding: 5px 0;
}

.nav-side-menu .nav-menu>.select {
	padding-bottom: 5px;
	border-bottom: 1px solid white;
}

.nav-side-menu .nav-menu>a:hover {
	color: rgb(119, 119, 120);
	background-color: rgba(38, 39, 47, 1);
	border-left-color: rgba(38, 39, 47, 1);
}



a {
    color: #0041d8;
    text-decoration: none;
}
/* userheader  */
.ors-nav-top {
	margin-bottom: 0;
	height: 80px;
	background-color: white;
	box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .14), 0 2px 2px 0
		rgba(0, 0, 0, .098), 0 1px 5px 0 rgba(0, 0, 0, .084);
}

.ors-nav-top .brand-image {
	height: 70px;
	width: 150px;
	padding-top: 5px;
	padding-bottom: 5px;
	
}

.ors-nav-top .navbar-toggle {
	margin-top: 20px;
	border: 1px solid rgba(38, 39, 47, 1);
	border-radius: 0px;
}

.ors-nav-top .navbar-toggle .icon-bar {
	background-color: rgba(38, 39, 47, 1);
}

.ors-nav-top .navbar-header {
	width: 100%;
}

.ors-nav-top .dropdown-menu {
	width: 100%;
}

.ors-nav-top li>a {
	color: blue;
}

.navbar-inverse .navbar-toggle:focus, .navbar-inverse .navbar-toggle:hover
	{
	background-color: #f3efef;
}


.ors-nav-top li>a:hover, .ors-nav-top li>a:focus, .ors-nav-top li.open>a
	{
	background-color: transparent important;
}

.ors-nav-top .navbar-right {
	margin-right: 5px;
}

.ors-nav-top .user-profile>a {
	margin-top: 10px;
}

.ors-nav-top .user-profile:hover>a, .ors-nav-top .user-profile.open>a {
	border: 1px solid rgba(0, 0, 0, .15);
	-webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
	box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
}

.ors-nav-top .user-profile-img {
	width: 25px;
	height: 25px;
}

@media ( min-width : 768px) {
	.ors-nav-top .navbar-clear {
		/* padding-left: 150px; */
		
	}
}
</style>


</head>
<body data-ng-app="720" ng-controller="TestController as ctrl">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<tiles:insertAttribute name="menu"></tiles:insertAttribute>

	<div id="page">

		<div id="body">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>

		</div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>