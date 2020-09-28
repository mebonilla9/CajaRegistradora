/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.tallerprogramacion.cajaregistradora;

import java.util.ArrayList;

/**
 *
 * @author dev_manuel
 */
public class HiloRegistrador extends Thread {

  private final ArrayList<Producto> listaProductos;
  private final ArrayList<Cuenta> listaCuentas;

  private int procesar;

  public HiloRegistrador(String name, ArrayList<Producto> listaProductos) {
    super(name);
    procesar = 1;
    this.listaProductos = listaProductos;
    this.listaCuentas = new ArrayList<>();
  }

  @Override
  public void run() {
    while (true) {
      if (procesar > 0) {
        // Crear una nueva cuenta de la caja registradora
        Cuenta cuenta = new Cuenta();

        // Iterar los productos para generar un calculo de la compra
        this.getListaProductos().forEach((producto) -> {
          cuenta.setCosto(cuenta.getCosto() + producto.getPrecio());
          cuenta.getProductos().append(producto.getNombre()).append(",\n");
        });

        // Imprimir el mensaje de la cuenta
        System.out.println(cuenta);

        // Agregar la cuenta al informe de ventas de la registradora.
        listaCuentas.add(cuenta);

        // Vaciar la lista de productos
        getListaProductos().clear();
        procesar = 0;
      }
    }
  }

  /**
   */
  public void cargarEnBanda() {
    procesar++;
  }

  /**
   * @return the listaProductos
   */
  public ArrayList<Producto> getListaProductos() {
    return listaProductos;
  }

}
