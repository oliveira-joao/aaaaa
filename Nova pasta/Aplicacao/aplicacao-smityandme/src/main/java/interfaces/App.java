/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominios.Funcionario;
import funcionamento.sistema.LoginUsuario;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import model.dao.FuncionarioDao;

/**
 *
 * @author victor.pederzini
 */
public class App extends javax.swing.JFrame {

    private Integer contador = 0;

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        trocarIconeDaJanela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSProgressCircleUIAnimated11 = new rojerusan.complementos.RSProgressCircleUIAnimated1();
        rSProgressCircleAnimatedUnoBeanInfo1 = new rojerusan.componentes.RSProgressCircleAnimatedUnoBeanInfo();
        pnlBackground = new javax.swing.JPanel();
        imgSmy = new javax.swing.JLabel();
        lblTextoLogin = new javax.swing.JLabel();
        pnlInputs = new javax.swing.JPanel();
        lblTextoSenha = new javax.swing.JLabel();
        lblTextoEmail = new javax.swing.JLabel();
        txtValorEmail = new javax.swing.JTextField();
        imgOlho = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtValorSenha = new javax.swing.JPasswordField();
        imgLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setMaximumSize(new java.awt.Dimension(1000, 600));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1000, 600));
        pnlBackground.setName(""); // NOI18N
        pnlBackground.setPreferredSize(new java.awt.Dimension(1000, 600));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgSmy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/smy.png"))); // NOI18N
        pnlBackground.add(imgSmy, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 358, -1, -1));

        lblTextoLogin.setFont(new java.awt.Font("Ebrima", 1, 35)); // NOI18N
        lblTextoLogin.setForeground(new java.awt.Color(47, 104, 166));
        lblTextoLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoLogin.setText("LOGIN");
        lblTextoLogin.setToolTipText("");
        pnlBackground.add(lblTextoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1000, -1));

        pnlInputs.setBackground(new java.awt.Color(255, 255, 255));

        lblTextoSenha.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblTextoSenha.setForeground(new java.awt.Color(67, 67, 67));
        lblTextoSenha.setText("SENHA");

        lblTextoEmail.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblTextoEmail.setForeground(new java.awt.Color(67, 67, 67));
        lblTextoEmail.setText("E-MAIL");

        txtValorEmail.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtValorEmail.setForeground(new java.awt.Color(67, 67, 67));
        txtValorEmail.setMargin(new java.awt.Insets(2, 20, 2, 2));
        txtValorEmail.setMaximumSize(new java.awt.Dimension(40, 336));
        txtValorEmail.setMinimumSize(new java.awt.Dimension(40, 336));
        txtValorEmail.setPreferredSize(new java.awt.Dimension(40, 336));

        imgOlho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgOlho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/olhoAberto.png"))); // NOI18N
        imgOlho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgOlhoMouseClicked(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(253, 113, 155));
        btnEntrar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtValorSenha.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtValorSenha.setForeground(new java.awt.Color(67, 67, 67));
        txtValorSenha.setMargin(new java.awt.Insets(2, 20, 2, 2));
        txtValorSenha.setMaximumSize(new java.awt.Dimension(280, 40));
        txtValorSenha.setMinimumSize(new java.awt.Dimension(280, 40));
        txtValorSenha.setPreferredSize(new java.awt.Dimension(280, 40));

        javax.swing.GroupLayout pnlInputsLayout = new javax.swing.GroupLayout(pnlInputs);
        pnlInputs.setLayout(pnlInputsLayout);
        pnlInputsLayout.setHorizontalGroup(
            pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(pnlInputsLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTextoSenha)
                    .addComponent(lblTextoEmail))
                .addGap(29, 29, 29)
                .addGroup(pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValorSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgOlho, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        pnlInputsLayout.setVerticalGroup(
            pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputsLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoEmail)
                    .addComponent(txtValorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTextoSenha)
                        .addComponent(txtValorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imgOlho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnEntrar)
                .addGap(54, 54, 54))
        );

        pnlBackground.add(pnlInputs, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N
        pnlBackground.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 14, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        if ((!txtValorEmail.getText().equalsIgnoreCase("") && !String.valueOf(txtValorSenha.getPassword()).equalsIgnoreCase(""))) {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = new Funcionario();
            LoginUsuario tentativaDeLogin = new LoginUsuario();

            funcionario.setEmailFuncionario(txtValorEmail.getText());
            funcionarioDao.buscarDados(funcionario);

            try {
                tentativaDeLogin.validarLogin(funcionario, String.valueOf(txtValorEmail.getText()), String.valueOf(txtValorSenha.getPassword()));
                if (tentativaDeLogin.getLoginValidado()) {
                    this.dispose();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            if (txtValorEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite seu e-mail!");
            } else {
                JOptionPane.showMessageDialog(null, "Digite sua senha!");
            }
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    private void imgOlhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgOlhoMouseClicked
        if (contador % 2 == 0) {
            imgOlho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/olhoFechado.png")));
            txtValorSenha.setEchoChar((char) 0);
        } else {
            imgOlho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/olhoAberto.png")));
            txtValorSenha.setEchoChar('*');
        }

        contador++;
    }//GEN-LAST:event_imgOlhoMouseClicked

    private void trocarIconeDaJanela() {
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/imagens/smyGrande.png"));
        } catch (Exception e) {
            System.out.println(e);;
        }
        setIconImage(im);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FontFormatException, IOException, UnsupportedLookAndFeelException, InterruptedException {
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgOlho;
    private javax.swing.JLabel imgSmy;
    private javax.swing.JLabel lblTextoEmail;
    private javax.swing.JLabel lblTextoLogin;
    private javax.swing.JLabel lblTextoSenha;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlInputs;
    private rojerusan.componentes.RSProgressCircleAnimatedUnoBeanInfo rSProgressCircleAnimatedUnoBeanInfo1;
    private rojerusan.complementos.RSProgressCircleUIAnimated1 rSProgressCircleUIAnimated11;
    private javax.swing.JTextField txtValorEmail;
    private javax.swing.JPasswordField txtValorSenha;
    // End of variables declaration//GEN-END:variables
}
