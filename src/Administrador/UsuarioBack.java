package Administrador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class UsuarioBack {

    private static final Logger LOGGER = Logger.getLogger(UsuarioBack.class.getName());
    private Connection conn = Conexion.conectar();

    /**
     * Guarda un usuario en la base de datos.
     *
     * @param usuario el usuario a guardar
     * @return true si el usuario fue guardado correctamente, false en caso contrario
     */
    public boolean guardarUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        boolean resultado = false;

        try {
            String sql = "INSERT INTO usuario (rut, nombre, apellido, numero, correo, pass, tipouser) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getRut());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getNumero());
            stmt.setString(5, usuario.getCorreo());
            stmt.setString(6, usuario.getPass());
            stmt.setString(7, usuario.getTipouser());
            int filasAfectadas = stmt.executeUpdate();
            resultado = (filasAfectadas > 0);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al guardar el usuario", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error al cerrar el statement", e);
            }
        }

        return resultado;
    }

    /**
     * Actualiza un usuario en la base de datos.
     *
     * @param usuario el usuario a actualizar
     * @return true si el usuario fue actualizado correctamente, false en caso contrario
     */
    public boolean actualizarUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        boolean resultado = false;

        try {
            String sql = "UPDATE usuario SET nombre = ?, apellido = ?, numero = ?, correo = ?, pass = ?, tipouser = ? WHERE rut = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getNumero());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getPass());
            stmt.setString(6, usuario.getTipouser());
            stmt.setString(7, usuario.getRut());
            
        int filasActualizadas = stmt.executeUpdate();

        if (filasActualizadas > 0) {
            resultado = true;
        }

    } catch (SQLException e) {
        System.out.println("Error al actualizar el usuario: " + e.getMessage());
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
        }
    }

    return resultado;
}
    
    
public List<Usuario> obtenerTodosLosUsuarios() {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Usuario> listaUsuarios = new ArrayList<>();

    try {
        String sql = "SELECT * FROM usuario";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario;
            usuario = new Usuario(
                    rs.getString("rut"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("numero"),
                    rs.getString("correo"),
                    rs.getString("pass"),
                    rs.getString("tipouser")
            );
            listaUsuarios.add(usuario);
        }
    } catch (SQLException e) {
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    return listaUsuarios;
}

public void eliminarUsuario(String rutUsuario) {
    PreparedStatement ps = null;

    try {
        String query = "DELETE FROM usuario WHERE rut = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, rutUsuario);
        int resultado = ps.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + e.getMessage());
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage());
        }
    }
}

    public Usuario obtenerUsuarioPorRut(String rut) {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuario = null;

    try {
        String sql = "SELECT * FROM usuario WHERE rut = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, rut);
        rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario(
                    rs.getString("rut"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("numero"),
                    rs.getString("correo"),
                    rs.getString("pass"),
                    rs.getString("tipouser")
            );
        }
    } catch (SQLException e) {
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    return usuario;
}
    
    /**
     *
     * @param rut
     */
   public void eliminarUsuarioPorRut(String rut) {
    try {
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM usuario WHERE rut = ?");
        pstmt.setString(1, rut);
        pstmt.executeUpdate();
        pstmt.close();
        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + ex.getMessage());
    }
}
   
public void generarExcelDeUsuarios(List<Usuario> listaUsuarios, String rutaArchivo) {
    Workbook libro = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("Usuarios");
    int filaActual = 0;

    // Crear encabezados de columna
    Row filaEncabezados = hoja.createRow(filaActual++);
    filaEncabezados.createCell(0).setCellValue("Rut");
    filaEncabezados.createCell(1).setCellValue("Nombre");
    filaEncabezados.createCell(2).setCellValue("Apellido");
    filaEncabezados.createCell(3).setCellValue("Número");
    filaEncabezados.createCell(4).setCellValue("Correo");
    filaEncabezados.createCell(5).setCellValue("Tipo de usuario");

    // Agregar datos de usuarios
    for (Usuario usuario : listaUsuarios) {
        Row filaUsuario = hoja.createRow(filaActual++);
        filaUsuario.createCell(0).setCellValue(usuario.getRut());
        filaUsuario.createCell(1).setCellValue(usuario.getNombre());
        filaUsuario.createCell(2).setCellValue(usuario.getApellido());
        filaUsuario.createCell(3).setCellValue(usuario.getNumero());
        filaUsuario.createCell(4).setCellValue(usuario.getCorreo());
        filaUsuario.createCell(5).setCellValue(usuario.getTipouser());
    }

    // Escribir el archivo
    try (FileOutputStream archivo = new FileOutputStream(rutaArchivo)) {
        libro.write(archivo);
    } catch (IOException e) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al escribir archivo Excel", e);
    }
}

public List<Usuario> obtenerTodosLosUsuariosBD() {
    String sql = "SELECT * FROM usuario";
    try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = new Usuario(
                rs.getString("rut"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("numero"),
                rs.getString("correo"),
                rs.getString("pass"),
                rs.getString("tipouser")
            );
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Error al obtener todos los usuarios", e);
        return Collections.emptyList();
    }
}

   

}



                            
    

