package Utils;

import java.sql.*;
import java.sql.DriverManager;


public class Conexion {
    public java.sql.Connection conectar () throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }String sURL = "jdbc:mysql://localhost:3306/test002";
        return DriverManager.getConnection(sURL,ReadProperties.readFromConfig("Propiedades.properties").getProperty("userbdd"),ReadProperties.readFromConfig("Propiedades.properties").getProperty("passbdd"));
    }
    /*public void desconectar () throws SQLException {
        con.close();
    }
    public void insertar(String insertar){
        try (PreparedStatement stmt = con.prepareStatement(insertar)) {
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }
    public String consultarNombre(int id){
        try (PreparedStatement stmt = con.prepareStatement("SELECT Campo_Texto FROM test002.squema where id = ?")) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                return rs.getString("Campo_Texto");
            }
            return "sin respuesta";

        } catch (SQLException sqle) {
            return "Error en la ejecución:";
     }
   }*/
}
