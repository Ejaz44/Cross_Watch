<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brand Form</title>
<script>
var app=angular.module("app",[]);
app.controller("myCtrl", function($scope)
	{
		$scope.jsonData=${brandList};
	});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("brandTable").style.display = "block";
		document.getElementById("brandTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("brandTable").style.display = "none";
		document.getElementById("brandTable").style.visibility = "hidden";
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
                padding: 10px;
            }
#brandTable
{
	display:none;
}
</style>


</head>
<body>
<div ng-app="app" ng-controller="myCtrl">
<form:form modelAttribute="brand" action="addBrand">
<form:input type="hidden" path="brandId" />
<form:input path="brandName" placeholder="Enter the brandName"/>
<form:errors path="brandName"/>
<form:input path="brandDescription" placeholder="Enter the brandDesc" />
<form:errors path="brandDescription"/>

<c:if test="${!empty brand.brandName }">
<input type="submit" value="Edit Brand" />
</c:if>

<c:if test="${empty brand.brandName }">
<input type="submit" value="Add Brand" />
<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
</c:if>
<input type="text" placeholder="Filter for Brand" ng-model="test" />
</form:form>
<table id="brandTable" class="table table-hover">
<tr>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'brandId'; sortReverse = !sortReverse" value="Brand ID">
 <span ng-show="sortType == 'brandId'" class="fa fa-caret-down"></span>
</th>

<th>
<input id="headerbutton" type="button" ng-click="sortType = 'brandName'; sortReverse = !sortReverse" value="Brand Name">
 <span ng-show="sortType == 'brandName'" class="fa fa-caret-down"></span>
</th>

<th>
<input id="headerbutton" type="button" ng-click="sortType = 'brandDescription'; sortReverse = !sortReverse" value="Brand Description">
 <span ng-show="sortType == 'brandDescription'" class="fa fa-caret-down"></span>
</th>

<th>Edit Brand</th>
<th>Delete Brand</th>
</tr>

<tr ng-repeat="blist in jsonData  | filter:test | orderBy:sortType:sortReverse">
<td>{{blist.brandId}}</td>
<td>{{blist.brandName}}</td>
<td>{{blist.brandDescription}}</td>
<td><a href="editBrand-{{blist.brandId}}">Edit</a></td>
<td><a href="deleteBrand-{{blist.brandId}}">Delete</a></td>
</tr>

</table>
</div>
</body>
</html>
<%@ include file="footer.jsp" %>