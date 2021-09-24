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
			return;
		} else {
			System.out.print("...");
			countdown(from - 1);
		}
	}
}
