<%@ include file="fragment_header.jsp" %>
<h2>Contrataciones</h2>
<a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/contrataciones?action=new">Nueva Contratación</a>
<table class="table table-striped">
  <thead><tr><th>ID</th><th>Departamento ID</th><th>Empleado ID</th><th>Cargo ID</th><th>Tipo ID</th><th>Fecha</th><th>Salario</th></tr></thead>
  <tbody>
    <c:forEach var="c" items="${contrataciones}">
      <tr>
        <td><c:out value="${c.idContratacion}"/></td>
        <td><c:out value="${c.idDepartamento}"/></td>
        <td><c:out value="${c.idEmpleado}"/></td>
        <td><c:out value="${c.idCargo}"/></td>
        <td><c:out value="${c.idTipoContratacion}"/></td>
        <td><c:out value="${c.fechaContratacion}"/></td>
        <td><c:out value="${c.salario}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="fragment_footer.jsp" %>
