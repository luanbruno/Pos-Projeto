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
	  <h2>Cadastramento de Produtos</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirma��o!</strong> ${mensagem}
		</div>	  
	  </c:if>
	<c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">
		  <strong>Erro!</strong> ${mensagemErro}
		</div>	  
	  </c:if>
		
	  		
	<c:if test="${not empty lista}">		
		<h2>Total de Produto: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>ID</th>
		      	<th>nome</th>
		      	<th>fabricante</th>
		        <th>valor</th>

		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="p" items="${lista}">
			      <tr>
			        <td>${p.id}</td>
			        <td>${p.nome}</td>
			        <td>${p.fabricante}</td>
			        <td>${p.valor}</td>
			        <td><a href="/produto/${p.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>N�o existem produto cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>