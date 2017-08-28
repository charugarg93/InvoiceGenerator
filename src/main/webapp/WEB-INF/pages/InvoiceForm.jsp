<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invoice Generator</title>
</head>
<body>
 <div align="center">
		<h1>Generate Invoice</h1>
		<form:form action="saveInvoice" method="post" modelAttribute="invoiceDetails">
			<table>
				<%-- <form:hidden path="id" /> --%>
				<tr>
					<td>Name:</td>
					<td><form:input path="user.name" /><%-- ${invoiceDetails.user.name} --%></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="user.email" /></td>
				</tr>
				<tr>
					<td>Due Date:</td>
					<td><form:input path="user.dueDate" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Send"></td>
				</tr>
			</table>

			<table>
				<th>Description</th>
				<th>Amount</th>

	 			<c:forEach var="item" items="${products}" varStatus="i">
				<tr>
				<td><form:input path="description"  <%-- type="text"  --%> /><%-- "list[${i.index}].description" --%></td>
				</tr>
				</c:forEach>
				
				
<%-- 				<c:forEach items="${a.list}" varStatus="i">
					<tr>
						<td><form:input path="list[${i.index}].x1" type="text" /></td>
						<td><form:input path="list[${i.index}].y1" type="text" /></td>
					</tr>
				</c:forEach> --%>
				<!--   -->

			</table>
		</form:form>
	</div>
</body>
</html>