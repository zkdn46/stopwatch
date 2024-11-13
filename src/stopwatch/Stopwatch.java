package stopwatch;

public class Stopwatch {

	private static final Stopwatch stopwatch = new Stopwatch();

	public static Stopwatch getInstance() {
		return stopwatch;
	}

	private Control control = new Control();
	private Thread controlThread = new Thread(control);

	public void run() {
		printMenu();
		controlThread.start();
	}

	private void printMenu() {
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[*] RERUN");
	}

}
