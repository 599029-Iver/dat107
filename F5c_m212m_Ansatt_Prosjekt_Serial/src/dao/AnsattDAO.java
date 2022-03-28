package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entitet.Ansatt;
import entitet.Prosjekt;
import entitet.Prosjektdeltagelse;

public class AnsattDAO {

    private EntityManagerFactory emf;

    public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("Oblig3Persistence");
    }
    
    public Ansatt finnAnsattMedId(int id) {

        EntityManager em = emf.createEntityManager();

        Ansatt ansatt = null;
        try {
            ansatt = em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
        return ansatt;
    }
    
    public  Ansatt finnAnsattMedBrukernavn(String Brukernavn) {
    	
    	EntityManager em = emf.createEntityManager();
    	
    	Ansatt ansatt = null;
    	
    	try {
    		String queryString = "SELECT Ansatt FROM Ansatt " 
                    + "WHERE Ansatt.Brukernavn = '" + Brukernavn + "'";
    		
            Query query 
            = em.createQuery(queryString);
            
            ansatt = finnAnsattMedId(query.getParameter(Brukernavn).getPosition());
    		
    	} finally {
    		em.close();
    	}
    	return ansatt;
    }

    public void registrerProsjektdeltagelse(int ansattId, int prosjektId) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            
            Ansatt a = em.find(Ansatt.class, ansattId);
            Prosjekt p = em.find(Prosjekt.class, prosjektId);
           
            Prosjektdeltagelse pd = new Prosjektdeltagelse(a, p, 0);

            em.persist(pd);
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        
    }

    public void slettProsjektdeltagelse(int ansattId, int prosjektId) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Prosjektdeltagelse pd = finnProsjektdeltagelse(ansattId, prosjektId);
            
            
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    private Prosjektdeltagelse finnProsjektdeltagelse(int ansattId, int prosjektId) {
        
        String queryString = "SELECT pd FROM Prosjektdeltagelse pd " 
                + "WHERE pd.ansatt.id = :ansattId AND pd.prosjekt.id = :prosjektId";

        EntityManager em = emf.createEntityManager();

        Prosjektdeltagelse pd = null;
        try {
            TypedQuery<Prosjektdeltagelse> query 
                    = em.createQuery(queryString, Prosjektdeltagelse.class);
            query.setParameter("ansattId", ansattId);
            query.setParameter("prosjektId", prosjektId);
            pd = query.getSingleResult();
            
        } catch (NoResultException e) {
            // e.printStackTrace();
        } finally {
            em.close();
        }
        return pd;
    }
    
}
