<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>


<c:url var="addUrl" value="/ctl/TimeSheet"></c:url>

<div class="row">
	<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3">
		<div class="panel panel-default ors-form-pannel">
			<div class="panel-heading">
				<c:if test="${form.id ==0}">
					<s:message code="label.addTimeSheet" />
				</c:if>
				<c:if test="${form.id>0}">
					<s:message code="label.updateTimeSheet" />
				</c:if>
			</div>
			<div class="panel-body">
				<%@include file="BusinessMessage.jsp"%>


				<sf:form action="${addUrl}" method="post" commandName="form"
					cssClass="form-horizontal">

					<sf:hidden path="id" />
		
				
					<s:bind path="name">
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
					
					<s:bind path="tDate">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="tDate" cssClass="col-sm-3">
								<s:message code="label.sDate" />
							</sf:label>

							<div class="col-sm-9" data-datepicker date-format="MM/dd/yyyy"
								date-typer="true" date-max-limit="{{maxDate}}"
								date-min-limit="{{minDate1}}">

								<sf:input path="tDate" class="form-control"  />

								<sf:errors path="tDate" cssClass="help-block" />

							</div>


						</div>
					</s:bind>
					
					<s:bind path="hours">
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
					
					
					<s:bind path="description">
						<div
							class="form-group has-feedback ${status.error ? 'has-error' : ''}">
							<sf:label path="description" cssClass="col-sm-3">
								<s:message code="label.description" />
							</sf:label>
							<div class="col-sm-9">
								<sf:textarea path="description" cssClass="form-control" />
								
								<sf:errors path="description" cssClass="help-block" />
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
								<button class="btn btn-default" type="submit" value="cancel"
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