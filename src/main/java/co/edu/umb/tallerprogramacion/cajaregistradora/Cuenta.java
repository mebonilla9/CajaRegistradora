/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.tallerprogramacion.cajaregistradora;

/**
 *
 * @author dev_manuel
 */
public class Cuenta {

  private int costo;
  private StringBuilder productos;

  public Cuenta() {
    costo = 0;
    productos = new StringBuilder();
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
  public StringBuilder getProductos() {
    return productos;
  }

  /**
   * @param productos the productos to set
   */
  public void setProductos(StringBuilder productos) {
    this.productos = productos;
  }

  @Override
  public String toString() {
    this.productos.append("\nValor compra: ").append(this.costo);
    return this.productos.toString();
  }

}
