<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR System</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">HR System</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/empleados?action=list">Empleados</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/departamentos?action=list">Departamentos</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/cargos?action=list">Cargos</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/tipos?action=list">Tipos</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contrataciones?action=list">Contrataciones</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container mt-4">
