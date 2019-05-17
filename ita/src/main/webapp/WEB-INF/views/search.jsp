<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="searchByName" method="get" modelAttribute="user">
		<tr>
			<td>Search:</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Search"></td>
		</tr>
	</form:form>
	<a href="back">Back</a>

</body>
</html>