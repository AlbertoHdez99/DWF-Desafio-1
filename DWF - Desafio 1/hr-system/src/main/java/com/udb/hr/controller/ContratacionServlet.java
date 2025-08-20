package com.udb.hr.controller;
import com.udb.hr.dao.ContratacionDAO;
import com.udb.hr.dao.DepartamentoDAO;
import com.udb.hr.dao.EmpleadoDAO;
import com.udb.hr.dao.CargoDAO;
import com.udb.hr.dao.TipoContratacionDAO;
import com.udb.hr.model.Contratacion;
import com.udb.hr.model.Departamento;
import com.udb.hr.model.Empleado;
import com.udb.hr.model.Cargo;
import com.udb.hr.model.TipoContratacion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@WebServlet("/contrataciones")
public class ContratacionServlet extends HttpServlet {
    private ContratacionDAO dao;
    private DepartamentoDAO dDao;
    private EmpleadoDAO eDao;
    private CargoDAO cDao;
    private TipoContratacionDAO tDao;
    @Override public void init() { dao = new ContratacionDAO(); dDao = new DepartamentoDAO(); eDao = new EmpleadoDAO(); cDao = new CargoDAO(); tDao = new TipoContratacionDAO(); }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("action"); if (action == null) action = "list";
        switch (action) {
            case "list": listar(request, response); break;
            case "new": prepararNuevo(request, response); break;
            case "insert": insertar(request, response); break;
            default: listar(request, response);
        }
    }
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Contratacion> lista = dao.listar();
        req.setAttribute("contrataciones", lista);
        req.getRequestDispatcher("/jsp/contrataciones.jsp").forward(req, resp);
    }

    private void prepararNuevo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        req.setAttribute("departamentos", dDao.listar());
        req.setAttribute("empleados", eDao.listarEmpleados());
        req.setAttribute("cargos", cDao.listar());
        req.setAttribute("tipos", tDao.listar());
        req.getRequestDispatcher("/jsp/contratacionForm.jsp").forward(req, resp);
    }

    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String idDept = req.getParameter("idDepartamento"); String idEmp = req.getParameter("idEmpleado"); String idCargo = req.getParameter("idCargo"); String idTipo = req.getParameter("idTipoContratacion"); String fecha = req.getParameter("fechaContratacion"); String sal = req.getParameter("salario");
        Contratacion c = new Contratacion();
        c.setIdDepartamento(Integer.parseInt(idDept));
        c.setIdEmpleado(Integer.parseInt(idEmp));
        c.setIdCargo(Integer.parseInt(idCargo));
        c.setIdTipoContratacion(Integer.parseInt(idTipo));
        try { if (fecha != null && !fecha.isEmpty()) c.setFechaContratacion(new SimpleDateFormat("yyyy-MM-dd").parse(fecha)); } catch (Exception ex) {}
        try { c.setSalario(Double.parseDouble(sal)); } catch (Exception ex) { c.setSalario(0.0); }
        c.setEstado(true);
        dao.insertar(c);
        resp.sendRedirect(req.getContextPath()+"/contrataciones?action=list");
    }
}
