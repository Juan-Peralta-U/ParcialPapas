/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;
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
public class Controler implements ActionListener{
    
    private CRUDFrame crudView;
    private GestorPapa gestorPapa;
    private ArchivoPropiedades archivoPropiedades;
    InitialFrame frameInicial;
    
    public Controler(){
        this.crudView = new CRUDFrame();
        this.gestorPapa = new GestorPapa();
        this.archivoPropiedades = new ArchivoPropiedades(
        new FileChooser("Selecciona archivo propiedades").getFile());
        this.gestorPapa.cargarPapas(archivoPropiedades, this);
    }

    public void crearVentanaInicial(String nombre,String especie,
            String zonaProduccion, int papaActual)
    {  
        frameInicial = new InitialFrame();
        frameInicial.setLocationRelativeTo(null);
        frameInicial.btnInsertar.addActionListener(this);
        frameInicial.btnLimpiar.addActionListener(this);
        frameInicial.labTitulo.setText("Insertar Datos: " + papaActual);
        frameInicial.fieldNombre.setText(nombre);
        frameInicial.fieldEspecie.setText(especie);
        frameInicial.fieldZonaProd.setText(zonaProduccion);
    }
    
    
    public void crearVentanaCrud(){
        this.crudView.btnInsertar.addActionListener(this);
        this.crudView.btnActualizar.addActionListener(this);
        this.crudView.btnConsultar.addActionListener(this);
        this.crudView.btnEliminar.addActionListener(this);
        this.crudView.comboBusqueda.addActionListener(this);
        this.crudView.setLocationRelativeTo(null);
        this.crudView.setVisible(true);
        this.gestorPapa.mostrarPapas(this.crudView.tablaMuestra, String.valueOf(this.crudView.comboBusqueda.getSelectedItem()),"%%");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
                                   
            case "InsertarInitial" ->{
                this.gestorPapa.registrarPapa(frameInicial.fieldNombre.getText(), 
                frameInicial.fieldEspecie.getText(), frameInicial.fieldZonaProd.getText(), 
                frameInicial.txAreaHabito.getText(), frameInicial.txAreaFloracion.getText(), 
                frameInicial.txAreaBayas.getText(), frameInicial.txAreaTuberculos.getText());       
                this.frameInicial.dispose();
                this.gestorPapa.cargarPapas(archivoPropiedades, this);
                         
            }
            case "LimpiarInitial" ->{
                this.frameInicial.limpiarFrame();
            }
            case "InsertarCRUD"->{
                this.gestorPapa.registrarPapa(crudView.fieldNombre.getText(),
                crudView.fieldEspecie.getText(), String.valueOf(crudView.comboZonaProd.getSelectedItem()), 
                crudView.txAreaHabito.getText(), crudView.txAreaFloracion.getText(), 
                crudView.txAreaBayas.getText(), crudView.txAreaTuberculos.getText());
            }
            
            case "comboBoxBuscar"->{
                if(this.crudView.comboBusqueda.getSelectedIndex()>2){
                    this.crudView.comboDatos.setVisible(false);
                    this.crudView.fieldDato.setVisible(true);
                    this.crudView.repaint();
                    return;
                }
                
                this.crudView.comboDatos.setVisible(true);
                this.crudView.fieldDato.setVisible(false);
                this.crudView.repaint();
            }
            
            case "ConsultarCRUD"->{
                this.gestorPapa.mostrarPapas(this.crudView.tablaMuestra, 
                String.valueOf(this.crudView.comboBusqueda.getSelectedItem()).split(" ")[0], //obtiene solo la primera sentencia pegada de mi model
                "%"+this.crudView.fieldDato.getText()+"%");
            }
            case "EliminarCRUD"->{
                
            }
            case "ActualizarCRUD"->{
                
            }
            
        }
        
    }
    
}
