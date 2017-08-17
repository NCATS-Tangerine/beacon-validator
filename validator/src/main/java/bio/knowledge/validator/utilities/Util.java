package bio.knowledge.validator.utilities;

public final class Util {
	
	public final static void println() {
		System.out.println();
	}
	
	public final static void println(Object... args) {
		for (Object arg : args) {
			System.out.print(arg + " ");
		}
		System.out.println();
	}
	
	public final static void print(Object... args) {
		for (Object arg : args) {
			System.out.print(arg + " ");
		}
	}
}
