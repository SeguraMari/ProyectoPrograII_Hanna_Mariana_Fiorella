
package vista;

import clases.Mensualidades;
import datos.GestionDatos;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Graciela_Hanna_Fiorella
 */

public class DlgGestionMensualidades extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DlgGestionMensualidades.class.getName());

    private GestionDatos gestion;
    private ArrayList<Mensualidades> mensualidadesMostradas = new ArrayList<>();

    /**
     * Creates new form DlgGestionMensualidades
     */
    public DlgGestionMensualidades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Crea el diálogo utilizando la única instancia de {@link GestionDatos}
     * compartida por la aplicación. Es el constructor utilizado por
     * {@code FramePrincipal}.
     *
     * @param parent ventana padre del diálogo.
     * @param modal indica si el diálogo es modal.
     * @param gestion instancia compartida de GestionDatos.
     */
    public DlgGestionMensualidades(java.awt.Frame parent, boolean modal, GestionDatos gestion) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        txtFechActual.setText(LocalDate.now().toString());
        txtFechActual.setEditable(false);
        cargarTabla();
    }

    /**
     * Carga en {@code tblMensualidades} todas las mensualidades existentes en
     * GestionDatos, sin aplicar ningún filtro.
     */
    private void cargarTabla() {
        mostrarMensualidades(gestion.obtenerMensualidades());
    }

    /**
     * Carga datos en la tabla 
     */
    private void aplicarFiltro() {
        String texto = txtFiltrar.getText();
        texto = texto.trim();

        if (chkInquilino.isSelected() == false && chkMes.isSelected() == false && chkAnio.isSelected() == false) {
            cargarTabla();
            return;
        }
        if (texto.equals("")) {
            cargarTabla();
            return;
        }

        int mesBuscado = -1;
        int anioBuscado = -1;

        if (chkMes.isSelected() == true) {
            try {
                mesBuscado = Integer.parseInt(texto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El mes debe ser un número.");
                return;
            }
        }

        if (chkAnio.isSelected() == true) {
            try {
                anioBuscado = Integer.parseInt(texto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El año debe ser un número.");
                return;
            }
        }

        ArrayList<Mensualidades> mensualidades = gestion.obtenerMensualidades();
        ArrayList<Mensualidades> resultado = new ArrayList<>();

        for (int i = 0; i < mensualidades.size(); i++) {

            Mensualidades men = mensualidades.get(i);
            boolean coincide = true;

            if (chkInquilino.isSelected() == true) {
                String nombre = men.getNomInquilino();
                nombre = nombre.toLowerCase();
                if (nombre.contains(texto.toLowerCase()) == false) {
                    coincide = false;
                }
            }

            if (chkMes.isSelected() == true) {
                if (men.getMesCobro() != mesBuscado) {
                    coincide = false;
                }
            }

            if (chkAnio.isSelected() == true) {
                if (men.getAnioActual() != anioBuscado) {
                    coincide = false;
                }
            }
            if (coincide == true) {
                resultado.add(men);
            }
        }
         mostrarMensualidades(resultado);


    }

    /**
     * Construye el modelo de {@code tblMensualidades} a partir de la lista de
     * mensualidades recibida, manteniendo el orden en que aparecen en la lista
     * y usando exclusivamente los getters de {@link Mensualidades}. Se usa
     * tanto para mostrar el listado completo como para mostrar el resultado de
     * un filtrado.
     *
     * @param mensualidades mensualidades a mostrar en la tabla.
     */
    private void mostrarMensualidades(ArrayList<Mensualidades> mensualidades) {
        String[] columnas = {"Consecutivo", "Num Alquiler", "Fech Creacion", "Inquilino",
            "Mes Cobro", "Año", "Descuento", "Monto a Pagar", "Estado"};
        Object[][] datos = new Object[mensualidades.size()][columnas.length];
        for (int fila = 0; fila < mensualidades.size(); fila++) {
            Mensualidades m = mensualidades.get(fila);
            datos[fila][0] = m.getConsecutivo();
            datos[fila][1] = m.getNumAlquiler();
            datos[fila][2] = m.getFechCreacion();
            datos[fila][3] = m.getNomInquilino();
            datos[fila][4] = m.getMesCobro();
            datos[fila][5] = m.getAnioActual();
            datos[fila][6] = m.getDescuento();
            datos[fila][7] = m.getMontoMes();
            datos[fila][8] = m.getEstado();
        }
        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        tblMensualidades.setModel(model);
        mensualidadesMostradas = mensualidades;
    }

    /**
     * Abre {@link DlgInfoMensualidad} con la mensualidad real correspondiente a
     * la fila seleccionada de {@code tblMensualidades}, ubicándola en
     * {@code mensualidadesMostradas} (la misma lista, filtrada o completa, con
     * la que se construyó la tabla actualmente visible).
     */
    private void tblMensualidadesMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() != 2) {
            return;
        }
        int fila = tblMensualidades.getSelectedRow();
        if (fila < 0 || fila >= mensualidadesMostradas.size()) {
            return;
        }
        Mensualidades seleccionada = mensualidadesMostradas.get(fila);
        DlgInfoMensualidad info = new DlgInfoMensualidad(null, true, gestion, seleccionada);
        info.setLocationRelativeTo(this);
        info.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMensualidades = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechActual = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        cmbmesGen = new javax.swing.JComboBox<>();
        txtAnioGen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        btnMostrarMensualidades = new javax.swing.JButton();
        cmbMes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chkInquilino = new javax.swing.JCheckBox();
        chkMes = new javax.swing.JCheckBox();
        chkAnio = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion De Mensualidades");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        tblMensualidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Consecutivo", "Num Alquiler", "Fech Creacion", "Inquilino", "Mes Cobro", "Año", "Descuento", "Monto a Pagar", "Estado"
            }
        ));
        tblMensualidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMensualidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMensualidades);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Fecha Actual");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Mes");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Año");

        txtFechActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechActualActionPerformed(evt);
            }
        });

        btnGenerar.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        cmbmesGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero ", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbmesGen, 0, 136, Short.MAX_VALUE)
                            .addComponent(txtAnioGen)
                            .addComponent(txtFechActual)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnGenerar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFechActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbmesGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAnioGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("Mes");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("Año");

        btnMostrarMensualidades.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        btnMostrarMensualidades.setText("Mostrar Mensualidades");
        btnMostrarMensualidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarMensualidadesActionPerformed(evt);
            }
        });

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero ", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMostrarMensualidades)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAnio)
                            .addComponent(cmbMes, 0, 114, Short.MAX_VALUE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMostrarMensualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel6.setText("Generar Mensualidades");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel7.setText("Mostrar Mensualidades");

        chkInquilino.setText("Inquilino");

        chkMes.setText("Mes");

        chkAnio.setText("Año");

        jLabel8.setText("Filtrar Por:");

        jLabel9.setText("Todos los Registros de Mensualidades ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(141, 141, 141))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(chkInquilino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkMes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkAnio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFiltrar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(chkInquilino)
                    .addComponent(chkMes)
                    .addComponent(chkAnio)
                    .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Obtiene el mes seleccionado en {@code jComboBox1} (índice 0 = Enero, ...,
     * índice 11 = Diciembre) y el año ingresado en {@code jTextField4}, y llama
     * exclusivamente a {@code gestion.generarMensualidades(mes, anio)}. La
     * interfaz no recorre alquileres, no calcula descuentos ni montos, y no
     * crea objetos {@link clases.Mensualidades} directamente: toda esa lógica
     * es responsabilidad exclusiva del motor ya implementado en
     * {@code GestionDatos}.
     */
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {
    int mes = cmbmesGen.getSelectedIndex() + 1;

    String textoAnio = txtAnioGen.getText().trim();
    int anio;
    try {
        anio = Integer.parseInt(textoAnio);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El año debe ser numérico.");
        return;
    }

    int resultado = gestion.generarMensualidades(mes, anio);

    if (resultado == -1) {
        JOptionPane.showMessageDialog(this, "No se pueden generar mensualidades para un periodo anterior al actual.");
    } else if (resultado == 0) {
        JOptionPane.showMessageDialog(this, "No se generaron nuevas mensualidades para el periodo seleccionado.");
    } else {
        JOptionPane.showMessageDialog(this, "Se generaron " + resultado + " mensualidades correctamente.");
    }
    aplicarFiltro();
}

    /**
     * Lee el estado actual de los filtros ({@code chkMes}/{@code cmbMes},
     * {@code chkAnio}/{@code txtAnio}, {@code chkInquilino}/{@code txtFiltrar})
     * y muestra en {@code tblMensualidades} únicamente las mensualidades de
     * {@code gestion.obtenerMensualidades()} que cumplan todos los filtros
     * activos. Un filtro cuyo checkbox no está marcado no restringe el
     * resultado. La fuente de datos siempre se relee en el momento del clic,
     * por lo que una mensualidad recién generada aparece de inmediato.
     */
    private void btnMostrarMensualidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarMensualidadesActionPerformed
        int mes = cmbMes.getSelectedIndex() + 1;

        String textoAnio = txtAnio.getText().trim();
        int anio;
        try {
            anio = Integer.parseInt(textoAnio);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El año debe ser numérico.");
            return;
        }

        ArrayList<Mensualidades> resultado = new ArrayList<>();
        for (Mensualidades m : gestion.obtenerMensualidades()) {
            if (m.getMesCobro() == mes && m.getAnioActual() == anio) {
                resultado.add(m);
            }
        }

        DlgInfoMensualidad info = new DlgInfoMensualidad(null, true, gestion, resultado, mes, anio);
        info.setLocationRelativeTo(this);
        info.setVisible(true);
    }//GEN-LAST:event_btnMostrarMensualidadesActionPerformed

    private void txtFechActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechActualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            DlgGestionMensualidades dialog = new DlgGestionMensualidades(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnMostrarMensualidades;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkAnio;
    private javax.swing.JCheckBox chkInquilino;
    private javax.swing.JCheckBox chkMes;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbmesGen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMensualidades;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAnioGen;
    private javax.swing.JTextField txtFechActual;
    private javax.swing.JTextField txtFiltrar;
    // End of variables declaration//GEN-END:variables
}
