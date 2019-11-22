<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page isELIgnored="false"%>

<c:url var="wel" value="/ctl/Welcome" />

<nav class="navbar navbar-fixed-top ors-nav-top navbar-inverse">
	<div class="container-fluid navbar-clear ">
		<div class="navbar-header" style="margin-top: 19px">
			
			
			<!-- 
			<img class="brand-image" alt=""
				src="/ORSProject0/resources/img/Logo.png"> -->


	<a href="${wel}" style="font-family: inherit; font-size: 28px; margin-left: 10px; color: #213a5f; text-decoration:none; ">PayRoll Management
			</a>



			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-navbar-toggle
				data-target="#navSideCollapseMenu1" aria-expanded="false">


				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>






			<ul class="nav navbar-nav navbar-right visible-lg " >
			
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" style="background-color: white" > <b>
				
				
					<font color="blue">
					 <s:message
								code="label.welcome" /> 
							
							${userLogin.firstName}
							(${roleLogin.roleName})
							
							
							
							 </span></b> <span class="caret"></span> </font>	</a> 
							 
							 
							 <c:url var="pro" value="/ctl/User/profile" />

					<ul class="dropdown-menu" >
						<li><a href="${pro}"><span
								class="glyphicon glyphicon-user"></span> <s:message
									code="label.myProfile" /></a></li>


						<li><a href="<c:url value="/ctl/User/changepassword"/>">
								<span class="glyphicon glyphicon-cog"></span> <s:message
									code="lable.changePassword" />
						</a></li>
						
						
						
					

						


					
						
						
						
						<c:url var="log" value="/Login" />

						<li><a style="color: red" href="${log}"> <span
								class="glyphicon glyphicon-log-out"></span> <s:message
									code="label.logout" />
						</a></li>

					</ul></li>
			</ul>

		</div>
	</div>
</nav>
