/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.klijenti;

import domen.Klijent;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajKlijenteSO extends ApstraktnaGenerickaOperacija {
    private List<Klijent> klijenti;
    @Override
    protected void preduslovi(Object objekat) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        klijenti = broker.getAll(new Klijent(), null);
    }

    public List<Klijent> getKlijetni() {
        return klijenti;
    }
    
}
