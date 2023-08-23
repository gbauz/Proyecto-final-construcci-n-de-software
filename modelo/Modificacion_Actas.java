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
 * La clase Modificacion_Actas representa la información de actas de partidos.
 * Contiene detalles como fecha, hora de inicio, hora de finalización, nombre del partido,
 * duración, goles anotados por el equipo local, goles anotados por el equipo rival y el ganador.
 */
public class Modificacion_Actas {
    // Atributos de la clase
    protected String fecha;
    protected String horaInicio;
    protected String horaFin;
    protected String partido;
    protected String duracion;
    protected String golesLocal;
    protected String golresRival;
    protected String ganador;

    /**
     * Constructor de la clase Modificacion_Actas.
     * @param fecha La fecha del partido.
     * @param horaInicio La hora de inicio del partido.
     * @param horaFin La hora de finalización del partido.
     * @param partido El nombre del partido.
     * @param duracion La duración del partido.
     * @param golesLocal La cantidad de goles anotados por el equipo local.
     * @param golresRival La cantidad de goles anotados por el equipo rival.
     * @param ganador El nombre del equipo ganador.
     */
    public Modificacion_Actas(String fecha, String horaInicio, String horaFin, String partido, String duracion, String golesLocal, String golresRival, String ganador) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.partido = partido;
        this.duracion = duracion;
        this.golesLocal = golesLocal;
        this.golresRival = golresRival;
        this.ganador = ganador;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getGolresRival() {
        return golresRival;
    }

    public void setGolresRival(String golresRival) {
        this.golresRival = golresRival;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    
    
}
