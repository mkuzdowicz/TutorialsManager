<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/js/main.js" />"></script>
<footer>
	<hr>
	<div class="text-center">
		author:&nbsp;
		<spring:message code="author" />
		&nbsp;&nbsp;&nbsp;&nbsp; version:&nbsp;
		<spring:message code="version" />

	</div>
</footer>

</div>
</body>
</html>