import java.sql.*;
import java.util.*;
public class CampañaDAOTest {
    private CampañaDAO campañaDAO;
    private Connection con;

    @BeforeAll
    public  void iniciar() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketing_db", "root", "1234");
        campañaDAO = new CampañaDAO();
        campañaDAO.crearTablaCampaña(con);
    }

    @Test
    public void pruebaInsertarYLeer() throws Exception {
        Campaña c = new Campaña("Test1", "TikTok", 1000);
        campañaDAO.insertaCampaña(con, c);
        ArrayList<Campaña> campañas = new ArrayList<>();
        campañaDAO.obtenerLasCampañas(con, campañas);

        boolean existe = false;
        for (Campaña campaña : campañas) {
            if (campaña.getNombreCampaña().equalsIgnoreCase("Test1") && !existe) {
                existe = true;
            }
        }
        assert(existe);
    }

    @Test
    public void pruebaEliminar() throws Exception {
        Campaña c = new Campaña("TestBorrar", "Youtube", 1400);
        campañaDAO.insertaCampaña(con, c);
        campañaDAO.eliminar(con, c);

        ArrayList<Campaña> campañas = new ArrayList<>();
        campañaDAO.obtenerLasCampañas(con, campañas);

        boolean existe = false;
        for (Campaña campaña : campañas) {
            if (campaña.getNombreCampaña().equalsIgnoreCase("TestBorrar") && !existe) {
                existe = true;
            }
        }
        assert(existe);
    }
    
    @AfterAll
    public void cerrar() throws Exception {
        if(con != null) con.close();
    }
}
