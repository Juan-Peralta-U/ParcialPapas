/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Papa;
import java.util.ArrayList;

/**
 *
 * @author Familia Mora
 */
public class GestorPapa {

    private PapaDAO miPapaDAO;

    public GestorPapa() {
        obtenerRegistros();
        buscarPapa();
    }

    private void obtenerRegistros() {
        miPapaDAO = new PapaDAO();
        Papa miPapa;
        ArrayList<Papa> listaDePapas = miPapaDAO.listaDePapas();
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
        String codigo = "202210200030";
        Papa papaEncontrada = miPapaDAO.consultarPapa();
        if (papaEncontrada != null) {
            
            //Lo mismo del metodo de alleba pero System.out.println("Zona de Produccion: " + papaEncontrada.getZonaProduccion());


        } else {
            //ventana de error
        }
    }
}
