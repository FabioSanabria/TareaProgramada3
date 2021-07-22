
/**
 * Write a description of class ArbolActK here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolPA
{
    String actor;
    ArbolPA ramaIzquierda;
    Boolean usado;
    ArbolPA ramaDerecha;
    ListaPunterosP listaPunteros;
    /**
    * Constructor de la clase.
    */
    public ArbolPA(String valor){
        this.actor= valor;
        Boolean usado=false;
        this.ramaIzquierda=null;
        this.ramaDerecha=null;
        this.listaPunteros=null;
    }
    
    /**
     * Agregar un valor nuevo al arbol (Basado en los programas del curso)
     * @param valorNuevo El valor nuevo que se agregara al arbol
     */
    public void agrega(String valorNuevo){ 
        if (this.actor.compareToIgnoreCase(valorNuevo) < 0){                             
            if (this.ramaDerecha == null){
                this.ramaDerecha = new ArbolPA(valorNuevo);
            }else{
                ramaDerecha.agrega(valorNuevo);
            }
        }else{
            if ((this.actor.compareToIgnoreCase(valorNuevo) > 0) && (this.ramaIzquierda == null)){ 
                this.ramaIzquierda = new ArbolPA(valorNuevo);
            }else{
                if (this.actor.compareToIgnoreCase(valorNuevo) != 0)                     
                    this.ramaIzquierda.agrega(valorNuevo);
            }
        }
    }
    
    /**
     * Verifica si el actor existe.
     * @param actorQuerido verifica si es el acotr buscado.
     * @return retorna el actor buscado.
     */
    public boolean existeActor(String ActorQuerido){
        boolean existe = false;  //valor no existe
        if ((this.actor.equalsIgnoreCase(ActorQuerido))){
            existe = true;
        }
        else{
            if (ramaDerecha != null)
                ramaDerecha. existeActor(ActorQuerido);
            if (ramaIzquierda != null)
                ramaIzquierda. existeActor(ActorQuerido);
        }
        return existe;
    }
    
    /**
     * Agrega los punteros de la lista apuntador para buscar el acotr requerido.
     * @param puntero El puntero al objeto listaPunterosP.
     * @param actorQuerido verifica si es el acotr buscado.
     */
    public void agregaPunteros(ListaPunterosP apuntador, String ActorQuerido){
        if(existeActor(ActorQuerido) ){
            if(this.actor.equalsIgnoreCase(ActorQuerido)){
                usado = true;
                this.listaPunteros = apuntador;
            }
            else{
                if(ramaDerecha != null){
                    this.ramaDerecha.agregaPunteros(apuntador , ActorQuerido);       
                }
                if(ramaIzquierda != null){
                    this.ramaIzquierda.agregaPunteros(apuntador , ActorQuerido);    
                }
            }
        }
        else{
            System.out.println("Su actor es inexistente en este arbol, vuelva a intentar");
        }
    }
    
    /**
     * Imprimir el arbol en forma transversal (Basado en los programas del curso)
     * @return tiraArbol String con el contenido del arbol
     */
    public String imprime(String t){
        String tiraArbol = "";
        
        if (this.ramaDerecha != null){
            tiraArbol += this.ramaDerecha.imprime(t+"\t");
        }
        
        tiraArbol += t + this.actor + "\n";
        
        if (this.ramaIzquierda != null){
            tiraArbol += this.ramaIzquierda.imprime(t+"\t");
        }
        
        return tiraArbol;
    }
}
