/*
 Elaborar un algoritmo para cargar un arreglo de 50 Nombres de 30
caracteres. 
 */
package ejercicios.parcial.pkg1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class EjerciciosParcial1 {

    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
    String[] names = new String[50];
    
    for (int i = 0; i < names.length; i++) {
      boolean validName = false;
      while (!validName) {
        System.out.print("Ingrese el nombre " + (i + 1) + ": ");
        String name = input.nextLine();
        if (name.length() <= 30) {
          names[i] = name;
          validName = true;
        } else {
          System.out.println("El nombre no puede tener más de 30 caracteres. Inténtelo de nuevo.");
        }
      }
    }
    Arrays.sort(names);
    System.out.println("Nombres ingresados:");
    for (String name : names) {
      System.out.println(name);
    }
  
        
        
    }
    
}
