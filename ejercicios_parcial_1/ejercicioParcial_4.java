/*
 Elaborar un algoritmo para cargar 50 Nombres en una array,
manteniendo en la misma un orden alfabético
 */
package ejercicios.parcial.pkg1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class ejercicioParcial_4 {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        String array[]= new String[5];
        boolean cumple=false;
        
        System.out.println("ingrese los 50 nombres");
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("ingrese el valor en la posicion, "+ i);
            array[i]=teclado.nextLine();
            
            if(array[i].length()<=30){
            
                cumple=true;
            }else{
                System.out.println("el nombre no puede tener mas de 30 caracteres intentelo otra vez");
            }
        }
        
        Arrays.sort(array);
        
        System.out.println("ingrese la psicion que desea eliminar");
        String posicion= teclado.nextLine();
        
        String Nuevoarray[]=new String[49];
        int j=0;
        
        for (String array1 : array) {
            if (!array1.equals(posicion)) {
                Nuevoarray[j] = array1;
                j++;
            }
        }
        
        System.out.println("los nombres en forma alfabetica son");
        
        for (String nombres : array) {
            System.out.println(nombres);
        }
    }
}
