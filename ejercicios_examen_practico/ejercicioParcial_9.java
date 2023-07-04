/*
 Elaborar un algoritmo que dadas dos arrays permita efectuar la
operación de diferencias entre las mismas en una tercera
 */
package ejercicios.parcial.pkg1;

import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class ejercicioParcial_9 {
    public static void main(String[] args) {
        int array1[] = {1, 2, 3, 4, 5, 6, 7};
        int array2[] = {1, 2, 3, 4, 5, 8, 9, 10};
        int diferencia[] = obtenerDiferencia(array1, array2);
        
        System.out.println("Diferencia entre los dos arrays:");
        for (int num : diferencia) {
            System.out.println(num);
        }
    }
     public static int[] obtenerDiferencia(int[] a, int[] b) {
        ArrayList<Integer> diferenciaList = new ArrayList<>();
        
        // Convertir el primer array a un ArrayList para facilitar la búsqueda
        ArrayList<Integer> arrayListA = new ArrayList<>();
        for (int num : a) {
            arrayListA.add(num);
        }
        
        // Verificar si los elementos del segundo array están en el primer array
        for (int num : b) {
            if (!arrayListA.contains(num)) {
                diferenciaList.add(num);
            }
        }
        
        // Convertir el ArrayList de diferencia a un array
        int[] diferencia = new int[diferenciaList.size()];
        for (int i = 0; i < diferenciaList.size(); i++) {
            diferencia[i] = diferenciaList.get(i);
        }
        
        return diferencia;
    }
}
