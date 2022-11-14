package UtilidadesMetodosComunes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utilidades {
	
	  public static  Alert crearAlert(AlertType type, String title, String header, String contextText) {
	    	Alert auxAlert = new Alert(type);
	    	
	    	auxAlert.setTitle(title);
	    	auxAlert.setHeaderText(header);
	    	auxAlert.setContentText(contextText);
	    	
	    	return auxAlert;
	    }

}
