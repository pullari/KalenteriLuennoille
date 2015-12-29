/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import java.util.Scanner;
import luentokalenteri.domain.lista.Merkinta;
import luentokalenteri.domain.lista.Merkintalista;

/**
 *
 * @author Pullis
 */
public class Poista implements Komento {
    
    @Override
    public boolean suorita(Merkintalista lista, Scanner lukija) {
        
        System.out.print("Päivä (ma, ti, ke, to, pe): ");
        String paiva = lukija.nextLine();
        System.out.print("Nimi: ");
        String nimi = lukija.nextLine();
        
        return lista.poista(paiva, nimi);
    }
}
