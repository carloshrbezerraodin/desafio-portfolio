<%@ include file="template/header.jspf"%>
<%@ include file="template/navigation.jspf"%>
<div class="container">

 <div class="panel panel-primary">
     <div class="panel-heading">Home Page</div>
        <div class="panel-body">
           Welcome ${name}!! <a href="/list-todos">Click here</a> to manage your
           todo's.
        </div>
     </div>
 </div>
<%@ include file="template/footer.jspf"%>