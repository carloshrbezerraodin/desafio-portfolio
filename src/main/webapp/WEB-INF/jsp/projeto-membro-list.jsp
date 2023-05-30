<%@ include file="template/header.jspf"%>
<%@ include file="template/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md"
			href="add-membro-projeto">Adicionar Membros a Projetos</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Lista de Membros e Projetos Associados</h3>
		</div>
		<div class="panel-body">

			<div style="color: red">${erro}</div>

			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">Projeto</th>
						<th width="40%">Membro</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${projetos}" var="projeto">
						<tr>
							<td>${projeto.nome}</td>
							<td>
								<c:forEach var="membro" items="${projeto.membros}">
									<tr>
										<td>${membro.nome}</td>
									</tr>
								</c:forEach>
							</td>
							<td><a type="button" class="btn btn-success"
								href="update-projeto?id=${membro.id}">Editar</a> <a
								type="button" class="btn btn-warning"
								href="delete-projeto?id=${membro.id}">Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="template/footer.jspf"%>