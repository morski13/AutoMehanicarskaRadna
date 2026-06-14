/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Automehanicar;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import coordinatior.Coordinatior;
/**
 *
 * @author Korisnik
 */
public class LoginController {
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    prijava(e);
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void prijava(ActionEvent e) throws IOException, ClassNotFoundException {
                String korisIme = lf.getjTextFieldKorisIme().getText().trim();
                String password = String.valueOf(lf.getjPasswordField1().getPassword());
                
                Komunikacija.getInstance().konekcija();
                Automehanicar ulogovani = Komunikacija.getInstance().login(korisIme, password);
                
                if(ulogovani == null){
                    JOptionPane.showMessageDialog(lf, "Prijava na sistem NIJE uspesna", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    //////
                    Coordinatior.getInstance().setUlogovani(ulogovani);
                    JOptionPane.showMessageDialog(lf, "Prijava na sistem je uspesna", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    Coordinatior.getInstance().otvoriGlavnuFormu();
                    lf.dispose();
                }
            }
        });

    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
}
