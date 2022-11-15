package application;

import java.io.IOException;

import UtilidadesMetodosComunes.Utilidades;
import application.PracticaMain;
import datos.ControllerDatos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerMenu {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane rootLayout;
		private GridPane rootLayout2;
		Image image2 = new Image(getClass(). getResourceAsStream("pngwing.com.png"));
			        
	    @FXML
	    private Button entrar;
	    @FXML
	    private PasswordField psw;

	    @FXML
	    private TextField usuario;
	    
	    @FXML
	    private RadioMenuItem idpendientes;


	    
	  @FXML
	    private void initialize() {
		 
	    }
	  
	    @FXML
	    void iniciarSesion(ActionEvent event) {
	    	if(usuario.getText().equals("usuario") && psw.getText().equals("usuario")) {
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
			
				stage.setOnCloseRequest(e-> controllerMeu.cerrarVentana());
				
				Stage ventana =(Stage) this.entrar.getScene().getWindow();
				ventana.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	}else {
	    		 Alert alert = Utilidades.crearAlert(AlertType.ERROR, "ERROR", "Usuario o contraseña incorrectos","vuelva a intentarlo" );
	       	  alert.showAndWait();
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
				stage.getIcons().add(image2);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Moisés Jiménez PracticaUnidad 3");
				stage.show();
				//stage.showAndWait(); // deja ventana bloqueda
				
				
				Stage ventana =(Stage) entrar.getScene().getWindow();
				ventana.close();
			
			} catch (Exception e) {
				
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
		Image image1 = new Image(getClass(). getResourceAsStream("pngwing.com.png"));
		ImageView imag= new ImageView(image1);
		
		imag.setFitHeight(198);
		imag.setFitWidth(300);	
		 VBox vbox=new VBox();
		 vbox.setPrefHeight(200);
		 vbox.setPrefWidth(100);
		 vbox.setAlignment(Pos.CENTER);
		 vbox.getChildren().addAll(imag);
		rootLayout.setCenter(vbox);
		
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
    	
    	 ;
	    		// Más que capturar este evento, lo más común es cerrar 
	    		// manualmente con el método "close" cuando es necesario
	    		//System.out.println("Click a cerrar"); 
	            
	       
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
    
    @FXML
    void abrirTutorial(ActionEvent event) {
    	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerMenu.class.getResource("/tutorial/Tutorial.fxml"));
			TabPane tutorial=(TabPane) loader.load();
			rootLayout.setCenter(tutorial);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
