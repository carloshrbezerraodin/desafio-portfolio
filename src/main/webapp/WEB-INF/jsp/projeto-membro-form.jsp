<%@ include file="template/header.jspf"%>
<%@ include file="template/navigation.jspf"%>


<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Adicionar Membro ao Projeto</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="projetoMembro">


					<fieldset class="form-group">
						<form:label path="membros">Membro</form:label>
							<form:select path="membros" class="form-control" multiple="true">
								<form:option value="">SELECIONE UM MEMBRO</form:option>
								<form:options items="${membros}" itemLabel="nome" ></form:options>
							</form:select>
							<form:errors path="membros" cssClass="text-warning" />
						</fieldset>

						
						<fieldset class="form-group">
						<form:label path="projeto">Projeto</form:label>
							<form:select path="projeto" class="form-control">
								<form:option value="">SELECIONE UM PROJETO</form:option>
								<form:options items="${projetos}" itemLabel="nome" ></form:options>
							</form:select>
							<form:errors path="projeto" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="template/footer.jspf"%>