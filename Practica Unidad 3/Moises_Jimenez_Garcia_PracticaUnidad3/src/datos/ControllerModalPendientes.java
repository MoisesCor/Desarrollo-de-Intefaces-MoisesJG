package datos;

import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    	
    	
    	/*Filtro usado en el campo telefono
    	 * solo permite usar números*/
    	
    	venTel.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {	
    	
  			System.out.println("Character: " + e.getCharacter());;
  			
  			if (Character.isLowerCase(e.getCharacter().charAt(0))) {
  				// Comprobamos si es númerico, si no:
  				e.consume(); // lo que hace es  no procesar el caracter lo borra
  			}
  		});	
    	
    	/* listener usado para obtener el valor antiguo del comboBox del modal y el nuevo
    	 * y interactuar con ellos para darle información al usuario de los eventos*/
    	venBox.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> {
        			resultado.setText("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
        		}); 
    	
    }
	
	
	   public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	   /*Recogemos la información del cliente y se la pasamos al modal de editar o borrar
	    * con su casteo de fechas para poder ser usado
	    *  */
	    public void setCitas(Citas cita1) {
	    	  DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		      LocalDate local_date = LocalDate.parse(cita1.getFecha(), JEFormatter);
	    	venNombre.setText(cita1.getNombre());
	    	venTel.setText(Integer.toString(cita1.getTelefono()));
	    	venEm.setText(cita1.getEmail());
	    	venBox.getSelectionModel().select(cita1.getBox());
	    	venDni.setText(cita1.getDNI());
	    	venFech.setValue(local_date);
	    	this.cita=cita1;
	    	
	    }
	    
	    @FXML
	    void cancelarModal(ActionEvent event) {
	    	
	    	dialogStage.close();
	    	
	    }
	    
	    @FXML
	    /* método que llama al método de borrar de controllerDatos (es el central)
	     * le pasa el valor de la cita creada aquí y lo borra de la lista general
	     * he creado un objeto de la clase ControllerPENDIENTESandTERMINADAS ( ese objeto recibe el valor del propio controlador
	     * cuando llama al método borrar, este le pasa su valor, para que seguido pueda acceder el al método propio de la clase
	     * encargado de refrescar la tabla, así en tiempo real se efetuan los cambios)
	     * que es la que contiene la información de esa tabla
	     * para poder llamar a su método*/
	    void borrarCitaModal(ActionEvent event) {
	    	
	    	ControllerDatos.borrarCita(cita);
	    	control.refreshTabla(borrarPendi.getText(),null);
	    	dialogStage.close();
	    	
	    	
	    	
		    }
	    
	    @FXML
	    /*Misma funcionalidad que el anterior pero este edita los campos
	     * de esa cita*/
	    void editarModal(ActionEvent event) {
	    	cita.setEmail(venEm.getText());
	    	cita.setTelefono(Integer.parseInt(venTel.getText()));
	    	cita.setFecha(venFech.getValue().toString());
	    	cita.setBox(venBox.getValue().toString());
	    	control.refreshTabla(editarPendi.getText(),venFech.getValue().toString());
	    	dialogStage.close();
	    }
	    	 

	    }
	    
	


