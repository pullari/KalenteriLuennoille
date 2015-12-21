/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.sovelluslogiikka;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
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
    

    @Before
    public void setUp() {
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
    }
    
    @Test
    public void tyhjennysToimii(){
        
        String syote = kasaa("1", "ma", "OTM", "12-14", "1", "ma", "Luento", "8-9", "3", "4","x");
        Sovelluslogiikka logiikka = new Sovelluslogiikka(new Scanner(syote));
        logiikka.kaynnista();
        
        String tulos = tulosvirta.toString();
        assertFalse(tulos.contains("OTM 12-14"));
        assertFalse(tulos.contains("Luento 8-9"));
    }
    
    @Test
    public void poistoToimii(){
        
        String syote = kasaa("1", "ma", "OTM", "12-14", "2", "ma", "OTM", "4","x");
        Sovelluslogiikka logiikka = new Sovelluslogiikka(new Scanner(syote));
        logiikka.kaynnista();
        
        String tulos = tulosvirta.toString();
        assertFalse(tulos.contains("OTM 12-14"));
    }

    @Test
    public void lisaysJaTulostusToimii(){
        
        String syote = kasaa("1", "ma", "OTM", "12-14", "4","x");
        Sovelluslogiikka logiikka = new Sovelluslogiikka(new Scanner(syote));
        logiikka.kaynnista();
        
        String tulos = tulosvirta.toString();
        assertTrue(tulos.contains("OTM 12-14"));
    }
    
    @Test
    public void ohjeetTulostuu(){
        
        String syote = kasaa("x");
        Sovelluslogiikka logiikka = new Sovelluslogiikka(new Scanner(syote));
        logiikka.kaynnista();
        
        String tulos = tulosvirta.toString();
        assertTrue(tulos.contains("1 lisää uusi merkintä || 2 poista merkintä || 3 tyhjennä kaikki || 4 tulosta lista || x lopettaa"));
    }

    private String kasaa(String... rivit) {
        
        String syote = "";
        
        for (String rivi : rivit) {
            syote += rivi + "\n";
        }
        return syote;
    }
}
