package datos;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.ControllerMenu;
import javafx.beans.WeakInvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class ControllerPENDIENTESandTERMINADAS {
	
    @FXML
    private  TableView<Citas> tablaPendiID;
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
    
    boolean okk=true;
    Citas cita;
    

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
        okk=true;
        // evento de ratón si usuario pulsa sobre un campo de la tabla abre el modal
        tablaPendiID.setOnMouseClicked(event -> mostrarVentana(cita));
        // evento de selección si el usuario selecciona un elemento de la tabla se le da ese valor a la cita 
        tablaPendiID.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                	cita=newValue;
                });
        
       
        
       
    

    }
    
    public void refreshTabla(String opcion) {
    	
    	if(opcion.equals("Editar")) {
    		cargarDatos();
    		this.tablaPendiID.refresh();
    	}else if(opcion.equals("Borrar")) {
    		int selectedIndex = this.tablaPendiID.getSelectionModel().getSelectedIndex(); 	
        	tablaPendiID.getItems().remove(selectedIndex);
    	}
    	
    	
    	
    }
    
    public ObservableList<Citas> cargarDatos() {
    	;
    	String cualEntra=ControllerMenu.cualPulsaUsuario();
    	boolean ok=false;
    	 ObservableList<Citas>pendientes=  ControllerDatos.datos;
    	 ObservableList<Citas> datospendientes = FXCollections.observableArrayList();
    	for(Citas cit: pendientes) {
    		if(cualEntra.equals("pendientes")) {
    		if(calcularFechaPendientes(cit.getFecha())==true) {
    			datospendientes.add(cit);
    			ok=true;
    		}
    		}else if(cualEntra.equals("acabadas")) {
    			if(calcularFechaPendientes(cit.getFecha())==false) {
        			datospendientes.add(cit);
        			ok=true;
        		}
    		}
    	}
		return ok==true?datospendientes:null;

}
    public boolean calcularFechaPendientes(String fecha) {
	      DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      // parsing the string to convert it into date
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
	      
	      return local_date.isAfter(LocalDate.now())?true:false;
	      
	  
    	
    }
    
    private void mostrarVentana(Citas cita) {
    	
   	 try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(ControllerDatos.class.getResource("ventanaPendientes.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();
	            System.out.println("entra");
	           

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Consulta cliente");
	            dialogStage.initModality(Modality.APPLICATION_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            
	            ControllerModalPendientes controller = loader.getController();
		          controller.setDialogStage(dialogStage);// le paso la ventana que necesita el controlador
		            controller.setCitas(cita);
		            controller.setControlDatos(this);
	            

	          

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok
	            
	          
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
   }

    }
    

    
    
    