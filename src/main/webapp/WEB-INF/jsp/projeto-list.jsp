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
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="40%">Nome</th>
      <th width="40%">Data Inicio</th>
      <th width="40%">Data Prev Fim</th>
      <th width="40%">Data Fim</th>
      <th width="20%">Status</th>
       <th width="20%">Orcamento</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${projetos}" var="projeto">
      <tr>
       <td>${projeto.nome}</td>
       <td><fmt:formatDate value="${projeto.dataInicio}"
         pattern="dd/MM/yyyy" /></td>
         <td><fmt:formatDate value="${projeto.dataPrevisaoFim}"
         pattern="dd/MM/yyyy" /></td>
         <td><fmt:formatDate value="${projeto.dataFim}"
         pattern="dd/MM/yyyy" /></td>
         <td>${projeto.status}</td>
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