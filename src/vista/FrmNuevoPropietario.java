package vista;

import clases.Propietario;
import datos.GestionDatos;
import javax.swing.JOptionPane;

/**
 * Formulario de captura de datos para insertar o modificar un propietario.
 * Utiliza la instancia compartida de {@link GestionDatos} para registrar o
 * actualizar el propietario; no manipula ningún {@code ArrayList} directamente.
 *
 * @author
 */
public class FrmNuevoPropietario extends javax.swing.JDialog {

    // PASO 1: Se crea la clase
    // PASO 2: Se crean los atributos
    private GestionDatos gestion;
    private Propietario propietarioEditar;
    private int cedulaOriginal;

    // PASO 3: Se crean los constructores
    /**
     * Crea el formulario para insertar un nuevo propietario.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     */
    public FrmNuevoPropietario(java.awt.Frame parent, boolean modal, GestionDatos gestion) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        this.setLocationRelativeTo(parent);
    }

    /**
     * Crea el formulario en modo edición, precargando los datos del propietario
     * recibido. El propietario debe haber sido obtenido previamente mediante
     * {@code gestion.buscarPropietario(...)}.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     * @param propietarioEditar propietario existente a modificar.
     */
    public FrmNuevoPropietario(java.awt.Frame parent, boolean modal, GestionDatos gestion, Propietario propietarioEditar) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        this.propietarioEditar = propietarioEditar;
        this.cedulaOriginal = propietarioEditar.getCedPropiet();
        this.setTitle("Editar Propietario");
        txtCedula.setText(String.valueOf(propietarioEditar.getCedPropiet()));
        txtNombre.setText(propietarioEditar.getNomPropiet());
        cmbGenero.setSelectedItem(propietarioEditar.getGenero());
        txtDireccion.setText(propietarioEditar.getDireccion());
        txtTelefono.setText(propietarioEditar.getTelefono());
        txtEmail.setText(propietarioEditar.getEmail());
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
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Propietario");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos del Propietario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCedula.setText("Cédula:");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGenero.setText("Género:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

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
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula)
                    .addComponent(txtNombre)
                    .addComponent(cmbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDireccion)
                    .addComponent(txtTelefono)
                    .addComponent(txtEmail))
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
     * nuevo propietario o modifica el propietario recibido en el constructor de
     * edición. Ambas operaciones se realizan exclusivamente mediante {@code gestion.agregarPropietario(...)} /
     * {@code gestion.modificarPropietario(...)}; la validación de duplicados es
     * responsabilidad exclusiva de GestionDatos.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        String genero = (String) cmbGenero.getSelectedItem();
        String direccion = txtDireccion.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();

        if (cedula.isEmpty() || nombre.isEmpty() || genero == null
                || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        int cedulaNumerica;
        try {
            cedulaNumerica = Integer.parseInt(cedula);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cédula del propietario debe ser numérica.");
            return;
        }

        if (cedulaNumerica <= 0) {
            JOptionPane.showMessageDialog(this, "La cédula del propietario debe ser un número positivo.");
            return;
        }

        Propietario datos = new Propietario(cedulaNumerica, nombre, genero, direccion, telefono, email);

        if (propietarioEditar == null) {
            // Modo insertar
            boolean agregado = gestion.agregarPropietario(datos);
            if (agregado) {
                JOptionPane.showMessageDialog(this, "Propietario agregado correctamente.");
                Limpiar();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar: ya existe un propietario con esa cédula.");
            }
        } else {
            // Modo editar
            boolean modificado = gestion.modificarPropietario(cedulaOriginal, datos);
            if (modificado) {
                JOptionPane.showMessageDialog(this, "Propietario modificado correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar: el propietario no existe o la cédula ya pertenece a otro propietario.");
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
        txtDireccion.setText("");
        txtTelefono.setValue(null);
        txtEmail.setText("");
        txtCedula.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
