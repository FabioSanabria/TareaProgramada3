
/**
 * Clase Lista entregada por el profesor en el curso (modificada para manejar un valor String)
 */
public class Lista
{
   
    String valor;           //valor del nodo
    boolean usado;       //bandera de uso del nodo
    Lista next;          //direccion sigte nodo

    /**
     * Copiado del curso
     */
    public Lista(){
        usado=false;
        next =null;
    }

    /**
     * Copiado del curso
     */
    public Lista(String v){
        valor=v;
        usado=true;
        next =null;
    }
    
    /**
     * Copiado del curso
     */
    public void add(String v){ //append
        if (!usado) { //lista vacia
            valor=v;
            usado=true;
        }else{
            if (next == null){ //existia solo un valor
                next = new Lista(v);
            }else{
                //algoritmo recursivo
                next.add(v);
            }
        }
  
    }
    
    /**
     * Copiado del curso
     */
    public boolean exist(String v){
        boolean hallado = false;
        Lista iter = this;
        while ((!hallado) && (iter != null)){
            if (iter.valor.compareTo(v) == 0)
                hallado = true;
            iter = iter.next;
        }

        return hallado;
    } 
}
