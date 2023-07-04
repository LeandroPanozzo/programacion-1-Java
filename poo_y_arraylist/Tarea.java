
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
public class Tarea {
    private String descripcion;
    private boolean compleata;

    //constructor
    public Tarea(String descripcion) {    
        this.descripcion = descripcion;
    }

    //getters
    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompleata() {
        return compleata;
    }
    //setters

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompleata(boolean compleata) {
        this.compleata = compleata;
    }

    @Override
    public String toString() {
        return "descripcion=" + descripcion + ", compleata=" + compleata;
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        ArrayList<Tarea>ArrayTareas= new ArrayList<>();
        
        while (true) {            
            System.out.println("1- Agregar tarea");
            System.out.println("2- Marcar tarea como completada");
            System.out.println("3- Mostarar tareas");
            System.out.println("4- Salir");
            System.out.println("Seleccione una opcion");
            int opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("ingrese la tarea a realizar");
                    String descripcion=teclado.next();
                    Tarea tarea = new Tarea(descripcion);
                    ArrayTareas.add(tarea);
                    break;
                    
                case 2:
                    if (ArrayTareas.isEmpty()) {
                        System.out.println("No hay tareas añadidas");
                        
                    }else{
                        
                        for (int i = 0; i < ArrayTareas.size(); i++) {
                            System.out.println(i+" :"+ ArrayTareas.get(i));
                        }
                        
                        System.out.println("ingrese la posicion que desea eliminar");
                        int posicion=teclado.nextInt();
                        
                        
                        if (posicion>=0&&posicion<ArrayTareas.size()) {
                            Tarea tareaSeleccionada=ArrayTareas.get(posicion);
                            tareaSeleccionada.setCompleata(true);
                            System.out.println("la tarea a sido seleccionada como completada");
                        }else{
                            System.out.println("indice invalido, intentelo denuevo");
                        }
                        
                    }
                    break;
                    
                case 3:
                    if (ArrayTareas.isEmpty()) {
                        System.out.println("no hay tareas que mostrar");
                    }else{
                        System.out.println("las tareas son: ");
                        for (Tarea ArrayTarea : ArrayTareas) {
                            System.out.println(ArrayTarea.toString());
                        }
                    }
                    break;
                    
                case 4:
                    teclado.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("valor selecciondo es incorrecto");
                    break;
            
            }
        }
    }
    
    
}
