/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.sovelluslogiikka;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import luentokalenteri.domain.lista.Merkinta;
import luentokalenteri.domain.lista.Merkintalista;
import luentokalenteri.domain.tiedostonkasittelija.TiedostonLukija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pullis
 */
public class SovelluslogiikkaTest {
    
    ByteArrayOutputStream tulosvirta;
    File tiedosto;
    TiedostonLukija lukija;
    Sovelluslogiikka testaa;
    Map<String, List<Merkinta>> lista;

    @Before
    public void setUp() {
        
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));

        lista = new HashMap<>();
        alustaLista();
        tiedosto = new File("src/test/java/luentokalenteri/sovelluslogiikka/sovellusTesteille.txt");
        testaa = new Sovelluslogiikka(tiedosto);
        
        
        try{
            lukija = new TiedostonLukija(tiedosto);
        }catch(Exception e){
            System.out.println("Testiluku epÃ¤onnistui");
        }
    }
    
    @Test
    public void komentoToimiiHyvillaSyotteilla(){
        
        alustaLista();
        
        String[] syote = {"ti", "OTM", "12-14", "kuvaus"};
        assertTrue(testaa.suoritaKomento(1, syote));
    }
    
    @Test
    public void lisaysEiToimiJosPuolipisteNimessa(){
        
        alustaLista();
        
        String[] syote = {"ti", "OT;M", "12-14", "kuvaus"};
        assertFalse(testaa.suoritaKomento(1, syote));
    }
    
    @Test
    public void komentoEiToimiVaarillaSyotteilla(){
        
        alustaLista();
        
        String syote[] = {"123", "OTM", "12-14", "kuvaus"};
        assertFalse(testaa.suoritaKomento(1, syote));
    }
    
    @Test
    public void tallennusToimii(){
        
        alustaLista();
        
        String[] syote = {"ti", "OTM", "12-14", "kuvaus"};
        testaa.suoritaKomento(1, syote);
        testaa.tallennaTila();
        
        alustaLista();
        lukija.puraTallennetut(lista);
        
        assertTrue(lista.get("ti").size() == 1);
    }
    
    @Test
    public void tallennusToimiiViela(){
        
        alustaLista();
        
        String[] syote = {"ke", "Luento", "12-14", "kuvaus"};
        testaa.suoritaKomento(1, syote);
        testaa.tallennaTila();
        
        alustaLista();
        lukija.puraTallennetut(lista);
        
        assertFalse(lista.get("ke").size() == 0);
    }
    
    @Test
    public void purkuToimii(){
        
        File tiedosto = new File("src/test/java/luentokalenteri/sovelluslogiikka/purettava.txt");
        Sovelluslogiikka purkuaVarten = new Sovelluslogiikka(tiedosto);
        alustaLista();
        
        purkuaVarten.puraTiedosto();
        purkuaVarten.suoritaKomento(4);
        
        String tulos = tulosvirta.toString();
        System.out.println(tulos);
        
        assertTrue(tulos.contains("ma") && tulos.contains("OTM") && tulos.contains("1-2"));
        assertTrue(tulos.contains("ti") && tulos.contains("samuli") && tulos.contains("tama"));
    }
    
    @Test
    public void purkamattaEiToimi(){
        
        File tiedosto = new File("src/test/java/luentokalenteri/sovelluslogiikka/purettava.txt");
        Sovelluslogiikka purkuaVarten = new Sovelluslogiikka(tiedosto);
        alustaLista();

        purkuaVarten.suoritaKomento(4);
        
        String tulos = tulosvirta.toString();
        System.out.println(tulos);
        
        assertFalse(tulos.contains("ma") && tulos.contains("OTM") && tulos.contains("1-2"));
        assertFalse(tulos.contains("ti") && tulos.contains("samuli") && tulos.contains("tama"));
    }
    
    private void alustaLista(){
        
        this.lista.clear();
        
        String[] paivat = {"ma", "ti", "ke", "to", "pe"};
        for (String tama : paivat) {
            
            this.lista.put(tama, new ArrayList<Merkinta>());
        }
    }

    private String kasaa(String... rivit) {
        
        String syote = "";
        
        for (String rivi : rivit) {
            syote += rivi + "\n";
        }
        return syote;
    }
}
