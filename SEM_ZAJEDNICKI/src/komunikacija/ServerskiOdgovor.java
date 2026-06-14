/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class ServerskiOdgovor implements Serializable {
    private Object odgovor;
    private Exception e;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, Exception e) {
        this.odgovor = odgovor;
        this.e = e;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    } 
}
