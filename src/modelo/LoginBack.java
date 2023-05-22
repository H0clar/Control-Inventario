package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBack {

    public Login buscarUsuario(String rut, String pass) {
        try (Connection conn = Conexion.conectar()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuario WHERE rut = ? AND pass = ?");
            ps.setString(1, rut);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Login login = new Login();
                login.setRut(rs.getString("rut"));
                login.setPass(rs.getString("pass"));
                login.setNombre(rs.getString("nombre"));
                login.setTipouser(rs.getString("tipouser"));
                return login;
            }
        } catch (SQLException e) {
            System.err.println("Error en la validación de usuario: " + e);
        }
        return null;
    }

    public String obtenerTipoUsuario(String rut) {
        try (Connection conn = Conexion.conectar()) {
            PreparedStatement ps = conn.prepareStatement("SELECT tipouser FROM usuario WHERE rut = ?");
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("tipouser");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el tipo de usuario: " + e);
        }
        return null;
    }

    /**
     *
     * @param rut
     * @return
     */
    
    
    
    
    
    
    
    
    public void actualizarRutaImagen(String rut, String rutaImagen) {
    try (Connection conn = Conexion.conectar()) {
        PreparedStatement ps = conn.prepareStatement("UPDATE usuario SET ruta_imagen = ? WHERE rut = ?");
        ps.setString(1, rutaImagen);
        ps.setString(2, rut);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error al actualizar la ruta de imagen: " + e);
    }
}
    

public String obtenerRutaImagen(String rut) {
    try (Connection conn = Conexion.conectar()) {
        PreparedStatement ps = conn.prepareStatement("SELECT ruta_imagen FROM usuario WHERE rut = ?");
        ps.setString(1, rut);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("ruta_imagen");
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener la ruta de imagen: " + e);
    }
    return null;
}


}




