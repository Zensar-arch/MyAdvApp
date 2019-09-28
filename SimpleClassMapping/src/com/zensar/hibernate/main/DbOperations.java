package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration().configure();//configure read hibernate.cfg.xml
		//singleton and heavy weight session factory
		SessionFactory f= c.buildSessionFactory();
		Session s = f.openSession();//represents database connection
		Transaction t = s.beginTransaction();
		//insert new record
		//Product p = new Product(1007,"sandwich maker","Bajaj",2700);
		//s.save(p);
		//get record according  to primary key
		
		//Product p=s.load(Product.class, 1005);
		//System.out.println(p);
		//Product p=s.get(Product.class, 1009);
		//if(p==null) {
		//	System.out.println("Product Not Found");}
		//else
		///{
		//	System.out.println(p);
		//}
		
		//update record
		Product p=s.get(Product.class, 1007);
		if(p==null) {
			System.out.println("Product Not Found");}
		else
		{	p.setPrice(p.getPrice()+100);
			s.update(p);
			System.out.println(p);
			
		}
		//delete record
		Product p1=s.get(Product.class, 1007);
		if(p==null) {
			System.out.println("Product Not Found");}
		else
		{
			s.delete(p);
			System.out.println(p);
		}
		
		t.commit();
		s.close();
		
	
	}

}
