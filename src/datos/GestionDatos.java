package datos;

import java.util.ArrayList;

/**
 *
 * @author Graciela_Hanna_Fiorella
 */
public class GestionDatos {

    private ArrayList<Propietario> listaPropietario;
    private ArrayList<Inquilino> listaInquilino;
    private ArrayList<Vivienda> listaVivienda;
    private ArrayList<Alquileres> listaAlquiler;
    private ArrayList<Mensualidades> listaMen;

    public GestionDatos() {
        listaPropietario = new ArrayList<>();
        listaInquilino = new ArrayList<>();
        listaVivienda = new ArrayList<>();
        listaAlquiler = new ArrayList<>();
        listaMen = new ArrayList<>();

    }

    // ==========================================
    // Metodo Busqueda Evaluar Duplicados
    // ==========================================
    
    
    //Buscar proper x ced
    
    public Propietario buscarPropietario(String cedula){
        for(Propietario p : listaPropietario){
          if(p.getCedPropietario().equalsIgnoreCase(cedula)){
              return p;
          }  
        }
        return null;// No lo encuentra
    }
    
    //Buscar Vivienda x ID
    public Vivienda buscarVivienda(int id) {
        for (Vivienda v : listaVivienda) {
            if (v.getIdVivienda() == id) {
                return v;
            }
        }
        return null;
    }
    
    //Buscar Alquiler x num
    public Alquileres buscarAlquiler(int num) {
        for (Alquileres a : listaAlquiler) {
            if (a.getNumAlquiler() == num) {
                return a;
            }
        }
        return null;
    }
    
    //Metodos para agregar
    public boolean agregarPropietario(Propietario p) {
        if (buscarPropietario(p.getCedPropietario()) == null) {
            listaPropietario.add(p);
            return true; // Agregado con éxito
        }
        return false; // Cédula duplicada
    }
    
    
    
    
    
}
