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

/**
 *
 * @author Pullis
 */
public class Sovelluslogiikka {
    
    private Merkintalista lista;
    private List<Komento> komennot;
    private Scanner lukija;
    
    public Sovelluslogiikka(){
        
        this.lista = new Merkintalista();
        this.komennot = new ArrayList<>();
        this.lukija = new Scanner(System.in);
    }
    
    public void kaynnista(){
        
        alustaKomennot();
        System.out.println("1 lisää uusi merkintä || 2 poista merkintä || 3 tyhjennä kaikki || 4 tulosta lista || x lopettaa");
        
        while(true){
            
            System.out.println("");
            System.out.print("Komento: ");
            String komento = this.lukija.nextLine();
            
            if(komento.equals("x")){
                
                break;
            }else{
                
                try{
                
                    int tama = Integer.parseInt(komento);
                    this.komennot.get(tama - 1).suorita(this.lista, this.lukija);
                }catch(Exception e){

                    System.out.println("Virheellinen komento, anna uusi");
                }
            }
        }
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
}
