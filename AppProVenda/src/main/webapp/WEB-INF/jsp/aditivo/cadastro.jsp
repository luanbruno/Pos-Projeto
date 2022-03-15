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
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="aditivo">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>fabricante:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu fabricante" name="fabricante" value="petronas">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>validade:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu validadde" name="validade" value="3">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>refinamento:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu compisicao" name="composicao" value="organico">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>viscosidade:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu moddelo" name="modelo" value="rosa">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>tipo:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu embalagem" name="embalagem" value="500">
	    </div>
		
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>