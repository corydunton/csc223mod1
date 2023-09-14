package csc223_cdunton_mod1;

/**
 * Instructions You are designing a role-playing game (RPG) named "Wizards and
 * Warriors," which allows you to play as either a Wizard or a Warrior.
 *
 * There are different rules for Warriors and Wizards to determine how much
 * damage points they deal.
 *
 * For a Warrior, these are the rules:
 * - Deal 6 points of damage if the fighter they are attacking is not vulnerable
 * - Deal 10 points of damage if the fighter they are attacking is vulnerable
 *
 * For a Wizard, these are the rules:
 * - Deal 12 points of damage if the Wizard prepared a spell in advance
 * - Deal 3 points of damage if the Wizard did not prepare a spell in advance
 *
 * In general, fighters are never vulnerable. However, Wizards are vulnerable if
 * they haven't prepared a spell.
 *
 * You have seven tasks to complete:
 * 1. Override each Player type's toString() in the format "Player is a ____" (Warrior or Wizard)
 * 2. Make all Players not vulnerable by default
 * 3. Allow Wizards to prepare a spell
 * 4. Make Wizards vulnerable when not having prepared a spell
 * 5. Calculate the damage points a Wizard produces
 * 6. Calculate the damage points a Warrior produces
 * 7. Add helpful documentation in multi-line or Javadoc comments (cf. Hamming exercise)
 */

/**
 * Abstract class representing a player in a role-playing game (RPG).
 */

abstract class RPGPlayer {
	
    /**
     * Checks if the player is vulnerable.
     *
     * @return {@code true} if the player is vulnerable, {@code false} otherwise.
     */
	boolean isVulnerable() {
		return new Boolean(false);
	}
	
    /**
     * Calculates the damage points inflicted by the player on another player.
     *
     * @param player The target player.
     * @return The calculated damage points.
     */
	abstract int damagePoints(RPGPlayer player);

}

/**
 * Represents a warrior player in the RPG.
 */
class Warrior extends RPGPlayer {

	@Override
	public String toString() {
		return "Player is a Warrior";
	}

	@Override
	int damagePoints(RPGPlayer wizard) {
		int dmg = 6;
		if (wizard.isVulnerable()) {
			dmg = 10;
		}
		return dmg;
	}
}

/**
 * Represents a wizard player in the RPG.
 */
class Wizard extends RPGPlayer {
	private boolean spellPrepared = false;

	@Override
	public String toString() {
		return "Player is a Wizard";
	}

	@Override
	boolean isVulnerable() {
		return !spellPrepared;
	}

	@Override
	int damagePoints(RPGPlayer warrior) {
		int dmg = 12;
		if (this.isVulnerable()) {
			dmg = 3;
		}
		return dmg;
	}
	
    /**
     * Prepares a spell for the wizard.
     */
	void prepareSpell() {
		spellPrepared = true;
	}

    /**
     * Checks if a spell is prepared.
     *
     * @return {@code true} if a spell is prepared, {@code false} otherwise.
     */
	public boolean getSpellPrepared() {
		return spellPrepared;
	}

}
