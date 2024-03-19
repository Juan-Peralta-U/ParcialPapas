/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author cesar
 */
public class CRUDFrame extends javax.swing.JFrame {

    /**
     * Creates new form CRUDJFrame
     */
    public CRUDFrame() {
        UIManager.put("ScrollBarUI", "javax.swing.plaf.basic.BasicScrollBarUI"); // Cambiar Scroll por defecto
        initComponents();
        getContentPane().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panePaneles = new javax.swing.JTabbedPane();
        panelInsertar = new javax.swing.JPanel();
        labZonaProd = new javax.swing.JLabel();
        labBayas = new javax.swing.JLabel();
        labHabito = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txAreaFloracion = new javax.swing.JTextArea();
        labTuberculos = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txAreaHabito = new javax.swing.JTextArea();
        fieldEspecie = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txAreaBayas = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txAreaTuberculos = new javax.swing.JTextArea();
        labNombre = new javax.swing.JLabel();
        labFloracion = new javax.swing.JLabel();
        labEspecie = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        comboZonaProd = new javax.swing.JComboBox<>();
        panelGestionar = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMuestra = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        comboBusqueda = new javax.swing.JComboBox<>();
        fieldDato = new javax.swing.JTextField();
        comboDatos = new javax.swing.JComboBox<>();
        labelTitulo = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panePaneles.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N

        panelInsertar.setBackground(new java.awt.Color(233, 243, 255));
        panelInsertar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 24, 89), 1, true));

        labZonaProd.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labZonaProd.setText("Zona de producción:");

        labBayas.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labBayas.setText("Bayas:");

        labHabito.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labHabito.setText("Hábito de crecimiento:");

        txAreaFloracion.setColumns(20);
        txAreaFloracion.setLineWrap(true);
        txAreaFloracion.setRows(5);
        jScrollPane6.setViewportView(txAreaFloracion);

        labTuberculos.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labTuberculos.setText("Tubérculos:");

        fieldNombre.setEditable(false);
        fieldNombre.setFocusable(false);

        txAreaHabito.setColumns(20);
        txAreaHabito.setLineWrap(true);
        txAreaHabito.setRows(5);
        jScrollPane2.setViewportView(txAreaHabito);

        fieldEspecie.setEditable(false);
        fieldEspecie.setFocusable(false);

        txAreaBayas.setColumns(20);
        txAreaBayas.setLineWrap(true);
        txAreaBayas.setRows(5);
        jScrollPane3.setViewportView(txAreaBayas);

        txAreaTuberculos.setColumns(20);
        txAreaTuberculos.setLineWrap(true);
        txAreaTuberculos.setRows(5);
        jScrollPane4.setViewportView(txAreaTuberculos);

        labNombre.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labNombre.setText("Nombre:");

        labFloracion.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labFloracion.setText("Floración:");

        labEspecie.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labEspecie.setText("Especie:");

        btnInsertar.setBackground(new java.awt.Color(255, 255, 255));
        btnInsertar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(13, 24, 89));
        btnInsertar.setText("Insertar");
        btnInsertar.setActionCommand("InsertarCRUD");
        btnInsertar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 24, 89), 1, true));
        btnInsertar.setContentAreaFilled(false);

        comboZonaProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout panelInsertarLayout = new javax.swing.GroupLayout(panelInsertar);
        panelInsertar.setLayout(panelInsertarLayout);
        panelInsertarLayout.setHorizontalGroup(
            panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInsertarLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelInsertarLayout.createSequentialGroup()
                            .addComponent(labEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInsertarLayout.createSequentialGroup()
                            .addComponent(labZonaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboZonaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInsertarLayout.createSequentialGroup()
                            .addComponent(labNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInsertarLayout.createSequentialGroup()
                            .addComponent(labHabito, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2))
                        .addGroup(panelInsertarLayout.createSequentialGroup()
                            .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labBayas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labFloracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labTuberculos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(100, 100, 100))
        );
        panelInsertarLayout.setVerticalGroup(
            panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombre)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEspecie)
                    .addComponent(fieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labZonaProd)
                    .addComponent(comboZonaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labHabito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labFloracion)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labBayas)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labTuberculos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panePaneles.addTab("Insertar", panelInsertar);

        panelGestionar.setBackground(new java.awt.Color(233, 243, 255));
        panelGestionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 24, 89), 1, true));

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(13, 24, 89));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 24, 89), 1, true));
        btnConsultar.setContentAreaFilled(false);

        tablaMuestra.setBackground(new java.awt.Color(255, 255, 255));
        tablaMuestra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        tablaMuestra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMuestra);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(13, 24, 89));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 24, 89), 1, true));
        btnEliminar.setContentAreaFilled(false);

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(13, 24, 89));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 24, 89), 1, true));
        btnActualizar.setContentAreaFilled(false);

        comboBusqueda.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        comboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Tipo de búsqueda--" }));
        comboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGestionarLayout = new javax.swing.GroupLayout(panelGestionar);
        panelGestionar.setLayout(panelGestionarLayout);
        panelGestionarLayout.setHorizontalGroup(
            panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionarLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestionarLayout.createSequentialGroup()
                        .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDato, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestionarLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestionarLayout.createSequentialGroup()
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        panelGestionarLayout.setVerticalGroup(
            panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestionarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fieldDato.setVisible(false);

        panePaneles.addTab("Gestionar", panelGestionar);

        labelTitulo.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        labelTitulo.setText("Papa Manager");

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(13, 24, 89));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setActionCommand("LimpiarCRUD");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 24, 89)));
        btnLimpiar.setContentAreaFilled(false);

        btnLimpiar1.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnLimpiar1.setForeground(new java.awt.Color(13, 24, 89));
        btnLimpiar1.setText("Salir");
        btnLimpiar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 24, 89)));
        btnLimpiar1.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panePaneles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panePaneles, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnLimpiar1;
    public javax.swing.JComboBox<String> comboBusqueda;
    public javax.swing.JComboBox<String> comboDatos;
    public javax.swing.JComboBox<String> comboZonaProd;
    public javax.swing.JTextField fieldDato;
    public javax.swing.JTextField fieldEspecie;
    public javax.swing.JTextField fieldNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JLabel labBayas;
    public javax.swing.JLabel labEspecie;
    public javax.swing.JLabel labFloracion;
    public javax.swing.JLabel labHabito;
    public javax.swing.JLabel labNombre;
    public javax.swing.JLabel labTuberculos;
    public javax.swing.JLabel labZonaProd;
    private javax.swing.JLabel labelTitulo;
    public javax.swing.JTabbedPane panePaneles;
    public javax.swing.JPanel panelGestionar;
    public javax.swing.JPanel panelInsertar;
    public javax.swing.JTable tablaMuestra;
    public javax.swing.JTextArea txAreaBayas;
    public javax.swing.JTextArea txAreaFloracion;
    public javax.swing.JTextArea txAreaHabito;
    public javax.swing.JTextArea txAreaTuberculos;
    // End of variables declaration//GEN-END:variables
}
