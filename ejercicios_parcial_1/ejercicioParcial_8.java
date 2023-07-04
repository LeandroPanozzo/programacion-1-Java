/*
 Elaborar un algoritmo que dadas dos array ordenadas haga la fusión
de las mismas en una tercera
 */
package ejercicios.parcial.pkg1;

import java.util.Arrays;

/**
 *
 * @author Leandro
 */
public class ejercicioParcial_8 {
    public static void main(String[] args) {
        int array1[]={1,3,5,7};
        int array2[]={2,4,6,8};
        
        System.out.println(Arrays.toString(fusion(array1, array2)));
    }
    
    public static int [] fusion(int a[], int b[]){
    int fusi[]=new int [a.length+b.length];
    int i=0;
    int j=0;
    int k=0;
    
        while (i<a.length&&j<b.length) {            
            if (a[i]<=b[j]) {
                fusi[k++]=a[i++];
            }else{
                fusi[k++]=b[j++];
            }
        }
        
        //añado los elementos restantes del primer array
        while (i<a.length) {            
            fusi[k++]=a[i++];
        }
        while (j<b.length) {            
            fusi[k++]=b[j++];
        }
        return fusi;
    } 
}
