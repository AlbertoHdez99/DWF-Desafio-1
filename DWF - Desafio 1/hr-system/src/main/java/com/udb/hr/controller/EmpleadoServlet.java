package com.udb.hr.controller;
import com.udb.hr.dao.EmpleadoDAO;
import com.udb.hr.model.Empleado;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@WebServlet("/empleados")
public class EmpleadoServlet extends HttpServlet {
    private EmpleadoDAO empleadoDAO;
    @Override public void init() { empleadoDAO = new EmpleadoDAO(); }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("action"); if (action == null) action = "list";
        switch (action) {
            case "list": listar(request, response); break;
            case "new": request.getRequestDispatcher("/jsp/empleadoForm.jsp").forward(request, response); break;
            case "insert": insertar(request, response); break;
            default: listar(request, response);
        }
    }
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Empleado> lista = empleadoDAO.listarEmpleados();
        req.setAttribute("empleados", lista);
        req.getRequestDispatcher("/jsp/empleados.jsp").forward(req, resp);
    }

    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String dui = req.getParameter("numeroDui"); String nombre = req.getParameter("nombrePersona"); String usuario = req.getParameter("usuario"); String tel = req.getParameter("numeroTelefono"); String correo = req.getParameter("correoInstitutional"); String fecha = req.getParameter("fechaNacimiento");
        Empleado e = new Empleado();
        e.setNumeroDui(dui); e.setNombrePersona(nombre); e.setUsuario(usuario); e.setNumeroTelefono(tel); e.setCorreoInstitutional(correo);
        try { if (fecha != null && !fecha.isEmpty()) e.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fecha)); } catch (Exception ex) { /* ignore */ }
        empleadoDAO.insertarEmpleado(e);
        resp.sendRedirect(req.getContextPath()+"/empleados?action=list");
    }
}
