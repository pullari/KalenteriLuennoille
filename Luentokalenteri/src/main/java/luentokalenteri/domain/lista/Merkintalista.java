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
 *
 * @author Pullis
 */
public class Merkintalista {
    
    private Map<String, List<Merkinta>> lista;
    
    public Merkintalista(){
        
        this.lista = new HashMap<>();
        this.alustaLista();
    }
    
    public boolean tyhjenna(){
        
        for (String avain : this.lista.keySet()) {
            
            this.lista.get(avain).clear();
        }
        return true;
    }
    
    public Map<String, List<Merkinta>> getMap(){
        
        return this.lista;
    }
    
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
    
    public boolean lisaa(String paiva, Merkinta lisattava){
        
        if( !this.lista.keySet().contains(paiva)){
            return false;
            
        }else if( this.lista.get(paiva).add(lisattava)){
            return true;
            
        }
        return false;
    }
    
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
