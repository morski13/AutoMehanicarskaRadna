/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Automehanicar;
import domen.Klijent;
import java.util.List;
import operacije.klijenti.ObrisiKlijentaSO;
import operacije.klijenti.UcitajKlijenteSO;
import operacije.login.LoginOperacija;

/**
 *
 * @author Korisnik
 */
public class Controller {
    private static Controller instance;
    private Controller() {
    }    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }

    public Automehanicar login(Automehanicar a) throws Exception {
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(a, null);
        System.out.println("KLASA CONTROLLER: " + operacija.getAutomehanicar());
        return operacija.getAutomehanicar();
    }

    public List<Klijent> ucitajKlijente() throws Exception {
        UcitajKlijenteSO operacija = new UcitajKlijenteSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER: " + operacija.getKlijetni());
        return operacija.getKlijetni();
    }

    public void obrisiKlijenta(Klijent k) throws Exception {
        ObrisiKlijentaSO operacija = new ObrisiKlijentaSO();
        operacija.izvrsi(k, null);
    }
    
    
}
