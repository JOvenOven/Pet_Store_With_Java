/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventamascotas;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Owen
 */
public class RegistroCompras extends javax.swing.JFrame {

    private SerializarObjetos so;
    private ArrayList<Venta> listaVentas;
    private File ficheroVentas=new File("Ventas.txt");
    private ArrayList<Usuario> listaUsuarios;
    private File ficheroUsuarios=new File("Usuarios.txt");
    private int indiceusuario;
    
    /**
     * Creates new form ComprasRealizadas
     */
    
    
    
    public RegistroCompras() {
        initComponents();
    }

    public RegistroCompras(int indiceusuario) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.indiceusuario=indiceusuario;
        modelo.addColumn("Cliente");
        modelo.addColumn("Venta de");
        modelo.addColumn("Precio");
        modelo.addColumn("IVA");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Total");
        modelo.addColumn("Fecha");
        modelo.addColumn("Folio");
        so=new SerializarObjetos();
        listaUsuarios=so.deserializarArrayUser(ficheroUsuarios);
        if(so.deserializarArrayVenta(ficheroVentas) != null){
            listaVentas=so.deserializarArrayVenta(ficheroVentas);
        for(int i=0;i<listaVentas.size();i++){
            if(listaVentas.get(i).getComprador().equalsIgnoreCase(listaUsuarios.get(indiceusuario).getCuenta())){
                int[] fecha=listaVentas.get(i).getFecha();
                String dia=Integer.toString(fecha[0]);
                String mes=Integer.toString(fecha[1]);
                String año=Integer.toString(fecha[2]);
                String fechac=new String(dia + "/"+ mes+ "/"+ año);
                modelo.addRow(new Object [] {listaVentas.get(i).getComprador(),listaVentas.get(i).getVenta(),
                    listaVentas.get(i).getPrecio(),listaVentas.get(i).getIVA(),listaVentas.get(i).getSubtotal(),
                    listaVentas.get(i).getTotal(),fechac,listaVentas.get(i).getFolio()});
            }
        }
        }
        listaVentas= new ArrayList<Venta>();
        listaUsuarios= new ArrayList<Usuario>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modelo=new DefaultTableModel();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(605, 631));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel1.setText("Registro de Compras");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Tienda               |");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registro de Compras               |");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        IniciarSesion is=new IniciarSesion();
        this.dispose();
        is.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        Tienda t=new Tienda(indiceusuario);
        t.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private DefaultTableModel modelo;
    // End of variables declaration//GEN-END:variables
}
