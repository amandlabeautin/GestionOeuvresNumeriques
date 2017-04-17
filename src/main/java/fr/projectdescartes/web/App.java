package fr.projectdescartes.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.projectdescartes.web.Film;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
    		
			tx.begin();
			
			Film f = new Film();
			f.setTitre("Le monde de Dory");
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2015");
			f.setDateDeParution(beginDate);
			
			String resume = "Dory, le poisson chirurgien bleu amnésique, retrouve ses amis Nemo et Marlin. Tous trois se lancent à la recherche du passé de Dory. Pourra-t-elle retrouver ses souvenirs ? Qui sont ses parents ? Et où a-t-elle bien pu apprendre à parler la langue des baleines ?";
			f.setResume(resume);

			
			entityManager.persist(f);
				
			tx.commit();			
		
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}