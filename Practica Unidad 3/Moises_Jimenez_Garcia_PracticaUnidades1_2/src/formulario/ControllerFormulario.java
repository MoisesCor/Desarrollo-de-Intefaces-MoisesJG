package formulario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import UtilidadesMetodosComunes.Utilidades;
import datos.Citas;
import datos.ControllerDatos;
import javafx.event.ActionEvent;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ControllerFormulario {
	
	
  @FXML
  private ComboBox<String> box;
  @FXML
  private Button deshacerBotonFormulario;
  
  @FXML
  private Button guardarBotonFormulario;
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
  private TextField formularioDNI;
  
  @FXML
  private ToggleGroup Sexo;

  @FXML
  private TextArea formularioObservaciones;
  double dd;
  
  int contador=0;
  
 
  ;

  @FXML
  void initialize() {
	  dd=deshacerBotonFormulario.getPrefHeight();
	 
	  /*A continuaci�n 4 eventos de raton si pasa por encima del alguno de los botones aumentan su tama�o
	   * si dejan de estar encima disminuye su tama�o*/
	  deshacerBotonFormulario.setOnMouseEntered(deshacer->{
		  deshacerBotonFormulario.setPrefHeight(70);
	  });
	  
	  deshacerBotonFormulario.setOnMouseExited(deshacer->{
		  deshacerBotonFormulario.setPrefHeight(dd);
	  });
	  
	
	  guardarBotonFormulario.setOnMouseEntered(deshacer->{
		  guardarBotonFormulario.setPrefHeight(70);
	  });
	  
	  guardarBotonFormulario.setOnMouseExited(deshacer->{
		  guardarBotonFormulario.setPrefHeight(dd);
	  });
	  formularioDNI.requestFocus();
	    	box.getItems().addAll("Box 1","Box 2","Box 3");
	    	
	    /*Creamos un modal de tipo confirmaci�n, para que el usuario verifique que es lo que de verdad desea hacer */
	    Alert deshacer=Utilidades.crearAlert(AlertType.CONFIRMATION, "Deshacer",
	    "Requerimiento de confirmaci�n", "�Desea borrar lo escrito?");
	    
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
    				formularioDNI.setText("");
    				formularioObservaciones.setText("");
    				box.setValue(null);
    			
    		    }
    			
    		});
    	});
	    
	    /*Creamos FILTRO para validar que introduce el usuario en los campos telefono y edad
	     * con ello no permitimos que introduzca campos no num�ricos*/
	    formularioTelf.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {				
			System.out.println("Character tel�fono: " + e.getCharacter());
			if (Character.isLowerCase(e.getCharacter().charAt(0))) {
				// Si descomenta esta l�nea entonces s� que se valida porque es el �ltimo evento que se genera
				e.consume(); 
				
			}
		});	
	   
	
		// Manejador solo numeros y mayusculas
	    formularioDNI.addEventHandler(KeyEvent.KEY_TYPED, (event) -> {
    		int numberCode = (int) event.getCharacter().charAt(0);
    		
    		if (((numberCode < 65) || (numberCode > 90)) && Character.isLowerCase(event.getCharacter().charAt(0))) {
    			System.out.println("ENTRAAAAAAA");
    			event.consume();
    			Alert alert= Utilidades.crearAlert(AlertType.ERROR, "Error", "Solo n�meros y letras mayusculas", "intentalo");
    			alert.showAndWait();
    		}
    		});	
    					
		
	    //Filtro solo n�meros
	    formularioEdad.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {				
			System.out.println("Character edad: " + e.getCharacter());
			if (Character.isLowerCase(e.getCharacter().charAt(0))) {
				System.out.println("traza "+e);
				e.consume(); 
			}
		});	
	    

  }
  
  @FXML
  /*M�todo que una vez validados los datos crea una nueva cita y llama al metodo de ese controlador
   * e introduce la cita, genera un modal de informaci�n avisando que ha sido correctamente y vuelve a poner
   * todos los campos a null*/
  private void guardarCita() throws NumberFormatException, ParseException {
		
		 if (validarDatos()) {
		 	
			 RadioButton selectedRadioButton = (RadioButton) Sexo.getSelectedToggle();
	    	 String sexo = selectedRadioButton.getText();
	    	 String nombre=(formularioNombre.getText());
	    	 String apellido=(formularioApellido.getText());
	    	 String email=(formularioEmail.getText());
	    	 Integer edad=(Integer.parseInt(formularioEdad.getText()));
	    	 String obser=(formularioObservaciones.getText());
	    	 String dni=(formularioDNI.getText());
	    	 String boxx = box.getValue();
	    	 String fecha=formularioFecha.getValue().toString();
	    	 Integer tlf=(Integer.parseInt(formularioTelf.getText()));
	    	 
	    	 Citas cita= new Citas(nombre,apellido,edad,email,tlf,sexo,boxx,obser,fecha,dni);
	    	
	    	if(ControllerDatos.nuevoCliente(cita)) {
	    		Alert exito= Utilidades.crearAlert(AlertType.INFORMATION, "CONFIRMACI�N", "Cita a�adida", "correctamente");
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

/*M�todo validar datos a continuaci�n se explicara dentro del propio m�todo el que considero m�s enrevesado:*/
private boolean validarDatos() throws ParseException {
	String camposFaltan="";
	boolean error=false;
	
	
	
	if(formularioApellido.getText().trim()==null || formularioApellido.getText().length() == 0) {
		camposFaltan+="Campo apellido sin intruducir\n";
		error=true;
	}
	if(formularioNombre.getText().trim()==null || formularioNombre.getText().length()==0 ) {
		camposFaltan+="Campo nombre sin intruducir\n";
		error=true;
	}
	if(formularioEmail.getText().trim()==null || formularioEmail.getText().length()==0) {
		camposFaltan+="Campo email sin intruducir\n";
		error=true;
	}
	if(formularioTelf.getText().trim()==null|| formularioTelf.getText().length()==0 ) {
		camposFaltan+="Campo telefono sin intruducir\n";
		error=true;
	}
	if(formularioFecha.getValue()==null) {
		camposFaltan+="Campo fecha sin intruducir\n";
		
		error=true;
	}
	if(formularioEdad.getText().trim()==null || formularioEdad.getText().length()==0) {
		camposFaltan+="Campo edad sin intruducir\n";
		error=true;
	}
	if(formularioDNI.getText().trim()==null || formularioDNI.getText().length()==0) {
		camposFaltan+="Campo DNI sin intruducir\n";
		error=true;
	}
	if(Sexo.getSelectedToggle()==null) {
		camposFaltan+="sexo sin intruducir\n";
		error=true;
	}
	if(box.getValue()==null) {
		camposFaltan+="box sin intruducir\n";
		error=true;
	}
	/*Nos creamos un objeto cliente a partir del DNI introduccido por usuario*/
	Citas cliente= ControllerDatos.verificarCliente(formularioDNI.getText().trim());
	// Comprobamos que no se haya cometido errores, y que el nombre del cliente del objeto no sea vac�o
	if(error==false && !cliente.getNombre().equals("vacio")) {
		/*Una vez comprobado y pasado el filtro, ahora si el nombre introduccido por el usuario
		 * es diferente al que  que tiene el cliente de la nueva cita
		 * si es diferente es un error ya que hemos filtrado por DNI y el nombre de esa persona debe coincidir con su DNI*/
		if(!cliente.getNombre().equals(formularioNombre.getText().trim())) {
			
			camposFaltan="El DNI introducido ya esta adjudicado a otro paciente (Debe coincidir el nombre con el dni)\n";
			error=true;
		}{
			error=false;
		}
		
	}
		
	 if (camposFaltan.length() == 0 && error==false) {
		 
         return true;
     } else {
    	 Alert alert = Utilidades.crearAlert(AlertType.ERROR, "ERROR", "Falta por introducir", camposFaltan);
    	  alert.showAndWait();
	
	
	return false;
}
	 
	
}

@FXML
/*Evento asociado al campo DNI el usuario puede introducir un dni al pulsar intro
 * en ese campo se comprueba si pertenece a alg�n cliente si es as� autorrellena los campos
 * con la informaci�n de ese cliente*/
void rellenarAutomatico(ActionEvent event) {
	
	Citas auux= ControllerDatos.verificarCliente(formularioDNI.getText().trim());
	if(!auux.getNombre().equals("")) {
		formularioNombre.setText(auux.getNombre());
		formularioApellido.setText(auux.getApellidos());
		formularioEdad.setText(Integer.toString(auux.getEdad()));
		formularioFecha.setValue(null);
		if(auux.getSexo().equals("Hombre")) {
			formularioHombre.setSelected(true);
		}else {
			formularioMujer.setSelected(true);
		}
		
		formularioTelf.setText(Integer.toString(auux.getTelefono()));
		formularioEmail.setText(auux.getEmail());
		formularioObservaciones.setText("");
		box.setValue(null);
	}else {
		Alert alert= Utilidades.crearAlert(AlertType.WARNING, "DNI NO REGISTRADO",formularioDNI.getText().trim() ,"incorrecto");
		alert.showAndWait();
	}
}


}
