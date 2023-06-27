/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleTelas;

import Auxiliares.Memoria;
import Telas.FrameFluxo;
import Telas.FrameNivelCaixa;
import Telas.FrameNivelCisterna;
import Telas.FramePrincipal;
import Telas.FrameSumario;
import Telas.FrameVolume;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author facacosta
 */
public class ThreadFramePrincipalControle extends Thread {
        private volatile boolean stopped = false;
         
    public ThreadFramePrincipalControle() {
        
    }
    public void halt() {
    this.stopped = true;
  }
  @Override  
  public void run() {
      
      //definições da tela principal
      FramePrincipal tp = new FramePrincipal();
      tp.setBounds(100, 50, 1200, 600);
      tp.setVisible(true);
      tp.setTitle("Automação do sistema de abastecimento de água Residencial");
      tp.setFont(new java.awt.Font("Tahoma", 1, 14));
      /*
      Titulos
      */
      // Titulo da tela principal
      JLabel titulo = new JLabel();
      titulo.setBounds(500, 10, 300, 30);
      titulo.setText("PAINEL PRINCIPAL");
      titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
      titulo.setVisible(true);
      tp.add(titulo);
      // titulo da primeira coluna      
      JLabel Subtitulo1 = new JLabel();
      Subtitulo1.setBounds(100, 50, 300, 30);
      Subtitulo1.setText("Valores Instantaneos");
      Subtitulo1.setFont(new java.awt.Font("Tahoma", 1, 16));
      Subtitulo1.setVisible(true);
      tp.add(Subtitulo1);
      //titulo da segunda coluna
      JLabel Subtitulo2 = new JLabel();
      Subtitulo2.setBounds(500, 50, 300, 30);
      Subtitulo2.setText("Botões de Comando");
      Subtitulo2.setFont(new java.awt.Font("Tahoma", 1, 16));
      Subtitulo2.setVisible(true);
      tp.add(Subtitulo2);
      //titulo da terceira coluna
      JLabel Subtitulo3 = new JLabel();
      Subtitulo3.setBounds(900, 50, 300, 30);
      Subtitulo3.setText("Situação das Bombas");
      Subtitulo3.setFont(new java.awt.Font("Tahoma", 1, 16));
      Subtitulo3.setVisible(true);
      tp.add(Subtitulo3);
      
      /*
      Primeira coluna descrição das variaveis
      */
      // texto nivel da cistena
      JLabel Jlb_NCisTex = new JLabel();
      Jlb_NCisTex.setBounds(50, 100, 200, 30);
      Jlb_NCisTex.setText("Nivel da Cisterna: ");
      Jlb_NCisTex.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCisTex.setVisible(true);
      tp.add(Jlb_NCisTex);
      // texto volume da cisterna
      JLabel Jlb_VCisTex = new JLabel();
      Jlb_VCisTex.setBounds(50, 150, 200, 30);
      Jlb_VCisTex.setText("Volume da Cisterna: ");
      Jlb_VCisTex.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_VCisTex.setVisible(true);
      tp.add(Jlb_VCisTex);
      // texto nivel da caixa
      JLabel Jlb_NCxTex = new JLabel();
      Jlb_NCxTex.setBounds(50, 200, 200, 30);
      Jlb_NCxTex.setText("Nivel da Caixa: ");
      Jlb_NCxTex.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCxTex.setVisible(true);
      tp.add(Jlb_NCxTex);
      // texto volume da caixa
      JLabel Jlb_VCxTex = new JLabel();
      Jlb_VCxTex.setBounds(50, 250, 200, 30);
      Jlb_VCxTex.setText("Volume da Caixa: ");
      Jlb_VCxTex.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_VCxTex.setVisible(true);
      tp.add(Jlb_VCxTex);
      // texto fluxo
      JLabel Jlb_FluTex = new JLabel();
      Jlb_FluTex.setBounds(50, 300, 200, 30);
      Jlb_FluTex.setText("Fluxo ");
      Jlb_FluTex.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_FluTex.setVisible(true);
      tp.add(Jlb_FluTex);
      
      // nivel da cisterna
      JLabel Jlb_NCisVar = new JLabel();
      Jlb_NCisVar.setBounds(250, 100, 200, 30);
      Jlb_NCisVar.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCisVar.setVisible(true);
      tp.add(Jlb_NCisVar);
      //volume da cisterna
      JLabel Jlb_VCisVar = new JLabel();
      Jlb_VCisVar.setBounds(250, 150, 200, 30);
      Jlb_VCisVar.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_VCisVar.setVisible(true);
      tp.add(Jlb_VCisVar);
      // nivel da caixa      
      JLabel Jlb_NCxVar = new JLabel();
      Jlb_NCxVar.setBounds(250, 200, 200, 30);
      Jlb_NCxVar.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCxVar.setVisible(true);
      tp.add(Jlb_NCxVar);
      // volume da caixa      
      JLabel Jlb_VCxVar = new JLabel();
      Jlb_VCxVar.setBounds(250, 250, 200, 30);
      Jlb_VCxVar.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_VCxVar.setVisible(true);
      tp.add(Jlb_VCxVar);
      // fluxo
      JLabel Jlb_FluVar = new JLabel();
      Jlb_FluVar.setBounds(250, 300, 200, 30);
      Jlb_FluVar.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_FluVar.setVisible(true);
      tp.add(Jlb_FluVar);
      // volume total      
      JLabel Jlb_volVar = new JLabel();
      Jlb_volVar.setBounds(250, 350, 200, 30);
      Jlb_volVar.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_volVar.setVisible(true);
      tp.add(Jlb_volVar);
      
      // nivel da cisterna
      JLabel Jlb_NCisStatus = new JLabel();
      Jlb_NCisStatus.setBounds(400, 100, 200, 30);
      Jlb_NCisStatus.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCisStatus.setVisible(true);
      tp.add(Jlb_NCisStatus);
      // nivel da cisterna range
      JLabel Jlb_NCisStatusRange = new JLabel();
      Jlb_NCisStatusRange.setBounds(200, 500, 400, 30);
      Jlb_NCisStatusRange.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCisStatusRange.setVisible(true);
      tp.add(Jlb_NCisStatusRange);
      
       // nivel da caixa      
      JLabel Jlb_NCxStatus = new JLabel();
      Jlb_NCxStatus.setBounds(400, 200, 200, 30);
      Jlb_NCxStatus.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCxStatus.setVisible(true);
      tp.add(Jlb_NCxStatus);
      //
      JLabel Jlb_NCxStatusRange = new JLabel();
      Jlb_NCxStatusRange.setBounds(200, 450, 400, 30);
      Jlb_NCxStatusRange.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_NCxStatusRange.setVisible(true);
      tp.add(Jlb_NCxStatusRange);
            // fluxo
      JLabel Jlb_FluStatus = new JLabel();
      Jlb_FluStatus.setBounds(400, 300, 200, 30);
      Jlb_FluStatus.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jlb_FluStatus.setVisible(true);
      tp.add(Jlb_FluStatus);
          
      /*
      botões
      */
      // sumario de eventos
      JButton Jb_cs = new JButton();
      Jb_cs.setBounds(500, 100, 200, 30);
      Jb_cs.setText("Sumario Eventos");
      Jb_cs.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jb_cs.setVisible(true);
      Jb_cs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_cs_ActionPerformed(evt);
            }
          private void Jb_cs_ActionPerformed(ActionEvent evt) {
             FrameSumario s = new FrameSumario();
             s.setVisible(true);
          }
        });
      tp.add(Jb_cs);
      // historico nivel da cisterna
      JButton Jb_cncis = new JButton();
      Jb_cncis.setBounds(500, 150, 200, 30);
      Jb_cncis.setText("Nível Cisterna");
      Jb_cncis.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jb_cncis.setVisible(true);
      Jb_cncis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_cncis_ActionPerformed(evt);
            }
          private void Jb_cncis_ActionPerformed(ActionEvent evt) {
              FrameNivelCisterna ncis = new FrameNivelCisterna();
              ncis.setVisible(true);
              FrameNivelCisterna fncis = new FrameNivelCisterna();
              fncis.setVisible(stopped);
              
          }
        });
      tp.add(Jb_cncis);
      // historico nivel da caixa
      JButton Jb_cncx = new JButton();// adiciona um JButton e cria uma instancia
      Jb_cncx.setBounds(500, 200, 200, 30); // define tamalho e localização do botão
      Jb_cncx.setText("Nível Caixa"); // define um texto que ficara no botão
      Jb_cncx.setFont(new java.awt.Font("Tahoma", 1, 18)); // define uma fonte
      Jb_cncx.setVisible(true);// define se vai ficar visivel
      Jb_cncx.addActionListener(new java.awt.event.ActionListener() { // tratamento do evento
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_cncx_ActionPerformed(evt);
            }
          private void Jb_cncx_ActionPerformed(ActionEvent evt) {
              FrameNivelCaixa ncx = new FrameNivelCaixa(); // apos o evento vai instancia um flameque vai aparecer
              ncx.setVisible(true);
          }
        });
      tp.add(Jb_cncx);
      //Historico fluxo
      JButton Jb_cnfl = new JButton();
      Jb_cnfl.setBounds(500, 250, 200, 30);
      Jb_cnfl.setText("Fluxo");
      Jb_cnfl.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jb_cnfl.setVisible(true);
      Jb_cnfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_cnfl_ActionPerformed(evt);
            }
          private void Jb_cnfl_ActionPerformed(ActionEvent evt) {
              FrameFluxo f = new FrameFluxo();
              f.setVisible(true);
          }
        });
      tp.add(Jb_cnfl);
      //historico volume total
      JButton Jb_cnv = new JButton();
      Jb_cnv.setBounds(500, 300, 200, 30);
      Jb_cnv.setText("Volume");
      Jb_cnv.setFont(new java.awt.Font("Tahoma", 1, 18));
      Jb_cnv.setVisible(true);
      Jb_cnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_cnv_ActionPerformed(evt);
            }
          private void Jb_cnv_ActionPerformed(ActionEvent evt) {
              FrameVolume v = new FrameVolume();
              v.setVisible(true);
          }
        });
      tp.add(Jb_cnv);
      
      /*
      quinta coluna Status das bombas
      */
      // Status da bomba Poço
      JLabel Jlb_StBomPcTex = new JLabel();
      Jlb_StBomPcTex.setBounds(900, 100, 200, 30);
      Jlb_StBomPcTex.setText("Bomba do Poço");
      Jlb_StBomPcTex.setFont(new java.awt.Font("Tahoma", 1, 20));
      Jlb_StBomPcTex.setVisible(true);
      tp.add(Jlb_StBomPcTex);
      // Status da bomba Poço
      JLabel Jlb_StBomPcVar = new JLabel();
      Jlb_StBomPcVar.setBounds(900, 150, 200, 30);
      Jlb_StBomPcVar.setFont(new java.awt.Font("Tahoma", 1, 20));
      Jlb_StBomPcVar.setVisible(true);
      tp.add(Jlb_StBomPcVar);
      // Status da bomba Poço
      JLabel Jlb_StBomCisTex = new JLabel();
      Jlb_StBomCisTex.setBounds(900, 250, 200, 30);
      Jlb_StBomCisTex.setText("Bomba da Cisterna");
      Jlb_StBomCisTex.setFont(new java.awt.Font("Tahoma", 1, 20));
      Jlb_StBomCisTex.setVisible(true);
      tp.add(Jlb_StBomCisTex);
      // Status da bomba Poço
      JLabel Jlb_StBomCisVar = new JLabel();
      Jlb_StBomCisVar.setBounds(900, 300, 200, 30);
      Jlb_StBomCisVar.setFont(new java.awt.Font("Tahoma", 1, 20));
      Jlb_StBomCisVar.setVisible(true);
      tp.add(Jlb_StBomCisVar);
      
        while (true) {
     if (stopped) return;
     
     Jlb_NCisVar.setText(Float.toString(Memoria.dadoRec0) + " cm");
     Jlb_NCxVar.setText(Float.toString(Memoria.dadoRec1)+ " cm");
     Jlb_FluVar.setText(Float.toString(Memoria.dadoRec2) + " l/min");
     Jlb_VCisVar.setText(Float.toString(Memoria.dadoRec11)+ " l");
     Jlb_VCxVar.setText(Float.toString(Memoria.dadoRec12)+ " l");
     
// valores do Status dos      
     Jlb_NCisStatus.setText(Memoria.dadoRec3);
     Jlb_NCisStatusRange.setText("Nível Normal da caixa - 5 a 13 cm");
     Jlb_NCxStatus.setText(Memoria.dadoRec4);
     Jlb_NCxStatusRange.setText("Nível Normal da cisterna - 5 a 13 cm");
     Jlb_FluStatus.setText(Memoria.dadoRec9);
     Jlb_StBomPcVar.setText(Memoria.dadoRec6);
     Jlb_StBomCisVar.setText(Memoria.dadoRec7);
     
        
        Thread.yield();
      
      }
    }
  }

