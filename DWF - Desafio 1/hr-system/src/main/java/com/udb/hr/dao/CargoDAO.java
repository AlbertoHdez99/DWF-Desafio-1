package com.udb.hr.dao;
import com.udb.hr.model.Cargo;
import com.udb.hr.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {
    public List<Cargo> listar() throws SQLException {
        String sql = "SELECT idCargo, cargo, descripcionCargo, jefatura FROM Cargos";
        List<Cargo> lista = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cargo c = new Cargo();
                c.setIdCargo(rs.getInt("idCargo"));
                c.setCargo(rs.getString("cargo"));
                c.setDescripcionCargo(rs.getString("descripcionCargo"));
                c.setJefatura(rs.getBoolean("jefatura"));
                lista.add(c);
            }
        }
        return lista;
    }

    public boolean insertar(Cargo c) throws SQLException {
        String sql = "INSERT INTO Cargos(cargo, descripcionCargo, jefatura) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getCargo());
            ps.setString(2, c.getDescripcionCargo());
            ps.setBoolean(3, c.isJefatura());
            return ps.executeUpdate() > 0;
        }
    }
}
