/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.komennot;

import java.util.Scanner;
import luentokalenteri.domain.lista.Merkintalista;

/**
 *
 * @author Pullis
 */
public class Tyhjenna implements Komento {

    @Override
    public boolean suorita(Merkintalista lista, String... arg) {
        
        return lista.tyhjenna();
    }
}
