package datos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ControllerMenu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControllerDatos2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  TextField apellidosLabel;

    @FXML
    private  TextField edadLabel;

    @FXML
    private  TextField emailLabel;

    @FXML
    private  TextField nombreLabel;

    @FXML
    private  Label numCitas;

    @FXML
    private  TextField telefonoLabel;
    
    
    private Stage dialogStage; // esto es porque nos tenemos que crear una nueva ventana todas las ventanas son stage
    private Citas cita;

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
    	edadLabel.setText(Integer.toString(cita.getEdad()));
    	telefonoLabel.setText(Integer.toString(cita.getTelefono()));
    	emailLabel.setText(cita.getEmail());
    	numCitas.setText(Integer.toString(num));
    	
    }
    
    @FXML
    private void salirConsulta() {
        dialogStage.close();
    }
    
    @FXML
    private void citarDefecto() {
       ControllerDatos.nuevoCliente(cita);
       dialogStage.close();
    }
    
    @FXML
    private void editarPaciente() {
       ControllerDatos.nuevoCliente(cita);
       dialogStage.close();
    }
    
  

}