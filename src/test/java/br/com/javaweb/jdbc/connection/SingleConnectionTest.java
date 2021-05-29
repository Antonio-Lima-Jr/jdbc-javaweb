package br.com.javaweb.jdbc.connection;

import br.com.javaweb.jdbc.dao.UserDAO;
import br.com.javaweb.jdbc.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Classe de tests simples sem asserts por enquanto,
 * apenas para verificar funcionalidade.
 *
 * @author Antônio Lima Jr
 * @project jdbc-javaweb
 * @created 28/mai/2021 - 14:01
 */
class SingleConnectionTest {

  @Test
  public void saveUser() {
    User user = new User(6L, "João Pereira", "emailjoao@email.com");
    UserDAO userDAO = new UserDAO();

    userDAO.salvar(user);
  }

  @Test
  public void listarUsers() {
    List<User> userList = new UserDAO().listar();
    userList.forEach(System.out::println);
  }

  @Test
  public void buscarById() {
    User user = new UserDAO().buscarById(3L);
    System.out.println(user);
  }

  @Test
  public void atualizarNomeUser() {
    UserDAO userDAO = new UserDAO();
    User user = userDAO.buscarById(3L);
    System.out.println(user);
    user.setNome("Joãozinho");

    userDAO.atualizarNameById(user);
    System.out.println(user);
  }
}