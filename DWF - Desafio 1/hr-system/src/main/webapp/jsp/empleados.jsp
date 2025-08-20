<%@ include file="fragment_header.jsp" %>
<h2>Empleados</h2>
<a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/empleados?action=new">Nuevo Empleado</a>
<table class="table table-striped">
  <thead><tr><th>ID</th><th>Nombre</th><th>DUI</th><th>Usuario</th><th>Teléfono</th><th>Email</th></tr></thead>
  <tbody>
    <c:forEach var="e" items="${empleados}">
      <tr>
        <td><c:out value="${e.idEmpleado}"/></td>
        <td><c:out value="${e.nombrePersona}"/></td>
        <td><c:out value="${e.numeroDui}"/></td>
        <td><c:out value="${e.usuario}"/></td>
        <td><c:out value="${e.numeroTelefono}"/></td>
        <td><c:out value="${e.correoInstitutional}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="fragment_footer.jsp" %>
