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
    
    public void skrivUt(/*String innrykk*/) {
       // System.out.printf("%sAnsatt nr %d: %s %s", innrykk, id, fornavn, etternavn);
    	System.out.println("Ansatt nr " + id + ": " + fornavn + " " + etternavn + " : Jobber som " + stilling + " i " /*+ avdeling*/ + " : Ble ansatt " + dato + " og tjener " + lonn + " i aaret");
    }
    
    public void skrivUtMedProsjekter() {
        System.out.println();
        skrivUt();
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
