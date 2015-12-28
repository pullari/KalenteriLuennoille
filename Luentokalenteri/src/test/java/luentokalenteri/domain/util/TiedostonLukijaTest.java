/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class TiedostonLukijaTest {
    
    TiedostonLukija testattava;
    File tiedosto;
    Map<String, List<Merkinta>> testiLista;
    ByteArrayOutputStream tulosvirta;
    
    @Before
    public void setUp() {
        
        testiLista = new HashMap<>();
        alustaLista();
        
        tiedosto = new File("src/test/java/luentokalenteri/domain/util/testiTiedostoLukijalle.txt");
        
        try{
            testattava = new TiedostonLukija(tiedosto);
        }catch(Exception e){
            System.out.println("Virhe testauksen setupissa");
        }
        
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
    }
    
    @Test
    public void purkaminenToimii(){
        
        testattava.puraTallennetut(testiLista);
        assertTrue(testiLista.get("ke").size() == 1 && testiLista.get("to").size() == 1);
    }
    
    @Test
    public void vaaraTiedostoEiToimi(){
        
        try{
            testattava = new TiedostonLukija(new File("src/test/java/luentokalenteri/domain/util/virheellinenTiedostoTesti.txt"));
            testattava.puraTallennetut(testiLista);
            String tulos = tulosvirta.toString();
            System.out.println(tulos);
            assertTrue(tulos.contains("Virhe purettaessa tiedostoa!"));
        }catch(Exception e){
            
        }
    }
    
    @Test
    public void purettaessaOikeatNimet(){
        
        testattava.puraTallennetut(testiLista);
        assertTrue(testiLista.get("ke").get(0).getNimi().equals("Aineharjoitus") && testiLista.get("to").get(0).getNimi().equals("OHPE"));
        assertFalse(testiLista.get("ke").get(0).getNimi().equals("Ainearjoitus") && testiLista.get("to").get(0).getNimi().equals("OHE"));
    }
    
    @Test
    public void purettaessaOikeatAjat(){
        
        testattava.puraTallennetut(testiLista);
        assertTrue(testiLista.get("ke").get(0).getAika().equals("12-14") && testiLista.get("to").get(0).getAika().equals("8-10"));
        assertFalse(testiLista.get("ke").get(0).getAika().equals("1-14") && testiLista.get("to").get(0).getAika().equals("8-1"));
    }
    
    private void alustaLista(){
        
        String[] paivat = {"ma", "ti", "ke", "to", "pe"};
        for (String tama : paivat) {
            
            this.testiLista.put(tama, new ArrayList<Merkinta>());
        }
    }
}
