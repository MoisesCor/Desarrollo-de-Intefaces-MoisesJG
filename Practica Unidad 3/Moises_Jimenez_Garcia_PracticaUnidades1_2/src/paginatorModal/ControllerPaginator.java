package paginatorModal;

import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.PracticaMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ControllerPaginator {
	
	
	
    private ArrayList<String> atajos = new ArrayList<String>();
    private static final int limite = 2;
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pagination paginator;

    @FXML
    private ProgressIndicator progresoIndicado;
    
    @FXML
    private Button okBoton;
    
    private Stage dialogStage;

    @FXML
    /*Clase adaptada de un ejercicio visto en clase una vez entendida, para añadir una forma de avisar al usuario
     * de los atajos que encontrará en la aplicación antes de usarla */
    void initialize() {
    	// Se inicializa el listado
    	this.atajosMe(this.atajos);
    	
    	// Se calcula el número de páginas en función de los ítems del listado
    	// Si el número no es divisor del número de ítems, entonces se añade una página
    	paginator.setPageCount((atajos.size() / limite) + 
    			(((atajos.size() % limite) > 0)?1:0));
    	    	    	
    	paginator.setPageFactory((Integer pageIndex) -> {
    		return createPage(pageIndex);   
        });
    	
    	// Cada vez que se selecciona una página se cambia la barra de progreso
    	paginator.currentPageIndexProperty().addListener(
    		(observable, oldValue, newValue) -> {
    			progresoIndicado.setProgress((newValue.doubleValue() + 1) / 
    					paginator.getPageCount());    			
    		});
    	    	 	
    	// Valor inicial de la barra de progreso
    	progresoIndicado.setProgress((double) 1 / paginator.getPageCount()); 
    	okBoton.setOnAction(e->{
    		this.dialogStage.close();
    	});

    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    private VBox createPage(int pageIndex) {        
        // Ítems por pagina
        VBox box = new VBox(); // Contenedor
        int page = pageIndex * limite;
        
        // Se recorren los ítems sumando el número de páginas, o el límite de ítems del listado
        int limit = Math.min(page + limite, atajos.size());
        for (int i = page; i < limit; i++) {
        	// Crea un Label
            Label text = new Label( (i+1) + ".- " + atajos.get(i));
               
            // Se añade el label al VBox
            box.getChildren().add(text);           
        }
        
        return box;
    }
    
    
    private void atajosMe(ArrayList<String> atajos) {
    	atajos.add("CONTROL+A abre citar");
    	atajos.add("CONTROL+B abre todas las citas");
    	atajos.add("CAPTURAS DE RATÓN");
    	atajos.add("MÁS CAPTURAS DE TECLADO");
   	 
 
   }
    // Creación de la visra es llamado desde la principal cuando pulsa entrar
    public static void modalPaginator() {
   	 try {
	            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerPaginator.class.getResource("/paginatorModal/paginator.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("ANTES DE EMPEZAR");
	            dialogStage.initModality(Modality.APPLICATION_MODAL);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            
	            dialogStage.showAndWait();
	        } catch (IOException e) {
	            e.printStackTrace();
	           
	        }
   }

}
