package Controlador.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Modelo.Conexion.Conexion;
import Modelo.PapaVO;
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

    public PapaVO consultarPapa() {
        PapaVO papa = null;
        String consulta = "SELECT * FROM Papas ";
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                //posible error a futuro con el constructor
                papa = new PapaVO();
                papa.setNombreComun(rs.getString("Nombre Comun"));
                papa.setEspecie(rs.getString("Especie"));
                papa.setZonaProduccion(rs.getString("nombre"));
                papa.setHabitoCrecimiento(rs.getString(consulta));
                papa.setFloracion(rs.getString("Floracion"));
                papa.setBayas(rs.getString("Bayas"));
                papa.setTuberculos(rs.getString("Tuberculos"));

            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            //Ventana error consulta
        }
        return papa;
    }

    public ArrayList<PapaVO> listaDePapas() {
        ArrayList<PapaVO> misPapas = new ArrayList<PapaVO>();
        String consulta = "SELECT * FROM Papas";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                //Mismo error con el constructor
                PapaVO papa = new PapaVO();
                papa.setNombreComun(rs.getString("Nombre Comun"));
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
           //Ventana error consulta
        }
        return misPapas;
    }

}
