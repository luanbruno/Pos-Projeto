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
	<c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">
		  <strong>Erro!</strong> ${mensagemErro}
		</div>	  
	  </c:if>
		
	  <form action="/bateria" method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Bateria: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr> 
				<th>ID</th>		      
		        <th>peso</th>
				<th>amperagem</th>
				<th>tipo</th>
				<th>nome</th>
				<th>fabricante</th>
				<th>valor</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="l" items="${lista}">
			      <tr>
			       	<td>${b.id}</td>
			        <td>${l.peso}</td>
			        <td>${l.amperagem}</td>
			        <td>${l.tipo}</td>
			        <td>${l.nome}</td>
			        <td>${l.fabricante}</td>
			        <td>${l.valor}</td>
			        <td><a href="/bateria/${l.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem bateria cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>