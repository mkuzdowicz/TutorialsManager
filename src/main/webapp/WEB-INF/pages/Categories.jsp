<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/Header.jsp"></jsp:include>

${category.categoryName}
<br>
<br>
<ul>
	<c:forEach items="${catList}" var="cat">
		<li><a href="/PersonalTutorialsRepo/category?name=${cat}">${cat}</a></li>
	</c:forEach>
</ul>

<hr>

selected category: ${selectedCategory.categoryName}

<c:set value="${selectedCategory.tutorials}"
	var="selectedCategoryTutorials" />

<table>

	<c:forEach items="${selectedCategoryTutorials}" var="tutorial">
		<tr>
			<td>${tutorial.title}</td>
			<td>${tutorial.author}</td>
			<td>${tutorial.serviceDomain}</td>
			<td>${tutorial.url}</td>
			<td>${tutorial.rating}</td>
		</tr>
	</c:forEach>
</table>



<jsp:include page="layout/Footer.jsp"></jsp:include>