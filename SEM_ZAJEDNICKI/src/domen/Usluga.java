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
public class Usluga implements ApstraktniDomenskiObjekat{
    private int idUsluga;
    private String naziv;
    private double cena;
    private int vremeTrajanja;

    public Usluga() {
    }

    public Usluga(int idUsluga, String naziv, double cena, int vremeTrajanja) {
        this.idUsluga = idUsluga;
        this.naziv = naziv;
        this.cena = cena;
        this.vremeTrajanja = vremeTrajanja;
    }

    public int getVremeTrajanja() {
        return vremeTrajanja;
    }

    public void setVremeTrajanja(int vremeTrajanja) {
        this.vremeTrajanja = vremeTrajanja;
    }

    public int getIdUsluga() {
        return idUsluga;
    }

    public void setIdUsluga(int idUsluga) {
        this.idUsluga = idUsluga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Usluga{" + "idUsluga=" + idUsluga + ", naziv=" + naziv + ", cena=" + cena + ", vremeTrajanja=" + vremeTrajanja + '}';
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
        final Usluga other = (Usluga) obj;
        if (this.idUsluga != other.idUsluga) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idUsluga = rs.getInt("usluga.idUsluga");
            String naziv = rs.getString("usluga.naziv");
            Double cena = rs.getDouble("usluga.cena");
            int VremeTrajanja = rs.getInt("usluga.vremeTrajanja");
            
            Usluga u = new Usluga(idUsluga, naziv, cena, VremeTrajanja);
            lista.add(u);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacaivanje() {
        return "naziv, cena, vremeTrajanja";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'"+naziv+"','"+cena+"','"+vremeTrajanja+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "usluga.idUsluga="+idUsluga;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"', cena="+cena+", bremeTrajanja="+vremeTrajanja;
    }
    
    
}
