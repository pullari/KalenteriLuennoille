/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.lista;

/**
 * Luokka sisältää kuvauksen yksittäisestä merkinnästä ja tarjoaa metodit
 * muokata sitä.
 *
 * @author Pullari
 *
 *
 */
public class Merkinta {

    private String nimi;
    private String aika;
    private String kuvaus;

    public Merkinta(String nimi, String aika, String kuvaus) {

        this.nimi = nimi;
        this.aika = aika;
        this.kuvaus = kuvaus;
    }

    public void setKuvaus(String uusi) {

        this.kuvaus = uusi;
    }

    public String getKuvaus() {

        return this.kuvaus;
    }
    
    public void setNimi(String uusi) {

        this.nimi = uusi;
    }

    public String getNimi() {

        return this.nimi;
    }

    public void setAika(String uusi) {

        this.aika = uusi;
    }

    public String getAika() {

        return this.aika;
    }

    @Override
    public String toString() {

        return this.nimi + " " + this.aika;
    }
}
