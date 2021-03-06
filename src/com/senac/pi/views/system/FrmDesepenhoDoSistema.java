package com.senac.pi.views.system;

import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static org.jfree.chart.ChartFactory.createBarChart3D;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import com.senac.pi.controller.sis.TesteDeDesepenhoDoSistema;
import com.senac.pi.model.vo.ModelGrafico;
import com.senac.pi.views.FrmConsultarFornecedor;
import static com.senac.util.Chronometer.elapsedTime;
import static com.senac.util.Chronometer.start;
import static com.senac.util.Chronometer.stop;
import static com.senac.util.Time.getDate;

public class FrmDesepenhoDoSistema extends javax.swing.JInternalFrame {

    private static final TesteDeDesepenhoDoSistema TESTE_SISTEMA = new TesteDeDesepenhoDoSistema();
    private final ArrayList<ModelGrafico> graficoList;
    int cont;

    public FrmDesepenhoDoSistema() {
        this.graficoList = new ArrayList<>();
        this.cont = 1;
        initComponents();
        jSliderQtdRegistro.setBorder(createTitledBorder("Quant."));
        jSliderQtdRegistro.setMajorTickSpacing(1_000);
        jSliderQtdRegistro.setMinorTickSpacing(10);
        jSliderQtdRegistro.setPaintTicks(true);
        jSliderQtdRegistro.setPaintLabels(true);
        jSliderQtdRegistro.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelNumeroRegistro.setText(valueOf(jSliderQtdRegistro.getValue()));

            }
        });

    }

    private CategoryDataset createDataset(ArrayList<ModelGrafico> list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < list.size(); i++) {
            dataset.addValue(list.get(i).getValue(), list.get(i).getLabel(), list.get(i).getTitle());
        }
        return dataset;
    }

    public void criaGrafico(ArrayList<ModelGrafico> list) {
        CategoryDataset cds = createDataset(list);
        String titulo = "Desempenho do Sistema";
        String eixoy = "Valores em ms.";
        String txt_legenda = "Legenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        myChartPanel.setVisible(true);
        jPanel1.removeAll();
        jPanel1.add(myChartPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioBtnCreatForn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        labelNumeroRegistro = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLogs = new javax.swing.JTextArea();
        radioBtnCreatUser = new javax.swing.JRadioButton();
        labelLog02 = new javax.swing.JLabel();
        radioBtnCreatCompra = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        labelQtdRegistro = new javax.swing.JLabel();
        radioBtnCreatProduto = new javax.swing.JRadioButton();
        labelLog01 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSliderQtdRegistro = new javax.swing.JSlider();

        setBackground(java.awt.Color.white);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sistema");

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        buttonGroup1.add(radioBtnCreatForn);
        radioBtnCreatForn.setText("Fornecedor");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Passo 1:");

        labelNumeroRegistro.setText("0");

        txtLogs.setEditable(false);
        txtLogs.setColumns(20);
        txtLogs.setRows(5);
        jScrollPane2.setViewportView(txtLogs);

        buttonGroup1.add(radioBtnCreatUser);
        radioBtnCreatUser.setText("Usuario");
        radioBtnCreatUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnCreatUserActionPerformed(evt);
            }
        });

        labelLog02.setText(" ");

        buttonGroup1.add(radioBtnCreatCompra);
        radioBtnCreatCompra.setText("Compras");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Passo a passo:\n\nSelecione o tipo de operação de que deseja realizar.\n\nSelecione quantos registros deseja gerar, \ndeslizando a barra para esquerda ou direita.\nClique no botão “Iniciar”.\n\nLogo após o sistema exibira uma mensagem perguntando se deseja visualizar o relatório ou não. \nAguarde enquanto o sistema processa e exibe as informações.\n");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Histórico");

        labelQtdRegistro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelQtdRegistro.setText("registro(s) :");

        buttonGroup1.add(radioBtnCreatProduto);
        radioBtnCreatProduto.setText("Produtos");

        labelLog01.setText(" ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Passo 2:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Passo 3:");

        jSliderQtdRegistro.setMajorTickSpacing(1000);
        jSliderQtdRegistro.setMaximum(1000);
        //When Changing Slider 1 Cursor...do this

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radioBtnCreatUser)
                                .addGap(48, 48, 48)
                                .addComponent(radioBtnCreatProduto))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radioBtnCreatForn)
                                .addGap(28, 28, 28)
                                .addComponent(radioBtnCreatCompra))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(256, 256, 256)
                                .addComponent(labelQtdRegistro)
                                .addGap(6, 6, 6)
                                .addComponent(labelNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSliderQtdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLog02, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelLog01, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBtnCreatUser)
                            .addComponent(radioBtnCreatProduto))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBtnCreatForn)
                            .addComponent(radioBtnCreatCompra))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelQtdRegistro)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(labelNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11)
                        .addComponent(jSliderQtdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLog01)
                        .addGap(38, 38, 38)
                        .addComponent(labelLog02)
                        .addGap(0, 183, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioBtnCreatUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnCreatUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnCreatUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int selecionado = 0;
        String listaDeLosg = "";

        if (radioBtnCreatForn.isSelected()) {
            selecionado = 1;
        }

        if (radioBtnCreatUser.isSelected()) {
            selecionado = 2;
        }
        if (radioBtnCreatProduto.isSelected()) {
            selecionado = 3;
        }
        if (radioBtnCreatCompra.isSelected()) {
            selecionado = 4;
        }

        if (selecionado > 0 && jSliderQtdRegistro.getValue() > 0) {
            switch (selecionado) {
                case 1:
                    /* Inicializa o contador.*/
                    start();
                    if (TESTE_SISTEMA.creatFornecedor(jSliderQtdRegistro.getValue())) {
                        stop();

                        /* Gerar relatório */
                        int selectedOption = showConfirmDialog(null, "Deseja visualizar o relatório?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
                        /* Ao confimar a mensagem, o relatorio é gerado. */
                        if (selectedOption == JOptionPane.YES_NO_OPTION) {
                            FrmConsultarFornecedor form = new FrmConsultarFornecedor();
                            getDesktopPane().add(form);
                            moveToBack();
                        }

                        /* Adiciona o processo ao histórico */
                        labelLog01.setText(jSliderQtdRegistro.getValue() + " Fornecedor(es) adicionado(s) a base de dados em " + elapsedTime() + " ms" + '\n');
                        listaDeLosg += jSliderQtdRegistro.getValue() + " Fornecedor(es) adicionado(s) a base de dados em " + elapsedTime() + " ms" + '\n';
                        listaDeLosg += txtLogs.getText();
                        txtLogs.setText(getDate() + " | " + listaDeLosg);

                        /*Adiciona o resultado a lista para posteriormente ser exibido no gráfico.*/
                        ModelGrafico grafico = new ModelGrafico();
                        grafico.setValue(elapsedTime());
                        grafico.setLabel("Fornecedor - Teste: " + cont);
                        grafico.setTitle("Fornecedor - Teste: " + cont);

                        /* Adiciona os dados a lista.*/
                        graficoList.add(grafico);
                    }
                    break;
                case 2:
                    /* Inicializa o contador.*/
                    start();
                    if (TESTE_SISTEMA.creatUser(jSliderQtdRegistro.getValue())) {
                        stop();

//                        /* Gerar relatório */
//                        int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja visualizar o relatório?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
//                        if (selectedOption == JOptionPane.YES_NO_OPTION) {
//                            // Chamar janela de filros para montar o ralatorio //
//                        }

                        /* Adiciona o processo ao histórico */
                        labelLog01.setText(jSliderQtdRegistro.getValue() + " Usuário(s) adicionado(s) a base de dados.");
                        listaDeLosg += jSliderQtdRegistro.getValue() + " Usuário(s) adicionado(s) a base de dados em " + elapsedTime() + " ms" + '\n';
                        listaDeLosg += txtLogs.getText();
                        txtLogs.setText(getDate() + " | " + listaDeLosg);

                        /* Adiciona o resultado a lista para posteriormente ser exibido no gráfico.*/
                        ModelGrafico grafico = new ModelGrafico();
                        grafico.setValue(elapsedTime());
                        grafico.setLabel("Usuário - Teste: " + cont);
                        grafico.setTitle("Usuário - Teste: " + cont);

                        /* Adiciona os dados a lista.*/
                        graficoList.add(grafico);
                    }
                    break;
                case 3:
                    /* Inicializa o contador.*/
                    start();
                    if (TESTE_SISTEMA.creatProduto(jSliderQtdRegistro.getValue())) {
                        stop();


                        /* Adiciona o processo ao histórico */
                        labelLog01.setText(jSliderQtdRegistro.getValue() + " Produto(s) adicionado(s) a base de dados.");
                        listaDeLosg += jSliderQtdRegistro.getValue() + " Produto(s) adicionado(s) a base de dados em " + elapsedTime() + " ms" + '\n';
                        listaDeLosg += txtLogs.getText();
                        txtLogs.setText(getDate() + " | " + listaDeLosg);

                        /* Adiciona o resultado a lista para posteriormente ser exibido no gráfico.*/
                        ModelGrafico grafico = new ModelGrafico();
                        grafico.setValue(elapsedTime());
                        grafico.setLabel("Produtos - Teste: " + cont);
                        grafico.setTitle("Produtos - Teste: " + cont);

                        /* Adiciona os dados a lista.*/
                        graficoList.add(grafico);

                    }
                    break;
                case 4:
                    /* Inicializa o contador.*/
                    start();
                    if (TESTE_SISTEMA.criarVendaAleatoria(jSliderQtdRegistro.getValue())) {
                        stop();

                        /* Adiciona o processo ao histórico */
                        labelLog01.setText(jSliderQtdRegistro.getValue() + " Venda(s) adicionado(s) a base de dados.");
                        listaDeLosg += jSliderQtdRegistro.getValue() + " Venda(s) adicionado(s) a base de dados em " + elapsedTime() + " ms" + '\n';
                        listaDeLosg += txtLogs.getText();
                        txtLogs.setText(getDate() + " | " + listaDeLosg);

                        /* Adiciona o resultado a lista para posteriormente ser exibido no gráfico.*/
                        ModelGrafico grafico4 = new ModelGrafico();
                        grafico4.setValue(elapsedTime());
                        grafico4.setLabel("Vendas - Teste: " + cont);
                        grafico4.setTitle("Vendas - Teste: " + cont);

                        /* Adiciona os dados a lista.*/
                        graficoList.add(grafico4);

                    }
                    break;
            }
            cont++;
            if (graficoList.size() > 0) {
                criaGrafico(graficoList);
                setVisible(true);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSliderQtdRegistro;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelLog01;
    private javax.swing.JLabel labelLog02;
    private javax.swing.JLabel labelNumeroRegistro;
    private javax.swing.JLabel labelQtdRegistro;
    private javax.swing.JRadioButton radioBtnCreatCompra;
    private javax.swing.JRadioButton radioBtnCreatForn;
    private javax.swing.JRadioButton radioBtnCreatProduto;
    private javax.swing.JRadioButton radioBtnCreatUser;
    private javax.swing.JTextArea txtLogs;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = getLogger(FrmDesepenhoDoSistema.class.getName());
}
