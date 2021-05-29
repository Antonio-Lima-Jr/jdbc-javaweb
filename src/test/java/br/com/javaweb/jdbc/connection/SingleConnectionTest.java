package br.com.javaweb.jdbc.connection;

import br.com.javaweb.jdbc.dao.UserDAO;
import br.com.javaweb.jdbc.model.User;
import org.junit.jupiter.api.Test;

/**
 * Class Description.
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

}