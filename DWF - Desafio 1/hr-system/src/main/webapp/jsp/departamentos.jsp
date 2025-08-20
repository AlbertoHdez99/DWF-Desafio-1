<%@ include file="fragment_header.jsp" %>
<h2>Departamentos</h2>
<a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/departamentos?action=new">Nuevo Departamento</a>
<table class="table table-striped">
  <thead><tr><th>ID</th><th>Nombre</th><th>Descripción</th></tr></thead>
  <tbody>
    <c:forEach var="d" items="${departamentos}">
      <tr>
        <td><c:out value="${d.idDepartamento}"/></td>
        <td><c:out value="${d.nombreDepartamento}"/></td>
        <td><c:out value="${d.descripcionDepartamento}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="fragment_footer.jsp" %>
