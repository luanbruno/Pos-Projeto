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
	  <h2>Cadastramento de Aditivo</h2>
	  
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
		
	  <form action="/aditivo" method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Aditivo: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>composicao</th>
				<th>modelo</th>
				<th>embalagem</th>
				<th>nome</th>
				<th>fabricante</th>
				<th>validade</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="a" items="${lista}">
			      <tr>
			        <td>${a.composicao}</td>
			        <td>${a.modelo}</td>
			        <td>${a.embalagem}</td>
			        <td>${a.nome}</td>
			        <td>${a.fabricante}</td>
			        <td>${a.validade}</td>
			        <td><a href="/aditivo/${a.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem lubrificante cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>