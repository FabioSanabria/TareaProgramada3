
/**
 * Maneja los datos o atributos de una pelicula
 * 
 * @author (Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194) 
 * @version (a version number or a date)
 */
public class PeliculaP
{
    // Atributos del archivo de Netflix
    String showId;
    String tipo;
    String titulo;
    String director;
    String[] actores;
    String paisProcedencia;
    String fechaAgregacion;
    String anoProduccion;
    String audiencia;
    String duracion;
    String[] categorias;
    String descripcion;

    /**
     * Constructor de la clase Pelicula
     * @param showId El identificador de la pelicula
     */
    public PeliculaP(String showId, String tipo, String titulo, String director, String[] actores,  String paisProcedencia, 
    String fechaAgregacion, String anoProduccion, String audiencia, String duracion, String[] categorias, String descripcion){
        this.showId = showId;
        this.tipo = tipo;
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.paisProcedencia = paisProcedencia;
        this.fechaAgregacion = fechaAgregacion;
        this.anoProduccion = anoProduccion;
        this.audiencia = audiencia;
        this.duracion = duracion;
        this.categorias = categorias;
        this.descripcion = descripcion;
    }
    
    
    /**
     * Imprimir los datos de una pelicula
     * 
     * @return tiraDatos String con los datos de una pel
     */
    public String toString(){
        String tiraDatos = "";
        tiraDatos += "Id: " + this.showId + "\n";
        tiraDatos += "  Tipo: " + this.tipo + "\n";
        tiraDatos += "  Titulo: " + this.titulo + "\n";
        // tiraDatos +=this.director = director;
        tiraDatos += "  Actores:\n";
        for(String  actor:this.actores){
            tiraDatos += "    " + actor + "\n";
        } 
        // tiraDatos +=this.paisProcedencia = paisProcedencia;
        // tiraDatos +=this.fechaAgregacion = fechaAgregacion;
        // tiraDatos +=this.anoProduccion = anoProduccion;
        // tiraDatos +=this.audiencia = audiencia;
        // tiraDatos +=this.duracion = duracion;
        tiraDatos += "  Categorias:\n";
        for(String  categoria:this.categorias){
            tiraDatos += "    " + categoria + "\n";
        } 
        // tiraDatos +=this.categorias = categorias;
        // tiraDatos +=this.descripcion = descripcion;
        
        return tiraDatos;
    }
}
