
public class MakingStrings {

	public void MakingStrings1() {
		System.out.println("Hello and welcome to the Pet Simulater");
		pauseInGameFor700Mill();
		System.out.println("How to win: \nlower the crime rate to under 0");
		pauseInGameFor700Mill();
		System.out.println(
				"How to lose: \nLet the crime rate hit 450\nLet hunger hit 100\nLet thirst hit 100\nLet sleepiness hit 100");
		pauseInGameFor700Mill();
	}

	private void pauseInGameFor700Mill() {
		try {
			Thread.sleep(700);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void choosePetBehavior() {
		pauseInGameFor700Mill();
		System.out.println("___________________________________________________________________________________");
		System.out.println("Please choose what you want to do with your pet by choosing a correspind number?\n"
				+ "Press \"1\" to feed your dog\n" + "Press \"2\" to drink your dog\n"
				+ "Press \"3\" to have your dog take a nap\n" + "Press \"4\" to let your pet use the potty\n"
				+ "Press \"5\" let your pet fight crime\n" + "Press \"6\" train your pet to fight crime\n"
				+ "or type \"quit\" to exit the program.");
		System.out.println("___________________________________________________________________________________");
	}

	public void feedPetPrintOut() {
		pauseInGameFor700Mill();
		System.out.println("*************************************************");
		System.out.println("**You feed your dog and he seems happy and full**");
		System.out.println("*************************************************");
	}

	public void giveYourPetWater() {
		pauseInGameFor700Mill();
		System.out.println("*************************************************************");
		System.out.println("**You give your dog water and he seems hydrated and content**");
		System.out.println("*************************************************************");
	}

	public void takeANapPrintOut() {
		pauseInGameFor700Mill();
		System.out.println("*********************************************");
		System.out.println("**Your dog takes a nap he seems well rested**");
		System.out.println("*********************************************");
	}

	public void useRestRoomPrintOut() {
		pauseInGameFor700Mill();
		System.out.println("***************************");
		System.out.println("**Your dog uses the potty**");
		System.out.println("***************************");
	}

	public void fightCrimePrintOut() {
		pauseInGameFor700Mill();
		System.out.println("********************************************");
		System.out.println("**Your pet fights crime for the whole day.**");
		System.out.println("********************************************");
	}

	public void trainHardPrintOut() {
		pauseInGameFor700Mill();
		System.out.println("*************************");
		System.out.println("**Your pet trains hard!**");
		System.out.println("*************************");
	}

	public void incorrectInputPrintOut() {
		pauseInGameFor700Mill();
		System.out.println("***********************************");
		System.out.println("**Please enter a number provided.**");
		System.out.println("***********************************");
	}

	public void finalScorePrintout(int score) {
		pauseInGameFor700Mill();
		System.out.println("Thanks for playing!");
		pauseInGameFor700Mill();
		System.out.println("Your final score is: " + score);
	}

	public void finalPetStatsPrintOut() {
		pauseInGameFor700Mill();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~Final Stats of your pet:~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void youWinPrintOut() {
		System.out.println("YOU WON");
	}

	public void youLosePrintOut() {
		System.out.println("YOU LOST");

	}

	public void youWoncongrats() {
		System.out.println("You won the game congrats!");
	}

	public void crimeHasTakenTheCity() {
		System.out.println("Crime overtakes your city and your pet gets stolen. Game Over");
	}

	public void soTiredIsTooTired() {
		System.out.println("Your pet is so tired from napping he is tired.");

	}

	public void diedFromNoSleepPrintOut() {
		System.out.println("Your pet dies from sleep deprivation.");

	}

}
