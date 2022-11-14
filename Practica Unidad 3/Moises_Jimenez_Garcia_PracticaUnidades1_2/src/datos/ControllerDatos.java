package datos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UtilidadesMetodosComunes.Utilidades;
import application.PracticaMain;
import datos.Citas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerDatos {
	  private PracticaMain mainApp;


	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	 @FXML
	    private TableColumn<Citas, String> apellidos;

	    @FXML
	    private TableColumn<Citas, String> box;

	    @FXML
	    private TableColumn<Citas, Integer>edad;

	    @FXML
	    private TableColumn<Citas, String> email;

	    @FXML
	    private TableColumn<Citas, String> fecha;

	    @FXML
	    private TableColumn<Citas, String> nombre;

	    @FXML
	    private TableColumn<Citas, String> observaciones;

	    @FXML
	    private TableColumn<Citas, String> sexo;

	    @FXML
	    private TableView<Citas> tablaDatos;

	    @FXML
	    private TableColumn<Citas, Integer> telefono;

	    @FXML
	    private TextField buscador;
	    @FXML
	    private Button mostrarBOTON;
	    
	    PracticaMain main;
	    Citas cita1;
	    
	  
	    public static ObservableList<Citas> datos = FXCollections.observableArrayList(
    			new Citas("Mois�s","Jim�nez",30,"mois@gamil.com",66666666,"Hombre","box1","tendinitis","16/10/22"),
    			new Citas("Vanesa","P�rez",22,"vane@gamil.com",7777777,"Mujer","box2","Esguince","16/10/22"),
    			new Citas("Raquel","Solear",50,"raquel@gamil.com",555555555,"Mujer","box1","fractura","17/10/22"),
    			new Citas("Victor","Rio",25,"vict@gamil.com",44444444,"Hombre","box3","cuento","16/10/22")
    			);
	    
		public ObservableList<Citas> getDatos() {
			return datos;
		}
	    
	    
	    @FXML
	    void initialize() {
	    	
	    	// Asociamos cada columna del TableView a una propiedad de la clase Citas 
	    	nombre.setCellValueFactory(new PropertyValueFactory<Citas,String>("nombre"));
	        apellidos.setCellValueFactory(new PropertyValueFactory<Citas,String>("apellidos"));
	        edad.setCellValueFactory(new PropertyValueFactory<Citas,Integer>("edad"));
	        email.setCellValueFactory(new PropertyValueFactory<Citas,String>("email"));
	        telefono.setCellValueFactory(new PropertyValueFactory<Citas,Integer>("telefono"));
	        sexo.setCellValueFactory(new PropertyValueFactory<Citas,String>("sexo"));
	        box.setCellValueFactory(new PropertyValueFactory<Citas,String>("box"));
	        observaciones.setCellValueFactory(new PropertyValueFactory<Citas,String>("observaciones"));
	        fecha.setCellValueFactory(new PropertyValueFactory<Citas,String>("fecha"));
	    	
	        
	        // Se rellena la tabla con objetos de la clase Citas
	        tablaDatos.setItems(datos);
	        
	        

	    }
	    
	    public static boolean nuevoCliente(Citas cita) {
	    	try {
				datos.add(cita);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
	    }
	    
   @FXML
	    void buscarContacto(ActionEvent event) {
	    	System.out.println("entra");
	    	 cita1 = new Citas ();
	    	int contador=0;
	    	for(Citas cliente: datos) {
	    		if(cliente.getNombre().equals(buscador.getText())) {
	    			cita1=cliente;
	    			 contador++;
	    		}
	    	
	    			
	    		}
	    		
	    	if(!(contador==0)) {
	    	mostrarDialoho(cita1,contador);
	    	}else {
	    		Alert alert = Utilidades.crearAlert(AlertType.ERROR, "ERROR", "Paciente no encontrado", buscador.getText());
	    		alert.showAndWait();
	   }
   }
	    
	    public boolean mostrarDialoho(Citas cita, int num) {
	    	System.out.println("entra");
	        try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de di�logo emergente.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(ControllerDatos.class.getResource("DatosCitas2.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();
	            System.out.println("entra");

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Consulta cliente");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            

	            // accedemos al controlador del dialogo y le pasamos a la persona para poder a�adir.
	           ControllerDatos2 controller = loader.getController();
	           controller.setDialogStage(dialogStage);// le paso la ventana que necesita el controlador
	            controller.setCitas(cita,num);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok

	            return false;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    


	


}
