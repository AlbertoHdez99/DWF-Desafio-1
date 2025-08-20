package com.udb.hr.controller;
import com.udb.hr.dao.TipoContratacionDAO;
import com.udb.hr.model.TipoContratacion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/tipos")
public class TipoContratacionServlet extends HttpServlet {
    private TipoContratacionDAO dao;
    @Override public void init() { dao = new TipoContratacionDAO(); }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("action"); if (action == null) action = "list";
        switch (action) {
            case "list": listar(request, response); break;
            case "new": request.getRequestDispatcher("/jsp/tipoForm.jsp").forward(request, response); break;
            case "insert": insertar(request, response); break;
            default: listar(request, response);
        }
    }
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<TipoContratacion> lista = dao.listar();
        req.setAttribute("tipos", lista);
        req.getRequestDispatcher("/jsp/tipos.jsp").forward(req, resp);
    }
    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String tipo = req.getParameter("tipoContratacion");
        TipoContratacion t = new TipoContratacion(); t.setTipoContratacion(tipo);
        dao.insertar(t);
        resp.sendRedirect(req.getContextPath()+"/tipos?action=list");
    }
}
