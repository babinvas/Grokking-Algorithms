package algorithms;

public class Recursion {
	public void countdown(int from) {
		System.out.print(from);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (from <= 0) {
			System.out.println("...Start");
		} else {
			System.out.print("...");
			countdown(from - 1);
		}
	}

	public int findFactorial(int number) {
		if (number == 1) {
			return 1;
		} else {
			return number * findFactorial(number - 1);
		}
	}
}
