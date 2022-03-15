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
	  <h2>Cadastramento de Cliente</h2>
	  
	   <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  	  
	  <form action="/cliente/incluir" method="post">
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="luan">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="luan@if.com">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>CPF:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu CPF" name="cpf" value="12365478911">
	    </div>

		<c:import url="/WEB-INF/jsp/endereco.jsp"/>
		
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>