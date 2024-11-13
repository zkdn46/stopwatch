package stopwatch;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time extends Thread {
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

	protected int sec = 1;
	protected boolean isRun = true;

	public void run() {

		while (true) {
			try {
				if (isRun) {
					Calendar cal = Calendar.getInstance();
					buffer.append(timeFormat.format(cal.getTime()));

					buffer.append(String.format(" [%d sec]\n", sec++));
					writer.append(buffer);
					buffer.setLength(0);

					writer.flush();
				} else {
					Calendar cal = Calendar.getInstance();
					buffer.append(timeFormat.format(cal.getTime()));
					buffer.setLength(0);
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				break;
			}
		}

	}
}