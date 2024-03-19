/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Familia Mora
 */
public class Conexion {

    private static Connection cn = null;
    //private static String URLBD = "jdbc:mysql://localhost:3308/TallerPapa";
    private static String URLBD = "jdbc:mysql://localhost:3306/TallerPapa";
    private static String usuario = "root";
    private static String contrasena = "";

    public static Connection getConexion() {
        try {
            cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        } catch (SQLException ex) {
            System.out.println("No se puede cargar el controlador");
        }
        return cn;
    }

    public static void desconectar() {
        cn = null;
    }
}
