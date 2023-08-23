package modelo;

import java.sql.Date;

/**
 * Clase que representa la asistencia de un árbitro a un partido en el sistema.
 * Los objetos de esta clase contienen información sobre la asistencia de un árbitro
 */
public class Asistencia {

    // Atributos de la clase Asistencia
    protected Integer id_asistencia;
    protected String partido;
    protected String lugar;
    protected Date fecha;
    protected Boolean asistio;
    protected Integer id_arbitro;

    /**
     * Constructor por defecto de la clase Asistencia.
     * Crea una instancia de Asistencia sin inicializar sus atributos.
     */
    public Asistencia(){}

    /**
     * Constructor de la clase Asistencia con parámetros.
     * Crea una instancia de Asistencia con los atributos proporcionados.
     *
     * @param partido Nombre del partido.
     * @param lugar Lugar del partido.
     * @param fecha Fecha del partido.
     * @param asistio Indica si el árbitro asistió al partido.
     * @param id_arbitro Identificador del árbitro.
     */
    public Asistencia(String partido, String lugar, Date fecha, Boolean asistio, Integer id_arbitro) {
        this.partido = partido;
        this.lugar = lugar;
        this.fecha = fecha;
        this.asistio = asistio;
        this.id_arbitro = id_arbitro;
    }

    /**
     * Constructor de la clase Asistencia con parámetros.
     * Crea una instancia de Asistencia con los atributos proporcionados.
     *
     * @param id_asistencia Identificador único de la asistencia.
     * @param partido Nombre del partido.
     * @param lugar Lugar del partido.
     * @param fecha Fecha del partido.
     * @param asistio Indica si el árbitro asistió al partido.
     */
    public Asistencia(Integer id_asistencia, String partido, String lugar, Date fecha, Boolean asistio) {
        this.id_asistencia = id_asistencia;
        this.partido = partido;
        this.lugar = lugar;
        this.fecha = fecha;
        this.asistio = asistio;
    }

    /**
     * Constructor de la clase Asistencia con parámetros.
     * Crea una instancia de Asistencia con los atributos proporcionados.
     *
     * @param id_asistencia Identificador único de la asistencia.
     * @param partido Nombre del partido.
     * @param lugar Lugar del partido.
     * @param fecha Fecha del partido.
     * @param asistio Indica si el árbitro asistió al partido.
     * @param id_arbitro Identificador del árbitro.
     */
    public Asistencia(Integer id_asistencia, String partido, String lugar, Date fecha, Boolean asistio,
            Integer id_arbitro) {
        this.id_asistencia = id_asistencia;
        this.partido = partido;
        this.lugar = lugar;
        this.fecha = fecha;
        this.asistio = asistio;
        this.id_arbitro = id_arbitro;
    }

    /**
     * Métodos getters y setters, sirven para acceder a datos de los objetos, 
     * para leerlos o asignar nuevos valores.
     */
    public Integer getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(Integer id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    public Integer getId_arbitro() {
        return id_arbitro;
    }

    public void setId_arbitro(Integer id_arbitro) {
        this.id_arbitro = id_arbitro;
    }

}
