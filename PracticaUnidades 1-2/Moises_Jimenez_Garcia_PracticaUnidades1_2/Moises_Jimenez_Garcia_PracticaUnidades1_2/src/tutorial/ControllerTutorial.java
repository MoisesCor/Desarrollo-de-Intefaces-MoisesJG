package tutorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControllerTutorial {

	
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
		 TreeItem<String> rootItem = new TreeItem<String> ("Datos",rootIcon); // aqu� en el cosntructor le metes la imagen
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
	        lista.getItems().addAll("Recomendar�as la aplicaci�n","Te facilita el trabajo","Funciona siempre bien","Es facil de usar","Te gusta el dise�o");
	        param.addAll("Siempre","Alguna vez","Nunca");
	        lista.setCellFactory(ComboBoxListCell.forListView(param));

	    }
	 
	 
	 //M�todos para hacer el link funcional, obtenido importando la clase desktop
	 
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

}
