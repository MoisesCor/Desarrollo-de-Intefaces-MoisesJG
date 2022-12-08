package datos;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import UtilidadesMetodosComunes.Utilidades;
import application.PracticaMain;

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

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	    private TableColumn<Citas, String> DNI;

	    @FXML
	    private TableColumn<Citas, String> sexo;

	    @FXML
	    private  TableView<Citas> tablaDatos;

	    @FXML
	    private TableColumn<Citas, Integer> telefono;

	    @FXML
	    private TextField buscador;
	    @FXML
	    private Button mostrarBOTON;
	    
	    PracticaMain main;
	    Citas cita1;
	    
	  
	    public static ObservableList<Citas> datos = FXCollections.observableArrayList(
    			new Citas("Moisés","Jiménez",30,"mois@gamil.com",66666666,"Hombre","Box1","tendinitis","2022-12-10","1111S"),
    			new Citas("Vanesa","Perez",22,"vane@gamil.com",7777777,"Mujer","Box2","Esguince","2022-10-10","2222T"),
    			new Citas("Raquel","Solear",50,"raquel@gamil.com",555555555,"Mujer","Box1","fractura","2022-10-10","3333V"),
    			new Citas("Victor","Rio",25,"vict@gamil.com",44444444,"Hombre","Box3","cuento","2022-10-10","OOOOR")
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
	        DNI.setCellValueFactory(new PropertyValueFactory<Citas,String>("DNI"));
	    	
	        
	        // Se rellena la tabla con objetos de la clase Citas
	        tablaDatos.setItems(datos);
    

	    }
	    
	   
	    	
	    
	    
	    /*Mï¿½todo para insetar nueva cita/cliente
	     * es llamado desde los diferentes controladores que se encargan de crear nuevas citas
	     * se pasa por parametro la cita y esta es aï¿½adida al observable principal
	     * del que la clase /datos/ControllerPENDIENTESandTERMINADAS.java
	     * se nutre para poder cargar los datos en su propia tabla dando el valor de su observable
	     * el de esta clase */
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
	    

	    /* Clase  que es llamada desde ControllerFormulario
	     * donde si el dni que ha escrito el usuario coincide con alguno que este en la lista
	     *  retorna esa cita para luego bien validar si el dni corresponde con la persona indicada
	     *  o para autorrellenar el formulario*/
	    public static Citas verificarCliente( String dni) {
	    	Citas citaaux=null;
	    	boolean ok=false;
	    
	    		for(Citas aux: datos) {
	    		
	    			if(aux.getDNI().equals(dni)) {
	    				citaaux=aux;
	    				ok=true;
	    			}
	    		}
	    		if(ok) {
	    			return citaaux; 
	    		}else {
	    			Citas vacio = new Citas("","",0,"",0,"","","","","");
	    			return vacio;
	    		}
	    		
		
	    }
	    
  
	    /*Mï¿½todo que se encarga de realizar la busqueda del cliente introducido
	     * y se encarfa de contar cuantas veces aparece en la lista para mostrar
	     * al usuario cuantas citas tiene, si no aparece ninguna vez en la lista
	     * abrirï¿½ un alert indicando que ese dni no esta registrado
	     * pero si existe abrira un modal personalizado haciendo la llamada a su mï¿½todo que esta en esta propia clase
	     * al cual le pasa el cliente buscado, y las veces que aparece*/
	    @FXML
	    void buscarContacto(ActionEvent event) {
	    	 cita1 = new Citas ();
	    	int contador=0;
	    	for(Citas cliente: datos) {
	    		if(cliente.getDNI().equals(buscador.getText())) {
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
	    /*modal informaciï¿½n cliente
	     * donde recibe por parametro la cita y el nï¿½mero de citas
	     * llama a su propio controlador pasandole la escena y los propios datos 
	     * que esta misma recibe del mï¿½todo Buscar*/
	    public boolean mostrarDialoho(Citas cita, int num) {
	    	System.out.println("entra");
	        try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diï¿½logo emergente.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(ControllerDatos.class.getResource("DatosCitas2.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();
	            System.out.println("entra");

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Consulta cliente");
	            dialogStage.initModality(Modality.APPLICATION_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            

	            // accedemos al controlador del dialogo y le pasamos a la persona para poder mostrarla.
	           ControllerDatos2 controller = loader.getController();
	           controller.setDialogStage(dialogStage);// le paso la ventana que necesita el controlador
	            controller.setCitas(cita,num);// paso de la infomaciï¿½n

	          
	            dialogStage.showAndWait(); // como no se cierra ok no va haber hasta que pulse el ok

	            return false;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    
	    public static void borrarCita(Citas borrar) {
	    	System.out.println("entra en borraR "+borrar.getEmail());
	    	
	    	datos.remove(borrar);
	    	
	    }
	    
	    


	


}
