 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
var app=angular.module("app",[]);
app.controller("myCtrl", function($scope)
	{
		$scope.jsonData=${subCategoryList};
	});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("subCategoryTable").style.display = "block";
		document.getElementById("subCategoryTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("subCategoryTable").style.display = "none";
		document.getElementById("subCategoryTable").style.visibility = "hidden";
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
#subCategoryTable
{
	display:none;
}
</style>
</head>
<body>
<div ng-app="app" ng-controller="myCtrl">
<form:form modelAttribute="subCategory" action="addSubCategory">
<form:input type="hidden" path="subCategoryId" />
<form:input path="subCategoryName" placeholder="Enter the SubCategoryName"/>
<form:errors path="subCategoryName" />
<form:input path="subCategoryDescription" placeholder="Enter the subCategoryDesc" />
<form:errors path = "subCategoryDescription" />
 <form:select path="category.categoryName" items="${categoryList}"  itemValue="categoryName" itemLabel="categoryName"/>
 <c:if test="${!empty subCategory.subCategoryName }">
<input type="submit" value="Edit SubCategory" />
</c:if>
<c:if test="${empty subCategory.subCategoryName }">

<input type="submit" value="Add SubCategory" />
<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
</c:if>
 <input type="text" placeholder="Filter for SubCategory" ng-model="test" />
 
</form:form>

<table  id="subCategoryTable" class="table table-hover">
<tr>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'categoryId'; sortReverse = !sortReverse" value="Category ID">
 <span ng-show="sortType == 'categoryId'" class="fa fa-caret-down"></span>
</th>

<th>
<input id="headerbutton" type="button" ng-click="sortType = 'subCategoryId'; sortReverse = !sortReverse" value="SubCategory ID">
 <span ng-show="sortType == 'subCategoryId'" class="fa fa-caret-down"></span>
</th>

<th>
<input id="headerbutton" type="button" ng-click="sortType = 'subCategoryName'; sortReverse = !sortReverse" value="SubCategory Name">
 <span ng-show="sortType == 'subCategoryName'" class="fa fa-caret-down"></span>
</th>

<th>
<input id="headerbutton" type="button" ng-click="sortType = 'subCategoryDescription'; sortReverse = !sortReverse" value="SubCategory Description">
 <span ng-show="sortType == 'subCategoryDescription'" class="fa fa-caret-down"></span>
</th>

<th>Edit SubCategory</th>
<th>Delete SubCategory</th>

</tr>

<tr ng-repeat="sclist in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{sclist.categoryId}}</td>
<td>{{sclist.subCategoryId}}</td>
<td>{{sclist.subCategoryName}}</td>
<td>{{sclist.subCategoryDescription}}</td>
<td><a href="editSubCategory-{{sclist.subCategoryId}}">Edit</a></td>
<td><a href="deleteSubCategory-{{sclist.subCategoryId}}">Delete</a></td>
</tr>

</table>
</div>
</body>
</html>
<%@ include file="footer.jsp"%>