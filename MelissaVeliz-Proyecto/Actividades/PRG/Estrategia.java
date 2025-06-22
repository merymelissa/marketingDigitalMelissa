import java.util.ArrayList;

public class Estrategia {
    private String nombre;
    private String descripcion;
    private String objetivo;
    
    public Estrategia(String nombre, String descripcion, String objetivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void implementarEstrategia() {
        if (!objetivo.equalsIgnoreCase("Completada")) {
            objetivo = "En proceso";
            System.out.println("Implementando la estrategia: " + nombre);
        }else {
            System.out.println("La estrategia ya fue completada");
        }
    }

    

    
}
