/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *
 *  Team Authors: Jack Bonnelycke
 *
 *  Problem: Create a calculator for your final grade, GPA, and total percent
 *  Description: The app I used to use for this got deleted off the iOS app
 *  			 store, so I decided to make my own.
 *
 *
 *************************************************************************/
import java.util.Scanner;

public class Driver {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String userInput;
		
		System.out.println("Please enter your desired operation:");
		System.out.println("(A) Final Grade Calculator");
		System.out.println("(B) Percentage Grade Calculator");
		System.out.println("(C) GPA Calculator");
		System.out.println("Press Q to Quit");
		
		userInput = scan.nextLine();
		
		while (!userInput.equalsIgnoreCase("Q")) { // loops until the user hits "q", and it terminates
			switch (userInput.toLowerCase()) {
			case "(a) final grade calculator":
			case "final grade calculator":
			case "(a)":
			case "a":
				double current;
				double desired;
				double examWeight;			

				System.out.println("What's your current grade percent?");
				current = scan.nextDouble() / 100;
				while ((current < 0) || (current > 1)) { // logic error handling
					System.out.println("Please enter a number between 0 and 100"); 
					current = scan.nextDouble() / 100;
				}
				System.out.println("What's your desired grade percent?");
				desired = scan.nextDouble() / 100;
				while ((desired < 0) || (desired > 1)) { // logic error handling
					System.out.println("Please enter a number between 0 and 100"); 
					desired = scan.nextDouble() / 100;
				}
				System.out.println("What's your exam's percent weight?");
				examWeight = scan.nextDouble() / 100;
				while ((examWeight < 0) || (examWeight > 1)) { // logic error handling
					System.out.println("Please enter a number between 0 and 100"); 
					examWeight = scan.nextDouble() / 100;
				}
				
				FinalGradeCalc finalCalc = new FinalGradeCalc(current, desired, examWeight);
				System.out.println(finalCalc.getFinalGrade());
				System.out.println();
				break;
			case "(b) percentage grade calculator":
			case "percentage grade calculator":
			case "(b)":
			case "b":
				System.out.println("How many grade criteria are there?");
				PercentGradeCalc percCalc = new PercentGradeCalc(scan.nextInt());
			
				percCalc.fillCalc();
				System.out.println(percCalc.getFinalGrade());
				break;
			case "(c) gpa calculator":
			case "gpa calculator":
			case "(c)":
			case "c":
				System.out.println("This program assumes the following is how your school's GPA is set up:\n");
				System.out.println("-------------------------------------------------------------------");
				System.out.println("|  A  |  A- |  B+ |  B  |  B- |  C+ |  C  |  C- |  D+ |  D  |  F  |");
				System.out.println("| 4.00| 3.66| 3.33| 3.00| 2.66| 2.33| 2.00| 1.66| 1.33| 1.00| 0.00|");
				System.out.println("-------------------------------------------------------------------\n");
				System.out.println("How many classes have you taken?");
				GPACalc gpas = new GPACalc(scan.nextInt());
				
				System.out.println("Enter your letter grade in each class, pressing enter after each entry.");
				gpas.fillCalc();
				gpas.translateCalc();
				System.out.println(gpas.calcGPA());
				break;
			default :
				System.out.println("Please enter your desired operation:");
				System.out.println("(A) Final Grade Calculator");
				System.out.println("(B) Percentage Grade Calculator");
				System.out.println("(C) GPA Calculator");
				System.out.println("Press Q to Quit");
				userInput = null; // empty out scan
			}
			userInput = scan.nextLine();
		}
	}	
}
