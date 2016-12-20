<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Form</title>
<script>
var app=angular.module("app",[]);
app.controller("myCtrl", function($scope)
	{
		$scope.jsonData=${supplierList};
	});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("supplierTable").style.display = "block";
		document.getElementById("supplierTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("supplierTable").style.display = "none";
		document.getElementById("supplierTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>

<style type="text/css">
#headerbutton {
     background:none!important;
     border:none; 
     padding:0!important;
     font: inherit;
     /*border is optional*/
     border-bottom:1px solid #444; 
     cursor: pointer;
}
tr,th,td {
                padding: 20px;
            }
#supplierTable
{
	display:none;
}
</style>

</head>
<body>
<div ng-app="app" ng-controller="myCtrl">
<form:form modelAttribute="supplier" action="addSupplier">
<form:input type="hidden" path="supplierId" />
<form:input path="supplierName" placeholder="Enter Supplier Name" />
<form:errors path="supplierName" />
<form:input path="supplierAddress" placeholder="Enter Supplier Address" />
<form:errors path="supplierAddress" />
<form:input path="supplierEmail" placeholder="Enter Supplier Email" />
<form:errors path="supplierEmail" />
<c:if test="${!empty supplier.supplierName }">

<input type="submit" value="Edit Supplier" />
</c:if>
<c:if test="${empty supplier.supplierName }">

<input type="submit" value="Add supplier" />
<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
</c:if>
<input type="text" placeholder="Filter for Supplier" ng-model="test" />
</form:form>
<table  id="supplierTable" class="table table-hover">
<tr>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'supplierId'; sortReverse = !sortReverse" value="Supplier ID">
 <span ng-show="sortType == 'supplierId'" class="fa fa-caret-down"></span>
</th>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'supplierName'; sortReverse = !sortReverse" value="Supplier Name">
 <span ng-show="sortType == 'supplierName'" class="fa fa-caret-down"></span>
</th>
<<th>
<input id="headerbutton" type="button" ng-click="sortType = 'supplierAddress'; sortReverse = !sortReverse" value="Supplier Address">
 <span ng-show="sortType == 'supplierAddress'" class="fa fa-caret-down"></span>
</th>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'supplierEmail'; sortReverse = !sortReverse" value="Supplier Email">
 <span ng-show="sortType == 'supplierEmail'" class="fa fa-caret-down"></span>
</th>
<th>Edit Supplier</th>
<th>Delete Supplier</th>
</tr>
<tr ng-repeat="slist in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{slist.supplierId}}</td>
<td>{{slist.supplierName}}</td>
<td>{{slist.supplierAddress}}</td>
<td>{{slist.supplierEmail}}</td>
<td><a href="editSupplier-{{slist.supplierId}}">Edit</a></td>
<td><a href="deleteSupplier-{{slist.supplierId}}">Delete</a></td>
</tr>
</table>
</div>
</body>
</html>
<%@include file="footer.jsp" %>