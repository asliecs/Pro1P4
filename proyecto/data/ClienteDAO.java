/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.data;

import jafetvs.proyecto.logic.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vsj94
 */
public class ClienteDAO {

    BDRelacional db;
    boolean resultado = false;

    public ClienteDAO(BDRelacional db) {
        this.db = db;
    }

    public boolean create(String cedula, String nombre, String usuario) throws Exception {
        String sql = "insert into Cliente (cedula, nombre, usuario) VALUES (?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, cedula);
        stm.setString(2, nombre);
        stm.setObject(3, usuario);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Cliente ya existe");
        }
        return resultado;
    }

    public Cliente read(String cedula) throws Exception {  ///
        String sql = "select * from Cliente e inner join Usuario u on e.usuario=u.cedula where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        UsuarioDAO usuarioDao = new UsuarioDAO(db);
        Cliente c;
        if (rs.next()) {
            c = from(rs, "e");
            c.setUsuario(usuarioDao.from(rs, "u"));
            return c;
        } else {
            throw new Exception("Empleado no Existe");
        }
    }

    public void update(Cliente e) throws Exception {  ///
        String sql = "update Cliente set nombre=? where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        stm.setString(2, e.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }
    }

    public boolean delete(String cedula) throws Exception {
        String sql = "delete from Cliente where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, cedula);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Cliente no Existe");
        }
        return resultado;
    }

    public Cliente from(ResultSet rs, String alias) { ///
        try {
            Cliente e = new Cliente();
            e.setCedula(rs.getString(alias + ".cedula"));
            e.setNombre(rs.getString(alias + ".nombre"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }

}
