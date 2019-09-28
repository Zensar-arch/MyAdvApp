package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class InheritenceMain {

public static void main(String[] args) {
// TODO Auto-generated method stub
Configuration c = new Configuration().configure();
SessionFactory s = c.buildSessionFactory();
Session session = s.openSession();
Transaction t = session.beginTransaction();

Employee e = new Employee();
e.setName("Aditee");
e.setJoinDate(LocalDate.of(2019, 8, 26));
e.setSalary(23000);

session.save(e);
WageEmp we = new WageEmp();
we.setName("Susmita");
we.setJoinDate(LocalDate.of(2019, 8, 27));
we.setSalary(25000);
we.setHours(10);
we.setRate(250);
session.save(we);

t.commit();
session.close();
}

}
