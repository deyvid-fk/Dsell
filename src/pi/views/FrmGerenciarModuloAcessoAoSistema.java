/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.views;

import static java.awt.EventQueue.invokeLater;
import java.io.UnsupportedEncodingException;
import static java.lang.Integer.parseInt;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import pi.controller.CadastrarLogin;
import pi.controller.seguranca.ModuloAcesso;
import static pi.controller.seguranca.Sessao.getSessao;
import pi.model.ModelLogin;
import pi.views.system.Menu;

/**
 *
 * @author Deyvid
 */
public class FrmGerenciarModuloAcessoAoSistema extends javax.swing.JFrame {

    private static FrmGerenciarModuloAcessoAoSistema instancia;
    private List menus = new ArrayList<>();
    private static FrmCadastrarPF formCadastrarPF;
    private static int idUser;

    public FrmGerenciarModuloAcessoAoSistema() {
        initComponents();
        this.idUser = getSessao().get(0).getUser().getId();
        this.txtLogin.setText(getSessao().get(0).getUser().getNome());
        this.btnSistema.setVisible(false);
        this.lblSistema.setVisible(false);
    }

    public FrmGerenciarModuloAcessoAoSistema(FrmCadastrarPF frm) {
        initComponents();
        FrmGerenciarModuloAcessoAoSistema.formCadastrarPF = frm;
        this.idUser = parseInt(formCadastrarPF.getTxtID().getText());
        this.txtLogin.setText(frm.getTxtNome().getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtLogin = new javax.swing.JTextField();
        btnSistema = new javax.swing.JToggleButton();
        lblSistema = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);

        jLabel5.setText("Senha");

        jLabel4.setText("Nome de Usuario");

        btnSistema.setText("Nao");
        btnSistema.setToolTipText("Habilitar módulo: Config. do Sistema");
        btnSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSistemaActionPerformed(evt);
            }
        });

        lblSistema.setText("SISTEMA        ->");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Nao");
        jToggleButton2.setToolTipText("Habilitar módulo: Relatórios");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Nao");
        jToggleButton1.setToolTipText("Habilitar módulo: Cadastro");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("CADASTRO    ->");

        jLabel2.setText("RELATÓRIOS ->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSenha)
                    .addComponent(txtLogin)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblSistema))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSistema)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jToggleButton1)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblSistema))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jToggleButton2)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSistema)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaActionPerformed
        if (btnSistema.isSelected()) {
            menus.add(Menu.SISTEMA);
            btnSistema.setText("Ok");
        } else {
            btnSistema.setText("Nao");
            menus.remove(Menu.SISTEMA);
        }
    }//GEN-LAST:event_btnSistemaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ModelLogin login = new ModelLogin();

        CadastrarLogin cadastro = new CadastrarLogin();
        ModuloAcesso moduloAcesso = new ModuloAcesso();
        List lista = new ArrayList<>();
        login.setId(this.idUser);
        login.setUsername(txtLogin.getText());
        lista.add(login);
        try {
            login.setPass(txtSenha.getText());
            cadastro.creat(login);
            moduloAcesso.addModuloAcesso(this.idUser, menus);
            showMessageDialog(this, "Configuracoes salvas com sucesso!");
            this.dispose();
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (jToggleButton2.isSelected()) {
            menus.add(Menu.RELATORIO);
            jToggleButton2.setText("Ok");
            jToggleButton2.setToolTipText("Módulo Habilitado");
        } else {
            jToggleButton2.setText("Nao");
            jToggleButton2.setToolTipText("Módulo Desabilitado");
            menus.remove(Menu.RELATORIO);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            menus.add(Menu.CADASTRO);
            jToggleButton1.setText("Ok");
            jToggleButton1.setToolTipText("Módulo Habilitado");
        } else {
            jToggleButton1.setText("Nao");
            jToggleButton1.setToolTipText("Módulo Desabilitado");
            menus.remove(Menu.CADASTRO);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(FrmGerenciarModuloAcessoAoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmGerenciarModuloAcessoAoSistema().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnSistema;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel lblSistema;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = getLogger(FrmGerenciarModuloAcessoAoSistema.class.getName());
}
