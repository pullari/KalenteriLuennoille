/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import luentokalenteri.domain.komennot.Komento;
import luentokalenteri.domain.komennot.Lisaa;
import luentokalenteri.domain.komennot.Poista;
import luentokalenteri.domain.komennot.Tulosta;
import luentokalenteri.domain.komennot.Tyhjenna;
import luentokalenteri.domain.util.Merkintalista;
import luentokalenteri.domain.util.TiedostonLukija;
import luentokalenteri.domain.util.TiedostoonTallentaja;

/**
 *
 * @author Pullis
 */
public class Sovelluslogiikka {
    
    private Merkintalista lista;
    private List<Komento> komennot;
    private Scanner lukija;
    private TiedostonLukija tiedostonLukija;
    private TiedostoonTallentaja tallentaja;
    
    public Sovelluslogiikka(Scanner lukija){
        
        this.lista = new Merkintalista();
        this.komennot = new ArrayList<>();
        this.lukija = lukija;
        this.tiedostonLukija = new TiedostonLukija();
        this.tallentaja = new TiedostoonTallentaja();
    }
    
    public void kaynnista(){
        
        alustaKomennot();
        lueTallennetutMerkinnatJaTulostaOhjeet();
        
        while(true){
            String komennonIndeksi = pyydaKomento();
            
            if(komennonIndeksi.equals("x")){
                
                tallentaja.tallennaTilanne(this.lista.getMap());
                break;
            }else{
                
                try{
                    suoritaKomento(Integer.parseInt(komennonIndeksi));
                }catch(Exception e){
                    System.out.println("Virheellinen komento, anna uusi");
                }
            }
        }
    }
    
    private void suoritaKomento(int indeksi){
        
        this.komennot.get(indeksi - 1).suorita(this.lista, this.lukija);
    }
    
    private String pyydaKomento(){
        
        System.out.println("");
        System.out.print("Komento: ");
        return this.lukija.nextLine();
    }
    
    private void alustaKomennot(){
        
        Komento eka = new Lisaa();
        Komento toka = new Poista();
        Komento kolmas = new Tyhjenna();
        Komento neljas = new Tulosta();
        
        this.komennot.add(eka);
        this.komennot.add(toka);
        this.komennot.add(kolmas);
        this.komennot.add(neljas);
    }
    
    private void lueTallennetutMerkinnatJaTulostaOhjeet(){
        
        System.out.println("1 lisää uusi merkintä || 2 poista merkintä || 3 tyhjennä kaikki || 4 tulosta lista || x lopettaa");
        this.tiedostonLukija.puraTallennetut(this.lista.getMap());
    }
}
