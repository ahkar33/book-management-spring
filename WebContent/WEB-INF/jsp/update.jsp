<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
</head>
<style>
#center {
	display: flex;
	justify-content: center;
}
</style>
<body>
	<%@ include file="header.jsp"%>
		<div style="color: red; text-align: center;">${error}</div>
	<div id="center">
		<form:form action="/Book/updateBook" method="post" modelAttribute="bean">
			<table>
				<tr>
					<td>Book Code</td>
					<td><form:input type="text" path="code" required="required" readonly="true"/></td>
				</tr>
				<tr>
					<td>Book Title</td>
					<td><form:input type="text" path="title" required="required" /></td>
				</tr>
				<tr>
					<td>Book Author</td>
					<td><form:input type="text" path="author" required="required" /></td>
				</tr>
				<tr>
					<td>Book Price</td>
					<td><form:input type="text" path="price" required="required" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add"/></td>
				</tr>
			</table>
		</form:form>

	</div>
	<div></div>


</body>
</html>