import java.util.Random;
import java.lang.Math;

public class NonUniform {
	static Random rand = new Random();

	// This makes somewhat of a bell curve to which number will be added to
	// hunger, thirst, sleepiness, waste and crime.
	// The numbers it mostly generates are 0,1,2,3, but can also generate nines
	// as the highest number.
	int makeARandom() {
		int firstRandomNumber = (rand.nextInt(rand.nextInt(7) + 6)) - rand.nextInt(9) - rand.nextInt(1);
		int theFinalNumber = Math.abs(firstRandomNumber);
		return theFinalNumber;

	} // method
} // class