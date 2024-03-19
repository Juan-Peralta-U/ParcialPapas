package Controlador.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Modelo.Conexion.Conexion;
import Modelo.PapaVO;
import java.awt.List;
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
                misPapas.add(papa);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            //Ventana error consulta
        }
        return misPapas;
    }

    public void insertarDatos(PapaVO papa) {
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO papa VALUES('" + papa.getNombreComun() + ",'" + papa.getEspecie() + ",'" + papa.getZonaProduccion() + "',"
                    + "'" + papa.getHabitoCrecimiento() + "','" + papa.getFloracion() + "','" + papa.getBayas() + "','" + papa.getTuberculos() + "')";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            //Ventana error insercion
        }
    }

    public boolean eliminarPapa(String nombreComun) {
        String consulta = "DELETE FROM papa where nombreComun='" + nombreComun + "'";
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
            return true;

        } catch (Exception e) {
            //Ventana error insercion

        }
        return false;
    }

    public boolean modificarPapa(String nombreComun, String campoModificable, String valorModificado) {
        /*Modo locura pa no tener que hacerlo varias veces
        *Campo modificable es el campo que se va a modificar de la tabla
        *El valor modificado sera el nuevo dato o valor que tendrá
        *Nombre comun es la primary key, el identificador de cada papa
         */
        String consulta = "update papa set '" + campoModificable + "'='" + valorModificado + "' where nombreComun='" + nombreComun + "' ";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            //ventana error
        }
        return false;
    }

}
