/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Modelo.Sensor;
import Modelo.SensorBd;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author facac
 */
public class FrameVolume extends javax.swing.JFrame {
    JTextField jtf_ano = new javax.swing.JTextField();
    JTextField jtf_mes = new javax.swing.JTextField();
    JTextField jtf_dia = new javax.swing.JTextField();
    JTextField jtf_soma = new javax.swing.JTextField();
    ArrayList<Sensor> sensorlist = new ArrayList();
    float soma = 0;
    Sensor s = new Sensor();
    SensorBd bd = new SensorBd();
    /**
     * Creates new form FrameNivelCisterna
     */
    public FrameVolume() {
        initComponents();
        super.setTitle("Tela histórico de valores do Nível da Cisterna");
        super.setBounds(100, 100, 900, 800);
        JLabel titulo = new javax.swing.JLabel();
        titulo.setBounds(300, 10 , 400, 30);
        titulo.setText("Histórico volume produzido");
        titulo.setFont(new java.awt.Font("Tahoma", 1, 25));
        titulo.setVisible(true);
        super.add(titulo);
        JLabel jl_dia = new javax.swing.JLabel();
        jl_dia.setBounds(300, 50 , 80, 30);
        jl_dia.setText("Dia");
        jl_dia.setFont(new java.awt.Font("Tahoma", 1, 20));
        jl_dia.setVisible(true);
        super.add(jl_dia);
    
        JLabel jl_mes = new javax.swing.JLabel();
        jl_mes.setBounds(400, 50 , 80, 30);
        jl_mes.setText("Mês");
        jl_mes.setFont(new java.awt.Font("Tahoma", 1, 20));
        jl_mes.setVisible(true);
        super.add(jl_mes);
    
        JLabel jl_ano = new javax.swing.JLabel();
        jl_ano.setBounds(500, 50 , 80, 30);
        jl_ano.setText("Ano");
        jl_ano.setFont(new java.awt.Font("Tahoma", 1, 20));
        jl_ano.setVisible(true);
        super.add(jl_ano);
        
        JLabel jl_soma = new javax.swing.JLabel();
        jl_soma.setBounds(600, 50 , 80, 30);
        jl_soma.setText("Soma");
        jl_soma.setFont(new java.awt.Font("Tahoma", 1, 20));
        jl_soma.setVisible(true);
        super.add(jl_soma);
        
        //JTextField jtf_dia = new javax.swing.JTextField();
        jtf_dia.setBounds(300, 80, 80, 30);
        jtf_dia.setFont(new java.awt.Font("Tahoma", 1, 18));
        jtf_dia.setVisible(true);
        super.add(jtf_dia);
    
        //JTextField jtf_mes = new javax.swing.JTextField();
        jtf_mes.setBounds(400, 80, 80, 30);
        jtf_mes.setFont(new java.awt.Font("Tahoma", 1, 18));
        jtf_mes.setVisible(true);
        super.add(jtf_mes);
    
        //JTextField jtf_ano = new javax.swing.JTextField();
        jtf_ano.setBounds(500, 80, 80, 30);
        jtf_ano.setFont(new java.awt.Font("Tahoma", 1, 18));
        jtf_ano.setVisible(true);
        super.add(jtf_ano);
        
        //JTextField jtf_ano = new javax.swing.JTextField();
        jtf_soma.setBounds(600, 80, 80, 30);
        jtf_soma.setFont(new java.awt.Font("Tahoma", 1, 18));
        jtf_soma.setText(Float.toString(soma));
        jtf_soma.setVisible(true);
        super.add(jtf_soma);
        
        JButton jb_atualizar = new javax.swing.JButton();
        jb_atualizar.setText("Atualizar");
        jb_atualizar.setFont(new java.awt.Font("Tahoma", 1, 18));
        jb_atualizar.setVisible(true);
        jb_atualizar.setBounds(350, 120, 150, 30);
        super.add(jb_atualizar);
        jb_atualizar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        jb_atualizarActionPerformed(evt);
    }
        private void jb_atualizarActionPerformed(ActionEvent evt) {
            String ano = jtf_ano.getText();
            String mes = jtf_mes.getText();
            String dia = jtf_dia.getText();
            String data = ano + "-" + mes +"-" + dia;
            sensorlist = bd.consultaBdSensor(data, "NivelCaixa");
            int tamanho = sensorlist.size();
            System.out.println("o tamanho da lista de valores analógicos do sensor de nível da caixa é: " + tamanho);
            Sensor sn = new Sensor();
            for (int i = 0; i< tamanho; i++){
                sn = sensorlist.get(i);
                soma = soma + sn.getVariavel();
             }
             System.out.println("a sopma dos volumes é: " + soma);  
             
             
            DefaultTableModel modelo = (DefaultTableModel) jt_nivelCisterna.getModel();
            Sensor sen = null;
            for(int i = 0; i < tamanho; i ++){
                sen = sensorlist.get(i);
                System.out.println("ID: " + String.valueOf(sen.getId()) + " - valor: " + String.valueOf(sen.getVariavel()) + " - data: " + sen.getData() + " - hora: " + sen);
                 //modelo.addRow(new Object[] {sen.getId(), sen.getVariavel(), sen.getData(), sen.getHora()});
                 modelo.insertRow(i, new Object[] {sen.getId(), sen.getVariavel(), sen.getData(), sen.getHora()});
            }
            
            }
        });
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_nivelCisterna = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jt_nivelCisterna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "VALOR", "DATA", "HORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_nivelCisterna);
        if (jt_nivelCisterna.getColumnModel().getColumnCount() > 0) {
            jt_nivelCisterna.getColumnModel().getColumn(0).setPreferredWidth(100);
            jt_nivelCisterna.getColumnModel().getColumn(1).setPreferredWidth(200);
            jt_nivelCisterna.getColumnModel().getColumn(2).setPreferredWidth(200);
            jt_nivelCisterna.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrameVolume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameVolume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameVolume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameVolume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameVolume().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jt_nivelCisterna;
    // End of variables declaration//GEN-END:variables
}


