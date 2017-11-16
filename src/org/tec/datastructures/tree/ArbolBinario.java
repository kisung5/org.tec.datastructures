package org.tec.datastructures.tree;

public class ArbolBinario <T extends Comparable<T>> {
 
    private ArbolBinarioNodo<T> raiz;

    public ArbolBinario() {
 
    }
 
    public ArbolBinario( T valor ) {
        this.raiz = new ArbolBinarioNodo<>( valor );
    }
 
    public ArbolBinario( ArbolBinarioNodo<T> raiz ) {
        this.raiz = raiz;
    }
 
    public ArbolBinarioNodo<T> getRaiz() {
        return raiz;
    }
 
    public void setRaiz(ArbolBinarioNodo<T> raiz) {
        this.raiz = raiz;
    }
 
    private void addNodo( ArbolBinarioNodo<T> nodo, ArbolBinarioNodo<T> raiz ) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            /* 
             * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato. 
             */
            raiz = nodo;
        }
        else {
            /* 4.- En caso negativo preguntamos: X < Nodo */
            if ( nodo.getValor().compareTo(raiz.getValor()) <= 0 ) {
                /* 
                 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar 
                 */
                addNodo( nodo , raiz.getHojaIzquierda() );
            }
            else {
                /* 
                 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.
                 */
                addNodo( nodo, raiz.getHojaDerecha() );
            }
        }
    }
 
    public void addNodo( ArbolBinarioNodo<T> nodo ) {
        this.addNodo( nodo , this.raiz );
    }
 
    public boolean removeNodo( ArbolBinarioNodo<T> nodo ) {
 
        /* Creamos variables para saber si tiene hijos izquierdo y derecho */
        boolean tieneNodoDerecha = nodo.getHojaDerecha() != null ? true : false;
        boolean tieneNodoIzquierda = nodo.getHojaIzquierda() != null ? true : false;
 
        /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */
 
        /* Caso 1: No tiene hijos */
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return removeNodoCaso1( nodo );
        }
 
        /* Caso 2: Tiene un hijo y el otro no */
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
 
        /* Caso 2: Tiene un hijo y el otro no */
        if ( !tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
 
        /* Caso 3: Tiene ambos hijos */
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }
 
        return false;
    }
 
    private boolean removeNodoCaso1( ArbolBinarioNodo<T> nodo ) {
        /* lo único que hay que hacer es borrar el nodo y establecer el apuntador de su padre a nulo */
 
        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        ArbolBinarioNodo<T> hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        ArbolBinarioNodo<T> hijoDerecho = nodo.getPadre().getHojaDerecha();
 
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHojaIzquierda( null );
            return true;
        }
 
        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha( null );
            return true;
        }
 
        return false;
    }
 
    private boolean removeNodoCaso2( ArbolBinarioNodo<T> nodo ) {
        /* Borrar el Nodo y el subárbol que tenía pasa a ocupar su lugar */
 
        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        ArbolBinarioNodo<T> hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        ArbolBinarioNodo<T> hijoDerecho = nodo.getPadre().getHojaDerecha();
 
        /*
         * Buscamos el hijo existente del nodo que queremos eliminar
         */
        ArbolBinarioNodo<T> hijoActual = nodo.getHojaIzquierda() != null ? 
                nodo.getHojaIzquierda() : nodo.getHojaDerecha();
 
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHojaIzquierda( hijoActual );
 
            /* Eliminando todas las referencias hacia el nodo */
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
 
            return true;
        }
 
        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha( hijoActual );
 
            /* Eliminando todas las referencias hacia el nodo */
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
 
            return true;
        } 
 
        return false;
    }
 
    private boolean removeNodoCaso3( ArbolBinarioNodo<T> nodo ) {
        /* Tomar el hijo derecho del Nodo que queremos eliminar */
        ArbolBinarioNodo<T> nodoMasALaIzquierda = recorrerIzquierda( nodo.getHojaDerecha() );
        if ( nodoMasALaIzquierda != null ) {
            /*
             * Reemplazamos el valor del nodo que queremos eliminar por el nodo que encontramos 
             */
            nodo.setValor( nodoMasALaIzquierda.getValor() );
            /* 
             * Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) 
             */
            removeNodo( nodoMasALaIzquierda );
            return true;
        }
        return false;
    }
 
    /* Recorrer de forma recursiva hasta encontrar el nodo más a la izquierda */
    private ArbolBinarioNodo<T> recorrerIzquierda(ArbolBinarioNodo<T> nodo) {
        if (nodo.getHojaIzquierda() != null) {
            return recorrerIzquierda( nodo.getHojaIzquierda() );
        }
        return nodo;
    }
 
}