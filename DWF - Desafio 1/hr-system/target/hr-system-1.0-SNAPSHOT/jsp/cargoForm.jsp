<%@ include file="fragment_header.jsp" %>
<h2>Nuevo Cargo</h2>
<form method="post" action="${pageContext.request.contextPath}/cargos">
  <input type="hidden" name="action" value="insert"/>
  <div class="mb-3"><label class="form-label">Cargo</label><input class="form-control" name="cargo" required/></div>
  <div class="mb-3"><label class="form-label">Descripción</label><textarea class="form-control" name="descripcionCargo"></textarea></div>
  <div class="form-check mb-3"><input class="form-check-input" type="checkbox" name="jefatura" id="jef"><label class="form-check-label" for="jef">Es jefatura</label></div>
  <button class="btn btn-success" type="submit">Guardar</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/cargos?action=list">Cancelar</a>
</form>
<%@ include file="fragment_footer.jsp" %>
