/*
 Eleborar un algoritmo para ordenar alfabéticamente el arreglo del
ejercicio 1
 */
package ejercicios.parcial.pkg1;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class EjercicioParcial_3 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String Array[]=new String[50];
        
        System.out.println("ingrese los nombres");
        for (int i = 0; i < Array.length; i++) {
            boolean NomValido=false;
            while (!NomValido) {
                System.out.println("posicion: "+i);
                Array[i]=teclado.nextLine();
                if (Array[i].length()<=30) {
                    NomValido=true;
                }else{
                    System.out.println("El nombre no puede tener más de 30 caracteres. Inténtelo de nuevo.");
                }
            }
            
        }
        System.out.println("los valores seran: ");
        for (String ValoresArray : Array) {
            System.out.println(ValoresArray);
        }
        
        Arrays.sort(Array); 
        
        System.out.println("ahora la lista en orden alfabetico sera: ");
        for (String ValoresArray : Array) {
            System.out.println(ValoresArray);
        }
        
    }
}
