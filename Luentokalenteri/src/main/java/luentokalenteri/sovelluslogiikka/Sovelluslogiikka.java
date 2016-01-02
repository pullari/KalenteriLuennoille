/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.sovelluslogiikka;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import luentokalenteri.domain.komennot.Komento;
import luentokalenteri.domain.komennot.Lisaa;
import luentokalenteri.domain.komennot.Poista;
import luentokalenteri.domain.komennot.Tulosta;
import luentokalenteri.domain.komennot.Tyhjenna;
import luentokalenteri.domain.lista.Merkintalista;
import luentokalenteri.domain.tiedostonkasittelija.TiedostonLukija;
import luentokalenteri.domain.tiedostonkasittelija.TiedostoonTallentaja;

/**
 * Sovelluksen peruslogiikka, joka huolehtii sovelluksen luokkien käytöstä
 * @author Pullari
 * 
 */
public class Sovelluslogiikka {
    
    private Merkintalista lista;
    private List<Komento> komennot;
    private TiedostonLukija tiedostonLukija;
    private TiedostoonTallentaja tallentaja;
    
    private String tiedostonNimi;     //TESTAAMISEN HELPOTTAMISEKSI
    
    public Sovelluslogiikka(String nimi){
        
        this.tiedostonNimi = nimi;
        this.lista = new Merkintalista();
        this.komennot = new ArrayList<>();
        alustaTiedostonLukijaJaTallentaja();
        alustaKomennot();
    }
    
    public Merkintalista getLista(){
        
        return this.lista;
    }
    
    /**
     * Sovelluslogiikan metodi joka pyytää listaa tulostamaan tietyn päivän
     * @param paiva Päivä, joka tulostetaan
     * @return palauttaa päivän tulostus muodon
     */
    
    public String tulostaPaiva(String paiva){
        
        return lista.tulostaPaiva(paiva);
    }
    
    public String tulosta(){
        
        return lista.toString();
    }
    
    /**
     * Tallentaa listan tiedostoon
     * 
     * @see luentokalenteri.domain.tiedostonkasittelija.TiedostoonTallentaja#tallennaTilanne(java.util.Map) 
     * @return palauttaa tiedon operaation onnistumisesta
     */
    
    public boolean tallennaTila(){
        
        return tallentaja.tallennaTilanne(this.lista.getMap());
    }
    
    /**
     * Purkaa tallennetut merkinnät tiedostosta
     * 
     * @see luentokalenteri.domain.tiedostonkasittelija.TiedostonLukija#puraTallennetut(java.util.Map) 
     * 
     */
    
    public void puraTiedosto(){
        
        this.tiedostonLukija.puraTallennetut(this.lista.getMap());
    }
    
    /**
     * Metodi pyytää sille annettua komentoa suorittamaan itsensä
     * @param indeksi Suoritettavan komennon indeksi komentolistassa
     * @param arg Komennolle annettavat String-muuttujat
     * @return Palauttaa onnistuiko suoritus
     */
    
    public boolean suoritaKomento(int indeksi, String... arg){
        
        return this.komennot.get(indeksi - 1).suorita(this.lista, arg);
    }
    
    /**
     * Lisää komennot listaan, josta ne voidaan suorittaa
     */
    
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
    
    /**
     * alustaa tiedostonkäsittelyyn tarvittavat luokat try - catch:lla
     */
    
    private void alustaTiedostonLukijaJaTallentaja() {
        
        try{
            File tiedosto = new File(this.tiedostonNimi);
            this.tiedostonLukija = new TiedostonLukija(tiedosto);
            this.tallentaja = new TiedostoonTallentaja(tiedosto);
            
        }catch(Exception e){
            
            System.out.println("Virhe! Tarkista tallnennustiedoston olemassaolo");
        }
    }
}
