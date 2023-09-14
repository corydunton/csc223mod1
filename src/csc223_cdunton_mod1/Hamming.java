package csc223_cdunton_mod1;

import java.io.ByteArrayOutputStream; // ignore but don't delete
import java.io.PrintStream; // ignore but don't delete

/**
 * This program calculates the Hamming distance between two DNA strands. Hamming
 * distance is the total number of character differences between two homologous
 * DNA strands, For example, "GGAC" and "AGTC" have a Hamming distance of 2
 * Author: Cory Dunton Date: 8/29/23
 * 
 * Instructions: Complete all the sections marked TODO 's
 * 
 * 1. Implement a class constructor for the Hamming class that takes two DNA
 * strings as input - If the input strands are empty, print "Empty inputs are
 * not allowed." - If the input strands are not of equal length, print "Strands
 * must be of equal length." // Note: If an input is both empty and of unequal
 * length, only print the empty error message
 *
 * 2. Implement the method getHammingDistance() to calculate and return the
 * Hamming distance between the two DNA strands
 *
 * 3. Run the main method. This will execute various tests to check if your
 * implementation is correct. - All tests when successful should state "PASS" -
 * If your implementation fails any of the tests, it will state "FAIL"—go ahead
 * and run the file to see it now
 *
 */
public class Hamming {
	private String leftStrand;
	private String rightStrand;

	/**
	 * Constructor for the Hamming class.
	 *
	 * @param leftStrand  The first DNA strand as a String.
	 * @param rightStrand The second DNA strand as a String.
	 */
	public Hamming(String leftStrand, String rightStrand) {
		if (leftStrand.isEmpty() || rightStrand.isEmpty()) {
			System.out.println("Empty inputs are not allowed.");
			return;
		}

		if (leftStrand.length() != rightStrand.length()) {
			System.out.println("Strands must be of equal length.");
			return;
		}

		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;

	}

	/**
	 * Calculates and returns the Hamming distance between the two DNA strands,
	 * which is the count of positions at which the corresponding symbols are
	 * different.
	 *
	 * @return int The calculated Hamming distance between the two DNA strands.
	 */
	public int getHammingDistance() {

		int dist = 0;
		for (int i = 0; i < leftStrand.length(); i++) {
			char left = leftStrand.charAt(i);
			char right = rightStrand.charAt(i);
			if (left != right) {
				dist++;
			}
		}
		return dist;
	}

	// DON'T CHANGE ANYTHING BELOW: Just run the main method to test your code
	// (click the green Run icon or right-click to run as Java app)
	public static void main(String[] args) {
		Hamming hamming;
		// Test 1. No Distance Between Short Identical Strands
		hamming = new Hamming("A", "A");
		System.out.println("Test 1. No Distance Between Short Identical Strands: "
				+ (hamming.getHammingDistance() == 0 ? "PASS" : "FAIL"));

		// Test 2. Correct Distance In Single Letter Different Strands
		hamming = new Hamming("G", "T");
		System.out.println("Test 2. Correct Distance In Single Letter Different Strands: "
				+ (hamming.getHammingDistance() == 1 ? "PASS" : "FAIL"));

		// Test 3. Correct Distance In Long Identical Strands
		hamming = new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG");
		System.out.println("Test 3. Correct Distance In Long Identical Strands: "
				+ (hamming.getHammingDistance() == 0 ? "PASS" : "FAIL"));

		// Test 4. Correct Distance In Long Different Strands
		hamming = new Hamming("GGACGGATTCTG", "AGGACGGATTCT");
		System.out.println("Test 4. Correct Distance In Long Different Strands: "
				+ (hamming.getHammingDistance() == 9 ? "PASS" : "FAIL"));

		// Test 5. Validates First Strand Not Longer
		System.out.println("Test 5. Validates First Strand Not Longer: "
				+ (testErrorMessage("AATG", "AAA", "Strands must be of equal length.") ? "PASS" : "FAIL"));

		// Test 6. Validates Second Strand Not Longer
		System.out.println("Test 6. Validates Second Strand Not Longer: "
				+ (testErrorMessage("ATA", "AGTG", "Strands must be of equal length.") ? "PASS" : "FAIL"));

		// Test 7. Disallow Left Empty Strand
		System.out.println("Test 7. Disallow Left Empty Strand: "
				+ (testErrorMessage("", "G", "Empty inputs are not allowed.") ? "PASS" : "FAIL"));

		// Test 8. Disallow Right Empty Strand
		System.out.println("Test 8. Disallow Right Empty Strand: "
				+ (testErrorMessage("G", "", "Empty inputs are not allowed.") ? "PASS" : "FAIL"));
	}

	/* This is a private helper method for testing your data validation output */
	private static boolean testErrorMessage(String leftStrand, String rightStrand, String expectedMessage) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));
		new Hamming(leftStrand, rightStrand);
		System.setOut(originalOut);
		String actualMessage = outputStream.toString().trim();
		return actualMessage.equals(expectedMessage);
	}
}
