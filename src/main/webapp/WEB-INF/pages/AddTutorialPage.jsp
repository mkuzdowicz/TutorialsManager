<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>add tutorial to repository</p>
	<br>
	<br>

	<form action="/PersonalTutorialsRepo/add-tutorial" method="POST">

		<label>category</label> <input type="text" name="category" /><br>
		<label>title</label> <input type="text" name="title" /> <br> <label>author</label>
		<input type="text" name="author" /><br> <label>url</label><input
			type="text" name="url" /> <br> <input type="submit" />

	</form>

	<hr>

	${reqMap}

</body>
</html>