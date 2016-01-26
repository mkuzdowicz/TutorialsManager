<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="layout/Header.jsp"></jsp:include>

<spring:message code="welcome" />

<ul>
	<c:forEach items="${categories}" var="category">
		<li>${category.categoryName}<br> <br>
			<ul>
				<c:forEach items="${category.tutorials}" var="tutorial">
					<li>${tutorial.id},${tutorial.title},${tutorial.serviceDomain},
						${tutorial.author}
						<hr> ${tutorial.url}
					</li>
				</c:forEach>
			</ul>
		</li>
	</c:forEach>
</ul>

<jsp:include page="layout/Footer.jsp"></jsp:include>