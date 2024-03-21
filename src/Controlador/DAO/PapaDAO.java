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
 * Clase PapaDAO contiene las funciones CRUD conectandose con la BD
 * @author Familia Mora
 */


public class PapaDAO {

    /**
     * atributo conexion con la base de datos
     */
    private Connection con;
    /**
     * atributo traductor con el lenguaje SQL de una sentencia DML
     */
    private Statement st;
    /**
     * Conjunto de resultados que se devuelven de una query
     */
    private ResultSet rs;

    /**
     * Constructor de la clase papaDAO, inicializa los atributos en null
     */
    public PapaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * El metodo listaColumnaPapa de tipo ArrayList se encarga de traer los
     * datos no duplicados de una columna de la tabla papa y me crea un
     * arraylist con esos datos
     *
     * @param Recibe un campo string que sera correspondiente a los campos de la
     * tabla
     * @return Retorna un arraylist Datos que contendra todos los registros de
     * la columna de la tabla que no esten repetidos
     */
    public ArrayList<String> listaColumnaPapa(String columna) {
        ArrayList<String> datos = new ArrayList<>();
        String consulta = "SELECT DISTINCT " + columna + " FROM papa";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                datos.add(rs.getString(1));
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            //Ventana error consulta
        }
        return datos;
    }

    /**
     * Metodo listaPapa, a partir de la conexion con la base de datos, usamos
     * sentencia SQL que la traducira st para poder ejecutar su funcion que sera
     * mostrar todos los campos de la tabla papa en la base de datos que
     * contengan una caracteristica en especial que definimos
     *
     * @param campo recibe el campo de la base de datos donde se va a consultar
     * @param valor recibe la especificacion que se quiere consultar
     * @return retorna una lista con papas recibidas de la consulta
     */
    public ArrayList<PapaVO> listaDePapas(String campo, String valor) {
        ArrayList<PapaVO> misPapas = new ArrayList<PapaVO>();
        String consulta = "SELECT * FROM papa WHERE " + campo + " LIKE '" + valor + "'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {

                PapaVO papa = new PapaVO();
                papa.setNombreComun(rs.getString("nombreComun"));
                papa.setEspecie(rs.getString("especie"));
                papa.setZonaProduccion(rs.getString("zonaProduccion"));
                papa.setHabitoCrecimiento(rs.getString("habitoCrecimiento"));
                papa.setFloracion(rs.getString("floracion"));
                papa.setBayas(rs.getString("bayas"));
                papa.setTuberculos(rs.getString("tuberculos"));
                misPapas.add(papa);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            
        }
        return misPapas;
    }

    /**
     * EL metodo Inserta los datos de la tabla papa a la BD
     *
     * @param papa recibe objeto de la clase PapaVO
     * @return retorna el resultado de la operacion 
     */
    public boolean insertarDatos(PapaVO papa) {
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO papa VALUES('" + papa.getNombreComun() + "','" + papa.getEspecie() + "','" + papa.getZonaProduccion() + "','"
                    + papa.getHabitoCrecimiento() + "','" + papa.getFloracion() + "','" + papa.getBayas() + "','" + papa.getTuberculos() + "')";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
    *El método elimina la fila  de la tabla papa a la BD
    *@param nombreComun  recibe la primary key de la fila que se va a eliminar
    *@return retorna un booleano que define la confirmacion o denegacion del proceso
     */
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
            

        }
        return false;
    }

    /**
    *Permite modificar los campos de registro de una papa seleccionada exeptuando el nombreComun que es la primarykey
    *@param nombreComun obtiene la primary key de la fila que se va a actualizar
    *@param valores contiene en orden los valores que se van a modificar en el registro
    *@return retorna un boleano que confirma o deniega el exito del proceso
     */
    public boolean modificarPapa(String nombreComun, String[] valores) {

        if (valores.length != 6) {
            return false;
        }
        String consulta = "UPDATE papa SET especie = '" + valores[0] + "',"
                + "zonaProduccion = '" + valores[1] + "', "
                + "habitoCrecimiento = '" + valores[2] + "', "
                + "floracion = '" + valores[3] + "', "
                + "bayas = '" + valores[4] + "', "
                + "tuberculos = '" + valores[5] + "' "
                + "WHERE nombreComun='" + nombreComun + "' ";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            
        }
        return false;
    }

}
