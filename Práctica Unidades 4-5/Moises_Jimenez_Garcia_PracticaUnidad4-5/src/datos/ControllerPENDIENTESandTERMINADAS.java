package datos;
import java.io.IOException;

import java.net.URL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ResourceBundle;

import application.ControllerMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * Controlador que se encarga de mostrar los datos basados a un filtrado indicado en los distintos métodos
 * @author Moisés Jiménez García
 *
 */
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
        //la tabla se carga con los valores de la general filtrados por este filtro según necesidad
        tablaPendiID.setItems(cargarDatos());
        okk=true;
        // listener de ratón si usuario hace click sobre un campo de la tabla abre el modal
        tablaPendiID.setOnMouseClicked(event -> mostrarVentana(cita));
        // listener de selección si el usuario selecciona un elemento de la tabla se le da ese valor a la cita 
        tablaPendiID.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                	cita=newValue;
                });
        
       
        
       
    

    }
    /**Método que se encarga de actualizar la tabla comprobando en que boton fue pulsado
     *  si borrar o editar, si es EDITAR comprueba que tabla esta seleccionada si 
     *  acabadas o pendientes, y comprueba en cada caso si la fecha ha sido modificada
     *  si la fecha en acabadas es modificada a una fecha mayor esta sera borrada de la tabla
     *  y se vuelve a cargar los datos, en el caso contrario pasa lo mismo pero si la fecha es superior
     *  @param opcion del menu bar seleccionada 
     *  @param fecha de la cita seleccionada
     */
    public void refreshTabla(String opcion, String fecha) {
    	String cualEntra=ControllerMenu.cualPulsaUsuario();
    	// recogemos el index de la selección actual y lo borramos de la tabla
    	int selectedIndex = this.tablaPendiID.getSelectionModel().getSelectedIndex(); 
    	if(opcion.equals("Editar")) {
    		if(cualEntra.equals("pendientes")) {
    			if(calcularFechaPendientes(fecha)) {
    	    		cargarDatos();
    			}else {
    				tablaPendiID.getItems().remove(selectedIndex);
    	    		cargarDatos();
    			}
    		}else if(cualEntra.equals("acabadas")) {
    			if(!calcularFechaPendientes(fecha)) {
    	    		cargarDatos();
    			}else {
    				tablaPendiID.getItems().remove(selectedIndex);
    	    		cargarDatos();
    			}
    		}
    		
    		this.tablaPendiID.refresh();
    		cargarDatos();
    	}else if(opcion.equals("Borrar")) {
    		
        	tablaPendiID.getItems().remove(selectedIndex);
    	}
    	
    	
    	
    }
    
    /**Metodo cargar datos filtrando los datos de la general que tiene un observable que será adjudicado a la tabla
     * con el filtro correspondiente  donde según que pestaña este el usuario carga unos u otros
     * para ser mostrados esto devuelve una lista, si no hay elementos que cumplan las condiciones devuelve la tabla vacía
     * @return lista con las citas existentes
     */
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
    /**Método usado para devolver si la fecha consultada es después que la actualff
     * @param fecha fecha a comparar con la actual
 	*/
    public boolean calcularFechaPendientes(String fecha) {
	      DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
	      
	      return local_date.isAfter(LocalDate.now())?true:false;
	      
	  
    	
    }
    /**
     *  método llamado desde listener para que abra el modal si hay una celsa seleccionada
     * @param cita recogida para cargar el los datos en la ventana
     */
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
	            scene.getStylesheets().add("css/dark.css");
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
    

    
    
    