package it.main.utils;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import it.main.controller.EMF;
import it.main.model.Auto;
import it.main.model.Compratore;
import it.main.model.Vendite;

public class UtilsDAO {
    
    public static void newAuto(Auto auto) throws SQLException
	{
    	EntityManager em = EMF.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(auto);
		tx.commit();
	}
    
    public static List<Auto> getAuto() throws SQLException {
    	EntityManager em = EMF.createEntityManager();
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<Auto> cq = cb.createQuery(Auto.class);
    	Root<Auto> auto = cq.from(Auto.class);
    	cq.select(auto);
    	TypedQuery<Auto> q = em.createQuery(cq);
    	List<Auto> allAuto = q.getResultList();
    	/*interfaccia lista condizioni*/
    	return allAuto;
    }
    
    public static List<Auto> getAutoByMarca(String marca) throws SQLException {
    	EntityManager em = EMF.createEntityManager();
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<Auto> cq = cb.createQuery(Auto.class);
    	Root<Auto> auto = cq.from(Auto.class);
    	cq.select(auto);
    	cq.where(cb.equal(auto.get("marca"), marca));    	
    	TypedQuery<Auto> q = em.createQuery(cq);
    	List<Auto> allAuto = q.getResultList();
    	return allAuto;
    }
    
    public static Auto findAuto(String targa) {
    	EntityManager em = EMF.createEntityManager();
    	Auto auto = em.find(Auto.class, targa);
    	return auto;
    }
    
    
    
    public static List<Vendite> getVendite() throws SQLException {   	
    	EntityManager em = EMF.createEntityManager();
    	TypedQuery<Vendite> q = em.createQuery("SELECT v FROM Vendite v", Vendite.class);
    	List<Vendite> allVendite = q.getResultList();
    	return allVendite;
    }
    
    public static void removeVend(String stringID) throws SQLException {
    	EntityManager em = EMF.createEntityManager();
    	em.getTransaction().begin();
    	Query query = em.createQuery("DELETE Vendite v WHERE id = :id");
    	int id = Integer.parseInt(stringID);
    	query.setParameter("id", id);
    	query.executeUpdate();
    	em.getTransaction().commit();
    }
    
    
    
    public static List<Compratore> getCompratore() throws SQLException {
    	EntityManager em = EMF.createEntityManager();
    	TypedQuery<Compratore> q  = em.createQuery("SELECT c FROM Compratore c", Compratore.class);
    	List<Compratore> allCompratore = q.getResultList();
    	return allCompratore;
    }
    
    public static void removeCompr(String stringID) throws SQLException {
    	EntityManager em = EMF.createEntityManager();
    	int id = Integer.parseInt(stringID);
    	/*Compratore compr = em.find(Compratore.class, 1);
    	em.remove(compr);*/
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	Query query = em.createQuery("DELETE Compratore c WHERE id = :id");
    	query.setParameter("id", id);
    	query.executeUpdate();
    	tx.commit();
    }
    
    public static void remCompr(String stringID) throws SQLException {
    	EntityManager em = EMF.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	int id = Integer.parseInt(stringID);
    	Compratore compr = em.find(Compratore.class, 1);
    	em.remove(compr);
    	tx.commit();
    }
    
    public static Vendite findVend() {
    	EntityManager em = EMF.createEntityManager();
    	Vendite vend = em.find(Vendite.class, 2);
    	return vend;
    }
    
    public static void remAuto(String targa) throws NotSupportedException, SystemException, Exception, Exception, RollbackException, HeuristicMixedException, HeuristicRollbackException {
    	EntityManager em = EMF.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	Auto auto = em.find(Auto.class, targa);
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("WEI");
			e.printStackTrace();
		}
    	auto.setMarca("FIAT");
    	tx.commit();
    }
    
    public static void newVendita(Vendite vendita) throws SQLException
	{
    	EntityManager em = EMF.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(vendita);
		tx.commit();
	}
}
