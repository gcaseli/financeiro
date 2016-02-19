<%@ page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<table class="table table-bordered">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Valor</th>
			<th>Descrição</th>
			<th>Quantidade</th>
			<th>Data</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${despesas}" var="desp">
			<tr>
				<td>${desp.nome}</td>
				<td>${desp.valor}</td>
				<td>${desp.descricao}</td>
				<td>${desp.quantidade}</td>
				<td><fmt:formatDate value="${desp.dataDespesa.time}"
						type="date" pattern="dd-MM-yyyy" /></td>
				<td><a
					href="${spring:mvcUrl('DC#editar').arg(0,desp.id).build()}">Editar</a>
					| <a href="${spring:mvcUrl('DC#excluir').arg(0,desp.id).build()}">Excluir</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

