/*
 Ejercicio 10:

Crear una clase llamada Serie con las siguientes características:
1. Sus atributos son título, número de temporadas, entregado, género y creador. Por
defecto, el número de temporadas es de 3 temporadas y entregado false. El resto de
atributos serán valores por defecto según el tipo del atributo.

Los constructores que se implementarán serán:
1. Un constructor por defecto.
2. Un constructor con el título y creador. El resto por defecto.
3. Un constructor con todos los atributos, excepto de entregado.

Los métodos que se implementara serán:
1. Métodos get de todos los atributos, excepto de entregado.
2. Métodos set de todos los atributos, excepto de entregado.

Crearemos una clase Videojuego con las siguientes características:
1. Sus atributos son titulo, horas estimadas, entregado, genero y compañia.
Por defecto, las horas estimadas serán de 10 horas y entregado false. El resto de
atributos serán valores por defecto según el tipo del atributo.

Los constructores que se implementarán serán:
1. Un constructor por defecto.
2. Un constructor con el título y horas estimadas. El resto por defecto.
3. Un constructor con todos los atributos, excepto de entregado.

Los métodos que se implementara serán:
1. Métodos get de todos los atributos, excepto de entregado.
2. Métodos set de todos los atributos, excepto de entregado.

Las clases anteriores tienen los siguientes métodos:
1. entregar(): cambia el atributo prestado a true.
2. devolver(): cambia el atributo prestado a false.
3. isEntregado(): devuelve el estado del atributo prestado.
Implementa los anteriores métodos en las clases Videojuego y Serie.

Crear una aplicación que realiza lo siguiente:
1. Crea dos arrays, uno de Series y otro de Videojuegos, de 5 posiciones cada uno.
2. Crea un objeto en cada posición del array, con los valores que desees, puedes usar
distintos constructores.
3. Entrega algunos Videojuegos y Series con el método entregar().
4. Cuenta cuantos Series y Videojuegos hay entregados. Al contarlos, retornar por pantalla
el resultado.

Por último, indica el Videojuego tiene más horas estimadas y la serie con más temporadas.
Mostrarlos en pantalla con toda su información.
 */
package ejercicios_poo;

import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class Ejercicio10_Serie {
    private String titulo;
    private int numTemp;
    private boolean entregado;
    private String genero;
    private String creador;
    
    //constructores

    public Ejercicio10_Serie() {
        this.entregado= false;
        this.numTemp=3;
    }

    public Ejercicio10_Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
        this.entregado = false;
        this.numTemp = 3;
    }

    public Ejercicio10_Serie(String titulo, int NumTemp, String genero, String creador) {
        this.titulo = titulo;
        this.numTemp = NumTemp;
        this.genero = genero;
        this.creador = creador;
        this.entregado = false;
    }
    
    //getter
    public String getTitulo() {
        return titulo;
    }

    public int getNumTemp() {
        return numTemp;
    }

    public String getGenero() {
        return genero;
    }

    public String getCreador() {
        return creador;
    }
    
    //setter

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNumTemp(int NumTemp) {
        this.numTemp = NumTemp;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
    
        public void entregar(){
            entregado= true;
        }
        
        public void devolver(){
            entregado=false;
        }
        
        public boolean isEntregado(){
            return entregado;
        }
    
        //clase videojuego
    public static class Videojuego{
    
        private String titulo;
        private int horas;
        private boolean entregado;
        private String genero;
        private String compañia;
        
        //constructores

        public Videojuego() {
            this.entregado=false;
            this.horas=10;
        }

        public Videojuego(String titulo, int Horas) {
            this.titulo = titulo;
            this.horas = Horas;
            this.entregado=false;
        }

        public Videojuego(String titulo, int Horas, String genero, String compañia) {
            this.titulo = titulo;
            this.horas = Horas;
            this.genero = genero;
            this.compañia = compañia;
            this.entregado=false;
        }
        
        //getters

        public String getTitulo() {
            return titulo;
        }

        public int getHoras() {
            return horas;
        }

        public String getGenero() {
            return genero;
        }

        public String getCompañia() {
            return compañia;
        }
        
        //setters

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setHoras(int Horas) {
            this.horas = Horas;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public void setCompañia(String compañia) {
            this.compañia = compañia;
        }
        
        public void entregar(){
            entregado= true;
        }
        
        public void devolver(){
            entregado=false;
        }
        
        public boolean isEntregado(){
            return entregado;
        }
    }
    
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        Ejercicio10_Serie serie[]= new Ejercicio10_Serie[5];
        
        Videojuego juego[]= new Videojuego[5];
        
        System.out.println("ingrese los valores para la serie: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("titulo: ");
            String titulo= teclado.next();
            System.out.println("numero de temporadas: ");
            int temp= teclado.nextInt();
            System.out.println("genero: ");
            String genero= teclado.next();
            System.out.println("creador: ");
            String creador= teclado.next();
            serie[i] = new Ejercicio10_Serie(titulo, temp, genero, creador);
        }
        
        
        System.out.println("ingrese los valores para el videojuego: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("titulo: ");
            String tituloVideojuego= teclado.next();
            System.out.println("genero: ");
            String generoVideojuego= teclado.next();
            System.out.println("compañia: ");
            String compañia= teclado.next();
            System.out.println("horas estimadas: ");
            int Horas= teclado.nextInt();
            juego[i] = new Ejercicio10_Serie.Videojuego(tituloVideojuego, Horas, generoVideojuego, compañia);
        }
        
        // Marcar algunos videojuegos y series como entregados
        juego[0].entregar();
        juego[1].entregar();
        serie[0].entregar();
        serie[2].entregar();
        serie[4].entregar();
        
        // Contar videojuegos y series entregados
        int videojuegosEntregados = 0;
        int seriesEntregadas = 0;

        for (int i = 0; i < 5; i++) {
            if (juego[i].isEntregado()) {
                videojuegosEntregados++;
            }

            if (serie[i].isEntregado()) {
                seriesEntregadas++;
            }
        }
        
        System.out.println("Videojuegos entregados: " + videojuegosEntregados);
        System.out.println("Series entregadas: " + seriesEntregadas);
        
        // Encontrar el videojuego con más horas estimadas
        Ejercicio10_Serie.Videojuego videojuegoMasHoras = juego[0];
        for (int i = 1; i < 5; i++) {
            if (juego[i].getHoras() > videojuegoMasHoras.getHoras()) {
                videojuegoMasHoras = juego[i];
            }
        }
        
        System.out.println("Videojuego con más horas estimadas: " + videojuegoMasHoras.getTitulo());

        // Encontrar la serie con más temporadas
        Ejercicio10_Serie serieMasTemporadas = serie[0];
        for (int i = 1; i < 5; i++) {
            if (serie[i].getNumTemp() > serieMasTemporadas.getNumTemp()) {
                serieMasTemporadas = serie[i];
            }
        }

        System.out.println("Serie con más temporadas: " + serieMasTemporadas.getTitulo());
    
    }
    
}
