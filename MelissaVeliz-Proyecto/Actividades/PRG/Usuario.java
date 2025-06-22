/**
 * Clase abstracta que representa a un usuario del sistema de gestion de campañas.
 * @author Melissa Veliz
 * @version 15/04/25
 */
public abstract class Usuario {
    /**
     * Nombre del usuario
     * Puesto del usuario
     */
    protected String nombre;
    protected String rol;
    
    /**
     * Constructor principal para crear un usuario
     * @param nombre Nombre del usuario
     * @param rol Puesto del usuario
     */
    public Usuario(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    /**
     * Constructor copia
     * @param copiaUsuario Usuario a copiar
     */
    public Usuario(Usuario copiaUsuario) {
        this.nombre = copiaUsuario.nombre;
        this.rol = copiaUsuario.rol;
    }
    /**
     * Metodo abstracto que define la tarea principal del usuario (polimorfismo)
     */
    public abstract void realizarTarea();

    /**
     * Obtiene el nombre del usuario
     * @return Nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Estable el nombre del usuario
     * @param nombre Nombre del usuario que se va a establacer
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el rol del usuario
     * @return Puesto actual del usuario
     */
    public String getRol() {
        return rol;
    }
    /**
     * Estable el rol del usuario
     * @param rol Nombre del usuario que se va a establacer
     * 
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    /**
     * Representa la información en cadena
     * @return La información en cadena, en este caso el nombre y el rol
     */
    @Override
    public String toString() {
        return "Nombre de usuario: " + nombre + "\nRol: " + rol;
    }
    /**
     * Muestra la información del usuario
     */
    public void mostrar(){
        System.out.println("Nombre de usuario: " + nombre + "\nRol: " + rol);
    }
    
}
