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
        buscarEstudiante();
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
                System.out.println("****************Estudiante No. " + numeroEstudiante + "**********");
                System.out.println("Codigo Estudiante: " + miPapa.getEspecie());
                System.out.println("Nombre Estudiante: " + miPapa.getZonaProduccion());
                System.out.println("Edad Estudiante: " + miPapa.getHabitoCrecimiento());
                System.out.println("Edad Estudiante: " + miPapa.getFloracion());
                System.out.println("Edad Estudiante: " + miPapa.getBayas());
                System.out.println("Edad Estudiante: " + miPapa.getTuberculos());
                System.out.println("*************************************************\n");
            }
        } else {
            System.out.println("Actualmente no existen registros de estudiantes");
        }
    }
    
    private void buscarEstudiante() {
        miPapaDAO = new PapaDAO();
        //Toca poner un identificador
        String codigo = "202210200030";
        Papa papaEncontrada = miPapaDAO.consultarPapa();
        if (papaEncontrada != null) {
            System.out.println("Especie Estudiante: " + papaEncontrada.getEspecie());
                System.out.println("Zona de Produccion: " + papaEncontrada.getZonaProduccion());
                System.out.println("HAbito de Crecimiento: " + papaEncontrada.getHabitoCrecimiento());
                System.out.println("Floracion: " + papaEncontrada.getFloracion());
                System.out.println("Bayas: " + papaEncontrada.getBayas());
                System.out.println("Tuberculos: " + papaEncontrada.getTuberculos());
            System.out.println("*************************************************\n");

        } else {
            System.out.println("No existen un papas con ese codigo");
        }
    }
}



