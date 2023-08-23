package modelo;

/**
 * Clase que representa un equipo de fútbol en el sistema.
 * Los objetos de esta clase contienen información sobre los equipos y su director.
 */
public class Equipo_futbol {

    // Atributos de la clase Equipo_futbol
    protected Integer id_equipo;
    protected String nombre_equipo;
    protected String director;
    protected String estado;

    /**
     * Constructor por defecto de la clase Equipo_futbol.
     * Crea una instancia de Equipo_futbol sin inicializar sus atributos.
     */
    public Equipo_futbol() {
    }

    /**
     * Constructor de la clase Equipo_futbol con parámetros.
     * Crea una instancia de Equipo_futbol con los atributos proporcionados.
     *
     * @param id_equipo Identificador único del equipo.
     * @param nombre_equipo Nombre del equipo.
     * @param director Nombre del director del equipo.
     * @param estado Estado actual del equipo.
     */
    public Equipo_futbol(Integer id_equipo, String nombre_equipo, String director, String estado) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.director = director;
        this.estado = estado;
    }
    
    /**
     * Constructor de la clase Equipo_futbol con parámetros.
     * Crea una instancia de Equipo_futbol con los atributos proporcionados.
     *
     * @param id_equipo Identificador único del equipo.
     * @param nombre_equipo Nombre del equipo.
     * @param director Nombre del director del equipo.
     */
    public Equipo_futbol(Integer id_equipo, String nombre_equipo, String director) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.director = director;
    }

    /**
     * Constructor de la clase Equipo_futbol con parámetros.
     * Crea una instancia de Equipo_futbol con los atributos proporcionados.
     *
     * @param id_equipo Identificador único del equipo.
     * @param nombre_equipo Nombre del equipo.
     */
    public Equipo_futbol(Integer id_equipo, String nombre_equipo) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
    }

    /**
     * Constructor de la clase Equipo_futbol con parámetro.
     * Crea una instancia de Equipo_futbol con el identificador proporcionado.
     *
     * @param id_equipo Identificador único del equipo.
     */
    public Equipo_futbol(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * Métodos getters y setters, sirven para acceder a datos de los objetos, 
     * para leerlos o asignar nuevos valores.
     */
    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
