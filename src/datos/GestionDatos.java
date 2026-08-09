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

    /*
    // ==========================================
    //    Metodo Busqueda Evaluar Duplicados
    // ==========================================
     */
    public Propietario buscarPropietario(String cedula) {
        for (Propietario p : listaPropietario) {
            if (p.getCedPropietario().equalsIgnoreCase(cedula)) {
                return p; // Lo encontró
            }
        }
        return null; // No existe
    }

    public Inquilino buscarInquilino(int cedula) {
        for (Inquilino inq : listaInquilino) {
            if (inq.getCedInqui() == cedula) {
                return inq; // Lo encontró, devuelve el objeto
            }
        }
        return null; // No lo encontró
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

    /*
    //==============================================
    //        Metodos Para Agregar
    //==============================================
    */
    public boolean agregarPropietario(Propietario p) {
        // Recorremos la lista para ver si ya existe la cédula
        for (Propietario prop : listaPropietario) {
            if (prop.getCedPropietario().equalsIgnoreCase(p.getCedPropietario())) {
                return false; // Ya existe, no lo agregamos
            }
        }
        listaPropietario.add(p);
        return true; // Se agregó con éxito
    }

    public boolean agregarInquilino(Inquilino i) {
        for (Inquilino inq : listaInquilino) {
            if (inq.getCedInqui() == i.getCedInqui()) {
                return false;
            }
        }
        listaInquilino.add(i);
        return true;
    }
    
    
    public boolean agregarVivienda(Vivienda v) {
        for (Vivienda viv : listaVivienda) {
            if (viv.getIdVivienda() == v.getIdVivienda()) {
                return false;
            }
        }
        listaVivienda.add(v);
        return true;
    }
    
    

}
