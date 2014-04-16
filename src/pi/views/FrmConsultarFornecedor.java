/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.views;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static org.jfree.chart.ChartFactory.createBarChart3D;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import pi.controller.relatorios.CriarRelatorio;
import static pi.dao.DaoPessoaJuridica.getForInativos;
import static pi.dao.DaoPessoaJuridica.getFornecedor;
import static pi.dao.DaoPessoaJuridica.getFornecedorAtivo;
import pi.model.ModelGrafico;
import static util.Chronometer.elapsedTime;
import static util.Chronometer.start;
import static util.Chronometer.stop;
import static util.Time.getTime;

/**
 *
 * @author deyvid.fasouza
 */
public class FrmConsultarFornecedor extends javax.swing.JInternalFrame {

    public FrmConsultarFornecedor() {
        initComponents();
        cboCidade.setEnabled(false);
        cboFiltro2.setEnabled(false);
        this.setVisible(true);
        if (getFornecedor() == null) {
            ckbFiltro.setEnabled(false);
            jButton1.setEnabled(false);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getFornecedor() != null) {
            ModelGrafico grafico;
            grafico = new ModelGrafico();
            ArrayList<ModelGrafico> list = new ArrayList<>();
            grafico.setLabel("Fornecedores com produtos cadastrados no sistema");
            grafico.setTitle("Ativos");
            grafico.setValue2(getFornecedorAtivo().size());
            list.add(grafico);
            grafico = new ModelGrafico();
            grafico.setLabel("Fornecedores com produtos cadastrados no sistema");
            grafico.setTitle("Inativos");
            grafico.setValue2(getForInativos().size());
            list.add(grafico);
            this.criaGrafico(list, "Fornecedores");
        }
    }

    private CategoryDataset createDataset(ArrayList<ModelGrafico> dados) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (ModelGrafico modelGrafico : dados) {
            dataset.addValue(modelGrafico.getValue2(), modelGrafico.getLabel(), modelGrafico.getTitle());
        }
        return dataset;
    }

    private void criaGrafico(ArrayList<ModelGrafico> dados, String title) {
        CategoryDataset cds = createDataset(dados);
        String titulo = title;
        String eixoy = "Valores";
        String txt_legenda = "Ledenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel2.getWidth(), jPanel2.getHeight());
        myChartPanel.setVisible(true);
        jPanel2.removeAll();
        jPanel2.add(myChartPanel);
        jPanel2.revalidate();
        jPanel2.repaint();
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
        jButton1 = new javax.swing.JButton();
        cboCidade = new javax.swing.JComboBox();
        cboFiltro2 = new javax.swing.JComboBox();
        ckbFiltro = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setClosable(true);
        setTitle("Filtrar relatório");

        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "São Paulo", "Rio de Janeiro" }));
        cboCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCidadeActionPerformed(evt);
            }
        });

        cboFiltro2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativos", "Inativos" }));

        ckbFiltro.setText("Filtros?");
        ckbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ckbFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(cboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ckbFiltro)
                            .addComponent(cboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String log;
        log = "";

        switch (cboFiltro2.getSelectedIndex()) {
            case 0:
                start();
                Thread relport = new Thread(new CriarRelatorio(getFornecedorAtivo(), CriarRelatorio.Templates.TMPL_FORNECEDOR_CADASTRO_RESUMIDO, null), "Thread: Imprimir Fornecedor");
                relport.start();
                stop();
                log += getTime() + " | Relatório com " + getFornecedorAtivo().size() + "   fornecedor(es) gerado em: " + elapsedTime() + " ms." + '\n';
                break;
            case 1:
                start();
                Thread relport1 = new Thread(new CriarRelatorio(getForInativos(), CriarRelatorio.Templates.TMPL_FORNECEDOR_CADASTRO_RESUMIDO, null), "Thread: Imprimir Fornecedor");
                relport1.start();
                stop();
                log += getTime() + " | Relatório com " + getForInativos().size() + "   fornecedor(es) gerado em: " + elapsedTime() + " ms." + '\n';
                break;
            default:
                HashMap<String, Object> parametros = new HashMap<>();
                parametros.put("QUANT_FORNECEDORES_INATIVOS", getForInativos().size());
                parametros.put("QUANT_FORNECEDORES_ATIVOS", getFornecedorAtivo().size());
                parametros.put("TOTAL_REGISTRO", getFornecedor().size());
                start();
                Thread relport2 = new Thread(new CriarRelatorio(getFornecedor(), CriarRelatorio.Templates.TMPL_FORNECEDOR_CADASTRO_COMPLETO, parametros), "Thread: Imprimir Fornecedor");
                relport2.start();
                stop();
                log += getTime() + " | Relatório com " + getFornecedor().size() + "   fornecedor(es) gerado em: " + elapsedTime() + " ms." + '\n';
                break;
        }

        log += jTextPane1.getText();
        jTextPane1.setText(log);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ckbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbFiltroActionPerformed
        if (ckbFiltro.isSelected()) {
            cboCidade.setEnabled(true);
            cboFiltro2.setEnabled(true);

        } else {
            cboCidade.setEnabled(false);
            cboFiltro2.setEnabled(false);
        }
    }//GEN-LAST:event_ckbFiltroActionPerformed

    private void cboCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCidadeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCidade;
    private javax.swing.JComboBox cboFiltro2;
    private javax.swing.JCheckBox ckbFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = getLogger(FrmConsultarFornecedor.class.getName());
}
