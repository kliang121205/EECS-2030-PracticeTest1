package model;

public class Registration {
	private String clazz;
	private int credits;
	private int marks;
	
	
	public Registration(String clazz, int credits, int marks) {
		this.clazz = clazz;
		this.credits = credits;
		this.marks = marks;
	}
	
	public Registration(String clazz, int credits) {
		this.clazz = clazz;
		this.credits = credits;
	}
	
	public String getCourseName() {
		System.out.println(clazz);
		return clazz;
	}
	
	public int getMarks() {
		
		return marks;
	}
	
	public int getNumberOfCredits() {
		return this.credits;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	public String getLetterGrade() {
		String grade = "";
		 /* Marks >= 90			: "A+"
			 * 80 <= Marks <  90	: "A"
			 * 70 <= Marks <  80	: "B"
			 * 60 <= Marks <  70	: "C"
			 * 50 <= Marks <  60	: "D"
			 * Marks < 50			: "F"
			 */
		if(this.marks >= 90) {
			grade = "A+";
		}
		else if(this.marks < 90 && this.marks >= 80) {
			grade = "A";
		}
		else if(this.marks < 80 && this.marks >= 70) {
			grade = "B";
		}
		else if(this.marks < 70 && this.marks >= 60) {
			grade = "C";
		}
		else if(this.marks < 60 && this.marks >= 50) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
		
	}
	
	public int getWeightedGradePoint() {
			int point = 0;
			if(this.marks >= 90) {
				point = 9;
			}
			else if(this.marks < 90 && this.marks >= 80) {
				point = 8;
			}
			else if(this.marks < 80 && this.marks >= 70) {
				point = 7;
			}
			else if(this.marks < 70 && this.marks >= 60) {
				point = 6;
			}
			else if(this.marks < 60 && this.marks >= 50) {
				point = 5;
			} else {
				point = 0;
			}
			return point;
		
		
	}
}
