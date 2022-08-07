<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Agregar</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#L">
      <img src="data:image/jpeg;base64,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" alt="" width="40" height="34" class="d-inline-block align-text-top">
      LOGISTICAL
    </a>
  </div>
</nav>
<div class= container>
	<p class="text-center fs-2">AGREGAR PRODUCTO</p>
	 <h3>${mensaje}</h3> 
	
	<form action="agregar" method="post">
		<table>
			
			<tr>
                <td class="p-2"><label for="codigo">Codigo:</label></td>
                <td><input class="form-control" type="text"
                           placeholder="Codigo" name="codigo" /></td>
            </tr>
			<tr>
                <td class="p-2"><label for="nombre">Nombre:</label></td>
                <td><input class="form-control" type="text"
                           placeholder="Nombre" name="nombre" /></td>
            </tr>
			<tr>
                <td class="p-2"><label for="precio">Precio:</label></td>
                <td><input class="form-control" type="number" name="precio"
                           placeholder="Precio"  /></td>
            </tr>
			<tr>
                <td class="p-2"><label for="stock">Stock:</label></td>
                <td><input class="form-control" type="number" name="stock"
                           placeholder="Stock"  /></td>
            </tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn m-2 btn-outline-secondary" value="Agregar" /></td>
			</tr>
		</table>
	</form>
</div>	
</body>