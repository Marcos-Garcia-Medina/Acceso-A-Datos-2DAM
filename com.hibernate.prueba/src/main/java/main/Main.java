package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animal;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Animal a1 = new Animal("Yorshire", new BigDecimal(1),"Casa");
		
		//session.save(a1);
		
		//int id = 10;
		
		//Animal a = (Animal) session.get(Animal.class,id);
		
		//System.out.println(a.getNombre());
		
		/*List animales = session.createQuery("FROM Animal").getResultList();
		for(Iterator i = animales.iterator();i.hasNext();) {
			Animal a = (Animal) i.next();
			System.out.println(a.getNombre());
		}
		session.close();}*/
		
		String hql = "FROM Animal WHERE habitat = :habitat";
		Query query = session.createQuery(hql);
		query.setParameter("habitat", "Casa");
		List animales = query.getResultList();
		
		for(Iterator i = animales.iterator();i.hasNext();) {
			Animal a = (Animal) i.next();
			System.out.println(a.getNombre());
		}

	}

}
