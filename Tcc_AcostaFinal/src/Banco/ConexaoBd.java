/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author facacosta
 */
public class ConexaoBd {
   
    private Connection conexao;

    /**
     * Conecta a um banco de dados (cria o banco se ele não existir)
     *
     * @return
     */
    public boolean conectar() {
        try {
            //String url = "jdbc:sqlite:banco_de_dados/banco_automacaoHome.db";
            // cria a string de localização do banco de dados
            String url = "jdbc:sqlite:banco_de_dados/Bd_automacaoHidrica.db";
            // estabelace uma conexão do o banco de dados atraves da string de localização
            this.conexao = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("conectou!!!");
        return true; // retorna verdadeiro se foi um sucesso
    }

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {// verifica se a conexão não estiver fechada fecha a mesma
                this.conexao.close(); // fecha a conexão com o banco de dados 
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("desconectou!!!");
        return true;
    }

    /**
     * Criar os statements para nossos sqls serem executados
     *
     * @return
     */
    public Statement criarStatement() {
        try {// cria um 
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
    
    /**
     * Criar os statements para nossos sqls serem executados
     *
     * @return
     */
    public PreparedStatement criarPreparedStatement(String sql) {
        try {// estabelece uma conexão com o banco de dados e executa a consulta 
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    } 
    
}
