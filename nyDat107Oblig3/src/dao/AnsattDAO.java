package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
    		String queryString = "SELECT u.id FROM Ansatt as u where u.brukernavn = :value1";
    		

    	    int id = (int) em.createQuery(queryString).setParameter("value1", Brukernavn).getSingleResult(); 
    	    ansatt = em.find(Ansatt.class, id);
    		
    	} finally {
    		em.close();
    	}
    	return ansatt;
    }
    
    public void visAlleAnsatte() {

            String queryString = "SELECT a FROM Ansatt a " ;

            EntityManager em = emf.createEntityManager();

            List<Ansatt> ansatte=null;
            try {
                TypedQuery<Ansatt> query 
                        = em.createQuery(queryString, Ansatt.class);
                ansatte=query.getResultList();

            } catch (NoResultException e) {
                // e.printStackTrace();
            } finally {
                em.close();
            }
            System.out.println(ansatte.toString());

        
    	
    }
    public void leggTilAnsatt(Ansatt nyAnsatt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
        	tx.begin();
        	
        	em.persist(nyAnsatt);
        	tx.commit();
        }finally{
        	em.close();
        }
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
    
    public String endreStilling(int ansattId, String nyStilling) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Ansatt a = null;
        try {
            tx.begin();
            
            a = em.find(Ansatt.class, ansattId);
            

            
            a.setStilling(nyStilling);
           

            em.persist(a);
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        
        return a.toString();
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

