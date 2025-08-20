package com.udb.hr.util;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("Conexión exitosa a la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
