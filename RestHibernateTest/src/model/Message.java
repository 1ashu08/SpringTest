package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Message {

	   private int id;
	   private Person sender;
	   private String data;
	   private LocalDate date;
	   private LocalDateTime time; 
	   public static int tempId=0; 
	   private int personId;
	   
	   public Message(Person sender,String data,LocalDate date,LocalDateTime time)
	   {
		   this.id=++tempId;
		   this.sender=sender;
		   this.data=data;
		   this.date=date;
		   this.time=time;
		   personId=sender.getId();
	   }
	   
	   public Message()
	   {
		   id=0;
		   sender=new Person();
		   data="NA";
		   date=LocalDate.now();
		   time=LocalDateTime.now();
		   
	   }

	   
	public int getPersonId() {
		return sender.getId();
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = ++tempId;
	}
	public void setId(int id) {
		this.id =id;
	}
	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	   
	   
}
