package project1;
import java.lang.Math;
import java.util.*;


public class Calculator {

	/**
	 * FIELDS
	 * Author @ Mike Gotta
	 */
	private double answer;
	public static final double PI = 3.14159;
	private Scanner scannedInput = new Scanner(System.in);
	public static final String usageInstructions = "Valid operations are: \n"
			+ " + \t add \n - \t subtract \n * \t multiply \n / \t divide \n"
			+ " c \t clear  \n neg \t negate \n % \t percent \n"
			+ " ^ \t raise to power of next value entered \n inv \t invert the current value \n"
			+ " rand \t radomize current value by a fractional amount \n"
			+ " round \t round to number of places given next \n" + " = \t print answer \n ? \t Help \n q \t Quit \n";

	/**
	 * CONSTRUCTOR
	 */
	Calculator() {
		this.answer = 0;
	};

	/**
	 * METHODS
	 * prompt user for a double and check before returning
 	 */
	public double getUserNum() {
		boolean validNumber = false;
		double userVal = 0;

		System.out.print("Enter number\n>>> ");

		while (validNumber == false) {
			if (scannedInput.hasNext("pi")) {
				userVal = PI;
				scannedInput.next();
				validNumber = true;
			} else if (scannedInput.hasNextDouble()) {
				userVal = scannedInput.nextDouble();
				validNumber = true;
			} else {
				System.out.print("That's not a number. \nEnter a valid number\n>>> ");
				scannedInput.next();
			}
		}
		return userVal;
	}

	/**
	 * 	prompt user for operation and check before returning
 	 */
	public String getUserOp() {
		String op;

		System.out.print("Enter operation\n>>> ");
		op = scannedInput.next();
		while (!(this.checkUserOp(op))) {
			op = scannedInput.next();
		}
		return op;
	}

	/**
	 * 	private helper method for getUserInput()
	 */
	private boolean checkUserOp(String op) {
		if (op.equals("+") || op.equals("-") || op.equals("=") || op.equals("?") || op.equals("Q") || op.equals("q")
				|| op.equals("*") || op.equals("/") || op.equals("c") || op.equals("C") || op.equals("neg")
				|| op.equals("%") || op.equals("^") || op.equals("inv") || op.equals("rand") || op.equals("round")) {
			return true;
		} else {
			System.out.print("Invalid Entry. Enter '?' for help." + "\nEnter a valid operation \n>>> ");
			return false;
		}
	}

	public double calculateAnswer(String op, double num) {
		switch (op) {
		case "+":
			add(num);
			break;
		case "-":
			subtract(num);
			break;
		case "*":
			multiply(num);
			break;

			/**
			 * creates a method for multiplying
			 */

		case "/":
			divide(num);
			break;

			/**
			 * creates a method for dividing
			 */

		case "c":
		case "C":
			clear(num);
			break;

			/**
			 * creates a method for clearing the calculator
			 */

		case "neg":
			negative(num);
			break;

			/**
			 * creates a method for making the user input negative
			 */

		case "%":
			percent(num);
			break;

			/**
			 * creates a method for finding percentages
			 */

		case "^":
			power(num);
			break;

			/**
			 * creates a method to allow the user to take the power of some number
			 */

		case "inv":
			inverse(num);
			break;

			/**
			 * creates a method that allows for the inverse of the specified number
			 */

		case "rand":
			rand(num);
			break;

			/**
			 * creates a method that takes the users input and randomizes the number
			 */

		case "round":
			rounding(num);
			break;

			/**
			 * creates a method that allows the user input to be rounded
			 */

		case "=":
			printAnswer();
			break;
		case "?":
			System.out.println(this.usageInstructions);
			break;
		default:
			System.out.println("Invalid Operator");
		}
		return this.answer;
	}

	public double add(double operand) {
		this.answer += operand;
		return this.answer;
	}

	public double subtract(double operand) {
		this.answer -= operand;
		return this.answer;
	}
	public double multiply(double operand){
		this.answer *= operand;
		return this.answer;
		/**
		 * multiply by the users input and the previous number entered
		 * returns the math the computer just did
		 */
	}
	public double divide(double operand){
		this.answer /= operand;
		return this.answer;
		/**
		 * divide by the users input and the previous number entered
		 * returns the math the computer just did
		 */
	}
	public double negative(double operand){
		this.answer = -1 * answer;
		return this.answer;
		/**
		 * turn the users previous answer into a negative, the users input is not actually used here
		 * the answer will now be what ever the answer was, but negative
		 */
	}
	public double clear(double operand){
		this.answer = operand * 0;
		return this.answer;
		/**
		 * clears all stored answer information
		 */
	}
	public double inverse(double operand){
		this.answer = 1 / operand;
		return this.answer;
		/**
		 * makes the users number the inverse of what the operand previously was.
		 */
	}
	public double rounding(double operand){
		double scale = Math.pow(10, operand);
		this.answer = Math.round(scale * answer) / scale;
		return this.answer;
		/**
		 * if you important the math library you can use this function, someone on github suggested that if you use a 10 it helps with decimal movement
		 *  so really you are getting an answer and then multiplying by the decimal scale of that answer
		 *  this will ensure that the decimal gets moved to the next position based on the users input
		 */

	}
	public double percent(double operand){
		this.answer = answer / 100;
		return this.answer;
		/**
		 * you can turn any number the user wants by taking the old answer and then dividing it by 100
		 */
	}
	public double power(double operand){
		this.answer = Math.pow(answer, operand);
		return this.answer;
		/**
		 * using the math library this one is really easy to do
		 * raises the previously stored user input (answer) by the new user input (operand)
		 */
	}
	public double rand(double operand){
		double test = Math.random();
		if(Math.random() > .5 ){
			answer -= test;
			/**
			 * you dont need the users input in this case since you are already going off the previous input
			 * this was the hardest one to do, apparently the random method from the math library picks a random int from 0, to 1
			 * so if I make .5 my barrier, then there is a 50% chance of either scenarios
			 */
		}
		else{
			answer += test;
			/**
			 * used the if else statement format, forgot what it looked like, so i borrowed this from google.
			 */
		}
		return answer;
	}


	public double getAnswer() {
		return this.answer;
	}


	public void printAnswer() {
		// https://www.fileformat.info/info/unicode/block/box_drawing/list.htm
		// https://www.homeandlearn.co.uk/java/java_formatted_strings.html
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.printf("┃ %21s ┃%n", this.answer);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	/**
	 * I used the homeandlearn link to figure the formatting out.
	 */
}

