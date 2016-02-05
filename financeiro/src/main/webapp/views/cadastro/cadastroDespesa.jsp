<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-xs-offset-3">
				<div class="page-header">
					<h3>Formulário de cadastro de Despesa</h3>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-6 col-xs-offset-3">
				<form:form action="/despesa/executarRegistro" method="post"
					commandName="despesa">
					<div class="form-group">
						<label for="nome">Nome:</label>
						<form:input type="text" path="nome" id="nome" class="form-control" />
						<span> <form:errors path="nome" />
						</span>
					</div>

					<div class="form-group">
						<label for="valor">Valor:</label>
						<form:input type="text" path="valor" id="valor"
							class="form-control" />
						<form:errors path="valor" />
					</div>

					<div class="form-group">
						<label for="descricao">Descrição</label>
						<form:textarea rows="10" cols="20" path="descricao" id="descricao"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="quantidade">Quantidade</label>
						<form:input type="number" path="quantidade" id="quantidade"
							class="form-control bfh-number" />
						<form:errors path="quantidade" />
					</div>

					<div class="form-group">
						<label for="dataDespesa">Data da Despesa</label>
						<form:input path="dataDespesa" type="date" class="form-control" />
						<form:errors path="dataDespesa" />
					</div>
					<br>
					<input type="submit" value="Incluir" class="btn btn-primary" />
					<br>
				</form:form>
			</div>
		</div>
	</div>
	<br>
	<c:import url="/views/cadastro/listarCadastros.jsp"></c:import>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>