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
 *
 * @author Familia Mora
 */
public class GestorPapa {

    private PapaDAO papaDAO;

    private Controler controler;

    private int iteradorPapas = 1;

    public GestorPapa(Controler controler) {
        this.papaDAO = new PapaDAO();
        this.controler = controler;
    }

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

    public void cargarPapas(ArchivoPropiedades propiedades) {

        if (propiedades.getData("Papa" + this.iteradorPapas) == null) {
            controler.crearVentanaCrud();
            return;
        }

        String[] pData = propiedades.getData("Papa" + iteradorPapas).split(",");

        
        if (!this.papaDAO.listaDePapas("nombreComun", pData[0]).isEmpty()){
            iteradorPapas++;
            cargarPapas(propiedades);
            return;
        }
        
        controler.crearVentanaInicial(pData[0], pData[1], pData[2], this.iteradorPapas);

        iteradorPapas++;
    }

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

    public void eliminarPapa(String nombreComun) {
        if (papaDAO.eliminarPapa(nombreComun)) {
            mostrarPapasCombo("nombreComun");
            mostrarPapas("nombreComun", "");
            controler.mensajeVentanaActual("Papa eliminada");
            return;
        }
        controler.mensajeVentanaActual("Error al eliminar papa");
    }

    public void actualizarPapa(String nombreComun, String[] valores) {
        if (papaDAO.modificarPapa(nombreComun, valores)) {
            controler.mensajeVentanaActual("Papa actualizada");
            return;
        }
        controler.mensajeVentanaActual("Error al actualizar papa");
    }

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
    
    public void guardarResultados(ArchivoAleatorio archivoAleatorio){
        int i=0;
        //for(String dato : arrayList<String>)
        for (PapaVO papa: this.papaDAO.listaDePapas("nombreComun", "%%")){
            archivoAleatorio.escribir(papa.getNombreComun(), papa.getEspecie(), 
            papa.getZonaProduccion(), papa.getHabitoCrecimiento(), papa.getFloracion(), papa.getBayas(), papa.getTuberculos());
            
        }
    }

}
