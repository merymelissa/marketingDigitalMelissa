import java.util.*;

public class DirectorRedesSociales extends Usuario{
    private String[] permisos = {"Crear", "Modificar", "Eliminar"};
    private static ArrayList<Estrategia> listaEstrategia = new ArrayList<>();
    /**
     * Constructor para crear un director de redes
     * @param nombre Nombre del director
     */
    public DirectorRedesSociales(String nombre) {
        super(nombre, "Director Redes Sociales");
    }

    /**
     * Metodo de la clase abstracta Usuario
     * Implementación de la tarea especifica del director
     */
    public void realizarTarea() {
        System.out.println("Analizando listaEstrategia");
    }

    /**
     * Esta función verifica si el director tiene un permiso especifico
     * @param permiso Permiso a verificar
     * @return true si tiene el permiso, devuelve false en caso contrario
     */

     public boolean tienePermiso(String permiso) {
        boolean encontrado = false;
        for (int i = 0; i < permisos.length && !encontrado; i++) {
            encontrado = permisos[i].equalsIgnoreCase(permiso);
        }
        return encontrado;
    }

    /**
     * Crea una nueva estrategia en redes sociales
     * @param nombre Nombre de la estrategia
     * @param plataforma Plataforma de la estrategia
     * @param objetivo Objetivo de la estrategia
     * @return La estrategia creada o null si no tiene permisos
     */
    
    public Estrategia crearEstrategia(String nombre, String plataforma, String nuevoObjetivo) {
        Estrategia resultado = null;
        if (tienePermiso("crear")) {
            resultado = new Estrategia(nombre, plataforma, nuevoObjetivo);
        }else {
            System.out.println("No tienes permisos para crear estrategias");
        }

        return resultado;
    }

    /**
     * Modifica una estrategia existente
     * @param estrategia Estrategia a modificar
     * @param nuevoNombre Nuevo nombre
     * @param nuevoObjetivo Nuevo objetivo
     */

    public void modificarEstrategia(Estrategia estrategia, String nuevoNombre, String nuevoObjetivo) {
        if (tienePermiso("modificar")) {
            estrategia.setNombre(nuevoNombre);
            estrategia.setObjetivo(nuevoObjetivo);
        }else {
            System.out.println("No tienes permisos par modificar estrategias");
        }
    }

    /**
     * Elimina una estrategia del sistema
     * @param estrategia Estrategia a eliminar
     */
    public void eliminarEstrategia(Estrategia estrategia) {
        if (tienePermiso("eliminar")) {
            listaEstrategia.remove(estrategia);
            System.out.println("La estrategia: " + estrategia.getNombre() + " ha sido eliminada");
        }else {
            System.out.println("No tienes permisos para eliminar una estrategia");
        }
    }
}
