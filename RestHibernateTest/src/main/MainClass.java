package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Message;
import model.Person;
import util.DBHelper;

public class MainClass {

	public static void main(String[] args) {
		
		SessionFactory factory;
		factory=new Configuration().configure("/config/hibernate.cfg.xml")
				.addAnnotatedClass(Person.class)
				.addResource("/config/Person.hbm.xml")
				.addAnnotatedClass(Message.class)
				.addResource("/config/Message.hbm.xml")
				.buildSessionFactory();

		DBHelper obj=new DBHelper();
		obj.setFactory(factory);
		
		//Person.tempId=obj.getPersonLastId();
		Message.tempId=obj.getMessageLastId();
		Person prsn=new Person();
		prsn.setId(1);
		obj.addMessage(prsn,"Testing Message1",LocalDate.now(),LocalDateTime.now());
		//obj.addPerson("Nidhi","Singh");
		System.out.println("Addition Complete");
	}

}
