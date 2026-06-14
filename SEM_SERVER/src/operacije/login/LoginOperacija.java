/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.login;

import domen.Automehanicar;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {
    Automehanicar automehanicar;
    @Override
    protected void preduslovi(Object objekat) throws Exception{
        if (objekat == null || !(objekat instanceof Automehanicar)) {
            throw new Exception("Korisnicko ime i sifra nisu ispravni");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception{
        List<Automehanicar> sviAutomehanicari = broker.getAll((Automehanicar) param, null);
        System.out.println("KLASA LoginOperacija SO"+sviAutomehanicari);
        
        if(sviAutomehanicari.contains((Automehanicar)param)){
            for (Automehanicar a : sviAutomehanicari) {
                if(a.equals((Automehanicar)param)){
                    automehanicar = a;
                    return;
                }
            }
        }else{
            
                automehanicar = null;
        }
    }
    
    public Automehanicar getAutomehanicar(){
        return automehanicar;
    }
    
}
