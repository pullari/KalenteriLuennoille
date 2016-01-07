package luentokalenteri.main;

import luentokalenteri.kayttojarjestelma.KalenteriGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samuli Rouvinen Version 0.1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main testaamista varten. Ohjelma toimii suoraan käynnistämällä.

        KalenteriGUI kayttis = new KalenteriGUI();
        kayttis.run();
    }
}
