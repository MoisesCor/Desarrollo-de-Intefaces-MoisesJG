package application;

import java.io.IOException;
import application.PracticaMain;
import datos.ControllerDatos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllerMenu {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane rootLayout;
		private GridPane rootLayout2;
	    @FXML
	    private Button entrar;
	    
	  @FXML
	    private void initialize() {
	        
	    }
	  
	    @FXML
	    void iniciarSesion(ActionEvent event) {
	    	try {
				// Carga el diseño del archivo FXML en la variable rootLayout
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(PracticaMain.class.getResource("Menu.fxml"));
				rootLayout = (BorderPane) loader.load();
			
				
				// Pasamos al controlador de menu el objeto con el BorderPane principal
				ControllerMenu controllerMeu = loader.getController();
				controllerMeu.setRootLayout(rootLayout);

				// Mostramos la escena del BorderPane de la variable rootLayot
				Scene scene = new Scene(rootLayout);
				Stage stage= new Stage();
				stage.setScene(scene);
				stage.setTitle("Moisés Jiménez PracticaUnidades 1-2");
				stage.show();
			
				stage.setOnCloseRequest(e-> controllerMeu.cerrarVentana());
				
				Stage ventana =(Stage) this.entrar.getScene().getWindow();
				ventana.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
	    void cerrarVentana() {
	    	
	    	try {
				// Carga el diseño del archivo FXML en la variable rootLayout
	    		FXMLLoader loader2 = new FXMLLoader();
				loader2.setLocation(PracticaMain.class.getResource("InicioSesion.fxml"));
			
				rootLayout2 = (GridPane) loader2.load();
				
				

				// Mostramos la escena del BorderPane de la variable rootLayot
				Scene scene = new Scene(rootLayout2);
				Stage stage= new Stage();
				stage.setScene(scene);
				stage.setTitle("Moisés Jiménez PracticaUnidades 1-2");
				stage.show();
				
				
				Stage ventana =(Stage) this.entrar.getScene().getWindow();
				ventana.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		System.out.println("cerrar");
	}
    @FXML
    void abrirTodasLasCitas(ActionEvent event) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(ControllerDatos.class.getResource("/datos/DatosCitas.fxml"));
			SplitPane datosCitas= (SplitPane) loader.load();
			
			rootLayout.setCenter(datosCitas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void abrirPendientes(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerMenu.class.getResource("/datos/Proceso.fxml"));
			AnchorPane pendiente = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(pendiente);
		} catch (IOException e) {
			e.printStackTrace();
		}

	    }
		
		
	    
	
	public BorderPane getRootLayout() {
		return rootLayout;
	}

		// Necesario para poder cargar la escena
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
}
