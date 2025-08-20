<%@ include file="fragment_header.jsp" %>
<h2>Cargos</h2>
<a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/cargos?action=new">Nuevo Cargo</a>
<table class="table table-striped">
  <thead><tr><th>ID</th><th>Cargo</th><th>Descripción</th><th>Jefatura</th></tr></thead>
  <tbody>
    <c:forEach var="c" items="${cargos}">
      <tr>
        <td><c:out value="${c.idCargo}"/></td>
        <td><c:out value="${c.cargo}"/></td>
        <td><c:out value="${c.descripcionCargo}"/></td>
        <td><c:out value="${c.jefatura}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="fragment_footer.jsp" %>
