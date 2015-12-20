/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.domain.util;

/**
 *
 * @author Pullis
 */
public class Merkinta {
    
    private String nimi;
    private String aika;
    
    public Merkinta(String nimi, String aika){
        
        this.nimi = nimi;
        this.aika = aika;
    }
    
    public void setNimi(){
        
        this.nimi = nimi;
    }
    
    public String getNimi(){
        
        return this.nimi;
    }
    
    public void setAika(){
        
        this.aika = aika;
    }
    
    public String getAika(){
        
        return this.aika;
    }
    
    @Override
    public String toString(){
        
        return this.nimi + " " + this.aika;
    }
}
