package estadisticas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(convertirMesesNumeros("2022-10-18"));

	}
	
	 public static int convertirMesesNumeros(String fecha) {
		 DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
	      
	      local_date.getMonthValue();
	      
	      return local_date.getMonthValue();
	      
	  
    	
    }

}
