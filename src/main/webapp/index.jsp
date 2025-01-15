<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>JSP - Hello World</title>
</head>
<body>
<h1><%= "CRUD" %>
</h1>
<br/>
<a href="controller/AddLibroServlet">Add Libro</a>
<a href="controller/RemoveLibroServlet">Remove Libro</a>
<a href="controller/UpdateLibroServlet">Update Libro</a>
<a href="controller/GetLibroServlet">Get Libro</a>
<a href="controller/GetAllLibroServlet">Get All Libro</a>
</body>
</html>