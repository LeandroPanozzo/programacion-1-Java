/*
 Ejercicio 3:
Crear una clase ejercicio3_fracción, que cuente con dos atributos: dividendo y divisor, que se asignan en
el constructor, y se imprimen como X/Y en el método toString().
1. Crear un método sumar que recibe otra fracción y devuelve una nueva fracción con la
suma de ambas.
2. Crear un método multiplicar que recibe otra fracción y devuelve una nueva fracción con
el producto de ambas.
 */
package ejercicios_poo;

/**
 *
 * @author Leandro
 */
public class ejercicio3_fraccion {
    private int dividendo;
    private int divisor;

    //constructor
    public ejercicio3_fraccion(int dividendo, int divisor) {
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

    @Override
    public String toString() {
        return dividendo + "/" + divisor;
    }
    
    
    public ejercicio3_fraccion sumar(ejercicio3_fraccion otraFraccion){
        int nuevoDividendo= (this.dividendo*otraFraccion.divisor)+(this.divisor*otraFraccion.dividendo);
        int nuevoDivisor= (this.divisor*otraFraccion.divisor);
        return new ejercicio3_fraccion(nuevoDividendo, nuevoDivisor);
    }
    
    public ejercicio3_fraccion multiplicar(ejercicio3_fraccion otraFraccion){ /*Dentro del método multiplicar(), this.dividendo y this.divisor se refieren
        a los atributos dividendo y divisor de la instancia actual (fraccion1 en este caso), mientras que otraFraccion.dividendo y otraFraccion.divisor se
        refieren a los atributos dividendo y divisor del objeto fraccion2.*/
        int nuevoDividendo= (this.dividendo*otraFraccion.dividendo);
        int nuevoDivisor= (this.divisor*otraFraccion.divisor);
        return new ejercicio3_fraccion(nuevoDividendo, nuevoDivisor);
    }
    
    public static void main(String[] args) {
        ejercicio3_fraccion fraccion1= new ejercicio3_fraccion(1, 2);
        ejercicio3_fraccion fraccion2= new ejercicio3_fraccion(2, 3);
        
        System.out.println("fraccion 1 :" + fraccion1.toString());
        System.out.println("fraccion 2 :" + fraccion2.toString());
        
        //sumar las dos fracciones:
        
        ejercicio3_fraccion suma= fraccion1.sumar(fraccion2);
        System.out.println("la suma sera :"+ suma.toString());
        
        //multiplicar dos fracciones: 
        
        ejercicio3_fraccion multiplicar = fraccion1.multiplicar(fraccion2); /*ose que ejercicio3_fraccion resultado = fraccion1.multiplicar(fraccion2); 
fraccion1 tiene los valores de this.dividendo y this.divisor y fraccion 2 la de otraFraccion*/
        System.out.println("la multiplicacion sera :" + multiplicar.toString());
    }
}
