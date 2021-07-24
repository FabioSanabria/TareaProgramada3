import javax.swing.JOptionPane;

/**
 * Programa principal
 * 
 * @author (Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194) 
 * @version (a version number or a date)
 */
public class ControladorP
{
    GestorDatosP gestorDatos;
    
    /**
     * Constructor instancia el gestor de datos
     */
    public ControladorP(){
        this.gestorDatos = new GestorDatosP();
    }
    
    /**
     * Activar el cargador de datos 
     */
    public void cargaPeliculas(){
        String nombreArchivoPeliculas = "peliculas.csv";
        this.gestorDatos.cargaDatos(nombreArchivoPeliculas);
    }
    
    /**
     * Imprimir la lista de peliculas completa 
     */
    public void imprimeLista(){
        System.out.println(gestorDatos.listaPeliculas.imprime());
    }
    
    /**
     * Crear el arbol de categorias
     */
    public void creaArbolCategorias(){
        gestorDatos.creaArbolCategorias();
        gestorDatos.creaPunterosCategorias();
    }
    
    /**
     * Crear el arbol de actores
     */
    public void creaArbolActores(){
        gestorDatos.creaArbolActores();
        gestorDatos.creaPunterosActores();
    }
    
    /**
     * Imprimir el arbol de categorias
     */
    public void imprimeArbolCategorias(){
        System.out.println(gestorDatos.arbolCategorias.imprime("\t"));
    }
    
    /**
     * Imprimir el arbol de actores
     */
    public void imprimeArbolActores(){
        System.out.println(gestorDatos.arbolActores.imprime("\t"));
    }
    
    /**
     * Imprimir los datos de las peliculas que pertenecen a una categoria dada por el usuario
     */
    public void imprimePeliculasCategoria(){
        String categoria = JOptionPane.showInputDialog("Digite la categoria para la búsqueda");
        gestorDatos.consultaPeliculasCategoria(categoria);
    }
    
    /**
     * Imprimir los datos de las peliculas que pertenecen a un actor dado por el usuario
     */
    public void imprimePeliculasActores(){
        String actor = JOptionPane.showInputDialog("Digite al actor para la búsqueda");
        gestorDatos.consultaPeliculasActores(actor);
    }
    
    /**
     * Validar los números digitados por un usuario
     */
    public int leeNumeroValido(String mensaje){
        int numeroValido = -1;
        boolean esNumeroValido = false;
        do{
            try {
                numeroValido = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                esNumeroValido = true;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe dar número válido");
            }
        }while(!esNumeroValido);
        return numeroValido;
    }
    
    /**
     * Reagrupa varias categorias en una nueva
     */
    public void reagrupaCategorias(){
        String nuevaCategoria = JOptionPane.showInputDialog("Digite el nombre de la nueva categoria");
        int cantidadCategorias = leeNumeroValido("Digite la cantidad de categoria por reagrupar");
        Lista listaCategoriasPorAgrupar = new Lista();
        for (int i = 0; i < cantidadCategorias; i++){
            String categoria = JOptionPane.showInputDialog("Digite el nombre de una categoria valida");
            listaCategoriasPorAgrupar.add(categoria);
        }
        gestorDatos.reagrupaCategorias(nuevaCategoria, listaCategoriasPorAgrupar);
    }
    
    /**
     * Controla que las opciones de un menú sean válidas
     * 
     * @param valorMenor El valor menor de las opciones
     * @param valorMayor El valor mayor de las opciones
     * @param menu El menu
     * @return opcionDigitada La opción válida digitada por el usuario
     * 
     */
    public int controlaMenu(int valorMenor, int valorMayor, String menu){
        int opcionDigitada=-1;
        boolean opcionValida;   
        do{
            opcionValida=false; 
            try{
                opcionDigitada = Integer.parseInt(JOptionPane.showInputDialog(menu + "\nValor debe estar entre [" + 
                        valorMenor + "," + valorMayor + "] ?"));
                if ((opcionDigitada >= valorMenor) && (opcionDigitada <= valorMayor)){
                    opcionValida = true;   
                }else{
                    JOptionPane.showMessageDialog(null, "Valor fuera de rango. Intente de nuevo");
                }
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe dar número válido");
            }
        } while (!opcionValida);
        return opcionDigitada;
    }
    
    /**
     * Controla el menú del programa
     */
    public void menuControlador(){
        String menu = "1.Cargar datos de peliculas desde archivo\n2.Ver la lista de peliculas\n3.Crear al arbol de categorias\n" + 
                       "4.Crear al arbol de actores\n5.Ver el arbol de categorias\n6.Ver el arbol de actores\n" +
                       "7.Visualizar peliculas de una categoria dada\n8.Visualizar peliculas de un actor dado\n" + 
                       "9.Reagrupar categorias\n10.Salir";
        int opcionDigitada;
        do{
            opcionDigitada = controlaMenu(1,10,menu);
            switch (opcionDigitada) {
                case 1: cargaPeliculas();
                break;
                case 2: imprimeLista();
                break;
                case 3: creaArbolCategorias();
                break;
                case 4: creaArbolActores();
                break;
                case 5: imprimeArbolCategorias();
                break;
                case 6: imprimeArbolActores();
                break;
                case 7: imprimePeliculasCategoria();
                break;
                case 8: imprimePeliculasActores();
                break;
                case 9: reagrupaCategorias();
                break;
                default:
            }
        }while(opcionDigitada != 10);
    }
    
    
    public static void main(){
        ControladorP controlador = new ControladorP();
        controlador.menuControlador();
    }
}
