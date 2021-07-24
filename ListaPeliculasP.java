
/**
 * Maneja una lista simple cuyo nodo contiene un objeto pelicula
 * 
 * @author (Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194) 
 * @version (a version number or a date)
 */
public class ListaPeliculasP
{
    PeliculaP pelicula;
    Boolean usado;
    ListaPeliculasP siguiente;
    
    /**
     * Constructor de una la lista vacía
     */
    public ListaPeliculasP(){
        this.pelicula = null;
        this.usado = false;
        this.siguiente = null;
    }
    
    /**
     * Constructor de la lista que recibe un objeto pelicula
     * 
     * @param pelicula El objeto que contiene los datos de la película
     */
    public ListaPeliculasP(PeliculaP pelicula){
        this.pelicula = pelicula;
        this.usado = true;
        this.siguiente = null;
    }
    
    /**
     * Agregar una película a la lista (Basado en los programas del curso)
     * 
     * @param pelicula El objeto que contiene los datos de la película
     */
    public void agrega(PeliculaP pelicula){
        // Si la lista esta vacia
        if (!this.usado){  
            this.usado = true;
            this.pelicula = pelicula;
            this.siguiente = null;
        }else{
            // Si es solo un nodo
            if (this.siguiente == null){ 
                this.siguiente = new ListaPeliculasP(pelicula);
            }else{
                // Si son muchos nodos
                this.siguiente.agrega(pelicula);
            }
        }
    }
    
    /**
     * Imprimir la lista de peliculas
     * 
     * @return  Lista de peliculas
     */
    public String imprime(){
        // Si la lista esta vacia
        if (!this.usado)
            return "";
        else
        if (this.siguiente == null){
            // Si es solo un nodo
            return this.pelicula.toString() + "\n\n";
        }
        else {
            // Si son muchos nodos
            return this.pelicula.toString() + "\n\n" + this.siguiente.imprime();
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
     * Buscar el objeto pelicula que esta en una posicion dada (Basado en los programas del curso)
     * 
     * @param posicion La posicion en que se encuentra al objecto buscado
     * @return  peliculaBuscada El objeto pelicula que se encuentra en la posicion indicada
     */
    public PeliculaP peliculaEnPosicion(int posicion){
        int posicionInicial = 0;
        ListaPeliculasP iterador = this;
        PeliculaP peliculaBuscada = null;
        boolean encontrado = false;
        while(!encontrado){
            if(posicionInicial == posicion){
                encontrado = true;
                peliculaBuscada = iterador.pelicula;
            }else{
                iterador = iterador.siguiente;
                posicionInicial++;
            }
        }

        return peliculaBuscada;
    }
}
