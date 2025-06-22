import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;
        ArrayList<Campaña> campañas = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketing_db", "root", "1234");
            System.out.println("Connection succed OK");
            System.out.println("Conexion establecida OK");
            stmt = con.createStatement();
            CampañaDAO campañaDAO = new CampañaDAO();
            campañaDAO.crearTablaCampaña(con);
            Campaña campaña1 = new Campaña("Verano2025", "Instagram", 1000);
            //intertamos campañas
            campañaDAO.insertaCampaña(con, campaña1);
            //mostramos campañas
            campañaDAO.obtenerLasCampañas(con, campañas);

        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.close();
        }

        //Creacion de usuario
        Usuario director = new DirectorPublicidad("Rick Torres");
        Usuario gerente = new GerentePublicidad("Melissa Veliz");

        System.out.println("Tarea de usuarios");
        director.realizarTarea();
        gerente.realizarTarea();

        //Creación de campañas
        Campaña navidad = ((DirectorPublicidad)director).crearCampaña("Navidad", "FACEBOOK", 12220);
        Campaña primavera = ((DirectorPublicidad)director).crearCampaña("Primavera", "Intagrama", 20300);
        
        //Añadimos estadisticas
        navidad.añadirEstadisticas(0, 60, 200);
        primavera.añadirEstadisticas(1, 1000, 20000);

        //Archivos
        System.out.println("Dime el nombre de archivo donde quieras guardar: ");
        String archivo = teclado.nextLine();

        ((DirectorPublicidad)director).guardarCampañas(archivo);
        ((DirectorPublicidad)director).cargarCampaña(archivo);

        //Modificar o eliminar
        ((DirectorPublicidad)director).modificarCampaña(primavera, "Ultimas rebajas", 600);
        //((DirectorPublicidad)director).eliminarCampaña(primavera); la comento para probar lo de abajo

        //Funciones Gerente
        ((GerentePublicidad)gerente).ejecutarCampaña(navidad);
        ((GerentePublicidad)gerente).superVisarCampaña(primavera);

        //Mostrar camapañas
        Campaña campaña = new Campaña("Navidiad", "Instagram", 4000);
        campaña.mostrarCampaña();

        //Generar y mostrar HTML
        System.out.println(navidad.toHTML());
        

    }
}
