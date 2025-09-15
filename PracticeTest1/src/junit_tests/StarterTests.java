package junit_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Registration;
import model.Transcript;

/*
 * A registration system stores a list of up to 500 transcripts. 
 * Each transcript is characterized by a student’s unique name (e.g., "Sunhye") 
 * 	and a list of up to 60 current registrations.
 *   
 * Each registration is characterized by the course name (e.g., "CSE1"), 
 * 	its number of credits (e.g., 3), and the raw marks (out of 100) for that student (e.g., 78). 
 * 
 * For more details, see the in-line comments and test methods given to you below.
 */

public class StarterTests {

	@Test
	public void test_01() {
		/* Create a new registration for CSE114 with 4 credits and raw marks 59 (out of 100).
		 * Requirement: Credits and marks are both integers, NOT double. 
		 */
		Registration r1 = new Registration("CSE114", 4, 59);

		assertEquals("CSE114", r1.getCourseName());
		assertEquals(4, r1.getNumberOfCredits(), 0.01);
		assertEquals(59, r1.getMarks()); 
	}

	@Test
	public void test_02() {
		/* Create a new registration for CSE214 with 3 credits. */
        Registration r2 = new Registration("CSE214", 3);

        assertEquals("CSE214", r2.getCourseName());
		assertEquals(3, r2.getNumberOfCredits(), 0.01);
		assertEquals(0, r2.getMarks());
    }

    @Test
    public void test_03() {
    	Registration r2 = new Registration("CSE214", 3);
    	/* Change marks of the registration. */
    	r2.setMarks(34);
    	
        assertEquals("CSE214", r2.getCourseName());
		assertEquals(3, r2.getNumberOfCredits(), 0.01);
		assertEquals(34, r2.getMarks()); 
    }
    
    @Test
    public void test_04() {
    	Registration r = new Registration("CSE214", 3, 49); 
    	
    	/* Here is the map from numerical raw marks to string letter grades:
		 * Marks >= 90			: "A+"
		 * 80 <= Marks <  90	: "A"
		 * 70 <= Marks <  80	: "B"
		 * 60 <= Marks <  70	: "C"
		 * 50 <= Marks <  60	: "D"
		 * Marks < 50			: "F"
		 */
		assertEquals("F", r.getLetterGrade());
		/* Your implemented `getLetterGrade` should also work for other input values. */
    }
    
    @Test
    public void test_14() {
    	Registration r = new Registration("CSE214", 5, 49); 
    	
    	/*
		 * Weighted Grade Point: grade point * number of credits.
		 * Here is the map from string letter grades to numerical grade points:
		 * "A+"	: 9
		 * "A"	: 8
		 * "B"	: 7
		 * "C" 	: 6
		 * "D"	: 5
		 * "F"	: 0
		 * For example, for r1 with letter grade B (and hence grade point 7) and 3 credits, 
		 * its weighted grade point is 7 * 3. 
		 */
		assertEquals(0 * 5, r.getWeightedGradePoint()); 
		/* Your implemented `getWeightedGradePoint` should also work for other input values. */
    } 

    @Test
    public void test_20() {
		Transcript alan = new Transcript("Alan"); 
		/* Return, as an array, all the stored registrations in the transcript. 
		 * Initially, no registrations have been added to the transcript yet.
		 */
		Registration[] alanRegistrations = alan.getReport();

		assertEquals(0, alanRegistrations.length); 
	}
    
	@Test
	public void test_21() {
		Registration r1 = new Registration("CSE303", 6, 79);
		Transcript alan = new Transcript("Alan"); 
		/* Add a registration object to the transcript. */
		alan.addRegistration(r1);
		//alanRegistrations
		Registration[] alanRegistrations = alan.getReport();
		Registration alanRegistration1 = alanRegistrations[0];
	
		assertEquals(1, alanRegistrations.length);
		assertEquals("CSE303", alanRegistration1.getCourseName());
		assertEquals(6, alanRegistration1.getNumberOfCredits(), 0.01);
		assertEquals(79, alanRegistration1.getMarks());
	}

	@Test
	public void test_22() {
		Registration r1 = new Registration("CSE303", 6, 79);
		Transcript alan = new Transcript("Alan"); 
		alan.addRegistration(r1);
		/* Given information of a registration (course name and number of credits), add it
		 * to the transcript. */
		alan.addRegistration("CSE215", 6);

		Registration[] alanRegistrations = alan.getReport();

		assertEquals(2, alanRegistrations.length);
		Registration alanRegistration1 = alanRegistrations[0];

		assertEquals("CSE303", alanRegistration1.getCourseName());
		assertEquals(6, alanRegistration1.getNumberOfCredits(), 0.01);
		assertEquals(79, alanRegistration1.getMarks());

		Registration alanRegistration2 = alanRegistrations[1];
		assertEquals("CSE215", alanRegistration2.getCourseName());
		assertEquals(6, alanRegistration2.getNumberOfCredits(), 0.01);
		assertEquals(0, alanRegistration2.getMarks());
	}

	@Test
	public void test_28() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 2));
		alan.addRegistration(new Registration("EECS2", 2));
		alan.addRegistration(new Registration("EECS3", 2));
		Registration[] registrations = {new Registration("EECS4", 2)};
		alan.addRegistrations(registrations);
		assertEquals(4, alan.getReport().length);
	}

	@Test
	public void test_29() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 2));
		alan.addRegistration(new Registration("EECS2", 2));
		alan.addRegistration(new Registration("EECS3", 2));
		Registration[] registrations = {new Registration("EECS4", 2), new Registration("EECS5", 2)};
		alan.addRegistrations(registrations);
		assertEquals(5, alan.getReport().length);
	}
	
	@Test
	public void test_31() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		/* Given the name of some existing course, return its current marks on the transcript.
		 */
		assertEquals(50, alan.getMarks("EECS1"));
	}
	
	@Test
	public void test_35() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		/* When attempting to get marks for some non-existing course, simply return -1.
		 */
		assertEquals(-1, alan.getMarks("EECS5"));
	}
	
	@Test
	public void test_36() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		/* Given the name of some existing course, set new marks for it on the transcript.
		 */
		alan.setMarks("EECS1", 55);
		assertEquals(55, alan.getMarks("EECS1"));
	}
	
	@Test
	public void test_40() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		/* When attempting to set marks for some non-existing course, simply do nothing.
		 */
		alan.setMarks("EECS5", 100);
		assertEquals(50, alan.getMarks("EECS1"));
		assertEquals(60, alan.getMarks("EECS2"));
		assertEquals(70, alan.getMarks("EECS3"));
		assertEquals(80, alan.getMarks("EECS4"));
		/* Given the name of some non-existing course, return -1 as it marks.
		 */
		assertEquals(-1, alan.getMarks("EECS5"));
	}
	
	@Test
	public void test_41() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		
		/* Weighted GPA denotes the Weighted Grade Point Average, which is calculated by
		 * first calculating the sum of the WEIGHTED grade points of all registrations on the transcript,
		 * then by dividing the sum by the number of registrations. 
		 * For example, t1 has two registrations: 
		 * 	CSE1 (with weighted grade point 7 * 3) and CSE3 (with weighed grade point 5 * 4),
		 *  then t1's weighed GPA is calculated by (21 + 20) / 2. 
		 * Requirement: When the number of registrations on the transcript is zero, then
		 * return 0 as the weighted GPA.
		 * 
		 */
		
		System.out.println(alan.getMarks());
		assertEquals((5 * 1) / (double) 1, alan.getWeightedGPA(), 0.01);
	}
}
