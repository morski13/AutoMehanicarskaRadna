/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Automehanicar;
import domen.Klijent;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Reciever;
import komunikacija.Request;
import komunikacija.Sender;
import komunikacija.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class ObradaKlijentskihZahteva extends Thread {
    Socket socket;
    Sender sender;
    Reciever reciever;
    boolean kraj = false;
    public ObradaKlijentskihZahteva(Socket s) throws IOException {
        this.socket = s;
        sender = new Sender(socket);
        reciever = new Reciever(socket);
    }

    @Override
    public void run() {
        
        while(!kraj){
            try {
                Request request = (Request) reciever.primi();
                if(request == null){
                    kraj = true;
                    break;
                }
                ServerskiOdgovor odgovor = new ServerskiOdgovor();
                switch (request.getOperacija()) {
                    case LOGIN:
                        Automehanicar a = (Automehanicar) request.getParam();
                        a = Controller.getInstance().login(a);
                        odgovor.setOdgovor(a);
                        break;
                        
                    case UCITAJ_KLIJENTE:
                        List<Klijent> klijenti = Controller.getInstance().ucitajKlijente();
                        
                        odgovor.setOdgovor(klijenti);
                        break;
                        
                    case OBRISI_KLIJENTA:
                        try{
                        Klijent k = (Klijent) request.getParam();
                        Controller.getInstance().obrisiKlijenta(k);
                        odgovor.setOdgovor(null);
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                        }
                        break;
                    
                    default:
                        System.out.println("GRESKA, TA OPERACIJA NE POSTOJI");
                }
                sender.posalji(odgovor);
            } catch (Exception ex) {
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        kraj = true;
                    }        
        }
    }
    public void prekini() throws IOException{
        kraj = true;
        socket.close();
        interrupt();
    }
    
}
