package datos;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class ControllerPENDIENTESandTERMINADAS {
    @FXML
    private TableView<Citas> tablaPendiID;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Citas, String> boxTab;

    @FXML
    private TableColumn<Citas, String> dniTab;

    @FXML
    private TableColumn<Citas, String> emailTab;

    @FXML
    private TableColumn<Citas, String> fechTab;

    @FXML
    private TableColumn<Citas, String> nombreTa;

    @FXML
    private TableColumn<Citas, Integer> telTab;
    
    @FXML
    void initialize() {
    	
    	
    	// Asociamos cada columna del TableView a una propiedad de la clase Citas 
    	nombreTa.setCellValueFactory(new PropertyValueFactory<Citas,String>("nombre"));
    	emailTab.setCellValueFactory(new PropertyValueFactory<Citas,String>("email"));
    	telTab.setCellValueFactory(new PropertyValueFactory<Citas,Integer>("telefono"));
        boxTab.setCellValueFactory(new PropertyValueFactory<Citas,String>("box"));
        fechTab.setCellValueFactory(new PropertyValueFactory<Citas,String>("fecha"));
        dniTab.setCellValueFactory(new PropertyValueFactory<Citas,String>("DNI"));
        
        tablaPendiID.setItems(cargarDatos());
    

    }
    
    public ObservableList<Citas> cargarDatos() {
    	boolean ok=false;
    	 ObservableList<Citas>pendientes=  ControllerDatos.datos;
    	 ObservableList<Citas> datospendientes = FXCollections.observableArrayList();
    	for(Citas cit: pendientes) {
    		if(calcularFechaPendientes(cit.getFecha())==true) {
    			datospendientes.add(cit);
    			ok=true;
    		}
    		
    	}
		return ok==true?datospendientes:null;

}
    public boolean calcularFechaPendientes(String fecha) {
	      DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      // parsing the string to convert it into date
	      System.out.println("fallo 2");
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
	      
	      return local_date.isAfter(LocalDate.now())?true:false;
	  
    	
    }
    }