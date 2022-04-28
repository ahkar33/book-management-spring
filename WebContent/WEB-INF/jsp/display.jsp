<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<style>
table {
	border-collapse: collapse;
}

td, th {
	border: 1px solid #999;
	padding: 0.5rem;
	text-align: left;
}

#center {
	display: flex;
	justify-content: center;
}

.error{
	text-align: center;
}
</style>
<body>
	<%@ include file="header.jsp"%>
 	<div class="error" style="color: blue">
		${message}
	</div>
	<br>
	
	<div id="center">
		<div>
			<table>
				<tr>
					<th>Book Code</th>
					<th>Book Title</th>
					<th>Book Author</th>
					<th>Book Price</th>
					<th>Action</th>
				</tr>

				<c:forEach var="data" items="${list}">
					<tr>
						<td>${data.code}</td>
						<td>${data.title}</td>
						<td>${data.author}</td>
						<td>${data.price}</td>
						<td>
							<a href="/Book/setupUpdateBook/${data.code}">Update</a>|
							<a href="/Book/deleteBook/${data.code}">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>