/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion.Conexion;
import Modelo.Papa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Familia Mora
 */
public class PapaDAO {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public PapaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public Papa consultarPapa() {
        Papa papa = null;
        String consulta = "SELECT * FROM Estudiantes ";
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                //posible error a futuro con el constructor
                papa= new Papa();
                papa.setEspecie(rs.getString("codigo"));
                papa.setZonaProduccion(rs.getString("nombre"));
                papa.setHabitoCrecimiento(rs.getString(consulta));
                papa.setFloracion(rs.getString("Floracion"));
                papa.setBayas(rs.getString("Bayas"));
                papa.setTuberculos(rs.getString("Tuberculos"));

            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return papa;
    }

    public ArrayList<Papa> listaDePapas() {
        ArrayList<Papa> misPapas = new ArrayList<Papa>();
        String consulta = "SELECT * FROM Estudiantes";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                //Mismo error con el constructor
                Papa papa = new Papa();
                papa.setEspecie(rs.getString("codigo"));
                papa.setZonaProduccion(rs.getString("nombre"));
                papa.setHabitoCrecimiento(rs.getString(consulta));
                papa.setFloracion(rs.getString("Floracion"));
                papa.setBayas(rs.getString("Bayas"));
                papa.setTuberculos(rs.getString("Tuberculos"));
                //misPapas.add(papa);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return misPapas;
    }
    
    
}


