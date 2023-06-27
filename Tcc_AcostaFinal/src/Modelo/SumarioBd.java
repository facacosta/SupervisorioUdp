/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Banco.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author facac
 */
public class SumarioBd {
    private Sumario s = null;
    private ArrayList<Sumario> sumarioList = new ArrayList<>();
    ConexaoBd bd = new  ConexaoBd();
    ResultSet rs = null;
    PreparedStatement st = null;
        
     //public ArrayList<Sumario> consultaBdSumarioDataTag(String dado, String Tag){
         public ArrayList<Sumario> consultaBdSumarioDataTag(String dado){
            
        bd.conectar();  // Conecta ao banco de dados   -  conexaoSQLite.conectar();
        //st = bd.criarPreparedStatement("SELECT id, tag, status, data, hora FROM Sumario where data = '" + dado +"' AND tag = '" + Tag);
        // 
        st = bd.criarPreparedStatement("SELECT id, tag, status, data, hora FROM Sumario where data = '" + dado);
          try {
           rs = st.executeQuery();
          
            while (rs.next()){
            s = new Sumario();   
            s.setId(rs.getInt("id"));
            s.setTag(rs.getString("tag"));
            s.setStatus(rs.getString("Staus"));    // carraga o valor do id do banco para a classe sumario
            s.setData(rs.getString("data"));        // carraga o valor da data do banco para a classe sumario
            s.setHora(rs.getString("hora"));        // carraga o valor da hora do banco para a classe sumario
            sumarioList.add(s);
              }
            } catch (SQLException ex) {
            Logger.getLogger(SumarioBd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha na criação do resultSet ou do array de obijetos Sensores");
        }finally{
            try {
                rs.close(); // limpa os dados do resulatdo da consulta 1
            } catch (SQLException ex) {
                Logger.getLogger(SumarioBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Falha no fechamento do resultSet");
            }
            try {
                st.close(); // limpa a consulta
            } catch (SQLException ex) {
                Logger.getLogger(SumarioBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Falha no fechamento do PreparedStatement");
            }
            bd.desconectar();
        }
    return sumarioList;
     }
     
     public void imprimirSuamriolist(){
          for(Sumario sen: sumarioList){
                System.out.println("As variaveis do sensor são - id: " + sen.getId()+ " - Tag: " + sen.getTag() + " - Status: " + sen.getStatus() + " - data: "+ sen.getData() + "- hora: "+ sen.getHora());
              }
          }
     
     
}



