package com.udb.hr.controller;
import com.udb.hr.dao.DepartamentoDAO;
import com.udb.hr.model.Departamento;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/departamentos")
public class DepartamentoServlet extends HttpServlet {
    private DepartamentoDAO dao;
    @Override public void init() { dao = new DepartamentoDAO(); }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("action"); if (action == null) action = "list";
        switch (action) {
            case "list": listar(request, response); break;
            case "new": request.getRequestDispatcher("/jsp/departamentoForm.jsp").forward(request, response); break;
            case "insert": insertar(request, response); break;
            default: listar(request, response);
        }
    }
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }

    private void listar(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Departamento> lista = dao.listar();
        req.setAttribute("departamentos", lista);
        req.getRequestDispatcher("/jsp/departamentos.jsp").forward(req, resp);
    }

    private void insertar(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String nombre = req.getParameter("nombreDepartamento"); String desc = req.getParameter("descripcionDepartamento");
        Departamento d = new Departamento(); d.setNombreDepartamento(nombre); d.setDescripcionDepartamento(desc);
        dao.insertar(d);
        resp.sendRedirect(req.getContextPath()+"/departamentos?action=list");
    }
}
