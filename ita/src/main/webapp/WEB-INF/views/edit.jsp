<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
</head>
<body>
	<div align="center">
		<h1>EDIT</h1>
		<form:form action="editSave" method="get" modelAttribute="users">
			<table>
				<form:hidden path="id" />

				<tr>
					<td>ID:</td>
					<td><form:input path="id" disabled = "true" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>InputDate:</td>
					<td><form:input path="inputDate" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>