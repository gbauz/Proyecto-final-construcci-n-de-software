/**
 * La clase Usuario representa un objeto de usuario en el sistema.
 * Contiene atributos que describen diferentes aspectos de un usuario,
 * como su identificación, nombre, apellido, nombre de usuario, contraseña,
 * dirección de correo electrónico, estado y rol.
 */
package modelo;

public class Usuario {

    // Atributos del usuario
    protected Integer id_usuario;
    protected String nombre;
    protected String apellido;
    protected String nombre_usuario;
    protected String contrasenia;
    protected String email;
    protected String estado;
    protected Integer id_rol;
    protected String nombre_rol;

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor que inicializa los atributos básicas del usuario.
     *
     * @param id_usuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     */
    public Usuario(Integer id_usuario, String nombre, String apellido) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Constructor que inicializa todas los atributos del usuario.
     *
     * @param id_usuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param nombre_usuario Nombre de usuario del usuario.
     * @param contrasenia Contraseña del usuario.
     * @param email Dirección de correo electrónico del usuario.
     * @param estado Estado actual del usuario.
     * @param id_rol Identificador del rol del usuario.
     */
    public Usuario(Integer id_usuario, String nombre, String apellido, String nombre_usuario, String contrasenia,
            String email, String estado, Integer id_rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.email = email;
        this.estado = estado;
        this.id_rol = id_rol;
    }

    /**
     * Constructor que inicializa todas los atributos del usuario, incluido el nombre del rol.
     *
     * @param id_usuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param nombre_usuario Nombre de usuario del usuario.
     * @param contrasenia Contraseña del usuario.
     * @param email Dirección de correo electrónico del usuario.
     * @param id_rol Identificador del rol del usuario.
     * @param nombre_rol Nombre del rol del usuario.
     */
    public Usuario(Integer id_usuario, String nombre, String apellido, String nombre_usuario, String contrasenia,
            String email, Integer id_rol, String nombre_rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.email = email;
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    /**
     * Constructor que inicializa los atributos del usuario sin el estado.
     *
     * @param id_usuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param nombre_usuario Nombre de usuario del usuario.
     * @param contrasenia Contraseña del usuario.
     * @param email Dirección de correo electrónico del usuario.
     * @param estado Estado actual del usuario.
     */
    public Usuario(Integer id_usuario, String nombre, String apellido, String nombre_usuario, String contrasenia,
            String email, String estado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.email = email;
        this.estado = estado;
    }

    /**
     * Retorna el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public Integer getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id_usuario El nuevo identificador único del usuario.
     */
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Retorna el estado actual del usuario.
     *
     * @return El estado actual del usuario.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del usuario.
     *
     * @param estado El nuevo estado actual del usuario.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna el identificador del rol del usuario.
     *
     * @return El identificador del rol del usuario.
     */
    public Integer getId_rol() {
        return id_rol;
    }

    /**
     * Establece el identificador del rol del usuario.
     *
     * @param id_rol El nuevo identificador del rol del usuario.
     */
    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * Retorna el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El nuevo apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Retorna el nombre de usuario del usuario.
     *
     * @return El nombre de usuario del usuario.
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * Establece el nombre de usuario del usuario.
     *
     * @param nombre_usuario El nuevo nombre de usuario del usuario.
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * Retorna la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Retorna la dirección de correo electrónico del usuario.
     *
     * @return La dirección de correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la dirección de correo electrónico del usuario.
     *
     * @param email La nueva dirección de correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna el nombre del rol del usuario.
     *
     * @return El nombre del rol del usuario.
     */
    public String getNombre_rol() {
        return nombre_rol;
    }

    /**
     * Establece el nombre del rol del usuario.
     *
     * @param nombre_rol El nuevo nombre del rol del usuario.
     */
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
}
