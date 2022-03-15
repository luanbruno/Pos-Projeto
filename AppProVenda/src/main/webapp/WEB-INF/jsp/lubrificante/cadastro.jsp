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
	  <h2>Cadastramento de lubrificante</h2>
	  
	   <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action="/lubrificante/incluir" method="post">
	  <div class="mb-3 mt-3">
	      <label>nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="Oleo de motor">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>fabricante:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="fabricante" value="petronas">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>validade:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="validade" value="2">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>refinamento:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="refinamento" value="20w50">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>viscosidade:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="viscosidade" value="mineral">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>tipo:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="tipo" value="automotivel">
	    </div>
		
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>