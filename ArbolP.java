
/**
 * Write a description of class ArbolP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolP
{
    String categoria;
    ArbolP ramaIzquierda;
    Boolean usado;
    ArbolP ramaDerecha;
    ListaPunterosP listaPunteros;
    
    /**
     * Constructor crea la raiz del arbol
     */
    public ArbolP(String valor){
        this.categoria = valor;
        Boolean usado = false;
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
        if (this.categoria.compareToIgnoreCase(valorNuevo) < 0){                             
            if (this.ramaDerecha == null){
                this.ramaDerecha = new ArbolP(valorNuevo);
            }else{
                ramaDerecha.agrega(valorNuevo);
            }
        }else{
            if ((this.categoria.compareToIgnoreCase(valorNuevo) > 0) && (this.ramaIzquierda == null)){ 
                this.ramaIzquierda = new ArbolP(valorNuevo);
            }else{
                if (this.categoria.compareToIgnoreCase(valorNuevo) != 0)                     
                    this.ramaIzquierda.agrega(valorNuevo);
            }
        }
    }
    
    /**
     * Manda si el valor existe o no (Basado en los programas del curso)
     * 
     * @param categoriaQuerida: Categoria buscada en el arbol
     * @return existe: True si existe el valor, false si no existe
     */
    
    public boolean existeCategoria(String categoriaQuerida){
        boolean existe = false;  //valor no existe
        if ((this.categoria.equalsIgnoreCase(categoriaQuerida))){
            existe = true;
        }
        else{
            if (ramaDerecha != null)
                ramaDerecha. existeCategoria(categoriaQuerida);
            if (ramaIzquierda != null)
                ramaIzquierda. existeCategoria(categoriaQuerida);
        }
        return existe;
    }
    
    /**
     * Agrega un puntero a cada nodo del arbol(Basado en los programas del curso)
     * 
     * @param categoriaQuerida: Lugar donde se coloca el puntero
     * @param apuntador: Puntero que apunta a la lista punteros
     */
    public void agregaPunteros(ListaPunterosP apuntador, String categoriaQuerida){
            if(this.categoria.equalsIgnoreCase(categoriaQuerida)){
                usado = true;
                this.listaPunteros = apuntador;
            }
            else{
                if(ramaDerecha != null){
                    this.ramaDerecha.agregaPunteros(apuntador , categoriaQuerida);       
                }
                if(ramaIzquierda != null){
                    this.ramaIzquierda.agregaPunteros(apuntador , categoriaQuerida);    
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
            tiraArbol += this.ramaDerecha.imprime(t+" \t");
        }
        
        tiraArbol += t + this.categoria + "\n";
        
        if (this.ramaIzquierda != null){
            tiraArbol += this.ramaIzquierda.imprime(t+"\t");
        }
        
        return tiraArbol;
    }
}
