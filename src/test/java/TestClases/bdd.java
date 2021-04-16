package TestClases;

import Utils.Conexion;
import Utils.ReadProperties;

import java. util. Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bdd {
    public void consultar() throws SQLException{
        Conexion con = new Conexion();
        try {
            java.sql.Connection son = con.conectar();
            try (PreparedStatement stmt = son.prepareStatement("SELECT Campo_Texto FROM test002.squema where id = ?")) {
                stmt.setString(1,ReadProperties.readFromConfig("Propiedades.properties").getProperty("idconsulta"));
                ResultSet rs = stmt.executeQuery();

                while (rs.next()){
                    System.out.println(rs.getString("Campo_Texto"));
                }

            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución:");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void insertar() throws SQLException{
        Conexion con = new Conexion();
        try {
            java.sql.Connection son = con.conectar();
            try (PreparedStatement stmt = son.prepareStatement("insert into test002.paises values (0,?, ?);")) {
                stmt.setString(1,ReadProperties.readFromConfig("Propiedades.properties").getProperty("Nuevopais"));
                stmt.setString(2,ReadProperties.readFromConfig("Propiedades.properties").getProperty("Nuevoapodo"));
                boolean rs = stmt.execute();


            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución:");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void modificar() throws SQLException{
        Conexion con = new Conexion();
        try {
            java.sql.Connection son = con.conectar();
            try (PreparedStatement stmt = son.prepareStatement("UPDATE test002.paises SET apodo = ? WHERE id=?;")) {
                Scanner entrada=new Scanner(System.in);
                stmt.setInt(2,Integer.parseInt(ReadProperties.readFromConfig("Propiedades.properties").getProperty("idpais")));
                stmt.setString(1,ReadProperties.readFromConfig("Propiedades.properties").getProperty("campiodeapodo"));
                boolean rs = stmt.execute();

            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución:");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
