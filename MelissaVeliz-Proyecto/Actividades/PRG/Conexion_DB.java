

import java.sql.*;
public class Conexion_DB {
    
    public Connection AbrirConexion() throws Exception{
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://localhost:3306/marketing_db";
            con = (java.sql.DriverManager.getConnection(urlOdbc,"root", "1234"));
            return con;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexión" + e.getMessage());
        }
    }

    public void CerrarConexion(Connection con) throws Exception {
        try {
            if (con != null) con.close();
                
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ha sido imposible cerrar la conexión" + e.getMessage());
        }
    }

    

    


}

