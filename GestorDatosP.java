import java.io.*;

/**
 * Maneja la interaccion entre las estructuras de memoria dinamica: listas de peliculas y arboles de busqueda con listas de punteros
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorDatosP
{
    ListaPeliculasP listaPeliculas;
    ArbolP arbolCategorias; 

    /**
     * Constructor instancia la lista de peliculas vacia
     */
    public GestorDatosP(){
        this.listaPeliculas = new ListaPeliculasP();
    }

    /**
     * Cargar los datos de las peliculas desde un archivo csv
     * 
     * @param nombreArchivoPeliculas El nombre del archivo csv que contiene los datos de las peliculas
     */
    public void cargaDatos(String nombreArchivoPeliculas){
        try{
            // Abrir el archivo con los datos de las películas
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivoPeliculas));

            // Variable para leer cada linea del archivo
            String lineaCampos;

            // Leer cada linea del archivo
            while((lineaCampos = bufferedReader.readLine()) != null){
                String[] vectorCampos = lineaCampos.split(";");
                String showId = vectorCampos[0];
                String tipo = vectorCampos[1];
                String titulo = vectorCampos[2];
                String director = vectorCampos[3];
                String[] actores = vectorCampos[4].split(",");
                String paisProcedencia = vectorCampos[5];
                String fechaAgregacion = vectorCampos[6];
                String anoProduccion = vectorCampos[7];
                String audiencia = vectorCampos[8];
                String duracion = vectorCampos[9];
                String[] categorias = vectorCampos[10].split(",");
                String descripcion = vectorCampos[11];
                
                // Quitar los espacios en blanco al inicio y al final del string
                for(int i = 0; i < categorias.length; i++){
                    categorias[i] = categorias[i].trim();
                }
                
                // Quitar los espacios en blanco al inicio y al final del string
                for(int i = 0; i < actores.length; i++){
                    actores[i] = actores[i].trim();
                }

                // Crear el objeto pelicula
                PeliculaP pelicula = new PeliculaP(showId, tipo, titulo, director, actores, paisProcedencia, fechaAgregacion,
                                                    anoProduccion, audiencia, duracion, categorias, descripcion); 
                // Agregar la pelicula a la lista
                this.listaPeliculas.agrega(pelicula);

            }

            // Cerrar el archivo
            bufferedReader.close();
        } catch(IOException e){
            System.out.println("Error al leer archivo");
        }
    }

    /**
     * Crear el arbol de catergorias a partir de todas las categorias de las peliculas que se encuentran en la lista
     * 
     */
    public void creaArbolCategorias(){
        // Crear el arbol con una categoria que tienda a estar en el centro del alfabeto
        this.arbolCategorias = new ArbolP("Music & Musicals");
        
        // Leer todas las categorias de la lista de peliculas y agregarlas al arbol
        int tamannoLista = listaPeliculas.tamanno();
        for (int indice = 0; indice < tamannoLista; indice++){
            System.out.println();
            PeliculaP peliculaBuscada = listaPeliculas.peliculaEnPosicion(indice);
            String[] categoriasPeliculas = peliculaBuscada.categorias;
            for (int indiceCategoria = 0; indiceCategoria < categoriasPeliculas.length; indiceCategoria++){
                System.out.println(categoriasPeliculas[indiceCategoria]);
                arbolCategorias.agrega(categoriasPeliculas[indiceCategoria]);
            }
        }
    }
    
    /**
     * Crear el arbol de actores a partir del reparto de las peliculas que se encuentran en la lista
     * 
     */
    public void creaArbolActores(){
    }
    
    /**
     * Recorrer cada pelicula de la lista, sacar cada categoria, buscarla en el arbol de categorias, crear un puntero de la lista de punteros
     * hacia el objeto pelicula de la lista de peliculas.
     * 
     */
    public void creaPunterosCategorias(){
    }
    
        /**
     * Recorrer cada pelicula de la lista, sacar cada actor, buscarlo en el arbol de actores, crear un puntero de la lista de punteros
     * hacia el objeto pelicula de la lista de peliculas.
     * 
     */
    public void creaPunterosActores(){
    }
}
