<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="editStudentServlet" method="post">
		First Name: <input type="text" name="firstName" value="${studentToEdit.firstName}"><br>
		Last Name: <input type="text" name="lastName" value="${studentToEdit.lastName}"><br>
		Age: <input type="text" name="age" value="${studentToEdit.age}"><br>
		Belt Rank: <input type="text" name="belt" value="${studentToEdit.belt}"><br>
		
		<input type="hidden" name="id" value="${studentToEdit.id}"> <input
			type="submit" value="Edit Student">
	</form>
</body>
</html>