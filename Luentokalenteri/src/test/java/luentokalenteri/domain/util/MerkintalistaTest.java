package luentokalenteri.domain.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MerkintalistaTest {
    
    Merkintalista lista;
    Merkinta eka;
    Merkinta toka;
    
    @Before
    public void setUp() {
        
        lista = new Merkintalista();
        eka = new Merkinta("OTM", "12-14");
        toka = new Merkinta("Luento", "8-9");
    }

    @Test
    public void listaEiTyhjaAlussa(){
        
        assertEquals(5, lista.getMap().size());
    }
    
    @Test
    public void listaSisaltaaPaivat(){
        
        assertTrue(lista.toString().contains("ma"));
        assertTrue(lista.toString().contains("ti"));
        assertTrue(lista.toString().contains("ke"));
        assertTrue(lista.toString().contains("to"));
        assertTrue(lista.toString().contains("pe"));
    }
    
    @Test
    public void lisaysToimii(){
        
        lista.lisaa("ma", eka);
        assertEquals("OTM", lista.getMap().get("ma").get(0).getNimi());
    }
    
    @Test
    public void lisaysHylataanJosPaivaVaarin(){
        
        lista.lisaa("keskiviikko", toka);
        assertFalse(lista.getMap().keySet().contains("keskiviikko"));
    }
    
    @Test
    public void poistoToimii(){
        
        lista.lisaa("ke", toka);
        lista.poista("ke", "Luento");
        assertEquals(0, lista.getMap().get("ke").size());
    }
    
    @Test
    public void poistoTietoSailyyJosVaaraPoisto(){
        
        lista.lisaa("ke", toka);
        lista.poista("ma", "Luento");
        assertEquals(toka, lista.getMap().get("ke").get(0));
    }
    
    @Test
    public void poistoSailyttaaMuut(){
        
        lista.lisaa("ma", eka);
        lista.lisaa("ma", toka);
        lista.poista("ma", "Luento");
        assertFalse(lista.toString().contains("Luento 8-9"));
        assertEquals(eka, lista.getMap().get("ma").get(0));
    }
    
    @Test
    public void tyhjennysToimii(){
        
        lista.lisaa("ma", eka);
        lista.lisaa("ma", toka);
        lista.tyhjenna();
        assertFalse(lista.toString().contains("OTM 12-14"));
        assertFalse(lista.toString().contains("Luento 8-9"));
    }
    
    @Test
    public void tyhjennysSailyttaaPaivat(){
        
        lista.lisaa("ma", eka);
        lista.lisaa("ma", toka);
        lista.tyhjenna();
        assertTrue(lista.toString().contains("ma"));
        assertTrue(lista.toString().contains("ti"));
        assertTrue(lista.toString().contains("ke"));
        assertTrue(lista.toString().contains("to"));
        assertTrue(lista.toString().contains("pe"));
    }
}
