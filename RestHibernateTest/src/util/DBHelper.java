package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import model.Message;
import model.Person;


public class DBHelper {
	
	 private static SessionFactory factory; 
	 
	 public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		DBHelper.factory = factory;
	}

	public Integer addPerson(String fname, String lname){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer personID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Person person = new Person(fname, lname);
	         
	         personID = (Integer) session.save(person); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return personID;
	   }
	 
	 public Integer addMessage(Person person,String data,LocalDate date,LocalDateTime time){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer messageID = null;
	      
	      try {
	    	 System.out.println(person.getId());
	    	 int Id=checkPerson(person.getId());
	         if(Id==-1)
	         {
	        	 addPerson(person.getFirstName(),person.getLastName());
	         }
	         tx = session.beginTransaction();
	         Message msg=new Message(person,data,date,time);
	         messageID = (Integer) session.save(msg); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return messageID;
	   } 	
	   public int checkPerson(int Id){
	      Session session = factory.openSession();
	      
	      try {
	         
	         String hqlSelectRow ="from Person where Id =:Id";
	         Query query1 = session.createQuery(hqlSelectRow);
	         Person person = (Person) query1.setParameter("Id",Id).uniqueResult();
	         
	         if(person!=null)
	         {
	        	 System.out.println("  Id: " +person.getFirstName()); 
	        	 return person.getId();
	         }
	         	         
	      } catch (HibernateException e) {
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return -1;
	   }
	   public Person getPerson(int Id){
		      Session session = factory.openSession();
		      
		      try {
		         
		         String hqlSelectRow ="from Person where Id =:Id";
		         Query query1 = session.createQuery(hqlSelectRow);
		         Person person = (Person) query1.setParameter("Id",Id).uniqueResult();
		         
		         if(person!=null)
		         {
		        	 System.out.println("  Id: " +person.getFirstName()); 
		        	 return person;
		         }
		         	         
		      } catch (HibernateException e) {
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return null;
		   }
	   public int checkMessage(int Id){
		      Session session = factory.openSession();
		      
		      try {
		         
		         String hqlSelectRow ="from Message where messageId =:Id";
		         Query query1 = session.createQuery(hqlSelectRow);
		         Message msg= (Message) query1.setParameter("Id",Id).uniqueResult();
		         
		         if(msg!=null)
		         {
		        	 System.out.println("  Id: " +msg.getId()); 
		        	 return msg.getId();
		         }
		         	         
		      } catch (HibernateException e) {
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return -1;
		   }
		   public Message getMessage(int Id){
			      Session session = factory.openSession();
			      
			      try {
			         
			         String hqlSelectRow ="from Message where messageId =:Id";
			         Query query1 = session.createQuery(hqlSelectRow);
			         Message msg = (Message) query1.setParameter("Id",Id).uniqueResult();
			         
			         if(msg!=null)
			         {
			        	 System.out.println("  Id: " +msg.getId()); 
			        	 return msg;
			         }
			         	         
			      } catch (HibernateException e) {
			         e.printStackTrace(); 
			      } finally {
			         session.close(); 
			      }
			      return null;
			   }
		   
	   public List listPerson( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List person = session.createQuery("FROM Person").list(); 
	         /*for (Iterator iterator = person.iterator(); iterator.hasNext();){
	            Person prsn = (Person) iterator.next(); 
	            System.out.print("First Name: " + prsn.getFirstName()); 
	            System.out.print("  Last Name: " + prsn.getLastName());  
	         }*/
	         
	         tx.commit();
	         return person;
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return null;
	   }
	   public List listMessage( ){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         List message = session.createQuery("FROM Message").list(); 
		         /*for (Iterator iterator = person.iterator(); iterator.hasNext();){
		            Person prsn = (Person) iterator.next(); 
		            System.out.print("First Name: " + prsn.getFirstName()); 
		            System.out.print("  Last Name: " + prsn.getLastName());  
		         }*/
		         
		         tx.commit();
		         return message;
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return null;
		   }
	   public void updatePersonFirstName(Integer PersonId,String firstName){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Person person = (Person)session.get(Person.class,PersonId); 
	         person.setFirstName(firstName);;
			 session.update(person); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   public void updatePersonLastName(Integer PersonId,String lastName){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         Person person = (Person)session.get(Person.class,PersonId); 
		         person.setFirstName(lastName);;
				 session.update(person); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }
	   public void updateMessage(Integer MessageId,Message message){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         Message msg= (Message)session.get(Message.class,MessageId); 
		         msg.setData(message.getData());
		         msg.setDate(message.getDate());
		         msg.setSender(message.getSender());
		         msg.setTime(message.getTime());
		         
				 session.update(msg); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }
	   public void deletePerson(Integer PersonId){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Person person= (Person)session.get(Person.class,PersonId); 
	         session.delete(person); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

	   public void deleteMessage(Integer PersonId){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         Message message= (Message)session.get(Message.class,PersonId); 
		         session.delete(message); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }
	   public int getPersonLastId(){
		      Session session = factory.openSession();
		      Integer id;
		      try {
		         
		    	  String query="select max(id) from Person";
		    	  Query query1 = session.createQuery(query);
			      id= (Integer) query1.uniqueResult();
		         if(id!=null) 
		         {
		        	 System.out.println("  Id: "+id); 
		        	 return id;
		         }
		         
		         	         
		      } catch (HibernateException e) {
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return 0;
		   }
	   public int getMessageLastId(){
		      Session session = factory.openSession();
		      Integer id;
		      try {
		         
		    	  String query="select max(id) from Message";
		    	  Query query1 = session.createQuery(query);
			      id= (Integer) query1.uniqueResult();
		         if(id!=null) 
		         {
		        	 System.out.println("  Id: "+id); 
		        	 return id;
		         }
		         
		         	         
		      } catch (HibernateException e) {
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return 0;
		   }
}
