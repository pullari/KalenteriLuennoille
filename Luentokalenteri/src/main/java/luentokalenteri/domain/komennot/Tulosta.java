/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import luentokalenteri.domain.lista.Merkintalista;

/**
 *
 * @author Pullis
 */
public class Tulosta implements Komento {

    @Override
    public boolean suorita(Merkintalista lista, String... tama) {
        
        System.out.println(lista);
        return true;
    }
}
