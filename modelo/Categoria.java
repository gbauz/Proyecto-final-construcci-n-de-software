package modelo;

/**
 * Enumeración que define las categorías disponibles en el sistema.
 * Cada categoría tiene un identificador único y un nombre asociado.
 */
public enum Categoria {

    /**
     * Categoría profesional,Identificador: 1
     * Categoría juvenil, Identificador: 2
     * Categoría infantil, Identificador: 3
     */
    PROFESIONAL(1, "PROFESIONAL"),
    JUVENIL(2, "JUVENIL"),
    INFANTIL(3, "INFANTIL");

    private int id;
    private String nombre;

     /**
     * Constructor privado de la enumeración Categoria.
     * Crea una instancia de Categoria con el identificador y el nombre proporcionados.
     *
     * @param id Identificador único de la categoría.
     * @param nombre Nombre de la categoría.
     */
    private Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Método get que obtiene el identificador de la categoría.
     *
     * @return Identificador de la categoría.
     */
    public int getId() {
        return id;
    }

    /**
     * Método get que obtiene el nombre de la categoría.
     *
     * @return Nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

}
