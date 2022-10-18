<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Class</title>
</head>
<body>
	<form action="editClassAttendanceServlet" method="post">
		<input type="hidden" name="id" value="${classToEdit.id}"> 
	
		Class name: <input type="text" name="listName" value="${classToEdit.className}"><br /> 
		
		Class date: <input type="text" name="month" placeholder="mm" size="4" value="${month}"> <input type="text" name="day" placeholder="dd" size="4" value="${date}">, <input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> 
			
		Instructor Name: <input type="text" name="instructorName" value="${classToEdit.instructor.name}"><br /> Available
		
		Students:<br /> <select name="studentsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allStudents}" var="currentstudent">
				<option value="${currentstudent.id}">${currentstudent.firstName} ${currentstudent.lastName} ${currentitem.belt}</option>
			</c:forEach>
			
		</select> <br /> <input type="submit" value="Edit Class">
	</form>
	<a href="index.html">Add new students</a>
</body>
</html>