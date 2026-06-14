/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinatior;

import domen.Automehanicar;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazKlijenataForma;
import kontroleri.LoginController;
import kontroleri.GlavnaFormaController;
import kontroleri.PrikazKlijenataController;
/**
 *
 * @author Korisnik
 */
public class Coordinatior {
    private static Coordinatior instance;
    private Automehanicar ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private PrikazKlijenataController pkController;
    public Coordinatior() {
    }
    public static Coordinatior getInstance(){
        if(instance==null){
            instance = new Coordinatior();
        }
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
    }

    public void otvoriPrikazKlijenataFormu() {
        pkController = new PrikazKlijenataController(new PrikazKlijenataForma());
        pkController.otvoriFormu();
    }
     
    public Automehanicar getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Automehanicar ulogovani) {
        this.ulogovani = ulogovani;
    }
    
}
