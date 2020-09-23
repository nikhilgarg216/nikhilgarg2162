<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
 <%@include file="scripts.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<div>Fill Your Credentials !</div>
	<sf:form action="saveStudent" modelAttribute="stu" class="form-group">
	<div>
		<label for="name">Name : </label>
		<sf:input path="name" id="name" class="form-control"/> 
	</div><br/>
	<div>
		<label for="course">Course : </label>
		<sf:input path="course" id="course" class="form-control"/> 
	</div><br/>
	<div>
		<label for="address">Address : </label>
		<sf:input path="address" id="address" class="form-control"/>
	</div> <br/> 
	<div>	
		<input type="submit" value="Save" class="btn btn-success"/>
	</div>
	
	</sf:form>

</body>
</html>