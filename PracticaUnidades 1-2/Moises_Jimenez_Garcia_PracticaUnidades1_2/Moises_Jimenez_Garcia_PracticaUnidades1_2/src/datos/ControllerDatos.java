package datos;

import java.net.URL;
import java.util.ResourceBundle;
import datos.Citas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ControllerDatos {

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
	    
	    
	    private ObservableList<Citas> datos = FXCollections.observableArrayList(
    			new Citas("Moisés","Jiménez",30,"mois@gamil.com",66666666,"Hombre","box1","tendinitis","16/10/22"),
    			new Citas("Vanesa","Pérez",22,"vane@gamil.com",7777777,"Mujer","box2","Esguince","16/10/22"),
    			new Citas("Raquel","Solear",50,"raquel@gamil.com",555555555,"Mujer","box1","fractura","17/10/22"),
    			new Citas("Victor","Rio",25,"vict@gamil.com",44444444,"Hombre","box3","cuento","16/10/22")
    			);
	    
	    
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
}
