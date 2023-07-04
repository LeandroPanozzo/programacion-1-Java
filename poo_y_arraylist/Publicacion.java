
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro
 */
public class Publicacion {
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public Publicacion(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }

    //getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    
    //setters

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
    
    public static class Libro extends Publicacion{
        private int NumPag;
        public Libro(String titulo, String autor, int añoPublicacion, int numPag) {
            super(titulo, autor, añoPublicacion);
            this.NumPag=numPag;
        }

        public int getNumPag() {
            return NumPag;
        }

        public void setNumPag(int NumPag) {
            this.NumPag = NumPag;
        }
        
        
        
        public void Imprimir(){
            System.out.println("Libro");
            System.out.println("Titulo "+getTitulo());
            System.err.println("Autor" + getAutor());
            System.out.println("Año de publicacion "+ getAñoPublicacion());
            System.out.println("Numero de paginas "+ getNumPag());
        }
    
    }
    
    public static class Revista extends Publicacion{
        private int NumEdicion;
        public Revista(String titulo, String autor, int añoPublicacion, int numEdicion) {
            super(titulo, autor, añoPublicacion);
            this.NumEdicion=numEdicion;
        }

        public int getNumEdicion() {
            return NumEdicion;
        }

        public void setNumEdicion(int NumEdicion) {
            this.NumEdicion = NumEdicion;
        }
        
        public void Imprimir(){
            System.out.println("Revista");
            System.out.println("Titulo "+getTitulo());
            System.err.println("Autor" + getAutor());
            System.out.println("Año de publicacion "+ getAñoPublicacion());
            System.out.println("Numero de edicion "+ getNumEdicion());
        }


    }
    
    public static void main(String[] args) {
        ArrayList<Publicacion>publicaciones= new ArrayList<>();
        Scanner teclado= new Scanner(System.in);
        
        while (true) {            
            System.out.println("ingrese una opcion");
            System.out.println("1- agregar libro");
            System.out.println("2- agregar revista");
            System.out.println("3- salir");
            System.out.println("opcion seleccionada:");
            int opcion= teclado.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("ingrese el nombre del libro");
                    String titulo=teclado.next();
                    System.out.println("ingrese el autor");
                    String autor=teclado.next();
                    System.out.println("ingrese el año de publicacion");
                    int año=teclado.nextInt();
                    System.out.println("ingrese el numero de paginas");
                    int numeroPag=teclado.nextInt();
                    
                    Libro libro= new Libro(titulo, autor, año, numeroPag);
                    publicaciones.add(libro);
                    System.out.println("valores ingresados");
                    System.out.println("el arreglo quedara:");
                    for (Publicacion publicacion : publicaciones) {
                        if (publicacion instanceof Libro) {
                        Libro libroActual = (Libro) publicacion;
                        libroActual.Imprimir();
                        }
                        System.out.println();
                    }
                   
                    
                    break;
                    
                case 2:
                    System.out.println("ingrese el nombre de la revista");
                    String tituloRevista=teclado.next();
                    System.out.println("ingrese el autor");
                    String autorRevista=teclado.next();
                    System.out.println("ingrese el año de publicacion");
                    int añoRevista=teclado.nextInt();
                    System.out.println("ingrese el numero de edicion");
                    int numeroEdicion=teclado.nextInt();
                    
                    Revista revista = new Revista(tituloRevista, autorRevista, añoRevista, numeroEdicion);
                    publicaciones.add(revista);
                    System.out.println("valores ingresados");
                    System.out.println("el arreglo quedara:");
                    for (Publicacion publicacion : publicaciones) {
                        if (publicacion instanceof Revista) {
                        Revista libroActual = (Revista) publicacion;
                        libroActual.Imprimir();
                        }
                        System.out.println();
                    }
                    break;
                    
                case 3:
                    teclado.close();
                    System.exit(0);
                     
                    break;
                    
                default:
                    System.out.println("opcion selleccionada incorecta");
                    
            
            }
        }
    }
    
}
