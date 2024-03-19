/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;

import Controlador.DAO.PapaDAO;
import Modelo.ArchivoPropiedades;
import Modelo.PapaVO;
import java.util.ArrayList;

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

    private void agregarPapa(String nombreComun,String especie,
            String zonaProduccion, String habitoCrecimiento, 
            String floracion, String bayas, String tuberculos)
    {
        
        
        
        
    }
    
    
    private void obtenerRegistros() {
        PapaVO miPapa;
        ArrayList<PapaVO> listaDePapas = papaDAO.listaDePapas();
        if (listaDePapas.size() > 0) {
            int numeroEstudiante = 0;
            for (int i = 0; i < listaDePapas.size(); i++) {
                numeroEstudiante++;
                miPapa = listaDePapas.get(i);

                //TOda la informacion de las papas
                //EJM System.out.println("Especie: " + miPapa.getEspecie());
                
            }
        } else {
            System.out.println("Actualmente no existen registros de estudiantes");
        }
    }

            
    private void buscarPapa() {
        papaDAO = new PapaDAO();
        //Toca poner un identificador??
        String codigo = "202210200030";
        PapaVO papaEncontrada = papaDAO.consultarPapa();
        if (papaEncontrada != null) {
            
            //Lo mismo del metodo de alleba pero System.out.println("Zona de Produccion: " + papaEncontrada.getZonaProduccion());


        } else {
            //ventana de error
        }
    }
    
    
    public void cargarPapas(ArchivoPropiedades propiedades, Controler controler){
                
        if(propiedades.getData("Papa"+this.iteradorPapas) == null)
            //iniciar CRUD
            return;
            
        String[] pData = propiedades.getData("Papa"+iteradorPapas).split(",");
            
        controler.crearVentanaInicial(pData[0],pData[1],pData[2], this.iteradorPapas);
            
        iteradorPapas++;
            
    }

}
