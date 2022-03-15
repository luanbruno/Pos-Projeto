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

	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Venda</h2>
	  
	   <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action="/venda/incluir" method="post">
	  		
	  		<div class="form-group">
		
			<c:if test="${not empty clientes}">	
		  		<label>Clientes:</label>
		  		<select class="form-control" name="cliente.id">
		  			<c:forEach var="c" items="${clientes}">
		  				<option value="${c.id}">${c.nome}</option>
		  			</c:forEach>
		  		</select>
		  	</c:if>
		  	
		  	<c:if test="${empty clientes}">	
		  		<c:set var="botao" value="disabled"/>
		  		<label>Não existe clientes cadastrados!</label>
		  	</c:if>
	  	</div>
	  
	    <div class="mb-3 mt-3">
	      <label>Quantidade:</label>
	      <input type="text" class="form-control" placeholder="Entre com a quantidade" name="qtd" value="qtd">
	    </div>
	    <div class="mb-3 mt-3">
	      <label>linha:</label>
			<div class="checkbox">
			  <label><input type="checkbox" value="leve" name="web">Linha leve</label>
			  <label><input type="checkbox" value="pesada" name="web">Linha pesada</label>
			  <label><input type="checkbox" value="pesada" name="web">Linha maritima</label>
			</div>
	    </div>
	    
	     <div class="mb-3 mt-3" style="margin-top:20px">
  	    	<c:if test="${not empty produtos}">		
		    	<label>Produtos:</label>
		    	<c:forEach var="p" items="${produtos}">
			    	<div class="checkbox">
			    		<label><input type="checkbox" name="produtosId" value="${p.id}">${p.nome}</label>
			    	</div>
			    </c:forEach>
			</c:if>	
			
			<c:if test="${empty produtos}">
				<c:set var="botao" value="disabled"/>
				<label>Não existe produtos cadastrados!</label>
			</c:if>	
	   	</div>  
	    
		
	    <button  ${botao} type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>