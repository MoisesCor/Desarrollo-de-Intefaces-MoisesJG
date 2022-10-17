package formulario;


import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.BorderPane;

public class ControllerFormulario {
	private BorderPane rootLayout;
	
  @FXML
  private ComboBox<String> box;

  @FXML
  void initialize() {
	      
	    	box.getItems().addAll("Box 1","Box 2","Box 3");

  }



}
