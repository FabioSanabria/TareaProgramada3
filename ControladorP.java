import javax.swing.JOptionPane;

/**
 * Programa principal
 * 
 * @author (your name) 
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
    }
    
    /**
     * Imprimir el arbol de categorias
     */
    public void imprimeArbolCategorias(){
        System.out.println(gestorDatos.arbolCategorias.imprime("\t"));
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
                       "4.Ver el arbol de categorias\n5.Salir";
        int opcionDigitada;
        do{
            opcionDigitada = controlaMenu(1,5,menu);
            switch (opcionDigitada) {
                case 1: cargaPeliculas();
                break;
                case 2: imprimeLista();
                break;
                case 3: creaArbolCategorias();
                break;
                case 4: imprimeArbolCategorias();
                break;
                default:
            }
        }while(opcionDigitada != 5);
    }
    
    
    public static void main(){
        ControladorP controlador = new ControladorP();
        controlador.menuControlador();
    }
}
