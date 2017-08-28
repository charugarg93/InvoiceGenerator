<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="js/dynamic_list_helper.js" type="text/javascript"></script>
<script language="javascript">
	function calc(A) {
		total = document.getElementById('totalAmount');
		if (total != null) {
			document.getElementById('totalAmount').value = parseFloat(total.value)
					+ parseFloat(A);
			document.getElementById('totalAmount').innerHTML = parseFloat(total.value)
					+ parseFloat(A);
		}
	}

	function rowAdded(rowElement) {//clear the imput fields for the row
		$(rowElement).find("input").val('');

		saveNeeded();
	}
	function rowRemoved(rowElement) {
		saveNeeded();
		alert("Removed Row HTML:\n" + $(rowElement).html());
	}

	function saveNeeded() {

		$('#submit').css('font-weight', 'bold');
		if ($('#submit').val().indexOf('!') != 0) {
			$('#submit').val($('#submit').val());
		}
	}

	function beforeSubmit() {
		alert('submitting....');
		return true;
	}

	$(document).ready(function() {
		var config = {
			rowClass : 'product',
			addRowId : 'addProduct',
			removeRowClass : 'deleteProduct',
			formId : 'detailsForm',
			rowContainerId : 'productListContainer',
			indexedPropertyName : 'products',
			indexedPropertyMemberNames : 'description,amount',
			rowAddedListener : rowAdded,
			rowRemovedListener : rowRemoved

		};
		new DynamicListHelper(config);
	});
</script>
<title>Invoice Generator</title>
</head>
<body>
	<div align="left">
		<h1>Generate Invoice</h1>
		<form:form action="saveInvoice" method="post"
			modelAttribute="invoiceDetails" id="detailsForm">
			<table cellspacing="10">
				<tr>
					<td>Name</td>
					<td><form:input path="user.name" id="name" /></td>
					<td><form:errors path="user.name" /></td>
				</tr>
				<br>
				<br>
				<tr>
					<td>Email</td>
					<td><form:input path="user.email" id="email" /></td>
					<td><form:errors path="user.email" /></td>
				</tr>
				<tr>
					<td>Due Date [dd/mm/yyyy]</td>
					<td><form:input path="dueDate" id="duedate" /></td>
				</tr>
				<br>
				<br>
			</table>
			&nbsp;

			<table id="table1" cellspacing="10">
				<thead>
					<tr>
						<th>Description</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody id="productListContainer">
					<tr class="product">
						<c:forEach var="product" items="${invoiceDetails.products}"
							varStatus="i">
							<td><form:input path="products[${i.index}].description"
									id="description${i.index}" /></td>
							<td><form:input path="products[${i.index}].amount"
									id="amount${i.index}"
									onkeypress='return event.charCode >= 48 && event.charCode <= 57'
									onChange="calc(this.value)" /></td>
							<!-- <td><a href="#" class="deleteProduct">Delete product</a></td> -->
							<tr>
								<td><form:errors path="products[${i.index}].description" /></td>
								<td><form:errors path="products[${i.index}].amount" /></td>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
			</table>
			<br>

			<a href="#" id="addProduct">ADD PRODUCT</a>
			<br>
			<br>
			TOTAL &nbsp;&nbsp;&nbsp;&nbsp;$ <form:input path="totalAmount"
				id="totalAmount" name="totalAmount" readonly="true"
				style="border:0px;" />

			<br>
			<br>
			<input type="submit" value="SEND" id="submit" />
			<br>
			<br>
		</form:form>
	</div>
</body>
</html>