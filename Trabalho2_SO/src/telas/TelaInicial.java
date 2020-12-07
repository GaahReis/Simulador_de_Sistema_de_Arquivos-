
/*

	Amanda Valado
	Bruna Lopes
	Gabriel Reis
	Luciana Lorrany
	Luiz Otávio Bissiato
	Marcel Losso

*/

package telas;

import helper.ArquivoHelper;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Arquivo;
import manager.ArquivoManager;

public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcurarArquivoMestre = new javax.swing.JButton();
        btnCriarArquivoMestre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnProcurarArquivoMestre.setText("Abrir Arquivo Mestre");
        btnProcurarArquivoMestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarArquivoMestreActionPerformed(evt);
            }
        });

        btnCriarArquivoMestre.setText("Criar Arquivo Mestre");
        btnCriarArquivoMestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarArquivoMestreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnCriarArquivoMestre)
                .addGap(50, 50, 50)
                .addComponent(btnProcurarArquivoMestre)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcurarArquivoMestre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCriarArquivoMestre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarArquivoMestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarArquivoMestreActionPerformed
        JFileChooser jfcFileChooser = new JFileChooser(new File("./"));
        jfcFileChooser.setVisible(true);
        jfcFileChooser.setApproveButtonText("Abrir");
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo ffm", "ffm");
        jfcFileChooser.setFileFilter(filter);
        jfcFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (jfcFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            String pathAtual = jfcFileChooser.getSelectedFile().toPath().toString();
            ArquivoManager arqMestre = ArquivoHelper.lerDeArquivoMestre(pathAtual);
            arqMestre.getCabecalho().setCaminhoAtual(pathAtual);
            new TelaPrincipal(arqMestre);
            TelaInicial.this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnProcurarArquivoMestreActionPerformed

    private void btnCriarArquivoMestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarArquivoMestreActionPerformed

        JFileChooser fc = new JFileChooser(new File("./"));
        fc.setVisible(true);

        fc.setAcceptAllFileFilterUsed(false);
        fc.setDialogTitle("Selecione a pasta para criar o Arquivo Mestre");
        fc.setApproveButtonText("Criar");
        
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            
            String path = fc.getSelectedFile().getAbsolutePath();
            
            ArquivoManager arqMestre = ArquivoHelper.criarArquivoMestre("ArquivoMestre.ffm", path);
            new TelaPrincipal(arqMestre);
            TelaInicial.this.setVisible(false);

        }
        
    }//GEN-LAST:event_btnCriarArquivoMestreActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarArquivoMestre;
    private javax.swing.JButton btnProcurarArquivoMestre;
    // End of variables declaration//GEN-END:variables
}