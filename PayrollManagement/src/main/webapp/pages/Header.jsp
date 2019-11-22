<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@page isELIgnored="false"%>



<nav class="navbar navbar-fixed-top ors-nav-top">
	<div class="container-fluid navbar-clear ">

		<button type="button" class="navbar-toggle collapsed "
			data-toggle="collapse" data-navbar-toggle
			data-target="#navSideCollapseMenu" aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>


		</button>

		<c:url var="log" value="/Login" />
		<c:url var="sign" value="/Login/SignUp" />
<c:url var="wel" value="/Welcome" />

		<div class="navbar-header">


			<!-- <img class="brand-image" alt="" src="resources/img/Logo.png"> -->
			
			<a href="${wel}" style="font-family: inherit; font-size: 28px; margin-left: 10px; color: #213a5f; text-decoration:none;  ">PayRoll Management
			</a>


			<ul class="nav navbar-nav navbar-right " id="navSideCollapseMenu">



				<li class="user-profile"><a href="${log}"><s:message
							code="label.login" /></a></li>


				<li class="user-profile"><a href="${sign}"><s:message
							code="label.signUp" /></a></li>

						
					
			</ul>



		</div>
	</div>
</nav>
