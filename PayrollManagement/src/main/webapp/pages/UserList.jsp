<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>



<c:url var="addUrl" value="/ctl/User" />

<c:url var="addSearch" value="/ctl/User/Search" />

<c:url var="editUrl" value="/ctl/User?id=" />



<div class="row">
	<div class="col-sm-12 col-sm-offset-0 col-md-12 col-md-offset-0">
		<div class="panel panel-default ors-form-pannel">
			<div class="panel-heading">
				<s:message code="label.listUser" />
			</div>



			<div class="panel-body">

				<%@include file="BusinessMessage.jsp"%>

				<div class="ors-justify-center">

					<sf:form action="${addSearch }" method="post"
						cssClass="form-inline " commandName="form">

						<s:bind path="firstName">

							<div class="form-group">

								<sf:label path="firstName">
									<s:message code="label.firstName" />
								</sf:label>

								<sf:input path="firstName" class="form-control" />
							</div>
						</s:bind>



						<s:bind path="login">
							<div class="form-group">

								<sf:label path="login">

									<s:message code="label.login" />
								</sf:label>

								<sf:input path="login" class="form-control" />
							</div>
						</s:bind>



						<s:bind path="roleId">
							<div class="form-group">
								<sf:label path="roleId">
									<s:message code="label.role" />
								</sf:label>
								<sf:select class="form-control" path="roleId">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="roleName" itemValue="id"
										items="${roleList}" />
								</sf:select>
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


					<sf:input type="hidden" path="firstName" />
					<sf:input type="hidden" path="lastName" />
					<sf:input type="hidden" path="login" />
					<sf:input type="hidden" path="roleId" />

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
								<th><s:message code="label.firstName" /></th>
								<th><s:message code="label.lastName" /></th>
								<th><s:message code="label.role" /></th>
								<th><s:message code="label.login" /></th>
								<th><s:message code="label.dob" /></th>
								<th><s:message code="label.gender" /></th>
								<th><s:message code="label.edit" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="user" varStatus="ct">
								<tr>
									<td><input type="checkbox" name="ids" class="case"
										<c:if test="${userLogin.login==user.login }">disabled="disabled"
 
 </c:if>
										value="${user.id}"></td>
									<td><c:out value="${user.firstName}" /></td>
									<td><c:out value="${user.lastName}" /></td>
									<td>${roleMap[user.roleId].roleName}</td>
									<td><c:out value="${user.login}" /></td>
									<td><fmt:formatDate pattern="MM/dd/yyyy"
											value="${user.dob}" /></td>
									<td><c:out value="${user.gender}" /></td>
									<td><c:choose>
											<c:when test="${ userLogin.login==user.login}">
												<p>----</p>
											</c:when>
											<c:otherwise>


												<a href="${editUrl} ${user.id}"> <span
								class="glyphicon glyphicon-pencil"></span>
												</a>

											</c:otherwise>
										</c:choose></td>
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
							onclick="location.href='<c:url value="/ctl/User" />';"
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
