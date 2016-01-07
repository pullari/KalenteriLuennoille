/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.tiedostonkasittelija;

import luentokalenteri.domain.tiedostonkasittelija.TiedostoonTallentaja;
import luentokalenteri.domain.lista.Merkinta;
import luentokalenteri.domain.tiedostonkasittelija.TiedostonLukija;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import luentokalenteri.domain.lista.Merkinta;
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
public class TiedostoonTallentajaTest {
    
    TiedostoonTallentaja testattava;
    TiedostonLukija lue;
    File tiedosto;
    Map<String, List<Merkinta>> testiLista;
    ByteArrayOutputStream tulosvirta;
    
    @Before
    public void setUp() {
        
        testiLista = new HashMap<>();
        alustaLista(testiLista);
        
        tiedosto = new File("src/test/java/luentokalenteri/domain/tiedostonkasittelija/testiTiedostoonKirjoittajalle.txt");
        
        try{
            testattava = new TiedostoonTallentaja(tiedosto);
            lue = new TiedostonLukija(tiedosto);
        }catch(Exception e){
            System.out.println("Virhe testauksen setupissa");
        }
        
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
    }
    
    @Test
    public void vaaraTiedostoTestiToimii(){
        
        testattava = new TiedostoonTallentaja(new File("\"src/test/java/luentokalenteri/domain/util/testiTiedostoonKirjoittajale.txt\""));
        assertFalse(testattava.tallennaTilanne(testiLista));
    }
    
    @Test
    public void tallennusToimii(){
        
        Map<String, List<Merkinta>> puraTanne = new HashMap<>();
        alustaLista(puraTanne);
        
        Merkinta lisays1 = new Merkinta("OHTU", "5-6","toimii");
        Merkinta lisays2 = new Merkinta("OHJA", "15-16","testi");
        
        this.testiLista.get("ma").add(lisays1);
        this.testiLista.get("ke").add(lisays2);
        
        testattava.tallennaTilanne(testiLista);
        lue.puraTallennetut(puraTanne);
        
        assertTrue(puraTanne.get("ma").get(0).getNimi().equals("OHTU") && puraTanne.get("ma").get(0).getAika().equals("5-6"));
        assertTrue(puraTanne.get("ke").get(0).getNimi().equals("OHJA") && puraTanne.get("ke").get(0).getAika().equals("15-16"));
    }
    
    @Test
    public void tallennusEiLisaaYlimaaraista(){
        
        Map<String, List<Merkinta>> puraTanne = new HashMap<>();
        alustaLista(puraTanne);
        
        Merkinta lisays1 = new Merkinta("OHTU", "5-6","toimii");
        Merkinta lisays2 = new Merkinta("OHJA", "15-16","testi");
        
        this.testiLista.get("ma").add(lisays1);
        this.testiLista.get("ke").add(lisays2);
        
        testattava.tallennaTilanne(testiLista);
        lue.puraTallennetut(puraTanne);
        
        assertFalse(puraTanne.get("ti").contains(lisays1));
        assertFalse(puraTanne.get("to").contains(lisays2));
    }
    
    @Test
    public void tallennusEiLisaaTyhjia(){
        
        Map<String, List<Merkinta>> puraTanne = new HashMap<>();
        alustaLista(puraTanne);
        
        Merkinta lisays1 = new Merkinta("OHTU", "5-6","toimii");
        Merkinta lisays2 = new Merkinta("OHJA", "15-16","testi");
        
        testattava.tallennaTilanne(testiLista);
        lue.puraTallennetut(puraTanne);
        
        assertFalse(puraTanne.get("ti").contains(lisays1));
        assertFalse(puraTanne.get("to").contains(lisays2));
    }

    @Test
    public void merkinnanKokoaminenToimiiOikein(){
        
        Merkinta testattava = new Merkinta("OHTU", "14-16","toimii");
        String tama = kokoaTallennusMuoto("ma", testattava);
        
        assertEquals("ma;OHTU;14-16" + "\n", tama);
    }

    private String kokoaTallennusMuoto(String paiva, Merkinta merkinta){
        
        return paiva + ";" + merkinta.getNimi() + ";" + merkinta.getAika() + "\n";
    }
    
    private void alustaLista(Map<String, List<Merkinta>> alustettava){
        
        String[] paivat = {"ma", "ti", "ke", "to", "pe"};
        for (String tama : paivat) {
            
            alustettava.put(tama, new ArrayList<Merkinta>());
        }
    }
}
