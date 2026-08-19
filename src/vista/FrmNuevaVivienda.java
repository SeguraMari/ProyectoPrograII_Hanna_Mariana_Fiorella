package vista;

import clases.Propietario;
import clases.Vivienda;
import datos.GestionDatos;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Formulario de captura de datos para una vivienda, clonado visualmente de
 * {@link FrmNuevoPropietario} y {@link FrmNuevoInquilino}. Permite insertar una
 * nueva vivienda mediante {@link datos.GestionDatos}.
 *
 * @author
 */
public class FrmNuevaVivienda extends javax.swing.JDialog {

    // PASO 1: Se crea la clase
    private GestionDatos gestion;
    private Vivienda viviendaEditar;
    private int idViviendaOriginal;

    // PASO 3: Se crean los constructores
    /**
     * Crea el formulario de nueva vivienda conectado a la instancia compartida
     * de {@link GestionDatos}, utilizada únicamente para precargar el combo de
     * propietarios existentes.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     */
    public FrmNuevaVivienda(java.awt.Frame parent, boolean modal, GestionDatos gestion) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        cargarPropietarios();
        this.setLocationRelativeTo(parent);
    }

    /**
     * Crea el formulario en modo edición, precargando los datos de la vivienda
     * recibida. La vivienda debe haber sido obtenida previamente mediante
     * {@code gestion.buscarVivienda(...)}.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     * @param viviendaEditar vivienda existente a modificar.
     */
    public FrmNuevaVivienda(java.awt.Frame parent, boolean modal, GestionDatos gestion, Vivienda viviendaEditar) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        cargarPropietarios();
        this.viviendaEditar = viviendaEditar;
        this.idViviendaOriginal = viviendaEditar.getIdVivienda();
        this.setTitle("Editar Vivienda");
        txtIdVivienda.setText(String.valueOf(viviendaEditar.getIdVivienda()));
        txtDescripcion.setText(viviendaEditar.getDescripcion());
        txtDireccion.setText(viviendaEditar.getDireccion());
        txtMtsConstruct.setText(String.valueOf(viviendaEditar.getMtsConstruct()));
        txtMtsLote.setText(String.valueOf(viviendaEditar.getMtsLote()));
        txtTipoConstruccion.setText(viviendaEditar.getTipoConstruccion());
        chkCochera.setSelected(viviendaEditar.isCochera());
        txtCantHabitac.setText(String.valueOf(viviendaEditar.getCantHabitac()));
        txtCantBanios.setText(String.valueOf(viviendaEditar.getCantBanios()));
        txtCarretera.setText(viviendaEditar.getCarretera());
        txtPrecioBase.setText(String.valueOf(viviendaEditar.getPrecioBase()));
        txtDepositoGarantia.setText(String.valueOf(viviendaEditar.getDepositoGarantia()));
        cmbPropietario.setSelectedItem(viviendaEditar.getPropietario());
        cmbEstado.setSelectedItem(viviendaEditar.getEstado());
        btnGuardar.setText("Guardar cambios");
        this.setLocationRelativeTo(parent);
    }

    /**
     * Llena {@code cmbPropietario} con los propietarios existentes en
     * GestionDatos, para que el usuario seleccione el objeto
     * {@link Propietario} dueño de la vivienda.
     */
    private void cargarPropietarios() {
        ArrayList<Propietario> propietarios = gestion.obtenerPropietarios();
        javax.swing.DefaultComboBoxModel<Propietario> modelo = new javax.swing.DefaultComboBoxModel<>();
        for (Propietario p : propietarios) {
            modelo.addElement(p);
        }
        cmbPropietario.setModel(modelo);
        cmbPropietario.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Propietario) {
                    Propietario p = (Propietario) value;
                    setText(p.getCedPropiet() + " - " + p.getNomPropiet());
                }
                return this;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIdVivienda = new javax.swing.JLabel();
        txtIdVivienda = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblMtsConstruct = new javax.swing.JLabel();
        txtMtsConstruct = new javax.swing.JTextField();
        lblMtsLote = new javax.swing.JLabel();
        txtMtsLote = new javax.swing.JTextField();
        lblTipoConstruccion = new javax.swing.JLabel();
        txtTipoConstruccion = new javax.swing.JTextField();
        lblCochera = new javax.swing.JLabel();
        chkCochera = new javax.swing.JCheckBox();
        lblCantHabitac = new javax.swing.JLabel();
        txtCantHabitac = new javax.swing.JTextField();
        lblCantBanios = new javax.swing.JLabel();
        txtCantBanios = new javax.swing.JTextField();
        lblCarretera = new javax.swing.JLabel();
        txtCarretera = new javax.swing.JTextField();
        lblPrecioBase = new javax.swing.JLabel();
        txtPrecioBase = new javax.swing.JTextField();
        lblDepositoGarantia = new javax.swing.JLabel();
        txtDepositoGarantia = new javax.swing.JTextField();
        lblPropietario = new javax.swing.JLabel();
        cmbPropietario = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Vivienda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Ingrese los datos de la Vivienda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblIdVivienda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIdVivienda.setText("ID Vivienda:");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblMtsConstruct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMtsConstruct.setText("Mts. Construcción:");

        lblMtsLote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMtsLote.setText("Mts. Lote:");

        lblTipoConstruccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTipoConstruccion.setText("Tipo Construcción:");

        lblCochera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCochera.setText("Cochera:");

        chkCochera.setText("¿Tiene cochera?");

        lblCantHabitac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCantHabitac.setText("Cant. Habitaciones:");

        lblCantBanios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCantBanios.setText("Cant. Baños:");

        lblCarretera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCarretera.setText("Carretera:");

        lblPrecioBase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecioBase.setText("Precio Base:");

        lblDepositoGarantia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDepositoGarantia.setText("Depósito Garantía:");

        lblPropietario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPropietario.setText("Propietario:");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "disponible", "alquilada", "inactiva" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdVivienda)
                    .addComponent(lblDescripcion)
                    .addComponent(lblDireccion)
                    .addComponent(lblMtsConstruct)
                    .addComponent(lblMtsLote)
                    .addComponent(lblTipoConstruccion)
                    .addComponent(lblCochera)
                    .addComponent(lblCantHabitac)
                    .addComponent(lblCantBanios)
                    .addComponent(lblCarretera)
                    .addComponent(lblPrecioBase)
                    .addComponent(lblDepositoGarantia)
                    .addComponent(lblPropietario)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdVivienda)
                    .addComponent(txtDescripcion)
                    .addComponent(txtDireccion)
                    .addComponent(txtMtsConstruct)
                    .addComponent(txtMtsLote)
                    .addComponent(txtTipoConstruccion)
                    .addComponent(chkCochera, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addComponent(txtCantHabitac)
                    .addComponent(txtCantBanios)
                    .addComponent(txtCarretera)
                    .addComponent(txtPrecioBase)
                    .addComponent(txtDepositoGarantia)
                    .addComponent(cmbPropietario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdVivienda)
                    .addComponent(txtIdVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMtsConstruct)
                    .addComponent(txtMtsConstruct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMtsLote)
                    .addComponent(txtMtsLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoConstruccion)
                    .addComponent(txtTipoConstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCochera)
                    .addComponent(chkCochera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantHabitac)
                    .addComponent(txtCantHabitac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantBanios)
                    .addComponent(txtCantBanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarretera)
                    .addComponent(txtCarretera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioBase)
                    .addComponent(txtPrecioBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepositoGarantia)
                    .addComponent(txtDepositoGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPropietario)
                    .addComponent(cmbPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardarrr.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelate.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpi.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(28, 28, 28)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
     * una nueva vivienda o modifica la vivienda recibida en el constructor de
     * edición. Ambas operaciones se realizan exclusivamente mediante
     * {@code gestion.agregarVivienda(...)} / {@code gestion.modificarVivienda(...)}.
     * El propietario se obtiene directamente del objeto seleccionado en
     * {@code cmbPropietario}, sin volver a buscarlo por cédula.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String idVivienda = txtIdVivienda.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String mtsConstruct = txtMtsConstruct.getText().trim();
        String mtsLote = txtMtsLote.getText().trim();
        String tipoConstruccion = txtTipoConstruccion.getText().trim();
        boolean cochera = chkCochera.isSelected();
        String cantHabitac = txtCantHabitac.getText().trim();
        String cantBanios = txtCantBanios.getText().trim();
        String carretera = txtCarretera.getText().trim();
        String precioBase = txtPrecioBase.getText().trim();
        String depositoGarantia = txtDepositoGarantia.getText().trim();
        Propietario propietario = (Propietario) cmbPropietario.getSelectedItem();
        String estado = (String) cmbEstado.getSelectedItem();

        if (idVivienda.isEmpty() || descripcion.isEmpty() || direccion.isEmpty()
                || mtsConstruct.isEmpty() || mtsLote.isEmpty() || tipoConstruccion.isEmpty()
                || cantHabitac.isEmpty() || cantBanios.isEmpty() || carretera.isEmpty()
                || precioBase.isEmpty() || depositoGarantia.isEmpty() || estado == null) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        if (propietario == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un propietario.");
            return;
        }

        int idViviendaNumerico;
        int cantHabitacNumerico;
        try {
            idViviendaNumerico = Integer.parseInt(idVivienda);
            cantHabitacNumerico = Integer.parseInt(cantHabitac);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de vivienda y la cantidad de habitaciones deben ser numéricos.");
            return;
        }

        double mtsConstructNumerico;
        double mtsLoteNumerico;
        double cantBaniosNumerico;
        double precioBaseNumerico;
        double depositoGarantiaNumerico;
        try {
            mtsConstructNumerico = Double.parseDouble(mtsConstruct);
            mtsLoteNumerico = Double.parseDouble(mtsLote);
            cantBaniosNumerico = Double.parseDouble(cantBanios);
            precioBaseNumerico = Double.parseDouble(precioBase);
            depositoGarantiaNumerico = Double.parseDouble(depositoGarantia);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mts. construcción, mts. lote, cant. baños, precio base y depósito de garantía deben ser numéricos.");
            return;
        }

        if (idViviendaNumerico <= 0 || cantHabitacNumerico <= 0 || mtsConstructNumerico <= 0
                || mtsLoteNumerico <= 0 || cantBaniosNumerico <= 0 || precioBaseNumerico <= 0
                || depositoGarantiaNumerico <= 0) {
            JOptionPane.showMessageDialog(this, "El ID, los metros, la cant. de habitaciones/baños, el precio base y el depósito deben ser números positivos.");
            return;
        }

        Vivienda datos = new Vivienda(idViviendaNumerico, descripcion, direccion, mtsConstructNumerico,
                mtsLoteNumerico, tipoConstruccion, cochera, cantHabitacNumerico, cantBaniosNumerico,
                carretera, precioBaseNumerico, depositoGarantiaNumerico, propietario, estado);

        if (viviendaEditar == null) {
            // Modo insertar
            boolean agregada = gestion.agregarVivienda(datos);
            if (agregada) {
                JOptionPane.showMessageDialog(this, "Vivienda agregada correctamente.");
                Limpiar();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar: ya existe una vivienda con ese ID o el propietario no existe.");
            }
        } else {
            // Modo editar
            boolean modificada = gestion.modificarVivienda(idViviendaOriginal, datos);
            if (modificada) {
                JOptionPane.showMessageDialog(this, "Vivienda modificada correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar: la vivienda no existe, el ID ya pertenece a otra vivienda, o el propietario no existe.");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * Limpia todos los campos de captura del formulario.
     */
    public void Limpiar() {
        txtIdVivienda.setText("");
        txtDescripcion.setText("");
        txtDireccion.setText("");
        txtMtsConstruct.setText("");
        txtMtsLote.setText("");
        txtTipoConstruccion.setText("");
        chkCochera.setSelected(false);
        txtCantHabitac.setText("");
        txtCantBanios.setText("");
        txtCarretera.setText("");
        txtPrecioBase.setText("");
        txtDepositoGarantia.setText("");
        if (cmbPropietario.getItemCount() > 0) {
            cmbPropietario.setSelectedIndex(0);
        }
        cmbEstado.setSelectedIndex(0);
        txtIdVivienda.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox chkCochera;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbPropietario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantBanios;
    private javax.swing.JLabel lblCantHabitac;
    private javax.swing.JLabel lblCarretera;
    private javax.swing.JLabel lblCochera;
    private javax.swing.JLabel lblDepositoGarantia;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdVivienda;
    private javax.swing.JLabel lblMtsConstruct;
    private javax.swing.JLabel lblMtsLote;
    private javax.swing.JLabel lblPrecioBase;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JLabel lblTipoConstruccion;
    private javax.swing.JTextField txtCantBanios;
    private javax.swing.JTextField txtCantHabitac;
    private javax.swing.JTextField txtCarretera;
    private javax.swing.JTextField txtDepositoGarantia;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdVivienda;
    private javax.swing.JTextField txtMtsConstruct;
    private javax.swing.JTextField txtMtsLote;
    private javax.swing.JTextField txtPrecioBase;
    private javax.swing.JTextField txtTipoConstruccion;
    // End of variables declaration//GEN-END:variables
}
