package klient;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import dao.AnsattDAO;
import dao.ProsjektDAO;
import entitet.Ansatt;
import entitet.Prosjekt;

public class Main {

    public static void main(String[] args) {
        
        AnsattDAO ansattDAO = new AnsattDAO();
        
        ansattDAO.leggTilAnsatt(new Ansatt("MiBo", "Mikal", "Bo", , "lakei", 10000));
        

/*
        ProsjektDAO prosjektDAO = new ProsjektDAO();
        
        Ansatt a4 = ansattDAO.finnAnsattMedId(4);
        
        Ansatt a2 = ansattDAO.finnAnsattMedId(2);
        a2.skrivUtMedProsjekter();

        Prosjekt p2 = prosjektDAO.finnProsjektMedId(2);
        p2.skrivUtMedAnsatte();

        Prosjekt p3 = prosjektDAO.finnProsjektMedId(3);
        p3.skrivUtMedAnsatte();

        ansattDAO.registrerProsjektdeltagelse(a2.getId(), p3.getId());
        a2 = ansattDAO.finnAnsattMedId(2);
        p3 = prosjektDAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
*/      
        //ansattDAO.slettProsjektdeltagelse(a2.getId(), p3.getId());
        //  ansattDAO.registrerProsjektdeltagelse(a2.getId(), p3.getId());
      // ansattDAO.registrerProsjektdeltagelse(a4.getId(), p3.getId());
     

        //set search_path = oblig3, "h599029", public;
        
        /*DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

CREATE TABLE Ansatt
(
  	Id         SERIAL,
  	Fornavn    VARCHAR(30),
  	Etternavn  VARCHAR(30),
	Brukernavn VARCHAR(4),
	Dato date,
	Stilling VARCHAR(30),
	Lonn int,
	Avdeling VARCHAR(30),
	
  CONSTRAINT Ansatt_PK PRIMARY KEY (Id)
);

INSERT INTO
  Ansatt(Fornavn, Etternavn, Brukernavn, Dato, Stilling, Lonn, Avdeling)
VALUES
  ('Arne', 'Arnesen', 'ArAr', '1000-01-01', 'Senior Arner', 10000, 'Avdeling1'),
  ('Brne', 'Brnesen', 'BrBr', '2000-02-02', 'Senior Brner', 20000, 'Avdeling2'),
  ('Crne', 'Crnesen', 'CrCr', '3000-03-03', 'Senior Crner', 30000, 'Avdeling3');

*/
    }

}

