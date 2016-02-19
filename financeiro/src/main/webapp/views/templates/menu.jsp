<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="list-group">
		<a href="${spring:mvcUrl('DC#registro').build()}" class="list-group-item">Nova Despesa</a>
		<a href="${spring:mvcUrl('DC#list').build()}" class="list-group-item">Listar Despesas</a>
		<a href="${spring:mvcUrl('RC#registro').build()}" class="list-group-item">Nova Receita</a>
		<a href="${spring:mvcUrl('RC#list').build()}" class="list-group-item">Listar Receitas</a>
	</div>
</body>
</html>