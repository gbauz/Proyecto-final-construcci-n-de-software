package modelo;

/**
 * La clase `UsuarioCache` proporciona una caché simple para almacenar un objeto de tipo `Usuario`.
 * Esta clase se utiliza para almacenar temporalmente un objeto `Usuario` en la memoria, de manera que
 * pueda ser accedido y utilizado en diferentes partes del programa sin tener que cargarlo desde la fuente
 * de datos (como una base de datos) cada vez que se necesita.
 */
public class UsuarioCache {
    
    /**
     * Objeto estático de tipo `Usuario` que actúa como caché para almacenar un usuario.
     */
    public static Usuario usuarioCache = new Usuario();

    /**
     * Método estático para obtener el usuario almacenado en la caché.
     * @return El objeto `Usuario` almacenado en la caché.
     */
    public static Usuario getUsuarioCache() {
        return usuarioCache;
    }

    /**
     * Método estático para establecer el usuario en la caché.
     * @param usuarioCache El objeto `Usuario` que se almacenará en la caché.
     */
    public static void setUsuarioCache(Usuario usuarioCache) {
        UsuarioCache.usuarioCache = usuarioCache;
    }
  
}
