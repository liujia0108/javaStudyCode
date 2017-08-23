package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String log = "04-11 17:00:05.544: D/TAG(4456): [image player report] : success [/mnt/usb/sda1/mutimedia_test/picture/风景.bmp]";
		String format = ".*(\\[image player report\\])\\s+:\\s+(success)\\s+.*/(.*)]";
		
		Pattern pattern = Pattern.compile(format);
		Matcher m = pattern.matcher(log);
		
		if (m.matches()) {
			System.out.println("matched");
			int c = m.groupCount();
			for (int i = 0; i <= c; i++) {
				System.out.println(i + ":" + m.group(i));
			}
		} else {
			System.out.println("not matched");
		}
	}

}
