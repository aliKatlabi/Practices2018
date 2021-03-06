
import java.io.*;
import java.util.*;
import java.text.*;

import models.Person;
import models.ClassRoom;


public class myMain{
	
	public static void main (String args []){
		boolean exit=false;
		ClassRoom room=new ClassRoom();
		
		Scanner sc = new Scanner(System.in);
		
		while(!exit)
		{
				System.out.printf("%nChoose from..%n%n1.add Student%n2.remove last student%n3.Show students%n4.exit%n");
			
				int n = sc.nextInt();
				switch(n)
				{
					case 1:
						System.out.print("Name : ");
						String N= sc.next();
						System.out.print("Family Name : ");
						String FN=sc.next();
						System.out.print("BirthDay yyyy/mm/dd: ");
						String Bd=sc.next();
						try{
						room.addStudent(new Person(N,FN,Bd));
						}catch(Exception ParseException){System.out.println("unparsable!");}
						break;
						
					case 2:
						System.out.println("SURE?Y/N");
						if(sc.next().charAt(0)=='y'){
						room.removeLastStudent();
						break;}
						else{
						break;}
					case 3:
						for(Person p: room.getStudents()){
							System.out.println(p.toString());
						}
						break;
					case 4:
						exit=true;
						break;
						
					default:
						break;
						
						
						
				}
				
			
		}
	}
}

package models;

//Import the Date package

import java.util.*;
import java.text.*;



public class Person{	
	
	//Attributes
	private String name;
	private String familyName;
	private Date birthDay;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
	
	
	//Constructors
	//Empty Constructor
	public Person(){}
	
	//Constructor with arguments	
	public Person(String name, String familyName){		
		this.name = name;
		this.familyName = familyName;
	}
	public Person(String name, String familyName, String birthday) throws ParseException{		
		this.name = name;
		this.familyName = familyName;
		this.birthDay = df.parse(birthday);
	}

	
	//Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;			
	}
	
	public String getFamilyName(){
		return familyName;
	}
	
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	
	public Date getBirthday(){
		return birthDay;
	}
	
	public void setBirthday(String Date) throws ParseException{
		this.birthDay = df.parse(Date);
	}
	
	//custom methods
	
	public String fullHungarianName(){
		return familyName+" "+name;
	}
	
	@Override
	public String toString(){
		return fullHungarianName()+"::"+df.format(birthDay);
		
		
	}
	
	
	
}

package models;

import java.util.ArrayList;
//import models.Person;


public class ClassRoom{
	
	private ArrayList<Person> students;

	public ClassRoom(){
		this.students = new ArrayList<Person>();
		}
		
	public ClassRoom(ArrayList<Person> arr){
		this.students=arr;
		}
	public void addStudent(Person p){
		this.students.add(p);
		}
	public void removeLastStudent(){
		int size = students.size();
		this.students.remove(size-1);
		}
	public ArrayList<Person> getStudents(){
		return this.students;
		}
		

}