package com.accolite.miniau.junitassignment;

public class BowlingGame {
	int[] rolls;
	int currentRoll;

	public BowlingGame() {
		this.rolls = new int[21];
	}

	public void roll(int p) {
		rolls[currentRoll++] = p;
	}

	public int score() {
		int score = 0;
		int frame = 0;

		for (int i = 0; i < 10; i++) {
			if (rolls[frame] == 10) {
				score += 10 + rolls[frame+1] + rolls[frame+2];
				frame++;
			} else if (rolls[frame] + rolls[frame+1]==10) {
				score += 10 + rolls[frame+2];
				frame += 2;
			} else {
				score += rolls[frame] + rolls[frame+1];
				frame += 2;
			}
		}
		return score;
	}
}