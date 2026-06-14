/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Klijent implements ApstraktniDomenskiObjekat {
    private int idKlijent;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    private Mesto mesto;

    public Klijent() {
    }

    public Klijent(int idKlijent, String ime, String prezime, String brojTelefona, String email, Mesto idMesto) {
        this.idKlijent = idKlijent;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.mesto = idMesto;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getIdKlijent() {
        return idKlijent;
    }

    public void setIdKlijent(int idKlijent) {
        this.idKlijent = idKlijent;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Klijent{" + "idKlijent=" + idKlijent + ", ime=" + ime + ", prezime=" + prezime + ", brojTelefona=" + brojTelefona + ", email=" + email + ", mesto=" + mesto + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent JOIN mesto ON klijent.idMesto = mesto.idMesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            int idKlijent = rs.getInt("klijent.idKlijent");
            String ime = rs.getString("klijent.ime");
            String prezime = rs.getString("klijent.prezime");
            String brojTelefona = rs.getString("klijent.brojTelefona");
            String email = rs.getString("klijent.email");

            int idMesto = rs.getInt("klijent.idMesto");
            String nazivMesta = rs.getString("mesto.naziv");
            int postanskiBroj = rs.getInt("mesto.postanskiBroj");

            Mesto mesto = new Mesto(idMesto, nazivMesta, postanskiBroj);
            Klijent k = new Klijent(idKlijent, ime, prezime, brojTelefona, email, mesto);

            lista.add(k);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacaivanje() {
        return "ime, prezime, brojTelefona, email";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+brojTelefona+"','"+email+"','"+mesto.getIdMesto()+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kljient.idKlijent ="+idKlijent;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"', prezime='"+prezime+"', brojTelefona='"+brojTelefona+"', email='"+email+"', idMesto="+mesto.getIdMesto();
    }
    
    
}
