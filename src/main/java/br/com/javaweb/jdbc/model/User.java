package br.com.javaweb.jdbc.model;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project jdbc-javaweb
 * @created 28/mai/2021 - 15:33
 */
public class User {
  private Long id;
  private String nome;
  private String email;

  public User() {
  }

  public User(Long id, String nome, String email) {
    this.id = id;
    this.nome = nome;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
