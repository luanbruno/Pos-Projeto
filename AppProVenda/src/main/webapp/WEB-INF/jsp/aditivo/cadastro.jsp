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
	  <h2>Cadastramento de aditivo</h2>
	  
	   <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action="/aditivo/incluir" method="post">
	  <div class="mb-3 mt-3">
	      <label>nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com nome do produto" name="nome" value="aditivo de radiador">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>fabricante:</label>
	      <input type="text" class="form-control" placeholder="Entre com o fabricante" name="fabricante" value="paraflu">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>valor:</label>
	      <input type="text" class="form-control" placeholder="Entre com o preço" name="valor" value="27">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>refinamento:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu compisicao" name="composicao" value="organico">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>viscosidade:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu modelo" name="modelo" value="concentrado">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>Embalagm:</label>
	      <select class="custom-select custom-select-sm mb-3" name="embalagem">
		      <option value="500" >500 ml</option>
		      <option value="1" selected>1 litro</option>
		      <option value="20" >20 litros</option>
		      </select>
	    </div>
		
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>