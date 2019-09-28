package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;


/**
 * @author Susmita Basak
 * @creation_date 27th Sept 2019 5:09pm
 * @modification_date 27th sept 2019 5:09pm
 * @version 2.0
 * @copyright Zensar Technologies.All rights reserved
 * @description It is a main Class.
 *
 */

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		
		Movie m1 = new Movie();
		Song s1 = new Song();
		Song s2 = new Song();
		Song s3 = new Song();
		
		m1.setReleaseDate(LocalDate.of(2010, 9, 9));
		m1.setTitle("KUCH KUCH HOTA HAIN");
		s1.setSongName("kuch kuch hota hain");
		s2.setSongName("mehendi laga k rakhna");
		s3.setSongName("KOI MIL GAYA");
		s1.setMovie(m1);
		s2.setMovie(m1);
		s3.setMovie(m1);
		
		List<Song> songs = new ArrayList();
		
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		
		
		s.save(m1);
		s.save(s1);
		s.save(s2);
		s.save(s3);
		
		
		t.commit();
		s.close();

	}

}
