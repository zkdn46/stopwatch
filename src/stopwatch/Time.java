package stopwatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time extends Thread {
	protected static StringBuffer buffer = new StringBuffer();
	protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	protected static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	protected static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	

	
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
				} 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
	            break;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			
		}

	}
}