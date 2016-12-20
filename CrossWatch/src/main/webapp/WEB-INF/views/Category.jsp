<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
 <%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Form</title>
<script>
var app=angular.module("app",[]);
app.controller("myCtrl", function($scope)
	{
		$scope.jsonData=${categoryList};
	});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("categoryTable").style.display = "block";
		document.getElementById("categoryTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("categoryTable").style.display = "none";
		document.getElementById("categoryTable").style.visibility = "hidden";
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
                padding: 2px;
            }

#categoryTable
{
	display:none;
}
  .modal-content
  {
  	height:auto;
    width:800px;
    max-width:1000px;
  }

</style>
</head>
<body>

<div ng-app="app" ng-controller="myCtrl" align="center">
<form:form modelAttribute="category" action="addCategory">
<form:input type="hidden" path="categoryId" />
<form:input path="categoryName" placeholder="Enter the categoryName"/>
<form:errors path="categoryName"/>
<form:input path="categoryDescription" placeholder="Enter the categoryDesc" />
<form:errors path="categoryDescription"/>
<c:if test="${!empty category.categoryName }">
<input type="submit" value="Edit Category" />
</c:if>

<c:if test="${empty category.categoryName }">
<input type="submit" value="Add Category" /> 
<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
</c:if>
<input type="text" placeholder="Filter for Category" ng-model="test" />
</form:form>
<table id="categoryTable" class="table table-hover">
<tr>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'categoryId'; sortReverse = !sortReverse" value="Category ID">
 <span ng-show="sortType == 'categoryId'" class="fa fa-caret-down"></span>
</th>
<th>
<input id="headerbutton" type="button" ng-click="sortType = 'categoryName'; sortReverse = !sortReverse" value="Category Name">
<span ng-show="sortType == 'categoryName'" class="fa fa-caret-down"></span>

</th>
<th>
 <input id="headerbutton" type="button" ng-click="sortType = 'categoryDescription'; sortReverse = !sortReverse" value="Category Description">
 <span ng-show="sortType == 'categoryDescription'" class="fa fa-caret-down" ></span>
</th>
<th>Edit Category</th>
<th>Delete Category</th>
</tr>

<tr ng-repeat="clist in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{clist.categoryId}}</td>
<td>{{clist.categoryName}}</td>
<td>{{clist.categoryDescription}}</td>
<td><a href="editCategory-{{clist.categoryId}}">Edit</a></td>
<td><a href="deleteCategory-{{clist.categoryId}}">Delete</a></td>
</tr>

</table>
</div>
</body>
<%@ include file="footer.jsp" %>