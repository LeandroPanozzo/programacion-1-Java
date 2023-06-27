/*
 Ejercicio 4:
Crear una clase Ejercicio4_Vector, que en su constructor reciba una lista de elementos que serán sus
coordenadas. En el método toString() se imprime su contenido con el formato [x,y,z].
1. Crear un método que reciba un número y devuelva un nuevo vector (objeto de la clase
Vector), con los elementos multiplicados por ese número.
2. Crear un método sumar que recibe otro vector, verifica si tienen la misma cantidad de
elementos y devuelve un nuevo vector con la suma de ambos. Si no tienen la misma
cantidad de elementos entonces imprimir un mensaje de error y la función debe retornar
el vector que se pasó como parámetro.
 */
package ejercicios_poo;

/**
 *
 * @author Leandro
 */
public class Ejercicio4_Vector {
    
    private int x;
    private int y;
    private int z;

    public Ejercicio4_Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[x = "+ x+ ",y = "+y+",z = "+z+ "]";
    }
    
    public Ejercicio4_Vector  MultiplicarVector(Ejercicio4_Vector otroVector){
        int nuevoX= (this.x*otroVector.x);
        int nuevoY= (this.y*otroVector.y);
        int nuevoZ= (this.z*otroVector.z);
        return new Ejercicio4_Vector(nuevoX, nuevoY, nuevoZ);
    }
    
    private boolean ValidadCantidadElementos(Ejercicio4_Vector otroVector){
        return this.x==otroVector.x&& this.y==otroVector.y&&this.z==otroVector.z;
    }
    public Ejercicio4_Vector SumaVector(Ejercicio4_Vector otroVector){
        if (this.ValidadCantidadElementos(otroVector)) {
            int nuevoX= (this.x+otroVector.x);
            int nuevoY= (this.y+otroVector.y);
            int nuevoZ= (this.z+otroVector.z);
            return new Ejercicio4_Vector(nuevoX, nuevoY, nuevoZ);
        }else{
            System.out.println("Error: Los vectores no tienen la misma cantidad de elementos.");
            return otroVector;
        }
        
        
    }
    
    public static void main(String[] args) {
        Ejercicio4_Vector vector1= new Ejercicio4_Vector(2, 2, 2);
        Ejercicio4_Vector vector2= new Ejercicio4_Vector(3, 3, 3);
        
        System.out.println("vector 1: "+ vector1.toString());
        System.out.println("vector 2: "+ vector2.toString());
        
        // multiplicar las dos fracciones
        
        Ejercicio4_Vector multiplicar = vector1.MultiplicarVector(vector2);
        System.out.println("la multiplicacion de ambos vectores sera: "+ multiplicar.toString());
        Ejercicio4_Vector sumar = vector1.SumaVector(vector2);
        System.out.println("la suma de ambos vectores sera: "+ sumar.toString());
        
    }
}
