package entiteter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    private String datoAnsatt;
    private String stilling;
    private long lonn;
    
    @ManyToOne(mappedBy="Avdeling")
    private String avdeling;
    
    @ManyToMany(mappedBy="ansatte")
    private List<Prosjekt> prosjekter;
    
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
    public String getdatoAnsatt() {
    	return datoAnsatt;
    }
    public String getStilling() {
    	return stilling;
    }
    public long getLonn() {
    	return lonn;
    }
    public String getAvdeling() {
    	return avdeling;
    }
    
	public void skrivUt(String innrykk) {
        System.out.printf("%sAnsatt nr %d: %s %s", innrykk, id, fornavn, etternavn);
    }
    
    public void skrivUtMedProsjekter() {
        System.out.println();
        skrivUt("");
        prosjekter.forEach(p -> p.skrivUt("\n   "));
    }

    public void leggTilProsjekt(Prosjekt p) {
        prosjekter.add(p);
    }

    public void fjernProsjekt(Prosjekt p) {
        prosjekter.remove(p);
    }

}
