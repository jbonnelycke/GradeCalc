import java.util.Scanner;

public class PercentGradeCalc {
	// global variable
	private int total = 0;
	private double[][] criteria;
	private Scanner scan = new Scanner(System.in);
	
	// constructor
	public PercentGradeCalc(int numberOfClasses) {
		criteria = new double[numberOfClasses][2];
	}
	
	// fills the matrix with what percent of the total grade each criteria is in the first row
	// and what percent grade you have in each respective criteria in the second row
	public void fillCalc() {
		System.out.println("Enter how much the percent of the total grade each\ncriteria is,"
			+ " pressing enter after each percentage.");
		for (int i = 0; i < criteria.length; i++) {
			criteria[i][0] = scan.nextDouble() / 100;
			while ((criteria[i][0] < 0) || (criteria[i][0] > 1)) {
				System.out.println("Please enter a number between 0 and 100");
				criteria[i][0] = scan.nextDouble() / 100;
			}
		}
		System.out.println("Enter your percent score in each respective criteria, pressing enter\n after each percentage.");
		for (int i = 0; i < criteria.length; i++) {
			criteria[i][1] = scan.nextDouble();
				while ((criteria[i][1] < 0) || (criteria[i][1] > 100)) {
					System.out.println("Please enter a number between 0 and 100");
					criteria[i][1] = scan.nextDouble();
				}
		}
	}
	
	// calculates the total final grade and returns a String with the total
	public String getFinalGrade() {
		for (int i = 0; i < criteria.length; i++)
			total += criteria[i][0] * criteria[i][1];
		if (total > 90) {
			return "\nYour final grade in this class is: " + this.total + "%.\nCongratulations!"
					+ "Get a cookie. You earned it.";
		}
		else {
			return "\nYour final grade in this class is: " + this.total + "%.";
		}
			
	}
	
}
