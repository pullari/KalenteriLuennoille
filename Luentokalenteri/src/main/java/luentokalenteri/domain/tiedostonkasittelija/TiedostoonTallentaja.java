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
 *
 * @author Pullis
 */
public class TiedostoonTallentaja {
    
    File tiedosto;
    
    public TiedostoonTallentaja(File tiedosto){
        
        this.tiedosto = tiedosto;
    }
    
    public void tallennaTilanne(Map<String, List<Merkinta>> tallennettava){
        
        try{
            FileWriter tallentaja = new FileWriter(this.tiedosto);
            
            for (String avain : tallennettava.keySet()) {
                kokoaJaTallennaMerkinnat(tallennettava, avain, tallentaja);
            }
            
            tallentaja.close();
        }catch(Exception e){
            
            System.out.println("Virhe tallentaessa");
        }
    }
    
    private void kokoaJaTallennaMerkinnat(Map<String, List<Merkinta>> tallennettava, String avain, FileWriter tallentaja) throws IOException{
        
        for (Merkinta merkinta : tallennettava.get(avain)) {
                    
            String tiedostoon = kokoaTallennusMuoto(avain, merkinta);
            tallentaja.write(tiedostoon);
        }
    }
    
    private String kokoaTallennusMuoto(String paiva, Merkinta merkinta){
        
        return paiva + ";" + merkinta.getNimi() + ";" + merkinta.getAika() + "\n";
    }
}
