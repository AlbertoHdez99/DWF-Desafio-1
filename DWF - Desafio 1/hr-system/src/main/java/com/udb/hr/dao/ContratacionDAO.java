package com.udb.hr.dao;
import com.udb.hr.model.Contratacion;
import com.udb.hr.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratacionDAO {
    public List<Contratacion> listar() throws SQLException {
        String sql = "SELECT idContratacion, idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado FROM Contrataciones";
        List<Contratacion> lista = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Contratacion c = new Contratacion();
                c.setIdContratacion(rs.getInt("idContratacion"));
                c.setIdDepartamento(rs.getInt("idDepartamento"));
                c.setIdEmpleado(rs.getInt("idEmpleado"));
                c.setIdCargo(rs.getInt("idCargo"));
                c.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                c.setFechaContratacion(rs.getDate("fechaContratacion"));
                c.setSalario(rs.getDouble("salario"));
                c.setEstado(rs.getBoolean("estado"));
                lista.add(c);
            }
        }
        return lista;
    }

    public boolean insertar(Contratacion c) throws SQLException {
        String sql = "INSERT INTO Contrataciones(idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdDepartamento());
            ps.setInt(2, c.getIdEmpleado());
            ps.setInt(3, c.getIdCargo());
            ps.setInt(4, c.getIdTipoContratacion());
            if (c.getFechaContratacion() != null) ps.setDate(5, new java.sql.Date(c.getFechaContratacion().getTime()));
            else ps.setNull(5, Types.DATE);
            ps.setDouble(6, c.getSalario());
            ps.setBoolean(7, c.isEstado());
            return ps.executeUpdate() > 0;
        }
    }
}
