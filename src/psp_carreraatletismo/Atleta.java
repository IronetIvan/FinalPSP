/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carreraatletismo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author irone
 */
public class Atleta extends Thread {

    private int dorsal;
    long tiempoacabar;
    public boolean acabar = false;
    private int tiempoInicio;

    Carrera c;

    public Atleta(final int dorsal, Carrera c) {
        this.dorsal = dorsal;
        this.c = c;

        setName("Atleta: " + dorsal);
        
    }
   
    @Override
    public void run() {
        int tiempo = c.getTemps();
        try {

            Thread.sleep(tiempo);
            

        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getName() + " acaba en " + tiempo / 1000.00 + " seg.");

    }

}
