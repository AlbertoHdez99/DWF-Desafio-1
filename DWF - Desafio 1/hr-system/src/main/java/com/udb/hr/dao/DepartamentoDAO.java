package com.udb.hr.dao;
import com.udb.hr.model.Departamento;
import com.udb.hr.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    public List<Departamento> listar() throws SQLException {
        String sql = "SELECT idDepartamento, nombreDepartamento, descripcionDepartamento FROM Departamento";
        List<Departamento> lista = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                d.setDescripcionDepartamento(rs.getString("descripcionDepartamento"));
                lista.add(d);
            }
        }
        return lista;
    }

    public boolean insertar(Departamento d) throws SQLException {
        String sql = "INSERT INTO Departamento(nombreDepartamento, descripcionDepartamento) VALUES (?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getNombreDepartamento());
            ps.setString(2, d.getDescripcionDepartamento());
            return ps.executeUpdate() > 0;
        }
    }
}
