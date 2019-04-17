package model;


public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	public static int tempId=0;
	
	
	public Person(String firstName, String lastName) {
		this.id = ++tempId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person()
	{
		id=0;
		firstName="NA";
		lastName="NA";
	}	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id =++tempId;
	}
	public void setId(int id) {
		this.id =id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
