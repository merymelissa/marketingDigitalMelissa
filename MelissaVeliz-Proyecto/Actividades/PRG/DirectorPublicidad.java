import java.io.*;
/**
 * @author Melissa Veliz
 * @version 15/04/2025
 * 
 * Clase que representa a un director de publicidad.
 * <p>
 * Hereda/Extiende de la clase Usuario, podrá crear, modificar y eliminar campañas.
 * <p>
 * 
 * <h3>Permisos disponibles:</h3>
 * <ul>
*   <li>Crear campañas</li>
*   <li>Modificar campañas</li>
*   <li>Eliminar campañas</li>
 * </ul>
 */
public class DirectorPublicidad extends Usuario{
    private String[] permisos = {"Crear", "Modificar", "Eliminar"};

    /**
     * Constructor para crear un director de publicidad
     * @param nombre Nombre del director
     */
    public DirectorPublicidad(String nombre) {
        super(nombre, "Director de Publicidad");
    }
    /**
     * Metodo de la clase abstracta Usuario
     * Implementación de la tarea especifica del director
     */
    @Override public void realizarTarea() {
        System.out.println("Revisando las campañas...");
    }
    /**
     * Esta función verifica si el director tiene un permiso especifico
     * @param permiso Permiso a verificar
     * @return true si tiene el permiso, devuelve false en caso contrario
     */
    public boolean tienePermiso(String permiso) {
        boolean tienePermiso = false;
        for (int i = 0; i < permisos.length; i++) {
            if (permisos[i].equalsIgnoreCase(permiso)) {
                tienePermiso = true;   
            }
        }
        return tienePermiso;
    }
    /**
     * Crea una nueva campaña
     * @param nombre Nombre de la campaña
     * @param plataforma Plataforma donde se anuncia
     * @param presupuesto Presupuesto asignado
     * @return La campaña creada o devuelve null si no tiene permisos
     */
    public Campaña crearCampaña(String nombre, String plataforma, double presupuesto) {
        if (tienePermiso("crear")) {
            return new Campaña(nombre, plataforma, presupuesto);
        }else {
            System.out.println("No tienes permisos para crear campañas");
            return null;
        }
    }
    /**
     * Modifica una campaña, pero tiene que existir alguna
     * @param campaña Campaña a modificar
     * @param nuevoNommbre Nuevo nombre para la campaña
     * @param nuevoPresupuesto Nuevo presupuesto para la campaña
     */
    public void modificarCampaña(Campaña campaña, String nuevoNombre, double nuevoPresupuesto) {
        if (tienePermiso("modificar")) {
            campaña.setNombreCampaña(nuevoNombre);
            campaña.setPresupuesto(nuevoPresupuesto);
            System.out.println("Campaña modificada: " + campaña);
        }else {
            System.out.println("No tienes permisos para modificar la campaña");
        }
    }
    /**
     * Elimina una campaña del sistema
     * @param campaña Campaña a eliminar
     */
    public void eliminarCampaña(Campaña campaña ) {
        if (tienePermiso("eliminar")) {
            Campaña.listaCampañas().remove(campaña);
            System.out.println("La campaña" +  campaña.getNombreCampaña() + " ha sido eliminada");
        }else {
            System.out.println("No tienes permisos para eliminar campaña");
        }
    }
    /**
     * Guarda todas las campañas en un archivo de texto
     * @param nombreArchivo Ruta del archivo donde se cargarán las campañas
     */
    public void guardarCampañas(String nombreArchivo) {
        try (PrintWriter archivo = new PrintWriter(nombreArchivo)){
            for(Campaña campaña: Campaña.getCampaña()) {
            archivo.println("Nombre campaña: " + campaña.getNombreCampaña() + "\nPlataforma: " + campaña.getPlataforma() + "\nPresupuesto campaña: " + campaña.getPresupuesto() + "\nEstadísticas del anuncio " + " Total clics: " + campaña.getTotalClics() + "\nTotal de visualizaciones del anuncio: " + campaña.getTotalVisualizaciones());
            }
            System.out.println("Campañas guardadas en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    /**
     * Carga campañas desde un archivo de texto
     * @param nombreArchivo Ruta del archivo donde a cargar
     */
    public void cargarCampaña(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))){
            Campaña.getCampaña().clear();
            String linea;
            while ((linea = reader.readLine()) != null) {
                String datos [] = linea.split(",");
                if (datos.length == 3) {
                    Campaña nuevacampaña = new Campaña(datos[0], datos[1], Double.parseDouble(datos[2]));
                    Campaña.añadirCampaña(nuevacampaña);
                }
            }
            System.out.println("Campaña cargada en : " + nombreArchivo);
        } catch (Exception e) {

            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
    
}
