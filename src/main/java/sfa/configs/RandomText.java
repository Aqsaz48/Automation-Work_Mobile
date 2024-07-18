package sfa.configs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomText {

	public static synchronized String getRandomString() {
		return (new SimpleDateFormat("ddMMyy").format(new Date())+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())).replaceAll("[-:./s]", "");
	}
}
