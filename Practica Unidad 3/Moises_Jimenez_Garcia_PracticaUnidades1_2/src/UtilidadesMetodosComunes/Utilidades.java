package UtilidadesMetodosComunes;

import java.io.IOException;

import application.ControllerMenu;
import application.PracticaMain;
import datos.Citas;
import datos.ControllerDatos;
import datos.ControllerDatos2;
import datos.ControllerModalPendientes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paginatorModal.ControllerPaginator;

public class Utilidades {
	
	/*Clase común para poder ser usadas por todas donde implemento los diferente modales
	 * y un constructor de alertas para poder usarlos más cómodamente*/
	
	  public static  Alert crearAlert(AlertType type, String title, String header, String contextText) {
	    	Alert auxAlert = new Alert(type);
	    	
	    	auxAlert.setTitle(title);
	    	auxAlert.setHeaderText(header);
	    	auxAlert.setContentText(contextText);
	    	
	    	return auxAlert;
	    }
	  
	  public static void modalFormulario() {
		  try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
	        	FXMLLoader loader = new FXMLLoader();
				loader.setLocation(ControllerMenu.class.getResource("/formulario/FormularioCitas.fxml"));
				GridPane page = (GridPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Consulta cliente");
	            dialogStage.initModality(Modality.APPLICATION_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            
	            
	         
	            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok
	        } catch (IOException e) {
	            e.printStackTrace();
	           
	        }
	  }
	  
	 public static void mostrarCita() {
	    	 try {
		            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
	    		 FXMLLoader loader = new FXMLLoader();
	         	loader.setLocation(ControllerDatos.class.getResource("/datos/DatosCitas.fxml"));
	 			SplitPane page= (SplitPane) loader.load();

		            // Create the dialog Stage.
		            Stage dialogStage = new Stage();
		            dialogStage.setTitle("Consulta cliente");
		            dialogStage.initModality(Modality.APPLICATION_MODAL);
		            Scene scene = new Scene(page);
		            dialogStage.setScene(scene);
		            
		            // Show the dialog and wait until the user closes it
		            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok
		        } catch (IOException e) {
		            e.printStackTrace();
		           
		        }
	    }
	 
	 
	 public static void mostrarPendiente() {
    	 try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
    		 FXMLLoader loader = new FXMLLoader();
	 			loader.setLocation(PracticaMain.class.getResource("/datos/Proceso.fxml"));
	 			AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Consulta cliente");
	            dialogStage.initModality(Modality.APPLICATION_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            
	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok
	        } catch (IOException e) {
	            e.printStackTrace();
	           
	        }
    }
	 
	 public static void modalPaginator() {
    	 try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
 			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerPaginator.class.getResource("/paginatorModal/paginator.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("ANTES DE EMPEZAR");
	            dialogStage.initModality(Modality.APPLICATION_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            ControllerPaginator controller = loader.getController();
		           controller.setDialogStage(dialogStage);
	            
	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok
	        } catch (IOException e) {
	            e.printStackTrace();
	           
	        }
    }
	 


}
