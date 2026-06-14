/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class RadniNalog implements ApstraktniDomenskiObjekat {
    private int idRadniNalog;
    private double ukupnaCena;
    private int ukupnoVremeTrajanja;
    private LocalDate datumOtvaranja;
    private String registracijaVozila;
    private Automehanicar automehanicar;
    private Klijent klijent;
    private List<StavkaRadnogNaloga> stavke;

    public RadniNalog() {
    }

    public RadniNalog(int idRadniNalog, double ukupnaCena, int ukupnoVremeTrajanja, LocalDate datumOtvaranja, String registracijaVozila, Automehanicar automehanicar, Klijent klijent) {
        this.idRadniNalog = idRadniNalog;
        this.ukupnaCena = ukupnaCena;
        this.ukupnoVremeTrajanja = ukupnoVremeTrajanja;
        this.datumOtvaranja = datumOtvaranja;
        this.registracijaVozila = registracijaVozila;
        this.automehanicar = automehanicar;
        this.klijent = klijent;
    }

    

    public String getRegistracijaVozila() {
        return registracijaVozila;
    }

    public void setRegistracijaVozila(String registracijaVozila) {
        this.registracijaVozila = registracijaVozila;
    }

    public int getIdRadniNalog() {
        return idRadniNalog;
    }

    public void setIdRadniNalog(int idRadniNalog) {
        this.idRadniNalog = idRadniNalog;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public int getUkupnoVremeTrajanja() {
        return ukupnoVremeTrajanja;
    }

    public void setUkupnoVremeTrajanja(int ukupnoVremeTrajanja) {
        this.ukupnoVremeTrajanja = ukupnoVremeTrajanja;
    }

    public LocalDate getDatumOtvaranja() {
        return datumOtvaranja;
    }

    public void setDatumOtvaranja(LocalDate datumOtvaranja) {
        this.datumOtvaranja = datumOtvaranja;
    }

    @Override
    public String toString() {
        return "RadniNalog{" + "idRadniNalog=" + idRadniNalog + ", ukupnaCena=" + ukupnaCena + ", ukupnoVremeTrajanja=" + ukupnoVremeTrajanja + ", datumOtvaranja=" + datumOtvaranja + ", registracijaVozila=" + registracijaVozila + ", automehanicar=" + automehanicar + ", klijent=" + klijent + '}';
    }    

    @Override
    public int hashCode() {
        int hash = 5;
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
        final RadniNalog other = (RadniNalog) obj;
        if (this.idRadniNalog != other.idRadniNalog) {
            return false;
        }
        return Objects.equals(this.registracijaVozila, other.registracijaVozila);
    }

    public Automehanicar getAutomehanicar() {
        return automehanicar;
    }

    public void setAutomehanicar(Automehanicar automehanicar) {
        this.automehanicar = automehanicar;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    public String vratiNazivTabele() {
        return "radni_nalog";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
               int idRadniNalog = rs.getInt("radni_nalog.idRadniNalog");
               double ukupnaCena = rs.getDouble("radni_nalog.ukupnaCena");
               int ukupnoVremeTrajanja = rs.getInt("radni_nalog.ukupnoVremeTrajanja");
               LocalDate datumOtvaranja = rs.getObject("radni_nalog.datumOtvaranja", LocalDate.class);
               String registracijaVozila = rs.getString("radni_nalog.registracijaVozila");

               int idAutomehanicar = rs.getInt("automehanicar.idAutomehanicar");
               String imeAutomehanicara = rs.getString("automehanicar.ime");
               String prezimeAutomehanicara = rs.getString("automehanicar.prezime");
               String korisnickoIme = rs.getString("automehanicar.korisnickoIme");
               String sifra = rs.getString("automehanicar.sifra");

               Automehanicar automehanicar = new Automehanicar(idAutomehanicar, imeAutomehanicara, prezimeAutomehanicara, korisnickoIme, sifra);

               int idMesto = rs.getInt("mesto.idMesto");
               String nazivMesta = rs.getString("mesto.naziv");
               int postanskiBroj = rs.getInt("mesto.postanskiBroj");

               Mesto mesto = new Mesto(idMesto, nazivMesta, postanskiBroj);

               int idKlijent = rs.getInt("klijent.idKlijent");
               String imeKlijenta = rs.getString("klijent.ime");
               String prezimeKlijenta = rs.getString("klijent.prezime");
               String brojTelefona = rs.getString("klijent.brojTelefona");
               String email = rs.getString("klijent.email");

               Klijent klijent = new Klijent(idKlijent, imeKlijenta, prezimeKlijenta, brojTelefona, email, mesto);

               RadniNalog radniNalog = new RadniNalog(idRadniNalog, ukupnaCena, ukupnoVremeTrajanja, datumOtvaranja, registracijaVozila, automehanicar, klijent);

               lista.add(radniNalog);
           }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacaivanje() {
        return "ukupnaCena, ukupnoVremeTrajanja, datumOtvaranja, registracijaVozila, idAutomehanicar, idKlijent";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'"+ukupnaCena+"','"+ukupnoVremeTrajanja+"','"+datumOtvaranja+"','"+registracijaVozila+"','"+automehanicar.getIdAutomehanicar()+"','"+klijent.getIdKlijent()+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "radni_nalog.idRadniNalog ="+idRadniNalog;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ukupnaCena="+ukupnaCena+", ukupnoVremeTrajanja="+ukupnoVremeTrajanja+", datumOtvaranja='"+datumOtvaranja+
                "', registracijaVozila='"+registracijaVozila+"', idAutomheanicar="+automehanicar.getIdAutomehanicar()+", idKlijent="+klijent.getIdKlijent();
    }
    
    
    
}
