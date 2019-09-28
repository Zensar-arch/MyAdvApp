package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.Main;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;
//TODO Auto-generated method stub
		/**
		 * @author Susmita Basak
		 * @creation_date 27th Sept 2019 5:09pm
		 * @modification_date 27th sept 2019 5:09pm
		 * @version 2.0
		 * @copyright Zensar Technologies.All rights reserved
		 * @description It is a main Class.
		 *
		 */

public class MovieDeleteDemo {

	
		
		public static void main(String[] args) {
			
				Configuration c=new Configuration().configure();
				SessionFactory f= c.buildSessionFactory();
				Session s = f.openSession();
				Transaction t = s.beginTransaction();
				
				Movie m = s.get(Movie.class, 1);
				System.out.println(m.getTitle());
				System.out.println(m.getReleaseDate());
				
				List<Song> songs = m.getSongs();
				
		
		  for(Song s1:songs) 
		   { 
			  System.out.println(s1);
		  
		   }
		  if(m!=null)
		  {
			  s.delete(m);
		  }
		  else
		  {
			  System.out.println("Sorry!you cannot delete");
		  }
		 
				
				
				t.commit();
				s.close();

			}

		

	}


