<%@ include file="template/header.jspf"%>
<%@ include file="template/navigation.jspf"%>
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Adicionar Projeto</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="projeto">
      
      <form:hidden path="id" />
      
      <fieldset class="form-group">
       <form:label path="nome">Nome</form:label>
       <form:input path="nome" type="text" class="form-control"
        required="required" />
       <form:errors path="nome" cssClass="text-warning" />
      </fieldset>

      <fieldset class="form-group">
       <form:label path="dataInicio">data Inicio</form:label>
       <form:input path="dataInicio" type="text" class="form-control"
        required="required" />
       <form:errors path="dataInicio" cssClass="text-warning" />
      </fieldset>
      
       <fieldset class="form-group">
       <form:label path="dataPrevisaoFim">data Previsao Fimo</form:label>
       <form:input path="dataPrevisaoFim" type="text" class="form-control"
        required="required" />
       <form:errors path="dataPrevisaoFim" cssClass="text-warning" />
      </fieldset>
      
      
       <fieldset class="form-group">
       <form:label path="dataFim">data Fim</form:label>
       <form:input path="dataFim" type="text" class="form-control"
        required="required" />
       <form:errors path="dataFim" cssClass="text-warning" />
      </fieldset>
      
       <fieldset class="form-group">
       <form:label path="descricao">descricao</form:label>
       <form:input path="descricao" type="text" class="form-control"
        required="required" />
       <form:errors path="descricao" cssClass="text-warning" />
      </fieldset>
      
      
       <fieldset class="form-group">
       <form:label path="status">status</form:label>
       <form:input path="status" type="text" class="form-control"
        required="required" />
       <form:errors path="status" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="orcamento">orcamento</form:label>
       <form:input path="orcamento" type="text" class="form-control"
        required="required" />
       <form:errors path="orcamento" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="risco">risco</form:label>
       <form:input path="risco" type="text" class="form-control"
        required="required" />
       <form:errors path="risco" cssClass="text-warning" />
      </fieldset>
      
      

      <button type="submit" class="btn btn-success">Save</button>
      
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="template/footer.jspf"%>