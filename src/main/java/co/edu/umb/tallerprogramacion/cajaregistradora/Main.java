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
 *
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
    registradora = new HiloRegistrador("Otra vieja", listaProductos);

    // Iniciar el subproceso de la registradora
    registradora.start();

    // variable de control para el menu
    int opcion = -1;
    while (opcion != 0) {
      //Llamar al menu
      opcion = menu();
      // Evaluar el valor de opcion.
      switch (opcion) {
        case 0:
          System.out.println("Gracias por usar este poderosisimo software!");
          break;
        case 1:
          registrarProductos();
          break;
        case 2:
          registrarCompra();
          break;
        default:
          System.out.println("Debe digitar una opción valida");
          break;
      }
    }
  }

  //Menu
  private int menu() {
    String menu = "1. Registrar productos.\n"
      + "2. Registrar compra.\n"
      + "0. Salir.";
    System.out.println(menu);
    return SuperTeclado.leerNumero();

  }

  private int menuRegistrar() {
    String menu = "1. Agregar producto.\n"
      + "2. Listar productos.\n"
      + "0. Terminar registro.";
    System.out.println(menu);
    return SuperTeclado.leerNumero();
  }

  private void registrarProductos() {
    int opcionRegistrar = -1;
    while (opcionRegistrar != 0) {
      opcionRegistrar = menuRegistrar();
      switch (opcionRegistrar) {
        case 0:
          System.out.println("Registro de productos terminado");
          break;
        case 1:
          agregarProducto();
          break;
        case 2:
          listarMisProductos();
          break;
        default:
          System.out.println("Debe digitar una opción valida");
          break;
      }
    }
  }

  private void agregarProducto() {
    // Registrar un nuevo producto para comprar
    Producto producto = new Producto();
    System.out.println("Digite el nombre del producto: ");
    producto.setNombre(SuperTeclado.leerTexto());
    System.out.println("Digite el precio del producto: ");
    producto.setPrecio(SuperTeclado.leerNumero());

    // Agregar el producto a la lista
    listaProductos.add(producto);

    System.out.println("Desea agregar otro producto a la lista (SI -> 1; NO -> Cualquier tecla)");
    int otro = SuperTeclado.leerNumero();
    if (otro == 1) {
      agregarProducto();
    }
  }

  private void listarMisProductos() {
    listaProductos.forEach((producto) -> System.out.println(producto));
  }

  private void registrarCompra() throws InterruptedException {
    /*
      Validacion mediante ciclo while, para que el hilo registrador solo inicie 
      el procesamiento de nuestra orden, hasta que termine la anterior.
     */
//    while (!registradora.getListaProductos().isEmpty()) {
//      System.out.println(
//        registradora.getName() + " aun debe procesar "
//        + registradora.getListaProductos().size()
//      );
//    }
    Thread.sleep(1000);
    System.out.println("La registradora: " + registradora.getName() + " esta procesando su orden");

    // Poner todos los productos de mi carro del mercado a la banda transportadora de la cajera
    registradora.cargarEnBanda();

    // Limpiar el carro del mercado
    System.out.println("Por favor espere hasta completar su orden");
    Thread.sleep(1000);
  }

}
