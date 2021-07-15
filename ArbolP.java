
/**
 * Write a description of class ArbolP here.
 * 
 * @author (your name) 
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
    
}
