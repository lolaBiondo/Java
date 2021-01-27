<%@page import="java.util.LinkedList"%>
<%@page import="entities.Libro"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libros</title>
<% 
   LinkedList<Libro> ll = (LinkedList<Libro>)request.getAttribute("listaLibros");
%>
</head>
<body>
<div class="container">
		<div class="row">
        	<h4>Personas</h4>
            	<div class="col-12 col-sm-12 col-lg-12">
                	<div class="table-responsive">
                    	<table class="table">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    		    	<th>titulo</th>
                        			<th>ISBN</th>
                        			<th>fecha Edicion</th>
                        			<th>Numero de edicion</th>
                        			<th>cant de dias de prestamo</th>
                        			<th>género</th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Libro lib : ll) { %>
                    			<tr>
                    				<td><%=lib.getIdLibro()%></td>
                    				<td><%=lib.getTitulo()%></td>
                    				<td><%=lib.getFechaEdicion()%></td>
                    				<td><%=lib.getNroEdicion()%></td>
                    				<td><%=lib.getCantDiasMaxPrestamo()%></td>
                    				<td><%=lib.getGenero()%></td>
                    				<td>
                    				    
                    				</td>
                    				<td></td><!-- editar -->
                    				<td></td><!-- borrar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
	 
	</div> <!-- /container --> 
	<form action="agregarLibro.jsp" method="post">
    <button type="submit">Agregar Libro</button>
 	</form> 
 	<form action="borrarLibro.jsp" method="post">
    <button type="submit">Borrar Libro</button>
 	</form>
 	<form  action="modificarLibro.jsp" method="post">
    <button type="submit">Modificar Libro</button>
    </form>
  
 <div class="container" style="background-color:#f1f1f1">
    <!--   <button type="button" class="cancelbtn">Cancel</button> -->
    <input type="button" onclick="history.back()" name="Volver" value="Volver">
  </div>

									
                    				
</body>
</html>