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
	  <h2>Cadastramento de Usuários</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	<form action ="/cep" class="form-inline" method="post">
	  	<div class="mb-3 mt-3">
	  		<label>Busca por CEP:</label>
	  		<input type="text" class="form-control" placeholder="Entre com o seu cep" name="cep" value="26510014">
	  	</div>
	  	
	  	<button type="submit" class="btn btn-primary">Buscar</button>
	 </form>

	  <form action="/usuario/incluir" method="post">
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="Luan">
	    </div>
	   
	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="luan@inf.com">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Entre com o sua senha" name="senha" value="123">
	    </div>
	      
		 <c:import url="/WEB-INF/jsp/endereco.jsp"/>
		 
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>