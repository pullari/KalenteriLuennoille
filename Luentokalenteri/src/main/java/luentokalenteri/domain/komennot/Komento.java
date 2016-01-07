/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import java.util.Scanner;
import luentokalenteri.domain.lista.Merkintalista;
import luentokalenteri.domain.tiedostonkasittelija.TiedostoonTallentaja;

/**
 * Rajapinta komennoille
 *
 * @author Pullari
 *
 */
public interface Komento {

    public boolean suorita(Merkintalista lista, String... tama);
}
