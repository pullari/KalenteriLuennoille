/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.kayttojarjestelma;

import java.util.Scanner;
import luentokalenteri.sovelluslogiikka.Sovelluslogiikka;

/**
 *
 * @author Pullis
 */
public class tekstiKayttojarjestelma {
    
    private Sovelluslogiikka logiikka;
    private Scanner lukija;
    
    public tekstiKayttojarjestelma(Scanner lukija){
        
        this.lukija = lukija;
        logiikka = new Sovelluslogiikka("src/main/java/luentokalenteri/domain/lista/testausta.txt");
    }
    
    public void suorita(){
        
        tulostaOhjeet();
        logiikka.puraTiedosto();
        
        while(true){
           
            String komento = pyydaKomento();
            
            if(komento.equals("x")){
                logiikka.tallennaTila();
                break;
                
            }else{
                suoritaKomento(komento);
                
            }
        }
    }
    
    private void tulostaOhjeet(){
        
        System.out.println("1 lisää uusi merkintä || 2 poista merkintä || 3 tyhjennä kaikki || 4 tulosta lista || x lopettaa");
    }
    
    private String pyydaKomento(){
        
        System.out.println("");
        System.out.print("Komento: ");
        return this.lukija.nextLine();
    }
    
    private void suoritaKomento(String komento){
        
        try{
            boolean tama = logiikka.suoritaKomento(Integer.parseInt(komento), this.lukija);
            tarkistaOnnistuikoOperaatio(tama);
            
        }catch(Exception e){
            System.out.println("Virheellinen komento, syötä uusi");
        }
    }
    
    private void tarkistaOnnistuikoOperaatio(boolean tama){
        
        if(tama == false){
            
            System.out.println("Komentoa ei voida toteuttaa, tarkista syötteet.");
        }
    }
}
