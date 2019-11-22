<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@page isELIgnored="false"%>

<div class="nav-side-collapse-menu" id="navSideCollapseMenu1">


	<aside class="nav-side-menu nav-side-lg">

		<ul class="nav-menu" collapse-nav-menu>

			<ul
				class="nav navbar-nav navbar-right  user-profile visible-xs  visible-md ">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <b> <s:message
								code="label.welcome" /> ${userLogin.firstName}
							(${roleLogin.roleName}) </span></b> <span class="caret"></span></a>


					<ul class="dropdown-menu">
						<li><a href="<c:url value="/ctl/User/profile"/>"><span
								class="glyphicon glyphicon-user	
"></span> <s:message
									code="label.myProfile" /></a></li>
						<li><a href="<c:url value="/ctl/User/changepassword"/>"><span
								class="glyphicon glyphicon-cog	
"></span> <s:message
									code="lable.changePassword" /></a></li>




						<li><a href="<c:url value="/resources/doc/index.html" />"
							target="_blank"><span class="glyphicon glyphicon-book"></span>
								<s:message code="label.javadoc" /></a></li>


						<c:url var="log" value="/Login" />
						<li><a style="color: red" href="${log}"> <span
								class="glyphicon glyphicon-log-out"></span> <s:message
									code="label.logout" />
						</a></li>

					</ul></li>
			</ul>

			<ul class="nav navbar-nav">



				


<c:choose>

<c:when test="${sessionScope.roleLogin.id == 1}">  
         
         
         
         		<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.employee" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/User"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addEmployee" /></a></li>



						<li><a href="<c:url value="/ctl/User/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listEmployee" /></a></li>
					</ul></li>

					

		         		<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.salary" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/Salary"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addSalary" /></a></li>



						<li><a href="<c:url value="/ctl/Salary/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listSalary" /></a></li>
				</ul></li>	
				
				
				
		         		<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.leave" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/Leave"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addLeave" /></a></li>



						<li><a href="<c:url value="/ctl/Leave/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listLeave" /></a></li>
				</ul></li>	
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.timeSheet" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/TimeSheet"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addTimeSheet" /></a></li>



						<li><a href="<c:url value="/ctl/TimeSheet/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listTimeSheet" /></a></li>
				</ul></li>	
				
					<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.attendance" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/Attendance"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addAttendance" /></a></li>



						<li><a href="<c:url value="/ctl/Attendance/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listAttendance" /></a></li>
				</ul></li>			
															
						         
    </c:when>  
<c:otherwise>  
			<ul class="nav navbar-nav">
			
			
			<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.leave" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/Leave"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addLeave" /></a></li>



						<li><a href="<c:url value="/ctl/Leave/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listLeave" /></a></li>
				</ul></li>	
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.attendance" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


						<li><a href="<c:url value="/ctl/Attendance"/>"><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="label.addAttendance" /></a></li>



						<li><a href="<c:url value="/ctl/Attendance/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listAttendance" /></a></li>
				</ul></li>	
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="label.timeSheet" />

						<span class="caret"></span></a>

					<ul class="dropdown-menu">


					



						<li><a href="<c:url value="/ctl/TimeSheet/Search"/>"><span
								class="glyphicon glyphicon-list-alt"></span> <s:message
									code="label.listTimeSheet" /></a></li>
				</ul></li>
				
			</ul>    </c:otherwise>  
</c:choose>



		

		</ul>
	</aside>
</div>
