/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Korisnik
 */
public class Automehanicar implements ApstraktniDomenskiObjekat{
    private int idAutomehanicar;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Automehanicar() {
    }

    public Automehanicar(int idAutomehanicar, String ime, String prezime, String korisnickoIme, String sifra) {
        this.idAutomehanicar = idAutomehanicar;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getIdAutomehanicar() {
        return idAutomehanicar;
    }

    public void setIdAutomehanicar(int idAutomehanicar) {
        this.idAutomehanicar = idAutomehanicar;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return "Automehanicat{" + "idAutomehanicar=" + idAutomehanicar + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", sifra=" + sifra + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Automehanicar other = (Automehanicar) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String vratiNazivTabele() {
        return "automehanicar"; 
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idAutomehanicar = rs.getInt("automehanicar.idAutomehanicar");
            String ime = rs.getString("automehanicar.ime");
            String prezime = rs.getString("automehanicar.prezime");
            String korisnickoIme = rs.getString("automehanicar.korisnickoIme");
            String sifra = rs.getString("automehanicar.sifra");
            
            Automehanicar a = new Automehanicar(idAutomehanicar, ime, prezime, korisnickoIme, sifra);
            lista.add(a);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacaivanje() {
        return "ime, prezime, korisnickoIme, sifra";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+korisnickoIme+"',"+sifra+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "automehanicar.idAutomehanicar ="+idAutomehanicar;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"', prezime='"+prezime+"', korisnickoIme='"+korisnickoIme+"'";
    }
    
    
}
