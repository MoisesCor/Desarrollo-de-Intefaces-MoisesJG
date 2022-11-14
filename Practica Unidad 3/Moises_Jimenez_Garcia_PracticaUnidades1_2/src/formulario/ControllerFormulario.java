package formulario;


import java.text.SimpleDateFormat;

import UtilidadesMetodosComunes.Utilidades;
import datos.Citas;
import datos.ControllerDatos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class ControllerFormulario {
	private BorderPane rootLayout;
	
  @FXML
  private ComboBox<String> box;
  @FXML
  private Button deshacerBotonFormulario;
  @FXML
  private TextField formularioApellido;

  @FXML
  private TextField formularioEdad;

  @FXML
  private TextField formularioEmail;

  @FXML
  private DatePicker formularioFecha;

  @FXML
  private RadioButton formularioHombre;

  @FXML
  private RadioButton formularioMujer;

  @FXML
  private TextField formularioNombre;

  @FXML
  private TextField formularioTelf;
  
  @FXML
  private ToggleGroup Sexo;

  @FXML
  private TextArea formularioObservaciones;
  
 
  ;

  @FXML
  void initialize() {
	      
	    	box.getItems().addAll("Box 1","Box 2","Box 3");
	    	
	    /*Creamos un modal de tipo confirmación, para que el usuario verifique que es lo que de verdad desea hacer */
	    Alert deshacer=Utilidades.crearAlert(AlertType.CONFIRMATION, "Deshacer",
	    "Requerimiento de confirmación", "¿Desea borrar lo escrito?");
	    
	    deshacerBotonFormulario.setOnAction(e->{
	    	deshacer.showAndWait().ifPresent(valor->{		
    			if (valor == ButtonType.OK) {
    				formularioNombre.setText("");
    				formularioApellido.setText("");
    				formularioEdad.setText("");
    				formularioFecha.setValue(null);
    				formularioNombre.requestFocus();
    				formularioMujer.setSelected(false);
    				formularioHombre.setSelected(false);
    				formularioTelf.setText("");
    				formularioEmail.setText("");
    				formularioObservaciones.setText("");
    				box.setValue(null);
    			
    		    }
    			
    		});
    	});

  }
  
  @FXML
  private void guardarCita() {
		
		 if (validarDatos()) {
		 	
			 RadioButton selectedRadioButton = (RadioButton) Sexo.getSelectedToggle();
	    	 String sexo = selectedRadioButton.getText();
	    	 String nombre=(formularioNombre.getText());
	    	 System.out.println(nombre);
	    	 String apellido=(formularioApellido.getText());
	    	 String email=(formularioEmail.getText());
	    	 Integer edad=(Integer.parseInt(formularioEdad.getText()));
	    	 String obser=(formularioObservaciones.getText());
	    	 String boxx = box.getValue();
	    	 Integer tlf=(Integer.parseInt(formularioTelf.getText()));
	    	 
	    	 Citas cita= new Citas(nombre,apellido,edad,email,tlf,sexo,boxx,obser,"16/10/22");
	    	
	    	if(ControllerDatos.nuevoCliente(cita)) {
	    		Alert exito= Utilidades.crearAlert(AlertType.INFORMATION, "CONFIRMACIÓN", "Cita añadida", "correctamente");
	    		exito.showAndWait();
	    		formularioNombre.setText("");
				formularioApellido.setText("");
				formularioEdad.setText("");
				formularioFecha.setValue(null);
				formularioNombre.requestFocus();
				formularioMujer.setSelected(false);
				formularioHombre.setSelected(false);
				formularioTelf.setText("");
				formularioEmail.setText("");
				formularioObservaciones.setText("");
				box.setValue(null);
	    	}
	        
	     } 
      }


private boolean validarDatos() {
	String camposFaltan="";
	if(formularioApellido.getText().trim()==null || formularioApellido.getText().length() == 0) {
		camposFaltan+="Campo apellido sin intruducir\n";
	}
	if(formularioNombre.getText().trim()==null || formularioNombre.getText().length()==0 ) {
		camposFaltan+="Campo nombre sin intruducir\n";
	}
	if(formularioEmail.getText().trim()==null || formularioEmail.getText().length()==0) {
		camposFaltan+="Campo email sin intruducir\n";
	}
	if(formularioTelf.getText().trim()==null|| formularioTelf.getText().length()==0 ) {
		camposFaltan+="Campo telefono sin intruducir\n";
	}
	if(formularioFecha.getValue()==null) {
		camposFaltan+="Campo fecha sin intruducir\n";
	}
	if(formularioEdad.getText().trim()==null || formularioEdad.getText().length()==0) {
		camposFaltan+="Campo edad sin intruducir\n";
	}
	if(Sexo.getSelectedToggle()==null) {
		camposFaltan+="sexo sin intruducir\n";
	}
	if(box.getValue()==null) {
		camposFaltan+="box sin intruducir\n";
	}
	 if (camposFaltan.length() == 0) {
         return true;
     } else {
    	 Alert alert = Utilidades.crearAlert(AlertType.ERROR, "ERROR", "Falta por introducir", camposFaltan);
    	  alert.showAndWait();
	
	
	return false;
}




}
}
