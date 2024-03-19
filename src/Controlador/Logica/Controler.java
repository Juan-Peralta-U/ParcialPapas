/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;
import Vista.CRUDJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Juan
 */
public class Controler implements ActionListener{
    
    CRUDJFrame crudView;
    GestorPapa gestorPapa;
    
    public Controler(){
        
        this.crudView = new CRUDJFrame();
        this.gestorPapa = new GestorPapa();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            
            
        }
        
    }
    
}
