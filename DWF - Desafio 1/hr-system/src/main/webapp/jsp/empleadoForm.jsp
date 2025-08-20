<%@ include file="fragment_header.jsp" %>
<h2>Nuevo Empleado</h2>
<form method="post" action="${pageContext.request.contextPath}/empleados">
  <input type="hidden" name="action" value="insert"/>
  <div class="mb-3">
    <label class="form-label">Nombre</label>
    <input class="form-control" name="nombrePersona" required/>
  </div>
  <div class="mb-3"><label class="form-label">DUI</label><input class="form-control" name="numeroDui"/></div>
  <div class="mb-3"><label class="form-label">Usuario</label><input class="form-control" name="usuario"/></div>
  <div class="mb-3"><label class="form-label">Teléfono</label><input class="form-control" name="numeroTelefono"/></div>
  <div class="mb-3"><label class="form-label">Correo Institucional</label><input class="form-control" name="correoInstitutional"/></div>
  <div class="mb-3"><label class="form-label">Fecha Nacimiento</label><input type="date" class="form-control" name="fechaNacimiento"/></div>
  <button class="btn btn-success" type="submit">Guardar</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/empleados?action=list">Cancelar</a>
</form>
<%@ include file="fragment_footer.jsp" %>
