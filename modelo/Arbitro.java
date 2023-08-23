
package modelo;

/**
 * Clase que representa a un árbitro en el sistema, extendiendo la clase Usuario.
 */
public class Arbitro extends Usuario {

    // Atributos de clase Arbitro
    protected String edad;
    protected String categoria;
    protected String nacionalidad;
    protected String cantidad_partidos;

    /**
     * Constructor por defecto de la clase Arbitro.
     * Crea una instancia de Arbitro sin inicializar sus atributos específicos.
     */
    public Arbitro() {
        this.edad = "";
        this.categoria = "";
        this.nacionalidad = "";
        this.cantidad_partidos = "";
    }

    /**
     * Constructor de la clase Arbitro con parámetros.
     * Crea una instancia de Arbitro con los atributos proporcionados, incluyendo
     * los atributos heredados de la clase Usuario.
     *
     * @param id_usuario Identificador único del árbitro (heredado de Usuario).
     * @param nombre Nombre del árbitro (heredado de Usuario).
     * @param apellido Apellido del árbitro (heredado de Usuario).
     * @param nombre_usuario Nombre de usuario del árbitro (heredado de Usuario).
     * @param email Correo electrónico del árbitro (heredado de Usuario).
     * @param contrasenia Contraseña del árbitro (heredado de Usuario).
     * @param estado Estado del árbitro (heredado de Usuario).
     * @param edad Edad del árbitro.
     * @param categoria Categoría del árbitro.
     * @param nacionalidad Nacionalidad del árbitro.
     * @param cantidad_partidos Cantidad de partidos arbitrados por el árbitro.
     */
    public Arbitro(Integer id_usuario, String nombre, String apellido,
            String nombre_usuario, String email, String contrasenia,
            String estado, String edad, String categoria, String nacionalidad,
            String cantidad_partidos) {
        super(id_usuario, nombre, apellido, nombre_usuario, contrasenia, email, estado);
        this.edad = edad;
        this.categoria = categoria;
        this.nacionalidad = nacionalidad;
        this.cantidad_partidos = cantidad_partidos;
    }
    
    /**
     * Constructor de la clase Arbitro con parámetros.
     * Crea una instancia de Arbitro con los atributos proporcionados, incluyendo
     * los atributos heredados de la clase Usuario.
     *
     * @param id_usuario Identificador único del árbitro (heredado de Usuario).
     * @param nombre Nombre del árbitro (heredado de Usuario).
     * @param apellido Apellido del árbitro (heredado de Usuario).
     * @param nombre_usuario Nombre de usuario del árbitro (heredado de Usuario).
     * @param email Correo electrónico del árbitro (heredado de Usuario).
     * @param contrasenia Contraseña del árbitro (heredado de Usuario).
     * @param estado Estado del árbitro (heredado de Usuario).
     * @param categoria Categoría del árbitro.
     * @param nacionalidad Nacionalidad del árbitro.
     */
    public Arbitro(Integer id_usuario, String nombre, String apellido,
            String nombre_usuario, String email, String contrasenia,
            String estado, String categoria, String nacionalidad)
    {
        super(id_usuario, nombre, apellido, nombre_usuario, contrasenia, email, estado);
        this.categoria = categoria;
        this.nacionalidad = nacionalidad;
    }

    /**
     * Métodos getters y setters, sirven para acceder a datos de los objetos, 
     * para leerlos o asignar nuevos valores.
     */
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCantidad_partidos() {
        return cantidad_partidos;
    }

    public void setCantidad_partidos(String cantidad_partidos) {
        this.cantidad_partidos = cantidad_partidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
