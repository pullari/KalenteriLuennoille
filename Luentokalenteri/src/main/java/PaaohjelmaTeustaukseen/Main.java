package PaaohjelmaTeustaukseen;

import java.io.File;
import java.util.Scanner;
import luentokalenteri.domain.lista.Merkinta;
import luentokalenteri.domain.lista.Merkintalista;
import luentokalenteri.domain.tiedostonkasittelija.TiedostonLukija;
import luentokalenteri.kayttojarjestelma.tekstiKayttojarjestelma;
import luentokalenteri.sovelluslogiikka.Sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuli Rouvinen
 * Version 0.1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main testaamista varten. Ohjelma toimii suoraan käynnistämällä.
        
//        Sovelluslogiikka testi = new Sovelluslogiikka(new Scanner(System.in));
//        testi.kaynnista();
        tekstiKayttojarjestelma kayttis = new tekstiKayttojarjestelma(new Scanner(System.in));
        kayttis.suorita();
    }
}
