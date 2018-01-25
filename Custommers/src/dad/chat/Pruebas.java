package dad.chat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class Pruebas {

	public static void main(String[] args) {
		
		Date da = new Date();
		Date da2 = new Date();
		
		DateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		
		LocalDate ahora = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		
		LocalDate test = da.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		System.out.println(test);
		
		
		
	}

}
