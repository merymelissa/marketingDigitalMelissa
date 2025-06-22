public class GerenteRedesSociales extends Usuario{
    private String[] permisos = {"Gestionar", "Publicar", "Responder"};

    public GerenteRedesSociales(String nombre) {
        super(nombre, "Gerente de Redes Sociales");
    }

    public void realizarTarea() {
        System.out.println("Supervisando la activdad diarai en redes s");
    }

    public void publicarContenido() {
        if (tienePermiso("Publicar")) {
            System.out.println("Publicando contenido en redes");
        }else {
            System.out.println("No tienes permiso par publicar contenido");
        }
    }

    public boolean tienePermiso(String permiso) {
        boolean permitido = false;
        for (int i = 0; i < permisos.length && !permitido; i++) {
            permitido = permisos[i].equalsIgnoreCase(permiso);
        }

        return permitido;
    }
    
    public void responderMensajes() {
        if (tienePermiso("Responder")) {
            System.out.println("Respondiendo mensajes...");
        }else {
            System.out.println("No tienes permisos para responder mensajes");
        }
    }

    public void gestionarRedes() {
        if (tienePermiso("Gestionar")) {
            System.out.println("Gestionando redes");
        }else {
            System.out.println("No tienes permiso para gestionar");
        }
    }
}
