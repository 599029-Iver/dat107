package klient;

import dao.AnsattDAO;
import dao.ProsjektDAO;
import entiteter.Ansatt;
import entiteter.Prosjekt;

public class Main {

    public static void main(String[] args) {
        
        AnsattDAO ansattDAO = new AnsattDAO();
        ProsjektDAO prosjektDAO = new ProsjektDAO();
        
        Ansatt a2 = ansattDAO.finnAnsattMedId(2);
        a2.skrivUtMedProsjekter();
        
        a2.leggTilProsjekt(prosjektDAO.finnProsjektMedId(3));
        a2.skrivUtMedProsjekter();
        
        a2.skrivUt(null);
        /*
        Prosjekt p2 = prosjektDAO.finnProsjektMedId(2);
        p2.skrivUtMedAnsatte();
        
        Prosjekt p3 = prosjektDAO.finnProsjektMedId(3);
        p3.skrivUtMedAnsatte();
        /*
        
        ansattDAO.registrerProsjektdeltagelse(a2.getId(), p3.getId());
        a2 = ansattDAO.finnAnsattMedId(2);
        p3 = prosjektDAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
        
        ansattDAO.slettProsjektdeltagelse(a2.getId(), p3.getId());
        a2 = ansattDAO.finnAnsattMedId(2);
        p3 = prosjektDAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
        */
    }

}
