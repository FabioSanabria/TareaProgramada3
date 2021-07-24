
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
        tiraDatos += "  Director: " + this.director + "\n";
        tiraDatos += "  Actores: ";
        for(String  actor:this.actores){
            tiraDatos += ", "+ actor ;
        } 
        tiraDatos += "\n";
        tiraDatos += "  Pais: " + this.paisProcedencia + "\n";
        tiraDatos += "  Fecha: " + this.fechaAgregacion + "\n";
        tiraDatos += "  Año: " + this.anoProduccion + "\n";
        tiraDatos += "  Audiencia: " + this.audiencia + "\n";
        tiraDatos += "  Duracion: " + this.duracion + "\n";
        tiraDatos += "  Categorias: ";
        for(String  categoria:this.categorias){
            tiraDatos += ", " + categoria;
        } 
        tiraDatos += "\n";
        tiraDatos += "  Descripcion: " + this.descripcion + "\n\n";
        
        return tiraDatos;
    }
}
