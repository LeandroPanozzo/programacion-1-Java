


import java.util.ArrayList;
import java.util.Scanner;


public class Libro {

    private String titulo;
    private String Autor;
    private int Publicacion;

    //getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(int Publicacion) {
        this.Publicacion = Publicacion;
    }
    
    //constructor

    public Libro(String titulo, String Autor, int Publicacion) {
        this.titulo = titulo;
        this.Autor = Autor;
        this.Publicacion = Publicacion;
    }
    
    
    @Override
    public String toString() {
        return "titulo=" + titulo + ", Autor=" + Autor + ", Publicacion=" + Publicacion;
    }
    
    public static class LibroFisico extends Libro{
        private int Paginas;
        private String Ubicacion;
        private int Copias; //igual o mayor a 0 representa el numero de copias disponibles

        public LibroFisico(String titulo, String Autor, int Publicacion, int paginas, String ubicacion, int copias) {
            super(titulo, Autor, Publicacion);
            this.Copias=copias;
            this.Paginas=paginas;
            this.Ubicacion=ubicacion;
            
        }
        
        public void prestarLibro(Libro libro) {
            if (libro instanceof LibroFisico) {
            LibroFisico libroFisico = (LibroFisico) libro;
            if (libroFisico.Copias > 0) {
                libroFisico.Copias--;
                System.out.println("Se ha prestado el libro: " + libroFisico.getTitulo());
                System.out.println("Copias disponibles: " + libroFisico.Copias);
            }else {
                System.out.println("No hay copias disponibles de este libro.");
            }
            } else {
                System.out.println("No se puede prestar un libro que no es fÃ­sico.");
            }
        }


        @Override
        public String toString() {
            return "Paginas=" + Paginas + ", Ubicacion=" + Ubicacion + ", Copias=" + Copias+ "titulo= "+ getTitulo()+ "Autor= "+ getAutor()+ "publicacion= "+ getPublicacion();
        }
        
        
    
    }
    
    public static class LibroDigital extends Libro{
        private String Formato; //indiaca si es pf,Ebook, etc
        private int TamañoDelArchivo;
        public LibroDigital(String titulo, String Autor, int Publicacion,String formato, int tamañoArchivo) {
            super(titulo, Autor, Publicacion);
            this.Formato=formato;
            this.TamañoDelArchivo=tamañoArchivo;
        }

        @Override
        public String toString() {
            return "Formato=" + Formato + ", TamaÃ±oDelArchivo=" + TamañoDelArchivo+ "titulo= "+ getTitulo()+ "autor= "+ getAutor()+"Publicacion= "+getPublicacion();
        }
        
        
    
    
    }
    
    public static class Biblioteca {
    private ArrayList<Libro> librosaArrayList;

    public Biblioteca() {
        librosaArrayList = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosaArrayList.add(libro);
        System.out.println("El libro ha sido agregado a la biblioteca.");
    }

    public void eliminarLibro(Libro libro) {
        if (librosaArrayList.remove(libro)) {
            System.out.println("El libro ha sido eliminado de la biblioteca.");
        } else {
            System.out.println("El libro no se encontraba en la biblioteca.");
        }
    }

    public void mostrarInformacionLibros() {
        if (librosaArrayList.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("InformaciÃ³n de los libros en la biblioteca:");
            for (Libro libro : librosaArrayList) {
                System.out.println(libro.toString());
            }
        }
    }

    public void buscarLibroPorTitulo(String titulo) {
        boolean encontrado = false;
        for (Libro libro : librosaArrayList) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado:");
                System.out.println(libro.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontrÃ³ ningÃºn libro con el tÃ­tulo: " + titulo);
        }
    }
}

    
    
    public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    Scanner teclado = new Scanner(System.in);
    
    while (true) {            
        System.out.println("Ingrese una opciÃ³n:");
        System.out.println("1 - Agregar libro fÃ­sico");
        System.out.println("2 - Agregar libro digital");
        System.out.println("3 - Eliminar un libro de la biblioteca");
        System.out.println("4 - Buscar un libro por tÃ­tulo y mostrar la informaciÃ³n");
        System.out.println("5 - Salir");
        
        //para el case 3 y 4 que pregunte si es libro fisico o digital como segundo parametro tambien para saber cual eliminar y buscar
        
        int opcion = teclado.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Agregar libro fÃ­sico");
                System.out.println("Ingrese el tÃ­tulo: ");
                String titulo = teclado.next();
                System.out.println("Ingrese el autor: ");
                String autor = teclado.next();
                System.out.println("Ingrese el aÃ±o de publicaciÃ³n: ");
                int año = teclado.nextInt();
                System.out.println("Ingrese el nÃºmero de pÃ¡ginas: ");
                int numeroPaginas = teclado.nextInt();
                System.out.println("Ingrese la ubicaciÃ³n: ");
                String ubicacion = teclado.next();
                System.out.println("Ingrese el nÃºmero de copias: ");
                int numCopias = teclado.nextInt();
                
                LibroFisico libroFisico = new LibroFisico(titulo, autor, año, numeroPaginas, ubicacion, numCopias);
                biblioteca.agregarLibro(libroFisico);
                
                break;
                
            case 2:
                System.out.println("Agregar libro digital");
                System.out.println("Ingrese el tÃ­tulo: ");
                String tituloDigital = teclado.next();
                System.out.println("Ingrese el autor: ");
                String autorDigital = teclado.next();
                System.out.println("Ingrese el aÃ±o de publicaciÃ³n: ");
                int añoDigital = teclado.nextInt();
                System.out.println("Ingrese el formato: ");
                String formato = teclado.next();
                System.out.println("Ingrese el tamaÃ±o del archivo: ");
                int tamañoArchivo = teclado.nextInt();
                
                LibroDigital libroDigital = new LibroDigital(tituloDigital, autorDigital, añoDigital, formato, tamañoArchivo);
                biblioteca.agregarLibro(libroDigital);
                
                break;
                
            case 3:
            System.out.println("Eliminar un libro de la biblioteca");
            System.out.println("Ingrese el tÃ­tulo del libro que desea eliminar: ");
            String tituloEliminar = teclado.next();
    
            // Buscar el libro en la biblioteca
            boolean encontrado = false;
            for (Libro libro : biblioteca.librosaArrayList) {
            if (libro.getTitulo().equalsIgnoreCase(tituloEliminar)) {
            biblioteca.eliminarLibro(libro);
            encontrado = true;
            break;
            }
            }
    
            if (!encontrado) {
            System.out.println("No se encontrÃ³ ningÃºn libro con el tÃ­tulo: " + tituloEliminar);
            }
            break;

                
            case 4:
                System.out.println("Buscar un libro por tÃ­tulo");
                System.out.println("Ingrese el tÃ­tulo: ");
                String tituloBusqueda = teclado.next();
                biblioteca.buscarLibroPorTitulo(tituloBusqueda);
                break;
                
            case 5:
                System.exit(0); // Salir del programa
                break;
                
            default:
                System.out.println("OpciÃ³n invÃ¡lida. Por favor, seleccione una opciÃ³n vÃ¡lida.");
        }
    }
}

    
}
