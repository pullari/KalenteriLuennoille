/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.util;

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
    }
    
    public Map<String, List<Merkinta>> getMap(){
        
        return this.lista;
    }
    
    public void poista(String paiva, String nimi){
        
        if(this.lista.keySet().contains(paiva)){
            
            poistaJosLoytyyNimella(paiva, nimi);
        }else{
            
            System.out.println("Tarkista päivä");
        }
    }
    
    private void poistaJosLoytyyNimella(String paiva, String nimi){
        
        boolean loytyi = false;
        Iterator<Merkinta> iteraattori = this.lista.get(paiva).iterator();
        
        while(iteraattori.hasNext()){
            
            Merkinta merkinta = iteraattori.next();
            
            if(merkinta.getNimi().equals(nimi)){
                
                iteraattori.remove();
                loytyi = true;
            }
        }
        if(!loytyi){
            System.out.println("Tämän nimistä merkintää ei löydy");
        }
    }
    
    public void lisaa(String paiva, Merkinta lisattava){
        
        if(oikeaPaiva(paiva) && !this.lista.containsKey(paiva)){
            
            uusiLisaysListaan(paiva, lisattava);
        }else if(oikeaPaiva(paiva)){
            
            this.lista.get(paiva).add(lisattava);
        }else{
            
            System.out.println("Tarkista päivä");
        }
    }
    
    private void uusiLisaysListaan(String paiva, Merkinta lisattava){
        
        ArrayList<Merkinta> listaLisattavia = new ArrayList<>();
        listaLisattavia.add(lisattava);
        this.lista.put(paiva, listaLisattavia);
    }
    
    private boolean oikeaPaiva(String paiva){
        
        String[] paivat = {"ma", "ti", "ke", "to", "pe"};
        boolean onko = false;
        
        for (String tama : paivat) {
            
            if(paiva.equals(tama)){
                
                onko = true;
            }
        }
        return onko;
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
