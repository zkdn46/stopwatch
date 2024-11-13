package stopwatch;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time implements Runnable {

	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

	public void run() {
		
		while (true) {

			try {
				Thread.sleep(1000);
				
				Calendar cal = Calendar.getInstance();
				buffer.append(timeFormat.format(cal.getTime()));
				writer.append(buffer);
				
				buffer.setLength(0);
				
				writer.flush();
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}