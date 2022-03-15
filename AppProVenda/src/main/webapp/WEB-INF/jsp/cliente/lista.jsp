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
	  <h2>Cadastramento de cliente</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	<c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">
		  <strong>Erro!</strong> ${mensagemErro}
		</div>	  
	  </c:if>
		
	  <form action="/cliente" method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Cliente: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		        <th>E-mail</th>
		        <th>CPF</th>
		        <th>Usuário</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="s" items="${lista}">
			      <tr>
			        <td>${s.id}</td>
			        <td>${s.nome}</td>
			        <td>${s.email}</td>
			        <td>${s.cpf}</td>
			        <td>${s.usuario.nome}</td>
			        <td><a href="/cliente/${s.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem cliente cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>