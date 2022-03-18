<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppProVenda</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de bateria</h2>
	  
	   <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action="/bateria/incluir" method="post">
	  <div class="mb-3 mt-3">
	      <label>nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com nome do produto" name="nome" value="Bateria de moto">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>fabricante:</label>
	      <input type="text" class="form-control" placeholder="Entre com o fabricante" name="fabricante" value="moura">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>valor:</label>
	      <input type="text" class="form-control" placeholder="Entre com o preço" name="valor" value="120">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>peso:</label>
	      <input type="text" class="form-control" placeholder="Entre com o peso" name="peso" value="3">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>amperagem:</label>
	      <input type="text" class="form-control" placeholder="Entre com a amperagem" name="amperagem" value="4">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>Voltagem:</label>
	      	<select class="custom-select custom-select-sm mb-3" name="tipo">
		      <option value="12" selected>12 Volt</option>
		      <option value="24" >24 Volt</option>
		      </select>
	    </div>
		
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>