/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.tiedostonkasittelija;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import luentokalenteri.domain.lista.Merkinta;

/**
 * Luokka, joka ohjelman käynnistyessä lukee tiedostosta tallennetut merkinnät
 * @author Pullis
 */
public class TiedostonLukija {

    private Scanner lukija;
    private File tiedosto;
    
    public TiedostonLukija(File tiedosto) throws IOException{
        
        lukija = new Scanner(tiedosto);
    }
    
    /**
     * Metodi purkaa tallennus tiedostoon tallennetut merkinnät ja lisää ne listaan
     * @param puraTahan Lista johon merkinnät puretaan
     * 
     */
    
    public void puraTallennetut(Map<String, List<Merkinta>> puraTahan){
        
        while(this.lukija.hasNextLine()){
            
            String rivi = lukija.nextLine();
            String[] rivinOsat = rivi.split(";");
            
            try{
                
                puraTahan.get(rivinOsat[0]).add(new Merkinta(rivinOsat[1], rivinOsat[2]));
            }catch(Exception e){
             
                System.out.println("Virhe purettaessa tiedostoa!");
            }
        }
    }
}
