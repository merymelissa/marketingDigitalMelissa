import java.sql.*;
import java.util.*;

public class CampañaDAO {

    public void crearTablaCampaña(Connection con)  throws SQLException{
        String createTable = "CREATE TABLE IF NOT EXISTS campañas (" + 
        "Nombre VARCHAR(40), " +
        "Plataforma VARCHAR(50), " + 
        "Presupuesto DOUBLE NOT NULL)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(createTable);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            stmt.close();
        }
    }

    public void insertaCampaña(Connection con, Campaña campaña) throws SQLException{
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO campañas (Nombre, Plataforma, Presupuesto) VALUES (?, ?, ?)");
            stmt.setString(1, campaña.getNombreCampaña());
            stmt.setString(2, campaña.getPlataforma());
            stmt.setDouble(3, campaña.getPresupuesto());
            stmt.executeUpdate();
            System.out.println("Datos insertados en la BD");
        } catch (SQLException e) {
            System.out.println("Error al insertar datos en la bd" + e.getMessage());
        }finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void eliminar(Connection con, Campaña campaña) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM campañas WHERE nombre = ?");
            stmt.setString(1, campaña.getNombreCampaña());
            stmt.executeUpdate();
            System.out.println("Campaña eliminada");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al eliminar una campaña " + e.getMessage());
        }finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void actualiza(Connection con, Campaña campaña) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE campaña SET Nombre=?, Plataforma=?, Presupuesto=? WHERE nombre = ?");
            stmt.setString(1, campaña.getNombreCampaña());
            stmt.setString(2, campaña.getPlataforma());
            stmt.setDouble(3, campaña.getPresupuesto());
            stmt.executeUpdate();
            System.out.println("Campaña actualizada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar campaña");
        }
    }

    public List<Campaña> obtenerLasCampañas(Connection con, ArrayList<Campaña> campañas) throws SQLException {
        Campaña campaña;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM campañas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                campaña = new Campaña(
                rs.getString("Nombre"),
                rs.getString("Plataforma"),
                rs.getDouble("Presupuesto"));
                campañas.add(campaña);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Ha habido un error al mostrar las campañas");
        }finally {
            if(rs != null) rs.close();
            if (stmt != null) stmt.close();
        }

        return campañas;
    }
}
