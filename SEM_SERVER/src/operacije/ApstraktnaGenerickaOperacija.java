/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;
import repository.Repository;
import repository.db.impl.DbRepositoryGeneric;
import repository.db.DbRepository;
/**
 *
 * @author Korisnik
 */
public abstract class ApstraktnaGenerickaOperacija {
    protected final Repository broker;

    public ApstraktnaGenerickaOperacija() {
        this.broker = new DbRepositoryGeneric();
    }
    
    public final void izvrsi(Object objekat, String kljuc) throws Exception{
        try{
            preduslovi(objekat);
            zapocniTransakciju();
            izvrsiOperaciju(objekat, kljuc);
            potvrdiTransakciju();
        }catch (Exception e){
            ponistiTranskaciju();
            throw e;
        }
        finally{
            //ugasiKonekciju();
        }
    }

    protected abstract void preduslovi(Object objekat) throws Exception;

    private void zapocniTransakciju() throws Exception {
        ((DbRepository) broker).connect();
    }

    protected abstract void izvrsiOperaciju(Object param, String kljuc) throws Exception;

    private void potvrdiTransakciju() throws Exception {
        ((DbRepository) broker).commit();
    }

    private void ponistiTranskaciju() throws Exception {
        ((DbRepository) broker).rollback();
    }

    private void ugasiKonekciju() throws Exception {
        ((DbRepository) broker).disconnect();
    }
}
