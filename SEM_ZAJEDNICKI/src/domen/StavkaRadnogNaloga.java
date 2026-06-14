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
public class StavkaRadnogNaloga implements ApstraktniDomenskiObjekat {
    private RadniNalog radniNalog;
    private int rb;
    private String opis;
    private double cena;
    private int kolicina;
    private double iznos;
    private Usluga usluga;

    public StavkaRadnogNaloga() {
    }

    public StavkaRadnogNaloga(RadniNalog radniNalog, int rb, String opis, double cena, int kolicina, double iznos, Usluga usluga) {
        this.radniNalog = radniNalog;
        this.rb = rb;
        this.opis = opis;
        this.cena = cena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.usluga = usluga;
    }

    public RadniNalog getRadniNalog() {
        return radniNalog;
    }

    public void setRadniNalog(RadniNalog radniNalog) {
        this.radniNalog = radniNalog;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
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
        final StavkaRadnogNaloga other = (StavkaRadnogNaloga) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (!Objects.equals(this.radniNalog, other.radniNalog)) {
            return false;
        }
        return Objects.equals(this.usluga, other.usluga);
    }

    @Override
    public String toString() {
        return "StavkaRadnogNaloga{" + "radniNalog=" + radniNalog + ", rb=" + rb + ", opis=" + opis + ", cena=" + cena + ", kolicina=" + kolicina + ", iznos=" + iznos + ", usluga=" + usluga + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "stavka_radni_nalog";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
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

            int idAutomehanicar = rs.getInt("automehanicar.idAutomehanicar");
            String imeAutomehanicara = rs.getString("automehanicar.ime");
            String prezimeAutomehanicara = rs.getString("automehanicar.prezime");
            String korisnickoIme = rs.getString("automehanicar.korisnickoIme");
            String sifra = rs.getString("automehanicar.sifra");

            Automehanicar automehanicar = new Automehanicar(idAutomehanicar, imeAutomehanicara, prezimeAutomehanicara, korisnickoIme, sifra);

            int idRadniNalog = rs.getInt("radni_nalog.idRadniNalog");
            double ukupnaCena = rs.getDouble("radni_nalog.ukupnaCena");
            int ukupnoVremeTrajanja = rs.getInt("radni_nalog.ukupnoVremeTrajanja");
            LocalDate datumOtvaranja = rs.getObject("radni_nalog.datumOtvaranja", LocalDate.class);
            String registracijaVozila = rs.getString("radni_nalog.registracijaVozila");

            RadniNalog radniNalog = new RadniNalog(idRadniNalog, ukupnaCena, ukupnoVremeTrajanja, datumOtvaranja, registracijaVozila, automehanicar, klijent);

            int idUsluga = rs.getInt("usluga.idUsluga");
            String nazivUsluge = rs.getString("usluga.naziv");
            double cenaUsluge = rs.getDouble("usluga.cena");
            int vremeTrajanja = rs.getInt("usluga.vremeTrajanja");

            Usluga usluga = new Usluga(idUsluga, nazivUsluge, cenaUsluge, vremeTrajanja);

            int rb = rs.getInt("stavka_radni_nalog.rb");
            String opis = rs.getString("stavka_radni_nalog.opis");
            double cenaStavke = rs.getDouble("stavka_radni_nalog.cena");
            int kolicina = rs.getInt("stavka_radni_nalog.kolicina");
            double iznos = rs.getDouble("stavka_radni_nalog.iznos");

            StavkaRadnogNaloga stavka = new StavkaRadnogNaloga(radniNalog, rb, opis, cenaStavke, kolicina, iznos, usluga);

            lista.add(stavka);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacaivanje() {
        return "rb, opis, cena, kolicina, iznos, idUsluga";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return  "'"+radniNalog.getIdRadniNalog()+"','"+rb+"','"+opis+"','"+cena+"','"+kolicina+"','"+iznos+"','"+usluga.getIdUsluga()+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavka_radni_nalog.rb="+rb;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "opis='"+opis+"', cena="+cena+", kolicina="+kolicina+", iznos="+iznos+", idUsluga="+usluga.getIdUsluga();
    }

    
    
}
