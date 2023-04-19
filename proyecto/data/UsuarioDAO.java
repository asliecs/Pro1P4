/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.data;

import jafetvs.proyecto.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vsj94
 */
public class UsuarioDAO {

    BDRelacional db;
    boolean resultado = false;

    public UsuarioDAO(BDRelacional db) {
        this.db = db;
    }

    public boolean create(String cedula, String clave, Integer tipo) throws Exception {
        String sql = "insert into Usuario (cedula, clave, tipo) VALUES (?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, cedula);
        stm.setString(2, clave);
        stm.setInt(3, tipo);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Empleado no Existe");
        }
        return resultado;
    }

    public Usuario read(String cedula) throws Exception {          ///
        String sql = "select * from  Usuario e where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Empleado no Existe");
        }
    }

    public boolean update(String cedula, String clave, Integer tipo) throws Exception {
        String sql = "update Usuario set clave=?, tipo=? where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, clave);
        stm.setInt(2, tipo);
        stm.setString(3, cedula);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Empleado no Existe");
        }
        return resultado;
    }

    public boolean delete(String cedula) throws Exception {
        String sql = "delete from Usuario where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, cedula);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Empleado no Existe");
        }
        return resultado;
    }

    public Usuario from(ResultSet rs, String alias) {   ///
        try {
            Usuario e = new Usuario();
            e.setCedula(rs.getString(alias + ".cedula"));
            e.setClave(rs.getString(alias + ".clave"));
            e.setTipo(rs.getInt(alias + ".tipo"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}
