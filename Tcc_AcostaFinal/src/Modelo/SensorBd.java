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
public class SensorBd {
    private ArrayList<Sensor> SensorList = new ArrayList<Sensor>(); // cria um array list de sensores e instancia o objeto SensorList
    private ArrayList<SensorNivel> SensorListNivel = new ArrayList<SensorNivel>(); // cria um array list de sensores e instancia o objeto SensorList
    private ConexaoBd bd = new  ConexaoBd(); // cria uma nova conexão
    private ResultSet rs = null; // Cria uma variavel de armazenamento das leituras das tabelas do banco de dados
    private PreparedStatement st = null; // cria uma variavel de consulta do banco de dados
    private Sensor s = null; // cria uma varivel tipo Sensor
    private SensorNivel sn = null; // Cria uma variavel tipo sensor
        
     public ArrayList<Sensor> consultaBdSensor(String dado, String tabela){

        bd.conectar();  // Conecta ao banco de dados
        switch (tabela){ // verifica qual é a tabela da consulta do banco de dados prepara a query da consulta utilizando como parametro a data do evento
               case "Volume":
               st = bd.criarPreparedStatement("SELECT id, valor, data, hora FROM Volume where data = '" + dado + "'");
               break;
               case "Fluxo":
               st = bd.criarPreparedStatement("SELECT id, valor, data, hora FROM Fluxo where data = '" + dado + "'");
               break;
           }
          try {
           rs = st.executeQuery(); // executa a consulta
         
            while (rs.next()){ // acessa todos os elementoas da lista de resultados
            s = new Sensor();                       // instancia um novo objeto do tipo sensor
            s.setId(rs.getInt("id"));               // carraga o id do banco para a classe Sensor
            s.setVariavel(rs.getFloat("valor"));    // carraga o valor do banco para a classe Sensor
            s.setData(rs.getString("data"));        // carraga o data do banco para a classe Sensor
            s.setHora(rs.getString("hora"));        // carraga a hora do banco para a classe Sensor
            SensorList.add(s);                      // cria uma lista de objetos do tipo Sensor
               }
            } catch (SQLException ex) {
            Logger.getLogger(SensorBd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha na criação do resultSet ou do array de obijetos Sensores");
        }finally{ // finaliza a consulta liberando recursos
            try {
                rs.close(); // limpa os dados do resulatdo da consulta
            } catch (SQLException ex) {
                Logger.getLogger(SensorBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Falha no fechamento do resultSet");
            }
            try {
                st.close(); // limpa a consulta
            } catch (SQLException ex) {
                Logger.getLogger(SensorBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Falha no fechamento do PreparedStatement");
            }
            bd.desconectar(); // desconecta o banco de dados
        }
    return SensorList; // retorna uma lista de obijetos do tipo sensores
    }
     
     
    public ArrayList<SensorNivel> consultaBdSensorNivel(String dado, String tabela){

        bd.conectar();  // Conecta ao banco de dados
        switch (tabela){ // verifica qual é a tabela da consulta do banco de dados prepara a query da consulta utilizando como parametro a data do evento
               case "NivelCaixa":
               st = bd.criarPreparedStatement("SELECT id, valor, volume, data, hora FROM NivelCaixa where data = '" + dado + "'");// preparedStatement = conexaoSQLite.criarPreparedStatement(sql);    
               break;
               case "NivelCisterna":
               st = bd.criarPreparedStatement("SELECT id, valor, volume, data, hora FROM NivelCisterna where data = '" + dado + "'");
               break;  
               }
          try {
           rs = st.executeQuery(); // executa a consulta
         
            while (rs.next()){ // acessa todos os elementoas da lista de resultados
            sn = new SensorNivel();                       // instancia um novo objeto do tipo sensor
            sn.setId(rs.getInt("id"));               // carraga o id do banco para a classe Sensor
            sn.setVariavel(rs.getFloat("valor"));    // carraga o valor do banco para a classe Sensor
            sn.setVolume(rs.getFloat("volume"));
            sn.setData(rs.getString("data"));        // carraga o data do banco para a classe Sensor
            sn.setHora(rs.getString("hora"));        // carraga a hora do banco para a classe Sensor
            SensorListNivel.add(sn);                      // cria uma lista de objetos do tipo Sensor
               }
            } catch (SQLException ex) {
            Logger.getLogger(SensorBd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha na criação do resultSet ou do array de obijetos Sensores");
        }finally{ // finaliza a consulta liberando recursos
            try {
                rs.close(); // limpa os dados do resulatdo da consulta
            } catch (SQLException ex) {
                Logger.getLogger(SensorBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Falha no fechamento do resultSet");
            }
            try {
                st.close(); // limpa a consulta
            } catch (SQLException ex) {
                Logger.getLogger(SensorBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Falha no fechamento do PreparedStatement");
            }
            bd.desconectar(); // desconecta o banco de dados
        }
    return SensorListNivel; // retorna uma lista de obijetos do tipo sensores
    } 
     
     public void imprimirSensorList(){
          for(Sensor sen: SensorList){
                System.out.println("As variaveis do sensor são - id: " + sen.getId()+ " - valor: " + sen.getVariavel() + " - data: "+ sen.getData() + "- hora: "+ sen.getHora());
              }
          }
     
      public void imprimirSensorListNivel(){
          for(SensorNivel senN: SensorListNivel){
                System.out.println("As variaveis do sensor são - id: " + senN.getId()+ " - valor: " + senN.getVariavel() + " - volume: "+ senN.getVolume() + " - data: "+ senN.getData() + "- hora: "+ senN.getHora());
              }
          }
          
}

