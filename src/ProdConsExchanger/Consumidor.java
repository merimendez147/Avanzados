/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdConsExchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Consumidor  extends Thread {  
      private Exchanger <String> exchanger;  
      public Consumidor(Exchanger exchanger) {  
           this.exchanger = exchanger;  
      }  
      @Override
      public void run() {  
           String mensaje = "";  
           while (true) {  
                try {  
                     mensaje = exchanger.exchange(mensaje);//Espera e intercambia el mensaje con el productor  
                     System.out.println( "Consumir "+mensaje + " ");  
                } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                }  
           }            
      }       
 }  