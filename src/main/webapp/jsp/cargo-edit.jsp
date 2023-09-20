<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<h2>Edit into the form and save it</h2>

<form:form action="update" modelAttribute="cargo">

 <form:hidden path="cargoId"/>

CargoIssuer : <form:input path="CargoIssuer"/><br><br>

CargoType : <form:input path="cargoType"/><br><br>

CargoLoad  : <form:input path="cargoLoad"/> <br><br>



<input type="submit" value="Save"><br><br>



</form:form>


<a href="viewAll">ViewAllCargo</a>

</body>
</html>