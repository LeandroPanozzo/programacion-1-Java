/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios_arboles_avl;

/**
 *
 * @author Leandro
 */
public class NodoArbolAVL {
    int dato; //dato del nodo
    int fe;//factor de eqilibrio 
    NodoArbolAVL hijoIzquierdo, hijoDerecho; //punteros izquierdo y derecho, apuntando a los siguientes nodos 

    
    //constructor (crea al arbol)
    public NodoArbolAVL(int d) {
        this.dato = d;  //dato sera igual al parametro d
        this.fe = 0;  //porque no sabemos como esta el arbol cuando inicia
        
        //inicializo los punteros en nulo 
        //cada vez que se crea un nodo sus hijos seran nulos
        this.hijoIzquierdo = null; 
        this.hijoDerecho = null;
    }
}
