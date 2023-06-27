/*
Ejercicio 2:
Crear una clase ejercicio2_libro que contenga los siguientes atributos:
1. ISBN, Título, Autor, Número de páginas
Crear sus respectivos métodos get y set correspondientes para cada atributo. Crear el método
toString() para mostrar la información relativa al libro con el siguiente formato:
“El libro con ISBN creado por el autor tiene páginas”
Crear una aplicación que permita crear 2 objetos Libro (los valores que se quieran) y mostrarlos
por pantalla. Por último, indicar cuál de los 2 tiene más páginas.
 */
package ejercicios_poo;

/**
 *
 * @author Leandro
 */
public class ejercicio2_libro {
    private String Titulo;
    private String Autor;
    private int Num_paginas;
    private int ISBN;
    
    //getters
    public String getAutor() {
        return Autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public int getNum_paginas() {
        return Num_paginas;
    }

    public int getISBN() {
        return ISBN;
    }
    
    //setters
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public void setNum_paginas(int Num_paginas) {
        this.Num_paginas = Num_paginas;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    //metodo to string
    @Override
    public String toString() {
        return "El libro '" + Titulo + "' creado por " + Autor + " tiene " + Num_paginas + " páginas.";
    }
    
    public static void main(String[] args) {
        ejercicio2_libro libro1= new ejercicio2_libro(); //creo el objeto libro 1
        libro1.setAutor("Dan Brown");
        libro1.setTitulo("El código Da Vinci");
        libro1.setNum_paginas(490);
        libro1.setISBN(4355345);
        
        ejercicio2_libro libro2= new ejercicio2_libro();
        libro2.setAutor("Gabriel García Márquez");
        libro2.setTitulo("Cien años de soledad");
        libro2.setNum_paginas(250);
        libro2.setISBN(3249384);
        
        
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        
        if (libro1.getNum_paginas()>libro2.getNum_paginas()) {
            System.out.println("el libro 1 tiene mas paginas");
        }else{
            if (libro1.getNum_paginas()<libro2.getNum_paginas()) {
            System.out.println("el libro 2 tiene mas paginas");
            }else{
                System.out.println("ambos tienen las mismas paginas");
            
            }
        }
    }
}
