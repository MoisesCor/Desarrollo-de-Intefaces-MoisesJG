package application;
	
import java.io.IOException;

import UtilidadesMetodosComunes.Utilidades;
import datos.Citas;
import datos.ControllerDatos;
import datos.ControllerDatos2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PracticaMain extends Application {
	 private Stage primaryStage;
	//private BorderPane rootLayout;	
	private GridPane rootLayout2;
	private BorderPane rootLayout;
	Image image1 = new Image(getClass(). getResourceAsStream("pngwing.com.png"));
	Image image2 = new Image(getClass(). getResourceAsStream("pngwing.com.png"));

	@Override
	public void start(Stage primaryStage) { //esto es para las ventanas
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Moisés Jiménez PracticaUnidad 3");
		iniciPrincipal();
		
	}


	public void iniciPrincipal() {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			//FXMLLoader loader = new FXMLLoader();
			FXMLLoader loader2 = new FXMLLoader();
			//loader.setLocation(PracticaMain.class.getResource("Menu.fxml"));
			loader2.setLocation(PracticaMain.class.getResource("InicioSesion.fxml"));
			//rootLayout = (BorderPane) loader.load();
			rootLayout2 = (GridPane) loader2.load();
			
			ControllerMenu controller =  loader2.getController();
			controller.setMain(this);
			
			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout2);
			primaryStage.getIcons().add(image1);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			scene.setOnMouseClicked(
			        new EventHandler<MouseEvent>() {

			            @Override
			            public void handle(MouseEvent event) {
			           System.out.println(event.getPickResult());
			            }
			          });
		//	primaryStage.setTitle("Moisés Jiménez PracticaUnidad 3");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//abrir General
	public void  abrirGeneral() {
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
			stage.getIcons().add(image2);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Moisés Jiménez PracticaUnidad 3");
			stage.show();
			
			//Atajos de teclado
			scene.setOnKeyReleased((KeyEvent keyEvent) -> {
			    System.out.println(" -> " + keyEvent.getCode().toString( )); //traza
			    if(keyEvent.isControlDown()) {
			    	if(keyEvent.getCode().toString( ).equals("a")|| keyEvent.getCode().toString( ).equals("A")) {
			    		Utilidades.modalFormulario();
			    	
			    	}else if ((keyEvent.getCode().toString( ).equals("B")|| keyEvent.getCode().toString( ).equals("b")) ) {
			    			Utilidades.mostrarCita();
			    	}
			    }
			});
			
			
	
			stage.setOnCloseRequest(e-> iniciPrincipal());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    }
	
	
	

	public BorderPane getRootLayout() {
		return rootLayout;
	}


	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}


	public static void main(String[] args) {
		launch(args);
	}

}
