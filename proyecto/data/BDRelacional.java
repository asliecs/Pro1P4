/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vsj94
 */
public class BDRelacional {

    Connection cnx;

    /*representa una conexión a una base de datos*/

    public BDRelacional() {
        cnx = this.getConnection();/*permite utilizar la conexión en otras partes*/
    }

    public Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String server = "localhost";
            String port = "3306";
            String user = "root";
            String password = "root";
            String database = "scriptProyecto";

            String URL_conexion = "jdbc:mysql://" + server + ":" + port + "/" + database + "?user=" + user + "&password="
                    + password + "&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            Class.forName(driver).newInstance();
            return DriverManager.getConnection(URL_conexion);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return null;
    }

    public PreparedStatement prepareStatement(String statement) throws SQLException {/*preparar una sentencia SQL para ser ejecutada en una base de datos*/
        return cnx.prepareStatement(statement);/*retorna un objeto PreparedStatement que representa una consulta SQL preparada en una base de datos*/
    }

    public int executeUpdate(PreparedStatement statement) {/*modifica los datos en una base de datos */
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();/* devuelve un entero que indica el número de filas afectadas por la sentencia SQL ejecutada*/
        } catch (SQLException ex) {
            return 0;
        }
    }

    public ResultSet executeQuery(PreparedStatement statement) {/*ejecutar una consulta SQL preparada en una base de datos*/
        try {
            return statement.executeQuery();/*devuelve un objeto ResultSet que permite recorrer los resultados de la consulta fila por fila y acceder a los valores de las columnas */
        } catch (SQLException ex) {
        }
        return null;
    }

    public int executeUpdateWithKeys(String statement) {/*ejecuta una consulta SQL de tipo INSERT, UPDATE o DELETE en una base de datos*/
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stm.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);/*devuelve el número de filas afectadas por la operación y las claves generadas, si las hay*/
        } catch (SQLException ex) {
            return -1;
        }
    }
}
