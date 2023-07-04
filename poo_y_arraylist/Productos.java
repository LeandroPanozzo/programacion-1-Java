/*
 Crea un programa que simule un carrito de compras. El programa debe permitir al usuario agregar productos al carrito, 
eliminar productos del carrito y mostrar el contenido actual del carrito.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Productos {
    private String nombre;
    private double precio;

    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }

    public static class CarritoCompras {
        private ArrayList<Productos> productos = new ArrayList<>();

        public void agregarProducto(Productos productoAgregar) {
            productos.add(productoAgregar);
        }

        public void eliminarProducto(int indice) {
            if (indice >= 0 && indice < productos.size()) {
                productos.remove(indice);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Índice del producto inválido.");
            }
        }

        public void mostrarProductos() {
            if (productos.isEmpty()) {
                System.out.println("El carrito está vacío.");
            } else {
                System.out.println("Productos en el carrito:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("Producto número " + i + ": " + productos.get(i));
                }
            }
        }

        public double calcularTotal() {
            double total = 0;
            for (Productos producto : productos) {
                total += producto.getPrecio();
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CarritoCompras carrito = new CarritoCompras();

        while (true) {
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Eliminar producto del carrito");
            System.out.println("3. Mostrar contenido del carrito");
            System.out.println("4. Calcular total");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = teclado.next();
                    System.out.print("Ingrese el precio del producto: ");
                    double precioProducto = teclado.nextDouble();
                    Productos producto = new Productos(nombreProducto, precioProducto);
                    carrito.agregarProducto(producto);
                    System.out.println("Producto agregado al carrito.");
                    break;
                case 2:
                    System.out.print("Ingrese el índice del producto a eliminar: ");
                    int indiceEliminar = teclado.nextInt();
                    carrito.eliminarProducto(indiceEliminar);
                    break;
                case 3:
                    carrito.mostrarProductos();
                    break;
                case 4:
                    double total = carrito.calcularTotal();
                    System.out.println("Total: $" + total);
                    break;
                case 5:
                    teclado.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
}
