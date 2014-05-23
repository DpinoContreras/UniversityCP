/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitetris;

import data.Figura;
import data.Mueve;
import data.Rejilla;

/**
 *
 * @author benito
 */
public class TetrisFrame extends javax.swing.JFrame {

    private Rejilla rejilla;
    private Figura figura;
    private Mueve mueve;
    
    /**
     * Creates new form TetrisFrame
     */
    public TetrisFrame() {
        initComponents();
        this.rejilla = new Rejilla(12, 22);
        this.mueve   = new Mueve(this, 2);
        nuevaFigura();
        mueve.reanudar();
    }

    /**
     * Obtiene una referencia a la Rejilla deljuego.
     *
     * @return una referencia a la Rejilla del juego.
     */
    public Rejilla getRejilla() {
        return this.rejilla;
    }

    /**
     * Obtiene una referencia a la Figura que cae actualmente en el juego.
     *
     * @return una referencia a la Figura actual.
     */
    public Figura getFigura() {
        return this.figura;
    }

    /**
     * Obtiene una nueva figura cuyo tipo es seleccionado de forma aleatoria
     */
    public void nuevaFigura() {
        figura = Figura.nuevaFigura();
    }

    /**
     * Deja VACIA todas las celdas de la Rejilla, la inicializa de nuevo. Además
     * genera una nueva Figura de tipo aleatorio
     */
    public void inicializaJuego() {
        rejilla.initRejilla();
        nuevaFigura();
    }

    /**
     * Obtiene una referencia al panel donde se dibujandel juego
     *
     * @return una referencia al panel las piezas del juego
     */
    public RejillaPanel getPanel() {
        return rejillaPanel1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rejillaPanel1 = new RejillaPanel(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout rejillaPanel1Layout = new javax.swing.GroupLayout(rejillaPanel1);
        rejillaPanel1.setLayout(rejillaPanel1Layout);
        rejillaPanel1Layout.setHorizontalGroup(
            rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        rejillaPanel1Layout.setVerticalGroup(
            rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        fileMenu.setMnemonic('F');
        fileMenu.setText("Archivo");
        fileMenu.setToolTipText("Archivo");

        newItem.setMnemonic('N');
        newItem.setText("Nuevo");
        newItem.setToolTipText("Nuevo");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
        fileMenu.add(newItem);

        exitItem.setMnemonic('X');
        exitItem.setText("Salir");
        exitItem.setToolTipText("Salir");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rejillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rejillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemActionPerformed
        inicializaJuego();
        mueve.reanudar();
    }//GEN-LAST:event_newItemActionPerformed

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
            java.util.logging.Logger.getLogger(TetrisFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TetrisFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TetrisFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TetrisFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TetrisFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem newItem;
    private guitetris.RejillaPanel rejillaPanel1;
    // End of variables declaration//GEN-END:variables
}
