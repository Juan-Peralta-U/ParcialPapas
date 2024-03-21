/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;

import Controlador.DAO.PapaDAO;
import Modelo.ArchivoAleatorio;
import Modelo.ArchivoPropiedades;
import Modelo.PapaVO;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase GestorPapa
 *
 * Esta clase se encarga de la gestión de las operaciones CRUD (Crear, Leer,
 * Actualizar y Eliminar) para el manejo de la información de las diferentes
 * variedades de papa. Utiliza una instancia de la clase PapaDAO para
 * interactuar con la base de datos. También maneja la carga inicial de los
 * datos de papa desde un archivo de propiedades.
 *
 * @author Familia Mora
 */
public class GestorPapa {

    /**
     * Instancia de la clase PapaDAO para interactuar con la base de datos.
     */
    private PapaDAO papaDAO;
    /**
     * Instancia del controlador Controler utilizado para interactuar con la
     * interfaz de usuario.
     */
    private Controler controler;
    /**
     * Contador utilizado para cargar los datos iniciales de papa desde el
     * archivo de propiedades.
     */
    private int iteradorPapas;

    /**
     * Constructor de la clase GestorPapa.
     *
     * @param controler Instancia del controlador Controler para interactuar con
     * la interfaz de usuario.
     */
    public GestorPapa(Controler controler) {
        this.papaDAO = new PapaDAO();
        this.controler = controler;
        this.iteradorPapas = 1;
    }

    /**
     * Muestra las opciones disponibles en un combo box de la interfaz de
     * usuario.
     *
     * @param campo Campo de la tabla de papa a mostrar en el combo box.
     */
    public void mostrarPapasCombo(String campo) {
        JComboBox combo = this.controler.getCrudView().comboDatos;
        combo.removeAllItems();
        ArrayList<String> lista = papaDAO.listaColumnaPapa(campo);

        if (lista.isEmpty()) {
            combo.addItem("-- No hay registros --");
            return;
        }
        for (String s : lista) {
            combo.addItem(s);
        }
    }

    /**
     * Carga los datos iniciales de papa desde un archivo de propiedades.
     *
     * @param propiedades Objeto ArchivoPropiedades que contiene los datos
     * iniciales de papa.
     */
    public void cargarPapas(ArchivoPropiedades propiedades) {

        if (propiedades.getData("Papa" + this.iteradorPapas) == null) {
            controler.crearVentanaCrud();
            controler.mensajeVentanaActual("Se han cargado las papas iniciales");
            return;
        }
        //me separa el properties por ,
        String[] pData = propiedades.getData("Papa" + iteradorPapas).split(",");

        //trae una consulta y si el nombre ya existe, salto al otro valor de properties
        if (!this.papaDAO.listaDePapas("nombreComun", pData[0]).isEmpty()) {
            iteradorPapas++;
            cargarPapas(propiedades);
            return;
        }

        controler.crearVentanaInicial(pData[0], pData[1], pData[2], this.iteradorPapas);

        iteradorPapas++;
    }

    /**
     * Registra una nueva variedad de papa en la base de datos.
     *
     * @param nombreComun Nombre común de la variedad de papa.
     * @param especie Especie de la variedad de papa.
     * @param zonaProduccion Zona de producción de la variedad de papa.
     * @param habitoCrecimiento Hábito de crecimiento de la variedad de papa.
     * @param floracion Información sobre la floración de la variedad de papa.
     * @param bayas Información sobre las bayas de la variedad de papa.
     * @param tuberculos Información sobre los tubérculos de la variedad de
     * papa.
     */
    public void registrarPapa(String nombreComun, String especie,
            String zonaProduccion, String habitoCrecimiento,
            String floracion, String bayas, String tuberculos) {

        PapaVO registroPapa = new PapaVO();

        registroPapa.setNombreComun(nombreComun);
        registroPapa.setEspecie(especie);
        registroPapa.setZonaProduccion(zonaProduccion);
        registroPapa.setHabitoCrecimiento(habitoCrecimiento);
        registroPapa.setFloracion(floracion);
        registroPapa.setBayas(bayas);
        registroPapa.setTuberculos(tuberculos);

        if (papaDAO.insertarDatos(registroPapa)) {
            controler.mensajeVentanaActual("Papa registrada");
            return;
        }

        controler.mensajeVentanaActual("Error al registrar papa");
    }

    /**
     * Elimina una variedad de papa de la base de datos.
     *
     * @param nombreComun Nombre común de la variedad de papa a eliminar.
     */
    public void eliminarPapa(String nombreComun) {
        if (papaDAO.eliminarPapa(nombreComun)) {
            mostrarPapasCombo("nombreComun");
            mostrarPapas("nombreComun", "");
            controler.mensajeVentanaActual("Papa eliminada");
            return;
        }
        controler.mensajeVentanaActual("Error al eliminar papa");
    }
    
     /**
    * Actualiza la información de una variedad de papa en la base de datos.
    *
    * @param nombreComun Nombre común de la variedad de papa a actualizar.
    * @param valores     Arreglo con los nuevos valores para los campos de la variedad de papa.
    */
    public void actualizarPapa(String nombreComun, String[] valores) {
        if (papaDAO.modificarPapa(nombreComun, valores)) {
            controler.mensajeVentanaActual("Papa actualizada");
            return;
        }
        controler.mensajeVentanaActual("Error al actualizar papa");
    }
    
     /**
    * Muestra las variedades de papa en una tabla de la interfaz de usuario.
    *
    * @param campo Campo de la tabla de papa a utilizar como filtro.
    * @param valor Valor del filtro para mostrar las variedades de papa.
    */
    public void mostrarPapas(String campo, String valor) {
        JTable tabla = this.controler.getCrudView().tablaMuestra;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        tabla.setModel(modelo);
        ArrayList<PapaVO> lista = papaDAO.listaDePapas(campo, valor);
        String[] datos = new String[7];
        for (PapaVO p : lista) {
            datos[0] = p.getNombreComun();
            datos[1] = p.getEspecie();
            datos[2] = p.getZonaProduccion();
            datos[3] = p.getHabitoCrecimiento();
            datos[4] = p.getFloracion();
            datos[5] = p.getBayas();
            datos[6] = p.getTuberculos();
            modelo.addRow(datos);
        }

    }
    
     /**
    * Guarda los resultados de las variedades de papa en un archivo aleatorio.
    *
    * @param archivoAleatorio Instancia de la clase ArchivoAleatorio para escribir los datos.
    */
    public void guardarResultados(ArchivoAleatorio archivoAleatorio) {
        //for(String dato : arrayList<String>)
        for (PapaVO papa : this.papaDAO.listaDePapas("nombreComun", "%%")) {
            archivoAleatorio.escribir(papa.getNombreComun(), papa.getEspecie(),
                    papa.getZonaProduccion(), papa.getHabitoCrecimiento(), papa.getFloracion(), papa.getBayas(), papa.getTuberculos());

        }
    }

}
