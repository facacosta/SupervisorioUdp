/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Modelo.Sensor;
import Modelo.SensorBd;
import Modelo.SensorNivel;
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
public class FrameNivelCaixa extends javax.swing.JFrame {
    JTextField jtf_ano = new javax.swing.JTextField();
    JTextField jtf_mes = new javax.swing.JTextField();
    JTextField jtf_dia = new javax.swing.JTextField();
    ArrayList<Sensor> SensorList = new ArrayList();
    ArrayList<SensorNivel> SensorListNivel = new ArrayList();
    SensorNivel s = new SensorNivel();
    SensorBd bd = new SensorBd();
    /**
     * Creates new form FrameNivelCisterna
     */
    public FrameNivelCaixa() {
        initComponents();
        super.setTitle("Tela de valores Históricos do Nível da Caixa");
        super.setBounds(100, 100, 900, 800);
        JLabel titulo = new javax.swing.JLabel();
        titulo.setBounds(300, 10 , 400, 30);
        titulo.setText("Histórico Nível Caixa ");
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
        
        JButton jb_atualizar = new javax.swing.JButton();
        jb_atualizar.setText("Atualizar");
        jb_atualizar.setFont(new java.awt.Font("Tahoma", 1, 18));
        jb_atualizar.setVisible(true);
        jb_atualizar.setBounds(350, 120, 150, 30);
        super.add(jb_atualizar);
        jb_atualizar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        jb_atualizarActionPerformed(evt);
    }   private void jb_atualizarActionPerformed(ActionEvent evt) {
            String ano = jtf_ano.getText(); // recebe o texto da caixa jtf_ano
            String mes = jtf_mes.getText(); // recebe o texto da caixa jtf_mes
            String dia = jtf_dia.getText(); // recebe o texto da caixa jtf_dia
            String data = ano + "-" + mes +"-" + dia; //concatena para criar a variavel de pesquiza do banco de dados
            //recebe da classe SensorBd o SensorLista com resultado da busca ao banco 
            SensorListNivel = bd.consultaBdSensorNivel(data, "NivelCaixa"); 
            int tamanho = SensorListNivel.size();// consulta o tamanho da lista
            System.out.println("o tamanho da lista de valores analogicos do sensor de nivel da caixa é: " + tamanho);
            //modelo de tabela recebe a tabela criada
            DefaultTableModel modelo = (DefaultTableModel) jt_nivelCisterna.getModel();
            SensorNivel sen = null; // cria uma varivel do tipo SensorNivel
            for(int i = 0; i < tamanho; i ++){ // executa o laço for
                sen = SensorListNivel.get(i); // a instancia de SensorNivel recebe o SensorListNivel
                System.out.println("ID: " + String.valueOf(sen.getId()) + " - valor: " + String.valueOf(sen.getVariavel()) + " - data: " + sen.getData() + " - hora: " + sen);
                 //Preenche a tabela com os valores da Lista                 
                modelo.insertRow(i, new Object[] {sen.getId(), sen.getVariavel(), sen.getVolume(), sen.getData(), sen.getHora()});
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
            java.util.logging.Logger.getLogger(FrameNivelCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameNivelCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameNivelCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameNivelCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameNivelCaixa().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jt_nivelCisterna;
    // End of variables declaration//GEN-END:variables
}


