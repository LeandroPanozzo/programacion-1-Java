
package binarios_arboles_avl;

import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */

//especifico el comportamiento de los metodos
public class ArbolAVL {
    
    private NodoArbolAVL raiz; 

    public ArbolAVL() {
        this.raiz = null; //inicializa la raiz en nulo, si cambia a otro elemento dif de nulo tengo minimo un nodo
    }
   
    //insertar un nodo al arbol
public void insertar(int d){
   NodoArbolAVL nuevo= new NodoArbolAVL(d);
   if(raiz==null){ 
       raiz=nuevo; //si no hay nada entonces la raiz es el nuevo nodo
   }else{
       raiz=insertarAVL(nuevo, raiz); //si ya hay raiz se creara un hijo ver metodo Insertar balanceo
   }
}


//recorridos
    //recorrer in orden

 public boolean estaVacio(){ //primero veo si no esta vacio
        return raiz==null;
    }
 //recorrer en Inorden
    public void inOrden(NodoArbolAVL r){ // es la raiz del nodo arbol
        if(r!=null){  //si la raiz no es nula
            inOrden(r.hijoIzquierdo);  //recorro primero el hizo izq
            System.out.println(r.dato); //muestro la raiz
            inOrden(r.hijoDerecho); //leo el hijo derecho
        }
    }
    //recorrer en preorden
    public void preorden(NodoArbolAVL r){
        if(r!=null){
            System.out.println(r.dato);
            preorden(r.hijoIzquierdo);
            preorden(r.hijoDerecho);
        }
    }
    //recorrer postorden
    public void postOrden(NodoArbolAVL r){
         if(r!=null){
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
             System.out.println(r.dato);
        }
    }

  
   
    public NodoArbolAVL obtenerRaiz(){
        return raiz;
    }
    
    
    
    //busqueda
public NodoArbolAVL buscar(int d, NodoArbolAVL r){ //d es un puntero auxiliar
    if(raiz==null){
        return null;
    }else if(r.dato==d){ //si auxiliar y el dato son iguales retorno el mismo
        return r; 
    }else if(r.dato<d){  //si el auxiliar es mayor al dato 
        return buscar(d, r.hijoDerecho);  //apuntamos a hijo derecho
    }else{
        
            return buscar(d, r.hijoIzquierdo); //sino aounta a hijo izquierdo 
        
    }
}

   //obtener factor de equilibrio
public int obtenerFE(NodoArbolAVL var){
    if(var==null){
        return -1;
    }else{
        return var.fe;
    }
}

//rotacion simple a la izquierda
public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
    NodoArbolAVL auxiliar=c.hijoIzquierdo; //reacomodo los punteros
    c.hijoIzquierdo=auxiliar.hijoDerecho;
    auxiliar.hijoDerecho=c;
    c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;  //obtiene el maximo de dos valores, obtengo el factor de equilibrio del lado derecho e izq
    auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1; // saco el factor de equilibrio de auxiliar se suma mas uno porque es el nivel mas 1 para obtener el nivel
    return auxiliar;
}

//rotacion simple derecha
public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
    NodoArbolAVL auxiliar=c.hijoDerecho;
    c.hijoDerecho=auxiliar.hijoIzquierdo;
    auxiliar.hijoIzquierdo=c;
    c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;  //obtiene el maximo
    auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
    return auxiliar;
}


//rotacion doble a la izq
public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
    NodoArbolAVL temporal;
    c.hijoIzquierdo= rotacionDerecha(c.hijoIzquierdo); //llamo a la rotacion derecha
    temporal=rotacionIzquierda(c); 
    return temporal;

}
//rotacion doble a la der
public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
    NodoArbolAVL temporal;
   c.hijoDerecho= rotacionIzquierda(c.hijoDerecho);
    temporal=rotacionDerecha(c);
    return temporal;
}

//insertar balanceo
public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){//creo dos nodos uno nuevo y un subarbol
    NodoArbolAVL nuevoPadre=subAr;  
    if(nuevo.dato<subAr.dato){   //si el dato nuevo (raiz) es menor a subarbol(siguiente dato introducido)
        if(subAr.hijoIzquierdo==null){  //si el puntero izq es nulo
            subAr.hijoIzquierdo=nuevo;  //se creara un nuevo nodo del lado izq
        }else{
            subAr.hijoIzquierdo=insertarAVL(nuevo, subAr.hijoIzquierdo); 
            if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2)){ //si el fe es 2 entonces
                if(nuevo.dato<subAr.hijoIzquierdo.dato){  
                    nuevoPadre=rotacionIzquierda(subAr); //si es menor que el subarbol se hace una rotacion izq
                }else{
                    nuevoPadre=rotacionDobleIzquierda(subAr); //sino una rotacion doble
                }
            }
        }
    }else if(nuevo.dato>subAr.dato){ //si no es menor a la raiz se ira a la derecha
        if(subAr.hijoDerecho==null){
            subAr.hijoDerecho=nuevo;
        }else{
            subAr.hijoDerecho=insertarAVL(nuevo, subAr.hijoDerecho);
            if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
                if(nuevo.dato>subAr.hijoDerecho.dato){
                    nuevoPadre=rotacionDerecha(subAr);
                }else{
                    nuevoPadre=rotacionDobleDerecha(subAr);
                }
            }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Nodo duplicado");
    }

  //actualizar factor de equilibrio
    if((subAr.hijoIzquierdo==null)&&(subAr.hijoDerecho!=null)){ //si ambos subarboles son nulos
        subAr.fe=subAr.hijoDerecho.fe+1; //actualizo su factor de equilibrio sumando 1
    }else if((subAr.hijoDerecho==null)&&(subAr.hijoIzquierdo!=null)){ //si el derecho es nulo
        subAr.fe=subAr.hijoIzquierdo.fe+1; //actualizo el factor de equilibrio con el del subarbol izquierdo
    }else{
        subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho))+1; //obtengo el valor del factor de equilibrio total
    }
    return nuevoPadre; //retorno el balance
}

//metodo para buscar el nodo arbol 
//debo crear un auxiliar que vaya comprando su valor con el de los nodos hasta encontarlo
public NodoArbolAVL buscarNodoArbolAVL(int d){ 
    NodoArbolAVL aux=raiz;//d es un puntero auxiliar que apunta a raiz
    while (aux.dato!=d) {   //mientras el dato del auxiliar sea diferente del dato que buscamos      
        if (d<aux.dato) { //si el dato es menor al dato auxiliar apuntamos a el hijo izquierdo
            aux=aux.hijoIzquierdo; 
        }else{
            aux=aux.hijoDerecho; //sino apunto al derecho
        }
        if (aux==null) {
            return null; //si no encuentro retorno nulo
        }
    }
    return aux;// si retorna aux es porque encontramos 
}

}
