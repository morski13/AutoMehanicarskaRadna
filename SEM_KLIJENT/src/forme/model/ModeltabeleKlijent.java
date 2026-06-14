/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Klijent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModeltabeleKlijent extends AbstractTableModel{
    List<Klijent> lista;
    String[] kolone = {"Id", "Ime", "Prezime", "Broj telefona", "Email", "Mesto"};

    public ModeltabeleKlijent(List<Klijent> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdKlijent();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getBrojTelefona();
            case 4:
                return k.getEmail();
            case 5: 
                return k.getMesto();
            default:
                return "N/A";
        }
    }

    public List<Klijent> getLista() {
        return lista;
    }
    
}
