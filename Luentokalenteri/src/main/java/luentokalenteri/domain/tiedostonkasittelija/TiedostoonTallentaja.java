/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.tiedostonkasittelija;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import luentokalenteri.domain.lista.Merkinta;

/**
 * Luokka huolehtii listattujen merkintöjen tiedostoon tallentamisesta
 * @author Pullari
 */
public class TiedostoonTallentaja {
    
    File tiedosto;
    
    public TiedostoonTallentaja(File tiedosto){
        
        this.tiedosto = tiedosto;
    }
    
    /**
     * Metodi, joka alustaa FileWriterin ja huolehtii siitä, ettei tapahdu virhettä sen vuoksi
     * @param tallennettava Tiedostoon tallennettava Map
     */
    public boolean tallennaTilanne(Map<String, List<Merkinta>> tallennettava){
        
        try{
            FileWriter tallentaja = new FileWriter(this.tiedosto);
            
            for (String avain : tallennettava.keySet()) {
                kokoaJaTallennaMerkinnat(tallennettava, avain, tallentaja);
            }
            tallentaja.close();
            return true;
        }catch(Exception e){
            
            return false;
        }
    }
    
    /**
     * Metodi kokoaa merkinnöistä ja päivistä tallennettavat String esitykset ja tallentaa ne tiedostoon
     * @param tallennettava Lista, joka tallennetaan
     * @param avain avain, jota käytetään merkintöjen hakemiseen eri päiviltä
     * @param tallentaja Filewriter, jonka tehtävä on tallentaa lista
     * @throws IOException Koska käytetään FileWriteria on IOExpception heitettävä
     */
    
    private void kokoaJaTallennaMerkinnat(Map<String, List<Merkinta>> tallennettava, String avain, FileWriter tallentaja) throws IOException{
        
        for (Merkinta merkinta : tallennettava.get(avain)) {
                    
            String tiedostoon = kokoaTallennusMuoto(avain, merkinta);
            tallentaja.write(tiedostoon);
        }
    }
    
    /**
     * Metodi huolehtii, että tallennettavat tiedot tallennetaan oikeassa muodossa
     * @param paiva Päivä, jossa tallennettava merkintä on
     * @param merkinta Itse merkintä, jonka tiedot tallennetaan
     * @return Palauttaa tallennettavan String esityksen päivästä ja merkinnästä
     */
    
    private String kokoaTallennusMuoto(String paiva, Merkinta merkinta){
        
        return paiva + ";" + merkinta.getNimi() + ";" + merkinta.getAika() + "\n";
    }
}
