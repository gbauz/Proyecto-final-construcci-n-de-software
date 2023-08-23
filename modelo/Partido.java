package modelo;

/**
 * Clase que representa un partido en el sistema.
 * Los objetos de esta clase contienen información sobre los partidos deportivos.
 */
public class Partido {
    
    // Atributos de la clase Partido
    protected Integer id_partido;
    protected Equipo_futbol club_local;
    protected Equipo_futbol club_rival;
    protected String estado;
    protected String partido_descripcion;

    /**
     * Constructor por defecto de la clase Partido.
     * Crea una instancia de Partido sin inicializar sus atributos.
     */
    public Partido() {
    }

    /**
     * Constructor de la clase Partido con parámetro.
     * Crea una instancia de Partido con el identificador proporcionado.
     *
     * @param id_partido Identificador único del partido.
     */
    public Partido(Integer id_partido) {
        this.id_partido = id_partido;
    }

    /**
     * Constructor de la clase Partido con parámetros.
     * Crea una instancia de Partido con el identificador y la descripción del partido proporcionados.
     *
     * @param id_partido Identificador único del partido.
     * @param partido_descripcion Descripción del partido.
     */
    public Partido(Integer id_partido, String partido_descripcion) {
        this.id_partido = id_partido;
        this.partido_descripcion = partido_descripcion;
    }

    /**
     * Constructor de la clase Partido con parámetros.
     * Crea una instancia de Partido con el identificador y los equipos locales y rivales proporcionados.
     *
     * @param id_partido Identificador único del partido.
     * @param club_local Objeto Equipo_futbol representando al club local.
     * @param club_rival Objeto Equipo_futbol representando al club rival.
     */
    public Partido(Integer id_partido, Equipo_futbol club_local, Equipo_futbol club_rival) {
        this.id_partido = id_partido;
        this.club_local = club_local;
        this.club_rival = club_rival;
    }

    /**
     * Constructor de la clase Partido con parámetros.
     * Crea una instancia de Partido con el identificador, equipos locales y rivales, y el estado proporcionados.
     *
     * @param id_partido Identificador único del partido.
     * @param club_local Objeto Equipo_futbol representando al club local.
     * @param club_rival Objeto Equipo_futbol representando al club rival.
     * @param estado Estado actual del partido.
     */
    public Partido(Integer id_partido, Equipo_futbol club_local, Equipo_futbol club_rival, String estado) {
        this.id_partido = id_partido;
        this.club_local = club_local;
        this.club_rival = club_rival;
        this.estado = estado;
    }

    /**
     * Métodos getters y setters, sirven para acceder a datos de los objetos, 
     * para leerlos o asignar nuevos valores.
     */
    public Equipo_futbol getClub_local() {
        return club_local;
    }

    public void setClub_local(Equipo_futbol club_local) {
        this.club_local = club_local;
    }

    public Equipo_futbol getClub_rival() {
        return club_rival;
    }

    public void setClub_rival(Equipo_futbol club_rival) {
        this.club_rival = club_rival;
    }

    public Integer getId_partido() {
        return id_partido;
    }
    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPartido_descripcion() {
        return partido_descripcion;
    }

    public void setPartido_descripcion(String partido_descripcion) {
        this.partido_descripcion = partido_descripcion;
    }
}
