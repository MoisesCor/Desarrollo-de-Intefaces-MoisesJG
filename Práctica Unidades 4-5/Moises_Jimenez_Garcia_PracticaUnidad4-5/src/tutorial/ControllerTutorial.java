package tutorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ListView;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.stage.Modality;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import UtilidadesMetodosComunes.Utilidades;
import application.ControllerMenu;


public class ControllerTutorial {
	String resultado;

    @FXML
    private Button buttonid;

	
	 @FXML
	    private TreeView<String> treeCarpetas;
	 @FXML
	    private ChoiceBox<String> choice1;
	 

	    @FXML
	    private ListView<String> lista;
	    public static final ObservableList<String> param = FXCollections.observableArrayList();
	 
	 private final Node rootIcon = new ImageView(
		        new Image(getClass().getResourceAsStream("icon1.JPG")));
	 private final Node rootIcon2 = new ImageView(
		        new Image(getClass().getResourceAsStream("icon1.JPG")));
	 private final Node rootIcon3 = new ImageView(
		        new Image(getClass().getResourceAsStream("icon1.JPG")));
	 
	 @FXML
	    void initialize() {
		 TreeItem<String> rootItem = new TreeItem<String> ("Datos",rootIcon); // aquí en el cosntructor le metes la imagen
		 TreeItem<String> rootItem2 = new TreeItem<String> ("Pacientes",rootIcon2);
		 TreeItem<String> rootItem3 = new TreeItem<String> ("Materiales",rootIcon3);
		 rootItem2.getChildren().add(new TreeItem<String> ("Nuevos"));
		 rootItem2.getChildren().add(new TreeItem<String> ("Antiguos"));
		 rootItem3.getChildren().add(new TreeItem<String> ("Cremas"));
		 rootItem3.getChildren().add(new TreeItem<String> ("Vendas"));
	        rootItem.getChildren().add(rootItem2);
	        rootItem.getChildren().add(rootItem3);     
	        treeCarpetas.setCellFactory(TextFieldTreeCell.forTreeView());
	        rootItem.setExpanded(true);
	        treeCarpetas.setRoot(rootItem);
	        
	     
	        
	        //choice
	        choice1.getItems().addAll("1 horas semana","2 horas semana","+ 2 horas semana");
	        choice1.setValue("Tiempo de uso");
	        
	        
	        //Lista
	        lista.setEditable(true);
	        lista.getItems().addAll("Recomendarías la aplicación","Te facilita el trabajo","Funciona siempre bien","Es facil de usar","Te gusta el diseño");
	      
	        //lisener para obtener el nuevo valor
	        lista.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> resultado=newValue);

	    }
	 
	  @FXML
	  
	  // Evento que nos crea un modal donde el usuario pueda contestar a las preguntas
	    void mostrarDialogo(MouseEvent event) {
		 
		  
	    	ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>("Siempre","Alguna vez","Nunca");
	    	choiceDialog.initModality(Modality.APPLICATION_MODAL); 
	    	choiceDialog.setTitle("Cuestionario");
	    	choiceDialog.setHeaderText(resultado);
			
	    	//lisener que nos recoje  la posición del actual selección de la lista, y cambiamos el valor por lo elegido
	    	choiceDialog.showAndWait().ifPresent(response -> {
				// Limpiamos la selección actual y seleccionamos el ítem del combo
	    		System.out.println(response);
	    		lista.getSelectionModel().getSelectedIndex();
	    		lista.getItems().set(lista.getSelectionModel().getSelectedIndex(),response);
	    		
	    		
	    	});
	    }
	  
	 
	 
	 //Métodos para hacer el link funcional, obtenido importando la clase desktop
	 
	    @FXML
	    void irVinculo(ActionEvent event) {
	    	
	    	try {
	    	
	    		Desktop.getDesktop().browse(new URI("https://github.com/MoisesCor/Desarrollo-de-Intefaces-MoisesJG"));
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void irVinculo2(ActionEvent event) {
	    	
	    	try {
	    	
	    		Desktop.getDesktop().browse(new URI("https://ast.wikipedia.org/wiki/Fisioterapia"));
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void irVinculo3(ActionEvent event) {
	    	
	    	try {
	    	
	    		Desktop.getDesktop().browse(new URI("https://www.educa2.madrid.org/web/centro.ies.piobaroja.madrid"));
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    /*Siguientes métodos encargados de abrir los modales*/
	    @FXML
	    void mostrarFormulario(ActionEvent event) {
	    	Utilidades.modalFormulario();
	    }
	    
	    @FXML
	    void mostrarAcabadas(ActionEvent event) {
	    	ControllerMenu.cualPulsa="acabadas";
	    	 Utilidades.mostrarPendiente();
	    }
	    @FXML
	    void mostrarPendientes(ActionEvent event) {
	    	ControllerMenu.cualPulsa="pendientes";
	    	 Utilidades.mostrarPendiente();;
	    }
	    @FXML
	    void mostrarCitas(ActionEvent event) {
	    	 Utilidades.mostrarCita();
	    }
	    

	    
	    
	  

}
