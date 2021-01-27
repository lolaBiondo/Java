<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entities.Libro"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Libro</title>
<% Libro lib = (Libro)session.getAttribute("nuevolibro"); %>
</head>
<body>

<%if (lib!= null){%>
	<h4> Libro agregado con éxito</h4>
	<String> mensaje="<script type="text/javascript">alert('Esto se debe de mostrar en el msgbox');</script>";
	out.println(mensaje);
<%} else {%>
	<form action="agregarLibroServlet" method="post">

  <div class="container">
    <label for="uname"><b>Titulo</b></label>
    <input type="text" name="titulo" required>

    <label for="psw"><b>ISBN</b></label>
    <input type="number"  name="isbn"required>

	<label for="psw"><b>Fecha Edicion</b></label>
    <input type="date" name="fechaedicion"required>
    
    <label for="nroed"><b>Numero Edicion</b></label>
    <input type="number" name="nroedicion"required>

	<label for="cantd"><b>Cant Dias Prestamo</b></label>
    <input type="number" name="cantdiasprestamo"required>
    
    <label for="gen"><b>Genero</b></label>
    <input type="text" name="genero"required>
    
    <label for="cuit"><b>CUIT</b></label>
    <input type="text" name="password"required>

    <button type="submit">Agregar</button>
    
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <!--   <button type="button" class="cancelbtn">Cancel</button> -->
    <input type="button" onclick="history.back()" name="Cancelar" value="Cancelar">
  </div>
</form>
	
<% }%>

</body>
</html>