package vista;

import clases.Inquilino;
import datos.GestionDatos;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Formulario de captura de datos para un inquilino, clonado de
 * {@link FrmNuevoPropietario}. Permite insertar un nuevo inquilino mediante
 * {@link datos.GestionDatos}.
 *
 * @author
 */
public class FrmNuevoInquilino extends javax.swing.JDialog {

    // PASO 1: Se crea la clase
    private GestionDatos gestion;
    private Inquilino inquilinoEditar;
    private int cedulaOriginal;

    // PASO 3: Se crean los constructores
    /**
     * Crea el formulario de nuevo inquilino.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     */
    public FrmNuevoInquilino(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
    }

    /**
     * Crea el formulario de nuevo inquilino conectado a la instancia compartida
     * de {@link GestionDatos}, utilizada para insertar el inquilino capturado.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     */
    public FrmNuevoInquilino(java.awt.Frame parent, boolean modal, GestionDatos gestion) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        this.setLocationRelativeTo(parent);
    }

    /**
     * Crea el formulario en modo edición, precargando los datos del inquilino
     * recibido. El inquilino debe haber sido obtenido previamente mediante
     * {@code gestion.buscarInquilino(...)}.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     * @param inquilinoEditar inquilino existente a modificar.
     */
    public FrmNuevoInquilino(java.awt.Frame parent, boolean modal, GestionDatos gestion, Inquilino inquilinoEditar) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        this.inquilinoEditar = inquilinoEditar;
        this.cedulaOriginal = inquilinoEditar.getCedInqui();
        this.setTitle("Editar Inquilino");
        txtCedula.setText(String.valueOf(inquilinoEditar.getCedInqui()));
        txtNombre.setText(inquilinoEditar.getNomInqui());
        cmbGenero.setSelectedItem(inquilinoEditar.getGenero());
        dchFechaNac.setDate(java.util.Date.from(inquilinoEditar.getFechNac().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        txtDireccion.setText(inquilinoEditar.getDireccion());
        txtTelefono.setText(inquilinoEditar.getTelefono());
        txtEmail.setText(inquilinoEditar.getEmail());
        txtOcupacion.setText(inquilinoEditar.getOcupacion());
        btnGuardar.setText("Guardar cambios");
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox();
        lblFechaNac = new javax.swing.JLabel();
        dchFechaNac = new com.toedter.calendar.JDateChooser();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblOcupacion = new javax.swing.JLabel();
        txtOcupacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Inquilino");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos del Inquilino", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCedula.setText("Cédula:");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGenero.setText("Género:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        lblFechaNac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFechaNac.setText("Fecha Nac.:");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelefono.setText("Teléfono:");

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+506-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblOcupacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOcupacion.setText("Ocupación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula)
                    .addComponent(lblNombre)
                    .addComponent(lblGenero)
                    .addComponent(lblFechaNac)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono)
                    .addComponent(lblEmail)
                    .addComponent(lblOcupacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula)
                    .addComponent(txtNombre)
                    .addComponent(cmbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dchFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDireccion)
                    .addComponent(txtTelefono)
                    .addComponent(txtEmail)
                    .addComponent(txtOcupacion))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNac)
                    .addComponent(dchFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOcupacion)
                    .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
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
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
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
     * Valida los campos obligatorios y, según el modo del formulario, agrega un
     * nuevo inquilino o modifica el inquilino recibido en el constructor de
     * edición. Ambas operaciones se realizan exclusivamente mediante
     * {@code gestion.agregarInquilino(...)} / {@code gestion.modificarInquilino(...)};
     * la validación de cédula duplicada es responsabilidad exclusiva de
     * GestionDatos.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        String genero = (String) cmbGenero.getSelectedItem();
        Date fecha = dchFechaNac.getDate();
        String direccion = txtDireccion.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();
        String ocupacion = txtOcupacion.getText().trim();

        if (cedula.isEmpty() || nombre.isEmpty() || genero == null || fecha == null
                || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty() || ocupacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        int cedulaNumerica;
        try {
            cedulaNumerica = Integer.parseInt(cedula);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cédula del inquilino debe ser numérica.");
            return;
        }

        if (cedulaNumerica <= 0) {
            JOptionPane.showMessageDialog(this, "La cédula del inquilino debe ser un número positivo.");
            return;
        }

        LocalDate fechaNac = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (fechaNac.isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser una fecha futura.");
            return;
        }

        Inquilino datos = new Inquilino(cedulaNumerica, nombre, genero, fechaNac, direccion, telefono, email, ocupacion);

        if (inquilinoEditar == null) {
            // Modo insertar
            boolean agregado = gestion.agregarInquilino(datos);
            if (agregado) {
                JOptionPane.showMessageDialog(this, "Inquilino agregado correctamente.");
                Limpiar();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar: ya existe un inquilino con esa cédula.");
            }
        } else {
            // Modo editar
            boolean modificado = gestion.modificarInquilino(cedulaOriginal, datos);
            if (modificado) {
                JOptionPane.showMessageDialog(this, "Inquilino modificado correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar: el inquilino no existe o la cédula ya pertenece a otro inquilino.");
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
        txtCedula.setText("");
        txtNombre.setText("");
        cmbGenero.setSelectedIndex(0);
        dchFechaNac.setDate(null);
        txtDireccion.setText("");
        txtTelefono.setValue(null);
        txtEmail.setText("");
        txtOcupacion.setText("");
        txtCedula.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbGenero;
    private com.toedter.calendar.JDateChooser dchFechaNac;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOcupacion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOcupacion;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
