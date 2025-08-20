package com.udb.hr.controller;
import com.udb.hr.dao.CargoDAO;
import com.udb.hr.model.Cargo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/cargos")
public class CargoServlet extends HttpServlet {
    private CargoDAO dao;
    @Override public void init() { dao = new CargoDAO(); }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("action"); if (action == null) action = "list";
        switch (action) {
            case "list": listar(request, response); break;
            case "new": request.getRequestDispatcher("/jsp/cargoForm.jsp").forward(request, response); break;
            case "insert": insertar(request, response); break;
            default: listar(request, response);
        }
    }
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { try { processRequest(req, resp); } catch (SQLException e) { throw new ServletException(e); } }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Cargo> lista = dao.listar();
        req.setAttribute("cargos", lista);
        req.getRequestDispatcher("/jsp/cargos.jsp").forward(req, resp);
    }
    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String cargo = req.getParameter("cargo"); String desc = req.getParameter("descripcionCargo"); boolean jef = "on".equals(req.getParameter("jefatura"));
        Cargo c = new Cargo(); c.setCargo(cargo); c.setDescripcionCargo(desc); c.setJefatura(jef);
        dao.insertar(c);
        resp.sendRedirect(req.getContextPath()+"/cargos?action=list");
    }
}
