/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Clase PapaVO
 *
 * Esta clase representa un objeto de transferencia de datos (Value Object) para
 * almacenar la información de una variedad de papa. Contiene atributos para
 * almacenar el nombre común, especie, zona de producción, hábito de
 * crecimiento, información sobre la floración, bayas y tubérculos, así como los
 * métodos getter y setter correspondientes.
 *
 * @author Familia Mora
 */
public class PapaVO {

    /**
     * Nombre común de la variedad de papa.
     */
    private String nombreComun;
    /**
     * Especie de la variedad de papa.
     */
    private String especie;
    /**
     * Zona de producción de la variedad de papa.
     */
    private String zonaProduccion;
    /**
     * Hábito de crecimiento de la variedad de papa.
     */
    private String habitoCrecimiento;
    /**
     * Información sobre la floración de la variedad de papa.
     */
    private String floracion;
    /**
     * Información sobre las bayas de la variedad de papa.
     */
    private String bayas;
    /**
     * Información sobre los tubérculos de la variedad de papa.
     */
    private String tuberculos;

    /**
     * Constructor por defecto de la clase PapaVO.
     */
    public PapaVO() {
    }

    ;
    
    /**
 * Obtiene el nombre común de la variedad de papa.
 *
 * @return Nombre común de la variedad de papa.
 */
    public String getNombreComun() {
        return nombreComun;
    }

    /**
     * Establece el nombre común de la variedad de papa.
     *
     * @param nombreComun Nombre común de la variedad de papa.
     */
    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    /**
     * Obtiene la especie de la variedad de papa.
     *
     * @return Especie de la variedad de papa.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Establece la especie de la variedad de papa.
     *
     * @param especie Especie de la variedad de papa.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Obtiene la zona de producción de la variedad de papa.
     *
     * @return Zona de producción de la variedad de papa.
     */

    public String getZonaProduccion() {
        return zonaProduccion;
    }

    /**
     * Establece la zona de producción de la variedad de papa.
     *
     * @param zonaProduccion Zona de producción de la variedad de papa.
     */
    public void setZonaProduccion(String zonaProduccion) {
        this.zonaProduccion = zonaProduccion;
    }

    /**
     * Obtiene el hábito de crecimiento de la variedad de papa.
     *
     * @return Hábito de crecimiento de la variedad de papa.
     */
    public String getHabitoCrecimiento() {
        return habitoCrecimiento;
    }

    /**
     * Establece el hábito de crecimiento de la variedad de papa.
     *
     * @param habtoCrecimiento Hábito de crecimiento de la variedad de papa.
     */
    public void setHabitoCrecimiento(String habtoCrecimiento) {
        this.habitoCrecimiento = habtoCrecimiento;
    }

    /**
     * Obtiene la información sobre la floración de la variedad de papa.
     *
     * @return Información sobre la floración de la variedad de papa.
     */
    public String getFloracion() {
        return floracion;
    }

    /**
     * Establece la información sobre la floración de la variedad de papa.
     *
     * @param floracion Información sobre la floración de la variedad de papa.
     */
    public void setFloracion(String floracion) {
        this.floracion = floracion;
    }

    /**
     * Obtiene la información sobre las bayas de la variedad de papa.
     *
     * @return Información sobre las bayas de la variedad de papa.
     */
    public String getBayas() {
        return bayas;
    }

    /**
     * Establece la información sobre las bayas de la variedad de papa.
     *
     * @param bayas Información sobre las bayas de la variedad de papa.
     */
    public void setBayas(String bayas) {
        this.bayas = bayas;
    }

    /**
     * Obtiene la información sobre los tubérculos de la variedad de papa.
     *
     * @return Información sobre los tubérculos de la variedad de papa.
     */
    public String getTuberculos() {
        return tuberculos;
    }

    /**
     * Establece la información sobre los tubérculos de la variedad de papa.
     *
     * @param tuberculos Información sobre los tubérculos de la variedad de
     * papa.
     */
    public void setTuberculos(String tuberculos) {
        this.tuberculos = tuberculos;
    }

}
