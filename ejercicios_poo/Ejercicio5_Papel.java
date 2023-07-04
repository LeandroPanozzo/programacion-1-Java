/*
Ejercicio 5:
Escribir una clase Ejercicio5_Papel que contenga un atributo texto, un método escribir, que reciba una
cadena de caracteres para agregar al texto, y el método toString() que imprima el contenido del
texto.
Escribir una clase Birome que contenga un atributo cantidad de tinta, y un método escribir, que
reciba un texto y un papel (objeto de la clase Papel) sobre el cual escribir. Cada letra escrita
debe reducir la cantidad de tinta contenida. Cuando la tinta se acabe, debe imprimir un mensaje
de error indicando que la tinta se ha acabado.
 */
package ejercicios_poo;

/**
 *
 * @author Leandro
 */
public class Ejercicio5_Papel {
    private String texto;
   
    //constructor
    public Ejercicio5_Papel(String texto) {
        this.texto = texto;
    }

    
    public Ejercicio5_Papel escribir(String cadena){
        String NuevoTexto= this.texto+cadena;
        
        return new Ejercicio5_Papel(NuevoTexto);
    }

    @Override
    public String toString() {
        return this.texto;
    }
    
    public class Birome{
       private int cantidad_tinta;
       
       //constructor de birome
        public Birome(int cantidad_tinta) {
            this.cantidad_tinta = cantidad_tinta;
        }
       
       public void Escribir( Ejercicio5_Papel papel, String texto){
           if (cantidad_tinta>0) {
               papel.escribir(texto);
               cantidad_tinta-= texto.length();
               if (cantidad_tinta<0) {
                   cantidad_tinta=0;
               }
           }else{
               System.out.println("la tinta se acabo");
           }
       
       }
       
    }
    
    
}
