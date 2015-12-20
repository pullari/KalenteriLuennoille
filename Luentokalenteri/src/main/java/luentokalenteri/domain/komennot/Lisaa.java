/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import java.util.Scanner;
import luentokalenteri.domain.util.Merkinta;
import luentokalenteri.domain.util.Merkintalista;

/**
 *
 * @author Pullis
 */
public class Lisaa implements Komento {

    @Override
    public void suorita(Merkintalista lista, Scanner lukija) {
        
        System.out.print("Päivä (ma, ti, ke, to, pe): ");
        String paiva = lukija.nextLine();
        System.out.print("Nimi: ");
        String nimi = lukija.nextLine();
        System.out.print("Aika (Esim. 12-14 tai 8-9): ");
        String aika = lukija.nextLine();
        
        Merkinta lisattava = new Merkinta(nimi, aika);
        lista.lisaa(paiva, lisattava);
    }
}
