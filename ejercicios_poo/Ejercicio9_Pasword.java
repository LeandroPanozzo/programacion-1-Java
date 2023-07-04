/*
 Ejercicio 9:

Crear una clase llamada Ejercicio9_Pasword que siga las siguientes condiciones:
1. Que tenga los atributos longitud y contraseña . Por defecto, la longitud sera de 8.

Los constructores serán los siguiente:
1. Un constructor por defecto.
2. Un constructor con la longitud. Generar una contraseña aleatoria con esa longitud.

Los métodos que implementa serán:
1. esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas
de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
2. generarPassword(): genera la contraseña del objeto con la longitud que tenga.
3. Método get para contraseña y longitud.
4. Método set para longitud.

Crear una aplicación que haga lo siguiente:
1. Crea un array de Passwords con el tamaño que tu le indiques por teclado.
2. Crea un bucle que cree un objeto para cada posición del array.
3. Indica también por teclado la longitud de los Passwords (antes de bucle).
4. Crea otro array de booleanos donde se almacene si el password del array de Password
es o no fuerte (usa el bucle anterior).
5. Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior). Usa este simple

formato:
contraseña1 valor_booleano1
contraseña2 valor_bololeano2
 */
package ejercicios_poo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class Ejercicio9_Pasword {
    private int longitud;
    private String contraseña;
    
    //constructores

    public Ejercicio9_Pasword() {
        this.longitud = longitud=8;
        GenerarPasword();
    }

    public Ejercicio9_Pasword(int longitud) {
        this.longitud = longitud;
        GenerarPasword();
    }
    
    private void GenerarPasword(){
        String Caracteres= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int index= random.nextInt(Caracteres.length());
            sb.append(Caracteres.charAt(index));
        }
        contraseña=sb.toString();
    }
    
    public boolean EsFuerte(){
        int Mayusculas = 0;
        int numeros=0;
        int Minusculas=0;
        
        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) {
                Mayusculas++;
            }else{
                if(Character.isLowerCase(c)){
                    Minusculas++;
                }else{
                    if (Character.isDigit(c)) {
                        numeros++;
                    }
                }
            }
        }
        return Mayusculas > 2 && Minusculas > 1 && numeros > 5;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese la cantidad de contraseñas a generar");
        int cantidad = teclado.nextInt();
        
        System.out.println("ingrese la longitud de las contraseña");
        int longitud = teclado.nextInt();
        
        Ejercicio9_Pasword pasword[]= new Ejercicio9_Pasword[cantidad];
        boolean esFuerteArray[] = new boolean[cantidad];
        
        for (int i = 0; i < cantidad; i++) {
            pasword[i]= new Ejercicio9_Pasword(longitud);
            esFuerteArray[i]=pasword[i].EsFuerte();
        }
        
        System.out.println("contraseñas generadas");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(pasword[i].getContraseña()+ " "+ esFuerteArray[i]);
        }
    }
}
