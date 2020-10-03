/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.tallerprogramacion.cajaregistradora;

/**
 * @author dev_manuel
 */
public class Cuenta {

  private int costo;
  private String productos;

  public Cuenta() {
    costo = 0;
    productos = "";
  }

  /**
   * @return the costo
   */
  public int getCosto() {
    return costo;
  }

  /**
   * @param costo the costo to set
   */
  public void setCosto(int costo) {
    this.costo = costo;
  }

  /**
   * @return the productos
   */
  public String getProductos() {
    return productos;
  }

  /**
   * @param productos the productos to set
   */
  public void setProductos(String productos) {
    this.productos = productos;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder(this.productos.substring(0, this.productos.length()-1));
    sb.append("\nValor compra: ").append(this.costo);
    return sb.toString();
  }

}
