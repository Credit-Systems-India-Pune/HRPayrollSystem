<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>



<c:url var="addUrl" value="/ctl/Attendance" />

<c:url var="addSearch" value="/ctl/Attendance/Search" />

<c:url var="editUrl" value="/ctl/Attendance?id=" />



<div class="row">
	<div class="col-sm-12 col-sm-offset-0 col-md-12 col-md-offset-0">
		<div class="panel panel-default ors-form-pannel">
			<div class="panel-heading">
				<s:message code="label.listAttendance" />
			</div>



			<div class="panel-body">

				<%@include file="BusinessMessage.jsp"%>

				<div class="ors-justify-center">

					<sf:form action="${addSearch }" method="post"
						cssClass="form-inline " commandName="form">

						<s:bind path="name">

							<div class="form-group">

								<sf:label path="name">
									<s:message code="label.name" />
								</sf:label>

								<sf:input path="name" class="form-control" />
							</div>
						</s:bind>

						<button type="submit" class="btn btn-default">
							<s:message code="label.search" />
						</button>

						<button class="btn btn-default" type="submit" value="Reset"
							name="operation">
							<s:message code="label.reset"></s:message>
						</button>
					</sf:form>
				</div>







				<sf:form action="${addSearch }" method="post"
					cssClass="form-inline " commandName="form" style="overflow-x: auto">


					<sf:input type="hidden" path="name" />
					<sf:input type="hidden" path="pageNo" />
					<sf:input type="hidden" path="pageSize" />

					<sf:input type="hidden" path="listsize" />
					<sf:input type="hidden" path="total" />
					<sf:input type="hidden" path="pagenosize" />


					<table id="listTable"
						class="table table-striped table-condensed  table-responsive">
						<thead>
							<tr>
								<th><span class="btn btn-default btn-sm"> <input
										type="checkbox" id="selectall"> <s:message
											code="lable.selectAll" />
								</span></th>
								<th><s:message code="label.name" /></th>
								<th><s:message code="label.emailId" /></th>
								<th><s:message code="label.sDate" /></th>
								<th><s:message code="label.status" /></th>
								<th><s:message code="label.edit" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="at" varStatus="ct">
								<tr>
									<td><input type="checkbox" name="ids" class="case" value="${at.id}"></td>
									<td><c:out value="${at.name}" /></td>
									<td><c:out value="${at.emailId}" /></td>
									<td><fmt:formatDate pattern="MM/dd/yyyy"
											value="${at.aDate}" /></td>
									<td><c:out value="${at.status}" /></td>
									<td><a href="${editUrl} ${at.id}"><span
								class="glyphicon glyphicon-pencil"></span>
												</a>

											</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>



					<ul class="pager">
						<li><button type="submit" class="btn"
								<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
								name="operation" value="Previous">

								<span class="glyphicon glyphicon-backward"></span>&nbsp;
								<s:message code="label.previous" />

							</button>
						<li><input type="button" class="btn btn-info"
							onclick="location.href='<c:url value="/ctl/Attendance" />';"
							value="<s:message code="label.new" />" /></li>

						<li><button type="submit" class="btn btn-info"
								<c:if test="${listsize== 0}">disabled="disabled"</c:if>
								name="operation" value="Delete">
								<s:message code="label.delete" />
								&nbsp;
							</button></li>



						<li><button style="margin-top: 3px;" type="submit"
								class="btn"
								<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
								name="operation" value="Next">
								<s:message code="label.next" />
								&nbsp;<span class="glyphicon glyphicon-forward"></span>
							</button></li>

					</ul>




				</sf:form>



			</div>


		</div>
	</div>
</div>
