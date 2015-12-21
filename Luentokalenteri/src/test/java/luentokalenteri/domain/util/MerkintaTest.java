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
public class MerkintaTest {
    
    Merkinta testattava;
    
    @Before
    public void setUp() {
        
        testattava = new Merkinta("OTM","12-14");
    }

    @Test
    public void merkinnanLuontiToimiiOikein(){
        
        assertEquals("OTM 12-14", testattava.toString());
    }
}
