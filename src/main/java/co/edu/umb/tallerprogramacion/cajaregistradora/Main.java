/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.tallerprogramacion.cajaregistradora;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dev_manuel
 */
public class Main {

  private ArrayList<Producto> listaProductos;

  //Hilo caja registradora
  private HiloRegistrador registradora;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      new Main().iniciar();
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void iniciar() throws InterruptedException {
    System.out.println("Bienvenido al ejercicio tres de la guia 4 de taller de programación");
    System.out.println("Ejercicio: Caja registradora con Threads");
    listaProductos = new ArrayList<>();

    // Creamos el hilo de la registradora
    registradora = new HiloRegistrador("Cajera Uno");

    // Iniciar el subproceso de la registradora
    registradora.start();

    // variable de control para el menu
    var opcion = -1;
    while (opcion != 0) {
      //Llamar al menu
      opcion = menu();
      // Evaluar el valor de opcion.
      switch (opcion) {
        case 0 -> System.out.println("Gracias por usar este poderosisimo software!");
        case 1 -> registrarProductos();
        case 2 -> registrarCompra();
        case 3 -> System.out.println(registradora.getListaCuentas().get(registradora.getListaCuentas().size() - 1));
        default -> System.out.println("Debe digitar una opción valida");
      }
    }
  }

  //Menu
  private int menu() {
    var menu = """
        1. Registrar productos.
        2. Registrar compra.
        3. Imprimir factura.
        0. Salir.
        """;
    System.out.println(menu);
    return SuperTeclado.leerNumero();
  }

  private int menuRegistrar() {
    var menu = """
        1. Agregar producto.
        2. Listar productos.
        0. Terminar registro.
        """;
    System.out.println(menu);
    return SuperTeclado.leerNumero();
  }

  private void registrarProductos() {
    var opcionRegistrar = -1;
    while (opcionRegistrar != 0) {
      opcionRegistrar = menuRegistrar();
      switch (opcionRegistrar) {
        case 0 -> System.out.println("Registro de productos terminado");
        case 1 -> agregarProducto();
        case 2 -> listarMisProductos();
        default -> System.out.println("Debe digitar una opción valida");
      }
    }
  }

  private void agregarProducto() {
    // Registrar un nuevo producto para comprar
    var producto = new Producto();
    System.out.println("Digite el nombre del producto: ");
    producto.setNombre(SuperTeclado.leerTexto());
    System.out.println("Digite el precio del producto: ");
    producto.setPrecio(SuperTeclado.leerNumero());

    // Agregar el producto a la lista
    listaProductos.add(producto);

    System.out.println("Desea agregar otro producto a la lista (SI -> 1; NO -> Cualquier tecla)");
    var otro = SuperTeclado.leerNumero();
    if (otro == 1) {
      agregarProducto();
    }
  }

  private void listarMisProductos() {
    listaProductos.forEach((producto) -> System.out.println(producto));
  }

  private void registrarCompra() throws InterruptedException {
    System.out.println("La registradora: " + registradora.getName() + " esta procesando su orden");

    // Poner todos los productos de mi carro del mercado a la banda transportadora de la cajera
    registradora.cargarEnBanda(this.listaProductos);

    // Limpiar el carro del mercado
    System.out.println("Por favor espere hasta completar su orden");

  }

}
