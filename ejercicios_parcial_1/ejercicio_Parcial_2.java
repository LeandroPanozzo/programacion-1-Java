/*
Elaborar un algoritmo para eliminar un nombre dado en un arreglo de
50 Nombres de 30 caracteres. 
 */
package ejercicios.parcial.pkg1;

import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class ejercicio_Parcial_2 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String array[]= new String[50];
        
        for (int i = 0; i < array.length; i++) {
            boolean NomValido=false;
            while (NomValido==false) {                
                System.out.println("ingrese los valores en la posicion: "+ i);
                array[i]=teclado.nextLine();
            
                if (array[i].length()<=30) {
                    
                    NomValido=true;
                    
                }else{
                System.out.println("El nombre no puede tener más de 30 caracteres. Inténtelo de nuevo.");
                }
            }
        }
        
        for (String ValorArray : array) {
            System.out.println("el valor: "+ValorArray);
        }
        
        System.out.println("ingrese la posicion que desea eliminar");
        String posicion=teclado.nextLine();
        
        String NuevoArray[]=new String[49];
        
        
        int j=0;
        for (int i = 0; i < 50; i++) {
            if (!array[i].equals(posicion)) {
                NuevoArray[j]=array[i];
                j++;
            }
        }
        
        
        
        for (int i = 0; i < NuevoArray.length; i++) {
            System.out.println("valor en la posicion: "+i+" es "+NuevoArray[i]);
        }
        
    }
    
}
