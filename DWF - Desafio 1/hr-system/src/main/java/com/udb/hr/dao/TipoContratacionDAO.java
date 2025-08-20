package com.udb.hr.dao;
import com.udb.hr.model.TipoContratacion;
import com.udb.hr.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoContratacionDAO {
    public List<TipoContratacion> listar() throws SQLException {
        String sql = "SELECT idTipoContratacion, tipoContratacion FROM TipoContratacion";
        List<TipoContratacion> lista = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoContratacion t = new TipoContratacion();
                t.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                t.setTipoContratacion(rs.getString("tipoContratacion"));
                lista.add(t);
            }
        }
        return lista;
    }

    public boolean insertar(TipoContratacion t) throws SQLException {
        String sql = "INSERT INTO TipoContratacion(tipoContratacion) VALUES (?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getTipoContratacion());
            return ps.executeUpdate() > 0;
        }
    }
}
