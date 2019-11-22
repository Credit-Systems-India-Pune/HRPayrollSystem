<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/User"></c:url>


<div class="row">
	<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3">
		<div class="panel panel-default ors-form-pannel">
			<div class="panel-heading">


				<c:if test="${form.id ==0}">
					<s:message code="label.addUser" />
				</c:if>
				<c:if test="${form.id>0}">
					<s:message code="label.updateUser" />
				</c:if>



			</div>


			<div class="panel-body">
				<%@include file="BusinessMessage.jsp"%>


				<sf:form action="${addUrl}" method="post" commandName="form"
					cssClass="form-horizontal">

					<sf:hidden path="id" />

					<s:bind path="firstName">
						
						<div class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="firstName" cssClass="col-sm-3">
								<s:message code="label.firstName" />
							</sf:label>
						
							<div class="col-sm-9">
								<sf:input path="firstName" class="form-control" />
								<sf:errors path="firstName" cssClass="help-block" />
							</div>
							
							
						</div>
					</s:bind>

					<s:bind path="lastName">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="lastName" cssClass="col-sm-3">
								<s:message code="label.lastName" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="lastName" class="form-control" />
								<sf:errors path="lastName" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="fatherName">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="motherName">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					
						<s:bind path="dob">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="dob" cssClass="col-sm-3">
								<s:message code="label.dob" />
							</sf:label>
							<div class="col-sm-9" data-datepicker date-format="MM/dd/yyyy"
							 date-typer="true"  date-max-limit="{{maxDate}}"  date-min-limit="{{minDate1}}">
							 
								<sf:input path="dob" class="form-control" />
								<sf:errors path="dob" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					
					

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

					<s:bind path="confirmPassword">
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

					<s:bind path="mobileNo">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>

					<s:bind path="gender">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options items="${genderMap}" />
								</sf:select>
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>


					<s:bind path="roleId">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">

							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.role" />
							</sf:label>
							
							
							<div class="col-sm-9">

								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="roleName" itemValue="id"
										items="${roleList}" />
								</sf:select>


								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="emailId">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					
					<s:bind path="doj">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="doj" cssClass="col-sm-3">
								<s:message code="label.doj" />
							</sf:label>
							<div class="col-sm-9" data-datepicker date-format="MM/dd/yyyy"
							 date-typer="true"  ">
							 
								<sf:input path="doj" class="form-control" />
								<sf:errors path="doj" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="designation">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="education">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="department">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="language">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="sSkill">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="pSkill">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="${status.expression}" cssClass="col-sm-3">
								<s:message code="label.${status.expression}" />
							</sf:label>
							<div class="col-sm-9">
								<sf:input path="${status.expression}" class="form-control" />
								<sf:errors path="${status.expression}" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="currentAddress">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="currentAddress" cssClass="col-sm-3">
								<s:message code="label.currentAddress" />
							</sf:label>
							<div class="col-sm-9">
								<sf:textarea path="currentAddress" cssClass="form-control" />
								
								<sf:errors path="currentAddress" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					<s:bind path="permanentAddress">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="currentAddress" cssClass="col-sm-3">
								<s:message code="label.permanentAddress" />
							</sf:label>
							<div class="col-sm-9">
								<sf:textarea path="permanentAddress" cssClass="form-control" />
								
								<sf:errors path="permanentAddress" cssClass="help-block" />
							</div>
						</div>
					</s:bind>
					
					

				

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">

							<button type="submit" value="save" name="operation"
								class="btn btn-default">
								<s:message code="label.save" />
							</button>

							<c:if test="${form.id ==0}">
								
							<button class="btn btn-default" type="submit" value="Reset"
								name="operation">
								<s:message code="label.reset"></s:message>
							</button>

							</c:if>
							<c:if test="${form.id>0}">
								
							<button class="btn btn-default" type="submit" value="Cancel"
								name="operation">
								<s:message code="label.cancel"></s:message>
							</button>

							</c:if>





						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>