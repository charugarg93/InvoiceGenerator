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
<script>	
//TODO: remove method 
function addRow(tableId) {
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	var cell1 = row.insertCell(0);
	var element1 = document.createElement("input");
	element1.name = "text";
	element1.type = "txtbox[]";
	cell1.appendChild(element1);
	var element2 = document.createElement("input");
	element2.name = "text1";
	element2.type = "txtbox[]";
	var cell2 = row.insertCell(1);
	cell2.appendChild(element2);
}</script>
	<script language="javascript">
		function rowAdded(rowElement) {
			//clear the imput fields for the row
			$(rowElement).find("input").val('');
			//may want to reset <select> options etc

			//in fact you may want to submit the form
			saveNeeded();
		}
		function rowRemoved(rowElement) {
			saveNeeded();
			alert("Removed Row HTML:\n" + $(rowElement).html());
		}

		function saveNeeded() {
			$('#submit').css('color', 'red');
			$('#submit').css('font-weight', 'bold');
			if ($('#submit').val().indexOf('!') != 0) {
				$('#submit').val('!' + $('#submit').val());
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
				rowRemovedListener : rowRemoved,
				beforeSubmit : beforeSubmit
			};
			new DynamicListHelper(config);
		});
	</script>
<title>Invoice Generator</title>
</head>
<body>
	<div align="center">
		<h1>Generate Invoice</h1>
		<button type="button" onclick="javascript:addRow('table1')">Add</button>
		<form:form action="saveInvoice" method="post"
			modelAttribute="invoiceDetails" id="detailsForm">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="user.name" id="name" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="user.email" id="email" /></td>
				</tr>
				<tr>
					<td>Due Date</td>
					<td><form:input path="dueDate" id="duedate" /></td>
				</tr>
			</table>

			<table id="table1">
				<thead>
					<tr>
						<th>Description</th>
						<th>Amount</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="productListContainer">
					<tr class="product">
						<c:forEach var="product" items="${invoiceDetails.products}"
							varStatus="i">
							<td><form:input path="products[${i.index}].description"
									id="description${i.index}" /></td>
							<td><form:input path="products[${i.index}].amount"
									id="amount${i.index}" /></td>
							<td><a href="#" class="deleteProduct">Delete product</a></td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="Save" id="submit" />
			&nbsp;
			<a href="#" id="addProduct">Add Product</a>
		</form:form>
	</div>
</body>
</html>