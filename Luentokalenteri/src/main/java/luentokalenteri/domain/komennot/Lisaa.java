/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import java.util.Scanner;
import luentokalenteri.domain.lista.Merkinta;
import luentokalenteri.domain.lista.Merkintalista;

/**
 * Komento, jota voi kutsua sovelluslogiikassa, joka lisää 
 * @author Pullari
 * 
 */
public class Lisaa implements Komento {

    /**
     * Lisäys-komennon suorita metodi, joka luo uuden merkinnän ja lisää sen merkintälistaan
     * @param lista lista johon merkintä lisätään
     * @param arg merkinnän nimi ja aika, sekä päivä johon listätää
     * @see luentokalenteri.domain.lista.Merkintalista#lisaa(java.lang.String, luentokalenteri.domain.lista.Merkinta) 
     * @return palauttaa boolean arvon onnistumisesta
     */
    
    @Override
    public boolean suorita(Merkintalista lista, String... arg) {
        
        if(!tarkistaAika(arg[2]) || !tarkistaNimi(arg[1])){
            
            return false;
        }else{
            Merkinta lisattava = new Merkinta(arg[1], arg[2]);
            return lista.lisaa(arg[0], lisattava);
        }
    }
    /**
     * Tarkistaa että nimi ei sisällä puolipisteitä
     * @param nimi nimi, joka tarkistetaan
     * @return false, jos nimessä puolipiste, muuten true
     */
    
    private boolean tarkistaNimi(String nimi){
        
        if(nimi.contains(";")){
            return false;
        }
        return true;
    }
    
    /**
     * Tarkistaa, että aika on aika, joka kelpaa listaan
     * @param aika tarkistettava aika String muodossa
     * @return palauttaa boolean arvon onnistumisesta
     */

    private boolean tarkistaAika(String aika){
        
        if(tarkistaMuoto(aika)){
            
            String[] osat = aika.split("-");
            int eka = Integer.parseInt(osat[0]);
            int toka = Integer.parseInt(osat[1]);
            
            if(eka >= 8 && toka <= 20){

                return true;
            }
            return false;
        }else{
            
            return false;
        }
    }
    
    /**
     * Tarkistaa annetun String muutujan muodon
     * @param tama muuttuja, jonka muoto tarkistetaan
     * @return palauttaa onnistuiko
     */
    
    private boolean tarkistaMuoto(String tama){
        
        try{
            String[] osat = tama.split("-");
            int eka = Integer.parseInt(osat[0]);
            int toka = Integer.parseInt(osat[1]);
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
}
