package entiteter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinTable(
            name = "oblig3.Avdeling", // NB! Må ha med schema !!!
            joinColumns = @JoinColumn(name="Avdelings_Id"),
            inverseJoinColumns = @JoinColumn(name="Ansatt_Id"))
    private List<Ansatt> ansatte;
}
