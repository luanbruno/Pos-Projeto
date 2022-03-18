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
		  <strong>Confirma��o!</strong> ${mensagem}
		</div>	  
	  </c:if>
	<c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">
		  <strong>Erro!</strong> ${mensagemErro}
		</div>	  
	  </c:if>
		
	  <form action="/lubrificante" method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Lubrificante: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr> 
		        <th>ID</th>
				<th>refinamento</th>
				<th>viscosidade</th>
				<th>motor</th>
				<th>nome</th>
				<th>fabricante</th>
				<th>valor</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="l" items="${lista}">
			      <tr>
			      	<td>${l.id}</td>
			        <td>${l.refinamento}</td>
			        <td>${l.viscosidade}</td>
			        <td>${l.motor}</td>
			        <td>${l.nome}</td>
			        <td>${l.fabricante}</td>
			        <td>${l.valor}</td>
			        <td><a href="/lubrificante/${l.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>N�o existem lubrificante cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>