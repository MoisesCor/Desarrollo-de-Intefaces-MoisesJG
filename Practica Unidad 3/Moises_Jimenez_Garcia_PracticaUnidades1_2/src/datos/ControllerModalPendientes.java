package datos;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import application.ControllerMenu;
import application.PracticaMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ControllerModalPendientes {
	
	ControllerPENDIENTESandTERMINADAS control;
	

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> venBox;

	    @FXML
	    private TextField venDni;

	    @FXML
	    private TextField venEm;

	    @FXML
	    private DatePicker venFech;

	    @FXML
	    private TextField venNombre;

	    @FXML
	    private TextField venTel;
	    @FXML
	    private Button buttonBorrar;
		@FXML
		private Text resultado;
		
	    @FXML
	    private Button borrarPendi;

	    @FXML
	    private Button editarPendi;
	
	
	
	
    private Stage dialogStage; // esto es porque nos tenemos que crear una nueva ventana todas las ventanas son stage
    private Citas cita;
    
    public void setControlDatos(ControllerPENDIENTESandTERMINADAS control) {
        this.control = control;
        
    }
    @FXML
    void initialize() {
    	venBox.getItems().addAll("Box 1","Box 2","Box 3");
    	
    	
    	/*Validamos que el teléfono solo sea numérico*/
    	
    	venTel.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {	
    	
  			System.out.println("Character: " + e.getCharacter());;
  			
  			if (Character.isLowerCase(e.getCharacter().charAt(0))) {
  				// Comprobamos si es numérico entonces se consume el evento
  				e.consume(); // esto lo que hace es  no procesar el caracter, como que lo borra
  			}
  		});	
    	
    	
    	venBox.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> {
        			resultado.setText("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
        		}); 
    	
    }
	
	
	   public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	    public void setCitas(Citas cita1) {
	    	  DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		      // parsing the string to convert it into date
		      LocalDate local_date = LocalDate.parse(cita1.getFecha(), JEFormatter);
	    	venNombre.setText(cita1.getNombre());
	    	venTel.setText(Integer.toString(cita1.getTelefono()));
	    	venEm.setText(cita1.getEmail());
	    	venBox.getSelectionModel().select(cita1.getBox());
	    	//venBox.setValue(cita1.getBox());
	    	venDni.setText(cita1.getDNI());
	    	venFech.setValue(local_date);
	    	this.cita=cita1;
	    	
	    }
	    
	    @FXML
	    void cancelarModal(ActionEvent event) {
	    	
	    	dialogStage.close();
	    	
	    }
	    
	    @FXML
	    void borrarCitaModal(ActionEvent event) {
	    	
	    	ControllerDatos.borrarCita(cita);
	    	control.refreshTabla(borrarPendi.getText());
	    	dialogStage.close();
	    	
	    	
	    	
		    }
	    
	    @FXML
	    void editarModal(ActionEvent event) {
	    	cita.setEmail(venEm.getText());
	    	cita.setTelefono(Integer.parseInt(venTel.getText()));
	    	cita.setFecha(venFech.getValue().toString());
	    	cita.setBox(venBox.getValue().toString());
	    	control.refreshTabla(editarPendi.getText());
	    	dialogStage.close();
	    }
	    	 

	    }
	    
	


