<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entities.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar libro</title>
<!--   LinkedList<Libro> ll = (LinkedList<Libro>)request.getAttribute("listaLibros2");
-->
</head>
<body>

	<form action="borrarLibroServlet" method="post">

  	<div class="container">
  	
    <label for="id"><b>Ingrese el ID del libro que desea borrar:</b></label>
    <input type="number"  name="idlibro">

	
    <button type="submit">Borrar libro</button>
    
  </div>

	
  <div class="container" style="background-color:#f1f1f1">
    <!--   <button type="button" class="cancelbtn">Cancel</button> -->
    <input type="button" onclick="history.back()" name="Cancelar" value="Cancelar">
  </div>
  
  
</form>
	<form  action="listarLibroServlet" method="post">
	<button type="submit">Ver Libros</button>
    </form>
	

</body>
</html>