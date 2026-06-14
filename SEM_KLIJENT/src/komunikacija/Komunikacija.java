/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Automehanicar;
import domen.Klijent;
import java.io.IOException;
import java.io.Serializable;
import java.net.ResponseCache;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Komunikacija implements Serializable{
    private Socket soket;
    private Sender sender;
    private Reciever reciever;
    private static Komunikacija instance;

    public Komunikacija() {
    }
    public static Komunikacija getInstance(){
        if(instance==null){
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public void konekcija() {
    try {
        soket = new Socket("localhost", 9000);

        sender = new Sender(soket);
        reciever = new Reciever(soket);

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

    public Automehanicar login(String korisIme, String password) throws IOException, ClassNotFoundException {
        Automehanicar a = new Automehanicar();
        a.setKorisnickoIme(korisIme);
        a.setSifra(password);
        Request request = new Request(Operacija.LOGIN, a);
        
        sender.posalji(request);
        
        ServerskiOdgovor odg = (ServerskiOdgovor) reciever.primi();
        if(odg == null){
            return null;
        }
        a = (Automehanicar) odg.getOdgovor();
        return a;
       
    }

    public List<Klijent> ucitajKlijente() {
        Request request = new Request(Operacija.UCITAJ_KLIJENTE, null);
        List<Klijent> klijenti = new ArrayList<>(); 
        
        sender.posalji(request);
        ServerskiOdgovor odg = (ServerskiOdgovor) reciever.primi();
        klijenti = (List<Klijent>) odg.getOdgovor();
        return klijenti;
    }

    public void obrisiKlijenta(Klijent k) {
        Request request = new Request(Operacija.OBRISI_KLIJENTA, k);
        sender.posalji(request);
        
        ServerskiOdgovor odg = (ServerskiOdgovor) reciever.primi();
        if (odg == null){
            System.out.println("USPEH");
        }else{
            System.out.println("GRESKA");
            ((Exception)odg.getOdgovor()).printStackTrace();
        }
    }
    
    
}
