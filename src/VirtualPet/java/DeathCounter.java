
class DeathCounter implements Runnable {
	static int counterForDeath = 0;

	public static void main(String[] args) {

		whyWontThisWork();

	}

	static void whyWontThisWork() {
		Thread t = new Thread(new DeathCounter());
		t.start();

	}

	public boolean howDeadAreYou(boolean quit) {
		if (counterForDeath > 100) {
			quit = true;
		} else {
			quit = false;
		}
		return quit;
	}

	public void run() {
		long t = System.currentTimeMillis();
		long end = t + 500000;
		while (System.currentTimeMillis() < end) {
			System.out.println(
					"                                                    Death in: " + counterForDeath + "/100");
			System.out.println("                                                    (If it reaches 100 you die)");

			counterForDeath++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			if (counterForDeath == 100) {
				System.out.println("Just kidding!");
				System.out.println("Just kidding!");
				System.out.println("Just kidding!");
				System.out.println("Just kidding!");
				System.out.println("Just kidding!");
				System.out.println("Just kidding!");

			}
		}
	}

}// class
