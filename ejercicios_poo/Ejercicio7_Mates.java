package ejercicios_poo;

/*
 Ejercicio 7:
Crear una clase Ejercicio7_Mates que describa el funcionamiento de la conocida bebida tradicional local. La
clase debe contener como miembros:
1. Un atributo para la cantidad de cebadas restantes hasta que se lava el mate
(representada por un número).
2. Un atributo para el estado (lleno o vacío).
3. El constructor debe recibir como parámetro n, la cantidad máxima de cebadas en base a
la cantidad de yerba vertida en el recipiente.
4. Un método cebar(), que llena el mate con agua. Si se intenta cebar con el mate lleno, se
debe imprimir un mensaje de error 'Cuidado! Te quemaste!'
5. Un método beber(), que vacía el mate y le resta una cebada disponible. Si se intenta
beber un mate vacío, se debe imprimir un mensaje de error 'El mate está vacío !'
6. Es posible seguir cebando y bebiendo el mate aunque no haya cebadas disponibles. En
ese caso la cantidad de cebadas restantes se mantendrá en 0, y cada vez que se
intente beber se debe imprimir un mensaje de aviso: 'Advertencia: el mate está lavado.'.
Crear una aplicación en donde se cree un objeto Mate y se puedan tomar mates.
 */

/**
 *
 * @author Leandro
 */
public class Ejercicio7_Mates {
    private int CantidadCebadas;
    private boolean Lleno;
    
    //constructor
    public Ejercicio7_Mates(int CantidadCebadas, boolean Lleno_vacio) {
        this.CantidadCebadas = CantidadCebadas;
        this.Lleno = Lleno_vacio;
    }
    
    //metodos
    public void cebar(Ejercicio7_Mates mates){
    
        if (mates.Lleno) {
            System.out.println("Cuidado! Te quemaste!");
        }
    }
    
    public void beber(Ejercicio7_Mates mates){
    
        if (mates.CantidadCebadas>0) {
            CantidadCebadas-=1;
        }else{
            if (mates.CantidadCebadas==0) {
                System.out.println("Advertencia: el mate está lavado");
            }else{
                System.out.println("El mate está vacío !");
            }
        }
    }
    
    public static void main(String[] args) {
        Ejercicio7_Mates mates= new Ejercicio7_Mates(5, true);
        
        mates.cebar(mates);  // Llenar el mate con agua
        mates.beber(mates);  // Tomar mate del mate y reducir las cebadas disponibles
        mates.beber(mates);  // Tomar mate del mate nuevamente
    
    // Salida:
    // ¡Cuidado! ¡Te quemaste!
    // Advertencia: el mate está lavado.
    }
}
