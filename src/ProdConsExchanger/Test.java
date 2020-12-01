/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdConsExchanger;

import java.util.concurrent.Exchanger;

/**
 *
 * @author elina
 */
public class Test {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        Consumidor consumidor = new Consumidor(exchanger);
        Productor productor = new Productor(exchanger);
        consumidor.start();
        productor.start();
    }
}
