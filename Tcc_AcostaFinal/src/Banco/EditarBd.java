/*
 
 */
package Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author facacosta
 */
public class EditarBd {
  private ConexaoBd cBd;
  PreparedStatement PS = null;

    public EditarBd() {
    }
    
  public void InserirDadosBancoInt(int data, String tabela){
      cBd = new ConexaoBd();
      cBd.conectar();
        String Insert = " INSERT INTO tbl_pessoa ("
                + "id,"
                + "nome,"
                + "idade"
                + ") VALUES(?,?,?)"
                + ";";   
      
      PS = cBd.criarPreparedStatement(Insert);
      
      try {
          
          PS.setInt(1, data);
           int resultado = PS.executeUpdate();
         // int resultado = PS.executeUpdate(data);
            if (resultado == 1) {
                System.out.println(" inserido");
            } else {
                System.out.println(" não inserido");
            }
          
          // PreparedStatement preparedStatement = onexaoBd.criarPreparedStatement(sqlInsert);
      } catch (SQLException ex) {
          Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Falha ao inserir o" );
          System.out.println("Falha ao inserir o ");
      }
      finally{
          if(PS != null){
              try {
                  PS.close();
              } catch (SQLException ex) {
                  Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Falha ao fechar o editor de SQL");
                  System.out.println("Falha ao fechar o editor de SQL");
              }
          }
          cBd.desconectar();
      }
   }
     
  public void InserirDadosBancoString(String data, String tabela){
      cBd = new ConexaoBd(); //cria uma instancia da classe  ConexãoBd()
      cBd.conectar(); // cria uma nova conexão
        
      switch(tabela){
          case "BombaPoco": 
          // cria o sql query para ser enviado a interrogação e a quantidade de colunas que vão receber os dados     
          PS = cBd.criarPreparedStatement("INSERT INTO BombaPoco (status) VALUES(?);");
          break;
              
          case "BombaCisterna":
              // cria o sql query para ser enviado a interrogação e a quantidade de colunas que vão receber os dados  
          PS = cBd.criarPreparedStatement("INSERT INTO BombaCisterna (status) VALUES(?);");
          break;
      }
         try {
              PS.setString(1, data);
          // Executa a consulta
            int resultado = PS.executeUpdate();
         // int resultado = PS.executeUpdate(data);
            if (resultado == 1) {
                System.out.println(" inserido");
            } else {
                System.out.println(" não inserido");
            }
          
          // PreparedStatement preparedStatement = onexaoBd.criarPreparedStatement(sqlInsert);
      } catch (SQLException ex) {
          Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Falha ao inserir o" );
          System.out.println("Falha ao inserir o ");
      }
      finally{ // fecha as conexões 
          if(PS != null){ // verifica se o PreparedStatement esta diferente de null
              try {
                  PS.close(); // fecha o PreparedStatement
              } catch (SQLException ex) {
                  Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Falha ao fechar o editor de SQL");
                  System.out.println("Falha ao fechar o editor de SQL");
              }
          }
          cBd.desconectar(); // desconecta do banco
      }
   }
  
  public void InserirDadosBancoFloat(float data, String tabela){
      cBd = new ConexaoBd();
      cBd.conectar();
      String sql = null;
      //
      String sql1 = " INSERT INTO NivelCisterna ("
                + "valor"
                + ") VALUES(?)"
                + ";";
      
       String sql2 = " INSERT INTO NivelCaixa ("
                + "valor"
                + ") VALUES(?)"
                + ";";
      
        String sql3 = " INSERT INTO Turbidez ("
                + "valor"
                + ") VALUES(?)"
                + ";";
      
        String sql4 = " INSERT INTO Volume ("
                + "valor"
                + ") VALUES(?)"
                + ";";
           
        String sql5 = " INSERT INTO Fluxo ("
                + "valor"
                + ") VALUES(?)"
                + ";";
        
      System.out.println("O Dado " + data + " vai ser inserido na tabela " + tabela);
      
      switch(tabela){
          case "Turbidez":
          PS = cBd.criarPreparedStatement("INSERT INTO Turbidez (valor) VALUES(?);");
          break;
              
          case "Volume":
          PS = cBd.criarPreparedStatement("INSERT INTO Volume (valor) VALUES(?);");
          break;
              
          case "Fluxo":
          PS = cBd.criarPreparedStatement("INSERT INTO Fluxo (valor) VALUES(?);");
          break;    
      }
         // PS = cBd.criarPreparedStatement(sql);
        try {
          PS.setFloat(1, data);
           int resultado = PS.executeUpdate();
            if (resultado == 1) {
                System.out.println("O Dado " + data + " foi inserido na tabela " + tabela);
            } else {
                System.out.println("Falha ao inserir o " + data + " na " + tabela);
            }
        } catch (SQLException ex) {
          Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Falha ao inserir o " + data + " na " + tabela);
          System.out.println("Falha ao inserir o " + data + " na " + tabela);
      }
      finally{
          if(PS != null){
              try {
                  PS.close();
              } catch (SQLException ex) {
                  Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Falha ao fechar o editor de SQL");
                  System.out.println("Falha ao fechar o editor de SQL");
              }
          }
          cBd.desconectar();
      }
   }
  
  public void InserirDadosBancoSuamrio(String data, String tag){
      cBd = new ConexaoBd();
      cBd.conectar();
       
                
    PS = cBd.criarPreparedStatement("INSERT INTO Sumario (tag,status) values(?,?);");
     try {
          PS.setString(1, tag);
          PS.setString(2, data);
           int resultado = PS.executeUpdate();
         // int resultado = PS.executeUpdate(data);
            if (resultado == 1) {
                System.out.println("O Dado " + data + " foi inserido na tabela sumario");
            } else {
                System.out.println("Falha ao inserir o " + data + " no suamrio");
            }
          
          // PreparedStatement preparedStatement = onexaoBd.criarPreparedStatement(sqlInsert);
      } catch (SQLException ex) {
          Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Falha ao inserir o " + data + " no sumario");
          System.out.println("Falha ao inserir o " + data + " no sumario");
      }
      finally{
          if(PS != null){
              try {
                  PS.close();
              } catch (SQLException ex) {
                  Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Falha ao fechar o editor de SQL");
                  System.out.println("Falha ao fechar o editor de SQL");
              }
          }
          cBd.desconectar();
      }
   }
  
public void InserirDadosBancoNivel(float valor, float volume, String tabela ){
      cBd = new ConexaoBd();
      cBd.conectar();
      
      switch(tabela){
          case "NivelCisterna":
          PS = cBd.criarPreparedStatement("INSERT INTO NivelCisterna (valor,volume) VALUES(?,?);");
          break;
              
          case "NivelCaixa":
          PS = cBd.criarPreparedStatement("INSERT INTO NivelCaixa (valor,volume) VALUES(?,?);");
          break;
      }
      try {
          PS.setFloat(1, valor);
          PS.setFloat(1, volume);
           int resultado = PS.executeUpdate();
            if (resultado == 1) {
                System.out.println("O nivel " + valor + " - e volume " + volume + "foi inserido na tabela sumario");
            } else {
                System.out.println("Falha ao inserir o " + valor + " - e volume " + volume + " no suamrio");
            }
        } catch (SQLException ex) {
          Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Falha ao inserir o " + valor + " - e volume " + volume + " no sumario");
          System.out.println("Falha ao inserir o " + valor + " - e volume " + volume + " no sumario");
      }
      finally{
          if(PS != null){
              try {
                  PS.close();
              } catch (SQLException ex) {
                  Logger.getLogger(EditarBd.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Falha ao fechar o editor de SQL");
                  System.out.println("Falha ao fechar o editor de SQL");
              }
          }
          cBd.desconectar();
      }
   }  
  
  
}

