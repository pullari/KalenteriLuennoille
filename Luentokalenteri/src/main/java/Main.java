
import luentokalenteri.domain.util.Merkinta;
import luentokalenteri.domain.util.Merkintalista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pullis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Merkinta tama = new Merkinta("otm", "12-14");
        Merkinta lisattava = new Merkinta("matikka", "10-12");
        Merkinta tamakin = new Merkinta("luento", "12-14");
        
        Merkintalista lista = new Merkintalista();
        
        lista.lisaa("ma", lisattava);
        lista.lisaa("ma", tama);
        lista.lisaa("ti", tamakin);
        lista.lisaa("la", tamakin);
        
        System.out.println(lista);
    }
    
}
