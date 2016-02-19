<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-header">
	<h3>Formulário de cadastro de Despesa</h3>
</div>


<form:form action="/despesa/executarRegistro" method="post"
	commandName="despesa" id="cadastroDespesa">
	<div class="form-group">
		<label for="nome">Nome:</label>
		<form:input type="text" path="nome" id="nome" class="form-control" />
		<span class="redStar"><form:errors path="nome" />
		</span>
	</div>

	<div class="form-group">
		<label for="valor">Valor:</label>
		<form:input type="number" step="any" path="valor" id="valor"
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
	
	<input type="submit" value="Incluir" class="btn btn-primary" />
	
	<c:import url="/views/despesa/listarCadastros.jsp"></c:import>
	
</form:form>