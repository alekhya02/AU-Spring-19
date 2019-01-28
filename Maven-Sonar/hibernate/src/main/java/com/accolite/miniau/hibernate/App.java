package com.accolite.miniau.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.accolite.miniau.hibernate.Address;
import com.accolite.miniau.hibernate.UserCollection;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static SessionFactory sessionFactory = null;
	    private static ServiceRegistry serviceRegistry = null;
	     
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	        	
	        	 serviceRegistry = new StandardServiceRegistryBuilder()
	                     .configure("hibernate.cfg.xml")
	                     .build();

	             sessionFactory = new Configuration().buildSessionFactory( serviceRegistry );
	         }
	         return sessionFactory;
	    }
    public static void main( String[] args )
    {
    	
    	SessionFactory sessionFactory = App.getSessionFactory();
		Session session = sessionFactory.openSession();
        
	//	11. CRUD Operations-Create Operation
	//  12. person is in transient state	
        Person person=new Person();
        person.setName("Alekhya");
        
        Address a1=new Address();
        Address a2=new Address();        
        a1.setStreet("Manikonda");
        a1.setCity("Hyderabad");
        a2.setStreet("Gachibowli");
        a2.setCity("Hyderabad");
        person.setPresentAddress(a1);
        person.setPermanentAddress(a2);
        
        Employee employee=new Employee();
        employee.setOffice("Accolite Hyd");
        
        Worker worker=new Worker();
        worker.setDailyWage("10000");
        
        Phone phone1=new Phone();
        phone1.setPhone("9876543210");
        Phone phone2=new Phone();
        phone2.setPhone("1234567890");
        
        ArrayList<Phone> arr=new ArrayList<Phone>();
        arr.add(phone1);
        arr.add(phone2);
        
        person.setPhone(arr);
        
        Set<Address> addr = new HashSet<Address>();
        addr.add(a1);
        addr.add(a2);
        
     // 6. Saving collections
        UserCollection usaddr = new UserCollection();
        usaddr.setAddresses(addr);
        
        session=sessionFactory.openSession();
        session.beginTransaction();
        
     // 11. CRUD Operations-Read Operation  
     // 13. HQL Query and query object
        Query query = session.createQuery("from Person");
     // 14. Pagination in HQL
        query.setMaxResults(1);
        List<Person> persons = query.getResultList();
	     for(Person p: persons) {
	    	 System.out.println(p.toString());
	     }
	     
	 // 14. Select query
	     String selectQuery = "SELECT P.name FROM Person P";
	     Query query1 = session.createQuery(selectQuery);
	     List<Person> results = query1.getResultList();
	     
	 //  15. Parameter Binding
	     String paramBinding = "from Person p where p.name = :pname";
	     List<Person> result = session.createQuery(paramBinding).setString("pname", "Ananya").list();
	     
	 //  15. Named Query
	     Query q = session.getNamedQuery("new");
	     List<Integer> namedResult = q.getResultList();
	     
	 //  16. Criteria API
	 //  17. Restrictions
	     Criteria criteria=session.createCriteria(Person.class);
	     criteria.add(Restrictions.or(Restrictions.like("name","%a")));
	     List<Person> restrictionList=criteria.list();
	     
	     criteria.setProjection(Projections.groupProperty("phone")).addOrder(Order.desc("phone"));

     
	 // 1. Saving objects using sessions 
	 //	12.person is in persistent state
        session.save(person);
        
     // 11. CRUD Operations-Update   
        person.setName("Ananya");
        session.save(usaddr);
        session.save(employee);
        session.save(worker);
        session.save(phone1);
        session.save(phone2);
     
     // 2. Retrieving objects using session
       person= (Person)session.get(Person.class, 1);
       System.out.println(person.toString());
        
        session.getTransaction().commit();
   	 //	12.person is in detached state
        session.close();
    }
}
