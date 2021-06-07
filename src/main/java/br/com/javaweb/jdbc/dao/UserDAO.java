package br.com.javaweb.jdbc.dao;

import br.com.javaweb.jdbc.connection.SingleConnection;
import br.com.javaweb.jdbc.model.BeanUserFone;
import br.com.javaweb.jdbc.model.Telefone;
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
    String sql = "INSERT INTO public.userposjava(nome, email) VALUES (?, ?)";
    try {
      PreparedStatement createUser = connection.prepareStatement(sql);
      createUser.setString(1, user.getNome());
      createUser.setString(2, user.getEmail());
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

  /**
   * Método com a função de atualizar o
   * nome de um usuário buscando por seu id.
   *
   * @param user Objeto user que vai ser alterado no DB
   */
  public void atualizarNameById(User user) {
    String sql = "UPDATE public.userposjava SET  nome=? WHERE id=" + user.getId();

    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, user.getNome());
      statement.execute();
      connection.commit();

    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
      e.printStackTrace();
    }
  }

  /**
   * Método com a função de deletar registro de usuário no DB.
   *
   * @param id Parâmetro de busca para exclusão do DB
   */
  public void deletarById(Long id) {
    try {
      String sql = "DELETE FROM userposjava WHERE id =" + id;
      PreparedStatement statementDel = connection.prepareStatement(sql);
      statementDel.execute();
      connection.commit();
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
  }

  public void salvarTelefone(Telefone telefone){
    try {
      String sql = "INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, telefone.getNumero());
      statement.setString(2, telefone.getTipo());
      statement.setLong(3, telefone.getUsuario());
      statement.execute();
      connection.commit();
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
  }

  public List<BeanUserFone> listaUserFone(Long idUser){
    List<BeanUserFone> beanUserFones = new ArrayList<>();

    String sql = "select nome, numero, email from telefoneuser as fone";
    sql += " inner join userposjava as userp";
    sql += " on fone.usuariopessoa = userp.id";
    sql += " where userp.id = " + idUser;

    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()){
        BeanUserFone beanUserFone = new BeanUserFone(
            resultSet.getString("nome"),
            resultSet.getString("numero"),
            resultSet.getString("email"));
        beanUserFones.add(beanUserFone);
      }
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    return beanUserFones;
  }
}
