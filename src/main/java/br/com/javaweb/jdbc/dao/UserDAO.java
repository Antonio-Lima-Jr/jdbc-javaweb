package br.com.javaweb.jdbc.dao;

import br.com.javaweb.jdbc.connection.SingleConnection;
import br.com.javaweb.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class com o objetivo de salvar, buscar, alterar e deletar Usuários no DB .
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

  /**
   * Método com a função de Salvar usuários no DB.
   *
   * @param user Objeto usuário utilizado para passar para query de INSERÇÃO
   */
  public void salvar(User user) {
    String sql = "INSERT INTO public.userposjava(id, nome, email) VALUES (?, ?, ?)";
    try {
      PreparedStatement createUser = connection.prepareStatement(sql);
      createUser.setLong(1, user.getId());
      createUser.setString(2, user.getNome());
      createUser.setString(3, user.getEmail());
      createUser.execute();
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

  /**
   * Método com a função de retornar todos os usuários.
   *
   * @return Retorna uma lista com todos os usuários do banco
   */
  public List<User> listar() {
    List<User> userList = new ArrayList<>();
    String sql = "SELECT * FROM public.userposjava";

    try {
      PreparedStatement readUser = connection.prepareStatement(sql);
      ResultSet result = readUser.executeQuery();

      while (result.next()) {
        User user = new User(
            result.getLong("id"),
            result.getString("nome"),
            result.getString("email")
        );
        userList.add(user);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userList;
  }

  /**
   * Buscar usuários por id.
   *
   * @param id Parâmetro para a busca no bando
   * @return Retorna um objeto do tipo user que coincidir com o parâmetro passado
   */
  public User buscarById(Long id) {
    User user = null;
    String sql = "SELECT * FROM public.userposjava WHERE id =" + id;

    try {
      PreparedStatement readUser = connection.prepareStatement(sql);
      ResultSet result = readUser.executeQuery();

      while (result.next()) {
        user = new User(
            result.getLong("id"),
            result.getString("nome"),
            result.getString("email")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return user;
  }

}
