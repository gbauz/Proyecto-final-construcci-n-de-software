/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author John
 */

/**
 * Clase que representa la disponibilidad de un árbitro para un partido en el sistema.
 */
public class Disponibilidad {
    
    // Atributos de la clase Disponibilidad
    protected String nombre_arbitro;
    protected String categoria;
    protected String partido;
    protected String disponibilidad;

    /**
     * Constructor de la clase Disponibilidad con parámetros.
     * Crea una instancia de Disponibilidad con los atributos proporcionados.
     *
     * @param nombre_arbitro Nombre del árbitro.
     * @param categoria Categoría del árbitro.
     * @param partido Nombre del partido.
     * @param disponibilidad Disponibilidad del árbitro para el partido.
     */
    public Disponibilidad(String nombre_arbitro, String categoria, String partido, String disponibilidad) {
        this.nombre_arbitro = nombre_arbitro;
        this.categoria = categoria;
        this.partido = partido;
        this.disponibilidad = disponibilidad;
    }

    /**
     * Métodos getters y setters, sirven para acceder a datos de los objetos, 
     * para leerlos o asignar nuevos valores.
     */
    public String getNombre_arbitro() {
        return nombre_arbitro;
    }

    public void setNombre_arbitro(String nombre_arbitro) {
        this.nombre_arbitro = nombre_arbitro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
 
}
