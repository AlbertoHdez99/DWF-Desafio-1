package com.udb.hr.dao;
import com.udb.hr.model.Empleado;
import com.udb.hr.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    public List<Empleado> listarEmpleados() throws SQLException {
        String sql = "SELECT idEmpleado, numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitutional, fechaNacimiento FROM Empleados";
        List<Empleado> lista = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNumeroDui(rs.getString("numeroDui"));
                e.setNombrePersona(rs.getString("nombrePersona"));
                e.setUsuario(rs.getString("usuario"));
                e.setNumeroTelefono(rs.getString("numeroTelefono"));
                e.setCorreoInstitutional(rs.getString("correoInstitutional"));
                e.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                lista.add(e);
            }
        }
        return lista;
    }

    public boolean insertarEmpleado(Empleado e) throws SQLException {
        String sql = "INSERT INTO Empleados(numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitutional, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNumeroDui());
            ps.setString(2, e.getNombrePersona());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getNumeroTelefono());
            ps.setString(5, e.getCorreoInstitutional());
            if (e.getFechaNacimiento() != null) ps.setDate(6, new java.sql.Date(e.getFechaNacimiento().getTime()));
            else ps.setNull(6, Types.DATE);
            return ps.executeUpdate() > 0;
        }
    }
}
