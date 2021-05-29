package br.com.javaweb.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta classe tem o objetivo de retornar uma conexão com o DB.
 *
 * @author Antônio Lima Jr
 * @project jdbc-javaweb
 * @created 28/mai/2021 - 13:48
 */
public class SingleConnection {
  private static final String URL = "jdbc:postgresql://localhost:5432/posjava";
  private static final String PASSWORD = "root";
  private static final String USER = "root";
  private static Connection connection = null;

  static {
    conectar();
  }

  public SingleConnection() {
    conectar();
  }

  private static void conectar() {
    try {
      if (connection == null) {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return connection;
  }
}
