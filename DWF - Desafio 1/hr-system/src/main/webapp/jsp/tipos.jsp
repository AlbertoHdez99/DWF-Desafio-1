<%@ include file="fragment_header.jsp" %>
<h2>Tipos de Contratación</h2>
<a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/tipos?action=new">Nuevo Tipo</a>
<table class="table table-striped">
  <thead><tr><th>ID</th><th>Tipo</th></tr></thead>
  <tbody>
    <c:forEach var="t" items="${tipos}">
      <tr>
        <td><c:out value="${t.idTipoContratacion}"/></td>
        <td><c:out value="${t.tipoContratacion}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="fragment_footer.jsp" %>
