/*
Elaborar un algoritmo que dadas dos arrays concatene las mismasen
una tercera
 */
package ejercicios.parcial.pkg1;

import java.util.Arrays;

/**
 *
 * @author Leandro
 */
public class ejercicio_5 {
    public static void main(String[] args) {
        int array1[]={1,2,3,4,5};
        int array2[]={6,7,8,9,10};
        Concatenar(array1, array2);
        System.out.println("el array total sera: "+ Arrays.toString(Concatenar(array1,array2)));
    }
    public static int[] Concatenar(int array1[],int array2[]){
        int arrayTotal[]= new int[array1.length+array2.length];
        System.arraycopy(array1, 0, arrayTotal, 0, array1.length);
        /***
         * array1: Es el array de origen desde el cual se copiarán los elementos.
        0: Es la posición de inicio en el array1 desde donde se empezará a copiar.
        resultado: Es el array de destino donde se copiarán los elementos.
        0: Es la posición de inicio en el resultado donde se empezarán a copiar los elementos.
        array1.length: Es la cantidad de elementos que se copiarán desde array1 al resultado.
         */
        System.arraycopy(array2, 0, arrayTotal, array1.length, array2.length);
        /***
         * array2: Es el array de origen desde el cual se copiarán los elementos.
        0: Es la posición de inicio en el array2 desde donde se empezará a copiar.
        resultado: Es el array de destino donde se copiarán los elementos.
        array1.length: Es la posición de inicio en el resultado donde se empezarán a copiar los elementos. 
        En este caso, se utiliza array1.length para continuar desde donde terminó la copia anterior.
        array2.length: Es la cantidad de elementos que se copiarán desde array2 al resultado.
         */
        return arrayTotal;
    }
}
