<%@ include file="fragment_header.jsp" %>
<h2>Nuevo Tipo de Contratación</h2>
<form method="post" action="${pageContext.request.contextPath}/tipos">
  <input type="hidden" name="action" value="insert"/>
  <div class="mb-3"><label class="form-label">Tipo</label><input class="form-control" name="tipoContratacion" required/></div>
  <button class="btn btn-success" type="submit">Guardar</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/tipos?action=list">Cancelar</a>
</form>
<%@ include file="fragment_footer.jsp" %>
