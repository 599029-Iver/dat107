package entitet;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private LocalDate dato;
    private String stilling;
    private long lonn;
    
    @OneToMany(mappedBy="ansatt")
    private List<Prosjektdeltagelse> deltagelser;
    
    public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate dato, String stilling, long lonn) {
    	this.brukernavn = brukernavn;
    	this.fornavn = fornavn;
    	this.etternavn = etternavn;
    	this.dato = dato;
    	this.stilling = stilling;
    	this.lonn = lonn;
    	
    }
    
    public int getId() {
		return id;
	}
    public String getBrukernavn() {
    	return brukernavn;
    }
    public String getEtternavn() {
    	return etternavn;
    }
    public String getFornavn() {
    	return fornavn;
    }
    public LocalDate getDato() {
    	return dato;
    }
    public String getStilling() {
    	return stilling;
    }
    public long getLonn() {
    	return lonn;
    }
    /*
    public String getAvdeling() {
    	return avdeling;
    }
    */
    
    public void setStilling(String stilling) {
    	this.stilling = stilling;
    }
    
    public String toString(/*String innrykk*/) {
       // System.out.printf("%sAnsatt nr %d: %s %s", innrykk, id, fornavn, etternavn);
    	return "Ansatt nr " + id + ": " + fornavn + " " + etternavn + " : Jobber som " + stilling + " i " /*+ avdeling*/ + " : Ble ansatt " + dato + " og tjener " + lonn + " i aaret";
    }
    
    public void skrivUtMedProsjekter() {
        System.out.println();
        System.out.println(toString());
        deltagelser.forEach(p -> p.skrivUt("\n   "));
    }

    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.add(prosjektdeltagelse);
    }

    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.remove(prosjektdeltagelse);
    }



	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}
    


}