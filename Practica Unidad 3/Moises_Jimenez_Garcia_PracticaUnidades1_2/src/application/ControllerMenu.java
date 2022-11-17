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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerMenu {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane rootLayout;
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
	    private RadioMenuItem idacabadas;
	    
	    
	   public static String cualPulsa;
	    
	    PracticaMain main;


	    
	  @FXML
	    private void initialize() {
		
 
	    }
	  
	    public void setMain(PracticaMain main) {
	        this.main = main;
	        
	    }
	    
	    String cadenaOpcion="";
	  
	  
	  /* Inicio de sesión donde si el usuario pulsa entrar valida que los campos usuario contraseña son correctos
	   * Si son correctos, abre la siguiente ventana y cierra la actual. De lo contrario abre un modal de error
	   * llamando al método utilidades donde he generado métodos comunes para comodidad
	   * si el usuario cierra la ventana vuelve abrir la de login, llamando a esa misma ventana
	   * gracias a la referenci al main creada*/
	    @FXML
	    void iniciarSesion(ActionEvent event) {
	    	if(usuario.getText().equals("usuario") && psw.getText().equals("usuario")) {
	    		main.abrirGeneral();
	    		Stage ventana =(Stage) this.entrar.getScene().getWindow();
				ventana.close();
	    	}else {
	    		 Alert alert = Utilidades.crearAlert(AlertType.ERROR, "ERROR", "Usuario o contraseña incorrectos","vuelva a intentarlo" );
	       	  alert.showAndWait();
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
    	
    	if(idpendientes.isSelected()) {
    		
    		ControllerMenu.cualPulsa="pendientes";
    	}else if(idacabadas.isSelected()) {
    		
    		ControllerMenu.cualPulsa="acabadas";
    	}
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PracticaMain.class.getResource("/datos/Proceso.fxml"));
			AnchorPane pendiente = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(pendiente);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	

	    }
    
    public static String cualPulsaUsuario() {
    	
		return cualPulsa;
    	
    }
    
    @FXML
    void abrirTutorial(ActionEvent event) {
  	 
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PracticaMain.class.getResource("/tutorial/Tutorial.fxml"));
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
