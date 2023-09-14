package edu.vwcc.email;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This program ensures emails are valid and removes duplicate email addresses
 * from a list of email addresses. Author: Your Name Date: Your Date
 *
 * Instructions: complete all the sections marked TODO then run the class or
 * main method to test your code
 *
 * 1. Implement the addEmail() method to add an email to a list of email
 * addresses - If the email is empty or null, print "Email cannot be empty." -
 * Only allow valid email addresses to be added, which for us are defined as 1.
 * having a "@" symbol with at least one alphanumeric character before and after
 * the "@" 2. ending in ".com" or ".edu"
 *
 * 2. Implement the removeDuplicates() method to remove any duplicate email
 * addresses from the ArrayList
 *
 * 3. Implement the getEmailCount() method to return the total number of email
 * addresses in the ArrayList
 *
 * 4. To test your code, simply Run this class. This will execute various tests
 * in the main method to check if your implementation is correct. - All tests
 * when successful should state "PASS" - If your implementation fails any of the
 * tests, it will state "FAIL"—go ahead and run the file to see it now
 */
public class EmailChecker {

	private ArrayList<String> emailAddresses = new ArrayList<>();

	public EmailChecker() {

	}

	/**
	 * Adds an email to the ArrayList if it is not empty or null.
	 *
	 * @param email The email address to add as a String.
	 */
	public void addEmail(String email) {

		String errorMessage = "Email is invalid.";

		if (email == null || email.isEmpty()) {
			System.out.println("Email cannot be empty.");
			return;
		}
		int atSignIndex = -1;
		for (int i = 0; i < email.length(); i++) {
			char currentChar = email.charAt(i);
			if (currentChar == '@') {
				atSignIndex = i;
			}
		}
		if (atSignIndex == -1) {
			System.out.println(errorMessage);
			return;
		}
		if (atSignIndex == 0 || atSignIndex == email.length() - 1) {
			System.out.println(errorMessage);
			return;
		}
		char beforeAtSign = email.charAt(atSignIndex - 1);
		char afterAtSign = email.charAt(atSignIndex + 1);

		if (!Character.isLetterOrDigit(beforeAtSign) || !Character.isLetterOrDigit(afterAtSign)) {
			System.out.println(errorMessage);
			return;
		}
		boolean emailEndingValid = email.endsWith(".edu") || email.endsWith(".com");
		if (!emailEndingValid) {
			System.out.println(errorMessage);
			return;
		}
		emailAddresses.add(email);
	}

	/**
	 * Removes any duplicate email addresses from the ArrayList.
	 */
	public void removeDuplicates() {
		Set<String> emailAddressesSet = new HashSet<>(this.emailAddresses);
		this.emailAddresses = new ArrayList<>(emailAddressesSet);
	}

	/**
	 * Returns the total number of email addresses in the ArrayList.
	 *
	 * @return int The total number of email addresses in the ArrayList.
	 */
	public int getEmailCount() {
		return this.emailAddresses.size();
	}

	// DON'T CHANGE ANYTHING BELOW: Just run the main method to test your code
	// (click the green Run icon or right-click to run as Java app)
	public static void main(String[] args) {
		EmailChecker checker = new EmailChecker();

		// Test 1. Add Valid Email
		checker.addEmail("test@example.com");
		System.out.println("Test 1. Add Valid Email: " + (checker.getEmailCount() == 1 ? "PASS" : "FAIL"));

		// Test 2. Add Duplicate Email
		checker.addEmail("test@example.com");
		checker.removeDuplicates();
		System.out.println("Test 2. Add Duplicate Email: " + (checker.getEmailCount() == 1 ? "PASS" : "FAIL"));

		// Test 3. Add Another Valid Email
		checker.addEmail("hello@example.com");
		System.out.println("Test 3. Add Another Valid Email: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 4. Add Invalid Email
		checker.addEmail("invalid_email");
		System.out.println("Test 4. Add Invalid Email: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 5. Add Email Without Top-Level Domain
		checker.addEmail("test@example");
		System.out.println(
				"Test 5. Add Email Without Top-Level Domain: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 6. Add Email Without Domain
		checker.addEmail("test@.com");
		System.out.println("Test 6. Add Email Without Domain: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 7. Add Email Without Username
		checker.addEmail("@example.com");
		System.out.println("Test 7. Add Email Without Username: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 8. Add Email With Invalid Top-Level Domain
		checker.addEmail("test@example.xyz");
		System.out.println(
				"Test 8. Add Email With Invalid Top-Level Domain: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 9. Add Empty Email
		checker.addEmail("");
		System.out.println("Test 9. Add Empty Email: " + (checker.getEmailCount() == 2 ? "PASS" : "FAIL"));

		// Test 10. Add Valid .edu Email
		checker.addEmail("test@example.edu");
		System.out.println("Test 10. Add Valid .edu Email: " + (checker.getEmailCount() == 3 ? "PASS" : "FAIL"));
	}
}
