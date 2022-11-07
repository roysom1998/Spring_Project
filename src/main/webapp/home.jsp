<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Add Datas Into Database</h3>
<form action="addStudents">
	<!-- <input type="text" name="s1"> -->
	<label><strong>Enter Name Of Student</strong></label>
	<br><br>
	<input type="text" name="sName">
	<br><br>
	<label><strong>Enter Department Of Student</strong></label>
	<br><br>
	<input type="text" name="sDepartment">
	<br><br>
	<input type="submit">
</form>
<hr>
<br>
<form action="/getStudents">
	<label>Enter The Id Of The Student</label>
	<br><br>
	<input type="text" name="sId">
	<br><br>
	<input type="submit">
</form>
<hr>
<br><br>
<h3>Delete Datas From Database</h3>
<form action="deleteStudent">
	<!-- <input type="text" name="s1"> -->
	<label><b>Enter The Id That You Want To Delete</b></label>
	<br><br>
	<input type="text" name="sId">
	<input type="submit">
</form>
</body>
</html>