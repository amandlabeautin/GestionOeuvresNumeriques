package test.fr.projectdescartes;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.projectdescartes.Films;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
    		
			tx.begin();
			
			String titre = "Horror Story Picture Show";
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2015");
			String resume = "un film desannées 70s";
			String annonce = "ANNONCE";
			Long duree = (long) 230;
			
			Films f = new Films(titre, beginDate, resume, duree, annonce);
			
			entityManager.persist(f);
				
			tx.commit();			
		
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}