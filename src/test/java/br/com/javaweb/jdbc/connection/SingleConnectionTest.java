package br.com.javaweb.jdbc.connection;

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
  public void initBanco() {
    System.out.println(SingleConnection.getConnection());

  }

}