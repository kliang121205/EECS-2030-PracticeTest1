package model;

public class Transcript {
	private String name;
	private String clazz;
	private Registration[] nameRegister = new Registration[60];
	private Registration obj;
	private int credits;
	private int nor;
	private int marks = 0;
	private int gpa;
	
	
	public Transcript(String name) {
		this.name = name;
		
	}
	
	
	
	public Registration[] getReport() {
		Registration[] u = new Registration[this.nor];
		for(int i = 0; i < nor; i++) {
			u[i] = nameRegister[i];
		}
		//this.nameRegister = u;
		System.out.println(u.length);
		return u;
		
	}
	
	public void addRegistration(Registration obj) {
		nameRegister[nor] = obj;
		this.nor++;
		
	}
	
	public void addRegistration(String clazz, int credits) {
		nameRegister[nor] = new Registration(clazz,credits);
		this.credits = credits;
		this.nor++;
		
	}
	
	public void addRegistrations(Registration[] nameRegister) {
		for(int i = 0; i < nameRegister.length; i++) {
			this.nameRegister[i] = nameRegister[i];
			this.nor++;
		}
		
	}
	
	/* public String getCourseName() {
		Registration[] u = new Registration[this.nor];
		Registration k = u[this.nor];
		this.clazz = k.getCourseName();
		return this.clazz;
	}
	*/
	
	/*
	
	public int getMarks() {
		Registration[] u = new Registration[this.nor];
		Registration k = u[0];
		this.marks = k.getMarks();
		return this.marks;
	}
	*/
	
	public int getMarks() {
		return marks;
	}
	
	public int getMarks(String f) {
		nameRegister[nor] = new Registration(this.clazz,credits,this.marks);
		for(int i = 0; i < nor; i++) {
			if(nameRegister[i].getCourseName().equals(f)) {
				return nameRegister[i].getMarks();
			}
		}
		
		return -1;
	}
	
	
	public void setMarks(String n, int k) {
		nameRegister[nor] = new Registration(this.clazz,credits,this.marks);
		for(int i = 0; i < nor; i++) {
			if(nameRegister[i].getCourseName() == n) {
				nameRegister[i].setMarks(k);
				
			}
			
		}
		
		this.clazz = n;
		this.marks = k;
		 
	}
	
	
	
	
		// TODO Auto-generated method stub

	
	/*public double getWeightedGradePoint() {
		double point = 0.0;
		if(this.marks >= 90) {
			point = 9.0;
		}
		if((this.marks < 90) && (this.marks >= 80)) {
			point = 8.0;
		}
		if((this.marks < 80) && (this.marks >= 70)) {
			point = 7.0;
		}
		if((this.marks < 70) && (this.marks >= 60)) {
			point = 6.0;
		}
		if((this.marks < 60) && (this.marks >= 50)) {
			point = 5.0;
		}else {
			point = 0.0;
		}
		
		System.out.println(point);
		return point;
		
	
}
*/
	
	public double getWeightedGPA() {
		double point = 0.0;
		double total = 0.0;
		double total2 = 0.0;
		for(int i = 0; i < nor; i++) {
		if(nameRegister[i].getMarks() >= 90) {
			point = 9.0;
		}
		else if((nameRegister[i].getMarks() < 90) && (nameRegister[i].getMarks()>= 80)) {
			point = 8.0;
		}
		else if((nameRegister[i].getMarks() < 80) && (nameRegister[i].getMarks() >= 70)) {
			point = 7.0;
		}
		else if((nameRegister[i].getMarks() < 70) && (nameRegister[i].getMarks() >= 60)) {
			point = 6.0;
		}
		else if((nameRegister[i].getMarks() < 60) && (nameRegister[i].getMarks() >= 50)) {
			point = 5.0;
		}else {
			point = 0.0;
		}
		total += point;
		total2 += nameRegister[i].getNumberOfCredits();
		}
		System.out.println(total);
		double n = (total * total2)/(this.nor);
		return n;
	}
	
	
	
	
	
}

