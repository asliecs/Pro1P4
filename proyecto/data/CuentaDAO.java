/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.data;

import jafetvs.proyecto.logic.Cliente;
import jafetvs.proyecto.logic.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vsj94
 */
public class CuentaDAO {

    BDRelacional db;
    boolean resultado = false;

    public CuentaDAO(BDRelacional db) {
        this.db = db;
    }

    public boolean create(String numero, double saldo, String cliente) throws Exception {
        String sql = "insert into Cuenta (numero, saldo, cliente) VALUES (?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, numero);
        stm.setDouble(2, saldo);
        stm.setObject(3, cliente);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Cuenta ya existe");
        }
        return resultado;
    }

    public Cuenta read(String numero) throws Exception { ///
        String sql = "select * from Cuenta e inner join Cliente c on e.cliente=c.cedula where e.numero=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, numero);
        ResultSet rs = db.executeQuery(stm);
        ClienteDAO clienteDao = new ClienteDAO(db);
        Cuenta c;
        if (rs.next()) {
            c = from(rs, "e");
            c.setCliente(clienteDao.from(rs, "c"));
            return c;
        } else {
            throw new Exception("Cuenta no Existe");
        }
    }

    public void update(Cuenta e) throws Exception {                  ///
        String sql = "update Cuenta set saldo=? where numero=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setDouble(1, e.getSaldo());
        stm.setString(2, e.getNumero());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cuenta no existe");
        }
    }

    public boolean delete(String numero) throws Exception {
        String sql = "delete from Cuenta where numero=?";
        PreparedStatement stm = db.prepareStatement(sql);/*ejecuta las consulta SQL*/
        stm.setString(1, numero);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {/*comprobar si devuelve alguna fila*/
            resultado = true;
        } else {
            resultado = false;
            throw new Exception("Cliente no Existe");
        }
        return resultado;
    }

    public List<Cuenta> findByCliente(Cliente cliente) {    ////
        List<Cuenta> resultados = new ArrayList<>();
        try {
            String sql = "select * from Cuenta e where e.cliente=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cliente.getCedula());
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultados.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultados;
    }

    private Cuenta from(ResultSet rs, String alias) { ///
        try {
            Cuenta e = new Cuenta();
            e.setNumero(rs.getString(alias + ".numero"));
            e.setSaldo(rs.getDouble(alias + ".saldo"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}
