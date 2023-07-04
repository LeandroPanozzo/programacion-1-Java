/*
 creamos la clase Ejercicio11_Electrodomesticos con las siguientes caracteristicas
*sus atrubutos son: precio base, color, consumo energetico(letras entre A y F) y peso. indica que se podran heredar
*por defecto el color sera blanco, consumo energetico sera F, el precio base de $ 100 y el peso de 5kg, usar constantes para ello
*los colores disponibles son: blanco,negro, azul y gris. sin importar el nombre en mayusc o minusculas
*los constructores implementados seran:
-constructor defecto
-const con precio y peso. el resto por defecto
-constructor con todos los atributos

los metodos que se implementaran:
*metodo get para todos los atributos
*comprobarConsumoEnergetico(char letra) comprueba que la letra es correcta y si no usa la que es por defecto. se la invoca al crear el objeto y no sera visible
*comprobarColor(String color) comprueba el color y sino usa el que es por defecto se invoca al crear el objecto y no sera visible 
*precio final() segun el consumo energetico y precio aumentara su precio partiendo con F aumentara un 10% y cada categoria un 10% mas 
 */
package ejercicios_poo;

import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class Ejercicio11_Electrodomesticos {
    private int precio_base;
    private String color;
    private char consumo_energetico;
    private int peso;

    //constructires
    public Ejercicio11_Electrodomesticos() {
        this.color="blanco";
        this.peso=5;
        this.consumo_energetico='F';
    }

    public Ejercicio11_Electrodomesticos(int precio_base, int peso) {
        this.precio_base = precio_base;
        this.peso = peso;
        this.color="blanco";
        this.consumo_energetico='F';
    }

    public Ejercicio11_Electrodomesticos(int precio_base, String color, char consumo_energetisco, int peso) {
        this.precio_base = precio_base;
        this.color = color;
        this.consumo_energetico = consumo_energetisco;
        this.peso = peso;
    }

    //getters
    public int getPrecio_base() {
        return precio_base;
    }

    public String getColor() {
        return color;
    }

    public char getConsumo_energetico() {
        return consumo_energetico;
    }

    public int getPeso() {
        return peso;
    }
    
    public void comprobarConsumoEnergetico(char letra){
    
        String letrasValidas = "ABCDEFabcdef";
        
        //verificar la letra 
        if (letrasValidas.contains(String.valueOf(letra))) {
            this.consumo_energetico=letra;
        }else{
            this.consumo_energetico='F';
        }
    }
    
    public void comprobarColor(String color){
        String ColoresValidos[] = {"azul","blanco","gris","negro"};
        
        boolean colorValido = false;
        
        for (String ColoresValido : ColoresValidos) {
            if (color.equalsIgnoreCase(ColoresValido)) {
                colorValido=true;
                break;
            }
        }
         // Establecer el color por defecto si no es válido
         if (colorValido) {
            this.color=color;
        }else{
            this.color="blanco";
         }
    }
    
    public void precio_final(){
        double aumento =1.0;
        switch(Character.toUpperCase(consumo_energetico)){
            case 'F':
                aumento+=0.1;
                break;
            case 'E':
                aumento+=0.2;
                break;
            case 'D':
                aumento+=0.3;
                break;
            case 'C':
                aumento+=0.4;
                break;
            case 'B':
                aumento+=0.5;
                break;
            case 'A':
                aumento+=0.6;
                break;

        }
       
        
        
        //precio dependiendo del peso
        
        double aumentoPeso=1.0;
        
        if (peso<=5) {
            aumentoPeso+=0.1;
            
        }else{
            if (peso>5&&peso<15) {
                aumentoPeso+=0.2;
            }else{
                if (peso>15&&peso<30) {
                    aumentoPeso+=0.3;
                }
            }
        }
        //calculo el precio final
        double aumentoFinal=aumento+aumentoPeso;
        double precioFinal=precio_base*aumentoFinal;
        
        this.precio_base=(int)Math.round(precioFinal);
    }
    
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        
        // Solicitar al usuario que ingrese los valores del electrodoméstico
        System.out.println("ingrese los valor del electrodomestico");
        int PrecioBase=teclado.nextInt();
        
        System.out.println("ingrese el consumo energetico");
        char Consumo=teclado.next().charAt(0);
        
        System.out.println("ingrese el color del electrodomestico");
        String Color=teclado.next();
        
        System.out.println("ingrese el peso del electrodomestico");
        int Peso=teclado.nextInt();
        
        // Crear un objeto Electrodomestico con los valores ingresados por el usuario
        
        Ejercicio11_Electrodomesticos electrodomesticos=new Ejercicio11_Electrodomesticos(PrecioBase, Color, Consumo, Peso);
        
        // Calcular y mostrar el precio final del electrodoméstico
        electrodomesticos.precio_final();
        System.out.println("el precio final del electrodomestico sera: "+ electrodomesticos.getPrecio_base());
    }
}
