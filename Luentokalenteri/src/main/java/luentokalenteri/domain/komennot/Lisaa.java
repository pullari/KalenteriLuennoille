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
 *
 * @author Pullis
 */
public class Lisaa implements Komento {

    @Override
    public boolean suorita(Merkintalista lista, String... arg) {
        
        if(!tarkistaAika(arg[2])){
            
            return false;
        }else{
            Merkinta lisattava = new Merkinta(arg[1], arg[2]);
            return lista.lisaa(arg[0], lisattava);
        }
    }
    
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
