/*
 Elaborar un algoritmo que dadas dos arrays haga la intersección de
las mismas en una tercera
 */
package ejercicios.parcial.pkg1;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Leandro
 */
public class ejercicioParcial_7 {
    public static void main(String[] args) {
        int array1[]={1,2,3,4,5,6,7};
        int array2[]={1,2,3,4,5,8,9,10};
        int intersec[]=Interseccion(array1, array2);
        for (int num : intersec) {
            System.out.println(num+" ");
        }
    }
    
    public static int [] Interseccion(int a[], int b[]){
        HashSet<Integer> set= new HashSet<>(); //hashset no permite elementos duplicados
        ArrayList<Integer> InterseccionList= new ArrayList<>(); //en Interseccion list añadiremos los valores de las arrays
        
        //agregar elementos del primer arraylist al hashset
        for (Integer num : a) {
            set.add(num);  //añadimos los numeros del array1 a InterseccionList 
        }
        
        //verificacion si los elementos del segundo array estan en el hashset
        for (Integer num : b) {
            if (set.contains(num)) { //contains verifica que el elemento del array ya no este en InterseccionList
                InterseccionList.add(num); //si no esta lo agregamos
            }
        }
        
        //convertir la arrayList en un array
        int interserccion[]=new int[InterseccionList.size()]; //creo una nueva array del tamaño de InterseccionList
        for (int i = 0; i < InterseccionList.size(); i++) {
            interserccion[i]=InterseccionList.get(i);  //ingreso cada valor de InterseccionList a Interseccion
        }
        return interserccion;
    }
}
