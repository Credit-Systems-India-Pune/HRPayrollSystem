<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="forget" value="/Login/ForgetPassword"/>

<c:url var="signup" value="/Login/SignUp"/>


<div class="row">
	<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3">
		<div class="panel panel-default ors-form-pannel">
			
			<div class="panel-heading">
				
					<s:message code="label.login" />
				
			</div>
			
			<div class="panel-body">
			 <%@include file="BusinessMessage.jsp"%> 
			
				<sf:form action="Login" method="post" commandName="form"
					cssClass="form-horizontal">
			
					<s:bind path="login">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="login" cssClass="col-sm-3">
								<s:message code="label.login" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="login" class="form-control" />
						
								<sf:errors path="login" cssClass="help-block" />
							</div>
						</div>
					</s:bind>

					<s:bind path="password">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input type="password" path="${status.expression}"
									class="form-control" />
								
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" value="save" name="operation"
								class="btn btn-default">
								<s:message code="label.login" />
							</button>
							
							<a class="btn btn-default" href="${signup}"> <s:message code="label.signUp"/></a>

						</div>
					</div>
					<div class="form-group">
					
					<div class="col-sm-offset-3 col-sm-9">
					<a href="${forget}"> <s:message code="label.forgetPassword"/></a>	
					</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>