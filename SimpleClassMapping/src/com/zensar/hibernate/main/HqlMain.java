package com.zensar.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

//hibernate query language(object-oriented-query-language)
public class HqlMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration().configure();//configure read hibernate.cfg.xml
		//singleton and heavy weight session factory
		SessionFactory f= c.buildSessionFactory();
		Session s = f.openSession();//represents database connection
		Transaction t = s.beginTransaction();
		//Query q=s.createQuery("From Product");//Jpa query
		//Query q=s.createQuery("From Product p where p.price>5000 and p.price<25000");//Jpa query
		//Query q=s.createQuery("From Product p where p.price between 5000 and 25000");
		//Query q=s.createQuery("From Product p where p.brand like 'S%'");
		//Query q=s.createQuery("From Product p where p.name = 'Toaster'");
		//Query q=s.createQuery("Select p.name,p.price from Product p");
		//Query q=s.createQuery("Select p.productId,p.name,p.brand from Product p");
		//Query q=s.createQuery("Select p.price,p.brand,p.name from Product p");
		
		//List<Object[]> objects = q.getResultList();
		
		//for(Object[] o: objects)
		//{
			//for(int i=0;i<o.length;i++) {
				
			//System.out.println(o[i]);
			//}
			//System.out.println();
		//}
		
		Query q = s.createQuery("select max(p.price) from Product p");
		Float maxprice = (Float) q.getSingleResult();
		System.out.println(maxprice);
		
		Query q1 = s.createQuery("select min(p.price) from Product p");
		Float minprice = (Float) q1.getSingleResult();
		System.out.println(minprice);
		
		Query q2 = s.createQuery("select sum(p.price) from Product p");
		Double sumprice = (Double) q2.getSingleResult();
		System.out.println(sumprice);
		
		Query q3 = s.createQuery("select avg(p.price) from Product p");
		Double avgprice = (Double) q3.getSingleResult();
		System.out.println(avgprice);
		
		Query q4 = s.createQuery("select count(p.price) from Product p");
		Long countprice = (Long) q4.getSingleResult();
		System.out.println(countprice);
		
		/*
		 * Criteria c1 =s.createCriteria(Product.class); List<Product> products =
		 * c1.list(); for(Product p:products) { System.out.println(p); }
		 */
		t.commit();
		s.close();

	}

}
