<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- 	<form:form action="${spring:mvcUrl("PC#save").build()" method="post" commandName="product"> --%>
	<form method="post" action="/despesa/executarRegistro">

		<div>
			<label for="nome">Nome:</label> <input type="text" name="nome"
				id="nome" />
				<form:errors path="nome" />
		</div>

		<div>
			<label for="valor">Valor:</label> <input type="text" name="valor"
				id="valor" />
				<form:errors path="valor" />
		</div>

		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao" id="descricao"></textarea>
		</div>

		<div>
			<label for="quantidade">Quantidade</label> <input type="text"
				name="quantidade" id="quantidade" />
				<form:errors path="dataDespesa" />
		</div>

		<div>
			<label for="dataDespesa">Data da Despesa</label> <input type="date"
				name="dataDespesa" />
			<form:errors path="dataDespesa" />
		</div>

		<input type="submit" value="Incluir" />
	</form>


</body>
</html>