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
public class AutomehanicarSpecijalizacija implements ApstraktniDomenskiObjekat {
    private Automehanicar automehanicar;
    private Specijalizacija specijalizacija;
    private int godinaPocetkaRada;

    public AutomehanicarSpecijalizacija() {
    }

    public AutomehanicarSpecijalizacija(Automehanicar automehanicar, Specijalizacija specijalizacija, int godinaPocetkaRada) {
        this.automehanicar = automehanicar;
        this.specijalizacija = specijalizacija;
        this.godinaPocetkaRada = godinaPocetkaRada;
    }

    public Automehanicar getAutomehanicar() {
        return automehanicar;
    }

    public void setAutomehanicar(Automehanicar automehanicar) {
        this.automehanicar = automehanicar;
    }

    public Specijalizacija getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(Specijalizacija specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getGodinaPocetkaRada() {
        return godinaPocetkaRada;
    }

    public void setGodinaPocetkaRada(int godinaPocetkaRada) {
        this.godinaPocetkaRada = godinaPocetkaRada;
    }

    @Override
    public String toString() {
        return "AutomehanicarSpecijalizacija{" + "automehanicar=" + automehanicar + ", specijalizacija=" + specijalizacija + ", godinaPocetkaRada=" + godinaPocetkaRada + '}';
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
        final AutomehanicarSpecijalizacija other = (AutomehanicarSpecijalizacija) obj;
        if (this.godinaPocetkaRada != other.godinaPocetkaRada) {
            return false;
        }
        if (!Objects.equals(this.automehanicar, other.automehanicar)) {
            return false;
        }
        return Objects.equals(this.specijalizacija, other.specijalizacija);
    }

    @Override
    public String vratiNazivTabele() {
        return "automehanicar_specijalizacija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {

            int idAutomehanicar = rs.getInt("automehanicar.idAutomehanicar");
            String imeAutomehanicara = rs.getString("automehanicar.ime");
            String prezimeAutomehanicara = rs.getString("automehanicar.prezime");
            String korisnickoIme = rs.getString("automehanicar.korisnickoIme");
            String sifra = rs.getString("automehanicar.sifra");

            Automehanicar automehanicar = new Automehanicar(idAutomehanicar, imeAutomehanicara, prezimeAutomehanicara, korisnickoIme, sifra);

            int idSpecijalizacija = rs.getInt("specijalizacija.idSpecijalizacija");
            String nazivSpecijalizacije = rs.getString("specijalizacija.naziv");
            String opis = rs.getString("specijalizacija.opis");

            Specijalizacija specijalizacija = new Specijalizacija(idSpecijalizacija, nazivSpecijalizacije, opis);

            int godinaPocetkaRada = rs.getInt("automehanicar_specijalizacija.godinaPocetkaRada");

            AutomehanicarSpecijalizacija asp =new AutomehanicarSpecijalizacija(automehanicar, specijalizacija, godinaPocetkaRada);

            lista.add(asp);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacaivanje() {
        return "idautomehanicar,idSpecijalizacija,godinaPocetkaRada";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'"+automehanicar.getIdAutomehanicar()+"','"+specijalizacija.getIdSpecijalizacija()+"','"+godinaPocetkaRada+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
