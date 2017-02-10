import java.util.Scanner;

public class VirtualPetApp extends Thread {

	public static void main(String[] args) throws InterruptedException {
		int score = 0; // Initiate Score Counter
		MakingStrings callingToPrint = new MakingStrings();

		// Welcome and Instructions
		callingToPrint.MakingStrings1();
		callingToPrint.choosePetBehavior();

		// Construction of VirtualPet object "executeVirtualPet"
		// Passing in false to check for a lose or win condition within the
		// Virtual Pet class

		VirtualPet executeVirtualPet = new VirtualPet();
		DeathCounter towardsDeath = new DeathCounter();
		executeVirtualPet.tick(false);

		// using a quit while statement to allow the program to fall through if
		// the user wins, losses, or inputs quit
		boolean quit = false;
		while (!quit) {

			// Instructions of what to write and scanner constructions
			String userChoice;
			Scanner scanner = new Scanner(System.in);
			userChoice = scanner.next();
			// quit = DeathCounter.howDeadAreYou(quit);
			DeathCounter.whyWontThisWork();

			switch (userChoice) {

			case "1": // Options to feed your animal
				callingToPrint.feedPetPrintOut();
				executeVirtualPet.feedPet();

				quit = callToSelfCareMethodAndTickMethod(executeVirtualPet, quit);
				if (!quit) {
					callingToPrint.choosePetBehavior();
				} // this if (and all ifs like it allow the program to fall
					// through
					// when the end game conditions are meet)
				score++;

				break;
			case "2": // Give your pet water
				callingToPrint.giveYourPetWater();
				executeVirtualPet.giveWater();

				quit = callToSelfCareMethodAndTickMethod(executeVirtualPet, quit);
				if (!quit) {
					callingToPrint.choosePetBehavior();
				}
				score++;

				break;
			case "3": // take a nap options
				callingToPrint.takeANapPrintOut();
				executeVirtualPet.takeNap();

				quit = callToSelfCareMethodAndTickMethod(executeVirtualPet, quit);
				if (!quit) {
					callingToPrint.choosePetBehavior();
				}

				score++;

				break;
			case "4": // use the restroom option
				callingToPrint.useRestRoomPrintOut();
				executeVirtualPet.useRestRoom();

				quit = callToSelfCareMethodAndTickMethod(executeVirtualPet, quit);
				if (!quit) {
					callingToPrint.choosePetBehavior();
				}

				score++;
				break;
			case "5": // figth crime option
				callingToPrint.fightCrimePrintOut();
				executeVirtualPet.fightCrime();

				quit = callToSelfCareMethodAndTickMethod(executeVirtualPet, quit);
				if (!quit) {
					callingToPrint.choosePetBehavior();
				}

				score++;
				break;
			case "6": // Train your pet
				callingToPrint.trainHardPrintOut();
				executeVirtualPet.strengthModifer();

				quit = callToSelfCareMethodAndTickMethod(executeVirtualPet, quit);
				if (!quit) {
					callingToPrint.choosePetBehavior();
				}

				score++;
				break;
			case "quit":
				quit = true;
				break;
			// quit option
			default:
				callingToPrint.incorrectInputPrintOut();
				break;
			// if you didn't type what I wanted you to type
			}

		}
		callingToPrint.finalScorePrintout(score); // prints out the final
													// score(i.e. how many times
													// you went through
		// the switch statement

	}

	// this allows the tick to always be called and quit evaluated but it
	// doesn't allow self care if you win/lose the game
	private static boolean callToSelfCareMethodAndTickMethod(VirtualPet executeVirtualPet, boolean quit) {
		quit = executeVirtualPet.tick(quit);
		if (!quit) {
			executeVirtualPet.selfCare();
		}
		return quit;
	}
}
