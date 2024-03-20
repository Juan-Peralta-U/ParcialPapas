/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;

import Controlador.DAO.PapaDAO;
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

    private int iteradorPapas = 1;

    public GestorPapa() {
        this.papaDAO = new PapaDAO();
    }

    public void mostrarPapasCombo(JComboBox<String> combo, String campo) {
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

    public void cargarPapas(ArchivoPropiedades propiedades, Controler controler) {

        if (propiedades.getData("Papa" + this.iteradorPapas) == null) {
            controler.crearVentanaCrud();
            return;
        }

        String[] pData = propiedades.getData("Papa" + iteradorPapas).split(",");
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

        papaDAO.insertarDatos(registroPapa);

    }

    public boolean eliminarPapa(String nombreComun, JComboBox<String> combo) {
        boolean b = papaDAO.eliminarPapa(nombreComun);
        mostrarPapasCombo(combo, "nombreComun");
        return b;
    }

    public boolean actualizarPapa(String nombreComun, String[] valores) {
        return papaDAO.modificarPapa(nombreComun, valores);
    }

    public void mostrarPapas(JTable tabla, String campo, String valor) {
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

}
