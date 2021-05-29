package br.com.javaweb.jdbc.dao;

import br.com.javaweb.jdbc.connection.SingleConnection;
import br.com.javaweb.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project jdbc-javaweb
 * @created 28/mai/2021 - 15:36
 */
public class UserDAO {

  private final Connection connection;

  public UserDAO() {
    this.connection = SingleConnection.getConnection();
  }

  public void salvar(User user) {
    String sql = "INSERT INTO public.userposjava(id, nome, email) VALUES (?, ?, ?)";
    try {
      PreparedStatement insert = connection.prepareStatement(sql);
      insert.setLong(1, user.getId());
      insert.setString(2, user.getNome());
      insert.setString(3, user.getEmail());
      insert.execute();
      connection.commit();
    } catch (SQLException e) {
      try {
        connection.rollback(); // reverte a operação
      } catch (SQLException f) {
        f.printStackTrace();
      }
      e.printStackTrace();
    }
  }

}
