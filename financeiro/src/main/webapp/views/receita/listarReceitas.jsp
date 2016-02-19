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
		<c:forEach items="${receitas}" var="recei">
			<tr>
				<td>${recei.nome}</td>
				<td>${recei.valor}</td>
				<td>${recei.descricao}</td>
				<td>${recei.quantidade}</td>
				<td><fmt:formatDate value="${recei.dataReceita.time}"
						type="date" pattern="dd-MM-yyyy" /></td>
				<td><a
					href="${spring:mvcUrl('RC#editar').arg(0,recei.id).build()}">Editar</a>
					| <a href="${spring:mvcUrl('RC#excluir').arg(0,recei.id).build()}">Excluir</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>