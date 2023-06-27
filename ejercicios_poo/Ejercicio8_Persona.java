/*
Ejercicio 8:
Crear una clase llamada Persona que siga las siguientes atributos: nombre, edad, DNI, peso y altura. No se debe permitir acceder directamente a estas.

Se implementarán varios constructores:
1. Un constructor por defecto.
2. Un constructor con el nombre, edad y el resto por defecto.
3. Un constructor con todos los atributos como parámetro.

Los métodos que se implementarán son:
1. calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2 en
m)), si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, si
devuelve un número entre 20 y 25 (incluidos), significa que está por debajo de su peso
ideal la función devuelve un 0 y si devuelve un valor mayor que 25 significa que tiene
sobrepeso, la función devuelve un 1.
2. esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
3. toString(): devuelve toda la información del objeto.
4. generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este su número
su letra correspondiente. Este método será invocado cuando se construya el objeto.
Puedes dividir el método para que te sea más fácil. No será visible al exterior.
5. Métodos set de cada parámetro, excepto de DNI.

Crea una aplicación que haga lo siguiente:
1. Pide por teclado el nombre, la edad, peso y altura.
2. Crea objeto de la clase anterior, el primer objeto obtendrá las anteriores variables
pedidas por teclado, el segundo objeto obtendrá todos los anteriores menos el peso y la
altura y el último por defecto, para este último utiliza los métodos set para darle a los
atributos un valor.
3. Para cada objeto, deberá comprobar si está en su peso ideal, tiene sobrepeso o por
debajo de su peso ideal con un mensaje.
4. Indicar para cada objeto si es mayor de edad.
5. Por último, mostrar la información de cada objeto
 */
package ejercicios_poo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class Ejercicio8_Persona {
    private String nombre;
    private int Edad;
    private int Dni;
    
    private int altura;
    private int peso;

    //constructor por defecto
    public Ejercicio8_Persona() {
    }

    public Ejercicio8_Persona(String nombre, int Edad) {
        this.nombre = nombre;
        this.Edad = Edad;
       
    }

    public Ejercicio8_Persona(String nombre, int Edad, int Dni, int altura, int peso) {
        this.nombre = nombre;
        this.Edad = Edad;
        this.Dni = Dni;
        
        this.altura = altura;
        this.peso = peso;
    }
    
    //metodos
    
    public int CalcularMC(Ejercicio8_Persona persona) {
        double imc = persona.peso / Math.pow(persona.altura / 100.0, 2);
        int resultado;
        if (imc < 20) {
            return resultado=-1;
        } else if (imc >= 20 && imc < 25) {
            return resultado=0;
        } else {
            return resultado=1;
        }
    }
    
    public boolean esMayorDeEdad(Ejercicio8_Persona persona){
        boolean esMayor=true;
        if (persona.Edad>18) {
            return esMayor;
        }else{
            esMayor=false;
            return esMayor;
        }
    }
    
    // Método para generar un DNI aleatorio y su letra correspondiente
    private void generaDNI() {
        Random random = new Random();
        this.Dni = random.nextInt(90000000) + 10000000;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", Edad=" + Edad + ", Dni=" + Dni + ", altura=" + altura + ", peso=" + peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public static void main(String[] args) {
        
       
        Scanner teclado= new Scanner(System.in);
        System.out.println("ingrese los valores");
        System.out.println("nombre :");
        String Nombre= teclado.next();
        System.out.println("edad :");
        int edad= teclado.nextInt();
        System.out.println("peso :");
        int peso= teclado.nextInt();
        System.out.println("altura :");
        int altura= teclado.nextInt();
        
        Ejercicio8_Persona persona=new Ejercicio8_Persona(Nombre, edad,0 ,altura, peso);
        
        int resultado=persona.CalcularMC(persona);
        if (resultado==-1) {
            System.out.println("esta debajo del peso ideal");
        }else{
            if (resultado==0) {
                System.out.println("esta en su peso ideal");
            }else{
                if (resultado==1) {
                    System.out.println("esta por encima de su peso ideal");
                }
            }
        }
        
        boolean resultadoEdad=persona.esMayorDeEdad(persona);
        if (resultadoEdad) {
            System.out.println("es mayor de edad");
        }else{
            System.out.println("es menor de edad");
        }
        
        System.out.println("los datos son:" + persona.toString());
        
    }
    
}
