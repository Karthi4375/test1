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

	<c:if test="${!empty listUsers}">
		<table align="left" border="1">
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Input Date</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.inputDate}" /></td>				
 					 <td><a href="<c:url value='/edit/${user.id }' />">Edit</a></td>
 					<td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
 					<!--  <td><a href="edit">Edit</a> -->
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

