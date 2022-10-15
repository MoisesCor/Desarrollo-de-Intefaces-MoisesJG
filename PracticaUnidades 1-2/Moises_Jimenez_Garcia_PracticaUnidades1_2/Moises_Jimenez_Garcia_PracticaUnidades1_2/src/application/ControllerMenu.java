package application;

import java.io.IOException;
import application.PracticaMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllerMenu {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane rootLayout;
	  @FXML
	    private void initialize() {
	        
	    }
	
	@FXML
	void abrirFormulario(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerMenu.class.getResource("/formulario/FormularioCitas.fxml"));
			GridPane formularioCitas = (GridPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(formularioCitas);
		} catch (IOException e) {
			e.printStackTrace();
		}

	    }
	
	@FXML
	   private void cerrarListado(ActionEvent event) throws IOException { 
		// como hacer para volver a la principal??
	}	
		
		
	    
	
	public BorderPane getRootLayout() {
		return rootLayout;
	}

		// Necesario para poder cargar la escena
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
}
