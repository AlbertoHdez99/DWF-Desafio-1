<%@ include file="fragment_header.jsp" %>
<h2>Nueva Contratación</h2>
<form method="post" action="${pageContext.request.contextPath}/contrataciones">
  <input type="hidden" name="action" value="insert"/>
  <div class="mb-3">
    <label class="form-label">Departamento</label>
    <select class="form-select" name="idDepartamento">
      <c:forEach var="d" items="${departamentos}"><option value="${d.idDepartamento}">${d.nombreDepartamento}</option></c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">Empleado</label>
    <select class="form-select" name="idEmpleado">
      <c:forEach var="e" items="${empleados}"><option value="${e.idEmpleado}">${e.nombrePersona}</option></c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">Cargo</label>
    <select class="form-select" name="idCargo">
      <c:forEach var="c" items="${cargos}"><option value="${c.idCargo}">${c.cargo}</option></c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">Tipo Contratación</label>
    <select class="form-select" name="idTipoContratacion">
      <c:forEach var="t" items="${tipos}"><option value="${t.idTipoContratacion}">${t.tipoContratacion}</option></c:forEach>
    </select>
  </div>
  <div class="mb-3"><label class="form-label">Fecha Contratación</label><input type="date" class="form-control" name="fechaContratacion"/></div>
  <div class="mb-3"><label class="form-label">Salario</label><input class="form-control" name="salario"/></div>
  <button class="btn btn-success" type="submit">Guardar</button>
  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/contrataciones?action=list">Cancelar</a>
</form>
<%@ include file="fragment_footer.jsp" %>
