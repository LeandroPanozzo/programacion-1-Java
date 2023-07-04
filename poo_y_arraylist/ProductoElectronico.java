
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
public class ProductoElectronico {
    private String marca;
    private String modelo;
    private double precio;

    //getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }
    
    //setters

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoElectronico(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    

    @Override
    public String toString() {
        return "marca=" + marca + ", modelo=" + modelo + ", precio=" + precio;
    }
    
    public static class Televisor extends ProductoElectronico{
    
        private int TamañoPantalla;

        public Televisor(String marca, String modelo, double precio, int tamañoPantalla) {
            super(marca, modelo, precio);
            this.TamañoPantalla=tamañoPantalla;
        }

        public int getTamañoPantalla() {
            return TamañoPantalla;
        }

        public void setTamañoPantalla(int TamañoPantalla) {
            this.TamañoPantalla = TamañoPantalla;
        }
        
        public String toString() {
            return super.toString() + ", pulgadas=" + TamañoPantalla;
        }
    
    }
    
    
    public static class Computadoras extends  ProductoElectronico{
    
        private String SistemaOP;

        public Computadoras(String marca, String modelo, double precio, String sistemaOP) {
            super(marca, modelo, precio);
            this.SistemaOP=sistemaOP;
        }
        

        public String getSistemaOP() {
            return SistemaOP;
        }

        public void setSistemaOP(String SistemaOP) {
            this.SistemaOP = SistemaOP;
        }
        
        
        
        public String toString() {
            return super.toString() + ", sistema operativo=" + SistemaOP;
        }
    
    }
    
    public static void main(String[] args) {
        ArrayList<ProductoElectronico> electrodomestico= new ArrayList<>();
        Scanner teclado= new Scanner(System.in);
        
        while (true) {            
            System.out.println("ingrese la opcion a elegir");
            System.out.println("1- agregar un televisor a la tienda");
            System.out.println("2- agregar una computadora a la tienda");
            System.out.println("3- mostrar todos los productos de la tienda");
            System.out.println("4- mostrar todos los televisores de la tienda");
            System.out.println("5- mostrar todas las computadoras de la tienda");
            System.out.println("6- editar la informacion de un producto en la tienda");
            System.out.println("7- eliminar producto de la tienda");
            System.out.println("8- salir");
            int opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("ingrese la marca:");
                    String MarcaTele=teclado.next();
                    System.out.println("ingrese el modelo");
                    String ModeloTele=teclado.next();
                    System.out.println("precio");
                    int precioTele=teclado.nextInt();
                    System.out.println("pulgadas");
                    int Pulgadas=teclado.nextInt();
                    Televisor tele= new Televisor(MarcaTele, ModeloTele, precioTele,Pulgadas);
                    electrodomestico.add(tele);
                    break;
            
                case 2:
                    System.out.println("ingrese la marca:");
                    String MarcaCompu=teclado.next();
                    System.out.println("ingrese el modelo");
                    String ModeloCompu=teclado.next();
                    System.out.println("precio");
                    int precioCompu=teclado.nextInt();
                    System.out.println("pulgadas");
                    String SistOp=teclado.next();
                    Computadoras compu= new Computadoras(MarcaCompu, ModeloCompu, precioCompu, SistOp);
                    electrodomestico.add(compu);
                    break;
                    
                case 3:
                    System.out.println("Todos los productos son:");
                    for (ProductoElectronico producto : electrodomestico) {
                    System.out.println(producto.toString());
                    }
                    break;
                    
                case 4:
                    System.out.println("Televisores:");
                    for (ProductoElectronico producto : electrodomestico) {
                        if (producto instanceof Televisor) {
                            System.out.println(producto.toString());
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("Computadoras:");
                    for (ProductoElectronico producto : electrodomestico) {
                        if (producto instanceof Computadoras) {
                            System.out.println(producto.toString());
                        }
                    }
                    break;
                    
                case 6:
                    System.out.println("Ingrese el modelo del producto a editar:");
                    String buscar = teclado.next();
                    boolean encontrado = false;
                    for (ProductoElectronico producto : electrodomestico) {
                        if (producto.getModelo().equals(buscar)) {
                            System.out.println("Ingrese la nueva marca:");
                            producto.setMarca(teclado.next());
                            System.out.println("Ingrese el nuevo precio:");
                            producto.setPrecio(teclado.nextDouble());
                            System.out.println("Información del producto actualizada.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró un producto con ese modelo.");
                    }
                    break;

                    
                case 7:
                    System.out.println("ingrese el modelo el producto a eliminar");
                    String Buscar=teclado.next();
                    encontrado= false;
                    for (ProductoElectronico productoElectronico : electrodomestico) {
                        if (productoElectronico.getModelo().equals(Buscar)) {
                            electrodomestico.remove(productoElectronico);
                            encontrado=true;
                            break;
                        }
                    }
                     if (encontrado==true) {
                        System.out.println("empleado eliminado");
                    }else{
                        System.out.println("no se encontro un empleado con ese nombre");
                    }
                    break;
                    
                case 8:
                    teclado.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("ingreso valores incorrectos intentelo denuevo");
                    break;
            }
        }
    }
}
