import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.text.DecimalFormat;

public class GPACalc {
	// global variables
	private double total;
	private DecimalFormat format = new DecimalFormat("#.00");
	private String[] letterGrade;
	private double[] gpas;
	private Scanner scan = new Scanner(System.in);
	
	// constructor
	public GPACalc(int numOfClasses) {
		letterGrade = new String[numOfClasses];
	}
	
	// fills the array with Strings representing the letter grade you got in each class
	public void fillCalc() {
		for (int i = 0; i < letterGrade.length; i++) {
			letterGrade[i] = scan.nextLine();
		}
	}
	
	
	// turns the Strings in each cell of letterGrade[] to its respective double in gpas[]
	public void translateCalc() {
		gpas = new double[letterGrade.length];
		for (int i = 0; i < letterGrade.length; i++) {
			if (letterGrade[i].equalsIgnoreCase("A"))
				gpas[i] = 4.00;
			else if (letterGrade[i].equalsIgnoreCase("A-"))
				gpas[i] = 3.66;
			else if (letterGrade[i].equalsIgnoreCase("B+"))
				gpas[i] = 3.33;
			else if (letterGrade[i].equalsIgnoreCase("B"))
				gpas[i] = 3.00;
			else if (letterGrade[i].equalsIgnoreCase("B-"))
				gpas[i] = 2.66;
			else if (letterGrade[i].equalsIgnoreCase("C+"))
				gpas[i] = 2.33;
			else if (letterGrade[i].equalsIgnoreCase("C"))
				gpas[i] = 2.00;
			else if (letterGrade[i].equalsIgnoreCase("C-"))
				gpas[i] = 1.66;
			else if (letterGrade[i].equalsIgnoreCase("D+"))
				gpas[i] = 1.33;
			else if (letterGrade[i].equalsIgnoreCase("D"))
				gpas[i] = 1.00;
			else if (letterGrade[i].equalsIgnoreCase("F"))
				gpas[i] = 0.00;
		}
	}
	
	// does a simple average of the cells in gpas[] and returns a String with the avg
	public String calcGPA() {
		for (int i = 0; i < letterGrade.length; i++) {
			total += gpas[i];
		}
		return "Your final GPA is " + format.format(total / gpas.length);
	}
	
}
