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
public class Productor extends Thread {

    private final Exchanger exchanger;
    private int producto;

    public Productor(Exchanger exchanger) {
        this.exchanger = exchanger;
        producto = 1;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println( "Produciendo Producto "+producto);                
                exchanger.exchange("Producto "+ producto);//Espera e intercambia el mensaje con el consumidor;     
                producto++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
