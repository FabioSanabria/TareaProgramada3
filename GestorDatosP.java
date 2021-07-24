import java.io.*;

/**
 * Maneja la interaccion entre las estructuras de memoria dinamica: listas de peliculas y arboles de busqueda con listas de punteros
 * 
 * @author (Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194) 
 * @version (a version number or a date)
 */
public class GestorDatosP
{
    ListaPeliculasP listaPeliculas;
    ArbolP arbolCategorias; 
    ArbolP arbolActores; 

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
     * Crear el arbol de categorias a partir de todas las categorias de las peliculas que se encuentran en la lista
     * 
     */
    public void creaArbolCategorias(){
        // Crear el arbol con una categoria que tienda a estar en el centro del alfabeto
        this.arbolCategorias = new ArbolP("Music & Musicals");

        // Leer todas las categorias de la lista de peliculas y agregarlas al arbol
        int tamannoLista = listaPeliculas.tamanno();
        for (int indice = 0; indice < tamannoLista; indice++){
            //System.out.println();
            PeliculaP peliculaBuscada = listaPeliculas.peliculaEnPosicion(indice);
            String[] categoriasPeliculas = peliculaBuscada.categorias;
            for (int indiceCategoria = 0; indiceCategoria < categoriasPeliculas.length; indiceCategoria++){
                //System.out.println(categoriasPeliculas[indiceCategoria]);
                this.arbolCategorias.agrega(categoriasPeliculas[indiceCategoria]);
            }
        }
    }

    /**
     * Crear el arbol de actores a partir del reparto de las peliculas que se encuentran en la lista
     * 
     */
    public void creaArbolActores(){
        // Crear el arbol con un actor que tienda a estar en el centro del alfabeto
        this.arbolActores = new ArbolP("Malcolm McDowell");

        // Leer todos los actores de la lista de peliculas y agregarlas al arbol
        int tamannoLista = listaPeliculas.tamanno();
        for (int indice = 0; indice < tamannoLista; indice++){
            //System.out.println();
            PeliculaP peliculaBuscada = listaPeliculas.peliculaEnPosicion(indice);
            String[] actoresPeliculas = peliculaBuscada.actores;
            for (int indiceActores = 0; indiceActores < actoresPeliculas.length; indiceActores++){
                //System.out.println(categoriasPeliculas[indiceCategoria]);
                this.arbolActores.agrega(actoresPeliculas[indiceActores]);
            }
        }    
    }

    /**
     * Recorrer cada pelicula de la lista, sacar cada categoria, buscarla en el arbol de categorias, crear un puntero de la lista de punteros
     * hacia el objeto listaPeliculasP.
     * 
     */
    public void creaPunterosCategorias(){
        // Recorrer toda la lista de peliculas
        ListaPeliculasP iteradorListaPeliculas = this.listaPeliculas;
        while(iteradorListaPeliculas != null){
            // Obtener una pelicula
            PeliculaP peliculaAsociada = iteradorListaPeliculas.pelicula;
            // Obtener el vector de categorias de la pelicula
            String[] categoriasPeliculas = peliculaAsociada.categorias;
            // Buscar cada categoria en el arbol de categorias y crear el puntero desde nodo de la categoria en el arbol
            // al nodo de la pelicula en la lista
            for (int indiceCategoria = 0; indiceCategoria < categoriasPeliculas.length; indiceCategoria++){
                this.arbolCategorias.enlazaConListaPeliculas(categoriasPeliculas[indiceCategoria],iteradorListaPeliculas);
            }
            // Mover al siguiente nodo
            iteradorListaPeliculas = iteradorListaPeliculas.siguiente;
        }

    }

    /**
     * Recorrer cada pelicula de la lista, sacar cada actor, buscarlo en el arbol de actores, crear un puntero de la lista de punteros
     * hacia el objeto pelicula de la lista de peliculas.
     * 
     */
    public void creaPunterosActores(){
        // Recorrer toda la lista de peliculas
        ListaPeliculasP iteradorListaPeliculas = this.listaPeliculas;
        while(iteradorListaPeliculas != null){
            // Obtener una pelicula
            PeliculaP peliculaAsociada = iteradorListaPeliculas.pelicula;
            // Obtener el vector de actores de la pelicula
            String[] actoresPeliculas = peliculaAsociada.actores;
            // Buscar cada actor en el arbol de actores y crear el puntero desde nodo del actor en el arbol
            // al nodo de la pelicula en la lista
            for (int indiceActores = 0; indiceActores < actoresPeliculas.length; indiceActores++){
                this.arbolActores.enlazaConListaPeliculas(actoresPeliculas[indiceActores],iteradorListaPeliculas);
            }
            // Mover al siguiente nodo
            iteradorListaPeliculas = iteradorListaPeliculas.siguiente;
        }
        
    }

    /**
     * Buscar y desplegar los datos de las peliculas que pertenecen a una categoria dada, 
     * buscando la categoria en el arbol de categorias y luego recorriendo la lista de punteros, 
     * donde cada nodo apunta a un nodo ListaPelicula que contiene la pelicula relacionada
     * 
     */
    public void consultaPeliculasCategoria(String categoria){

        // Buscar el nodo en el arbol de categorias que contiene la categoria buscada
        ArbolP nodoArbolBuscado = arbolCategorias.encuentraNodo(categoria);

        if (nodoArbolBuscado != null){
            // Recorrer la lista de punteros para llegar a cada nodo ListaPelicula e imprimir los datos de cada pelicula
            ListaPunterosP listaPunteros = nodoArbolBuscado.listaPunteros;
            int tamannoListaPunteros = listaPunteros.tamanno();
            for (int indice = 0; indice < tamannoListaPunteros; indice++){
                ListaPeliculasP puntero = listaPunteros.punteroEnPosicion(indice);
                System.out.print(puntero.pelicula.toString());
            }
        }else{
            System.out.print("Categoria inexistente");
        }

    }
    
    /**
     * Buscar y desplegar los datos de las peliculas que contienen al actor dado, 
     * buscando el actor en el arbol de actore y luego recorriendo la lista de punteros, 
     * donde cada nodo apunta a un nodo ListaPelicula que contiene la pelicula relacionada
     * 
     */
    public void consultaPeliculasActores(String actor){

        // Buscar el nodo en el arbol de actores que contiene al actor buscado
        ArbolP nodoArbolBuscado = arbolActores.encuentraNodo(actor);

        if (nodoArbolBuscado != null){
            // Recorrer la lista de punteros para llegar a cada nodo ListaPelicula e imprimir los datos de cada pelicula
            ListaPunterosP listaPunteros = nodoArbolBuscado.listaPunteros;
            int tamannoListaPunteros = listaPunteros.tamanno();
            for (int indice = 0; indice < tamannoListaPunteros; indice++){
                ListaPeliculasP puntero = listaPunteros.punteroEnPosicion(indice);
                System.out.print(puntero.pelicula.toString());
            }
        }else{
            System.out.print("Actor inexistente");
        }

    }
    
    /**
     * Reagrupar categorias en el arbol de categorias, creando un nuevo nodo en el arbol para la nueva categoria
     * y creano sus punteros a las peliculas que tienen alguna de las categorias seleccionadas.
     * 
     * @param nuevaCategoria El nombre de la nueva categoria que contendra a un grupo de categorias existentes
     * @param listaCategoriasPorAgrupar Lista con los nombres de las categorias que se reagruparan en la nueva categoria
     * 
     */
    public void reagrupaCategorias(String nuevaCategoria, Lista listaCategoriasPorAgrupar){
        // Agregar la nueva categoria al arbol de categorias
        this.arbolCategorias.agrega(nuevaCategoria);
        // Recorrer toda la lista de peliculas
        ListaPeliculasP iteradorListaPeliculas = this.listaPeliculas;
        while(iteradorListaPeliculas != null){
            // Obtener una pelicula
            PeliculaP peliculaAsociada = iteradorListaPeliculas.pelicula;
            // Obtener el vector de categorias de la pelicula
            String[] categoriasPeliculas = peliculaAsociada.categorias;
            // Para cada una de sus categorias verificar si es una categoria de la lista, de ser asi se crea un puntero a la pelicula
            for (int indiceCategoria = 0; indiceCategoria < categoriasPeliculas.length; indiceCategoria++){
                if (listaCategoriasPorAgrupar.exist(categoriasPeliculas[indiceCategoria])){
                    this.arbolCategorias.enlazaConListaPeliculas(nuevaCategoria,iteradorListaPeliculas);
                }    
            }
            // Mover al siguiente nodo
            iteradorListaPeliculas = iteradorListaPeliculas.siguiente;
        }
    }
}
