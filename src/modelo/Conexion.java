package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn = null;

    /**
     * @return
     */
    public static Connection conectar() {
        try {
            String url = "jdbc:oracle:thin:@//localhost:1521/xe";
            String user = "Admin";
            String pass = "12345";
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    /**
     *
     */
    public static void desconectar(Connection conn1) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Desconexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

}
