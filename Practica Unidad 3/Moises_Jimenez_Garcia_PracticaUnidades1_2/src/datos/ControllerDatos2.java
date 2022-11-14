package datos;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerDatos2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label apellidosLabel;

    @FXML
    private Label edadLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label numCitas;

    @FXML
    private Label telefonoLabel;
    
    private Stage dialogStage; // esto es porque nos tenemos que crear una nueva ventana todas las ventanas son stage
    private Citas cita;
    private boolean okClicked = false;

    @FXML
    void initialize() {
  

    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setCitas(Citas cita, int num) {
    	this.cita=cita;
    	nombreLabel.setText(cita.getNombre());
    	apellidosLabel.setText(cita.getApellidos());
    	edadLabel.setText(cita.getApellidos());
    	telefonoLabel.setText(Integer.toString(cita.getTelefono()));
    	numCitas.setText(Integer.toString(num));
    	
    }

}