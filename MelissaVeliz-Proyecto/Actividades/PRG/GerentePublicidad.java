import java.util.Arrays;
/**
 * @author Melissa Veliz
 * @version 15/04/25
 * Clase que representa a un Gerente de publicidad
 * <p>
 * Extiende de Usuario y tiene permisos para supervisar y ejecutar campañas
 * </p>
 * <h3>Permisos disponibles:</h3>
 * <ul>
 *   <li>Supervisar campañas</li>
 *   <li>Ejecutar campañas</li>
 * </ul>
 */
public class GerentePublicidad extends Usuario{
    private String[] permisos = {"Supervisar", "Ejecutar"};
    /**
     * Constructor para crear un gerente de publicidad
     * @param nombre Nombre del gerente
     */
    public GerentePublicidad(String nombre) {
        super(nombre, "Gerente de Publicidad");
    }
    /**
     * Verifica si el gerente tiene permisos o no
     * @param permiso Permisos a verificar
     * @return true si tiene permiso, false si no
     */
    public boolean tienePermiso(String permiso) {
        for (int i = 0; i < permisos.length; i++) {
            if (permisos[i].equalsIgnoreCase(permiso)) {
            return true;   
            }
        }
        return false;
    }
    /**
     * Supervisa una campaña, mostrando sus estadísticas
     * @param campaña Campaña a supervisar
     */
    public void superVisarCampaña(Campaña campaña) {
        if (tienePermiso("supervisar")) {
            System.out.println("Supervisando campaña: " + campaña.getNombreCampaña());
            campaña.mostrarEstadisticas();
        }else {
            System.out.println("No tienes permisos para supervisar campaña");
        }
    }
    /**
     * Ejecuta una campaña, mostrando sus estadísticas
     * @param campaña Campaña a ejecutar
     */
    public void ejecutarCampaña(Campaña campaña) {
        if (tienePermiso("ejecutar")) {
            System.out.println("Ejecutando campaña: " + campaña.getNombreCampaña());
            campaña.mostrarEstadisticas();
        }else {
            System.out.println("No tienes permisos para ejecutar campaña");
        }
    }
    /**
     * Muestra la informacion del gerente en cadena 
     * @return String con la info del gerente y sus permisos
     */
    @Override
    public String toString() {
        return super.toString() + "\nPermisos: " + Arrays.toString(permisos); //ese funcion sirve para mostrar el array 
    }
    /**
     * Metodo abstracto de la clase padre Usuario
     * Implementación de la tarea principal de gerente
     */
    @Override
    public void realizarTarea() {
        System.out.println("Ejecutando compaña...");
    }
}
