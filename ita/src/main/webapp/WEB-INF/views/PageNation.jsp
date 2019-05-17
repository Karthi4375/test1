<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</body>
</html> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="ext" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>User Details</title>
<style>
.btn-browser {
	padding: 6px 0;
}
</style>
</head>
<body>

	<c:if test="${!empty listing}">
		<table align="left" border="1">
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Input Date</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listing}" var="user">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.inputDate}" /></td>
					<td><a href="<c:url value='/listing/${user.id}'/>">list</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

