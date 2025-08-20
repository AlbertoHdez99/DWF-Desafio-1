<%@ include file="fragment_header.jsp" %>
<h2>Nuevo Departamento</h2>
<form method="post" action="${pageContext.request.contextPath}/departamentos">
  <input type="hidden" name="action" value="insert"/>
  <div class="mb-3"><label class="form-label">Nombre</label><input class="form-control" name="nombreDepartamento" required/></div>
  <div class="mb-3"><label class="form-label">Descripción</label><textarea class="form-control" name="descripcionDepartamento"></textarea></div>
  <button class="btn btn-success" type="submit">Guardar</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/departamentos?action=list">Cancelar</a>
</form>
<%@ include file="fragment_footer.jsp" %>
