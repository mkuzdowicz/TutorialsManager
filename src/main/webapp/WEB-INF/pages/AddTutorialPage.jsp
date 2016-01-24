<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="layout/Header.jsp"></jsp:include>

<form action="/PersonalTutorialsRepo/add-tutorial" method="POST">

	<label>category</label> <input type="text" name="category" /><br>
	<label>title</label> <input type="text" name="title" /> <br> <label>author</label>
	<input type="text" name="author" /><br> <label>url</label><input
		type="text" name="url" /> <br> <input type="submit" />

</form>

<hr>

${reqMap}

<jsp:include page="layout/Footer.jsp"></jsp:include>