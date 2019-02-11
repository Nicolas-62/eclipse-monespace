import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tests {

	public static LocalDate parseDate(String toParse) {
		LocalDate dateNaissance;
		dateNaissance = LocalDate.parse(toParse, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return dateNaissance;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val=153400%153000;
		System.out.println(val);
		parseDate("05032008");
		

	}

}
