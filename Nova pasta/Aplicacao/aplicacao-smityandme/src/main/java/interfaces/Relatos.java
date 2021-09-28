/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import conexao.ConexaoSmy;
import dominios.Funcionario;
import dominios.Relato;
import funcionamento.sistema.GeradorDeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Victor
 */
public class Relatos extends javax.swing.JInternalFrame {

    private Funcionario funcionario = new Funcionario();
    private Relato relato = new Relato();
    private Integer contadorDeRelatos = 0;
    private GeradorDeLog geradorDeLog = new GeradorDeLog();

    /**
     * Creates new form Relatos
     */
    public Relatos() {
        initComponents();
    }
//

    public Relatos(Funcionario funcionarioLogado) {
        initComponents();
        funcionario.setIdFuncionario(funcionarioLogado.getIdFuncionario());
        funcionario.setNomeFuncionario(funcionarioLogado.getNomeFuncionario());
        funcionario.setLoginFuncionario(funcionarioLogado.getLoginFuncionario());
        funcionario.setSenhaFuncionario(funcionarioLogado.getSenhaFuncionario());
        funcionario.setEmailFuncionario(funcionarioLogado.getEmailFuncionario());
        funcionario.setTelefoneFuncionario(funcionarioLogado.getTelefoneFuncionario());
        if (funcionarioLogado.getPermissaoAdmin().equals("Administrador")) {
            funcionario.setPermissaoAdmin(1);
        } else {
            funcionario.setPermissaoAdmin(0);
        }
        funcionario.setEmpresa(funcionarioLogado.getEmpresa());
        funcionario.setTipoFuncionario(funcionarioLogado.getTipoFuncionario());
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        pnlRelatos = new javax.swing.JPanel();
        lblTituloRelatoDiario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imgSmyGrande = new javax.swing.JLabel();
        imgBalaoFala = new javax.swing.JLabel();
        imgFeliz = new javax.swing.JLabel();
        imgNeutro = new javax.swing.JLabel();
        imgTriste = new javax.swing.JLabel();
        radioBtnFeliz = new javax.swing.JRadioButton();
        radioBtnNeutro = new javax.swing.JRadioButton();
        radioBtnTriste = new javax.swing.JRadioButton();
        lblTituloPergunta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaRelato = new javax.swing.JTextArea();
        lblTituloCaracteresRestantes = new javax.swing.JLabel();
        lblValorCaracteresRestantes = new javax.swing.JLabel();
        lblTituloCaracteresRestantes2 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(933, 700));
        setMinimumSize(new java.awt.Dimension(933, 700));
        setPreferredSize(new java.awt.Dimension(933, 700));

        pnlRelatos.setBackground(new java.awt.Color(255, 255, 255));
        pnlRelatos.setMaximumSize(new java.awt.Dimension(917, 670));
        pnlRelatos.setMinimumSize(new java.awt.Dimension(917, 670));

        lblTituloRelatoDiario.setFont(new java.awt.Font("Ebrima", 1, 35)); // NOI18N
        lblTituloRelatoDiario.setForeground(new java.awt.Color(67, 67, 67));
        lblTituloRelatoDiario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloRelatoDiario.setText("RELATO DIÁRIO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        imgSmyGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/smyGrande.png"))); // NOI18N

        imgBalaoFala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/balaoFala.png"))); // NOI18N

        imgFeliz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/feliz.png"))); // NOI18N

        imgNeutro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/neutro.png"))); // NOI18N

        imgTriste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/triste.png"))); // NOI18N

        radioBtnFeliz.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioBtnFeliz);
        radioBtnFeliz.setForeground(new java.awt.Color(47, 104, 166));
        radioBtnFeliz.setSelected(true);
        radioBtnFeliz.setFocusPainted(false);

        radioBtnNeutro.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioBtnNeutro);
        radioBtnNeutro.setFocusPainted(false);

        radioBtnTriste.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioBtnTriste);
        radioBtnTriste.setFocusPainted(false);

        lblTituloPergunta.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        lblTituloPergunta.setForeground(new java.awt.Color(67, 67, 67));
        lblTituloPergunta.setText("COMO VOCÊ SE SENTE HOJE?");

        txtAreaRelato.setBackground(new java.awt.Color(230, 230, 230));
        txtAreaRelato.setColumns(20);
        txtAreaRelato.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        txtAreaRelato.setForeground(new java.awt.Color(67, 67, 67));
        txtAreaRelato.setLineWrap(true);
        txtAreaRelato.setRows(4);
        txtAreaRelato.setAutoscrolls(false);
        txtAreaRelato.setMargin(new java.awt.Insets(10, 10, 0, 10));
        txtAreaRelato.setMaximumSize(new java.awt.Dimension(300, 125));
        txtAreaRelato.setMinimumSize(new java.awt.Dimension(300, 125));
        txtAreaRelato.setSelectionColor(new java.awt.Color(253, 113, 155));
        txtAreaRelato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaRelatoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaRelato);

        lblTituloCaracteresRestantes.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        lblTituloCaracteresRestantes.setText("Caracteres restantes (");

        lblValorCaracteresRestantes.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        lblValorCaracteresRestantes.setText("150");

        lblTituloCaracteresRestantes2.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        lblTituloCaracteresRestantes2.setText("/150)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(lblTituloPergunta))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(imgBalaoFala))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTituloCaracteresRestantes)
                        .addGap(0, 0, 0)
                        .addComponent(lblValorCaracteresRestantes)
                        .addGap(0, 0, 0)
                        .addComponent(lblTituloCaracteresRestantes2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgSmyGrande)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imgFeliz)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(radioBtnFeliz)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(imgNeutro)
                                        .addGap(74, 74, 74))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioBtnNeutro)
                                        .addGap(100, 100, 100)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imgTriste)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(radioBtnTriste))))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(imgSmyGrande)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTituloPergunta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(imgBalaoFala)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgTriste)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtnTriste))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgNeutro)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtnNeutro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgFeliz)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtnFeliz)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloCaracteresRestantes)
                    .addComponent(lblValorCaracteresRestantes)
                    .addComponent(lblTituloCaracteresRestantes2)))
        );

        btnEnviar.setBackground(new java.awt.Color(253, 113, 155));
        btnEnviar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("ENVIAR");
        btnEnviar.setBorder(null);
        btnEnviar.setMaximumSize(new java.awt.Dimension(127, 41));
        btnEnviar.setMinimumSize(new java.awt.Dimension(127, 41));
        btnEnviar.setName(""); // NOI18N
        btnEnviar.setPreferredSize(new java.awt.Dimension(127, 41));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRelatosLayout = new javax.swing.GroupLayout(pnlRelatos);
        pnlRelatos.setLayout(pnlRelatosLayout);
        pnlRelatosLayout.setHorizontalGroup(
            pnlRelatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatosLayout.createSequentialGroup()
                .addGroup(pnlRelatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloRelatoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRelatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRelatosLayout.createSequentialGroup()
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );
        pnlRelatosLayout.setVerticalGroup(
            pnlRelatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTituloRelatoDiario)
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlRelatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRelatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAreaRelatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaRelatoKeyReleased
        int max = 150;
        if (txtAreaRelato.getText().length() >= max) {
            evt.consume();
            String shortened = txtAreaRelato.getText().substring(0, max);
            txtAreaRelato.setText(shortened);
            lblValorCaracteresRestantes.setText("0");
        } else {
            Integer numCaracteres = max - (txtAreaRelato.getText().length());
            lblValorCaracteresRestantes.setText(numCaracteres.toString());
            evt.consume();
        }
    }//GEN-LAST:event_txtAreaRelatoKeyReleased

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        ConexaoSmy conexao = new ConexaoSmy();
        Connection con = conexao.conectar();
        PreparedStatement pstm;
        ResultSet resultadoInsert;
        ResultSet resultadoSelect;
        Boolean retornouResultado;
        List<String> dataRelatoDoBanco = new ArrayList();

        try {
            String verificarRelato = "SELECT momentoRelato FROM relato where fkFuncionario = ?";
            pstm = con.prepareStatement(verificarRelato);
            pstm.setInt(1, funcionario.getIdFuncionario());
            resultadoSelect = pstm.executeQuery();

            while (resultadoSelect.next()) {
                dataRelatoDoBanco.add((resultadoSelect.getDate("momentoRelato").toString()).substring(0, 10));
            }

            for (String data : dataRelatoDoBanco) {
                if (data.equals(consultarSomenteDataDeAgora())) {
                    contadorDeRelatos++;
                    JOptionPane.showMessageDialog(null, "Você já fez o seu relato de hoje!");
                    geradorDeLog.adicionarLog("INFO", "Funcionário " + funcionario.getNomeFuncionario() + " tentou realizar mais de um relato no dia");
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        if (contadorDeRelatos.equals(0)) {
            if (txtAreaRelato.getText().isEmpty() || txtAreaRelato.getText().isBlank()) {

                JOptionPane.showMessageDialog(null, "Por favor, não envie um relato vazio!");

            } else {

                try {
                    String insertRelato = "INSERT INTO Relato VALUES (?, ?, ?, ?) ";
                    pstm = con.prepareStatement(insertRelato);
                    pstm.setString(1, txtAreaRelato.getText());
                    pstm.setString(2, verificaSentimento());
                    pstm.setString(3, armazenarData());
                    pstm.setInt(4, funcionario.getIdFuncionario());
                    retornouResultado = pstm.execute();
                    if (!retornouResultado) {
                        System.out.println("");
                    } else {
                        resultadoInsert = pstm.getResultSet();
                    }
                    JOptionPane.showMessageDialog(null, "Relato cadastrado com sucesso! Obrigado :)");
                    geradorDeLog.adicionarLog("INFO", "Funcionário " + funcionario.getNomeFuncionario() + " realizou o seu relato diário!");

                } catch (SQLException erro) {
                    System.err.println("Erro ao fazer a inserção no banco");
                    geradorDeLog.adicionarLog("ERRO", "Não foi possível inserir os dados do relato do funcionário, em decorrência de uma falha da plataforma Azure");

                }

            }
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    public String verificaSentimento() {
        if (radioBtnFeliz.isSelected()) {
            return "Feliz";
        } else if (radioBtnNeutro.isSelected()) {
            return "Neutro";
        } else {
            return "Triste";
        }
    }

    public String armazenarData() {
        Timestamp dataDeAgora = new Timestamp(System.currentTimeMillis());
        relato.setMomentoRelato(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(dataDeAgora));
        return (new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(dataDeAgora));
    }

    public String consultarSomenteDataDeAgora() {
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        return (new SimpleDateFormat("yyyy-MM-dd").format(dataDeHoje));
    }

    public JTextArea getTextoRelato() {
        return txtAreaRelato;
    }

    public JRadioButton getBotaoFeliz() {
        return radioBtnFeliz;
    }

    public JRadioButton getBotaoNeutro() {
        return radioBtnNeutro;
    }

    public JRadioButton getBotaoTriste() {
        return radioBtnTriste;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel imgBalaoFala;
    private javax.swing.JLabel imgFeliz;
    private javax.swing.JLabel imgNeutro;
    private javax.swing.JLabel imgSmyGrande;
    private javax.swing.JLabel imgTriste;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloCaracteresRestantes;
    private javax.swing.JLabel lblTituloCaracteresRestantes2;
    private javax.swing.JLabel lblTituloPergunta;
    private javax.swing.JLabel lblTituloRelatoDiario;
    private javax.swing.JLabel lblValorCaracteresRestantes;
    private javax.swing.JPanel pnlRelatos;
    private javax.swing.JRadioButton radioBtnFeliz;
    private javax.swing.JRadioButton radioBtnNeutro;
    private javax.swing.JRadioButton radioBtnTriste;
    private javax.swing.JTextArea txtAreaRelato;
    // End of variables declaration//GEN-END:variables
}