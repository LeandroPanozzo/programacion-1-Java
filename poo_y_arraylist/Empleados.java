
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
public class Empleados {
    private String nombre;
    private int edad;
    private double salario;

    public Empleados(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario;
    }
    
    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        ArrayList<Empleados> empleados;
        empleados= new ArrayList<>();
        
        while (true) {            
            System.out.println("1- agregar empleado");
            System.out.println("2- Mostrar empleados");
            System.out.println("3- eliminar empleado");
            System.out.println("4-Salir del programa");
            System.out.println("seleccione una opcion ingresando un numero");
            int opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("ingrese el nombre");
                    String nombre = teclado.next();
                    System.out.println("ingrese el salario");
                    double salario = teclado.nextDouble();
                    System.out.println("ingrese la edad");
                    int edad = teclado.nextInt();
                    Empleados empleados1= new Empleados(nombre, edad, salario);
                    empleados.add(empleados1);
                    System.out.println("el empleado a sido agregado correectamente");
                    break;
                    
                case 2:
                    if (empleados.isEmpty()) {
                        System.out.println("no hay empleados registrados");
                    }else{
                        for (int i = 0; i < empleados.size(); i++) {
                            System.out.println(empleados.toString());
                        }
                    }
                    break;
                    
                case 3: 
                    System.out.println("ingrese el nombre del empleado a eliminar");
                    String empleadoEliminar= teclado.next();
                    boolean encontrado = false;
                    
                    for (Empleados emp : empleados) {
                        if (emp.getNombre().equals(empleadoEliminar)) {
                            empleados.remove(emp);
                            encontrado= true;
                            break;
                        }
                    }
                    if (encontrado==true) {
                        System.out.println("empleado eliminado");
                    }else{
                        System.out.println("no se encontro un empleado con ese nombre");
                    }
                    break;
                    
                case  4: 
                    teclado.close();
                    break;
                    
                default:
                    System.out.println("valores incorrectos ingrese denuevo");
                    break;
            }
            
        }
        
    }
    
}
