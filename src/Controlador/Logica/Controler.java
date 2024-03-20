/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;

import Modelo.ArchivoAleatorio;
import Modelo.ArchivoPropiedades;
import Vista.CRUDFrame;
import Vista.FileChooser;
import Vista.InitialFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Juan
 */
public class Controler implements ActionListener {

    private CRUDFrame crudView;
    private GestorPapa gestorPapa;
    private ArchivoPropiedades archivoPropiedades;
    private ArchivoAleatorio archivoSalida;
    InitialFrame frameInicial;

    public Controler() {
        this.crudView = new CRUDFrame();
        this.gestorPapa = new GestorPapa(this);
        this.archivoPropiedades = new ArchivoPropiedades(
                new FileChooser("Selecciona archivo propiedades").getFile());
        this.gestorPapa.cargarPapas(archivoPropiedades);
    }

    public void crearVentanaInicial(String nombre, String especie,
            String zonaProduccion, int papaActual) {
        frameInicial = new InitialFrame();
        frameInicial.setLocationRelativeTo(null);
        frameInicial.btnInsertar.addActionListener(this);
        frameInicial.btnLimpiar.addActionListener(this);
        frameInicial.labTitulo.setText("Insertar Datos: " + papaActual);
        frameInicial.fieldNombre.setText(nombre);
        frameInicial.fieldEspecie.setText(especie);
        frameInicial.fieldZonaProd.setText(zonaProduccion);
        this.gestorPapa.registrarPapa(frameInicial.fieldNombre.getText(),
                frameInicial.fieldEspecie.getText(), frameInicial.fieldZonaProd.getText(),
                frameInicial.txAreaHabito.getText(), frameInicial.txAreaFloracion.getText(),
                frameInicial.txAreaBayas.getText(), frameInicial.txAreaTuberculos.getText());
    }

    public void crearVentanaCrud() {
        this.crudView.btnInsertar.addActionListener(this);
        this.crudView.btnActualizar.addActionListener(this);
        this.crudView.btnConsultar.addActionListener(this);
        this.crudView.btnEliminar.addActionListener(this);
        this.crudView.comboBusqueda.addActionListener(this);
        this.crudView.btnLimpiar.addActionListener(this);
        this.crudView.btnSalir.addActionListener(this);
        this.crudView.setLocationRelativeTo(null);
        this.crudView.setVisible(true);
        this.crudView.comboDatos.setEnabled(false);
        this.crudView.btnEliminar.setEnabled(false);
        this.crudView.btnActualizar.setEnabled(false);
        this.crudView.comboBusqueda.setSelectedIndex(0);
        this.gestorPapa.mostrarPapas(String.valueOf(this.crudView.comboBusqueda.getSelectedItem()), "%%");
    }

    public boolean ValidarEspaciosInitial() {
        if (frameInicial.txAreaBayas.getText().isEmpty()
                || frameInicial.txAreaFloracion.getText().isEmpty()
                || frameInicial.txAreaHabito.getText().isEmpty()
                || frameInicial.txAreaTuberculos.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean ValidarEspaciosCreate() {
        if (crudView.fieldNombre.getText().isEmpty()
                || crudView.fieldEspecie.getText().isEmpty()
                || crudView.txAreaBayas.getText().isEmpty()
                || crudView.txAreaFloracion.getText().isEmpty()
                || crudView.txAreaHabito.getText().isEmpty()
                || crudView.txAreaTuberculos.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean ValidarEspaciosJTable() {
        if (crudView.tablaMuestra.getModel().getValueAt(0, 1).equals("")
                || crudView.tablaMuestra.getModel().getValueAt(0, 2).equals("")
                || crudView.tablaMuestra.getModel().getValueAt(0, 3).equals("")
                || crudView.tablaMuestra.getModel().getValueAt(0, 4).equals("")
                || crudView.tablaMuestra.getModel().getValueAt(0, 5).equals("")
                || crudView.tablaMuestra.getModel().getValueAt(0, 6).equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "InsertarInitial" -> {
                if (!ValidarEspaciosInitial()) {
                    frameInicial.mensajeEmergente("Complete todos los campos");
                    return;
                }

                String[] valores = new String[6];
                valores[0] = this.frameInicial.fieldEspecie.getText();
                valores[1] = this.frameInicial.fieldZonaProd.getText();
                valores[2] = this.frameInicial.txAreaHabito.getText();
                valores[3] = this.frameInicial.txAreaFloracion.getText();
                valores[4] = this.frameInicial.txAreaBayas.getText();
                valores[5] = this.frameInicial.txAreaTuberculos.getText();

                this.gestorPapa.actualizarPapa(this.frameInicial.fieldNombre.getText(), valores);

                this.frameInicial.dispose();
                this.gestorPapa.cargarPapas(archivoPropiedades);

            }
            case "LimpiarInitial" -> {
                this.frameInicial.limpiarFrame();
            }
            case "InsertarCRUD" -> {

                if (!ValidarEspaciosCreate()) {
                    crudView.mensajeEmergente("Complete todos los campos");
                    return;
                }
                
                this.gestorPapa.registrarPapa(crudView.fieldNombre.getText(),
                        crudView.fieldEspecie.getText(), String.valueOf(crudView.comboZonaProd.getSelectedItem()),
                        crudView.txAreaHabito.getText(), crudView.txAreaFloracion.getText(),
                        crudView.txAreaBayas.getText(), crudView.txAreaTuberculos.getText());
                
                this.crudView.comboBusqueda.setSelectedIndex(0);
                this.gestorPapa.mostrarPapas("nombreComun", "%%");
            }

            case "comboBoxBuscar" -> {
                this.crudView.comboDatos.setEnabled(true);
                this.crudView.btnEliminar.setEnabled(false);
                this.crudView.btnActualizar.setEnabled(false);

                if (this.crudView.comboBusqueda.getSelectedIndex() > 2) {
                    this.crudView.comboDatos.setVisible(false);
                    this.crudView.fieldDato.setVisible(true);
                    this.crudView.repaint();
                    return;
                }

                if (crudView.comboBusqueda.getSelectedIndex() == 2) {

                    crudView.comboDatos.removeAllItems();
                    String[] zonas = {"Cundinamarca", "Nariño",
                        "Antioquia", "Boyaca",
                        "Santander", "Cauca",
                        "Tolima", "Caldas"};

                    for (String s : zonas) {
                        crudView.comboDatos.addItem(s);
                    }
                }

                if (crudView.comboBusqueda.getSelectedIndex() < 2) {
                    gestorPapa.mostrarPapasCombo(String.valueOf(crudView.comboBusqueda.getSelectedItem()));
                }
                
                this.crudView.comboDatos.setVisible(true);
                this.crudView.fieldDato.setVisible(false);
                this.crudView.repaint();
            }

            case "ConsultarCRUD" -> {

                if ((crudView.comboDatos.getSelectedItem() + "").equals("-- No hay registros --")) {
                    return;
                }

                if (crudView.comboBusqueda.getSelectedIndex() == 0) {
                    crudView.mensajeEmergente("Si desea actualizar, modifique valores en la tabla");
                    this.crudView.btnEliminar.setEnabled(true);
                    this.crudView.btnActualizar.setEnabled(true);
                }

                if (crudView.comboBusqueda.getSelectedIndex() < 3) {
                    gestorPapa.mostrarPapas(
                            String.valueOf(crudView.comboBusqueda.getSelectedItem()),
                            String.valueOf(crudView.comboDatos.getSelectedItem()));
                    return;
                }

                this.gestorPapa.mostrarPapas(
                        String.valueOf(this.crudView.comboBusqueda.getSelectedItem()).split(" ")[0], //obtiene solo la primera sentencia pegada de mi model
                        "%" + this.crudView.fieldDato.getText() + "%");
            }

            case "EliminarCRUD" -> {
                this.crudView.btnEliminar.setEnabled(false);
                this.crudView.btnActualizar.setEnabled(false);
                
                gestorPapa.eliminarPapa(String.valueOf(crudView.comboDatos.getSelectedItem()));

            }

            case "ActualizarCRUD" -> {
                if (!ValidarEspaciosJTable()) {
                    crudView.mensajeEmergente("Complete los campos a actualizar");
                    return;
                }

                this.crudView.btnEliminar.setEnabled(false);
                this.crudView.btnActualizar.setEnabled(false);

                String[] valores = new String[6];
                for (int i = 0; i < 6; i++) {
                    valores[i] = "" + crudView.tablaMuestra.getModel().getValueAt(0, i + 1);
                }

                gestorPapa.actualizarPapa(String.valueOf(crudView.comboDatos.getSelectedItem()),
                        valores);
            }

            case "LimpiarCRUD" -> {
                crudView.limpiarFrame();
            }

            case "Salir" -> {
                archivoSalida = new ArchivoAleatorio(new FileChooser("Seleccione archivo aleatorio").getFile());
                gestorPapa.guardarResultados(archivoSalida);
                mensajeVentanaActual(archivoSalida.lecturaRegistros());
                crudView.setVisible(false);
                crudView.dispose();
                System.exit(0);
            }

        }

    }

    public void mensajeVentanaActual(String msj) {
        if (this.crudView == null) {
            this.frameInicial.mensajeEmergente(msj);
            return;
        }

        this.crudView.mensajeEmergente(msj);
    }

    public CRUDFrame getCrudView() {
        return crudView;
    }

    public InitialFrame getFrameInicial() {
        return frameInicial;
    }

}
