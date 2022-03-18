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
	  <h2>Cadastramento de Venda</h2>
	  
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
		
	  <form action="/venda" method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de vendas: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		       <th>id</th>
		        <th>data</th>
		        <th>tipo</th>
		        <th>movimento</th>
		        <th>Cliente</th>
		        <th>Produtos</th>

		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="s" items="${lista}">
			      <tr>
			      	<td>${s.id}</td>
			        <td>${s.data}</td>
			        <td>${s.tipo}</td>
		        	<td>${s.movimento}</td>		        	
		        	<td>${p.clientes.nome}</td>
			        <td>${p.produtos.size()}</td>
			        <td><a href="/venda/${s.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem vendas cadastradas!!!</h2>
	</c:if>

	</div>
</body>
</html>