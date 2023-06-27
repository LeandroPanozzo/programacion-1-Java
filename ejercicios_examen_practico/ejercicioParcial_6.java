/*
 Elaborar un algoritmo que dadas dos arrays haga la unión de las
mismas en una tercera.
 */
package ejercicios.parcial.pkg1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Leandro
 */
public class ejercicioParcial_6 {
    public static void main(String[] args) {
        int array1[]={1,2,3,4,5};
        int array2[]={6,7,8,9,10};
        
        System.out.println(Arrays.toString(union(array1, array2)));
        
    }
    
    public static int [] union(int array1[], int array2[]){
        Set<Integer>SetUnion=new HashSet<>();
        for (int numeros : array1) {
            SetUnion.add(numeros);
        }
        for (int numeros : array2) {
            SetUnion.add(numeros);
        }
        
        int arrayTot[]=new int[SetUnion.size()];
        int index=0;
        for (Integer numeros : SetUnion) {
            arrayTot[index++]=numeros;
        }
        
        return arrayTot;
    }
}
