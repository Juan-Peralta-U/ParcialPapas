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
        frameInicial.btnInsertar.addActionListener(this);
        frameInicial.btnLimpiar.addActionListener(this);
        frameInicial.labTitulo.setText("Insertar Datos: " + papaActual);
        frameInicial.fieldNombre.setText(nombre);
        frameInicial.fieldEspecie.setText(especie);
        frameInicial.fieldZonaProd.setText(zonaProduccion);
    }
    
    
    public void crearVentanaCrud(){
        this.crudView.btnActualizar.addActionListener(this);
        this.crudView.btnConsultar.addActionListener(this);
        this.crudView.btnEliminar.addActionListener(this);
        this.crudView.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            
            case "InsertarInitial" ->{
                this.frameInicial.dispose();
                this.gestorPapa.cargarPapas(archivoPropiedades, this);
            }
            case "LimpiarInitial" ->{
                this.frameInicial.limpiarFrame();
            }
            case ""->{
                
            }
            
        }
        
    }
    
}
