<%@ include file="template/header.jspf"%>
<%@ include file="template/navigation.jspf"%>

<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="add-projeto">Adicionar Projeto</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Lista de Projetos</h3>
  </div>
  <div class="panel-body">
  
  	<div style="color:red">
  		${erro}
  	</div>
  
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="20%">Nome</th>
      <th width="20%">Data Inicio</th>
      <th width="20%">Data Fim</th>
      <th width="20%">Status</th>
      <th width="20%">Risco</th>
      <th width="10%">Orcamento</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${projetos}" var="projeto">
      <tr>
       <td>${projeto.nome}</td>
       <td><fmt:formatDate value="${projeto.dataInicio}"
         pattern="dd/MM/yyyy" /></td>
         <td><fmt:formatDate value="${projeto.dataFim}"
         pattern="dd/MM/yyyy" /></td>
         <td>${projeto.status}</td>
         <td>${projeto.risco}</td>
         <td>${projeto.orcamento}</td>
       <td><a type="button" class="btn btn-success"
        href="update-projeto?id=${projeto.id}">Editar</a>
       <a type="button" class="btn btn-warning"
        href="delete-projeto?id=${projeto.id}">Deletar</a></td>
      </tr>
     </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="template/footer.jspf"%>