<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3 class="text-center">${formName}</h3> 
    <h3 class="text-center">${desc}</h3> 
<h1 style="color:green"> Welcome ${user.userName} </h1>
<h1 style="color:green"> User Id  ${user.id} </h1>
<h1> your email is ${user.email} </h1>
<h1>your password is ${user.userPassword}</h1>

</body>
</html>