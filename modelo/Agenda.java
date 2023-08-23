package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 * Clase que representa la agenda de un partido en el sistema.
 * Los objetos de esta clase contienen información sobre la programación
 * de un partido, incluyendo el identificador de la agenda, el partido
 * asociado, la fecha, el lugar, la hora y el estado.
 */
public class Agenda {

    // Atributos de la clase Agenda
    protected Integer id_agenda;
    protected Partido partido_id;

    protected Date fecha_partido;
    protected String lugar_partido;
    protected Time hora_partido;
    protected String estado;

    /**
     * Constructor por defecto de la clase Agenda.
     * Crea una instancia de Agenda sin inicializar sus atributos.
     */
    public Agenda() {
    }

    /**
     * Constructor de la clase Agenda con parámetros.
     * Crea una instancia de Agenda con los atributos proporcionados.
     *
     * @param id_agenda Identificador único de la agenda.
     * @param partido_id Partido asociado a la agenda.
     * @param fecha_partido Fecha del partido.
     * @param lugar_partido Lugar del partido.
     * @param hora_partido Hora del partido.
     * @param estado Estado de la agenda.
     */
    public Agenda(Integer id_agenda, Partido partido_id, Date fecha_partido, String lugar_partido, Time hora_partido,
            String estado) {
        this.id_agenda = id_agenda;
        this.partido_id = partido_id;
        this.fecha_partido = fecha_partido;
        this.lugar_partido = lugar_partido;
        this.hora_partido = hora_partido;
        this.estado = estado;
    }

    /**
     * Constructor de la clase Agenda con parámetros.
     * Crea una instancia de Agenda con los atributos proporcionados.
     *
     * @param partido_id Partido asociado a la agenda.
     * @param fecha_partido Fecha del partido.
     * @param lugar_partido Lugar del partido.
     * @param hora_partido Hora del partido.
     */
    public Agenda(Partido partido_id, Date fecha_partido, String lugar_partido, Time hora_partido) {
        this.partido_id = partido_id;
        this.fecha_partido = fecha_partido;
        this.lugar_partido = lugar_partido;
        this.hora_partido = hora_partido;
    }

    /**
     * Métodos getters y setters, sirven para acceder a datos de los objetos, 
     * para leerlos o asignar nuevos valores.
     */
    public Integer getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(Integer id_agenda) {
        this.id_agenda = id_agenda;
    }

    public Partido getPartido_id() {
        return partido_id;
    }

    public void setPartido_id(Partido partido_id) {
        this.partido_id = partido_id;
    }

    public Date getFecha_partido() {
        return fecha_partido;
    }

    public void setFecha_partido(Date fecha_partido) {
        this.fecha_partido = fecha_partido;
    }

    public String getLugar_partido() {
        return lugar_partido;
    }

    public void setLugar_partido(String lugar_partido) {
        this.lugar_partido = lugar_partido;
    }

    public Time getHora_partido() {
        return hora_partido;
    }

    public void setHora_partido(Time hora_partido) {
        this.hora_partido = hora_partido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
