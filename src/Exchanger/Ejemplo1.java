/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Ejemplo1 {

    static class ExchangerRunnable implements Runnable {

        Exchanger exchanger = null;
        Object object = null;

        public ExchangerRunnable(Exchanger exchanger, Object object) {
            this.exchanger = exchanger;
            this.object = object;
        }

        @Override
        public void run() {
            try {
                Object previous = this.object;
                System.out.println(Thread.currentThread().getName()+ " primero tiene el objeto " + this.object);
                this.object = this.exchanger.exchange(this.object);
                System.out.println(Thread.currentThread().getName()+ " despues tiene el objeto " + this.object);
                System.out.println(Thread.currentThread().getName()+ " intercambio " + previous + " por " + this.object);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExchangerRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");
        Thread h1 = new Thread(exchangerRunnable1);
        Thread h2 = new Thread(exchangerRunnable2);
        h1.start();
        h2.start();
    }
}
