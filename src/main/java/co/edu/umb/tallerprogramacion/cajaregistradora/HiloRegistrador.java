/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.tallerprogramacion.cajaregistradora;

import java.util.ArrayList;

/**
 * @author dev_manuel
 */
public class HiloRegistrador extends Thread {

  private final ArrayList<Producto> listaProductos;
  private final ArrayList<Cuenta> listaCuentas;

  private int procesar;

  public HiloRegistrador(String name) {
    super(name);
    procesar = 1;
    this.listaProductos = new ArrayList<>();
    this.listaCuentas = new ArrayList<>();
  }

  @Override
  public void run() {
    try {
      procesarCompra();
    } catch (InterruptedException e) {
      e.printStackTrace(System.err);
    }
  }

  private void procesarCompra() throws InterruptedException {
    while (true) {
      Thread.sleep(1);
      if (procesar <= 0) {
        continue;
      }
      // Crear una nueva cuenta de la caja registradora
      var cuenta = new Cuenta();
      var resumen = new StringBuilder();
      // Iterar los productos para generar un calculo de la compra
      listaProductos.forEach((producto) -> {
        cuenta.setCosto(cuenta.getCosto() + producto.getPrecio());
        resumen.append(producto.getNombre()).append(",");
      });
      cuenta.setProductos(resumen.toString());

      // Agregar la cuenta al informe de ventas de la registradora.
      listaCuentas.add(cuenta);

      // Vaciar la lista de productos
      this.listaProductos.clear();
      procesar = 0;
    }
  }

  /**
   *
   */
  public void cargarEnBanda(ArrayList<Producto> listaProductos) {
    if (!listaProductos.isEmpty()) {
      this.listaProductos.addAll(listaProductos);
      procesar++;
    }
  }

  /**
   * @return the listaProductos
   */
  public ArrayList<Producto> getListaProductos() {
    return listaProductos;
  }

  public ArrayList<Cuenta> getListaCuentas() {
    return listaCuentas;
  }
}
