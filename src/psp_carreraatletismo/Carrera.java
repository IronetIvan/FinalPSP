/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carreraatletismo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author irone
 */
public class Carrera {
   String nom;
    Random r;
    
    public Carrera(String nom) {
        this.nom = nom;
        r=new Random(System.currentTimeMillis());
    }

    
    public String getNom() {
        return nom;
    }
    
    // devuelve un numero entre 9 y 11 segundos
    int getTemps(){
        return r.nextInt(2000)+9001;
    }
    
    

}