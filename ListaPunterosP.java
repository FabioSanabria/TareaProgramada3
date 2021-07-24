
/**
 * Write a description of class ListaPunterosP here.
 * 
 * @author (Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194) 
 * @version (a version number or a date)
 */
public class ListaPunterosP
{
    ListaPeliculasP puntero;
    ListaPunterosP siguiente;
    boolean usado;

    /**
     * Constructor de una la lista vacía
     */
    public ListaPunterosP(){
        this.puntero = null;
        this.usado = false;
        this.siguiente = null;
    }

    /**
     * Constructor de la lista que recibe un objeto listaPeliculaP
     * 
     * @param puntero El puntero al objeto listaPeliculasP
     */
    public ListaPunterosP(ListaPeliculasP puntero){
        this.puntero = puntero;
        this.usado = true;
        this.siguiente = null;
    }

    /**
     * Verificar si un puntero ya esta en la lista de punteros (Basado en los programas del curso)
     * 
     * @param puntero El puntero al objeto ListaPeliculasP
     * @param hallado La variable booleana con la respuesta
     */
    public boolean existePuntero(ListaPeliculasP puntero){
        boolean hallado = false;
        ListaPunterosP iter= this;

        while ((!hallado) && (iter.siguiente != null)){
            if (iter.puntero == puntero)
                hallado = true;
            iter=iter.siguiente;
        }

        return hallado;
    }

    /**
     * Agregar un puntero a la lista (Basado en los programas del curso)
     * 
     * @param puntero El puntero al objeto listaPeliculasP
     */
    public void agrega(ListaPeliculasP puntero){
        // Si la lista esta vacia
        if (!this.usado){  
            this.usado = true;
            this.puntero = puntero;
            this.siguiente = null;
        }else{
            // Si es solo un nodo
            if (this.siguiente == null){ 
                this.siguiente = new ListaPunterosP(puntero);
            }else{
                // Si son muchos nodos
                this.siguiente.agrega(puntero);
            }

        }
    }
    
    /**
     * Calcular el tamaño de la lista  (Basado en los programas del curso)
     * 
     * @return  El tamaño de la lista
     */
    public int tamanno(){
        if (this.siguiente != null)
            return 1 + this.siguiente.tamanno();
        else
            return 1;
    }
    
    /**
     * Buscar el objeto ListaPelicula que esta en una posicion dada (Basado en los programas del curso)
     * 
     * @param posicion La posicion en que se encuentra al objecto buscado
     * @return  listaPeliculaBuscada El objeto ListaPelicula que se encuentra en la posicion indicada
     */
    public ListaPeliculasP punteroEnPosicion(int posicion){
        int posicionInicial = 0;
        ListaPunterosP iterador = this;
        ListaPeliculasP punteroBuscado = null;
        boolean encontrado = false;
        while(!encontrado){
            if(posicionInicial == posicion){
                encontrado = true;
                punteroBuscado = iterador.puntero;
            }else{
                iterador = iterador.siguiente;
                posicionInicial++;
            }
        }

        return punteroBuscado;
    }
}
