/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.tallerprogramacion.cajaregistradora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dev_manuel
 */
public final class SuperTeclado {

  public static String leerTexto() {
    try {
      return new BufferedReader(
        new InputStreamReader(System.in)
      ).readLine().trim();
    } catch (IOException e) {
      System.out.println("Digite nuevamente el valor");
      return leerTexto();
    }
  }

  public static char leerCaracter() {
    try {
      return new BufferedReader(
        new InputStreamReader(System.in)
      ).readLine().trim().charAt(0);
    } catch (IOException e) {
      System.out.println("Digite nuevamente el valor");
      return leerCaracter();
    }
  }
  
  public static int leerNumero() {
    try {
      return Integer.parseInt(
        new BufferedReader(
          new InputStreamReader(System.in)
        ).readLine().trim()
      );
    } catch (IOException | NumberFormatException e) {
      System.out.println("Digite nuevamente el valor");
      return leerNumero();
    }
  }
  
  public static long leerNumeroLargo() {
    try {
      return Long.parseLong(
        new BufferedReader(
          new InputStreamReader(System.in)
        ).readLine().trim()
      );
    } catch (IOException | NumberFormatException e) {
      System.out.println("Digite nuevamente el valor");
      return leerNumeroLargo();
    }
  }

}
