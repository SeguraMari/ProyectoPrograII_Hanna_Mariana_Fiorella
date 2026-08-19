
package vista;

import clases.Alquileres;
import clases.Inquilino;
import clases.Vivienda;
import datos.GestionDatos;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Formulario de captura de datos para un alquiler, clonado visualmente de
 * {@link FrmNuevaVivienda} y {@link FrmNuevoInquilino}. Permite insertar un
 * nuevo alquiler mediante {@link datos.GestionDatos}.
 *
 * @author 
 */
public class FrmNuevoAlquiler extends javax.swing.JDialog {

    // PASO 1: Se crea la clase

    private GestionDatos gestion;
    private Alquileres alquilerEditar;
    private int numAlquilerOriginal;

    // PASO 3: Se crean los constructores
    /**
     * Crea el formulario de nuevo alquiler.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     */
    public FrmNuevoAlquiler(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
    }

    /**
     * Crea el formulario de nuevo alquiler conectado a la instancia
     * compartida de {@link GestionDatos}, utilizada para precargar los
     * combos de inquilinos y viviendas disponibles, y para insertar el
     * alquiler capturado.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     */
    public FrmNuevoAlquiler(java.awt.Frame parent, boolean modal, GestionDatos gestion) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        cargarInquilinos();
        cargarViviendasDisponibles();
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Vigente"}));
        cmbEstado.setEnabled(false);
        this.setLocationRelativeTo(parent);
    }

    /**
     * Crea el formulario en modo edición, precargando los datos del
     * alquiler recibido. El alquiler debe haber sido obtenido previamente
     * mediante {@code gestion.buscarAlquiler(...)}.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     * @param alquilerEditar alquiler existente a modificar.
     */
    public FrmNuevoAlquiler(java.awt.Frame parent, boolean modal, GestionDatos gestion, Alquileres alquilerEditar) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        this.alquilerEditar = alquilerEditar;
        this.numAlquilerOriginal = alquilerEditar.getNumAlquiler();
        cargarInquilinos();
        cargarViviendasParaEditar(alquilerEditar.getVivienda());
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Vigente", "Vencido", "Cancelado"}));

        this.setTitle("Editar Alquiler");
        lblNumAlquiler.setText(String.valueOf(alquilerEditar.getNumAlquiler()));
        dchFechaContrato.setDate(java.util.Date.from(alquilerEditar.getFechContrato().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        txtCantMeses.setText(String.valueOf(alquilerEditar.getCantMeses()));
        txtNumAdultos.setText(String.valueOf(alquilerEditar.getNumAdultos()));
        txtNumNinos.setText(String.valueOf(alquilerEditar.getNumNinos()));
        txtDepositoGarantia.setText(String.valueOf(alquilerEditar.getDepositoGarantia()));
        txtPrecioAlquiler.setText(String.valueOf(alquilerEditar.getPrecioAlquiler()));
        txtPorcIncremAnual.setText(String.valueOf(alquilerEditar.getPorcIncremAnual()));
        cmbInquilino.setSelectedItem(alquilerEditar.getInquilino());
        cmbVivienda.setSelectedItem(alquilerEditar.getVivienda());
        cmbEstado.setSelectedItem(alquilerEditar.getEstado());
        btnGuardar.setText("Guardar cambios");
        this.setLocationRelativeTo(parent);
    }

    /**
     * Llena {@code cmbInquilino} con los inquilinos existentes en
     * GestionDatos, para que el usuario seleccione el objeto
     * {@link Inquilino} que arrendará la vivienda.
     */
    private void cargarInquilinos() {
        ArrayList<Inquilino> inquilinos = gestion.obtenerInquilinos();
        javax.swing.DefaultComboBoxModel<Inquilino> modelo = new javax.swing.DefaultComboBoxModel<>();
        for (Inquilino i : inquilinos) {
            modelo.addElement(i);
        }
        cmbInquilino.setModel(modelo);
        cmbInquilino.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Inquilino) {
                    Inquilino i = (Inquilino) value;
                    setText(i.getCedInqui() + " - " + i.getNomInqui());
                }
                return this;
            }
        });
    }

    /**
     * Llena {@code cmbVivienda} únicamente con las viviendas existentes en
     * GestionDatos cuyo estado sea {@code "disponible"}, para que el usuario
     * seleccione el objeto {@link Vivienda} que se dará en alquiler.
     */
    private void cargarViviendasDisponibles() {
        ArrayList<Vivienda> viviendas = gestion.obtenerViviendas();
        javax.swing.DefaultComboBoxModel<Vivienda> modelo = new javax.swing.DefaultComboBoxModel<>();
        for (Vivienda v : viviendas) {
            if ("disponible".equalsIgnoreCase(v.getEstado())) {
                modelo.addElement(v);
            }
        }
        cmbVivienda.setModel(modelo);
        cmbVivienda.setRenderer(crearRendererVivienda());
    }

    /**
     * Llena {@code cmbVivienda} en modo edición: incluye la vivienda
     * actualmente asociada al alquiler (aunque su estado no sea
     * {@code "disponible"}, por ser precisamente la suya) más el resto de
     * viviendas con {@code estado=="disponible"}, sin duplicar la vivienda
     * actual.
     */
    private void cargarViviendasParaEditar(Vivienda viviendaActual) {
        ArrayList<Vivienda> viviendas = gestion.obtenerViviendas();
        javax.swing.DefaultComboBoxModel<Vivienda> modelo = new javax.swing.DefaultComboBoxModel<>();
        if (viviendaActual != null) {
            modelo.addElement(viviendaActual);
        }
        for (Vivienda v : viviendas) {
            if (v != viviendaActual && "disponible".equalsIgnoreCase(v.getEstado())) {
                modelo.addElement(v);
            }
        }
        cmbVivienda.setModel(modelo);
        cmbVivienda.setRenderer(crearRendererVivienda());
    }

    /**
     * Crea el {@link DefaultListCellRenderer} compartido para mostrar
     * información legible de {@link Vivienda} en {@code cmbVivienda}.
     */
    private DefaultListCellRenderer crearRendererVivienda() {
        return new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Vivienda) {
                    Vivienda v = (Vivienda) value;
                    setText(v.getIdVivienda() + " - " + v.getDescripcion());
                }
                return this;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNumAlquilerTitulo = new javax.swing.JLabel();
        lblNumAlquiler = new javax.swing.JLabel();
        lblFechaContrato = new javax.swing.JLabel();
        dchFechaContrato = new com.toedter.calendar.JDateChooser();
        lblCantMeses = new javax.swing.JLabel();
        txtCantMeses = new javax.swing.JTextField();
        lblNumAdultos = new javax.swing.JLabel();
        txtNumAdultos = new javax.swing.JTextField();
        lblNumNinos = new javax.swing.JLabel();
        txtNumNinos = new javax.swing.JTextField();
        lblDepositoGarantia = new javax.swing.JLabel();
        txtDepositoGarantia = new javax.swing.JTextField();
        lblPrecioAlquiler = new javax.swing.JLabel();
        txtPrecioAlquiler = new javax.swing.JTextField();
        lblPorcIncremAnual = new javax.swing.JLabel();
        txtPorcIncremAnual = new javax.swing.JTextField();
        lblInquilino = new javax.swing.JLabel();
        cmbInquilino = new javax.swing.JComboBox();
        lblVivienda = new javax.swing.JLabel();
        cmbVivienda = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Alquiler");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos del Alquiler", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblNumAlquilerTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumAlquilerTitulo.setText("Núm. Alquiler:");

        lblNumAlquiler.setText("Se generará automáticamente");

        lblFechaContrato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFechaContrato.setText("Fecha Contrato:");

        lblCantMeses.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCantMeses.setText("Cant. Meses:");

        lblNumAdultos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumAdultos.setText("Núm. Adultos:");

        lblNumNinos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumNinos.setText("Núm. Niños:");

        lblDepositoGarantia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDepositoGarantia.setText("Depósito Garantía:");

        lblPrecioAlquiler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecioAlquiler.setText("Precio Alquiler:");

        lblPorcIncremAnual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPorcIncremAnual.setText("% Increm. Anual:");

        lblInquilino.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInquilino.setText("Inquilino:");

        lblVivienda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVivienda.setText("Vivienda:");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumAlquilerTitulo)
                    .addComponent(lblFechaContrato)
                    .addComponent(lblCantMeses)
                    .addComponent(lblNumAdultos)
                    .addComponent(lblNumNinos)
                    .addComponent(lblDepositoGarantia)
                    .addComponent(lblPrecioAlquiler)
                    .addComponent(lblPorcIncremAnual)
                    .addComponent(lblInquilino)
                    .addComponent(lblVivienda)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dchFechaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantMeses)
                    .addComponent(txtNumAdultos)
                    .addComponent(txtNumNinos)
                    .addComponent(txtDepositoGarantia)
                    .addComponent(txtPrecioAlquiler)
                    .addComponent(txtPorcIncremAnual)
                    .addComponent(cmbInquilino, 0, 240, Short.MAX_VALUE)
                    .addComponent(cmbVivienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumAlquilerTitulo)
                    .addComponent(lblNumAlquiler))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaContrato)
                    .addComponent(dchFechaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantMeses)
                    .addComponent(txtCantMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumAdultos)
                    .addComponent(txtNumAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumNinos)
                    .addComponent(txtNumNinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepositoGarantia)
                    .addComponent(txtDepositoGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioAlquiler)
                    .addComponent(txtPrecioAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPorcIncremAnual)
                    .addComponent(txtPorcIncremAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInquilino)
                    .addComponent(cmbInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVivienda)
                    .addComponent(cmbVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardarrr.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelate.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // PASO 5: Se crean los métodos de clase
    /**
     * Valida los campos obligatorios y, según el modo del formulario, agrega
     * un nuevo alquiler o modifica el alquiler recibido en el constructor de
     * edición. Ambas operaciones se realizan exclusivamente mediante
     * {@code gestion.agregarAlquiler(...)} / {@code gestion.modificarAlquiler(...)};
     * el inquilino y la vivienda se obtienen directamente de los objetos
     * seleccionados en {@code cmbInquilino}/{@code cmbVivienda}, sin volver a
     * buscarlos. El número de alquiler original se conserva siempre, y el
     * estado (así como los cambios de estado de la vivienda asociada) los
     * establece exclusivamente {@code GestionDatos}.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Date fecha = dchFechaContrato.getDate();
        String cantMeses = txtCantMeses.getText().trim();
        String numAdultos = txtNumAdultos.getText().trim();
        String numNinos = txtNumNinos.getText().trim();
        String depositoGarantia = txtDepositoGarantia.getText().trim();
        String precioAlquiler = txtPrecioAlquiler.getText().trim();
        String porcIncremAnual = txtPorcIncremAnual.getText().trim();
        Inquilino inquilino = (Inquilino) cmbInquilino.getSelectedItem();
        Vivienda vivienda = (Vivienda) cmbVivienda.getSelectedItem();

        if (fecha == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la fecha de contrato.");
            return;
        }

        if (inquilino == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un inquilino.");
            return;
        }

        if (vivienda == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una vivienda.");
            return;
        }

        if (cantMeses.isEmpty() || numAdultos.isEmpty() || numNinos.isEmpty()
                || depositoGarantia.isEmpty() || precioAlquiler.isEmpty() || porcIncremAnual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        int cantMesesNumerico;
        int numAdultosNumerico;
        int numNinosNumerico;
        try {
            cantMesesNumerico = Integer.parseInt(cantMeses);
            numAdultosNumerico = Integer.parseInt(numAdultos);
            numNinosNumerico = Integer.parseInt(numNinos);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cant. meses, núm. adultos y núm. niños deben ser numéricos.");
            return;
        }

        double depositoGarantiaNumerico;
        double precioAlquilerNumerico;
        double porcIncremAnualNumerico;
        try {
            depositoGarantiaNumerico = Double.parseDouble(depositoGarantia);
            precioAlquilerNumerico = Double.parseDouble(precioAlquiler);
            porcIncremAnualNumerico = Double.parseDouble(porcIncremAnual);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Depósito de garantía, precio de alquiler y % de incremento anual deben ser numéricos.");
            return;
        }

        LocalDate fechaContrato = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String estadoSeleccionado = (String) cmbEstado.getSelectedItem();

        Alquileres datos = new Alquileres(0, fechaContrato, cantMesesNumerico, numAdultosNumerico,
                numNinosNumerico, depositoGarantiaNumerico, precioAlquilerNumerico, porcIncremAnualNumerico,
                inquilino, vivienda, estadoSeleccionado);

        if (alquilerEditar == null) {
            // Modo insertar
            boolean agregado = gestion.agregarAlquiler(datos);
            if (agregado) {
                JOptionPane.showMessageDialog(this, "Alquiler agregado correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar: verifique que el inquilino y la vivienda existan, que la vivienda esté disponible, y que el incremento anual esté entre 1% y 30%.");
            }
        } else {
            // Modo editar
            boolean modificado = gestion.modificarAlquiler(numAlquilerOriginal, datos);
            if (modificado) {
                JOptionPane.showMessageDialog(this, "Alquiler modificado correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar: verifique que el inquilino y la vivienda existan, que la vivienda esté disponible si cambió, y que el incremento anual esté entre 1% y 30%.");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbInquilino;
    private javax.swing.JComboBox cmbVivienda;
    private com.toedter.calendar.JDateChooser dchFechaContrato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantMeses;
    private javax.swing.JLabel lblDepositoGarantia;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaContrato;
    private javax.swing.JLabel lblInquilino;
    private javax.swing.JLabel lblNumAdultos;
    private javax.swing.JLabel lblNumAlquiler;
    private javax.swing.JLabel lblNumAlquilerTitulo;
    private javax.swing.JLabel lblNumNinos;
    private javax.swing.JLabel lblPorcIncremAnual;
    private javax.swing.JLabel lblPrecioAlquiler;
    private javax.swing.JLabel lblVivienda;
    private javax.swing.JTextField txtCantMeses;
    private javax.swing.JTextField txtDepositoGarantia;
    private javax.swing.JTextField txtNumAdultos;
    private javax.swing.JTextField txtNumNinos;
    private javax.swing.JTextField txtPorcIncremAnual;
    private javax.swing.JTextField txtPrecioAlquiler;
    // End of variables declaration//GEN-END:variables
}
