package csc223_cdunton_mod1;

public class GameEngine {

	/*
	 * Run this class to execute various tests to check if your implementation is
	 * correct. - All tests when successful should state "PASS" - If your
	 * implementation fails any of the tests, it will state "FAIL"—go ahead and run
	 * the file to see it now
	 */
	public static void main(String[] args) {
		RPGPlayer warrior = new Warrior();
		Wizard wizard = new Wizard();

		// Test: Warrior toString
		System.out.println(
				"Test: Warrior toString: " + (warrior.toString().equals("Player is a Warrior") ? "PASS" : "FAIL"));

		// Test: Wizard toString
		System.out.println(
				"Test: Wizard toString: " + (wizard.toString().equals("Player is a Wizard") ? "PASS" : "FAIL"));

		// Test: All Players Vulnerable By Default
		System.out.println("Test: All Players Vulnerable By Default: "
				+ (!warrior.isVulnerable() && wizard.isVulnerable() ? "PASS" : "FAIL"));

		// Test: Wizard Not Vulnerable After Spell
		wizard.prepareSpell();
		System.out.println("Test: Wizard Not Vulnerable After Spell: " + (!wizard.isVulnerable() ? "PASS" : "FAIL"));

		// Test: Wizards Damage Points
		Wizard wizard2 = new Wizard();
		boolean wizardsDamagePoints = wizard2.damagePoints(warrior) == 3;
		wizard2.prepareSpell();
		wizardsDamagePoints &= wizard2.damagePoints(warrior) == 12;
		System.out.println("Test: Wizards Damage Points: " + (wizardsDamagePoints ? "PASS" : "FAIL"));

		// Test: Warriors Damage Points
		Wizard wizard3 = new Wizard();
		boolean warriorsDamagePoints = warrior.damagePoints(wizard3) == 10;
		wizard3.prepareSpell();
		warriorsDamagePoints &= warrior.damagePoints(wizard3) == 6;
		System.out.println("Test: Warriors Damage Points: " + (warriorsDamagePoints ? "PASS" : "FAIL"));
	}
}