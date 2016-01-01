/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.lista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Luokka käsittelee merkintöjä Mapilla, jonka avaimina toimii päivät
 * @author Pullari
 * 
 */
public class Merkintalista {
    
    private Map<String, List<Merkinta>> lista;
    
    public Merkintalista(){
        
        this.lista = new HashMap<>();
        this.alustaLista();
    }
    
    /**
     * Metodi tyhjentää listan kaikista merkinnöistä
     * 
     * @return palauttaa aina true, koska operaatio ei voi epäonnistua
     */
    
    public boolean tyhjenna(){
        
        for (String avain : this.lista.keySet()) {
            
            this.lista.get(avain).clear();
        }
        return true;
    }
    
    public Map<String, List<Merkinta>> getMap(){
        
        return this.lista;
    }
    
    /**
     * 
     * @param paiva Päivä josta poistetaan merkintää
     * @param nimi Poistettavan merkinnän nimi
     * @return Onnistuiko operaatio
     */
    
    public boolean poista(String paiva, String nimi){

        Merkinta poistettava = null;
            
        for (Merkinta tama : this.lista.get(paiva)) {
            if(tama.getNimi().equals(nimi)){
                    
                poistettava = tama;
            }
        }
        
        if( poistettava == null || !this.lista.keySet().contains(paiva)){
            return false;
            
        } else if( this.lista.get(paiva).remove(poistettava)){
            return true;
        }
        return false;
    }
    
    /**
     * Lisää merkinnän listaan
     * 
     * @param paiva Päivä jolle merkintä lisätään
     * @param lisattava Merkintä, joka päivään lisätään
     * @return Palauttaa sen, onnistuiko operaatio
     */
    
    public boolean lisaa(String paiva, Merkinta lisattava){
        
        if( !this.lista.keySet().contains(paiva)){
            return false;
            
        }else if( this.lista.get(paiva).add(lisattava)){
            return true;
            
        }
        return false;
    }
    
    /**
     * Alustaa viikonpäivät listan Map:iin
     */
    
    private void alustaLista(){
        
        String[] paivat = {"ma", "ti", "ke", "to", "pe"};
        for (String tama : paivat) {
            
            this.lista.put(tama, new ArrayList<Merkinta>());
        }
    }
    
    @Override
    public String toString(){
        
        String palauta = "";
        
        for (String avain : this.lista.keySet()) {
         
            palauta += "\n" + avain + " " + this.lista.get(avain);
        }
        
        return palauta;
    }
}
