/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rede;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import Auxiliares.FormatRecString;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author facacosta
 */
public class ReciverThread extends Thread {
 
    private DatagramSocket socket;    // cria uma variavel socket para a Classe de comunicação DatagramSocket
    private byte[] buffer = new byte[40]; // cria o buffer de dados com capacidade para 40 bytes
    private volatile boolean stopped = false; // variavel padrão da Threand
    private int porta = 60011; // estabelece a porta de comunicação
    
    public ReciverThread(int porta) { // metodo construtor recebe a porta como parametro
        this.porta = porta;
        //this.socket = socket;
    }
    public void halt() {
    this.stopped = true;
  }
  @Override  
  public void run() { // metodo abistrato de classes Thread.
    
      FormatRecString frs = new FormatRecString();
  
    while (true) {
     if (stopped) return;
     
        try {
            socket = new DatagramSocket(porta); // cria uma instancia da classe de envio socket udp
        } catch (SocketException ex) {
            Logger.getLogger(ReciverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length); // cria uma instancia da classe que prepara o pacote de dados
      try {
        socket.receive(dp); // A instancia socket executa o metodo de recebimento de dados
        String s = new String(dp.getData(), 0, dp.getLength(), "UTF-8"); // o datagramPacket passa os dados para a string s no formato UTF-8
        socket.close(); // encerra a conexão com o controlador
        System.out.println(s);
        frs.enviarDados(s);
               
        Thread.yield();
      } catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }
}
