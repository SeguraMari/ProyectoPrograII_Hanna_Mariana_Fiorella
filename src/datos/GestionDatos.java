package datos;

import clases.Alquileres;
import clases.Inquilino;
import clases.Mensualidades;
import clases.Propietario;
import clases.Vivienda;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Centraliza el almacenamiento y las operaciones básicas sobre los datos del
 * sistema GuanaRent: propietarios, inquilinos, viviendas, alquileres y
 * mensualidades.
 *
 * @author
 * @author
 * @author
 */




// PASO 1: Se crea la clase
public class GestionDatos {

   
    // PASO 2: Se crean los atributos
    private ArrayList<Propietario> listaPropietario;
    private ArrayList<Inquilino> listaInquilino;
    private ArrayList<Vivienda> listaVivienda;
    private ArrayList<Alquileres> listaAlquiler;
    private ArrayList<Mensualidades> listaMen;

    // PASO 3: Se crean los constructores
    /**
     * Constructor vacío de la clase. Inicializa las cinco listas de datos.
     */
    public GestionDatos() {
        listaPropietario = new ArrayList<>();
        listaInquilino = new ArrayList<>();
        listaVivienda = new ArrayList<>();
        listaAlquiler = new ArrayList<>();
        listaMen = new ArrayList<>();
    }

    // PASO 4: Se crean los métodos get y set
    /**
     * Obtiene la lista completa de propietarios.
     *
     * @return lista de propietarios.
     */
    public ArrayList<Propietario> obtenerPropietarios() {
        return listaPropietario;
    }

    /**
     * Obtiene la lista completa de inquilinos.
     *
     * @return lista de inquilinos.
     */
    public ArrayList<Inquilino> obtenerInquilinos() {
        return listaInquilino;
    }

    /**
     * Obtiene la lista completa de viviendas.
     *
     * @return lista de viviendas.
     */
    public ArrayList<Vivienda> obtenerViviendas() {
        return listaVivienda;
    }

    /**
     * Obtiene la lista completa de alquileres.
     *
     * @return lista de alquileres.
     */
    public ArrayList<Alquileres> obtenerAlquileres() {
        return listaAlquiler;
    }

    /**
     * Obtiene la lista completa de mensualidades.
     *
     * @return lista de mensualidades.
     */
    public ArrayList<Mensualidades> obtenerMensualidades() {
        return listaMen;
    }

    // PASO 5: Se crean los métodos de clase

    // ==========================================
    //   Propietario: buscar, agregar, modificar, eliminar
    // ==========================================
    /**
     * Busca un propietario por su cédula.
     *
     * @param cedula cédula del propietario a buscar.
     * @return el propietario encontrado, o {@code null} si no existe.
     */
    public Propietario buscarPropietario(int cedula) {
        for (Propietario p : listaPropietario) {
            if (p.getCedPropiet() == cedula) {
                return p; // Lo encontró
            }
        }
        return null; // No existe
    }

    /**
     * Agrega un propietario si su cédula no está registrada previamente.
     *
     * @param p propietario a agregar.
     * @return {@code true} si se agregó con éxito; {@code false} si ya existía.
     */
    public boolean agregarPropietario(Propietario p) {
        // Recorremos la lista para ver si ya existe la cédula
        for (Propietario prop : listaPropietario) {
            if (prop.getCedPropiet() == p.getCedPropiet()) {
                return false; // Ya existe, no lo agregamos
            }
        }
        listaPropietario.add(p);
        return true; // Se agregó con éxito
    }

    /**
     * Modifica los datos de un propietario existente, localizado por su
     * cédula original. Si la cédula cambia, valida que la nueva cédula no
     * esté siendo usada por otro propietario. El objeto existente se
     * actualiza mediante sus setters (no se reemplaza la referencia), para
     * preservar la relación {@code Vivienda.propietario} de cualquier
     * vivienda que ya apunte a este propietario.
     *
     * @param cedPropietario cédula original del propietario a modificar.
     * @param datosNuevos objeto con los datos nuevos a aplicar.
     * @return {@code true} si se modificó con éxito; {@code false} si el
     * propietario no existe o si la nueva cédula ya pertenece a otro
     * propietario.
     */
    public boolean modificarPropietario(int cedPropietario, Propietario datosNuevos) {
        Propietario actual = buscarPropietario(cedPropietario);
        if (actual == null) {
            return false; // No existe el propietario a modificar
        }
        int nuevaCedula = datosNuevos.getCedPropiet();
        if (nuevaCedula != cedPropietario) {
            Propietario colision = buscarPropietario(nuevaCedula);
            if (colision != null) {
                return false; // La nueva cédula ya pertenece a otro propietario
            }
        }
        actual.setCedPropiet(datosNuevos.getCedPropiet());
        actual.setNomPropiet(datosNuevos.getNomPropiet());
        actual.setGenero(datosNuevos.getGenero());
        actual.setDireccion(datosNuevos.getDireccion());
        actual.setTelefono(datosNuevos.getTelefono());
        actual.setEmail(datosNuevos.getEmail());
        return true;
    }

    /**
     * Elimina un propietario, siempre que no tenga viviendas asociadas.
     *
     * @param cedPropietario cédula del propietario a eliminar.
     * @return {@code true} si se eliminó con éxito; {@code false} si no
     * existe o si tiene al menos una vivienda asociada.
     */
    public boolean eliminarPropietario(int cedPropietario) {
        Propietario actual = buscarPropietario(cedPropietario);
        if (actual == null) {
            return false; // No existe
        }
        for (Vivienda v : listaVivienda) {
            if (v.getPropietario() == actual) {
                return false; // Tiene viviendas asociadas, no se puede eliminar
            }
        }
        listaPropietario.remove(actual);
        return true;
    }

    // ==========================================
    //   Inquilino: buscar, agregar, modificar, eliminar
    // ==========================================
    /**
     * Busca un inquilino por su cédula.
     *
     * @param cedula cédula del inquilino a buscar.
     * @return el inquilino encontrado, o {@code null} si no existe.
     */
    public Inquilino buscarInquilino(int cedula) {
        for (Inquilino inq : listaInquilino) {
            if (inq.getCedInqui() == cedula) {
                return inq; // Lo encontró, devuelve el objeto
            }
        }
        return null; // No lo encontró
    }

    /**
     * Agrega un inquilino si su cédula no está registrada previamente.
     *
     * @param i inquilino a agregar.
     * @return {@code true} si se agregó con éxito; {@code false} si ya existía.
     */
    public boolean agregarInquilino(Inquilino i) {
        for (Inquilino inq : listaInquilino) {
            if (inq.getCedInqui() == i.getCedInqui()) {
                return false;
            }
        }
        listaInquilino.add(i);
        return true;
    }

    /**
     * Modifica los datos de un inquilino existente, localizado por su cédula
     * original. Si la cédula cambia, valida que la nueva cédula no esté
     * siendo usada por otro inquilino. El objeto existente se actualiza
     * mediante sus setters (no se reemplaza la referencia), para preservar
     * la relación {@code Alquileres.inquilino} de cualquier alquiler que ya
     * apunte a este inquilino.
     *
     * @param cedInqui cédula original del inquilino a modificar.
     * @param datosNuevos objeto con los datos nuevos a aplicar.
     * @return {@code true} si se modificó con éxito; {@code false} si el
     * inquilino no existe o si la nueva cédula ya pertenece a otro inquilino.
     */
    public boolean modificarInquilino(int cedInqui, Inquilino datosNuevos) {
        Inquilino actual = buscarInquilino(cedInqui);
        if (actual == null) {
            return false; // No existe el inquilino a modificar
        }
        int nuevaCedula = datosNuevos.getCedInqui();
        if (nuevaCedula != cedInqui) {
            Inquilino colision = buscarInquilino(nuevaCedula);
            if (colision != null) {
                return false; // La nueva cédula ya pertenece a otro inquilino
            }
        }
        actual.setCedInqui(datosNuevos.getCedInqui());
        actual.setNomInqui(datosNuevos.getNomInqui());
        actual.setGenero(datosNuevos.getGenero());
        actual.setFechNac(datosNuevos.getFechNac());
        actual.setDireccion(datosNuevos.getDireccion());
        actual.setTelefono(datosNuevos.getTelefono());
        actual.setEmail(datosNuevos.getEmail());
        actual.setOcupacion(datosNuevos.getOcupacion());
        return true;
    }

    /**
     * Elimina un inquilino, siempre que no tenga alquileres asociados.
     *
     * @param cedInqui cédula del inquilino a eliminar.
     * @return {@code true} si se eliminó con éxito; {@code false} si no
     * existe o si tiene al menos un alquiler asociado.
     */
    public boolean eliminarInquilino(int cedInqui) {
        Inquilino actual = buscarInquilino(cedInqui);
        if (actual == null) {
            return false; // No existe
        }
        for (Alquileres a : listaAlquiler) {
            if (a.getInquilino() == actual) {
                return false; // Tiene alquileres asociados, no se puede eliminar
            }
        }
        listaInquilino.remove(actual);
        return true;
    }

    // ==========================================
    //   Vivienda: buscar, agregar, modificar, eliminar
    // ==========================================
    /**
     * Busca una vivienda por su identificador.
     *
     * @param id identificador de la vivienda a buscar.
     * @return la vivienda encontrada, o {@code null} si no existe.
     */
    public Vivienda buscarVivienda(int id) {
        for (Vivienda v : listaVivienda) {
            if (v.getIdVivienda() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Agrega una vivienda si su identificador no está registrado previamente
     * y su propietario ya existe en el registro de propietarios.
     *
     * @param v vivienda a agregar.
     * @return {@code true} si se agregó con éxito; {@code false} si el
     * identificador ya existía o si el propietario asociado no está
     * registrado.
     */
    public boolean agregarVivienda(Vivienda v) {
        for (Vivienda viv : listaVivienda) {
            if (viv.getIdVivienda() == v.getIdVivienda()) {
                return false;
            }
        }
        if (v.getPropietario() == null
                || buscarPropietario(v.getPropietario().getCedPropiet()) == null) {
            return false; // El propietario asociado no existe en el registro
        }
        listaVivienda.add(v);
        return true;
    }

    /**
     * Modifica los datos de una vivienda existente, localizada por su
     * identificador original. Si el identificador cambia, valida que el
     * nuevo identificador no esté siendo usado por otra vivienda. Si el
     * propietario cambia, valida que el nuevo propietario exista en el
     * registro de propietarios. El objeto existente se actualiza mediante
     * sus setters (no se reemplaza la referencia), para preservar la
     * relación {@code Alquileres.vivienda} de cualquier alquiler que ya
     * apunte a esta vivienda.
     *
     * @param idVivienda identificador original de la vivienda a modificar.
     * @param datosNuevos objeto con los datos nuevos a aplicar.
     * @return {@code true} si se modificó con éxito; {@code false} si la
     * vivienda no existe, si el nuevo identificador ya pertenece a otra
     * vivienda, o si el nuevo propietario no está registrado.
     */
    public boolean modificarVivienda(int idVivienda, Vivienda datosNuevos) {
        Vivienda actual = buscarVivienda(idVivienda);
        if (actual == null) {
            return false; // No existe la vivienda a modificar
        }
        int nuevoId = datosNuevos.getIdVivienda();
        if (nuevoId != idVivienda) {
            Vivienda colision = buscarVivienda(nuevoId);
            if (colision != null) {
                return false; // El nuevo id ya pertenece a otra vivienda
            }
        }
        if (datosNuevos.getPropietario() == null
                || buscarPropietario(datosNuevos.getPropietario().getCedPropiet()) == null) {
            return false; // El propietario asociado no está registrado
        }
        actual.setIdVivienda(datosNuevos.getIdVivienda());
        actual.setDescripcion(datosNuevos.getDescripcion());
        actual.setDireccion(datosNuevos.getDireccion());
        actual.setMtsConstruct(datosNuevos.getMtsConstruct());
        actual.setMtsLote(datosNuevos.getMtsLote());
        actual.setTipoConstruccion(datosNuevos.getTipoConstruccion());
        actual.setCochera(datosNuevos.isCochera());
        actual.setCantHabitac(datosNuevos.getCantHabitac());
        actual.setCantBanios(datosNuevos.getCantBanios());
        actual.setCarretera(datosNuevos.getCarretera());
        actual.setPrecioBase(datosNuevos.getPrecioBase());
        actual.setDepositoGarantia(datosNuevos.getDepositoGarantia());
        actual.setPropietario(datosNuevos.getPropietario());
        actual.setEstado(datosNuevos.getEstado());
        return true;
    }

    /**
     * Elimina una vivienda, siempre que no tenga alquileres asociados.
     *
     * @param idVivienda identificador de la vivienda a eliminar.
     * @return {@code true} si se eliminó con éxito; {@code false} si no
     * existe o si tiene al menos un alquiler asociado.
     */
    public boolean eliminarVivienda(int idVivienda) {
        Vivienda actual = buscarVivienda(idVivienda);
        if (actual == null) {
            return false; // No existe
        }
        for (Alquileres a : listaAlquiler) {
            if (a.getVivienda() == actual) {
                return false; // Tiene alquileres asociados, no se puede eliminar
            }
        }
        listaVivienda.remove(actual);
        return true;
    }

    // ==========================================
    //   Alquileres: buscar, agregar, modificar, eliminar
    // ==========================================
    /**
     * Busca un alquiler por su número.
     *
     * @param num número del alquiler a buscar.
     * @return el alquiler encontrado, o {@code null} si no existe.
     */
    public Alquileres buscarAlquiler(int num) {
        for (Alquileres a : listaAlquiler) {
            if (a.getNumAlquiler() == num) {
                return a;
            }
        }
        return null;
    }

    /**
     * Genera el siguiente número consecutivo de alquiler, calculado como el
     * mayor {@code numAlquiler} existente más uno. Se usa el máximo en vez
     * del tamaño de la lista para que el consecutivo no se reutilice tras
     * eliminar un alquiler intermedio.
     *
     * @return el siguiente número de alquiler disponible, comenzando en 1
     * si no existen alquileres registrados.
     */
    private int generarNumAlquiler() {
        int maximo = 0;
        for (Alquileres a : listaAlquiler) {
            if (a.getNumAlquiler() > maximo) {
                maximo = a.getNumAlquiler();
            }
        }
        return maximo + 1;
    }

    /**
     * Agrega un alquiler, siempre que su inquilino y su vivienda existan, la
     * vivienda esté disponible y el porcentaje de incremento anual esté
     * dentro del rango permitido (1 a 30). El número de alquiler se genera
     * internamente y se asigna al objeto recibido mediante
     * {@code setNumAlquiler(...)}, y el estado se fija en {@code "Vigente"}.
     * <p>
     * Regla de negocio derivada del diseño del sistema (no es una cita
     * literal de la guía): al agregarse correctamente el alquiler, la
     * vivienda asociada cambia su estado a {@code "alquilada"}, para que el
     * estado de la vivienda refleje siempre la realidad del negocio.
     *
     * @param a alquiler a agregar; se espera con {@code inquilino},
     * {@code vivienda} y demás datos ya cargados, sin {@code numAlquiler} ni
     * {@code estado} definidos por el llamador.
     * @return {@code true} si se agregó con éxito; {@code false} si el
     * inquilino no existe, la vivienda no existe, la vivienda no está
     * disponible, o el porcentaje de incremento anual está fuera de rango.
     */
    public boolean agregarAlquiler(Alquileres a) {
        if (a.getInquilino() == null
                || buscarInquilino(a.getInquilino().getCedInqui()) == null) {
            return false; // El inquilino no existe en el registro
        }
        if (a.getVivienda() == null
                || buscarVivienda(a.getVivienda().getIdVivienda()) == null) {
            return false; // La vivienda no existe en el registro
        }
        if (!"disponible".equalsIgnoreCase(a.getVivienda().getEstado())) {
            return false; // La vivienda no está disponible para alquilar
        }
        if (a.getPorcIncremAnual() < 1 || a.getPorcIncremAnual() > 30) {
            return false; // Porcentaje de incremento anual fuera de rango (1 a 30)
        }
        a.setNumAlquiler(generarNumAlquiler());
        a.setEstado("Vigente");
        listaAlquiler.add(a);
        a.getVivienda().setEstado("alquilada");
        return true;
    }

    /**
     * Modifica los datos de un alquiler existente, localizado por su número.
     * El {@code numAlquiler} original se conserva y no puede modificarse. Si
     * el inquilino o la vivienda cambian, se valida que existan en sus
     * respectivos registros; si la vivienda cambia, se valida además que la
     * nueva vivienda esté disponible. El objeto existente se actualiza
     * mediante sus setters (no se reemplaza la referencia), para preservar
     * la integridad de cualquier referencia externa al alquiler.
     * <p>
     * Regla de negocio derivada del diseño del sistema: si la vivienda
     * asociada cambia, la vivienda anterior vuelve a estado
     * {@code "disponible"} y la nueva vivienda pasa a {@code "alquilada"} —
     * es la contraparte simétrica de la regla aplicada en
     * {@link #agregarAlquiler(Alquileres)}. De igual forma, si el
     * {@code estado} del alquiler deja de ser {@code "Vigente"}, la vivienda
     * asociada vuelve a {@code "disponible"}; y si pasa a ser
     * {@code "Vigente"} viniendo de otro estado, se exige que la vivienda
     * esté disponible y se marca como {@code "alquilada"}.
     *
     * @param numAlquiler número del alquiler a modificar.
     * @param datosNuevos objeto con los datos nuevos a aplicar (su
     * {@code numAlquiler} se ignora).
     * @return {@code true} si se modificó con éxito; {@code false} si el
     * alquiler no existe, si el inquilino o la vivienda nuevos no existen,
     * si la nueva vivienda no está disponible cuando corresponde validarlo,
     * o si el porcentaje de incremento anual está fuera de rango.
     */
    public boolean modificarAlquiler(int numAlquiler, Alquileres datosNuevos) {
        Alquileres actual = buscarAlquiler(numAlquiler);
        if (actual == null) {
            return false; // No existe el alquiler a modificar
        }
        if (datosNuevos.getInquilino() == null
                || buscarInquilino(datosNuevos.getInquilino().getCedInqui()) == null) {
            return false; // El inquilino no existe en el registro
        }
        if (datosNuevos.getVivienda() == null
                || buscarVivienda(datosNuevos.getVivienda().getIdVivienda()) == null) {
            return false; // La vivienda no existe en el registro
        }
        if (datosNuevos.getPorcIncremAnual() < 1 || datosNuevos.getPorcIncremAnual() > 30) {
            return false; // Porcentaje de incremento anual fuera de rango (1 a 30)
        }

        Vivienda viviendaAnterior = actual.getVivienda();
        Vivienda viviendaNueva = datosNuevos.getVivienda();
        boolean cambiaVivienda = viviendaAnterior != viviendaNueva;

        if (cambiaVivienda && !"disponible".equalsIgnoreCase(viviendaNueva.getEstado())) {
            return false; // La nueva vivienda no está disponible
        }

        String estadoAnterior = actual.getEstado();
        String estadoNuevo = datosNuevos.getEstado();
        boolean eraVigente = "Vigente".equalsIgnoreCase(estadoAnterior);
        boolean seraVigente = "Vigente".equalsIgnoreCase(estadoNuevo);

        if (seraVigente && !eraVigente && !cambiaVivienda
                && !"disponible".equalsIgnoreCase(viviendaAnterior.getEstado())) {
            return false; // Se reactiva a Vigente pero la vivienda ya no está disponible
        }

        actual.setInquilino(datosNuevos.getInquilino());
        actual.setVivienda(datosNuevos.getVivienda());
        actual.setFechContrato(datosNuevos.getFechContrato());
        actual.setCantMeses(datosNuevos.getCantMeses());
        actual.setNumAdultos(datosNuevos.getNumAdultos());
        actual.setNumNinos(datosNuevos.getNumNinos());
        actual.setDepositoGarantia(datosNuevos.getDepositoGarantia());
        actual.setPrecioAlquiler(datosNuevos.getPrecioAlquiler());
        actual.setPorcIncremAnual(datosNuevos.getPorcIncremAnual());
        actual.setEstado(datosNuevos.getEstado());

        if (cambiaVivienda) {
            viviendaAnterior.setEstado("disponible");
            viviendaNueva.setEstado("alquilada");
        } else if (eraVigente && !seraVigente) {
            viviendaAnterior.setEstado("disponible");
        } else if (!eraVigente && seraVigente) {
            viviendaAnterior.setEstado("alquilada");
        }

        return true;
    }

    /**
     * Elimina físicamente un alquiler, siempre que no tenga mensualidades
     * asociadas. Esta operación está destinada únicamente a corregir errores
     * de captura: el mecanismo normal para finalizar un contrato es cambiar
     * su {@code estado} (Vigente, Vencido, Cancelado) mediante
     * {@link #modificarAlquiler(int, Alquileres)}, no eliminarlo. Si el
     * alquiler eliminado estaba {@code "Vigente"}, su vivienda vuelve a
     * estado {@code "disponible"}.
     * <p>
     * Nota: en esta fase el módulo de Mensualidades aún no está
     * implementado ({@code listaMen} permanece vacía), por lo que la
     * validación de dependencias queda preparada y documentada para cuando
     * exista la generación de mensualidades.
     *
     * @param numAlquiler número del alquiler a eliminar.
     * @return {@code true} si se eliminó con éxito; {@code false} si no
     * existe o si tiene al menos una mensualidad asociada.
     */
    public boolean eliminarAlquiler(int numAlquiler) {
        Alquileres actual = buscarAlquiler(numAlquiler);
        if (actual == null) {
            return false; // No existe
        }
        for (Mensualidades m : listaMen) {
            if (m.getNumAlquiler() == numAlquiler) {
                return false; // Tiene mensualidades asociadas, no se puede eliminar
            }
        }
        listaAlquiler.remove(actual);
        if ("Vigente".equalsIgnoreCase(actual.getEstado()) && actual.getVivienda() != null) {
            actual.getVivienda().setEstado("disponible");
        }
        return true;
    }

    // ==========================================
    //   Mensualidades: generación
    // ==========================================
    /**
     * Genera el siguiente consecutivo único de mensualidad, calculado como
     * el mayor {@code consecutivo} existente en {@code listaMen} más uno,
     * siguiendo el mismo criterio que {@link #generarNumAlquiler()}.
     *
     * @return el siguiente consecutivo disponible, comenzando en 1 si no
     * existen mensualidades registradas.
     */
    private int generarConsecutivoMensualidad() {
        int maximo = 0;
        for (Mensualidades m : listaMen) {
            if (m.getConsecutivo() > maximo) {
                maximo = m.getConsecutivo();
            }
        }
        return maximo + 1;
    }

    /**
     * Determina el porcentaje de descuento aplicable según la temporada del
     * mes recibido, según las reglas de negocio autorizadas para este
     * proyecto:
     * <ul>
     * <li>Temporada baja (agosto, septiembre, octubre): 10.0</li>
     * <li>Temporada media (marzo a julio): 5.0</li>
     * <li>Temporada alta (noviembre, diciembre, enero, febrero): 0.0</li>
     * </ul>
     *
     * @param mes mes de cobro (1 a 12).
     * @return el porcentaje de descuento correspondiente a la temporada del
     * mes recibido.
     */
    private double calcularDescuentoPorTemporada(int mes) {
        if (mes == 8 || mes == 9 || mes == 10) {
            return 10.0; // Temporada baja
        }
        if (mes >= 3 && mes <= 7) {
            return 5.0; // Temporada media
        }
        return 0.0; // Temporada alta: 11, 12, 1, 2
    }

    /**
     * Verifica si ya existe, en {@code listaMen}, una mensualidad generada
     * para la combinación exacta de alquiler, mes y año recibidos.
     *
     * @param numAlquiler número del alquiler a verificar.
     * @param mes mes de cobro a verificar.
     * @param anio año de cobro a verificar.
     * @return {@code true} si ya existe una mensualidad con esa combinación;
     * {@code false} en caso contrario.
     */
    private boolean existeMensualidad(int numAlquiler, int mes, int anio) {
        for (Mensualidades m : listaMen) {
            if (m.getNumAlquiler() == numAlquiler && m.getMesCobro() == mes && m.getAnioActual() == anio) {
                return true;
            }
        }
        return false;
    }

    /**
     * Genera una mensualidad para cada alquiler {@code Vigente} que aún no
     * tenga una mensualidad registrada para el mes y año recibidos, y las
     * agrega a {@code listaMen}. No se genera mensualidad para alquileres en
     * cualquier otro estado (p. ej. {@code Vencido} o {@code Cancelado}), ni
     * se duplica una mensualidad ya existente para la misma combinación
     * alquiler + mes + año.
     * <p>
     * Reglas de negocio autorizadas explícitamente para este proyecto (la
     * documentación original no las especificaba):
     * <ul>
     * <li>{@code descuento} se guarda como el porcentaje de la temporada
     * (10.0, 5.0 o 0.0), no como fracción.</li>
     * <li>{@code montoMes = precioAlquiler - (precioAlquiler * descuento / 100)},
     * usando exclusivamente {@code alquiler.getPrecioAlquiler()} como base,
     * sin considerar {@code porcIncremAnual}.</li>
     * <li>El {@code estado} inicial de toda mensualidad generada es
     * {@code "Pendiente"}.</li>
     * </ul>
     * Esta operación no modifica ningún {@code Alquileres} ni ninguna
     * {@code Vivienda}; únicamente lee sus datos.
     *
     * @param mes mes de cobro a generar (1 a 12).
     * @param anio año de cobro a generar.
     * @return la cantidad de mensualidades nuevas generadas (puede ser 0 si
     * no había alquileres vigentes pendientes de generar, o si todos ya
     * tenían mensualidad para ese mes/año); {@code -1} si el periodo
     * (mes/año) recibido es anterior al mes/año actual del sistema, en cuyo
     * caso no se genera ni se modifica nada.
     */
    public int generarMensualidades(int mes, int anio) {
        LocalDate hoy = LocalDate.now();
        int anioActual = hoy.getYear();
        int mesActual = hoy.getMonthValue();
        if (anio < anioActual || (anio == anioActual && mes < mesActual)) {
            return -1; // Periodo anterior al actual: no se genera nada
        }

        int generadas = 0;
        for (Alquileres a : listaAlquiler) {
            if (!"Vigente".equalsIgnoreCase(a.getEstado())) {
                continue; // Solo participan los alquileres Vigente
            }
            if (existeMensualidad(a.getNumAlquiler(), mes, anio)) {
                continue; // Ya existe mensualidad para esta combinación, no se duplica
            }
            double descuento = calcularDescuentoPorTemporada(mes);
            double precio = a.getPrecioAlquiler();
            double montoMes = precio - (precio * descuento / 100);
            String nombreInquilino = a.getInquilino() == null ? "" : a.getInquilino().getNomInqui();

            Mensualidades nueva = new Mensualidades(generarConsecutivoMensualidad(), a.getNumAlquiler(),
                    LocalDate.now(), nombreInquilino, mes, anio, descuento, montoMes, "Pendiente");
            listaMen.add(nueva);
            generadas++;
        }
        return generadas;
    }

    // ==========================================
    //   Ganancias: cálculo
    // ==========================================
    /**
     * Suma {@code Alquileres.depositoGarantia} de los alquileres cuya
     * {@code fechContrato} pertenece al año recibido y, si {@code mes} no es
     * {@code null}, también al mes recibido, y aplica el 50% autorizado
     * explícitamente como regla de negocio para este proyecto. No modifica
     * ningún {@code Alquileres}.
     *
     * @param mes mes a filtrar (1 a 12), o {@code null} para no filtrar por
     * mes (modo anual).
     * @param anio año a filtrar.
     * @return el 50% de la suma de depósitos de garantía de los alquileres
     * del periodo.
     */
    private double calcularIngresoDepositos(Integer mes, int anio) {
        double suma = 0;
        for (Alquileres a : listaAlquiler) {
            LocalDate fecha = a.getFechContrato();
            if (fecha == null || fecha.getYear() != anio) {
                continue;
            }
            if (mes != null && fecha.getMonthValue() != mes) {
                continue;
            }
            suma += a.getDepositoGarantia();
        }
        return suma * 0.50;
    }

    /**
     * Suma {@code Mensualidades.montoMes} de las mensualidades cuyo
     * {@code anioActual} coincide con el año recibido y, si {@code mes} no
     * es {@code null}, también su {@code mesCobro} coincide con el mes
     * recibido, y aplica el 5% autorizado explícitamente como regla de
     * negocio para este proyecto. No filtra por {@code estado} (el proyecto
     * no implementa un estado "Cobrada"/"Pagada"). No modifica ninguna
     * {@code Mensualidades}.
     *
     * @param mes mes a filtrar (1 a 12), o {@code null} para no filtrar por
     * mes (modo anual).
     * @param anio año a filtrar.
     * @return el 5% de la suma de montos de las mensualidades del periodo.
     */
    private double calcularIngresoMensualidades(Integer mes, int anio) {
        double suma = 0;
        for (Mensualidades m : listaMen) {
            if (m.getAnioActual() != anio) {
                continue;
            }
            if (mes != null && m.getMesCobro() != mes) {
                continue;
            }
            suma += m.getMontoMes();
        }
        return suma * 0.05;
    }

    /**
     * Calcula el 50% de los depósitos de garantía de los alquileres cuya
     * fecha de contrato pertenece al mes y año recibidos.
     *
     * @param mes mes de la consulta (1 a 12).
     * @param anio año de la consulta.
     * @return ingreso por depósitos de garantía del periodo mensual.
     */
    public double calcularIngresoDepositosMensual(int mes, int anio) {
        return calcularIngresoDepositos(mes, anio);
    }

    /**
     * Calcula el 50% de los depósitos de garantía de los alquileres cuya
     * fecha de contrato pertenece al año recibido, sin filtrar por mes.
     *
     * @param anio año de la consulta.
     * @return ingreso por depósitos de garantía del periodo anual.
     */
    public double calcularIngresoDepositosAnual(int anio) {
        return calcularIngresoDepositos(null, anio);
    }

    /**
     * Calcula el 5% de las mensualidades cuyo mes y año de cobro coinciden
     * con los recibidos, sin filtrar por estado.
     *
     * @param mes mes de la consulta (1 a 12).
     * @param anio año de la consulta.
     * @return ingreso por mensualidades cobradas del periodo mensual.
     */
    public double calcularIngresoMensualidadesMensual(int mes, int anio) {
        return calcularIngresoMensualidades(mes, anio);
    }

    /**
     * Calcula el 5% de las mensualidades cuyo año de cobro coincide con el
     * recibido, sin filtrar por mes ni por estado.
     *
     * @param anio año de la consulta.
     * @return ingreso por mensualidades cobradas del periodo anual.
     */
    public double calcularIngresoMensualidadesAnual(int anio) {
        return calcularIngresoMensualidades(null, anio);
    }

    /**
     * Calcula la ganancia total de un periodo mensual, como la suma del
     * ingreso por depósitos de garantía (50%) más el ingreso por
     * mensualidades (5%) de ese mes y año. No modifica ningún
     * {@code Alquileres} ni ninguna {@code Mensualidades}; el
     * {@code porcIncremAnual} de los alquileres no participa en el cálculo.
     *
     * @param mes mes de la consulta (1 a 12).
     * @param anio año de la consulta.
     * @return la ganancia total del periodo mensual.
     */
    public double calcularGananciaMensual(int mes, int anio) {
        return calcularIngresoDepositosMensual(mes, anio) + calcularIngresoMensualidadesMensual(mes, anio);
    }

    /**
     * Calcula la ganancia total de un periodo anual, como la suma del
     * ingreso por depósitos de garantía (50%) más el ingreso por
     * mensualidades (5%) de todo ese año, sin ejecutar cálculos mes a mes.
     * No modifica ningún {@code Alquileres} ni ninguna {@code Mensualidades}.
     *
     * @param anio año de la consulta.
     * @return la ganancia total del periodo anual.
     */
    public double calcularGananciaAnual(int anio) {
        return calcularIngresoDepositosAnual(anio) + calcularIngresoMensualidadesAnual(anio);
    }

}




