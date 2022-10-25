package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PracticaMain extends Application {
	//private BorderPane rootLayout;	
	private GridPane rootLayout2;
	Image image1 = new Image(getClass(). getResourceAsStream("pngwing.com.png"));

	@Override
	public void start(Stage primaryStage) { //esto es para las ventanas
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			//FXMLLoader loader = new FXMLLoader();
			FXMLLoader loader2 = new FXMLLoader();
			//loader.setLocation(PracticaMain.class.getResource("Menu.fxml"));
			loader2.setLocation(PracticaMain.class.getResource("InicioSesion.fxml"));
			//rootLayout = (BorderPane) loader.load();
			rootLayout2 = (GridPane) loader2.load();
			
			// Pasamos al controlador de menu el objeto con el BorderPane principal
			//ControllerMenu controllerMeu = loader.getController();
			//controllerMeu.setRootLayout(rootLayout);

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout2);
			primaryStage.getIcons().add(image1);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			
			primaryStage.setTitle("Moisés Jiménez PracticaUnidades 1-2");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
