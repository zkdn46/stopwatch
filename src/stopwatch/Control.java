package stopwatch;

public class Control extends Thread {

	private Time time = new Time();
	private Thread timeThread = new Thread(time);

	public void run() {
		timeThread.start();
		while (true) {
			try {
				String sel = Time.reader.readLine();
				if (sel.equals("q")) {
					Time.writer.append(String.format("%d분 %d초 소요", time.sec / 60, time.sec % 60));
					timeThread.interrupt();
					break;
				} else if (sel.equals("h")) {
					time.isRun = false;
				} else {
					time.isRun = true;
				}
			} catch (Exception e) {

			}
		}

	}

}
