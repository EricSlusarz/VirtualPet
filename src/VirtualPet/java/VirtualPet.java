import java.util.Random;
import java.util.Scanner;

public class VirtualPet extends VirtualPetApp {

	Scanner scanner = new Scanner(System.in); // turn on scanner

	static Random rand = new Random(); // brings in a random method usage

	static NonUniform randomNumber = new NonUniform(); // constructer for random
														// class that makes a
														// kind of bell curve
														// result

	MakingStrings callingToPrint = new MakingStrings(); // failed attempt to
														// organize system outs

	private static int pethunger = rand.nextInt(15) + 2; // random start up
															// numbers
	private static int petthrist = rand.nextInt(15) + 2;
	private static int petwaste = rand.nextInt(15) + 2;
	private static int petsleepiness = rand.nextInt(15) + 2;
	private static int crimeInCity = 280 + rand.nextInt(15);
	private static int strengthModifer = 0;

	// main tick method updates all static variables and evaluates win
	// conditions
	public boolean tick(boolean quit) {

		generateRandomNumbersAndAddThem();
		quit = checkToSeeIfHungerIsInTheRightRange(quit);
		quit = checkToSeeIfThristIsWithinRange(quit);
		seeIfWasteIsIsWithingRange();
		quit = sleepinessRangeCheck(quit);
		quit = crimeRateWithinRangeCheck(quit);

		// Shows a heading saying final stats if a win condition is true
		if (quit == true) {
			callingToPrint.finalPetStatsPrintOut();
		}

		// prints out stats and checks to see if you won or not
		printOutOfPetStats();
		winningAndLosingEndScreens();

		return quit;
	}

	// Checkts to see if you won and makes fun of you if you did not
	private void winningAndLosingEndScreens() {
		if (crimeInCity < 0 || crimeInCity > 450 || pethunger > 100 || petthrist > 100 || petsleepiness > 100)
			for (int i = 0; i < 10; i++) {
				if (crimeInCity < 0) {
					callingToPrint.youWinPrintOut();
				} else if (crimeInCity > 450 || pethunger > 100 || petthrist > 100 || petsleepiness > 100) {
					callingToPrint.youLosePrintOut();
					if (i > 7) {
						for (int j = 1; j < 3; j++) {
							System.out.println("Hahaha");
							pauseFor500Milli();
						}
					}
				}
				try {
					Thread.sleep(900);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
	}

	private void pauseFor500Milli() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	// Checks to see if crime was within a losing or winning range
	private boolean crimeRateWithinRangeCheck(boolean quit) {
		if (crimeInCity < 0) {
			callingToPrint.youWoncongrats();
			quit = true;
		} else if (crimeInCity > 450) {
			callingToPrint.crimeHasTakenTheCity();
			quit = true;
		}
		return quit;
	}

	// checks to see if sleepiness if within a good range
	private boolean sleepinessRangeCheck(boolean quit) {
		if (petsleepiness < 0) {
			callingToPrint.soTiredIsTooTired();
			petsleepiness = petsleepiness + 25;
		} else if (petsleepiness > 100) {
			callingToPrint.diedFromNoSleepPrintOut();
			quit = true;
		}
		return quit;
	}

	// checks to see if waste if within a good range
	private void seeIfWasteIsIsWithingRange() {
		if (petwaste < 0) {
			System.out.println("Your dog gets hemorrhoids from being force to use the bathroom.");
			petwaste = petwaste + 15;
		} else if (petwaste > 100) {
			System.out.println("Your pet poops in defiance and then smirks at you.");
			petwaste = petwaste - 50;
			petthrist = petthrist + 10;
			pethunger = pethunger + 10;
			petsleepiness = petsleepiness + 10;
		}
	}

	// checks to see if thirst if within a good range
	private boolean checkToSeeIfThristIsWithinRange(boolean quit) {
		pauseFor500Milli();
		if (petthrist < 0) {
			System.out.println("You overhydrated your pet and he threw up. Way to go.");
			petthrist = petthrist + 15;
		} else if (petthrist > 100) {
			System.out.println("Your pet died from dehydration.");
			quit = true;
		}
		return quit;
	}

	// checks to see if hunger if within a good range
	private boolean checkToSeeIfHungerIsInTheRightRange(boolean quit) {
		pauseFor500Milli();
		if (pethunger < 0) {
			System.out.println("You overfed your pet and he threw up. Way to go.");
			pethunger = pethunger + 15;
		} else if (pethunger > 100) {
			System.out.println("Your pet died from startvation.");
			quit = true;
		}
		return quit;
	}

	// makes random numbers
	private void generateRandomNumbersAndAddThem() {
		pethunger = pethunger + randomNumber.makeARandom();
		petthrist = petthrist + randomNumber.makeARandom();
		petwaste = petwaste + randomNumber.makeARandom();
		petsleepiness = petsleepiness + randomNumber.makeARandom();
		int crimeIncrement = rand.nextInt(6) + rand.nextInt(2) + 1;
		crimeInCity = crimeInCity + crimeIncrement;
	}

	// stat print out
	private void printOutOfPetStats() {
		pauseFor500Milli();
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("-Hunger: " + pethunger);
		System.out.print(" Thrist: " + petthrist);
		System.out.print(" Sleepiness: " + petsleepiness);
		System.out.println(" Waste: " + petwaste);
		System.out.println("- Crime Rate: " + crimeInCity + " Strength: " + strengthModifer);
		System.out.println("-----------------------------------------------------------------------");
	}

	// self care randomness test and print out
	public void selfCare() {
		pauseFor500Milli();
		int randomNumber = rand.nextInt(20) + 1;
		if (randomNumber < 20 && randomNumber > 14) {
			pethunger--;
			System.out.println("Self pet-care: Your pet feed himself");
		} else if (randomNumber < 15 && randomNumber > 9) {
			petthrist--;
			System.out.println("Self pet-care: Your pet got a glasss of milk");
		} else if (randomNumber < 9 && randomNumber > 4) {
			petwaste--;
			System.out.println("Self pet-care: Your dog got outside to use the restroom");
		} else {
			System.out.println("Self pet-care: Your dog didn't take care of himself this turn");
		}

	}

	// all the actions executable methods that reduce the states
	public void feedPet() {
		pethunger = pethunger - 4 - (rand.nextInt(3));
	}

	public void giveWater() {
		petthrist = petthrist - 4 - (rand.nextInt(3));
	}

	public void takeNap() {
		petsleepiness = petsleepiness - 4 - (rand.nextInt(3));
	}

	public void useRestRoom() {
		petwaste = petwaste - 4 - (rand.nextInt(3));
	}

	// makes you stronger and a mini-game inside the game
	public void strengthModifer() {
		pauseFor500Milli();
		System.out.println("If you can guess weather the randomly generated number is\n"
				+ "even or odd you will increase your strength which helps you fight crime more efficently.\n"
				+ "Type an even number to guess even and an odd number to guess odd");
		int inputForStrength = scanner.nextInt();
		inputForStrength = inputForStrength % 2;

		if (inputForStrength == rand.nextInt(2)) {
			System.out.println("You guessed right you strength increases!");
			strengthModifer++;
		} else {
			System.out.println("You guessed wrong your strength stays the same.");
		}

	}

	// another action with a mini game within it
	public void fightCrime() {
		pauseFor500Milli();
		System.out.println(
				"If you can guess the correct number between 1-4 you get " + "double your crime fighting abilties.");
		int inputForGuess = scanner.nextInt();

		int randomNumberGuess = rand.nextInt(4) + 1;

		if (inputForGuess == randomNumberGuess) {
			crimeInCity = crimeInCity - 8 * strengthModifer;
			System.out.println("You guessed right and gained double crime fighting effectivness!");

		} else {
			crimeInCity = crimeInCity - 4 * strengthModifer;
			System.out.println("Sorry wrong guess.");
		}
	}

	/*
	 * 
	 * What you wrote... (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO
		return super.toString();
	}

}
