<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script 
type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js">
</script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="/PayrollManagement/resources/js/jquery.min.js"></script>

<script src="/PayrollManagement/resources/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/ORSProject0/css/Bootstrap.css">



<link rel="stylesheet"
	href="/PayrollManagement/resources/css/font-awesome.min.css">

<link href="/PayrollManagement/resources/css/ors_them.css" rel="stylesheet" type="text/css" />

<link href="/PayrollManagement/resources/css/ors_form.css" rel="stylesheet" type="text/css"/>	

 
 <style type="text/css">
 
 .nav>li {
	position: relative;
	display: inline
}

.row {
	margin-right: -15px;
	margin-left: -15px;
	margin-top : 30px;
}

 
 </style>
 
 <!-- Compulsary needed -->
<!--  <base href="/ORSProject0/"> -->
 
 
 
 <link rel="stylesheet" type="text/css" href="/PayrollManagement/resources/css/angular-datepicker.css">

<script type="text/javascript" src="/PayrollManagement/resources/js/angular.min.js"></script>

 <script type="text/javascript" src="/PayrollManagement/resources/js/angular-locale_en.js"></script>
<script type="text/javascript" src="/PayrollManagement/resources/js/angular-datepicker.js"></script>  
<script type="text/javascript" src="/PayrollManagement/resources/js/index.js"></script>


</head>


<body  data-ng-app="720" ng-controller="TestController as ctrl">


	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<div id="page">

		<div id="body" style="margin-left: 0">


			<tiles:insertAttribute name="body"></tiles:insertAttribute>

		</div>

	</div>
	
<tiles:insertAttribute name="footer"></tiles:insertAttribute>

</body>
</html>