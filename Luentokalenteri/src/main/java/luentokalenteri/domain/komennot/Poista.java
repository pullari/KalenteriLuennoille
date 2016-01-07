/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import luentokalenteri.domain.lista.Merkintalista;

/**
 * Määrittelee komennon, joka poistaa listasta merkinnän
 *
 * @author Pullari
 *
 */
public class Poista implements Komento {

    /**
     * Poistaa listasta määritellyn merkinnän
     *
     * @param lista lista, josta poistetaan
     * @param arg Poistettavan merkinnän päivä ja nimi
     * @see luentokalenteri.domain.lista.Merkintalista#poista(java.lang.String,
     * java.lang.String)
     * @return palauttaa onnistuiko operaatio
     */
    @Override
    public boolean suorita(Merkintalista lista, String... arg) {

        return lista.poista(arg[0], arg[1]);
    }
}
