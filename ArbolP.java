
/**
 * Write a description of class ArbolP here.
 * 
 * @author (Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194) 
 * @version (a version number or a date)
 */
public class ArbolP
{
    String valor;
    ArbolP ramaIzquierda;
    ArbolP ramaDerecha;
    ListaPunterosP listaPunteros;

    /**
     * Constructor crea la raiz del arbol
     */
    public ArbolP(String valor){
        this.valor = valor;
        this.ramaIzquierda = null;
        this.ramaDerecha = null;
        this.listaPunteros = null;
    }

    /**
     * Agregar un valor nuevo al arbol (Basado en los programas del curso)
     * 
     * @param valorNuevo El valor nuevo que se agregara al arbol
     */
    public void agrega(String valorNuevo){ 
        if (this.valor.compareToIgnoreCase(valorNuevo) < 0){                             
            if (this.ramaDerecha == null){
                this.ramaDerecha = new ArbolP(valorNuevo);
            }else{
                ramaDerecha.agrega(valorNuevo);
            }
        }else{
            if ((this.valor.compareToIgnoreCase(valorNuevo) > 0) && (this.ramaIzquierda == null)){ 
                this.ramaIzquierda = new ArbolP(valorNuevo);
            }else{
                if (this.valor.compareToIgnoreCase(valorNuevo) != 0)                     
                    this.ramaIzquierda.agrega(valorNuevo);
            }
        }
    }

    /**
     * Imprimir el arbol en forma transversal (Basado en los programas del curso)
     * 
     * @return tiraArbol String con el contenido del arbol
     */
    public String imprime(String t){
        String tiraArbol = "";

        if (this.ramaDerecha != null){
            tiraArbol += this.ramaDerecha.imprime(t+"\t");
        }

        tiraArbol += t + this.valor + "\n";

        if (this.ramaIzquierda != null){
            tiraArbol += this.ramaIzquierda.imprime(t+"\t");
        }

        return tiraArbol;
    }

    /**
     * Encuentra el nodo del arbol que contiene el valor buscado (una categoria o un actor)
     * 
     * @param valorBuscado El nombre de la categoria o actor buscado
     * @return nodoArbolBuscado El nodo del arbol que contiene el valor buscado
     * 
     */
    public ArbolP encuentraNodo(String valorBuscado){
        ArbolP nodoArbolBuscado = null;
        boolean encontrado = false;

        if (this.valor.compareToIgnoreCase(valorBuscado) == 0){ //se encontro el valor buscado
            nodoArbolBuscado = this;
            encontrado = true;
        }
        else{
            if (this.valor.compareToIgnoreCase(valorBuscado) < 0){ //deberia estar en rama derecha
                if (ramaDerecha != null)
                    nodoArbolBuscado = ramaDerecha.encuentraNodo(valorBuscado);
            }else{
                if (ramaIzquierda !=null)//deberia estar en rama izquierda
                    nodoArbolBuscado = ramaIzquierda.encuentraNodo(valorBuscado);
            }
        }

        return nodoArbolBuscado;
    }

    /**
     * Enlazar el nodo con el valorBuscado (categoria o actor) con el nodo de la ListaPelicula que lo contiene, usando la lista de punteros
     * 
     * @param valorBuscado El nombre de la categoria o actor que se desea enlazar desde el arbol a la pelicula
     * @param peliculaAsociada El nodo de la ListaPelicula que se desea asociar con la categoria o actor
     * 
     */
    public void enlazaConListaPeliculas(String valorBuscado, ListaPeliculasP nodoListaPelicula){
        // Encontrar al nodo del arbol que contiene la categoria o actor
        ArbolP nodoArbolBuscado = encuentraNodo(valorBuscado);
        if (nodoArbolBuscado.listaPunteros == null){
            nodoArbolBuscado.listaPunteros = new ListaPunterosP();
            nodoArbolBuscado.listaPunteros.agrega(nodoListaPelicula);
        }else{
            if(!nodoArbolBuscado.listaPunteros.existePuntero(nodoListaPelicula)){
                nodoArbolBuscado.listaPunteros.agrega(nodoListaPelicula);
            }
        }
    }
}
