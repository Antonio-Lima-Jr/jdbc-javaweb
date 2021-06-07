package br.com.javaweb.jdbc.model;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project jdbc-javaweb
 * @created 06/06/2021 - 23:15
 */
public class Telefone {
  private Long id;
  private String numero;
  private String tipo;
  private Long usuario;

  public Telefone(String numero, String tipo, Long usuario) {
    this.numero = numero;
    this.tipo = tipo;
    this.usuario = usuario;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Long getUsuario() {
    return usuario;
  }

  public void setUsuario(Long usuario) {
    this.usuario = usuario;
  }
}
