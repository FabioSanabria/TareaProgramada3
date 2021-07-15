
/**
 * Write a description of class ListaPunterosP here.
 * 
 * @author (your name) 
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
}
