package br.com.javaweb.jdbc.model;

/**
 * Destinada a armazenar o nome numero e email pegos no banco.
 *
 * @author Antônio Lima Jr
 * @project jdbc-javaweb
 * @created 07/06/2021 - 00:07
 */
public class BeanUserFone {
  private String nome;
  private String numero;
  private String email;

  public BeanUserFone() {}

  public BeanUserFone(String nome, String numero, String email) {
    this.nome = nome;
    this.numero = numero;
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "BeanUserFone{" +
        "nome='" + nome + '\'' +
        ", numero='" + numero + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
