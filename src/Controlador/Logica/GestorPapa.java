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

    private PapaDAO miPapaDAO;
    private int iteradorPapas = 1;

    public GestorPapa() {
        obtenerRegistros();
        buscarPapa();
    }

    private void obtenerRegistros() {
        miPapaDAO = new PapaDAO();
        PapaVO miPapa;
        ArrayList<PapaVO> listaDePapas = miPapaDAO.listaDePapas();
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
        miPapaDAO = new PapaDAO();
        //Toca poner un identificador??
        String codigo = "";
        PapaVO papaEncontrada = miPapaDAO.consultarPapa();
        if (papaEncontrada != null) {

            //Lo mismo del metodo de alleba pero System.out.println("Zona de Produccion: " + papaEncontrada.getZonaProduccion());
        } else {
            //ventana de error
        }
    }

    private void registrarPapa() {
        miPapaDAO = new PapaDAO();
        PapaVO registroPapa1 = new PapaVO();
        //Logica para registrar la papa
        /*
        registroPapa1.setNombreComun();
        registroPapa1.setEspecie();
        registroPapa1.setZonaProduccion();
        registroPapa1.setHabitoCrecimiento();
        registroPapa1.setFloracion();
        registroPapa1.setBaya();
        registroPapa1.setTuberculo();


         */
    }

    //Necesito ver bien la presentacion
    private void eliminarPapa() {

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
