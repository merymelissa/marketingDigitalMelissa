import java.io.*;
import java.util.*;
/**
 * @author Melissa Veliz
 * @version 15/04/2025
 * 
 * Clase que representa una campaña
 * <p>
 * Cada campaña contiene información sobre nombre, plataforma, presupuesto, estadísticas y clics por día.
 * <p>
 * 
 * <h3>Características:</h3>
 * <ul>
*   <li>Seguimiento por 7 días</li>
*   <li>Registro de clics y visualizaciones</li>
*   <li>Generar reporte en HTML</li>
 * </ul>
 */
public class Campaña {
    /**
     * Numero de dias que dura la campaña
     */
    private final int DIAS = 7;
    /**
     * Como usamos matriz, le indicamos el numero de metricas registradas (clics y visualizaciones)
     */
    private final int VISUALIZACIONES = 2; //cuantos clics y cuantas veces le sale el anuncio en la pantalla
    /**
     * Matriz de estadísticas [DIAS][Visualizaciones]
     */
    private int[][] estadisticas;// de los clics y las visualizaciones de los anunciones en la pantalla
    /**
     * Lista estática de todas las campañas
     */
    private static ArrayList<Campaña> campañas = new ArrayList<>();
    private String nombreCampaña;
    private String plataforma;
    private double presupuesto;
    /**
     * Constructor para crear una nueva campaña
     * @param nombreCampaña Nombre de la campaña
     * @param plataforma Plataforma donde se lanzará la campaña
     * @param presupuesto Presupuesto asignado para la creación de la campaña
     */
    public Campaña(String nombreCampaña, String plataforma, double presupuesto) {
        this.nombreCampaña = nombreCampaña;
        this.plataforma = plataforma;
        this.presupuesto = presupuesto;
        this.estadisticas = new int[DIAS][VISUALIZACIONES];
        campañas.add(this);
    }
    /**
     * Añade una nueva campaña a la lista
     * @param campaña Campaña a añadir a la lista
     */
    public static void añadirCampaña(Campaña campaña) {
        campañas.add(campaña);
    }
    /**
     * Muestra todas las campañas almacenadas en la lista
     */
    public void mostrarCampaña() {
        for (int i = 0; i < campañas.size(); i++) {
            System.out.println(campañas.get(i));
        }
    }
    /**
     * Devuelve la lista de campañas registradas
     * @return Lista de campañas
     */
    public static ArrayList<Campaña> listaCampañas() {
        return campañas;
    }
    /**
     * Añade estadísticas diarias a la campaña para un día específico
     * @param dia Día de semana de (0-6)
     * @param clics Número de clics recibidos
     * @param visualizaciones Número de visualizaciones del anuncio
     */
    public void añadirEstadisticas(int dia, int clics, int visualizaciones) {
        if (dia >= 0 && dia < 7) {
            estadisticas[dia][0] = clics;
            estadisticas[dia][1] = visualizaciones;
        }else{
            System.out.println("El día no es válido");
        }
    }
    /**
     * Muestra las estadísticas de la campaña
     */
    public void mostrarEstadisticas(){
        System.out.println("Estadísticas de la campaña: " + nombreCampaña);
        for (int i = 0; i < DIAS; i++) {
            int clics = estadisticas[i][0];
            int visualizaciones = estadisticas[i][1];
            
            System.out.println("Día: " + (i+1) + "\nNúmero de clics: " + estadisticas[i][0] + "\nVisualizaciones del anuncio: " + estadisticas[i][1]);
        }
    }
    /**
     * Calcula y devuelve los clics acumulados durante la campaña
     * @return Total de clics
     */
    public int getTotalClics() {
        int total = 0;
        for (int i = 0; i < DIAS; i++) {
            total += estadisticas[i][0];
        }

        return total;
    }
    /**
     * Calcula y devuelve el total de visualizaciones acumuladas durante la campaña.
     * @return
     */
    public int getTotalVisualizaciones() {
        int total = 0;
        for (int i = 0; i < DIAS; i++) {
            total += estadisticas[i][1];
        }

        return total;
    }
    /**
     * Realiza una tarea especifica relacionada con la campaña
     */
    public void realizarTarea() {
        System.out.println("Viendo estadísticas");
    }
    /**
     * Devuelve la informacion de la campaña en cadena 
     * @return Cadena de texto con los detalles de la campaña
     */
    @Override
    public String toString() {
        return "Nombre campaña: " + nombreCampaña + "\nPlataforma: " + plataforma + "\nPresupuesto campaña: " + presupuesto + "\nEstadísticas del anuncio " + "\nTotal clics: " + getTotalClics() + "\nTotal de visualizaciones del anuncio: " + getTotalVisualizaciones();
    }
    /**
     * Devuelve una representación HTML de los datos de la campaña
     * @return
     */
    public String toHTML(){
        return "<div>" + 
        "<h3>" + nombreCampaña + "<h3>" +
        "<p>Plataforma: " + plataforma + "</p>" +
        "<p>Presupuesto: " + presupuesto + "</p>" +
        "<p>Visualizaciones: " + getTotalVisualizaciones() + "</p>" +
        "<p>Clics: " + getTotalClics() + "</p>" +
        "</div>";
    }
    /**
     * Guarda los datos de todas las campañas en un archivo
     * @param nombreArchivo Nombre del archivo donde se guardarán los datos
     */
    public static void guardarEnArchivo(String nombreArchivo) {
        try(PrintWriter archivo = new PrintWriter(nombreArchivo)) {
            for (Campaña campaña : campañas) {
                archivo.println("Nombre campaña: " + campaña.nombreCampaña + "\nPlataforma: " + campaña.plataforma + "\nPresupuesto campaña: " + campaña.presupuesto + "\nEstadísticas del anuncio " + " Total clics: " + campaña.getTotalClics() + "\nTotal de visualizaciones del anuncio: " + campaña.getTotalVisualizaciones());
            }
            System.out.println("Datos guardados en " + nombreArchivo);
            
        }catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    /**
     * Obtiene la matriz de estadísticas de la campaña
     * @return
     */
    public int[][] getEstadisticas() {
        return estadisticas;
    }
    /**
     * Establece la matriz de estadísticas, asignando o modificando la matriz 
     * @param estadisticas Nueva matriz de estadísticas
     */
    public void setEstadisticas(int[][] estadisticas) {
        this.estadisticas = estadisticas;
    }
    /**
     * Devuelve el nombre de la campaña
     * @return Nombre de la campaña
     */
    public String getNombreCampaña() {
        return nombreCampaña;
    }
    /**
     * Define el nombre de la campaña
     * @param nombre Nuevo nombre de la campaña
     */
    public void setNombreCampaña(String nombre) {
        this.nombreCampaña = nombre;
    }
    /**
     * Obtiene la plataforma en la que se realiza la campaña
     * @return Plataforma de la campaña
     */
    public String getPlataforma() {
        return plataforma;
    }
    /**
     * Asigna/Modifica la plataforma en la que se realiza la campaña
     * @param plataforma Nueva plataforma
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    /**
     * Obtiene el presupuesto asignado a la campaña
     * @return Presupuesto de la campaña
     */
    public double getPresupuesto() {
        return presupuesto;
    }
    /**
     * Asigna/Modifica el presupuesto asignado a la campaña
     * @param presupuesto Nuevo presupuesto
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    /**
     * Devuelve la lista de campañas
     * @return Lista de campañas
     */
    public static ArrayList<Campaña> getCampaña() {
    return campañas;
    }
    /**
    * Asigna la lista de campañas
    * @param campañas Lista de campañas a modificar
    */
    public static void setCampañas(ArrayList<Campaña> campañas) {
    Campaña.campañas = campañas;
    }
}
