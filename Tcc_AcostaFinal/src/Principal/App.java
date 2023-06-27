package Principal;

import Auxiliares.FormatRecString;
import ControleTelas.ThreadFramePrincipalControle;
import Rede.ReciverThread;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author facac
 */
public class App {
    private static int porta = 60011;
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     ThreadFramePrincipalControle tp = new ThreadFramePrincipalControle();
     tp.start();
     
     ReciverThread udp = new ReciverThread(porta);
     udp.start();
     
     
    }
    
}
