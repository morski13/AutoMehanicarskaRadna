/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Klijent;
import forme.LoginForma;
import forme.PrikazKlijenataForma;
import forme.model.ModeltabeleKlijent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazKlijenataController {
    private PrikazKlijenataForma pkf;
    public PrikazKlijenataController(PrikazKlijenataForma pkf) {
        this.pkf = pkf;
        addActionListeners();
    }
    public void otvoriFormu() {
        pripremiFormu();
        pkf.setVisible(true);
        //
    }

    private void pripremiFormu() {
        List<Klijent> klijenti = komunikacija.Komunikacija.getInstance().ucitajKlijente();
        ModeltabeleKlijent mtk = new ModeltabeleKlijent(klijenti);
        pkf.getjTableKlijenti().setModel(mtk);
    }

    private void addActionListeners() {
        pkf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKlijenti().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise klijenta.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModeltabeleKlijent mtk = (ModeltabeleKlijent) pkf.getjTableKlijenti().getModel();
                    Klijent k = mtk.getLista().get(red);
                    try{
                        Komunikacija.getInstance().obrisiKlijenta(k);
                        JOptionPane.showMessageDialog(pkf, "Sistem je obrisao klijenta.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise klijenta.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
    
}
