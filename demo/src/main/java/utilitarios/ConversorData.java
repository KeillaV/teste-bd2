package utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {

	public static Date converterData(String dataString) {
		Date data = null;
  
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			data = formato.parse(dataString);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	}
	
}
